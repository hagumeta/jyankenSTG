package graphics;

import bullet.EnemyBullet;

public class Enemy_normal extends Enemy {
	private int jyankenChange = 0;
	public int count = 0;//ショット間隔
	public double spd = 5.0;//敵弾のスピード
	public int direction = 0;//敵弾の打つ方向

	public Enemy_normal(){
		this.HP = 35;
	}
	public void behave(){
		count++;
		if(count % 35 == 0){
			//自機狙い扇弾
			int dir = Vector2.getDirection(this.position, Global.player.position);//自機狙い
			System.out.println(dir);
			for(int i=0; i<13; i++){
				EnemyBullet.shot(jyankenChange, this.position, new Vector2(spd, dir - 60 + 10*i));
			}

			if(HP <= 20){
				//自機狙い弾(個別)扇弾3つ追加
				for(int i=0; i<2; i++){
					EnemyBullet.shot(jyankenChange, this.position, new Vector2(spd*2, dir-10+20*i));
				}
				EnemyBullet.shot((jyankenChange+1)%3, this.position, new Vector2(spd*1.2, dir+Mathf.randomRange(-5, 5)));

				if(HP <= 7){
					//加速
					count++;
				}
			}
		}
		if(count >= 105){
			//じゃんけん属性変更
			jyankenChange ++;
			jyankenChange %= 3;
		}

		if(count >= 240){
			//瞬間移動
			this.position = new Vector2(Mathf.randomRange(0, Global.MainFrame.width-this.radius), Mathf.randomRange(0, 100));
			count=0;
		}


	}

}
