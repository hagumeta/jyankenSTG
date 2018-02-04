package graphics;

import bullet.EnemyBullet;

/*敵(Easy)
 * 拡散攻撃で攻撃してくる
 * */
public class Enemy_easy extends Enemy {
	private int jyankenChange = Mathf.randomRange(0, 2);
	public int count = 0;//ショット間隔
	public double spd = 5.0;//敵弾のスピード
	public int direction = 0;//敵弾の打つ方向

	public Enemy_easy(){
		super(30);
		System.out.println(
				"☆Easy☆\nじゃんけん属性の相性を考えて弾を打つのが勝利への近道！\n"
				+ "やみくもに打っても打ち消されるだけだから気を付けて!"
				);
	}
	public void behave(){
		if(count % 2 == 0){
			//発射位置を微妙にずらす
			Vector2 vec = new Vector2(this.centerPos.x+Mathf.randomRange(-30, 30), this.centerPos.y+Mathf.randomRange(-30, 30));
			//全方位拡散
			EnemyBullet.shot(jyankenChange, vec, new Vector2(spd, Mathf.randomRange(0, 360)));
			EnemyBullet.shot(jyankenChange, vec, new Vector2(spd, Mathf.randomRange(0, 360)));
		}
		if(count >= 120){
			//じゃんけん属性変更
			jyankenChange = (jyankenChange+2)%3;
			count=0;
		}
		if(HP <= 15){
			this.spd = 6.5;//少し早く
			if(count % 30 == 0){
				//上から落石的なの(多少の運ゲー化を狙う)
				EnemyBullet b = EnemyBullet.shot(jyankenChange, this.centerPos, new Vector2(spd*2.5, Mathf.randomRange(30, 150)));
				b.setAccelerate(1, 270);
			}

			//加速
			count++;

		}
		count++;

		//ぷるぷるさせる
		this.position = new Vector2(this.position.x+Mathf.randomRange(-2, 2), this.position.y+Mathf.randomRange(-2, 2));
	}

}
