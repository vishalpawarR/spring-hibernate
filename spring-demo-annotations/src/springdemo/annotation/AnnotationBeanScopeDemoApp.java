package springdemo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		//Load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from string container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		
		//check if they are same
		boolean result = (theCoach == alphaCoach);
		
		//print out the results
		System.out.println("Pointing to the same Object: "+result);
		
		System.out.println("Memory location for theCoach: "+ theCoach);
		
		System.out.println("Memory location for alphaCoach: "+ alphaCoach);

		//close the context object
		context.close();
	}

}
