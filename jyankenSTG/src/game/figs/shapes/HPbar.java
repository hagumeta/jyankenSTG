package game.figs.shapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game.Global;
import graphics.Vector2;
import graphics.frames.figures.shapes.Shape;

/*HPバーの描画*/
public class HPbar extends Shape{
	public int width;//横幅
	private int maxHP;//最大HP
	private int nowHP;//現在HP
	private int maxLength = Global.MainFrame.width-100;//バーの最長長さ
	private Font font = new Font(Font.SANS_SERIF, Font.BOLD, 40);//残りHP(数字)描画用

	private int delayWidth;//遅れバーの横幅
	private int delayX;//遅れバーの位置
	private boolean delay = false;//遅れバーを表示するか


	/*コンストラクタ*/
	public HPbar(int MaxHp){
		this.width = maxLength;
		this.maxHP = MaxHp;
		this.nowHP = maxHP;
		this.filled = true;
	}

	///描画関数(filledはtrueしかない)
	public void drawSelfWithFilled(Graphics g, Vector2 pos){
		//下地の描画
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Global.MainFrame.width, 70);

		//HPバー下地の描画
		g.setColor(Color.black);
		g.fillRect(70, 7, maxLength, 55);

		//HPバーの描画
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(70, 10, width, 50);

		//HPの数値描画
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(nowHP), 15, 45);

		//遅れバーがあれば描画
		if(delay){
			g.setColor(Color.MAGENTA);
			g.fillRect(delayX, 10, delayWidth, 50);
			//だんだん短くする
			delayWidth -= 2;
			if(delayWidth <= 0){
				delayWidth = 0;
				delay = false;
			}
		}
	}

	/*HPの入力*/
	public void setHP(int HP){
		//HPが減ったら更新を行う
		if(HP < nowHP){
			//差で生じるバーの幅の計算
			int d = (int)Math.round(maxLength*(nowHP - HP)/(double)maxHP);
			//バーの長さの更新
			this.width -= d;
			//遅れバーの設定
			this.delay = true;
			this.delayWidth += d;
			this.delayX = width + 70;

			//数値の更新
			nowHP = HP;
		}
	}


	public void drawSelf(Graphics g, Vector2 pos){}
}
