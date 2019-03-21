package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import model.Individu;
import model.Nourriture;
import model.Obstacle;
import model.Partie;

public class FenetreJeu extends JFrame{
	protected static final int LARGEUR=1200;
	protected static final int HAUTEUR=700;
	private GridBagConstraints gc;
	private JPanel panel;
	private JTextPane score;
	private Partie partie;
	public FenetreJeu(String nom, Partie partie){
		super(nom);
		this.partie=partie;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(FenetreJeu.LARGEUR, FenetreJeu.HAUTEUR);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//Action de la souris
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(SwingUtilities.isLeftMouseButton(e)) {
					Random alt =new Random();
					int x_ = e.getX()*50/100;
					int y_ = e.getY()*42/100;
					String img_ ="Newimg.png";
					int valnutritive_ = alt.nextInt(20);
					Nourriture food_ = new Nourriture(x_, y_, valnutritive_, img_);
					partie.ajouterNourriture_(food_);
					System.out.println("Press Left x_ "+x_+" y_ "+y_);
				}
				
				else if(SwingUtilities.isRightMouseButton(e)) {
					//Sur click gauche on ajoute la nouriture 
					int x_ = e.getX()*50/100;
					int y_ = e.getY()*42/100;
					Obstacle Obst_ = new Obstacle(x_, y_);
					partie.ajouterObstacleParametre_(Obst_);
					System.out.println("Press Right x_ "+x_+" y_ "+y_);
				}
				
				else if (SwingUtilities.isMiddleMouseButton(e)) {
					//Sur click sur le bouton du millieu on supprime un item sur l'écran
					int x_ = e.getX()*50/100;
					int y_ = e.getY()*42/100;
					partie.supprimerItemParametre( x_, y_);
				}
			}
		});
		//Action de la souris
				
		//gio modif
		this.panel=new JPanel();
		//this.add(panel);
		
		//Actions du menu
		JMenuBar jmb=new JMenuBar();
		JMenu options=new JMenu("Options");
		JMenuItem sauver=new JMenuItem("Sauver");
		JMenuItem reprendre=new JMenuItem("Reprendre");
		JButton pause = new JButton("Pause");
		JButton nourriture = new JButton("Ajouter Nourriture");
		JButton individu = new JButton("Ajouter Individu");
		JButton obstacle = new JButton("Ajouter Obstacle");
		
		
		sauver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				partie.enregistrer();
				partie.pause();
				//FenetreJeu.this.setVisible(false);
			}
		});
		
		pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				partie.pause();
			}
		});
		
		reprendre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				partie.reprendre();
			}
		});
		
		nourriture.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random alt =new Random();
				int x_ = alt.nextInt(FenetreJeu.LARGEUR*60/100);
				int y_ = alt.nextInt(FenetreJeu.HAUTEUR*60/100);
				String img_ ="Newimg.png";
				int valnutritive_ = alt.nextInt(20);
				Nourriture food_ = new Nourriture(x_, y_, valnutritive_, img_);
				partie.ajouterNourriture_(food_);
				
			}
		});
		
		individu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random alt =new Random();
				partie.ajouterIndividu_();
				
			}
		});
		
		obstacle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random alt =new Random();
				partie.ajouterObstacle_();
				
			}
		});
		
		//Fin d'action du Menu
		
		//Ajout au menu bar
		options.add(sauver);
		options.add(pause);
		options.add(reprendre);
		jmb.add(options);
		jmb.add(pause);
		jmb.add(nourriture);
		jmb.add(individu);
		jmb.add(obstacle);
		
		this.setJMenuBar(jmb);
		//Fin d'action du menu
		
		//fin gio modif
		
		this.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.setOpaque(false);
		/*JButton ajouterNourriture = new JButton("Ajouter nourriture");
		//sajouterNourriture.setPreferredSize(preferredSize);
		
		ajouterNourriture.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		buttonPanel.add(ajouterNourriture);*/
		this.add(buttonPanel,BorderLayout.NORTH);
		
		this.score=new JTextPane();
		score.setLayout(new FlowLayout(FlowLayout.LEFT));
		score.setOpaque(false);
		score.setText(partie.afficheScore());
		this.add(score,BorderLayout.SOUTH);
		
	}
	
	public Partie getPartie(){
		return this.partie;
	}
	
	public void ecrireScore(){
		
		this.score.setText(this.partie.afficheScore());
	}
	
	public JPanel getPanel(){
		return this.panel;
	}
	
	private void boutonEnregister(){
	}
	
	public static int getHauteur(){
		return FenetreJeu.HAUTEUR-30;
	}
	
	public static int getLargeur(){
		return FenetreJeu.LARGEUR+10;
	}

}
