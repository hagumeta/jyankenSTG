package game.figs;

import game.figs.shapes.GameStartText;
import graphics.frames.Figure;
import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.Shape;

/*ゲームスタート時のエフェクト*/
public class GameStart extends MovingFigure {

	/*コンストラクタ*/
	public GameStart(int countDown){
		super();
		this.shape = (Shape)(new GameStartText(countDown));
	}

	public void updateAdd(){
		/*自分の中のGameStartTextを監視してvisibleがfalseになったら自分を破棄*/
		if(!this.shape.visible){
			Figure.destroy(this);
		}
	}
}
