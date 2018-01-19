package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Vector2;

/*長方形*/
public class Rectangle extends Shape{
	///ここのdrawではposは左上の座標
	public int width, height;//それぞれのサイズ

	/*コンストラクタ*/
	public Rectangle(int width, int height, Color color, boolean filled){
		super(color, filled);
		this.width = width;
		this.height = height;
	}
	public Rectangle(int width, int height){
		this(width, height, Color.black, true);
	}

	///描画関数
	public void drawSelfWithFilled(Graphics g, Vector2 pos){
		g.fillRect(pos.x, pos.y, width, height);
	}
	public void drawSelf(Graphics g, Vector2 pos){
		g.drawRect(pos.x, pos.y, width, height);
	}

}