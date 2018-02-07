package game.figs;
import java.awt.Color;

import game.Global;
import game.figs.bullets.Bullet;
import game.figs.bullets.EnemyBullet;
import game.figs.bullets.JyankenBullet;
import game.figs.bullets.PlayerBullet;
import graphics.BoolUtil;
import graphics.Vector2;
import graphics.frames.figures.Figure;
import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.Circle;

public class Player extends MovingFigure{
	protected int moveSpeed = 5;//動くスピード
	protected int shotCount = 0;//ショットカウンタ
	protected int shotDig	  = 8;//ショット間隔(フレーム)

	public Vector2 centerPos;//自身の中心座標
	protected int radius = 30;//自身の半径
	protected int colRad = 10;//自身のあたり判定の半径

	/*コンストラクタ*/
	public Player(){
		this.shape = new Circle(30, Color.blue, true);
		this.position = new Vector2(200, 200);
		this.speed = new Vector2(0,0);
		this.enable = true;
		this.frozen = false;

		this.centerPos = this.position;

		//プレイヤーをグローバル設定
		Global.player = this;
	}


	/*自機の更新*/
	protected void updateAdd()
	{

		//動き
		move();

		//当たり判定
		checkCollide();

		//ショットマネージャ
		shotManage();
	}

	private void shotManage(){
		/*カウンタがたまるまでは弾は打てない*/
		if(shotCount >= 10){
			if(Global.keyInput[4]){//Z
				shot(new PlayerBullet(0));//グー
				return;
			}
			if(Global.keyInput[5]){//X
				shot(new PlayerBullet(1));//チョキ
				return;
			}
			if(Global.keyInput[6]){//C
				shot(new PlayerBullet(2));//パー
				return;
			}
		}else{
			//カウンタを一つ増やす
			shotCount++;
		}

		///画面外から戻す
		constrain();
	}

	/*ショット*/
	private void shot(JyankenBullet bul){
		//弾を生成して真上にスピードセット
		Bullet bul1 = (Bullet)Figure.create(bul, this.position.x+10, this.position.y+10);
		bul1.setSpeed(30, 90);
		//カウンタを0に
		shotCount = 0;
	}

	/*自身のあたり判定*/
	private void checkCollide(){
		//敵弾と
		for(int i=0; i<Global.EnemyBullets.length; i++){
			EnemyBullet eb = Global.EnemyBullets[i];
			if(eb.enable){
				if(Vector2.getDisPow(this.centerPos, eb.centerPos) < Math.pow(this.colRad+eb.radius, 2)){
					//衝突
					this.death();
					break;
				}
			}
		}
	}

	/*自機の死亡*/
	private void death(){
		this.enable = false;
		//ゲームオーバー
		Result.gameOver();
	}


	/*自機の動き*/
	int dir;//動く方向
	private void move(){
		//横方向
		int h = BoolUtil.toInteger(Global.keyInput[3]) - BoolUtil.toInteger(Global.keyInput[2]);
		//縦方向
		int v = BoolUtil.toInteger(Global.keyInput[0]) - BoolUtil.toInteger(Global.keyInput[1]);

		if(h == 0 && v == 0){
			///ベクトル入力なし
			super.setSpeed(Vector2.ZERO);
		}else{
			///ベクトル入力あり
			//入力の正規化を行う
			dir = Vector2.getDirection(new Vector2(h, v));
			//スピードを変更
			super.setSpeed(moveSpeed, dir);
		}
		//自身の中心座標の更新
		this.centerPos = new Vector2(this.position.x + this.radius, this.position.y + this.radius);
	}

	/*自機を画面外から戻す*/
	private void constrain(){
		if(this.centerPos.x < 0){
			this.setPosition(-this.radius, this.position.y);
		}
		if(this.centerPos.x > Global.MainFrame.width){
			this.setPosition(Global.MainFrame.width-this.radius, this.position.y);
		}
		if(this.centerPos.y < 0){
			this.setPosition(this.radius, this.radius);
		}
		if(this.centerPos.y > Global.MainFrame.height){
			this.setPosition(this.position.x, Global.MainFrame.height-this.radius);
		}

	}
}