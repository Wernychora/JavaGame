package game;
import java.awt.image.BufferedImage;
class Stump extends Physical
{
	final int place;
	static BufferedImage bitmap=Util.load("stump");
	Stump(int p)
	{
		super(30, 30, 0, 250f);
		place=p;
	}
}
