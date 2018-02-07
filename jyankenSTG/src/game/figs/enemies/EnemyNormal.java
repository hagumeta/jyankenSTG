package game.figs.enemies;

import game.Global;
import game.figs.bullets.EnemyBullet;
import graphics.Mathf;
import graphics.Vector2;

public class EnemyNormal extends Enemy {
	private int jyankenChange = Mathf.randomRange(0, 2);;
	public int count = 0;//ショット間隔
	public double spd = 5.0;//敵弾のスピード
	public int direction = 0;//敵弾の打つ方向

	public EnemyNormal(){
		super(35);
		System.out.println(
				"\n\n☆Noral☆\n相手も作戦を考えて打ってきているぞ！\n相手の手を見て打つ属性を考えよう！\n"
				+ "移動して攻撃するから深追いするのは危険だぞ！"
				);
	}
	public void behave(){
		count++;
		if(count % 40 == 0){
			//自機狙い扇弾
			int dir = Vector2.getDirection(this.centerPos, Global.player.position);//自機狙い
			for(int i=0; i<13; i++){
				EnemyBullet.shot(jyankenChange, this.centerPos, new Vector2(spd, dir - 60 + 10*i));
			}
			if(HP > 25){
				//じゃんけん属性変更
				jyankenChange += 2;
				jyankenChange %= 3;
			}

			if(HP <= 25){
				//自機狙い弾(個別)扇弾3つ追加
				for(int i=0; i<2; i++){
					EnemyBullet.shot(jyankenChange, this.centerPos, new Vector2(spd*2, dir-10+20*i));
				}
				EnemyBullet.shot((jyankenChange+2)%3, this.centerPos, new Vector2(spd*1.2, dir+Mathf.randomRange(-5, 5)));

				if(count % 120 == 0){
					//じゃんけん属性変更
					jyankenChange +=2;
					jyankenChange %= 3;
				}

				if(HP <= 10){
					//加速
					count++;
				}


			}
		}


		if(count >= 240){
			//瞬間移動
			this.position = new Vector2(Mathf.randomRange(0, Global.MainFrame.width-this.radius), Mathf.randomRange(0, 100));
			count=0;
		}


	}

}
