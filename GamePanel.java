package bounceball;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class GamePanel extends JPanel {
	Image barImg = new ImageIcon("Image/bar.png").getImage();  //bar �̹����� �����´�.
	int barPoint = this.getWidth()/2; // bar�� �ʱ���ġ����
	boolean barFlag=true; // bar�� �����̰� ��ġ�°� �ϴ°� ����
	static final int barScroll = 25;
	final int barSize = 125;
	
	GamePanel(){ // ������
		this.setOpaque(false); // �ǳ��� �������ϰ� �Ѵ�.
		this.setLayout(new BorderLayout());
		this.addKeyListener(new BarKeyListener()); // ������ KeyListner add
		
		this.setFocusable(true);
		this.requestFocus();
	}
	
	@Override
	public void paintComponent(Graphics g){ // bar�̹����� �׸���.
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
