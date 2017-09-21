package fr.pizzeria.model;

import java.util.Scanner;

public class Pizza {

Integer id;
String code;
String nom;
double prix;

public static Scanner question = new Scanner(System.in);

public Pizza(String code, String nom, double prix) {
	super();
	this.code = code;
	this.nom = nom;
	this.prix = prix;
}

@Override
public String toString() {
	return code+" -> "+nom+" ("+prix+"€)" ;
}

/**
 * @return the code
 */
public String getCode() {
	return code;
}

/**
 * @param code the code to set
 */
public void setCode(String code) {
	this.code = code;
}

/**
 * @return the nom
 */
public String getNom() {
	return nom;
}

/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}

/**
 * @return the prix
 */
public double getPrix() {
	return prix;
}

/**
 * @param prix the prix to set
 */
public void setPrix(double prix) {
	this.prix = prix;
}

}
