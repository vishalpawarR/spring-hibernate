package spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) 
	{
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		
		/*
		 * For 1st method i.e., if we defined the bean id
		 * then we need to use the defined bean id to create the class in getbean() as shown below.
		 */
		
		//Coach theCoach = context.getBean("thatSillyCoach",Coach.class); //Bean id is created by programmer
		
		/*
		 * For 2nd method i.e., Default bean id
		 * In this case we need to use the class name with the first letter as small as bean id the bean id is generated y program it self 
		 */
		
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call the method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
