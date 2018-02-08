package game.figs.enemies;

import java.awt.Color;

import game.Global;
import game.figs.GameStart;
import game.figs.Result;
import game.figs.bullets.Bullet;
import graphics.Vector2;
import graphics.frames.Figure;
import graphics.frames.figures.FigText;
import graphics.frames.figures.shapes.Circle;

public class Enemy extends Bullet {

	public int jyanken = 0;//じゃんけん属性

	public int timeCount = 0;//タイムカウント

	public int countDown = 80;//スタートまでの時間
	public boolean start = false;//始まってるかどうか
	private FigText startText;//スタート文字

	public int HP;//HP

	public Enemy(int HP){
		super();
		this.shape = new Circle(100, Color.BLACK, true);
		this.position = new Vector2(0, 0);
		this.speed = new Vector2(0, 0);
		this.accelerate = new Vector2(0, 0);
		this.radius = 100;
		this.timeCount = 0;
		this.HP = HP;

		//HPバーの用意
		Figure.create(new EnemyHPDrawer(this.HP));

		//自身をボス敵に設定する
		Global.Boss = this;

		//スタートの文字を作る
		Figure.create(new GameStart(countDown));
		}


	public void updateAdd(){
		if(start){
			super.updateAdd();
			timeCount++;//タイムカウント＋
			this.behave();
		}else{
			//カウントダウン
			countDown--;
			if(countDown <= 0){
				//スタート
				start = true;
			}
		}
	}
	//自身の挙動(追加)
	public void behave(){}


	/*グローバル変数においてある難易度設定でエネミー作成*/
	public static void create(){
		Vector2 enemyPos = new Vector2(Global.MainFrame.width/2-100, 50);
		switch(Global.difficulty){
		case 0://easy
			Figure.create(new EnemyEasy(), enemyPos);
			break;
		case 1://normal
			Figure.create(new EnemyNormal(), enemyPos);
			break;
		case 2://difficult
			Figure.create(new EnemyDifficult(), enemyPos);
			break;
		case 3://エンドレス(未実装)
			Result.comingSoon();
			System.out.println(
					"\n\n☆Endressモード☆\n"
					+ "すまんなwwwwwwwwwwww");
		}
	}

	/*ボスの撃破*/
	public static void destroy(){
		//ボスを消す
		Figure.destroy(Global.Boss);
		Global.Boss.enable = false;

		//敵弾を全て消す
		//EnemyBullet.deleteAll();

		///ゲームクリア
		//クリアタイムの計算
		double time = (double)Global.Boss.timeCount/30.0;
		Result.gameClear(time);
	}
}
