package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Vector2;

/*swingで描画する形(色等含む)を定義している抽象クラス.*/
abstract public class Shape implements Drawable{

	public Color color = Color.black;//色
	public boolean filled = true;//塗りつぶすか
	public boolean visible = true;//可視性かどうか

	/*コンストラクタ*/
	public Shape(Color color, boolean filled){
		this.color = color;
		this.filled = filled;
	}
	public Shape(Color color){
		this(color, false);
	}
	public Shape(){}

	//-------------/*以下finalメソッド*/-------------//
	/*描画*/
	final public void draw(Graphics g, Vector2 pos){
		if(this.visible){
			g.setColor(color);
			if(filled){
				drawSelfWithFilled(g, pos);
			}else{
				drawSelf(g, pos);
			}
		}
	}

	/*透明度を設定する*/
	final public void setAlpha(float alpha){
		//alphaは0～1までの小数
		color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 255*alpha);
	}
}