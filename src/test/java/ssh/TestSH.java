package ssh;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wcj.entity.Hero;
import com.wcj.service.HeroService;

import junit.framework.TestCase;

public class TestSH extends TestCase{
	
	//����spring + Hibernate
	public void testSHfind(){
		//���������⣺��ζ�ȡ���������ļ�?
		//��������
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
	    hero.setName("����");
	   
	    Integer i=heroService.addHero(hero);//���ص���idֵ
	    System.out.println(i);
	}
	public void testSHdel(){
		String p[]={"spring-common.xml","spring-beans.xml"};
		ApplicationContext context=new ClassPathXmlApplicationContext(p);
	    HeroService heroService=(HeroService) context.getBean("heroService");
	    Hero hero=new Hero();
	    hero.setId(133);
	    //hero.setName("����");
	    heroService.delHero(hero);//���ص���idֵ
	}
	
	public void testSHupdate(){
		String p[]={"spring-common.xml","spring-beans.xml"};
		ApplicationContext context=new ClassPathXmlApplicationContext(p);
	    HeroService heroService=(HeroService) context.getBean("heroService");
	    Hero hero=new Hero();
	    hero.setId(131);

	    hero.setName("����");
	   
	    heroService.updateHero(hero);;//���ص���idֵ
	}
	
	//���Է�ҳ��ʹ��ԭ��session-***********��dao�����
	public void testSHgetPage(){
		String p[]={"spring-common.xml","spring-beans.xml"};
		ApplicationContext context=new ClassPathXmlApplicationContext(p);
	    HeroService heroService=(HeroService) context.getBean("heroService");
	    List<Hero> heros=heroService.getPage(1, 3);
	    System.out.println(heros);
	}
	//���Բ�ѯ��¼��������ʹ��ԭ��session-***********��dao�����
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
	    hero.setName("����");
	    List<Hero> heros=heroService.findByName(hero);
	    System.out.println(heros);
	}
}
