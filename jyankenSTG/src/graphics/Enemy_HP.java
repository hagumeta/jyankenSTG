package graphics;

import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.HPbar;

/*敵のHPを取得して描画するFigure
 * HPバーを表示する
 * */
public class Enemy_HP extends MovingFigure {

	public Enemy_HP(int enemyMaxHP){
		super();
		this.shape = new HPbar(enemyMaxHP);
	}

	//ボスのHPを更新して描画
	public void updateAdd(){
		((HPbar)this.shape).setHP(Global.Boss.HP);
	}
}