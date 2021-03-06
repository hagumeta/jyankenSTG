package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Vector2;

/*swingで描画する形(色等含む)を定義している抽象クラス.
 * Figureの描画方法にShapeが用いられる
 */
abstract public class Shape implements Drawable{

	public Color color;//色
	public boolean filled;//塗りつぶすか
	public boolean visible;//可視性かどうか

	/*コンストラクタ*/
	public Shape(Color color, boolean filled){
		this.color = color;
		this.filled = filled;
		this.visible = true;
	}
	public Shape(Color color){
		this(color, false);
	}
	public Shape(){
		this(Color.BLACK, false);
	}

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