package graphics;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import graphics.frames.GameFrame;
import graphics.frames.figures.Figure;

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
