package com.wcj.service;

import java.util.List;

import com.wcj.entity.Hero;

public interface HeroService {
	public int addHero(Hero hero);
	public void delHero(int id);
	public void updateHero(Hero hero);
	public List<Hero> findHero();
	public List<Hero>  getPage(int page,int size);
	public long getCount();
	public Hero findById(int id);

}
