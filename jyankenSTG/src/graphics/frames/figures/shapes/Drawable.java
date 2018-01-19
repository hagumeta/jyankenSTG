package graphics.frames.figures.shapes;

import java.awt.Graphics;

import graphics.Vector2;

public interface Drawable {
	//塗りつぶさない
	void drawSelf(Graphics g, Vector2 pos);
	//塗りつぶす
	void drawSelfWithFilled(Graphics g, Vector2 pos);
}
