package com.wcj.dao;

import java.util.List;

import com.wcj.entity.Hero;

public interface HeroDao {
	public int addHero(Hero hero);
	public void delHero(int id);
	public void updateHero(Hero hero);
	public List<Hero> findHero();
	public List getPage(int page,int size);
	public long getCount();
	public Hero findById(int id);
	public void delById(Hero hero);
}
