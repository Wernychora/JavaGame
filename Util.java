package paczka;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
class Util
{
	static BufferedImage wczytaj(String name)
	{
		BufferedImage bufor;
		try 
		{
			//System.out.println(Util.class.getResource(""));
			URL link=Util.class.getResource("/paczka/img/"+name+".png");
			bufor = ImageIO.read(link);
			//bufor = ImageIO.read(new File("imagine\\"+name+".png"));
			return bufor;
		} 
		catch (Exception e) 
		{
			System.err.println("B³¹d odczytu obrazka");
			e.printStackTrace();
		}
		return null;
	}
	static boolean kolizja(Obiekt a, Obiekt b)
	{
		int licznik=0;
		if(a.x<=b.x+b.szer)licznik++;
		if(a.x+a.szer>=b.x)licznik++;
		if(a.y<=b.y+b.wys)licznik++;
		if(a.y+a.wys>=b.y)licznik++;
		if(licznik==4)return true;
		return false;
	}
}