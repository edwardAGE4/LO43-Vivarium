package controller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.*;

import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;

import model.Environnement;
import model.Individu;
import model.Item;
import model.Nourriture;
import model.Obstacle;
import view.FenetreJeu;

public class GameManager implements Serializable{

	private static int id = 0;
    private Environnement environnement;
    private ArrayList<Item> items;
    private FenetreJeu frame;

	public GameManager(Environnement e, FenetreJeu frame) {
		this.environnement=e;
		this.items=new ArrayList();
		this.frame=frame;
	}
	
	public FenetreJeu getFrame(){
		return this.frame;
	}

	public void ajouterItem(Item item) {
		this.items.add(item);
	}

	public void supprimerItem(Item item) {
		this.items.remove(item);
	}

	public List<Item> getItems() {
		return this.items;
	}
	
	public List<Obstacle> getObstacles(){
		ArrayList<Obstacle> obstacles=new ArrayList();
		for(Item i:this.items){
			if(i instanceof Obstacle){
				obstacles.add((Obstacle) i);
			}
		}
		return obstacles;
	}
	
	public List<Individu> getIndividus(){
		ArrayList<Individu> individus=new ArrayList();
		for(Item i:this.items){
			if(i instanceof Individu){
				individus.add((Individu) i);
			}
		}
		return individus;
	}
	
	public List<Nourriture> getNourritures(){
		ArrayList<Nourriture> nourritures=new ArrayList();
		for(Item i:this.items){
			if(i instanceof Nourriture){
				nourritures.add((Nourriture) i);
			}
		}
		return nourritures;
	}
	
	/**
	 * màj la position de tous les individus, puis gère les possible collisions => nourrit ou s'écarte
	 */
	public void deplacerIndividus() throws ArrayIndexOutOfBoundsException{
		for(int i=0;i<this.items.size();i++){
			if(this.items.get(i) instanceof Individu){
				((Individu) this.items.get(i)).deplacer(this);
				frame.getPanel().repaint();
			}
		}
	}
	
	/************************/
	
	/*public void update(){ //****************************modif
		//frame.getContentPane().removeAll();
		//System.out.println(this.frame.getContentPane().size());
		for(Item i:this.items){
			//System.out.println(i);
			frame.getContentPane().add(i); // pb n'affiche que le dernier ajouté
			this.frame.setVisible(true);
			this.deplacerIndividus();
			frame.getContentPane().repaint();
			
		}
		
	}*/
	
	public void Initialize(){ //****************************modif
		for(Item i:this.items){
			this.frame.getContentPane().add(i); // pb n'affiche que le dernier ajouté
			this.frame.setVisible(true);
			this.frame.getContentPane().repaint();
						
		}
	}
	
	public void update(){ //****************************modif
			//frame.getContentPane().removeAll();
			//System.out.println(this.frame.getContentPane().size());
			//System.out.println("dans update delete");

			//this.Updating=true;
			//System.out.println("iciii");
			//frame.getContentPane().add(i); // pb n'affiche que le dernier ajouté
			
			this.deplacerIndividus();
			this.frame.getContentPane().repaint();
			//this.frame.getPartie().ajouterPoint();
			this.frame.ecrireScore();			
			
		//this.Updating=false;
		
	}
	
	

}
