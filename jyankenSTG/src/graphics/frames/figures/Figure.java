package graphics.frames.figures;
import java.awt.Graphics;

import graphics.Vector2;
import graphics.frames.figures.shapes.Shape;
/*
 * HFigureFrameに投げる時のオブジェクト単位.
 * 描画される時の形と可視性、座標を持つ.
 */
public class Figure {
	public Shape shape;//自分の形
	public Vector2 position;//自分の座標
	public boolean visible = true;//可視性


	/*コンストラクタ*/
	public Figure(Shape shape, Vector2 position){
		this.shape = shape;
		this.position = position;
	}
	public Figure(){
		this.shape = null;
		this.position = Vector2.ZERO;
	}


	/*座標を変更する*/
	public void setPosition(int x, int y){
		this.position.x = x;
		this.position.y = y;
	}


	/*自身を描画*/
	public void draw(Graphics g){
		if(this.visible && shape != null){
			this.shape.draw(g, position);
		}
	}
}