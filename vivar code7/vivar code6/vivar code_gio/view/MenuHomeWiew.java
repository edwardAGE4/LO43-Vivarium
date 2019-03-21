package view;


import javax.swing.JButton;

@SuppressWarnings("serial")
public class MenuHomeWiew extends GameViewMenu
{
	//declaration des attributs adaptes a la page principale
	private JButton newButton,loadButton,optionsButton,exitButton;
	
	public MenuHomeWiew() {
		
        newButton = new JButton("Nouvelle Partie");
        newButton.setSize(150,30);
        newButton.setLocation(frameWidth/2-75, 150);
        
        loadButton = new JButton("charger une partie");
        loadButton.setSize(150,30);
        loadButton.setLocation(frameWidth/2-75, 225);
        
        optionsButton = new JButton("Aide");
        optionsButton.setSize(150,30);
        optionsButton.setLocation(frameWidth/2-75, 300);
        
        exitButton = new JButton("Quitter le Jeu");
        exitButton.setSize(150,30);
        exitButton.setLocation(frameWidth/2-75, 375);
        
        backButton.setVisible(false); //pas de bouton de retour sur la page principale
        
        //ajout des attributs avec l'index 1 pour etre en premier plan
   	 	this.add(newButton,new Integer(1));
   	 	this.add(loadButton,new Integer(1));
   	 	this.add(optionsButton,new Integer(1));
   	 	this.add(exitButton,new Integer(1));
	}
	
	public JButton getNewButton()
	{
		return newButton;
	}
	
	public JButton getLoadButton()
	{
		return loadButton;
	}
	
	public JButton getOptionsButton()
	{
		return optionsButton;
	}
	
	public JButton getExitButton()
	{
		return exitButton;
	}
}