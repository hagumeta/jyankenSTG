package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.frames.HFigureFrame;
import graphics.frames.figures.Figure;

/*ゲームフレーム*/
public class GameFrame extends HFigureFrame {

	public BufferedImage background;//背景画像

	public GameFrame(){
		super(1000, 750, 30);//1秒間に30回更新

		//自身をメインフレームに設定
		Global.MainFrame = (HFigureFrame)this;


		background = Global.gameBackground;//背景画像をとってくる
		//敵の用意
		Enemy.create();
		//プレイヤーの用意
		Figure.create(new Player(), 500, 600);
	}

	/*背景の描画*/
	protected void drawBackground(Graphics g){
		//背景画像を描画する
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(this.background, null, 0, 0);
	}
}