package com.wcj.dao.impl;

import java.sql.SQLException;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.wcj.dao.HeroDao;
import com.wcj.entity.Hero;
//要继承hibernate3包中的HibernateDaoSupport类
//类中有hibernateTemplate模板类对象属性,可以插入到每一个dao类中
//就不用再手动处理事务以及session了，均通过前置后置通知做了

@Repository
public class HeroDaoImpl extends MyHibernateSipport implements HeroDao {

	public int addHero(Hero hero) {
		Integer count=(Integer) this.getHibernateTemplate().save(hero);
		return count;
	}

	public void delHero(int id) {
		Hero hero = this.getHibernateTemplate().load(Hero.class, id);
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

	
	public void delById(Hero hero) {
		List<Hero> heros=(List<Hero>) this.getHibernateTemplate().find("from Hero where id=?", hero.getId());
		this.getHibernateTemplate().delete(hero);
	}

	public Hero findById(int id) {
		Hero hero = this.getHibernateTemplate().load(Hero.class, id);
		return hero;
	}
	

}
