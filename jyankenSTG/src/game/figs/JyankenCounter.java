package game.figs;

import java.awt.Color;
import java.awt.Font;

import game.Global;
import graphics.frames.figures.Figure;
import graphics.frames.figures.shapes.Shape;
import graphics.frames.figures.shapes.Text;

/*じゃんけんカウンター
 * 1プレイ中に何回じゃんけんやったかをカウントして描画する
 * */
public class JyankenCounter extends Figure{
	public static int jyankenCount;//じゃんけんカウント


	/*コンストラクタ*/
	public JyankenCounter(){
		this.setPosition(5, Global.MainFrame.height-20);
		jyankenCount = 0;//リセット
		this.shape = (Shape)(new Text("", Color.red, new Font(Font.SANS_SERIF, Font.PLAIN, 20)));
	}

	//じゃんけんカウントを足して更新
	public void addCount(){
		jyankenCount++;
		((Text)this.shape).text = "Jyanken×"+jyankenCount;
	}
}
