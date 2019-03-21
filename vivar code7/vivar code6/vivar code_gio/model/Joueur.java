package model;

import java.io.Serializable;

public class Joueur implements Serializable{
	private static int id=0;
	
	private String nom;
	private int identifiant;
	private Individu principal;
	
	public Joueur(String nom, Individu principal){
		this.nom=nom;
		this.identifiant=Joueur.id;
		Joueur.id++;
		this.principal=principal;
	}
	
	public String getNom(){
		return this.nom;
	}
}
