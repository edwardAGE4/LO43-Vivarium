package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

public class IndividuPrincipal extends Individu implements Serializable{

	public IndividuPrincipal(int x, int y, String image, int dureeVie) {
		super(x, y, image, dureeVie);
	}
	
	@Override
	public void paint(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
        /*  g2.setPaint(Color.BLUE);
          //g2.setBackground(Color.WHITE);
          //g2.draw(new Rectangle.Double(this.x, this.y, this.largeur, this.hauteur));
          g2.fillRect(this.x, this.y, this.largeur, this.hauteur);*/
			g2.drawImage(getImage(),this.x,this.y,this.hauteur,this.largeur,this) ;
        
	}
	
	@Override
	public String toString() {
		return "Principal"+" [x=" + x + ", y=" + y + ", vX=" + vitesseX + ", vY=" + vitesseY + "]";
	}

}
