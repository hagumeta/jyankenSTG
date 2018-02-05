package graphics.frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.Enemy;
import graphics.Global;
import graphics.Player;
import graphics.frames.figures.Figure;

/*ゲームフレーム*/
public class GameFrame extends HFigureFrame {

	public BufferedImage background;//背景画像
	private boolean backEnable = true;//背景を描画するか

	public GameFrame(){
		super(1000, 750, 30);//1秒間に30回更新

		//自身をメインフレームに設定
		Global.MainFrame = (HFigureFrame)this;


		background = Global.gameBackground;//背景画像をとってくる
		//敵の用意
		Enemy.create();
		//プレイヤーの用意
		Figure.create(new Player(), 500, 600);

		///パフォーマンスモード(背景を描画しない)
		if(Global.peformanceMode){
			this.backEnable = false;
		}

	}

	/*背景の描画*/
	protected void drawBackground(Graphics g){

		if(this.backEnable){
			//ノーマルモード(画像を描画) 結構かくつく
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(this.background, null, 0, 0);
		}
		else{
			//パフォーマンスモード(画像を用いない) ぬる
			//ちょっとだけグラデーション
			for(int i=0; i<3; i++){
				g.setColor(new Color(0, 0, (130-25*i)));
				g.fillRect(0, i*200, this.width, 200+i*200);
			}
		}
	}
}