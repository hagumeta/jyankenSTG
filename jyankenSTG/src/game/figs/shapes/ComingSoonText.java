package game.figs.shapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game.Global;
import graphics.Vector2;
import graphics.frames.figures.shapes.Shape;

/*伝家の宝刀ComingSoonだぜYeah!!*/
public class ComingSoonText extends Shape{
	private Font fontCap = new Font(Font.SANS_SERIF, Font.BOLD, 80);//ComingSoon用フォント
	private Font fontMenu = new Font(Font.SANS_SERIF, Font.BOLD, 40);//メニュー用フォント
	private Font fontMini = new Font(Font.SANS_SERIF, Font.PLAIN, 8);//すまんかった用フォント

	/*コンストラクタ*/
	public ComingSoonText(){
		this.filled = false;
		this.color = Color.ORANGE;
		this.visible = true;
	}

	/*描画(塗りつぶしfilledは常にfalse)*/
	public void drawSelf(Graphics g, Vector2 pos){

		//未実装描画
		g.setFont(fontCap);
		g.setColor(Color.BLACK);//影の描画
		g.drawString("未実装", pos.x+5, pos.y+5);
		g.setColor(this.color);
		g.drawString("未実装", pos.x, pos.y);

		//ComingSoon描画
		g.setColor(Color.BLACK);//影の描画
		g.drawString("ComingSoon!!", pos.x+5, pos.y+105);
		g.setColor(this.color);
		g.drawString("ComingSoon!!", pos.x, pos.y+100);

		//メニュー描画
		g.setFont(fontMenu);
		g.setColor(Color.black);
		g.drawString("RETRY : X", pos.x+3, pos.y+173);
		g.drawString("BACK TO TITLE : C", pos.x+3, pos.y+223);
		g.setColor(this.color);
		g.drawString("RETRY : X", pos.x, pos.y+170);
		g.drawString("BACK TO TITLE : C", pos.x, pos.y+220);

		//すまんかった描画
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(fontMini);
		g.drawString("すまんかった", 2, Global.MainFrame.height-6);
	}
	public void drawSelfWithFilled(Graphics g, Vector2 pos){}
}
