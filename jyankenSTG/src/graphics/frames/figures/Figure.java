package graphics.frames.figures;
import java.awt.Graphics;

import game.Global;
import graphics.Vector2;
import graphics.frames.figures.shapes.Shape;
/*
 * HFigureFrameに投げる時のオブジェクト単位.
 * 描画される時の形と可視性、座標を持つ.
 */
public class Figure {
	public Shape shape;//自分の形
	public Vector2 position;//自分の座標
	public boolean enable = true;//存在しているかどうか(falseだと描画も更新もされず，存在しない扱いとなる)


	//////-----------------*staticメソッド-------------------------*///////
	/*インスタンスFigureの生成*/
	public static Figure create(Figure fig, Vector2 vec){
		return Figure.create(fig, vec.x, vec.y);
	}
	public static Figure create(Figure fig, int x, int y){
		//座標のセット
		fig.position.x = x;
		fig.position.y = y;
		//現在稼働中のFrameに入れる
		Global.MainFrame.add(fig);
		//一応figureを返す(役立ちそう)
		return fig;
	}
	public static Figure create(Figure fig){
		//現在稼働中のFrameに入れる
		Global.MainFrame.add(fig);
		//figureを返す
		return fig;
	}

	/*インスタンスFigureの削除*/
	public static void destroy(Figure fig){
		//現在稼働中のFrameから消す.
		Global.MainFrame.remove(fig);
		//存在しない扱い
		fig.enable = false;
	}


	/////------------------*コンストラクタ*------------------------////
	public Figure(Shape shape, Vector2 position){
		this.shape = shape;
		this.position = position;
	}
	public Figure(){
		this.shape = null;
		this.position = new Vector2(0,0);
	}

	/////-----------------*publicメソッド*---------------------------////
	/*座標を変更する*/
	public void setPosition(int x, int y){
		this.position.x = x;
		this.position.y = y;
	}


	/*自身を描画*/
	public void draw(Graphics g){
		if(this.enable && shape != null){
			this.shape.draw(g, position);
		}
	}
}