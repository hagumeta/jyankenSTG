package kusoelmo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import graphics.Game;
import graphics.Global;
import graphics.frames.HDrawingFrame;


public class Title extends HDrawingFrame{
	private int cursor;
	private JLabel logo, label2;
	private JLabel mode[];
	private JPanel panel1, panel2;
	private int count = 10;
	private int colorcnt = 0;

	public Title() {
		super(1000, 750, 30);
		cursor = 0;
		mode = new JLabel[4];
		mode[0] = new JLabel("CHALLENGE MODE (EASY)");
		mode[1] = new JLabel("CHALLENGE MODE (NORMAL)");
		mode[2] = new JLabel("CHALLENGE MODE (HARD)");
		mode[3] = new JLabel("ENDLESS MODE");
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 1));
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4, 1));
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setLayout(new GridLayout(2, 1));

		mode[0].setBackground(Color.WHITE);
		for(int i = 1; i < 4; i++) {
			mode[i].setBackground(Color.ORANGE);
		}

		LineBorder border = new LineBorder(Color.BLACK, 1, true);
		for(int i = 0; i < 4; i++) {
			mode[i].setFont(new Font("Serif", Font.BOLD, 28));

			mode[i].setForeground(Color.BLACK);
			mode[i].setHorizontalAlignment(JLabel.CENTER);
			mode[i].setOpaque(true);
			mode[i].setBorder(border);
			panel2.add(mode[i]);
		}

		setBackground(Global.imageTitle);
		panel1.setOpaque(false);
		logo = new JLabel("じゃんけんシューティング");
		logo.setFont(new Font("Gothic", Font.BOLD, 40));
		logo.setForeground(Color.MAGENTA);
		logo.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(logo);
		label2 = new JLabel("矢印キー↑↓で選択　Zで開始");
		label2.setFont(new Font("Gothic", Font.PLAIN, 24));
		label2.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(label2);

		add(panel1);
		add(panel2);
		this.start();
	}

	private void cursorUp() {
		if(count >= 10){
			mode[cursor].setBackground(Color.ORANGE);
			if(cursor > 0) {
				cursor--;
			}else {
				cursor = 3;
			}
			mode[cursor].setBackground(Color.WHITE);
			count = 0;
		}else{
			//カウンタを一つ増やす
			count++;
		}
	}

	private void cursorDown() {
		if(count >= 10){
			mode[cursor].setBackground(Color.ORANGE);
			if(cursor < 3) {
				cursor++;
			}else {
				cursor = 0;
			}
			mode[cursor].setBackground(Color.WHITE);
			count = 0;
		}else{
			//カウンタを一つ増やす
			count++;
		}
	}

	@Override//使わない
	protected void init() {}

	@Override
	protected void update() {
		//System.out.println(this);
		if(Global.keyInput[0]){//up
			cursorUp();
		}else if(Global.keyInput[1]){//down
			cursorDown();
		}else if(Global.keyInput[4]){//Z
			//自身の設定
			end();
			//難易度設定
			Global.difficulty = cursor;
			//Global.peformanceMode = hoooooooooooooooooooooooooooooooooooooooooooooo;
			Test_Title.sceneMove(new Game());
			//タイトルシーンの更新を止める
			super.end();
		}else {
			count = 10;
		}
		//常にフレームにキー対象を向ける

		if(colorcnt <= 50) {
			colorcnt++;
		}else {
			colorcnt = 0;
		}
		int x = 255 - Math.abs(255 - colorcnt * 10);
		label2.setForeground(new Color(x, x, x));
	}

	@Override//使わない
	protected void draw(Graphics g) {}

}
