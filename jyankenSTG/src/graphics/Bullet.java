package graphics;

import java.awt.Color;

import graphics.frames.figures.Figure;
import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.Circle;

public class Bullet extends MovingFigure{

	public Bullet(){
		this.shape = new Circle(10, Color.gray, true);
		this.position = new Vector2(0, 0);
	}
	protected void updateAdd(){
		///自身が画面外にいたら削除する.
		if(Global.MainFrame.width+50 < this.position.x || -50 > this.position.x
				|| Global.MainFrame.height+50 < this.position.y || -50 > this.position.y){
			Figure.destroy(this);
		}
	}
}