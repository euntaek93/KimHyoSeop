package bounceball;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;//  gggggggggggggggggggggggggggggggggggg

public class BallThread extends JPanel implements Runnable{
	Image ballImg1 = new ImageIcon("Image/ball1.png").getImage();
	GamePanel gamePanel2;
	ScoreLabel scoreLabel;
	int x = 350;
	int y = 0;
	int flag=1;
	static final int ballScroll = 10;
	BallThread(GamePanel gamePanel, ScoreLabel scoreLabel){
		this.gamePanel2 = gamePanel;
		this.scoreLabel = scoreLabel;
		this.setOpaque(false); // 판넬을 불투명하게 한다.
	}
	
	@Override
	public void paintComponent(Graphics g){ // bar이미지를 그린다.
		super.paintComponent(g);
		g.drawImage(ballImg1, x, y, 30, 30, this);
	}
	
	@Override
	public void run() {
		while(true){
			try {
				switch(flag){
				case 1:
					x += ballScroll; 
					y += ballScroll;
					if(x >= gamePanel2.getWidth()-30){
						flag=2; 
					}else if(y >= gamePanel2.getHeight()-30){
						flag=4;
						scoreLabel.minusScore();
					}
					break;
					
				case 2:
					x -= ballScroll; 
					y +=ballScroll;
					if(x <= 0){
						flag=1;
					}else if(y >= gamePanel2.getHeight()-30){
						flag=3;
						scoreLabel.minusScore();
					}
					break;	
					
				case 3:
					x -= ballScroll; 
					y -= ballScroll;
					if(x <= 0){
						flag=4;
					}else if(y <= 0){
						flag=2;
					}
					break;
					
				case 4:
					x += ballScroll; 
					y -= ballScroll;
					if(x >= gamePanel2.getWidth()-30){
						flag=3;
					}else if(y <= 0){
						flag=1;
					}
					break;
				}
				repaint();
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(gamePanel2.barPoint <= x && gamePanel2.barPoint +125 >= x && y >= gamePanel2.getHeight() -80){
				if(flag==1){flag=4;}
				else{flag=3;}
				scoreLabel.plusScore();
			}
			
		}
		

		
	}
	
}
