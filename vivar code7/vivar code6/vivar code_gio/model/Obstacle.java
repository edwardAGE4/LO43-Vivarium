package model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Random;

import view.FenetreJeu;

public class Obstacle extends Item implements Serializable{

	public Obstacle(int x, int y) {
		super(x,y,"images/Obstacles.png",15,15);
	}
	
	public Obstacle(Obstacle Obst_) {
		super(Obst_.getX(),Obst_.getY(),"images/Obstacles.png",15,15);
	}

	public Obstacle(){
		super(
				(new Random()).nextInt(FenetreJeu.getLargeur()*49/100),
				(new Random()).nextInt(FenetreJeu.getHauteur()*46/100),
				"images/Obstacles.png",15,15);
	}

	@Override
	public String toString() {
		return "Obstacle [x=" + x + ", y=" + y + ", hauteur=" + hauteur + ", largeur=" + largeur + "]";
	}

	@Override
	public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(getImage(),this.x,this.y,this.hauteur,this.largeur,this) ;
	         /*   //g2.setPaint(Color.GRAY);
	            g.setColor(Color.GRAY);
	            //g2.draw(new Rectangle.Double(this.x, this.y, this.largeur, this.hauteur));
	            g.fillRect(this.x, this.y, this.largeur, this.hauteur);*/
	}


}
