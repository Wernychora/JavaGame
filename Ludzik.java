package paczka;
import java.awt.image.BufferedImage;
class Ludzik extends Obiekt
{
	static BufferedImage bitmapa=Util.wczytaj("ludzik");
	float grawitacja=0.08f;
	int pu³ap=100;
	boolean skok=false, ziemia=true;
	Ludzik(int p, float g)
	{
		super(55, 40, 300f, 250f);
		pu³ap=p;
		grawitacja=g;
	}
	void ¿yj()
	{
		if(skok)
			if(y>pu³ap)y-=(y-pu³ap+1)*grawitacja;
			else skok=false;
		if(y<250 && !skok)y+=(y-pu³ap+1)*grawitacja;
		if(y>250)y=250;
		if(y==250)ziemia=true;
		else ziemia=false;
	}
}