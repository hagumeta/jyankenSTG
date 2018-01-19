package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Vector2;

/*×印(Shapeの子だが形ではない)*/
public class Cross extends Shape{
	public Vector2 size = new Vector2(10, 10);//×の大きさ(横幅, 縦幅)

	//コンストラクタ
	public Cross(Vector2 size, Color color){
		super(color);
		this.size = size;
	}

	/*描画(塗りつぶしはないのでどちらも同じ)*/
	public void drawSelf(Graphics g, Vector2 pos){
		Vector2 a = new Vector2(size.x/2, size.y/2);
		g.drawLine(pos.x-a.x, pos.y-a.y, pos.x+a.x, pos.y+a.y);
		g.drawLine(pos.x+a.x, pos.y-a.y, pos.x-a.x, pos.y+a.y);
	}
	public void drawSelfWithFilled(Graphics g, Vector2 pos){
		this.drawSelf(g, pos);
	}
}
