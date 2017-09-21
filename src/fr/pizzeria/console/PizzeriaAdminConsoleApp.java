package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Création de la carte à pizza selon un tableau
		Pizza[] pizzas = new Pizza[8];
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza("FRO", "La 4 Fromage", 12.00);
		pizzas[4] = new Pizza("CAN", "La Cannibale", 12.50);
		pizzas[5] = new Pizza("SAV", "La Savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L'Orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L'Indienne", 14.00);
		//Annonce la variable "choix" avant do while sinon erreur
		String choix = "";
		//Boucle do pour revenir au menu à chaque fois, seul moyen d'en sortir est d'écrire 99 (dans condition while), do while pour que la boucle s'effectue au moins une fois
		do {
			System.out.println(
					"\n*****Pizzeria Administration***** \n 1. Lister les pizzas \n 2. Ajouter une nouvelle pizza \n 3. Mettre à jour une pizza \n 4. Supprimer une pizza \n 99. Sortir");
			Scanner question = new Scanner(System.in);
			choix = question.nextLine();
			//Utilisation d'un switch pour eviter le cumul de if else, et pour avoir le default si on écrit autre chose que demandé
			switch (choix) {
			case "1"://Affiche la carte
				for (Pizza i : pizzas) {
					System.out.println(i);
				}

				break;

			case "2"://Demande les informations pour la nouvelle pizza
				System.out.println("Veuillez saisir le code de la pizza");
				String code = question.nextLine();
				System.out.println("Veuillez saisir le nom (sans espace svp) de la pizza");
				String nom = question.nextLine();
				System.out.println("Veuillez saisir le prix de la pizza");
				double prix = question.nextDouble();
				//Création d'un nouveau tableau avec une longueur +1
				Pizza[] newpizzas = new Pizza[pizzas.length + 1];
				//Recopie les valeurs de l'ancien tableau dans le nouveau
				for (int i = 0; i < pizzas.length; i++) {
					newpizzas[i] = pizzas[i];
				}
				//Ajout de la nouvelle pizza puis reviens aligne l'ancien tableau sur le nouveau
				newpizzas[newpizzas.length - 1] = new Pizza(code, nom, prix);
				pizzas = newpizzas;
				break;
			case "3":
				for (Pizza i : pizzas) {
					System.out.println(i);
				}
				System.out.println("\nVeuillez choisir la pizza à modifier \n(99 pour abandonner)");
				code = question.nextLine();
				if (code.equals("99")) {
					break;
				}
				//Cherche la pizza avec le code de référence entré, utilise getCode pour trouver la pizza référencée
				for (Pizza i : pizzas) {
					if (i.getCode().equals(code)) {
						System.out.println("Veuillez saisir le code de la pizza");
						code = question.nextLine();
						System.out.println("Veuillez saisir le nom (sans espace svp) de la pizza");
						nom = question.nextLine();
						System.out.println("Veuillez saisir le prix de la pizza");
						prix = question.nextDouble();
						//Utilise setCode pour modifier la pizza
						i.setCode(code);
						i.setNom(nom);
						i.setPrix(prix);
						System.out.println("\nListe des pizzas modifier");
					}
				}

				break;
			case "4":
				for (Pizza i : pizzas) {
					System.out.println(i);
				}
				System.out.println("\nVeuillez choisir la pizza à supprimer \n(99 pour abandonner)");
				code = question.nextLine();
				if (code.equals("99")) {
					break;
				}
				//Cherche la pizza référencée avec getCode, puis crée un tableau de longueur -1
				for (int i = 0; i < pizzas.length; i++) {
					if (pizzas[i].getCode().equals(code)) {
						Pizza[] jpizzas = new Pizza[pizzas.length - 1];
						for (int j = 0; j < pizzas.length-1; j++) { // L'idée ici est de décaler les pizzas en dessous de la pizza séléctionner de 1 vers le haut du tableau
							if (i > j) { // Pour les pizzas en dessous de la pizza sélectionnée
								jpizzas[j] = pizzas[j];
								jpizzas[j] = pizzas[j];
								jpizzas[j] = pizzas[j];
							} else { // Pour la pizza séléctionnée et les pizzas au dessus
									jpizzas[j] = pizzas[j + 1];
									jpizzas[j] = pizzas[j + 1];
									jpizzas[j] = pizzas[j + 1];
							}

						}
						pizzas = jpizzas;
						
					}
				}

				break;

			case "99":
				System.out.println("Aurevoir \u2639");// Comme écrit sur le TP

				break;

			default:
				System.out.println("Veuillez rentrer une valeur correct");
			}
		} while (!choix.equals("99"));

	}

}
