package game.figs.shapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Vector2;
import graphics.frames.figures.shapes.Shape;

/*GameOver時に表示する文字とか*/
public class GameOverText extends Shape {
	private Font fontCap = new Font(Font.SANS_SERIF, Font.BOLD, 80);//GameOver用フォント
	private Font fontMenu = new Font(Font.SANS_SERIF, Font.BOLD, 40);//メニュー用フォント


	/*コンストラクタ*/
	public GameOverText(){
		this.filled = false;
		this.color = Color.red;
		this.visible = true;
	}

	/*描画(塗りつぶしfilledは常にfalse)*/
	public void drawSelf(Graphics g, Vector2 pos){
		//がめおべら描画
		g.setFont(fontCap);
		g.setColor(Color.BLACK);//影の描画
		g.drawString("GAMEOVER", pos.x+7, pos.y+7);
		g.setColor(this.color);
		g.drawString("GAMEOVER", pos.x, pos.y);

		//メニュー描画
		g.setFont(fontMenu);
		g.setColor(Color.black);
		g.drawString("RETRY : X", pos.x+3, pos.y+153);
		g.drawString("BACK TO TITLE : C", pos.x+3, pos.y+203);
		g.setColor(this.color);
		g.drawString("RETRY : X", pos.x, pos.y+150);
		g.drawString("BACK TO TITLE : C", pos.x, pos.y+200);
	}
	public void drawSelfWithFilled(Graphics g, Vector2 pos){}
}
