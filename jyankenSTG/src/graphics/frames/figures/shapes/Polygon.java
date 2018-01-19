package graphics.frames.figures.shapes;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Vector2;

/*ポリゴン（クソ実装なので重いぞ注意！！）*/
public class Polygon extends Shape{

	private int[] xPoints;//それぞれの頂点x
	private int[] yPoints;//それぞれの頂点y
	private Vector2[] corners;//それぞれの頂点の座標
	public int num, radius;//頂点の数, 外接円の半径
	public int angle;//回転角度

	/*コンストラクタ*/
	public Polygon(int radius, int num, Color color, int angle, boolean filled){
		super(color, filled);
		this.radius = radius;
		this.num = num;
		this.angle = angle;
	}
	public Polygon(int radius, int num){
		this(radius, num, Color.black, 0, false);
	}


	///描画関数
	public void drawSelfWithFilled(Graphics g, Vector2 pos){
		setCornerPoints(pos);
		g.fillPolygon(xPoints, yPoints, xPoints.length);
	}
	public void drawSelf(Graphics g, Vector2 pos){
		setCornerPoints(pos);
		g.drawPolygon(xPoints, yPoints, xPoints.length);
	}


	/*頂点の座標パラメータを計算する*/
	private void setCornerPoints(Vector2 pos){
		xPoints = new int[num];
		yPoints = new int[num];
		corners = new Vector2[num];

		double a = 360/num;//角度
		for(int i=0; i<num; i++){
			double rad = Math.toRadians(a*i+angle);
			xPoints[i] = pos.x + (int)(Math.cos(rad)*radius);
			yPoints[i] = pos.y + (int)(Math.sin(rad)*radius);
			corners[i] = new Vector2(xPoints[i], yPoints[i]);
		}
	}


	/*配列のVector2からx, yの配列を作る*/
	/*private int[] getVecXs(Vector2[] vec){
		int[] ret = new int[vec.length];
		for(int i=0; i<ret.length; i++){
			ret[i] = vec[i].x;
		}
		return ret;
	}
	private int[] getVecYs(Vector2[] vec){
		int[] ret = new int[vec.length];
		for(int i=0; i<ret.length; i++){
			ret[i] = vec[i].y;
		}
		return ret;
	}*/
}
