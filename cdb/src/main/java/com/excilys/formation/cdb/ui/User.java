package com.excilys.formation.cdb.ui;

import java.util.Scanner;

import com.excilys.formation.cdb.service.ComputerService;

public class User {
	ComputerService s= new ComputerService();
	Scanner sc = new Scanner(System.in);

	public void affichage() {
		System.out.println("Que voulez vous faire? ");
		System.out.println("0 - Liste des ordinateurs");
		System.out.println("1 - Liste des entreprises");
		System.out.println("2 - Détails d'un ordinateur");
		System.out.println("3 - Création d'un ordinateur");
		System.out.println("4 - Mise à jour d'un ordinateur");
		System.out.println("5 - Suppression d'un ordinateur");
		System.out.println("6 - Quitter ");
		;

		selectswitch();

	}

	public void transitordis() {
		System.out.println("Veuillez entrer l'id de l'ordinateur souhaité : ");
		try {
			int answer;
			answer=sc.nextInt();
			detailordis(answer);
		} catch (final Exception e) { System.out.println("Veuillez entrer un entier");}
	}

	public void detailordis(final int id)  {
		System.out.println(s.afficheListeComputerByID(id));
	}

	/*public void nomordi() {
		System.out.println("Veuillez entrer le nom du nouvel ordinateur : ");
		try {
		String answer;
		answer=sc.nextLine();
		createordi(answer); } catch (Exception e) { System.out.println("Un string est attendu ici");}
	}*/

	/*public void createordi(String nomordi) {
		s.insertcomputer(nomordi);
	}*/

	public void deleteComputer() {
		System.out.println("Veuillez entrer l'id de l'ordinateur à supprimer : ");
		try {
			final int answer = sc.nextInt();
			s.deleteByID(answer); } 
		catch (final Exception e) {System.out.println("un entier est attendu ici !");}
	}



	/*public void majOrdi () {
		System.out.println("Veuillez entrer l'id de l'ordinateur à update : ");
		int answer;
		answer=sc.nextInt();
		System.out.println("Veuillez entrer le nouveau nom de l'ordinateur : ");
		try {
		String updatenameordi = sc.nextLine();
		s.updateName(answer,updatenameordi ); } catch (Exception e ) {System.out.println("Identifiant ou nom mal renseigné");}
		System.out.println("Veuillez entrer la nouvelle date de sortie :  elle doit être au format YYYY-MM-DD");
		try {
		String updatedatesortie = sc.nextLine();
		s.updateDateSortie(answer, updatedatesortie);
		} catch (Exception e ) {System.out.println("Identifiant ou date mal renseigné");}
		System.out.println("Veuillez entrer la nouvelle date de fin : elle doit être au format YYYY-MM-DD");
		try {
		String updatedatefin = sc.nextLine(); 
		s.updateDateFIn(answer,updatedatefin ); } 
		catch (Exception e ) {System.out.println("Identifiant ou date mal renseigné");}
		System.out.println("Veuillez entrer l'id du nouveau fabricant");
		try {
		int idcompanieupdate = sc.nextInt();
		s.updateFabricant(answer, idcompanieupdate); } catch (Exception e ) {System.out.println("Identifiant ou id fabricant mal renseigné");}

	}*/

	public void select_pc(String answer,int pc,final int pas) {
		switch(answer) {
		case("+") :
			pc = pc+9;
		//System.out.println(s.afficheListeComputer(pc+9,10));
		System.out.println("\n Appuyez sur + pour afficher les pc suivants, - pour les précédents");
		answer = sc.nextLine();
		select_pc(answer,pc,pas);

		case("-") :
			pc = pc-9;
		//System.out.println(s.afficheListeComputer(pc-9,10));
		System.out.println("\n Appuyez sur + pour afficher les pc suivants, - pour les précédents");
		answer = sc.nextLine();
		select_pc(answer,pc,pas);

		default:
			System.out.println("je ne comprends pas désolé");
		}
	}



	public void selectswitch() {
		Boolean stop=true;
		String answer;
		answer=sc.nextLine();
		while (stop) {
			switch(answer) {
			case ("0"):
				System.out.println("Liste des ordinateurs :");
			final int pc = 0;
			final int pas = 9;
			//System.out.println(s.afficheListeComputer(pc,10));
			System.out.println("\n Appuyez sur + pour afficher les pc suivants, - pour les précédents");
			answer = sc.nextLine();
			select_pc(answer,pc,pas);
			stop = false;
			break;

			case ("1"):
				System.out.println("Liste des entreprises :");
			System.out.println(s.afficheListeCompanie());
			stop = false;
			break;

			case ("2"):
				System.out.println("Détails d'un ordinateur :");
			transitordis();
			stop = false;
			break;

			case ("3"):
				System.out.println(" Création ordinateur :");
			//nomordi();
			stop = false;
			break;

			case ("4"):
				System.out.println(" Mise à jour d'un ordinateur :");
			//majOrdi();
			stop = false;
			break;

			case ("5"):
				System.out.println("Supprimer un ordinateur :");
			deleteComputer();
			stop = false;
			break;

			case ("6"):
				System.out.println("Au revoir !");
			stop=false;
			break;
			default:
				System.out.println("Désolé je n'ai pas compris.");
				break;
			}

		}
	}
}