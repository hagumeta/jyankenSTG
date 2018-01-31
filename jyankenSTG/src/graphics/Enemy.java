package graphics;

import java.awt.Color;

import bullet.Bullet;
import bullet.EnemyBullet;
import graphics.frames.figures.Figure;
import graphics.frames.figures.shapes.Circle;

public class Enemy extends Bullet {
	public int count = 0;//ショット間隔
	public int jyanken = 0;//じゃんけん属性
	public double spd = 7.0;//敵弾のスピード
	public int direction = 0;//敵弾の打つ方向

	public int HP;//HP

	public Enemy(){
		super();
		this.shape = new Circle(100, Color.BLACK, true);
		this.position = new Vector2(0, 0);
		this.speed = new Vector2(0, 0);
		this.accelerate = new Vector2(0, 0);
		this.HP = 20;
		this.radius = 100;

		Figure.create(new Enemy_HP(), new Vector2(500, 50));

		//自身をボス敵に設定する
		Global.Boss = this;
		}
	public void behave(){
		count++;
		if(count >= 3){
			//ショット
			if(HP >= 10){
				//うずまき
				EnemyBullet.shot(jyanken, this.centerPos, new Vector2(spd, direction));
				EnemyBullet.shot(jyanken, this.centerPos, new Vector2(spd, 360-direction));
			}else{
				//シャワー
				EnemyBullet eb1 = EnemyBullet.shot(jyanken, this.centerPos, new Vector2(spd*2, Mathf.randomRange(30,150)));
				eb1.accelerate = new Vector2(0, 1);
				EnemyBullet eb2 = EnemyBullet.shot(jyanken, this.centerPos, new Vector2(spd*2, Mathf.randomRange(30,150)));
				eb2.accelerate = new Vector2(0, 1);
			}
			count = 0;
			direction += 10;

			//じゃんけん属性の変更
			jyanken++;
			jyanken %= 3;
		}
	}

}
