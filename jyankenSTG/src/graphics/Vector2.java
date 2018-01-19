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


	/*ベクトルの足し算*/
	public static Vector2 sum(Vector2 vec1, Vector2 vec2){
		return new Vector2(vec1.x+vec2.x, vec1.y+vec2.y);
	}
}