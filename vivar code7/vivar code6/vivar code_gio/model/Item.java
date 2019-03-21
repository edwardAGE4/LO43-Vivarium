package model;

import java.awt.geom.Ellipse2D;
import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.lang.String;

import javax.swing.*;


public abstract class Item extends JPanel implements Serializable{
	
	
	protected static int id = 0;
	protected int x;
	protected int y;
	protected String imagePath;
	protected Image image;
	protected int identifiant;
	protected int hauteur;
	protected int largeur;
	protected Rectangle carre;
	protected Cote haut;
	protected Cote bas;
	protected Cote gauche;
	protected Cote droit;
	
	

	//	FORME
	public Item(int x, int y, String adresseImage, int hauteur, int largeur) {
		this.x=x;
		this.y=y;
		this.imagePath=adresseImage;
		ImageIcon ii = new ImageIcon(imagePath);
		image = ii.getImage();  
		this.identifiant=id;
		Item.id++;
		this.hauteur=hauteur;
		this.largeur=largeur;
		this.carre=new Rectangle(x, x, largeur, hauteur);
	}
	
	public Image getImage() {
        return this.image;
    }

	public int getIdentifiant() {
		// TODO Auto-generated method stub
		return this.identifiant;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	/********************************/
	/* extends JComponet
	public void createComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		g2.draw(this.carre);
	}*/
	

    //abstract public void paint(Graphics g);
	
	public int getHauteur(){
		return this.hauteur;
	}
	
	public int getLargeur(){
		return this.largeur;
	}
}

class Cote{
	private Point p1;
	private Point p2;
	
	public Cote(Point p1, Point p2){
		this.p1=p1;
		this.p2=p2;
	}
	
	public boolean sontColles(Cote c){
		return (c.p1.getX()>this.p1.getX() && c.p1.getX()<this.p2.getX()) || (c.p2.getX()>this.p1.getX() && c.p2.getX()<this.p2.getX()) ||
			   (c.p1.getY()>this.p1.getY() && c.p1.getY()<this.p2.getY()) || (c.p2.getY()>this.p1.getY() && c.p2.getY()<this.p2.getY());
	}
}
