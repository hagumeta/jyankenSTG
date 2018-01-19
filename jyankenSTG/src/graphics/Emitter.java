package graphics;

import java.awt.Color;

import graphics.frames.HFigureFrame;
import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.Circle;

/*
 * 爆発エフェクトを起こす
 * 具体的には円が四方八方に飛び散る.
 * */
public class Emitter {
	HFigureFrame frame;//対象のHFigureFrame

	public Emitter(HFigureFrame frame){
		this.frame = frame;
	}

	public void burst(int x, int y, int num){
		MovingFigure[] f = new MovingFigure[num];
		for(int i=0; i<num; i++){
			f[num].setPosition(x, y);
			this.frame.add(f[num]);
			f[num].shape = new Circle(15, Color.blue, true);
			f[num].setSpeed(10, 360/num*i);
		}
	}
}