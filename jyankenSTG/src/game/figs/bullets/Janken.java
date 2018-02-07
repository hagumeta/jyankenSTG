package game.figs.bullets;
public class Janken {
	static final int gu = 0;
	static final int choki = 1;
	static final int pa = 2;

	public static int judge(int te1, int te2) {
		switch((te1 - te2 + 3) % 3) {
		case 0:			//あいこ
			return 0;
		case 1:			//te2の勝ち
			return 2;
		case 2:			//te1の勝ち
			return 1;
		default:		//エラー
			return -1;
		}
	}

}
