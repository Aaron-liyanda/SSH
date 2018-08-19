package ssh;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wcj.entity.Hero;
import com.wcj.service.HeroService;

import junit.framework.TestCase;

public class TestSH extends TestCase{
	
	//测试spring + Hibernate
	public void testSHfind(){
		//遇到的问题：如何读取两个配置文件?
		//用数组解决
		String p[]={"spring-common.xml","spring-beans.xml"};
		ApplicationContext context=new ClassPathXmlApplicationContext(p);
	    HeroService heroService=(HeroService) context.getBean("heroService");
	    List<Hero> heros = heroService.findHero();
	    for (Hero hero : heros) {
			System.out.println(hero);
		}
	    System.out.println(heros);
	}
	public void testSHadd(){
		String p[]={"spring-common.xml","spring-beans.xml"};
		ApplicationContext context=new ClassPathXmlApplicationContext(p);
	    HeroService heroService=(HeroService) context.getBean("heroService");
	    Hero hero=new Hero();
	    hero.setName("码云");
	   
	    Integer i=heroService.addHero(hero);//返回的是id值
	    System.out.println(i);
	}
	public void testSHdel(){
		String p[]={"spring-common.xml","spring-beans.xml"};
		ApplicationContext context=new ClassPathXmlApplicationContext(p);
	    HeroService heroService=(HeroService) context.getBean("heroService");
	    Hero hero=new Hero();
	    hero.setId(133);
	    //hero.setName("码云");
	    heroService.delHero(hero);//返回的是id值
	}
	
	public void testSHupdate(){
		String p[]={"spring-common.xml","spring-beans.xml"};
		ApplicationContext context=new ClassPathXmlApplicationContext(p);
	    HeroService heroService=(HeroService) context.getBean("heroService");
	    Hero hero=new Hero();
	    hero.setId(131);

	    hero.setName("妈妈");
	   
	    heroService.updateHero(hero);;//返回的是id值
	}
	
	//测试分页，使用原生session-***********看dao层代码
	public void testSHgetPage(){
		String p[]={"spring-common.xml","spring-beans.xml"};
		ApplicationContext context=new ClassPathXmlApplicationContext(p);
	    HeroService heroService=(HeroService) context.getBean("heroService");
	    List<Hero> heros=heroService.getPage(1, 3);
	    System.out.println(heros);
	}
	//测试查询记录总条数，使用原生session-***********看dao层代码
	public void testSHgetCount(){
		String p[]={"spring-common.xml","spring-beans.xml"};
		ApplicationContext context=new ClassPathXmlApplicationContext(p);
	    HeroService heroService=(HeroService) context.getBean("heroService");
	    Long count =heroService.getCount();
	    System.out.println(count);
	}
	public void testSHgetListByName(){
		String p[]={"spring-common.xml","spring-beans.xml"};
		ApplicationContext context=new ClassPathXmlApplicationContext(p);
	    HeroService heroService=(HeroService) context.getBean("heroService");
	    Hero hero=new Hero();
	    hero.setName("妈妈");
	    List<Hero> heros=heroService.findByName(hero);
	    System.out.println(heros);
	}
}
