package graphics;

import java.awt.Color;

public class JyankenBullet extends Bullet {
	public int jyanken;//じゃんけん属性
	/*
	 * 0 グー
	 * 1 チョキ
	 * 2 パー
	 */

	public JyankenBullet(int jyanken){
		super();
		this.jyanken = jyanken;

		//じゃんけん属性によって見た目を変える
		switch(jyanken){
		case 0://グー
			//this.shape = (Shape)(new Image(Global.imageLock));
			this.shape.color = Color.red;
			break;
		case 1://チョキ
			//this.shape = (Shape)(new Image(Global.imageScissors));
			this.shape.color = Color.blue;
			break;
		case 2://パー
			//this.shape = (Shape)(new Image(Global.imagePaper));
			this.shape.color = Color.green;
		}
	}
}