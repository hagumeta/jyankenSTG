package graphics;

import java.awt.Color;

import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.Text;
import kusoelmo.Test_Title;
import kusoelmo.Title;


public class GameOver extends MovingFigure {
	public GameOver(){
		this.shape = new Text("GAME OVER \n ", Color.red);
		this.setPosition(0, 0);
		((Text)this.shape).setFontSize(50);
	}

	//Xキーでリトライ
	//Cキーでタイトルに戻る
	public void updateAdd(){
		if(Global.keyInput[6]){//C
			Global.MainFrame.end();
			Test_Title.sceneMove(new Title());
		}else{
			if(Global.keyInput[5]){//X
				Global.MainFrame.end();
				Test_Title.sceneMove(new Game());
			}
		}
	}
}