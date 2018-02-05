package bullet;

import java.awt.Color;

import graphics.Global;
import graphics.Vector2;
import graphics.frames.figures.shapes.Circle;

/*
 * 敵弾
*/
public class EnemyBullet extends JyankenBullet {
	public EnemyBullet(int jyanken){
		super(jyanken);
		this.radius = 23;
		this.setPosition(0,0);
		this.shape = new Circle(this.radius, Color.BLACK, true);
	}
	//自身の発射(初期位置，初期スピード)
	public static EnemyBullet shot(int jyanken, Vector2 pos, Vector2 spd){
		//敵弾の倉庫の中から使っていないものを探してきてそれを使う
		for(int i=0; i<Global.EnemyBullets.length; i++){
			EnemyBullet eb = Global.EnemyBullets[i];
			//enable(使用中か)でなければそれを弾に起用する
			if(!eb.enable){
				eb.enable = true;
				eb.setPosition(pos.x, pos.y);
				eb.setSpeed(spd);
				eb.switchJyanken(jyanken);
				return eb;
			}
		}
		System.out.println("エラー！！　Global. EnemyBullets　在庫切れです！！");
		return null;
	}

	/*敵弾の全削除*/
	public static void deleteAll(){
		for(int i=0; i<Global.EnemyBullets.length; i++){
			EnemyBullet eb = Global.EnemyBullets[i];
			if(eb.enable){
				eb.delete();
			}
		}
	}

	//自身の削除は自身を無効化することで行う．
	public void delete(){
		this.setPosition(0, 0);
		this.setSpeed(0, 0);
		this.setAccelerate(new Vector2(0,0));
		this.enable = false;
	}
}