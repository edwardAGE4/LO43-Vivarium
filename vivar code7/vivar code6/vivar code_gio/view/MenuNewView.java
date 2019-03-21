package view;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MenuNewView extends GameViewMenu
{
	//declaration des attributs adaptes a la page creation de nouvelles parties
	JLabel playernameLabel;
	JLabel difficulteLabel;
	JTextField playernameField;
	JButton okNewButton;
	
	String[] difficulte = new String[] {"Facile", "Moyen", "Difficile", "Extrème", "Impossible"};
	JComboBox<String> difficulteCombo;
	
	public MenuNewView()
	{
        playernameLabel = new JLabel("Veuillez entrer un nom :");
        playernameLabel.setSize(250, 10);
        playernameLabel.setLocation(frameWidth/2-60,150);
        
        playernameField = new JTextField();
        playernameField.setSize(200,30);
        playernameField.setLocation(frameWidth/2-100,180);
        
        difficulteLabel = new JLabel("Veuillez choisir une difficulté :");
        difficulteLabel.setSize(250, 10);
        difficulteLabel.setLocation(frameWidth/2-80,250);
        
        difficulteCombo = new JComboBox<String>(difficulte);
        difficulteCombo.setSize(200,30);
        difficulteCombo.setLocation(frameWidth/2-100,280);
   	 	
   	 	okNewButton = new JButton("OK");
   	 	okNewButton.setSize(100,30);
   	 	okNewButton.setLocation(frameWidth/2-50, 350);
   	 	
   	    //ajout des attributs avec l'index 1 pour etre en premier plan
        this.add(playernameLabel,new Integer(1));
   	 	this.add(playernameField,new Integer(1));
   	 	this.add(difficulteLabel,new Integer(1));
	 	this.add(difficulteCombo,new Integer(1));
        this.add(okNewButton,new Integer(1));
        
	}
	
	public JTextField getPlayerNameField()
	{
		return playernameField;
	}
	
	public JComboBox<String> getdifficulteCombo()
	{
		return difficulteCombo;
	}
	
	
	public JButton getOkNewButton()
	{
		return okNewButton;
	}
}