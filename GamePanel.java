package bounceball;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class GamePanel extends JPanel {
	Image barImg = new ImageIcon("Image/bar.png").getImage();  //bar 이미지를 가져온다.
	int barPoint = this.getWidth()/2; // bar의 초기위치설정
	boolean barFlag=true; // bar가 움직이고 멈치는게 하는걸 선택
	static final int barScroll = 25;
	final int barSize = 125;
	
	GamePanel(){ // 생성자
		this.setOpaque(false); // 판넬을 불투명하게 한다.
		this.setLayout(new BorderLayout());
		this.addKeyListener(new BarKeyListener()); // 생성한 KeyListner add
		
		this.setFocusable(true);
		this.requestFocus();
	}
	
	@Override
	public void paintComponent(Graphics g){ // bar이미지를 그린다.
		super.paintComponent(g);
		g.drawImage(barImg,barPoint,this.getHeight()-50, barSize, 25, this);
	}
	
	class BarKeyListener extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
				switch(keyCode){
				case KeyEvent.VK_LEFT:
					if(barPoint > 0 ){
						barPoint -= barScroll;
						repaint();
					}
					break;
					
				case KeyEvent.VK_RIGHT:
					if(barPoint < 780 - barSize){
						barPoint += barScroll;
						repaint();
					}
					break;
				} // switch			
				
		}//keyPressed
		
	}// barKeyListener
	
}//class
