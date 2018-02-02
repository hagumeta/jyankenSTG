package graphics;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import graphics.frames.HFigureFrame;
import graphics.frames.figures.Figure;

/*ゲームのシーン用意するコンポーネント*/
public class SceneGame extends JPanel {

	private JPanel panel;

	public SceneGame() {

		panel = new JPanel();

		//HShapesFrameの用意
		HFigureFrame hsf = new HFigureFrame(800, 700, 30);//1秒間に30回更新
		Global.MainFrame = hsf;//グローバルに設定

		//自機とエネミーの設定
		Figure.create(new Player(), 300, 700);
		//Figure.create(new Bullet(), 300, 300);
		Figure.create(new Enemy(), 300, 50);


		///HShapesFrameをコンポーネントにアタッチ
		panel.add(hsf, BorderLayout.CENTER);
		panel.setVisible(true);


		//ゲームシーンの初期化
		GameInitialize.init();

		hsf.start();//ゲームフレームスタート

		add(panel);
	}
}
