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
	private int Time3;
	private int Time4;
	private int Time5;

	//影用のオフセット
	private double offsetX;
	private double offsetY;

	//カウンタ
	private int count = 0;

	private int paturn = 0;//現在のパターン
	/* 0 左右から出てくる
	 * 1 オフセット
	 * 2 待機
	 * 3 オフセット戻す
	 * 4 左右に消える
	 */

	/*コンストラクタ*/
	public GameStartText(int time){
		//不透過度は122（半分くらい透明）で
		this.setAlpha(0);
		this.color = Color.GREEN;

		this.filled = false;
		this.Time0 = time/5;
		this.Time1 = time/10;
		this.Time2 = time/4;//待機
		this.Time3 = time/10;
		this.Time4 = time/10;//オフセット戻す

		this.offsetX = 0;
		this.offsetY = 0;
	}

	@Override
	public void drawSelf(Graphics g, Vector2 pos) {
		g.setFont(font);

		switch(paturn){
		case 0://左右からくるところ
			double a = 800/Time0;
			lX -= a;
			rX -= a;
			if(count >= Time0){
				rX = centerX;
				lX = centerX;
				count = 0;
				paturn = 1;
			}
			break;

		case 1://オフセットを出しつつ影描画
			double b = 8.0/Time1;
			this.offsetX += b;
			this.offsetY += b;
			//影描画
			this.drawShadow(g);
			if(count >= Time1){
				paturn = 2;
				count = 0;
			}
			break;

		case 2://待機
			if(count >= Time2){
				paturn = 3;
				count = 0;
			}
			//影描画
			this.drawShadow(g);
			break;

		case 3://オフセット戻す
			double c = 8.0/Time3;
			this.offsetX -= c;
			this.offsetY -= c;
			//影描画
			this.drawShadow(g);
			if(count >= Time3){
				paturn = 4;
				count = 0;
			}
			break;

		case 4://左右に消える
			int d = 1000/Time2;
			lX += d;
			rX -= d;
			if(count >= Time2){
				//自身を見えなくする
				this.visible = false;
			}
			break;
		}
		count++;

		/*文字の描画*/
		g.setColor(this.color);
		g.drawString("GAME START!!", lX, 350);
		g.drawString("GAME START!!", rX, 350);

	}
	/*影の描画*/
	private void drawShadow(Graphics g){
		g.setColor(Color.BLACK);
		g.drawString("GAME START!!", lX+(int)offsetX, 350+(int)offsetY);
	}

	@Override
	//使用しない
	public void drawSelfWithFilled(Graphics g, Vector2 pos) {}

}
