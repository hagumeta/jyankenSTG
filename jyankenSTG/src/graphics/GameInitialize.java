package graphics;

import bullet.EnemyBullet;
import graphics.frames.figures.Figure;

public class GameInitialize {

	///ゲームシーンの初期化を行う
	public static void init(){
		///敵弾の準備
		loadEnemyBullets();

		//グローバル変数初期化
		Global.setup();
	}


	//敵弾の準備を行う.
	private static void loadEnemyBullets(){
		//一つずつ生成して配列に格納しておく．
		for(int i=0; i<Global.EnemyBullets.length; i++){
			EnemyBullet bul = new EnemyBullet(0);
			bul.enable = false;
			bul.frozen = false;
			Global.EnemyBullets[i] = (EnemyBullet)Figure.create(bul, 0, 0);
		}
	}
}