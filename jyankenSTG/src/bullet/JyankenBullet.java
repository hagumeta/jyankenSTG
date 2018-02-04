package bullet;


import graphics.Global;
import graphics.frames.figures.shapes.Image;

public class JyankenBullet extends Bullet {
	public int jyanken;//じゃんけん属性
	/*
	 * 0 グー
	 * 1 チョキ
	 * 2 パー
	 */

	public JyankenBullet(int jyanken){
		super();
		this.switchJyanken(jyanken);
	}

	///じゃんけん属性の変更
	public void switchJyanken(int jyanken){
		this.jyanken = jyanken;

		//じゃんけん属性によって見た目を変える
		switch(jyanken){
		case 0://グー
			this.shape = new Image(Global.imageLock);
			//this.shape.color = Color.red;
			break;
		case 1://チョキ
			this.shape = new Image(Global.imageScissors);
			//this.shape.color = Color.blue;
			break;
		case 2://パー
			this.shape = new Image(Global.imagePaper);
			//this.shape.color = Color.green;
		}

	}
}