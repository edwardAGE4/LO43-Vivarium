package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;


import javax.swing.ImageIcon;

public class panel extends JPanel {
	
	public panel() {
		super();
		this.setBackground(Color.RED);
		this.setSize(400, 800);
	}
	
	public  void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image iconPhoto = new ImageIcon("images/vivarium.jpg").getImage();
		g.drawImage(iconPhoto, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
