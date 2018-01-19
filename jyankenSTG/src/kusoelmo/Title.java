package kusoelmo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Title implements KeyListener {
	private int cursor;
	private JPanel panel;
	private JLabel label[];

	public Title() {
		cursor = 0;
		panel = new JPanel();
		label = new JLabel[4];
		label[0] = new JLabel("CHALLENGE MODE (EASY)");
		label[1] = new JLabel("CHALLENGE MODE (NORMAL)");
		label[2] = new JLabel("CHALLENGE MODE (HARD)");
		label[3] = new JLabel("ENDLESS MODE");
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		cursor++;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//使わない
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//使わない
	}

}
