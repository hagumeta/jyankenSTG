package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.Vector2;

/*画像を描画できるShape*/
public class Image extends Shape{

	public BufferedImage image;//画像

	/*コンストラクタ*/
	public Image(BufferedImage image){
		this.filled = false;
		this.color = Color.black;
		this.image = image;
	}

	/*描画*/
	public void drawSelfWithFilled(Graphics g, Vector2 pos){}
	public void drawSelf(Graphics g, Vector2 pos){
		//画像を描画する.
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(image, null, pos.x, pos.y);
	}
}