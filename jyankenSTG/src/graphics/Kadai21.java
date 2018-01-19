package graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

import graphics.frames.HFigureFrame;
import graphics.frames.figures.Figure;
import graphics.frames.figures.MovingFigure;
import graphics.frames.figures.shapes.Cross;
import graphics.frames.figures.shapes.Ellipse;
import graphics.frames.figures.shapes.Polygon;
import graphics.frames.figures.shapes.Rectangle;
import graphics.frames.figures.shapes.Text;

public class Kadai21{

	public static void main(String args[]){
		//フレームの用意
		JFrame frame = new JFrame("Kadai21");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//HShapesFrameの用意
		HFigureFrame hsf = new HFigureFrame(500, 500, 25);//1秒間に25回更新


		///各図形と文字の定義
		Figure[] figures = new Figure[8];

		/*new Figure(Shape shape ,Vector2 position)*/

		/*形(Shape)のコンストラクタ一覧↓*/
		/*new Rectangle(int width , int height, Color color, boolean filled)*/
		/*new Ellipse(  int width , int height, Color color, boolean filled)*/
		/*new Polygon(int radius  , int num   , Color color, int angle, boolean filled)*/
		/*new Text(   String text , Color color, Font font)*/
		/*new Cross(  Vector2 size, Color color)*/

		//長方形
		/*new Rectangle(int width , int height, Color color, boolean filled)*/
		figures[0] = new MovingFigure(new Rectangle(50, 100, Color.green, false), new Vector2(50, 150));
		((MovingFigure)figures[0]).setSpeed(15, 45);
		((MovingFigure)figures[0]).setAccelerate(1, 270);
		figures[1] = new Figure(new Text("長方形", Color.green, new Font(Font.SANS_SERIF, Font.PLAIN, 30)), new Vector2(40, 280));

		//×印
		/*new Cross(  Vector2 size, Color color)*/
		figures[2] = new Figure(new Cross(new Vector2(170, 170), Color.red), new Vector2(220, 200));
		figures[3] = new Figure(new Text("直線", Color.red, new Font(Font.SERIF, Font.BOLD, 20)), new Vector2(200, 260));

		//楕円
		/*new Ellipse(  int width , int height, Color color, boolean filled)*/
		figures[4] = new Figure(new Ellipse(100, 150, Color.blue, false), new Vector2(190, 300));
		figures[5] = new Figure(new Text("楕円", Color.blue, new Font(Font.DIALOG, Font.PLAIN, 25)), new Vector2(290, 430));

		//六角形
		/*new Polygon(int radius  , int num   , Color color, int angle, boolean filled)*/
		figures[6] = new Figure(new Polygon(90, 6,Color.black, 30, false), new Vector2(400, 200));
		figures[7] = new Figure(new Text("六角形", Color.black, new Font(Font.SERIF, Font.ITALIC, 30)), new Vector2(350, 320));

		//HShapesFrameに図形たちを全部アタッチ
		for(int i=0; i<figures.length; i++){
			hsf.add(figures[i]);
		}

		///HShapesFrameをフレームウインドウにアタッチ
		frame.add(hsf, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.pack();

		//(繰り返す必要がないので)HShapesFrameで一回だけ描画をする.
		hsf.start();//スタート(既に一回分描画は行われた)
		//hsf.end();//更新/描画を終了させる.
	}
}