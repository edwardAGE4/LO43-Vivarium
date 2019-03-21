package model;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import controller.GameManager;
import view.FenetreJeu;

public class Individu extends Item implements Serializable{

	protected int dureeVie;
	protected int vitesseX;
	protected int vitesseY;
	protected long apparition;

	public Individu(int x, int y, String image, int dureeVie) {
		super(x,y,image,26,30);
		this.dureeVie=dureeVie;
		Random rand=new Random();
	    this.vitesseX = rand.nextInt(2) + 1; 
		this.vitesseY = rand.nextInt(2) + 1;
		this.apparition=System.currentTimeMillis();
	}
	
	/*public Individu(int x, int y, String image, String nom, int dureeVie, boolean principal) {
		super(x,y,image,20,20);
		this.nom=nom;
		this.dureeVie=dureeVie;
		Random rand=new Random();
	    this.vitesseX = rand.nextInt(2) + 1; 
		this.vitesseY = rand.nextInt(2) + 1;
		this.estPrincipal=true;
	}*/
	
	public int getVitesseX() {
		return this.vitesseX;
	}
	
	public int getVitesseY() {
		return this.vitesseY;
	}
	
	public void setVitesseX(int vX){
		this.vitesseX=vX;
	}
	
	public void setVitesseY(int vY){
		this.vitesseY=vY;
	}
	
	public void deplacer(GameManager vivarium) {
		if(this.getDureeVieRestante()<=0){
			this.vitesseX=0;
			this.vitesseY=0;
			vivarium.supprimerItem(this);
			vivarium.getFrame().remove(this);
		}
		this.siToucheBord();
		this.x+=vitesseX;
		this.y+=vitesseY;
		
		ArrayList<Item> itemsCopy=new ArrayList<>();
		for(Item i:vivarium.getItems()){
			if(i != this)
			itemsCopy.add(i);
		}
		for(Item i:itemsCopy){
			if(i instanceof Obstacle || i instanceof Individu){
				if(this.collisionAvec(i)){
					Random rand=new Random();
					int alt = rand.nextInt(2);
					if (alt == 0) this.vitesseX=(-1)*this.vitesseX;
					else if (alt == 1) this.vitesseY=(-1)*this.vitesseY;
					/*else if (alt ==2 ) {
						this.vitesseX=(-1)*this.vitesseX;
						this.vitesseY=(-1)*this.vitesseY;
					}*/
				}
			}
			else if(i instanceof Nourriture){
				//Nourriture n=(Nourriture) i;
				if(this.collisionAvec(i)){
					vivarium.getItems().remove(i);
					vivarium.getFrame().remove(i);
					this.dureeVie+=((Nourriture) i).getValeurNutri();
				}
			}
		}
		
	}

	/*public void deplacer(GameManager vivarium) {
		this.siToucheBord();
		if(this.dureeVie!=0){
			this.x+=vitesseX;
			this.y+=vitesseY;
		}
		else{
			this.vitesseX=0;
			this.vitesseY=0;
		}
		
		for(Individu i:vivarium.getIndividus()){
			if(this.collisionAvec(i)){
				this.vitesseX=-this.vitesseX;
				this.vitesseY=-this.vitesseY;
			}
		}
		/*for(Obstacle o:vivarium.getObstacles()){
			if(this.collisionAvec(o)){
				this.vitesseX=-this.vitesseX;
				this.vitesseY=-this.vitesseY;
			}
		}
		*/
		/*for(Nourriture n:vivarium.getNourritures()){
			if(this.collisionAvec(n)){
				vivarium.supprimerItem(n);
				this.dureeVie+=n.getValeurNutri();
			}
		}*/
		
		//System.out.println(this);
	//}
	
	public void siToucheBord(){
		if(this.x<=0 && this.y>0 && this.x+this.largeur<FenetreJeu.getLargeur()*51/100 && this.y+this.hauteur<FenetreJeu.getHauteur()*49/100){
			this.vitesseX=-this.vitesseX;
		}
		else if(this.x>0 && this.y<=0 && this.x+this.largeur<FenetreJeu.getLargeur()*51/100 && this.y+this.hauteur<FenetreJeu.getHauteur()*49/100){
			this.vitesseY=-this.vitesseY;
		}
		else if(this.x>0 && this.y>0 && this.x+this.largeur>=FenetreJeu.getLargeur()*51/100 && this.y+this.hauteur<FenetreJeu.getHauteur()*49/100){
			this.vitesseX=-this.vitesseX;
		}
		else if(this.x>0 && this.y>0 && this.x+this.largeur<FenetreJeu.getLargeur()*51/100 && this.y+this.hauteur>=FenetreJeu.getHauteur()*49/100){
			this.vitesseY=-this.vitesseY;
		}
		
		else if(this.x<0 && this.y<0){
			this.vitesseX=-this.vitesseX;
			this.vitesseY=-this.vitesseY;
		}
		else if(this.x+this.largeur>FenetreJeu.getLargeur()*51/100 && this.y+this.hauteur>FenetreJeu.getHauteur()*49/100){
			this.vitesseX=-this.vitesseX;
			this.vitesseY=-this.vitesseY;
		}
		
		else if(this.x<0 && this.y+this.hauteur>FenetreJeu.getHauteur()*49/100){
			this.vitesseX=-this.vitesseX;
			this.vitesseY=-this.vitesseY;
		}
		else if(this.y<0 && this.x+this.largeur>FenetreJeu.getLargeur()*51/100){
			this.vitesseX=-this.vitesseX;
			this.vitesseY=-this.vitesseY;
		}
		
	}
	
	public void siToucheBord(GameManager gm){
		if(this.x<=0 && this.y>0 && this.x+this.largeur<gm.getFrame().getWidth()*51/100 && this.y+this.hauteur<gm.getFrame().getHeight()*48/100){
			this.vitesseX=-this.vitesseX;
		}
		else if(this.x>0 && this.y<=0 && this.x+this.largeur<gm.getFrame().getWidth()*51/100 && this.y+this.hauteur<gm.getFrame().getHeight()*48/100){
			this.vitesseY=-this.vitesseY;
		}
		else if(this.x>0 && this.y>0 && this.x+this.largeur>=gm.getFrame().getWidth()*51/100 && this.y+this.hauteur<gm.getFrame().getHeight()*48/100){
			this.vitesseX=-this.vitesseX;
		}
		else if(this.x>0 && this.y>0 && this.x+this.largeur<gm.getFrame().getWidth()*51/100 && this.y+this.hauteur>=gm.getFrame().getHeight()*48/100){
			this.vitesseY=-this.vitesseY;
		}
		
		else if(this.x<0 && this.y<0){
			this.vitesseX=-this.vitesseX;
			this.vitesseY=-this.vitesseY;
		}
		else if(this.x+this.largeur>FenetreJeu.getLargeur()*51/100 && this.y+this.hauteur>gm.getFrame().getHeight()*48/100){
			this.vitesseX=-this.vitesseX;
			this.vitesseY=-this.vitesseY;
		}
		
		else if(this.x<0 && this.y+this.hauteur>gm.getFrame().getHeight()*48/100){
			this.vitesseX=-this.vitesseX;
			this.vitesseY=-this.vitesseY;
		}
		else if(this.y<0 && this.x+this.largeur>gm.getFrame().getWidth()*51/100){
			this.vitesseX=-this.vitesseX;
			this.vitesseY=-this.vitesseY;
		}
		
	}

	public void manger(Nourriture aliment) {
		this.dureeVie+=aliment.getValeurNutri();
	}

	@Override
	public String toString() {
		return "Autre individu"+" [x=" + x + ", y=" + y + ", vX=" + vitesseX + ", vY=" + vitesseY + "]";
	}
	
	public boolean collisionAvec(Item obj){
		return obj.x < this.x + this.largeur &&
			       obj.x + obj.largeur > this.x &&
			       obj.y < this.y + this.hauteur &&
			       obj.hauteur + obj.y > this.y;
		 
	}
	
	public int getDureeVie(){
		return this.dureeVie;
	}
	
	public long getDureeVieRestante(){
		return ((this.dureeVie*1000+this.apparition)-(System.currentTimeMillis()))/1000;
	}
	
	/*****************************/
	
	@Override
	public void paint(Graphics g){
        	Graphics2D g2 = (Graphics2D) g;
        	g2.drawImage(getImage(),this.x,this.y,this.hauteur,this.largeur,this) ;
            
		
        
	}

}
