package game.figs;

import game.Global;
import game.figs.shapes.ComingSoonText;
import game.figs.shapes.GameClearText;
import game.figs.shapes.GameOverText;
import game.launcher.Launcher;
import game.scenes.Game;
import game.scenes.Title;
import graphics.Vector2;
import graphics.frames.figures.Figure;
import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.Shape;


/*ゲームオーバー時,ゲームクリア時に出力
 * 入力を受け付けてタイトルに戻したりする
 * */
public class Result extends MovingFigure {

	private int waitCount;//待機時間
	private boolean wait;//待機状態か

	private static Result result = null;//リザルト
	/*リザルトが重ならないようにする*/

	public Result(Shape shape){
		super();
		waitCount = 60;
		wait = true;
		this.shape = shape;
	}

	/*---------------------staticメソッド------------------------*/
	/*ゲームオーバー*/
	public static void gameOver(){
		if(result == null){
			result = (Result)Figure.create(new Result(new GameOverText()), new Vector2(250, 350));
		}
	}

	/*ゲームクリア*/
	public static void gameClear(double clearTime){
		if(result == null){
			result = (Result)Figure.create(new Result(new GameClearText(clearTime)), new Vector2(250, 350));
		}
	}

	/*comingsoon!!*/
	public static void comingSoon(){
		if(result == null){
			result = (Result)Figure.create(new Result(new ComingSoonText()), new Vector2(280, 250));
		}
	}



	/*--------------------------更新メソッド-----------------------*/

	public void updateAdd(){
		if(wait){
			/*待機状態*/
			//1秒間キー入力がなかったら解除する
			if(!Global.keyInput[6] && !Global.keyInput[5]){
				waitCount --;
				if(waitCount < 0){
					//待機解除
					wait = false;
				}
			}
		}else{

			///入力受付
			//Xキーでリトライ
			//Cキーでタイトルに戻る
			if(Global.keyInput[6]){//C
				result = null;
				Global.MainFrame.end();//現在のゲームシーンの破棄
				Launcher.sceneMove(new Title());//タイトルへ戻る
			}else{
				if(Global.keyInput[5]){//X
					result = null;
					Global.MainFrame.end();//現在のゲームシーンの破棄
					Launcher.sceneMove(new Game());//ゲームをもう一度
				}
			}
		}
	}
}