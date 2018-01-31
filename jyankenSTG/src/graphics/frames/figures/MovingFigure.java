package graphics.frames.figures;

import graphics.Vector2;
import graphics.frames.figures.shapes.Shape;

/*動く！Figureのクラス 一応線形移動,加速度はデフォで備えてる*/
public class MovingFigure extends Figure implements Updatable{

	public Vector2 speed;//スピード(x,y)
	public Vector2 accelerate;//加速度(x,y)
	public boolean frozen = false;//trueだと更新が止まる

	/*コンストラクタ*/
	public MovingFigure(){
		super();
		this.speed = new Vector2(0, 0);
		this.accelerate = new Vector2(0, 0);
	}
	public MovingFigure(Shape shape){
		this();
		this.shape = shape;
	}
	public MovingFigure(Shape shape, Vector2 position){
		this.shape = shape;
		this.position = position;
	}
	public MovingFigure(Shape shape, Vector2 position, Vector2 speed, Vector2 accel){
		super(shape, position);
		this.speed = speed;
		this.accelerate = accel;
	}

	/*各フレームごとに更新するものを入れる(任意)*/
	protected void updateAdd(){}

	//------------------/*以下finalメソッド*/-----------------------//

	/*各フレームごとに呼び出される更新メソッド*/
	final public void update(){
		if(!this.frozen && this.enable){
			//加速する
			this.speed = Vector2.sum(this.speed, this.accelerate);
			//座標移動(進む)
			this.position.x += this.speed.x;
			this.position.y += this.speed.y;
			//追加で更新(任意)
			this.updateAdd();
		}
	}

	/*速度を変更する*/
	final public void setSpeed(Vector2 speed){
		this.speed = speed;
	}
	final public void setSpeed(int spSc, int direction){
		this.speed = new Vector2((double)spSc, direction);
	}

	/*加速度を変更する*/
	final public void setAccelerate(Vector2 accelerate){
		this.accelerate = accelerate;
	}
	final public void setAccelerate(int accelSc, int direction){
		this.accelerate = new Vector2((double)accelSc, direction);
	}
}