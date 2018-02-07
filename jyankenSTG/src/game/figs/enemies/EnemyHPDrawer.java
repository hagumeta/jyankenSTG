package game.figs.enemies;

import game.Global;
import game.figs.shapes.HPbar;
import graphics.frames.figures.MovingFigure;

/*敵のHPを取得して描画するFigure
 * HPバーを表示する
 * */
public class EnemyHPDrawer extends MovingFigure {

	public EnemyHPDrawer(int enemyMaxHP){
		super();
		this.shape = new HPbar(enemyMaxHP);
	}

	//ボスのHPを更新して描画
	public void updateAdd(){
		((HPbar)this.shape).setHP(Global.Boss.HP);
	}
}