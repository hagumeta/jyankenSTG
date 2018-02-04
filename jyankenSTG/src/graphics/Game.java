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
		Enemy.create();
		//プレイヤーの用意
		Figure.create(new Player(), 500, 600);
		//じゃんけんカウンターの用意
		Global.jyankenCounter = (JyankenCounter)Figure.create(new JyankenCounter());

		///HShapesFrameをフレームウインドウにアタッチ
		add(hsf, BorderLayout.CENTER);

		//ゲームシーンの初期化
		GameInitialize.init();

		hsf.start();//スタート
	}
}
