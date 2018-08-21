package com.wcj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcj.dao.HeroDao;
import com.wcj.entity.Hero;
import com.wcj.service.HeroService;

@Service("heroService")
public class HeroServiceImpl implements HeroService{

	@Autowired
	private HeroDao heroDao;
	
	
	public void setHeroDao(HeroDao heroDao) {
		this.heroDao = heroDao;
	}

	public int addHero(Hero hero) {
		return heroDao.addHero(hero);
	}

	public void delHero(int id) {
		heroDao.delHero(id);
//		heroDao.delById(hero);
	}

	public void updateHero(Hero hero) {
		
		Hero oldHero = heroDao.findById(hero.getId());
		System.out.println(oldHero);
		if(hero.getName() != null && !"".equals(hero.getName())){
			oldHero.setName(hero.getName());
		}
		if(hero.getNickname() != null && !"".equals(hero.getNickname())){
			oldHero.setNickname(hero.getNickname());
		}
		if(hero.getFirst() != null && !"".equals(hero.getFirst())){
			oldHero.setFirst(hero.getFirst());
		}
		if(hero.getSecond() != null && !"".equals(hero.getSecond())){
			oldHero.setSecond(hero.getSecond());
		}
		if(hero.getPassivity() != null && !"".equals(hero.getPassivity())){
			oldHero.setPassivity(hero.getPassivity());
		}
		heroDao.updateHero(oldHero);
		System.out.println(oldHero);
	}

	public List<Hero> findHero() {
		return heroDao.findHero();
	}

	public List<Hero> getPage(int page, int size) {
		// TODO Auto-generated method stub
		List<Hero> heros=heroDao.getPage(page, size);
		return heros;
	}

	public long getCount() {
		long count=heroDao.getCount();
		return count;
	}

	public Hero findById(int id) {
		Hero hero = heroDao.findById(id);
		return hero;
	}
	

}
