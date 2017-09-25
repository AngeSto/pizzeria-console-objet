package fr.pizzeria.model;

import java.util.Scanner;

public class Pizza {

Integer id;
String code;
String nom;
double prix;
CategoriePizza categorie;

public static Scanner question = new Scanner(System.in);

public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
	super();
	this.code = code;
	this.nom = nom;
	this.prix = prix;
	this.categorie = categorie;
}

@Override
public String toString() {
	return code+" -> "+nom+" ("+prix+"€) "+categorie;
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

/**
 * @return the categorie
 */
public CategoriePizza getCategorie() {
	return categorie;
}

/**
 * @param categorie the categorie to set
 */
public void setCategorie(CategoriePizza categorie) {
	this.categorie = categorie;
}



}
