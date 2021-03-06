package game.scenes;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import game.GameFrame;
import game.GameInitialize;
import game.Global;
import game.figs.JyankenCounter;
import graphics.frames.Figure;

/*ゲームシーン*/
public class Game extends JPanel{
	public Game(){
		//GameFrameの用意
		GameFrame gf = new GameFrame();

		///GameFrameをフレームウインドウにアタッチ
		add(gf, BorderLayout.CENTER);

		//じゃんけんカウンターの用意
		Global.jyankenCounter = (JyankenCounter)Figure.create(new JyankenCounter());

		//ゲームシーンの初期化
		GameInitialize.init();

		gf.start();//スタート
	}
}
