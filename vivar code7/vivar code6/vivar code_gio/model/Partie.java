package model;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import controller.GameManager;
import view.FenetreJeu;
import view.GameFrame;

/*
 * Affichera la fenêtre à l'appel du main
 */
public class Partie extends Thread implements Serializable{

	private GameManager vivarium;
    private Individu principal;
    private Joueur joueur;
    private int point;
    private boolean pause;

	public Partie(Individu principal, Joueur joueur, Environnement e) {
		this.principal=principal;
		this.joueur=joueur;
		this.vivarium=new GameManager(e, new FenetreJeu("Vivarium "+joueur.getNom(),this));
		
		this.point=0;
	}
	
	public String afficheScore(){
		return "Durée de vie : "+this.principal.getDureeVieRestante();
	}
	
	public void pause(){
		this.pause=true;
		for(Individu i:this.vivarium.getIndividus()) {
			i.dureeVie = (int) i.getDureeVieRestante();
		}
		this.suspend();
	}
	
	public void reprendre(){
		this.pause=false;
		for(Individu i:this.vivarium.getIndividus()) {
			i.apparition = System.currentTimeMillis();
		}
		this.resume();
	}

	public void enregistrer() {
		try {
			FileOutputStream fos = new FileOutputStream("partie"+joueur.getNom()+".ser");
			BufferedReader br = new BufferedReader(new FileReader("partie"+joueur.getNom()+".ser"));

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ajouterPoint(){
		this.point++;
	}
	
	public void enleverPoint(){
		this.point--;
	}
	
	public static Partie lireEnregistement(String joueur) {
		Partie res = null;
		try {
			FileInputStream fis = new FileInputStream("partie"+joueur+".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			res = (Partie) ois.readObject();

			ois.close();
		} catch (Exception e) {
			System.out.println("File is empty");
		}
		return res;
	}

	public void ajouterObstacle(int nombre) {
		for(int i=0;i<nombre;i++){
			this.vivarium.ajouterItem(new Obstacle());
		}
		this.vivarium.Initialize();
	}
	
	public void ajouterIndividus(int nombre, int duree) {
		Random rand=new Random();
		for(int i=0;i<nombre;i++){
			this.vivarium.ajouterItem(new Individu(rand.nextInt(FenetreJeu.getLargeur()/4),rand.nextInt(FenetreJeu.getLargeur()/4),"images/Enemy.png",duree));
		}
		this.vivarium.Initialize();
	}
	//gio modif
	public void ajouterNourriture_(Nourriture food_) {
		this.vivarium.ajouterItem(food_);
		this.vivarium.Initialize();
	}
	
	public void ajouterObstacle_() {
		this.vivarium.ajouterItem(new Obstacle());
		this.vivarium.Initialize();
	}
	
	public void ajouterObstacleParametre_(Obstacle Obst_) {
		this.vivarium.ajouterItem(new Obstacle(Obst_));
		this.vivarium.Initialize();
	}
	
	public void ajouterIndividu_() {
		Random rand=new Random();
		this.vivarium.ajouterItem(new Individu(rand.nextInt(FenetreJeu.getLargeur()/2),rand.nextInt(FenetreJeu.getHauteur()/2),"images/Enemy.png",100));
		this.vivarium.Initialize();
	}
	//fin modif
	/**
	 * Supprime un obstacle quelconque (premier obstacle de la liste items par exemple
	 */
	public void supprimerObstacle() {
		ArrayList<Obstacle> obstacles=new ArrayList();
		for(Item i:this.vivarium.getItems()){
			if(i instanceof Obstacle){
				obstacles.add((Obstacle) i);
			}
		}
		if(obstacles.size()!=0)
			this.vivarium.supprimerItem(obstacles.get(0));
	}
	
	public void supprimerItemParametre(int x_, int y_) {
		for(Item i:this.vivarium.getItems()){
			if(i.x <=x_ && x_<=i.x+i.largeur && i.y<y_ && y_ <i.y+i.hauteur && i!= this.principal) {
				this.vivarium.supprimerItem(i);
				this.vivarium.getFrame().remove(i);
			}
		}
	}

	public GameManager getVivarium() {
		return this.vivarium;
	}
	
	public void run(){
		while(!this.pause){
			if(this.principal.getDureeVieRestante()<0){
				this.vivarium.getFrame().setVisible(false);
				int option = javax.swing.JOptionPane.showConfirmDialog(null, "Vous avez perdu. Voulez vous recommencer avec un niveau moyen ?", "Confirmation to leave", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.OK_OPTION)
				{	
					Individu princ=new IndividuPrincipal(10,10,"images/chien.png",50);
					Partie p=new Partie(princ,this.joueur,null);
					p.getVivarium().ajouterItem(princ);		
					p.ajouterIndividus(10,80);
					p.ajouterObstacle(10);
					p.reprendre();
					p.start();
				}
				else {
				new GameFrame("VIVARIUM UTBM");
				}
				
				this.pause=true;
			}
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(this.principal.getDureeVie());
			this.vivarium.update();
		}
	}
	
}
