package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Vector2;

/*円*/
public class Circle extends Shape{
	///ここではposiionは左上の座標
	public int radius;//それぞれのサイズ

	/*コンストラクタ*/
	public Circle(int radius, Color color, boolean filled){
		super(color, filled);
		this.radius = radius;
	}
	public Circle(int radius){
		super();
		this.radius = radius;
	}

	///描画メソッド
	public void drawSelfWithFilled(Graphics g, Vector2 pos){
		g.fillOval(pos.x, pos.y, radius, radius);
	}
	public void drawSelf(Graphics g, Vector2 pos){
		g.drawOval(pos.x, pos.y, radius, radius);
	}
}