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
//Ҫ�̳�hibernate3���е�HibernateDaoSupport��
//������hibernateTemplateģ�����������,���Բ��뵽ÿһ��dao����
//�Ͳ������ֶ����������Լ�session�ˣ���ͨ��ǰ�ú���֪ͨ����

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

	
	public void delById(Hero hero) {
		List<Hero> heros=(List<Hero>) this.getHibernateTemplate().find("from Hero where id=?", hero.getId());
		this.getHibernateTemplate().delete(hero);
	}

	public Hero findById(int id) {
		Hero hero = this.getHibernateTemplate().load(Hero.class, id);
		return hero;
	}
	

}
