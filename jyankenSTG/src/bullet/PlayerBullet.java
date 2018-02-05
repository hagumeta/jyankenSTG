package bullet;

import graphics.Enemy;
import graphics.Global;
import graphics.Vector2;

public class PlayerBullet extends JyankenBullet{
	public PlayerBullet(int jyanken){
		super(jyanken);
		this.radius = 15;
	}

	protected void updateAdd(){
		super.updateAdd();

		//*---------当たり判定チェック-----------*//
		//敵弾と
		for(int i=0; i<Global.EnemyBullets.length; i++){
			EnemyBullet eb = Global.EnemyBullets[i];
			if(!this.enable){
				break;
			}
			if(eb.enable){
				if(Vector2.getDisPow(this.centerPos, eb.centerPos) < Math.pow(this.radius+eb.radius, 2)){
					//衝突
					collisionWithEnemyBullet(eb);
					//break;
				}
			}
		}

		//敵とのあたり判定
		if(Global.Boss != null){
			if(Global.Boss.enable && Global.Boss.start && this.enable){
				if(Vector2.getDisPow(this.centerPos, Global.Boss.centerPos) < Math.pow(this.radius+Global.Boss.radius, 2)){
					collisionWithEnemy(Global.Boss);
				}
			}
		}
	}

	/*敵弾と当たった時の処理*/
	private void collisionWithEnemyBullet(EnemyBullet eb){
		switch(Janken.judge(this.jyanken, eb.jyanken)){
		case 0:			//あいこ
			//どちらも削除
			this.delete();
			eb.delete();
			break;
		case 1:			//自機弾の勝ち
			//敵弾を削除
			eb.delete();
			break;
		case 2:			//敵弾の勝ち
			//自機弾を削除
			this.delete();
			break;
		}
		//じゃんけんカウンタをふやす
		if(Global.jyankenCounter != null){
			Global.jyankenCounter.addCount();
		}
	}

	/*ボス敵と当たった時の処理*/
	private void collisionWithEnemy(Enemy en){
		//相手のHPを1減らして0になったら消す
		en.HP--;
		if(en.HP <= 0){
			//破壊
			Global.Boss.destroy();
		}
		this.delete();
	}
}