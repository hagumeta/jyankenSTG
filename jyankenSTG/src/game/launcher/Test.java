package game.launcher;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import game.GameInitialize;
import game.Global;
import game.figs.Player;
import game.figs.enemies.Enemy;
import graphics.frames.Figure;
import graphics.frames.HFigureFrame;
/*デバック用
 * ゲームシーンを直接ぶち込む
 * */
public class Test extends JFrame implements KeyListener{

	public Test(String caption){
		super(caption);
		super.requestFocusInWindow();
		super.setFocusable(true);
		super.addKeyListener((KeyListener)this);
	}

	public static void main(String args[]){
		//フレームの用意
		Test frame = new Test("hoge");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//HShapesFrameの用意
		HFigureFrame hsf = new HFigureFrame(1000, 750, 30);//1秒間に30回更新
		Global.MainFrame = hsf;

		//敵の用意
		Global.difficulty = 2;
		Enemy.create();

		Figure.create(new Player(), 300, 600);

		///HShapesFrameをフレームウインドウにアタッチ
		frame.add(hsf, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.pack();

		//ゲームシーンの初期化
		GameInitialize.init();

		hsf.start();//スタート
		Global.nowGameScene = hsf;
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