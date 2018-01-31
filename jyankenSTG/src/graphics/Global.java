package graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bullet.EnemyBullet;
import graphics.frames.HFigureFrame;

public class Global {
	/*グローバル変数を置いておくクラス*/


	/*キーボードの入力*/
	public static boolean[] keyInput = new boolean[7];

	/*現在稼働中のフレーム*/
	public static HFigureFrame MainFrame;

	/*画像*/
	public static BufferedImage imageLock;//グー
	public static BufferedImage imageScissors;//チョキ
	public static BufferedImage imagePaper;//	パー


	/*コンストラクタ*/
	public Global(){
		///キーボードの初期化
		initKey();
		///画像のロード
		loadImages();

	}


	/*キーボードの初期化*/
	public void initKey(){
		for(int i=0; i<7; i++){
			keyInput[i] = false;
		}
		/*
		 0 : ↑
		 1 : ↓
		 2 : ←
		 3 : →
		 4 : V
		 5 : B
		 6 : N
		*/

	}

	/*敵弾の集合(当たり判定の処理用)*/
	public static EnemyBullet EnemyBullets[] = new EnemyBullet[200];

	/*ボス敵(当たり判定の処理用)*/
	public static Enemy Boss;


	/*画像の読み取り*/
	public void loadImages(){
		try {
			BufferedImage imageLock = ImageIO.read(new File("C:\\beach.jpg"));
		} catch (IOException e) {
			System.out.println("画像ロード失敗!");
		}
		try {
			BufferedImage imageScissors = ImageIO.read(new File("C:\\beach.jpg"));
		} catch (IOException e) {
			System.out.println("画像ロード失敗!");
		}
		try {
			BufferedImage imagePaper = ImageIO.read(new File("C:\\beach.jpg"));
		} catch (IOException e) {
			System.out.println("画像ロード失敗!");
		}
	}

}