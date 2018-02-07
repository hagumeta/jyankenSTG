package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import graphics.Vector2;


/*画像を描画できるShape*/
public class SImage extends Shape{

	public Image image;//画像

	/*コンストラクタ*/
	public SImage(Image image){
		this.filled = false;
		this.color = Color.black;
		this.image = image;
	}

	/*描画*/
	public void drawSelfWithFilled(Graphics g, Vector2 pos){}
	public void drawSelf(Graphics g, Vector2 pos){
		//画像を描画する.
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(image, pos.x, pos.y, null);
	}
}