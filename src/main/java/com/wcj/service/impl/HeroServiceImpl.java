package com.wcj.service.impl;

import java.util.List;

import com.wcj.dao.HeroDao;
import com.wcj.entity.Hero;
import com.wcj.service.HeroService;

public class HeroServiceImpl implements HeroService{

	
	private HeroDao heroDao;
	
	
	public void setHeroDao(HeroDao heroDao) {
		this.heroDao = heroDao;
	}

	public int addHero(Hero hero) {
		return heroDao.addHero(hero);
	}

	public void delHero(Hero hero) {
		heroDao.delHero(hero);
	}

	public void updateHero(Hero hero) {
		// TODO Auto-generated method stub
		heroDao.updateHero(hero);
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

	public List<Hero> findByName(Hero hero) {
		List<Hero> heros=heroDao.findByName(hero);
		return heros;
	}

}
