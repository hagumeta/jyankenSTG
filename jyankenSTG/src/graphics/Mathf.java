package graphics;

public class Mathf {
	//範囲内の値をランダムに返す
	public static int randomRange(int min, int max){
		int d = max - min;//差
		return min + (int)Math.round(d*Math.random());
	}
}
