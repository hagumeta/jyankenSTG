package bullet;


import java.awt.Color;

import graphics.Global;
import graphics.Vector2;
import graphics.frames.figures.Figure;
import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.Circle;

public class Bullet extends MovingFigure{

	public Bullet(){
		this.shape = new Circle(10, Color.gray, true);
		this.position = new Vector2(0, 0);
	}

	//中心座標
	public Vector2 centerPos = new Vector2(0,0);//中心座標
	public int radius = 10;//半径

	protected void updateAdd(){
		///自身が画面外にいたら削除する.
		if(Global.MainFrame.width+50 < this.position.x || -50 > this.position.x
				|| Global.MainFrame.height+50 < this.position.y || -50 > this.position.y){
			delete();
		}

		this.centerPos = new Vector2(this.position.x + this.radius , this.position.y + this.radius);
		this.behave();
	}

	///自身の削除方法
	public void delete(){
		Figure.destroy(this);
	}

	//自身の挙動(追加)
	public void behave(){}
}