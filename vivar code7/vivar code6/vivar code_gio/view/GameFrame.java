package view;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import controller.GameManager;
import controller.MenuManeger;

import model.Joueur;


@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	private MenuHomeWiew VivariumMenuHomeView;
    private MenuNewView VivariumMenuNewView;
	//private MenuLoadView VivariumMenuLoadView;
	private MenuOptionsView VivariumMenuOptionsView;
/*	private MenuDifficultyView VivariumMenuDifficultyView;
	private MenuLevelView VivariumMenuLevelView;
	private GameView VivariumView;
	private GameManager VivariumController;*/
	private MenuManeger VivariumMenuController;
	//private GameModel angryModel;
	private String winName;
//	ArrayList<Items> VivariumEntities;
//	ArrayList<Joueur> VivariumPlayers;
	
	public GameFrame(String name) {
		winName = name;
		
		//creation du dossier de sauvegardes
	/*	File fb = new File("save/"); 
		fb.mkdir();
		
		angryModel = new GameModel();
		VivariumEntities = angryModel.getItemsList();
		VivariumPlayers = angryModel.getPlayers();*/
		
		//Views
		VivariumMenuHomeView = new MenuHomeWiew();
	VivariumMenuNewView = new MenuNewView();
		//VivariumMenuLoadView = new MenuLoadView(VivariumPlayers);*/
		VivariumMenuOptionsView = new MenuOptionsView();
	/*	VivariumMenuDifficultyView = new MenuDifficultyView();
		VivariumMenuLevelView = new MenuLevelView();*/
		
	/*	VivariumView = new GameView(VivariumEntities);
		
		angryModel.setVivariumView(VivariumView);
		
		//Controller 
		VivariumController = new GameManager(this);*/
		VivariumMenuController = new MenuManeger(this);
		
		//Listener
		VivariumMenuHomeView.addKeyListener(VivariumMenuController);
		VivariumMenuNewView.addKeyListener(VivariumMenuController);
		VivariumMenuNewView.addMouseListener(VivariumMenuController);
	/*	VivariumMenuLoadView.addKeyListener(VivariumMenuController);
		VivariumMenuLoadView.addMouseListener(VivariumMenuController);*/
		VivariumMenuOptionsView.addKeyListener(VivariumMenuController);
	/*	VivariumMenuDifficultyView.addKeyListener(VivariumMenuController);
		VivariumMenuLevelView.addKeyListener(VivariumMenuController);
		
		VivariumView.addKeyListener(VivariumController);
		VivariumView.addMouseListener(VivariumController);
		VivariumView.addMouseMotionListener(VivariumController);
		angryModel.addListListener(VivariumView);
		//angryModel.addListListener(angryController);	*/

		this.setContentPane(VivariumMenuHomeView);
		
		this.setTitle(winName);
		this.setSize((int)GameFrame.getFrameSize().getWidth(), (int)GameFrame.getFrameSize().getHeight());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);		
    }

/*	public GameView getVivariumView() {
		return VivariumView;
	}*/
	
	public MenuHomeWiew getVivariumMenuHomeView()
	{
		return VivariumMenuHomeView;
	}
	
	public MenuNewView getAVivariumMenuNewView()
	{
		return VivariumMenuNewView;
	}
	
	/*
	public MenuLoadView getVivariumMenuLoadView()
	{
		return VivariumMenuLoadView;
	}*/
	
	public MenuOptionsView getVivariumMenuOptionsView()
	{
		return VivariumMenuOptionsView;
	}
	
/*	public MenuDifficultyView getVivariumMenuDifficultyView()
	{
		return VivariumMenuDifficultyView;
	}
	
	public MenuLevelView getVivariumMenuLevelView()
	{
		return VivariumMenuLevelView;
	}
	
	public GameModel getVivariumModel()
	{
		return angryModel;
	}
	public GameManager getController()
	{
		return VivariumController;
	}

	public void setMenuLevel()
	{

		this.setContentPane(VivariumMenuLevelView);
		VivariumMenuLevelView.requestFocus();
		this.setVisible(true);
		
	}
	
	public void setGame()
	{
		this.setContentPane(VivariumView);
		VivariumView.requestFocus();
		this.setVisible(true);
		
	}
	
	public void setPlayers(ArrayList<Joueur> players) {
		angryModel.setPlayers(players);
	}
	
	public void setCurrentPlayer(Joueur p) {
		angryModel.setCurrentPlayer(p);
	}
	
	public void setDifficulty(String dif) {
		angryModel.setDifficulty(dif);
	}
	
	public void setCurrentLevel(int l) {
		angryModel.setCurrentLevel(l);
	}
	
	public void setCurrentHighScore() {
		angryModel.setCurrentHighScore();
	}*/
	
	static public Dimension getFrameSize() {
		Dimension frameSize = new Dimension(800,600);
		return frameSize;
	}
	
}
