package game;
import java.awt.image.BufferedImage;
class Man extends Physical
{
	static BufferedImage bitmap=Util.load("guy");
	float gravity=0.08f;
	int roof=100;
	boolean jump=false, ground=true;
	Man(int p, float g)
	{
		super(55, 40, 300f, 250f);
		roof=p;
		gravity=g;
	}
	void live()
	{
		if(jump)
			if(y>roof)y-=(y-roof+1)*gravity;
			else jump=false;
		if(y<250 && !jump)y+=(y-roof+1)*gravity;
		if(y>250)y=250;
		if(y==250)ground=true;
		else ground=false;
	}
}
