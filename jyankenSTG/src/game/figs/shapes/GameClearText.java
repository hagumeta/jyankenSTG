package game.figs.shapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Vector2;
import graphics.frames.figures.shapes.Shape;

/*GameClear時に表示する文字とか*/
public class GameClearText extends Shape {
	private Font fontCap = new Font(Font.SANS_SERIF, Font.BOLD, 80);//クリア＆スコア用フォント
	private Font fontMenu = new Font(Font.SANS_SERIF, Font.BOLD, 40);//メニュー用フォント
	private double clearTime = 0;//クリアタイム

	/*コンストラクタ*/
	public GameClearText(double clearTime){
		this.filled = false;
		this.color = Color.GREEN;
		this.visible = true;
		this.clearTime = clearTime;
	}

	/*描画(塗りつぶしfilledは常にfalse)*/
	public void drawSelf(Graphics g, Vector2 pos){
		//スコアとタイム描画
		g.setFont(fontCap);
		g.setColor(Color.BLACK);//影の描画
		g.drawString("GAMECLEAR!!", pos.x+7, pos.y+7);
		g.drawString("TIME : " + (float)clearTime + " S", pos.x+7, pos.y+107);
		g.setColor(this.color);
		g.drawString("GAMECLEAR!!", pos.x, pos.y);
		g.drawString("TIME : " + (float)clearTime + " S", pos.x, pos.y+100);


		//メニュー描画
		g.setFont(fontMenu);
		g.setColor(Color.black);
		g.drawString("RETRY : X", pos.x+3, pos.y+183);
		g.drawString("BACK TO TITLE : C", pos.x+3, pos.y+233);
		g.setColor(this.color);
		g.drawString("RETRY : X", pos.x, pos.y+180);
		g.drawString("BACK TO TITLE : C", pos.x, pos.y+230);
	}
	public void drawSelfWithFilled(Graphics g, Vector2 pos){}
}
