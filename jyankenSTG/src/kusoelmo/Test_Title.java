package kusoelmo;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphics.Global;

public class Test_Title extends JFrame implements KeyListener{

	public Test_Title(String caption){
		super(caption);
		super.requestFocusInWindow();
		super.setFocusable(true);
		super.addKeyListener((KeyListener)this);
	}

	public static Test_Title frame;
	public static void main(String args[]){

		Global.setup();

		//フレームの用意
		frame = new Test_Title("fuga");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//タイトルの生成
		Title title = new Title();

		///Titleをフレームウインドウにアタッチ
		frame.add(title, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.pack();

		//現在のシーンはtitle
		Global.nowGameScene = title;
	}

	/*シーン移動*/
	public static void sceneMove(JPanel p) {
		frame.remove(Global.nowGameScene);
		frame.add(p);
		frame.pack();
		Global.nowGameScene = p;
	}

	//キー入力の受付
	public void keyPressed(KeyEvent e){
	      int key;
	      key=e.getKeyCode();
	      switch(key){
	      //上キー
	      case KeyEvent.VK_UP:
	    	 Global.keyInput[0] = true;
	         break;
	      //下キー
	      case KeyEvent.VK_DOWN:
	    	 Global.keyInput[1] = true;
	         break;
	      //左キー
	      case KeyEvent.VK_LEFT:
	    	 Global.keyInput[2] = true;
	         break;
	      //右キー
	      case KeyEvent.VK_RIGHT:
	    	 Global.keyInput[3] = true;
	         break;
	      //Vキー
	      case KeyEvent.VK_Z:
	    	 Global.keyInput[4] = true;
	         break;
	       //Bキー
	      case KeyEvent.VK_X:
	    	 Global.keyInput[5] = true;
	         break;
	       //Nキー
	      case KeyEvent.VK_C:
	    	 Global.keyInput[6] = true;
	         break;
	      }
	}

	public void keyReleased(KeyEvent e){
	      int key;
	      key=e.getKeyCode();
	      switch(key){
	      //上キー
	      case KeyEvent.VK_UP:
	    	 Global.keyInput[0] = false;
	         break;
	      //下キー
	      case KeyEvent.VK_DOWN:
	    	 Global.keyInput[1] = false;
	         break;
	      //左キー
	      case KeyEvent.VK_LEFT:
	    	 Global.keyInput[2] = false;
	         break;
	      //右キー
	      case KeyEvent.VK_RIGHT:
	    	 Global.keyInput[3] = false;
	         break;
	      //Vキー
	      case KeyEvent.VK_Z:
	    	 Global.keyInput[4] = false;
	         break;
	       //Bキー
	      case KeyEvent.VK_X:
	    	 Global.keyInput[5] = false;
	         break;
	       //Nキー
	      case KeyEvent.VK_C:
	    	 Global.keyInput[6] = false;
	         break;
	      }
	}

	public void keyTyped(KeyEvent e){
	}

}