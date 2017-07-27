package bounceball;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class MainBounceBall extends JFrame{
	Container contentPane;
	BackgroundPanel backgroundPanel;
	GamePanel gamePanel;
	BallThread ballPanel;
	ScoreLabel scoreLabel;
	
	MainBounceBall(){
		setTitle("Bounce Ball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		scoreLabel = new ScoreLabel();
		backgroundPanel = new BackgroundPanel(scoreLabel);
		gamePanel = new GamePanel();
		ballPanel = new BallThread(gamePanel, scoreLabel);
		
		gamePanel.add(ballPanel);
		backgroundPanel.add(gamePanel);
		contentPane.add(backgroundPanel);
		setSize(800,600);
		setVisible(true);
		ballPanel.run();
	}
	

	public static void main(String[] args) {
		new MainBounceBall();
		
	}

}
