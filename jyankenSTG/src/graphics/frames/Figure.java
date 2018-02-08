package graphics.frames;
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
	public boolean enable = true;//存在しているかどうか(falseだと描画も更新もされず，存在しない扱いとなる)


	//////-----------------*staticメソッド-------------------------*///////


	/*インスタンスFigureの生成
	 * FigureインスタンスをHFigureFrameにアタッチする
	 * */
	public static Figure create(Figure fig, Vector2 vec){
		return Figure.create(fig, vec.x, vec.y);
	}
	public static Figure create(HFigureFrame frame, Figure fig, Vector2 vec){
		return Figure.create(frame, fig, vec.x, vec.y);
	}
	public static Figure create(Figure fig, int x, int y){
		//現在のMainFrameに返す
		return create(HFigureFrame.MainFrame, fig, x, y);
	}
	public static Figure create(HFigureFrame frame, Figure fig, int x, int y){
		//座標のセット
		fig.position.x = x;
		fig.position.y = y;
		return create(frame, fig);
	}
	public static Figure create(HFigureFrame frame, Figure fig){
		if(frame != null){
			//Frameに入れる
			frame.add(fig);
			//figureを返す
			return fig;
		}else{
			System.out.println("★エラー！！\n指定したframeがないぞ");
			return null;
		}
	}
	public static Figure create(Figure fig){
		//現在のMainFrameに入れる
		return create(HFigureFrame.MainFrame, fig);
	}


	/*インスタンスFigureの削除
	 * HFigureFrameからFigureを抹消する(後はガベコレ任せ)
	 * */
	public static void destroy(HFigureFrame frame, Figure fig){
		if(frame != null){
			//選択したFrameから消す.
			frame.remove(fig);
			//存在しない扱い
			fig.enable = false;
		}else{
			System.out.println("★エラー！！\n指定したframeがないぞ");
		}
	}
	public static void destroy(Figure fig){
		//現在のメインフレームに返す
		destroy(HFigureFrame.MainFrame, fig);
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