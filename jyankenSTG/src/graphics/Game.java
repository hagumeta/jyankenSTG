package graphics;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import graphics.frames.HFigureFrame;
import graphics.frames.figures.Figure;

/*ゲームシーン*/
public class Game extends JPanel{
	public Game(){

		//HShapesFrameの用意
		HFigureFrame hsf = new HFigureFrame(1000, 750, 30);//1秒間に30回更新
		Global.MainFrame = hsf;

		//敵の用意
		Global.difficulty = 2;
		Enemy.create();

		Figure.create(new Player(), 300, 600);

		///HShapesFrameをフレームウインドウにアタッチ
		add(hsf, BorderLayout.CENTER);

		//ゲームシーンの初期化
		GameInitialize.init();

		hsf.start();//スタート
		Global.nowGameScene = this;
	}
}
