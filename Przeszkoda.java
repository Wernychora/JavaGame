package paczka;
import java.awt.image.BufferedImage;
class Przeszkoda extends Obiekt
{
	final int miejsce;
	static BufferedImage bitmapa=Util.wczytaj("pieñ");
	Przeszkoda(int m)
	{
		super(30, 30, 0, 250f);
		miejsce=m;
	}
}