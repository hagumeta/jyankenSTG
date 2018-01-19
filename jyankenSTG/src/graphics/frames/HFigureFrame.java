
package graphics.frames;

import java.awt.Graphics;
import java.util.Vector;

import graphics.frames.figures.Figure;
import graphics.frames.figures.Updatable;
/*
 * HGraphicsFrameを制限した、Figure特化拡張版
Figureを格納し、自分でFigureたちの描画更新を行う.
*/

public class HFigureFrame extends HDrawingFrame{
	//今表示されているFigureを格納しておくリスト
	private Vector<Figure> figures = new Vector<Figure>(0);

	/*コンストラクタ*/
	public HFigureFrame(int width, int height, int frameRate){
		/*
		 * width 横幅
		 * height 縦幅
		 * frameRate 1秒間の更新回数
		 */
		super(width, height, frameRate);
	}

	//---------------/*以下オーバーライドしてもいいメソッド(任意)*/---------------//

	/*Figure以外に描画するものがあればここに(drawの代替メソッド)*/
	protected void drawAdditional(Graphics g){}

	/*更新はコイツ自身しない*/
	protected void update(){}
	protected void init(){}



	//---------------/*以下finalメソッド*/---------------//

	/*格納されたshapeをそれぞれ描画*/
	final protected void draw(Graphics g){
		///各shapeの描画/更新(Updatableであれば)
		for(int i=0; i<figures.size(); i++){
			Figure fig = figures.get(i);
			fig.draw(g);
			//自動更新可能なオブジェクトなら更新(Updatableインターフェース継承されてるかどうか)
			if(fig instanceof Updatable){
				((Updatable)fig).update();
			}
		}

		//追加の描画(任意)
		drawAdditional(g);
	}


	/*figureを追加する*/
	final public void add(Figure s){
		figures.add(s);
	}
	/*指定のfigureを消す*/
	final public void remove(Figure s){
		figures.remove(s);
	}
	/*全てのshapeを画面上から消す*/
	final public void removeAll(){
		figures.clear();
	}
}
