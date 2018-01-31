package graphics;

import java.awt.Color;

import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.Text;

public class Enemy_HP extends MovingFigure {
	//敵のHPを取得して描画するFigure.
	public Enemy_HP(){
		this.shape = new Text("", Color.BLACK);
		this.setPosition(0, 0);
	}

	//ボスのHPを更新して描画
	public void updateAdd(){
		((Text)this.shape).text = Integer.toString(Global.Boss.HP);
	}
}