package com.wcj.dao.impl;

import java.sql.SQLException;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wcj.dao.HeroDao;
import com.wcj.entity.Hero;
//要继承hibernate3包中的HibernateDaoSupport类
//类中有hibernateTemplate模板类对象属性,可以插入到每一个dao类中
//就不用再手动处理事务以及session了，均通过前置后置通知做了

public class HeroDaoImpl extends HibernateDaoSupport implements HeroDao {

	public int addHero(Hero hero) {
		Integer count=(Integer) this.getHibernateTemplate().save(hero);
		return count;
	}

	public void delHero(Hero hero) {
		this.getHibernateTemplate().delete(hero);
	}

	public void updateHero(Hero hero) {
		this.getHibernateTemplate().update(hero);
	
	}

	public List<Hero> findHero() {
		//获取代理类对象进行查询
		List<Hero> heros=(List<Hero>) this.getHibernateTemplate().find("from Hero");
		
		return heros;
	}
	
	//得到原生session，并进行分页
	public List getPage(final int page,final int size){
		//得到session
		List list=(List)this.getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query q=session.createQuery("from Hero");
				q.setFirstResult((page-1)*size);
				q.setMaxResults(size);
				return q.list();
			}
		});
		return list;
		
	}

	public long getCount() {
		// TODO Auto-generated method stub
		long count=this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query q=session.createQuery("select count(*) from Hero");
				Long co=(Long) q.uniqueResult();
				return co;
			}
		});
		return count;
	}

	public List<Hero> findByName(Hero hero) {
		List<Hero> heros=(List<Hero>) this.getHibernateTemplate().find("from Hero where name=?", hero.getName());
		
		return heros;
	}
	

}
