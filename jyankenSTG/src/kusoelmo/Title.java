package kusoelmo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graphics.Global;

public class Title extends JPanel{
	private int cursor;
	private JButton mode[];
	private JPanel panel;

	public Title() {
		cursor = 0;
		mode = new JButton[4];
		mode[0] = new JButton("CHALLENGE MODE (EASY)");
		mode[1] = new JButton("CHALLENGE MODE (NORMAL)");
		mode[2] = new JButton("CHALLENGE MODE (HARD)");
		mode[3] = new JButton("ENDLESS MODE");
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		mode[0].setBackground(Color.WHITE);
		for(int i = 1; i < 4; i++) {
			mode[i].setBackground(Color.ORANGE);
		}

		for(int i = 0; i < 4; i++) {
			mode[i].setFont(new Font("Serif", Font.BOLD, 28));
			mode[i].setAlignmentX((JComponent.CENTER_ALIGNMENT));
			panel.add(mode[i]);
		}

		add(new JLabel("じゃんけんシューティング"));

		Global.nowGameScene = this;
		add(panel);
	}

	public void cursorUp() {
		mode[cursor].setBackground(Color.ORANGE);
		if(cursor > 0) {
			cursor--;
		}else {
			cursor = 3;
		}
		mode[cursor].setBackground(Color.WHITE);
	}

	public void cursorDown() {
		mode[cursor].setBackground(Color.ORANGE);
		if(cursor < 3) {
			cursor++;
		}else {
			cursor = 0;
		}
		mode[cursor].setBackground(Color.WHITE);
	}

}
