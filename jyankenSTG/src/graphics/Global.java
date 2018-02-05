package graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import bullet.EnemyBullet;
import graphics.frames.HFigureFrame;

public class Global {
	/*グローバル変数を置いておくクラス*/

	//現在のゲームシーンを入れておく
	public static JPanel nowGameScene;

	/*難易度
	 * 0 easy
	 * 1 normal
	 * 2 difficult
	 * 3 endless(未実装)
	 * */
	public static int difficulty=0;


	/*じゃんけんカウンター(一回の挑戦で何回じゃんけんしたか)*/
	public static JyankenCounter jyankenCounter = null;

	/*キーボードの入力*/
	public static boolean[] keyInput = new boolean[7];

	/*現在稼働中のフレーム*/
	public static HFigureFrame MainFrame;

	/*画像*/
	public static BufferedImage imageLock;//グー
	public static BufferedImage imageScissors;//チョキ
	public static BufferedImage imagePaper;//	パー
	public static BufferedImage imageTitle;

	/*変数初期化*/
	public static void setup(){
		///キーボードの初期化
		initKey();
		///画像のロード
		loadImages();
	}


	/*キーボードの初期化*/
	public static void initKey(){
		for(int i=0; i<7; i++){
			keyInput[i] = false;
		}
		/*
		 0 : ↑
		 1 : ↓
		 2 : ←
		 3 : →
		 4 : Z
		 5 : X
		 6 : C
		*/

	}

	/*敵弾の集合(当たり判定の処理用)*/
	public static EnemyBullet EnemyBullets[] = new EnemyBullet[250];//250個用意

	/*ボス敵(当たり判定の処理用)*/
	public static Enemy Boss;

	/*プレイヤー(自機狙い用)*/
	public static Player player;

	/*画像の読み取り*/
	public static void loadImages(){
		try {
			//グー
			imageLock = ImageIO.read(new File("src/gu.png"));
		} catch (IOException e) {
			System.out.println("画像ロード失敗!");
		}
		try {
			//チョキ
			imageScissors = ImageIO.read(new File("src/tyoki.png"));
		} catch (IOException e) {
			System.out.println("画像ロード失敗!");
		}
		try {
			//パー
			imagePaper = ImageIO.read(new File("src/pa.png"));
		} catch (IOException e) {
			System.out.println("画像ロード失敗!");
		}		try {
			//title
			imageTitle = ImageIO.read(new File("src/TitleBack.png"));
		} catch (IOException e) {
			System.out.println("画像ロード失敗!");
		}
	}

}