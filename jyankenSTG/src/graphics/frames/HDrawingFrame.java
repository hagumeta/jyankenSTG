package graphics.frames;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

abstract public class HDrawingFrame extends JPanel implements Runnable{
	//スレッド定義
	Thread thread = null;
	protected int frameRate;//一秒間に再描画する回数
	protected long time;//描画の間隔時間
	public boolean clearPast;//更新時に前の描画を消すか

	public int width;//横幅
	public int height;//縦幅

	public Image background;//背景画像

	private boolean enable;//更新, 描画が有効か
	private boolean activate;//falseにすると描画更新が終わる(startで再開できるが)
	/*コンストラクタ*/
	public HDrawingFrame(int width, int height, int frameRate){
		/*
		 * width 横幅
		 * height 縦幅
		 * frameRate 1秒間の更新回数
		 */
		super.setPreferredSize(new Dimension(width, height));
		this.height = height;
		this.width  = width;

		this.frameRate = frameRate;
		this.clearPast = true;
		setFrameRate(frameRate);

	}

	//---------------/*以下オーバーライド用メソッド*/---------------//

	/*初期化*/
	abstract protected void init();

	/*更新はここに書く*/
	abstract protected void update();

	/*描画はここに書く*/
	abstract protected void draw(Graphics g);


	//---------------/*以下finalメソッド*/---------------//

	/*フレームレートの設定*/
	final public void setFrameRate(int rate){
		time = 1000/rate;
	}
	/*現在のフレームレートを返す*/
	final public int getFrameRate(){
		return frameRate;
	}

	/*更新ループ*/
	final public void run(){
		while(activate){
			//描画が有効なら描画, 更新を行う.
			if(enable){
				//描画/更新
				update();
				repaint();
			}
			//次の再描画の時間まで待つ
			try{
				thread.sleep(time);
			}catch(java.lang.InterruptedException e){}
		}
	}

	/*描画放り投げ*/
	final public void paintComponent(Graphics g){
		//前の描画を消すなら, 背景を上から再描画して塗りつぶしで消す.
		if(clearPast){
			super.paintComponent(g);
		}
		//背景の描画
		if(this.background != null){
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(this.background, 0, 0, null);
		}
		draw(g);
	}

	/*フレームの初期化、およびスタート*/
	final public void start(){
		init();//初期化
		enable = true;
		activate = true;
		thread = new Thread(this);
		thread.start();
	}

	/*フレームの背景を設定*/
	final public void setBackground(Image back){
		this.background = back;
	}


	/*(ちょっとした)更新/描画のストップ*/
	final public void stop(){
		if(activate){
			enable = false;
		}
	}

	/*(ちょっとした)更新/描画の再開*/
	final public void resume(){
		if(activate){
			enable = true;
		}
	}

	/*更新/描画の終了(もう再開しないことを想定(一応もう一度startを呼ぶことで再開できる))*/
	final public void end(){
		activate = false;
	}
}