package fr.pizzeria.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launcher {

	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)){
			PizzeriaAdminConsole menu = context.getBean(PizzeriaAdminConsole.class);
			menu.demarrer();
		}
		
		
	}

}
