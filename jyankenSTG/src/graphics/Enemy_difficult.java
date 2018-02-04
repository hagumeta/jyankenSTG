package graphics;

import bullet.EnemyBullet;

public class Enemy_difficult extends Enemy {
	private int jyankenChange = 0;
	public int count = 0;//ショット間隔
	public double spd = 6.0;//敵弾のスピード
	public int direction = 0;//敵弾の打つ方向
	public int jyanken = 0;

	public Enemy_difficult(){
		super(50);
		System.out.println(
				"☆Hard☆\nここに挑戦するとはお主強者ですな!\nいままでの成果を見せてやれ！\n"
				+ "攻略のヒントは今一番有利な属性を見分けることだ！\n"
				+ "頑張れよ！"
				);
	}
	public void behave(){
		count++;
		if(HP >= 30){
			if(count % 3 == 0){
				//うずまき
				Vector2 vec = new Vector2(this.centerPos.x-80, this.centerPos.y-80);
				Vector2 vec2= new Vector2(this.centerPos.x+40, this.centerPos.y+40);
				EnemyBullet.shot(jyanken, vec, new Vector2(spd, direction));
				EnemyBullet.shot(jyanken, vec, new Vector2(spd, direction+170));
				EnemyBullet.shot((jyanken+2)%3, vec2, new Vector2(spd, (360-direction)+170));
				EnemyBullet.shot((jyanken+2)%3, vec2, new Vector2(spd, 360-direction));
				//じゃんけん属性の変更
				jyankenChange ++;
				if(jyankenChange >= 30){
					jyanken++;
					jyanken %= 3;
					jyankenChange = 0;
				}
				direction += 10;
				count = 0;
			}
		}else{
			if(HP >= 15){
				///瞬間移動しながら拡散
				///自機狙い拡散
				int dir = Vector2.getDirection(this.centerPos, Global.player.centerPos);//自機狙い方向
				Vector2 vec = new Vector2(this.centerPos.x+Mathf.randomRange(-30, 30), this.centerPos.y+Mathf.randomRange(-30, 30));
				EnemyBullet.shot(jyanken, vec, new Vector2(spd, dir+Mathf.randomRange(-90, 90)));
				if(count % 10 == 0){
					EnemyBullet.shot((jyanken+1)%3, vec, new Vector2(spd, dir+Mathf.randomRange(-90, 90)));
				}
				if(count % 100 == 0){
					//瞬間移動
					this.position = new Vector2(Mathf.randomRange(0, Global.MainFrame.width-this.radius), Mathf.randomRange(0, 100));
					count = 0;
					//属性変更
					jyanken = (jyanken+2)%3;
				}

				}else{
					///見えない敵の弾幕攻撃
					this.shape.visible = false;//見えなくする
					if(count % 25 == 0){
						///自機狙い扇弾

						int dir = Vector2.getDirection(this.centerPos, Global.player.centerPos) + Mathf.randomRange(-15, 15);//自機狙い方向+乱数少し
						for(int i=0; i<5; i++){
							EnemyBullet.shot(jyanken, this.centerPos, new Vector2(spd, dir - 20 + 10*i));
						}
					}
					if(count % 50 == 0){
						//属性変更
						jyanken = (jyanken+2)%3;
					}

					if(count >= 99){
						//噴火
						for(int i=0; i<10; i++){
							EnemyBullet b = EnemyBullet.shot(jyanken, this.centerPos, new Vector2(spd*1.5, i*18));
							b.setAccelerate(1, 270);
						}
						//瞬間移動
						this.position = new Vector2(Mathf.randomRange(0, Global.MainFrame.width-this.radius), Mathf.randomRange(0, 100));
						count = 0;
					}
				}
			}
		}
	}

