package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Vector2;

/*楕円*/
public class Ellipse extends Shape{
	///ここではposiionは左上の座標
	public int width, height;//それぞれのサイズ

	/*コンストラクタ*/
	public Ellipse(int width, int height, Color color, boolean filled){
		super(color, filled);
		this.width = width;
		this.height = height;
	}
	public Ellipse(int width, int height){
		super();
		this.width = width;
		this.height = height;
	}

	///描画メソッド
	public void drawSelfWithFilled(Graphics g, Vector2 pos){
		g.fillOval(pos.x, pos.y, width, height);
	}
	public void drawSelf(Graphics g, Vector2 pos){
		g.drawOval(pos.x, pos.y, width, height);
	}
}
