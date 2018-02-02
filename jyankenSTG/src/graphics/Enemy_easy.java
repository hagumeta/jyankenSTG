package graphics;

import bullet.EnemyBullet;

public class Enemy_easy extends Enemy {
	private int jyankenChange = 0;
	public int count = 0;//ショット間隔
	public double spd = 5.0;//敵弾のスピード
	public int direction = 0;//敵弾の打つ方向

	public Enemy_easy(){
		this.HP = 30;
	}
	public void behave(){
		if(count % 2 == 0){
			Vector2 vec = new Vector2(this.centerPos.x+Mathf.randomRange(-30, 30), this.centerPos.y+Mathf.randomRange(-30, 30));
			EnemyBullet.shot(jyankenChange, vec, new Vector2(spd, Mathf.randomRange(180, 360)));
		}
		if(count >= 120){
			//じゃんけん属性変更
			jyankenChange = (jyankenChange+2)%3;
			count=0;
		}
		if(HP <= 10){
			//加速
			count++;
		}
		count++;

		//ぷるぷるさせる
		this.position = new Vector2(this.position.x+Mathf.randomRange(-2, 2), this.position.y+Mathf.randomRange(-2, 2));
	}

}
