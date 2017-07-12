package game;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
class Util
{
	static BufferedImage load(String name)
	{
		BufferedImage buffer;
		try 
		{
			URL link=Util.class.getResource("/game/img/"+name+".png");
			buffer = ImageIO.read(link);
			return buffer;
		} 
		catch (Exception e) 
		{
			System.err.println("Error, image can not found");
			e.printStackTrace();
		}
		return null;
	}
	static boolean colision(Physical a, Physical b)
	{
		int counter=0;
		if(a.x<=b.x+b.szer)counter++;
		if(a.x+a.szer>=b.x)counter++;
		if(a.y<=b.y+b.wys)counter++;
		if(a.y+a.wys>=b.y)counter++;
		if(licznik==4)return true;
		return false;
	}
}
