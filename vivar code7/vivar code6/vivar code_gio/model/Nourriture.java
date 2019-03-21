package model;
import java.awt.*;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Nourriture extends Item implements Serializable{

	private int valeurNutri;

	public Nourriture(int x, int y, int valeurNutri, String image) {
		super(x,y,"images/Nourriture.png",26,30);
		this.valeurNutri=valeurNutri;
	}
	
	public int getValeurNutri(){
		return this.valeurNutri;
	}
	
	@Override
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
    	g2.drawImage(getImage(),this.x,this.y,this.hauteur,this.largeur,this) ;
     /*   g2.setPaint(Color.YELLOW);
        //g2.draw(new Rectangle.Double(this.x, this.y, this.largeur, this.hauteur));
        g2.fillRect(this.x, this.y, this.largeur, this.hauteur);*/
        
	}

}
