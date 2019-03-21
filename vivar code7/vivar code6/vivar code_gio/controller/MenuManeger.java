package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Individu;
import model.IndividuPrincipal;
import model.Joueur;
import model.Partie;
import view.FenetreJeu;
import view.GameFrame;

import view.MenuHomeWiew;
import view.MenuNewView;

import view.MenuOptionsView;
//import view.MenuPauseView;

public class MenuManeger implements KeyListener, ActionListener, MouseListener {

	private JTextField playerNameField;
	JComboBox<String> difficulteCombo;
//	private JButton backfromNewButton, backfromLoadButton, backfromOptionsButton;
//	private JButton backfromDifficultyButton, backfromLevelButton;
	private JButton newButton,loadButton,optionsButton,exitButton,backfromNewButton,okNewButton,backfromOptionsButton;
/*	private JButton okNewButton,okLoadButton,deleteButton;
	private JButton easyButton,mediumButton,hardButton,extremeButton;
	private JButton resetButton , resume ;
	private ArrayList<JButton> lvlButto*/
	@SuppressWarnings("unused")

	//private ArrayList<Joueur> VivariumPlayers;
	//private JComboBox playersList;
	private MenuHomeWiew VivariumMenuHomeView;
	private MenuNewView VivariumMenuNewView;
	//private MenuLoadView VivariumMenuLoadView;*/
	private MenuOptionsView VivariumMenuOptionsView;
/*	private MenuDifficultyView VivariumMenuDifficultyView;
	private MenuPauseView VivariumMenuPauseView;
	private MenuLevelView VivariumMenuLevelView ;*/
	private GameFrame VivariumFrame;
//	private String difficulty = "";
//	private GameModel VivariumModel;
	
	public MenuManeger(GameFrame frame){
		
		VivariumFrame = frame;
	/*	VivariumModel = VivariumFrame.getVivariumModel();
		VivariumPlayers = VivariumModel.getPlayers();*/
		
		
		//on recupere les differentes vues du menu
		VivariumMenuHomeView = frame.getVivariumMenuHomeView();
	    VivariumMenuNewView = frame.getAVivariumMenuNewView();
		//VivariumMenuLoadView = frame.getVivariumMenuLoadView();*/
		VivariumMenuOptionsView = frame.getVivariumMenuOptionsView();
		/*VivariumMenuDifficultyView = frame.getVivariumMenuDifficultyView();
		VivariumMenuLevelView = frame.getVivariumMenuLevelView();*/
		
		//on recupere les objets du menu necessaires
		//et on leur ajoute  un actionlistener
		
		backfromNewButton = VivariumMenuNewView.getBackButton();
		backfromNewButton.addActionListener(this);
	/*	backfromLoadButton = VivariumMenuLoadView.getBackButton();
		backfromLoadButton.addActionListener(this);*/
		backfromOptionsButton = VivariumMenuOptionsView.getBackButton();
		backfromOptionsButton.addActionListener(this);
	/*	backfromDifficultyButton = VivariumMenuDifficultyView.getBackButton();
		backfromDifficultyButton.addActionListener(this);
		backfromLevelButton = VivariumMenuLevelView.getBackButton();
		backfromLevelButton.addActionListener(this);*/
		
		newButton = VivariumMenuHomeView.getNewButton();
		newButton.addActionListener(this);
		loadButton = VivariumMenuHomeView.getLoadButton();
		loadButton.addActionListener(this);	
		optionsButton = VivariumMenuHomeView.getOptionsButton();
		optionsButton.addActionListener(this);
		exitButton = VivariumMenuHomeView.getExitButton();
		exitButton.addActionListener(this);
		
	    playerNameField = VivariumMenuNewView.getPlayerNameField();
	    difficulteCombo = VivariumMenuNewView.getdifficulteCombo();
		okNewButton = VivariumMenuNewView.getOkNewButton();
		okNewButton.addActionListener(this);
	/*			
		playersList = VivariumMenuLoadView.getPlayersList();
		deleteButton = VivariumMenuLoadView.getDeleteButton();
		deleteButton.addActionListener(this);
		okLoadButton = VivariumMenuLoadView.getOkLoadButton();
		okLoadButton.addActionListener(this);
		
		easyButton = VivariumMenuDifficultyView.getEasyButton();
		easyButton.addActionListener(this);
		mediumButton = VivariumMenuDifficultyView.getMediumButton();
		mediumButton.addActionListener(this);
		hardButton = VivariumMenuDifficultyView.getHardButton();
		hardButton.addActionListener(this);
		extremeButton = VivariumMenuDifficultyView.getExtremeButton();
		extremeButton.addActionListener(this);
		
		lvlButtons = VivariumMenuLevelView.getLvlButtons();
		for (JButton button : lvlButtons) {
			button.addActionListener(this);
		}*/
		
		JOptionPane.setDefaultLocale(Locale.ENGLISH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// on change de panel en fonction du bouton clique
		
		if(e.getSource().equals(backfromNewButton)||/*e.getSource().equals(backfromLoadButton)||*/e.getSource().equals(backfromOptionsButton))
		{
			VivariumFrame.setContentPane(VivariumMenuHomeView);
			VivariumMenuHomeView.requestFocus();
			VivariumFrame.setVisible(true);
		}
	/*	if(e.getSource().equals(backfromDifficultyButton))
		{
			if(VivariumMenuDifficultyView.getParentPanel()=="newPanel")
			{
				VivariumFrame.setContentPane(VivariumMenuNewView);
				VivariumMenuNewView.requestFocus();
				VivariumFrame.setVisible(true);
			}
			else
			{
				VivariumFrame.setContentPane(VivariumMenuLoadView);
				VivariumMenuLoadView.requestFocus();
				VivariumFrame.setVisible(true);
			}
		}

		if(e.getSource().equals(backfromLevelButton))
		{
			VivariumFrame.setContentPane(VivariumMenuDifficultyView);
			VivariumMenuDifficultyView.requestFocus();
			VivariumFrame.setVisible(true);
		}*/
		
		if (e.getSource().equals(newButton))
		{
			VivariumFrame.setContentPane(VivariumMenuNewView);
			VivariumMenuNewView.requestFocus();
			VivariumFrame.setVisible(true);
		}
		
		if(e.getSource().equals(loadButton))
		{			
		/*	if(VivariumFrame.getVivariumModel().getPlayers().isEmpty())
			{
				javax.swing.JOptionPane.showMessageDialog(null, "No save file found !");
			}
			else
			{
				VivariumFrame.setContentPane(VivariumMenuLoadView);
				VivariumMenuLoadView.requestFocus();
				VivariumFrame.setVisible(true);
			}*/
		}
		
		if (e.getSource().equals(optionsButton))
		{
			VivariumFrame.setContentPane(VivariumMenuOptionsView);
			VivariumMenuOptionsView.requestFocus();
			VivariumFrame.setVisible(true);
		}
		
		if (e.getSource().equals(exitButton))
		{
			int option = javax.swing.JOptionPane.showConfirmDialog(null, "Voullez-vous réellement quitter le jeux ?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION)
			{
				System.exit(0);		
			}
		}
		
		if(e.getSource().equals(okNewButton))
		{			
			if (playerNameField.getText().equals(""))
			{
				javax.swing.JOptionPane.showMessageDialog(null, "Veuillez renseigner un nom de joueur.");
			}		
			else 
			{			
				String ValeurCombo = (String) difficulteCombo.getSelectedItem();
				 if (ValeurCombo.equals("Facile")) {
					 //Niveau Facile avec 3 ennemi initial
					 // ->une durée de vie initiale de 80 
					 // ->une durée de vie des ennemi de 30
					 // ->6 obtacles au total au début 
					 	
					 	VivariumFrame.setVisible(false);
					 	Random rand=new Random();
						Individu princ=new IndividuPrincipal(rand.nextInt(FenetreJeu.getLargeur()/3),rand.nextInt(FenetreJeu.getLargeur()/3),"images/chien.png",80);
						Joueur j=new Joueur(playerNameField.getText(),princ);
						Partie p=new Partie(princ,j,null);
						p.getVivarium().ajouterItem(princ);		
						p.ajouterIndividus(3,30);
						p.ajouterObstacle(6);
						p.reprendre();
						p.start();
			        } 
				 
				 else if (ValeurCombo.equals("Moyen")) {
					 //Niveau Moyen avec 10 ennemis initiaux
					 // ->une durée de vie initiale de 50 
					 // ->une durée de vie des ennemi de 80
					 // ->un nombre dobtacles au total au début  de 10
					 
					 	VivariumFrame.setVisible(false);
					 	Random rand=new Random();
						Individu princ=new IndividuPrincipal(rand.nextInt(FenetreJeu.getLargeur()/3),rand.nextInt(FenetreJeu.getLargeur()/3),"images/chien.png",50);
						Joueur j=new Joueur(playerNameField.getText(),princ);
						Partie p=new Partie(princ,j,null);
						p.getVivarium().ajouterItem(princ);		
						p.ajouterIndividus(10,80);
						p.ajouterObstacle(10);
						p.reprendre();
						p.start();
			        }
				 
				 else if (ValeurCombo.equals("Difficile")) {
					 //Niveau Moyen avec 20 ennemis initiaux
					 // ->une durée de vie initiale de 30 
					 // ->une durée de vie des ennemi de 100
					 // ->un nombre dobtacles au total au début  de 15
					 
					 	VivariumFrame.setVisible(false);
					 	Random rand=new Random();
						Individu princ=new IndividuPrincipal(rand.nextInt(FenetreJeu.getLargeur()/3),rand.nextInt(FenetreJeu.getLargeur()/3),"images/chien.png",30);
						Joueur j=new Joueur(playerNameField.getText(),princ);
						Partie p=new Partie(princ,j,null);
						p.getVivarium().ajouterItem(princ);		
						p.ajouterIndividus(20,100);
						p.ajouterObstacle(15);
						p.reprendre();
						p.start();
			        }
				 
				 else if (ValeurCombo.equals("Extrème")) {
					 //Niveau Moyen avec 30 ennemis initiaux
					 // ->une durée de vie initiale de 10 
					 // ->une durée de vie des ennemi de 150
					 // ->un nombre dobtacles au total au début  de 20
					 
					 	VivariumFrame.setVisible(false);
					 	Random rand=new Random();
						Individu princ=new IndividuPrincipal(rand.nextInt(FenetreJeu.getLargeur()/3),rand.nextInt(FenetreJeu.getLargeur()/3),"images/chien.png",10);
						Joueur j=new Joueur(playerNameField.getText(),princ);
						Partie p=new Partie(princ,j,null);
						p.getVivarium().ajouterItem(princ);		
						p.ajouterIndividus(30,150);
						p.ajouterObstacle(20);
						p.reprendre();
						p.start();
			        }
				 
				 else if (ValeurCombo.equals("Impossible")) {
					 //Niveau Moyen avec 50 ennemis initiaux
					 // ->une durée de vie initiale de 5 
					 // ->une durée de vie des ennemi de 200
					 // ->un nombre dobtacles au total au début  de 30
					 
					 	VivariumFrame.setVisible(false);
					 	Random rand=new Random();
						Individu princ=new IndividuPrincipal(rand.nextInt(FenetreJeu.getLargeur()/3),rand.nextInt(FenetreJeu.getLargeur()/3),"images/chien.png",5);
						Joueur j=new Joueur(playerNameField.getText(),princ);
						Partie p=new Partie(princ,j,null);
						p.getVivarium().ajouterItem(princ);		
						p.ajouterIndividus(50,200);
						p.ajouterObstacle(25);
						p.reprendre();
						p.start();
			        }
		   /*
				VivariumFrame.setVisible(false);
				Individu princ=new IndividuPrincipal(10,10,"images/chien.png",10);
				Joueur j=new Joueur(playerNameField.getText(),princ);
				Partie p=new Partie(princ,j,null);
				p.getVivarium().ajouterItem(princ);
				p.getVivarium().ajouterItem(new Individu(50,7,"images/Enemy.png",10));
				
				p.ajouterObstacle(10);*/
				
				
				//System.out.println((String) difficulteCombo.getSelectedItem());
				
			}
			
		}/*
		
		if(e.getSource().equals(okLoadButton))
		{
			//chargement du joueur choisi
			currentPlayer = (Joueur) playersList.getSelectedItem();
			VivariumFrame.setCurrentPlayer(currentPlayer);
			VivariumFrame.setDifficulty("");
			VivariumFrame.setCurrentLevel(0);
			VivariumFrame.setCurrentHighScore();

			VivariumFrame.setContentPane(VivariumMenuDifficultyView);
			VivariumMenuDifficultyView.setParentPanel("loadPanel");
			VivariumMenuDifficultyView.requestFocus();
			VivariumFrame.setVisible(true);
			
			//actualisation de la liste des joueurs
			ArrayList<Joueur> players = new ArrayList<Joueur>();
			try{
				File initial = new File ("save");
				for (File f:initial.listFiles())
				{
					FileInputStream fis = new FileInputStream(f);
					ObjectInputStream ois = new ObjectInputStream(fis);
					Joueur pl = (Joueur)ois.readObject();
					players.add(pl);
				}			
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}

			VivariumFrame.setPlayers(players);
			VivariumMenuLoadView.setPlayersList(players);
		}
		
		if(e.getSource().equals(deleteButton))
		{
			int option = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure ?", "Confirmation before suppression", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION)
			{
				//suppression du fichier choisi
				Joueur p = (Joueur) playersList.getSelectedItem();
				playersList.removeItem(p);
				File file = new File("save/" + p.getName() + ".save"); 
				file.delete();
				
				//actualisation de la liste des joueurs
				ArrayList<Joueur> players = new ArrayList<Joueur>();
				try{
					File initial = new File ("save");
					for (File f:initial.listFiles())
					{
						FileInputStream fis = new FileInputStream(f);
						ObjectInputStream ois = new ObjectInputStream(fis);
						Joueur pl = (Joueur)ois.readObject();
						players.add(pl);
					}			
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				VivariumFrame.setPlayers(players);
				VivariumMenuLoadView.setPlayersList(players);
				
				VivariumFrame.setContentPane(VivariumMenuLoadView);
				VivariumMenuLoadView.requestFocus();
				VivariumFrame.setVisible(true);	
			}
		}
		

		//on actualise la variable difficulty
		if (e.getSource().equals(easyButton))
		{
			difficulty = "easy";
			
		}
		
		if (e.getSource().equals(mediumButton))
		{
			difficulty = "medium";
			
		}
			
		if (e.getSource().equals(hardButton))
		{
			difficulty = "hard";
			
		}
		
		if (e.getSource().equals(extremeButton))
		{
			difficulty = "extreme";	
		}
		
		//on affiche la page des niveaux
		//selon la sauvegarde les boutons sont disponibles ou non
		if (!difficulty.equals("") && (e.getSource().equals(easyButton) || e.getSource().equals(mediumButton) || e.getSource().equals(hardButton) || e.getSource().equals(extremeButton))) {
			for (int lvlNumber = 0; lvlNumber < lvlButtons.size(); ++lvlNumber) {
				lvlButtons.get(lvlNumber).setEnabled(false);
				
				if (currentPlayer.isFinished(lvlNumber, difficulty)) {
					lvlButtons.get(lvlNumber).setEnabled(true);
					if ((lvlNumber+1) < lvlButtons.size())
						lvlButtons.get(lvlNumber+1).setEnabled(true);
				}
			}
			lvlButtons.get(0).setEnabled(true);
			
			VivariumFrame.setDifficulty(difficulty);
			
			VivariumFrame.setContentPane(VivariumMenuLevelView);
			VivariumMenuLevelView.requestFocus();
			VivariumFrame.setVisible(true);
		}
		
		//on lance le jeu correspondant au niveau choisi
		for (int i = 0; i < lvlButtons.size(); ++i) {
			if(e.getSource().equals(lvlButtons.get(i))) {
				level lvl = new level("res/maps/lvl0" + (i+1) + ".txt", difficulty);
				if (lvl.isLoaded()) {
					VivariumFrame.getVivariumView().setMap(lvl);
					VivariumFrame.getVivariumModel().setMap(lvl);
					VivariumFrame.setCurrentHighScore();
					VivariumFrame.setGame();
					VivariumFrame.setCurrentLevel(i+1);
				}
				else {
					javax.swing.JOptionPane.showMessageDialog(null, "No map for this level yet !");
				}
			}
		}*/
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		
			case KeyEvent.VK_ESCAPE:
				if(VivariumFrame.getContentPane()==VivariumMenuHomeView)
				{
					int option = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure ?", "Confirmation to leave", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(option == JOptionPane.OK_OPTION)
					{
						System.exit(0);		
					}
				}
				if(VivariumFrame.getContentPane()==VivariumMenuNewView ||/* VivariumFrame.getContentPane()==VivariumMenuLoadView ||*/ VivariumFrame.getContentPane()==VivariumMenuOptionsView)
				{
				VivariumFrame.setContentPane(VivariumMenuHomeView);
					VivariumMenuHomeView.requestFocus();
					VivariumFrame.setVisible(true);
				}/*
				if(VivariumFrame.getContentPane()==VivariumMenuDifficultyView)
				{
					if(VivariumMenuDifficultyView.getParentPanel()=="newPanel")
					{
						VivariumFrame.setContentPane(VivariumMenuNewView);
						VivariumMenuNewView.requestFocus();
						VivariumFrame.setVisible(true);
					}
					else
					{
						VivariumFrame.setContentPane(VivariumMenuLoadView);
						VivariumMenuLoadView.requestFocus();
						VivariumFrame.setVisible(true);
					}
				}
				if(VivariumFrame.getContentPane()==VivariumMenuLevelView)
				{
					VivariumFrame.setContentPane(VivariumMenuDifficultyView);
					VivariumMenuDifficultyView.requestFocus();
					VivariumFrame.setVisible(true);
				}*/
				break;
			default:
				System.out.println("Qu'essayez vous de faire ??!");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		if(VivariumFrame.getContentPane()==VivariumMenuNewView)
	//		VivariumMenuNewView.requestFocus();
		
	//	if(VivariumFrame.getContentPane()==VivariumMenuLoadView)
		//	VivariumMenuLoadView.requestFocus();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
