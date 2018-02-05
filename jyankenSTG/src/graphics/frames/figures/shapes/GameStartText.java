package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Global;
import graphics.Vector2;

/*ゲームスタートエフェクト的なの
 * 左右から文字がスッとでてきて合わさり，またもどっていく感じ
 * */
public class GameStartText extends Shape {
	//フォント
	private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 80);

	//センター座標
	private int centerX = Global.MainFrame.width/2 - 300;
	//左右座標
	private int lX = centerX - 800;
	private int rX = centerX + 800;

	/*それぞれに振り分けられる時間*/
	private int Time0;
	private int Time1;
	private int Time2;

	//カウンタ
	private int count = 0;

	private int paturn = 0;//現在のパターン
	/* 0 左右から出てくる
	 * 1 合わさる
	 * 2 左右に消える
	 */

	/*コンストラクタ*/
	public GameStartText(int time){
		//不透過度は122（半分くらい透明）で
		this.setAlpha(0);
		this.color = Color.GREEN;

		this.filled = false;
		this.Time0 = time/4;
		this.Time1 = time*3/4;
		this.Time2 = time/4;
	}

	@Override
	public void drawSelf(Graphics g, Vector2 pos) {
		switch(paturn){
		case 0://左右からくるところ
			int a = 800/Time0;
			lX += a;
			rX -= a;
			if(count >= Time0){
				rX = centerX;
				lX = centerX;
				count = 0;
				paturn = 1;
			}
			break;

		case 1://合わさって待機
			if(count >= Time1){
				paturn = 2;
				count = 0;
			}
			break;

		case 2://左右に消える
			int b = 1000/Time2;
			lX += b;
			rX -= b;
			if(count >= Time2){
				//自身を見えなくする
				this.visible = false;
			}
			break;
		}
		count++;

		/*文字の描画*/
		g.setFont(font);
		g.drawString("GAME START!!", lX, 350);
		g.drawString("GAME START!!", rX, 350);

	}

	@Override
	//使用しない
	public void drawSelfWithFilled(Graphics g, Vector2 pos) {}

}
