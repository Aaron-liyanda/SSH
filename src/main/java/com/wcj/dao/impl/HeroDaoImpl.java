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
//Ҫ�̳�hibernate3���е�HibernateDaoSupport��
//������hibernateTemplateģ�����������,���Բ��뵽ÿһ��dao����
//�Ͳ������ֶ����������Լ�session�ˣ���ͨ��ǰ�ú���֪ͨ����

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
		//��ȡ�����������в�ѯ
		List<Hero> heros=(List<Hero>) this.getHibernateTemplate().find("from Hero");
		
		return heros;
	}
	
	//�õ�ԭ��session�������з�ҳ
	public List getPage(final int page,final int size){
		//�õ�session
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
