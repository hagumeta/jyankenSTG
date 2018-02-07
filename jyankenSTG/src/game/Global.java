package game;
import java.awt.Image;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.figs.JyankenCounter;
import game.figs.Player;
import game.figs.bullets.EnemyBullet;
import game.figs.enemies.Enemy;
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

	/*パフォーマンスモード(背景の描画をしないとか)*/
	public static boolean peformanceMode;


	/*じゃんけんカウンター(一回の挑戦で何回じゃんけんしたか)*/
	public static JyankenCounter jyankenCounter = null;

	/*キーボードの入力*/
	public static boolean[] keyInput = new boolean[7];

	/*現在稼働中のフレーム*/
	public static HFigureFrame MainFrame;

	/*画像*/
	public static Image imageLock;//グー
	public static Image imageScissors;//チョキ
	public static Image imagePaper;//	パー
	public static Image imageTitle;

	public static Image gameBackground;//ゲームの背景画像

	/*変数初期化*/
	public static void setup(){
		///キーボードの初期化
		initKey();
		///画像のロード
		loadImages();

		///パフォーマンスモードはoffで
		Global.peformanceMode = true;
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
		//グー
		imageLock = loadImageKai("gu.png");
		//チョキ
		imageScissors = loadImageKai("tyoki.png");
		//パー
		imagePaper = loadImageKai("pa.png");
		//タイトル
		imageTitle = loadImageKai("TitleBack.png");
		//背景
		gameBackground = loadImageKai("back.png");

		/*
		//グー
		imageLock = loadImage("image/gu.png");
		//チョキ
		imageScissors = loadImage("image/tyoki.png");
		//パー
		imagePaper = loadImage("image/pa.png");
		//タイトル
		imageTitle = loadImage("image/TitleBack.png");
		//背景
		gameBackground = loadImage("image/back.png");
		*/
	}

	/*画像1枚ロード*/
	private static Image loadImage(String path){
		try {
			return (Image)ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("★リソースエラー！！\n"+path+"\nのロードに失敗！");
			return null;
		}
	}


	/*画像単体のロード(.jar出力対応ver)*/
	private static Image loadImageKai(String path){
		try {
			//URL(ファイルのURLを取得)
			URL url = (new Global()).getClass().getClassLoader().getResource(path);
			//URLから画像を取り込む

			return  (new JFrame()).createImage((ImageProducer) url.getContent());
			//System.out.println(img.getWidth(null));
/*			//ImageからBufferedImageにムリヤリ変換(文句は言わせん)

			//System.out.println(img.getHeight());

			return new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
*/
		}catch(Exception ex){
			System.out.println("★リソースエラー！！\n"+path+"\nのロードに失敗！");
			return null;
		}
	}

}