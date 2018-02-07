package graphics.frames.figures;

import java.awt.Color;

import graphics.frames.figures.shapes.Text;


///文字を描画するFigure
//更新はされないので注意

public class FigText extends Figure {
	public FigText(String text, Color color){
		this.shape = new Text(text, color);
	}
}
