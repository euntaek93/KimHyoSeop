package bounceball;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class BackgroundPanel extends JPanel{
	Image BackgroundImg1 = new ImageIcon("Image/Background1.png").getImage();
	Image BackgroundImg2 = new ImageIcon("Image/Background2.png").getImage();
	ScoreLabel scoreLabel;
	BackgroundPanel(ScoreLabel scoreLabel){
		this.setLayout(new BorderLayout());
		this.scoreLabel = scoreLabel;
		this.add(scoreLabel, BorderLayout.NORTH);
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(BackgroundImg1,0,0,this.getWidth(), this.getHeight() - 50, this);
		g.drawImage(BackgroundImg2,0,this.getHeight() - 50,this.getWidth(), this.getHeight(), this);
	}
}
