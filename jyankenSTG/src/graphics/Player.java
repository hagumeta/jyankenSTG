package graphics;
import java.awt.Color;

import graphics.frames.figures.Figure;
import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.Circle;

public class Player extends MovingFigure{
	int moveSpeed = 5;//動くスピード
	int shotCount = 0;//ショットカウンタ
	int shotDig	  = 30;//ショット間隔(フレーム)

	/*コンストラクタ*/
	public Player(){
		this.shape = new Circle(30, Color.blue, true);
		this.position = new Vector2(200, 200);
		this.speed = Vector2.ZERO;
	}


	/*自機の更新*/
	protected void updateAdd()
	{
		//動き
		move();

		/*カウンタがたまるまでは弾は打てない*/
		if(shotCount >= 30){
			if(Global.keyInput[4]){//V
				shot(new JyankenBullet(0));//グー
			}
			if(Global.keyInput[5]){//B
				shot(new JyankenBullet(1));//チョキ
			}
			if(Global.keyInput[6]){//N
				shot(new JyankenBullet(2));//パー
			}
		}else{
			//カウンタを一つ増やす
			shotCount++;
		}
	}


	/*ショット*/
	private void shot(JyankenBullet bul){
		//弾を生成して真上にスピードセット
		Bullet bul1 = (Bullet)Figure.create(bul, this.position.x+10, this.position.y+10);
		bul1.setSpeed(30, 90);
		//カウンタを0に
		shotCount = 0;
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
	}

}