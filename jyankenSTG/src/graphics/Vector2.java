package graphics;

public class Vector2 {
	/*
	Vector2クラス
	x, yの二次元座標を持ったクラス.
	*/

	public int x, y;

	//0ベクトル
	public static Vector2 ZERO = new Vector2(0,0);

	/*コンストラクタ*/
	public Vector2(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Vector2(double x, double y){
		this.x = (int)x;
		this.y = (int)y;
	}
	public Vector2(){
		this.x = 0;
		this.y = 0;
	}
	public Vector2(double r, int direction){
		double a = Math.toRadians(direction);
		this.x = (int)Math.round(r*Math.cos(a));
		this.y = (int)Math.round(-r*Math.sin(a));
	}

	/*ベクトルに足す*/
	public void addBoth(int addX, int addY){
		this.x += addX;
		this.y += addY;
	}

	/*ベクトルの足し算*/
	public static Vector2 sum(Vector2 vec1, Vector2 vec2){
		return new Vector2(vec1.x+vec2.x, vec1.y+vec2.y);
	}
	/*二つの距離（の二乗）を求める*/
	public static int getDisPow(Vector2 vec1, Vector2 vec2){
		return (vec1.x-vec2.x)*(vec1.x-vec2.x) + (vec1.y-vec2.y)*(vec1.y-vec2.y);
	}
	/*二つの距離を求める*/
	public static int getDis(Vector2 vec1, Vector2 vec2){
		return (int)Math.round(Math.sqrt((double)getDisPow(vec1, vec2)));
	}
	/*二つの角度を求める*/
	public static int getDirection(Vector2 vec1, Vector2 vec2){
		return (int)Math.toDegrees(Math.atan2(vec1.y-vec2.y, vec2.x-vec1.x));
	}
	/*ベクトルの角度を求める*/
	public static int getDirection(Vector2 vec){
		return (int)Math.toDegrees(Math.atan2(vec.y, vec.x));
	}
}