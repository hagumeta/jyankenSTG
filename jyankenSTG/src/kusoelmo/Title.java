package kusoelmo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graphics.Game;
import graphics.Global;
import graphics.frames.HDrawingFrame;


public class Title extends HDrawingFrame{
	private int cursor;
	private JButton mode[];
	private JPanel panel;
	private int count = 10;

	public Title() {
		super(1000, 750, 30);
		cursor = 0;
		mode = new JButton[4];
		mode[0] = new JButton("CHALLENGE MODE (EASY)");
		mode[1] = new JButton("CHALLENGE MODE (NORMAL)");
		mode[2] = new JButton("CHALLENGE MODE (HARD)");
		mode[3] = new JButton("ENDLESS MODE");
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setLayout(new GridLayout(2, 1));

		mode[0].setBackground(Color.WHITE);
		for(int i = 1; i < 4; i++) {
			mode[i].setBackground(Color.ORANGE);
		}

		for(int i = 0; i < 4; i++) {
			mode[i].setFont(new Font("Serif", Font.BOLD, 28));
			mode[i].setAlignmentX((JComponent.CENTER_ALIGNMENT));
			mode[i].setEnabled(false);
			panel.add(mode[i]);
		}

		setBackground(Color.BLACK);

		JLabel logo = new JLabel("じゃんけんシューティング");
		logo.setFont(new Font("Gothic", Font.BOLD, 40));
		logo.setForeground(Color.MAGENTA);
		logo.setHorizontalAlignment(JLabel.CENTER);
		add(logo);

		add(panel);
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

	@Override
	protected void init() {
	}

	@Override
	protected void update() {
		//System.out.println(this);
		if(Global.keyInput[0]){//up
			cursorUp();
		}else if(Global.keyInput[1]){//down
			cursorDown();
		}else if(Global.keyInput[4]){//Z
			end();
			Global.difficulty = cursor;
			Test_Title.sceneMove(new Game());
			//タイトルシーンの更新を止める
			super.end();
		}else {
			count = 10;
		}
		//常にフレームにキー対象を向ける

	}

	@Override
	protected void draw(Graphics g) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
