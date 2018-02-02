package kusoelmo;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.Global;

public class Test_Title extends JFrame implements KeyListener{

	private static Title title;

	public Test_Title(String caption){
		super(caption);
		super.requestFocusInWindow();
		super.setFocusable(true);
		super.addKeyListener((KeyListener)this);
	}

	static Test_Title frame;
	public static void main(String args[]){

		Global.setup();

		//フレームの用意
		frame = new Test_Title("fuga");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		title = new Title();

		///Titleをフレームウインドウにアタッチ
		frame.add(title, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.pack();
	}

	/*シーン移動*/
	public static void sceneMove(JPanel p) {
		frame.remove(Global.nowGameScene);
		frame.add(p);
	}

	//キー入力の受付
	public void keyPressed(KeyEvent e){
	      int key;
	      key=e.getKeyCode();
	      switch(key){
	      //上キー
	      case KeyEvent.VK_UP:
	    	 title.cursorUp();
	         break;
	      //下キー
	      case KeyEvent.VK_DOWN:
	    	 title.cursorDown();
	         break;
	      }
	}

	public void keyReleased(KeyEvent e){
	}

	public void keyTyped(KeyEvent e){
	}

}