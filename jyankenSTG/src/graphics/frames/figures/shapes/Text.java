package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import graphics.Vector2;

/*テキスト(Shapeなのに形じゃないやつ)*/
public class Text extends Shape{
	public String text = "";//テキスト
	private String fontName = Font.SANS_SERIF;//フォント名
	private int fontStyle = Font.PLAIN;//スタイル
	private int fontSize = 30;//文字の大きさ
	private Font font = new Font(fontName, fontStyle, fontSize);//フォント

	//コンストラクタ
	public Text(String text, Color color){
		super(color);
		this.text = text;
	}
	public Text(String text, Color color, Font font){
		super(color);
		this.text = text;
		this.font = font;
	}

	/*フォント回りの設定*/
	public void setFont(String fontName, int fontStyle, int fontSize){
		this.fontName = fontName;
		this.fontStyle = fontStyle;
		this.fontSize = fontSize;
		this.font = new Font(fontName, fontStyle, fontSize);
	}

	/*フォントサイズの設定*/
	public void setFontSize(int fontSize){
		this.fontSize = fontSize;
		this.font = new Font(fontName, fontStyle, fontSize);
	}

	/*描画(塗りつぶしなんてものはないのでどちらも一緒)*/
	public void drawSelf(Graphics g, Vector2 pos){
		g.setFont(font);
		g.drawString(text, pos.x, pos.y);
	}
	public void drawSelfWithFilled(Graphics g, Vector2 pos){
		this.drawSelf(g, pos);
	}
}
