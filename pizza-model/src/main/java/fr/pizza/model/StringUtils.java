package fr.pizza.model;

import java.lang.reflect.Field;

public class StringUtils {
	
	private StringUtils(){
		
	}

	public static String concat(Object... chaines) {
		StringBuilder builder = new StringBuilder();
		for (Object chaine : chaines) {
			builder.append(chaine);
		}

		return builder.toString();
	}

	public static String convert(Object o){
		StringBuilder builder = new StringBuilder();
		Class<?> classe = o.getClass();
		for (Field field : classe.getDeclaredFields()) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(ToString.class)) {
				try {
					if (field.getAnnotation(ToString.class).upperCase()) {

						builder.append(StringUtils.concat(field.get(o), " -> ").toUpperCase());

					} else {
						if (field.getAnnotation(ToString.class).euro()) {

							builder.append(StringUtils.concat("(", field.get(o), "€) "));

						} else {
							builder.append(StringUtils.concat(field.get(o), " "));
						}
					}

				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.getMessage();
				}
			}
		}
		return builder.toString();		
		

	}
}
