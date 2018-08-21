package com.wcj.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wcj.entity.Hero;
import com.wcj.service.HeroService;

@Controller
public class HeroAction extends ActionSupport {
	@Autowired
	HeroService heroService;
	
	Integer page;
	int id;
	int maxPage;
	Hero hero;


	public Hero getHero() {
		return hero;
	}


	public void setHero(Hero hero) {
		this.hero = hero;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public HeroService getHeroService() {
		return heroService;
	}

	public void setHeroService(HeroService heroService) {
		this.heroService = heroService;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		if(page == null || page < 1){
			page = 1;
		}
		if(page > ((heroService.getCount())/10)+1){
			page = ((int)(heroService.getCount())/10)+1;
		}

		List<Hero> list = heroService.getPage(page, 10);
		Map request = (Map)ActionContext.getContext().get("request");//	存放在 作用域
		request.put("heroList", list);
		this.maxPage = (((int)heroService.getCount())/10)+1;//存放在值栈中       两种都可以用 EL标签取得
		return SUCCESS;
	}
	
	public String del() throws Exception {
		 System.out.println(id);
	    heroService.delHero(id);
	   
	    System.out.println("已经删除");
		return SUCCESS;
	}
	
	public String modify(){
		heroService.updateHero(hero);
		return SUCCESS;
	}
	
	public String add(){
		Hero newHero = new Hero();
		newHero.setId(hero.getId());
		newHero.setName(hero.getName());
		newHero.setNickname(hero.getNickname());
		newHero.setFirst(hero.getFirst());
		newHero.setSecond(hero.getSecond());
		newHero.setPassivity(hero.getPassivity());
		heroService.addHero(newHero);
		return SUCCESS;
	}
	

}
