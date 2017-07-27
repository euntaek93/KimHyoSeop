package bounceball;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.StyledEditorKit.ItalicAction;

public class ScoreLabel extends JLabel{
	static int score = 0;
	
	ScoreLabel(){
		this.setForeground(Color.blue);
		this.setFont(new Font("±¼¸²", Font.BOLD, 30));
		this.setText("  SCORE : " + Integer.toString(score));
	}
	
	public void plusScore(){
		score++;
		this.setText(" Score : " + Integer.toString(score));
	}
	public void minusScore(){
		if(score >0){
			score--;
			this.setText(" Score : " + Integer.toString(score));
		}
	}
}
