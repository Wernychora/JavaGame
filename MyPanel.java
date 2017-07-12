package game;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;
class MyPanel extends JPanel
{
	int time=0, checked=0, dead=1000000000;
	boolean defeat=false, victory=false;
	static Configuration k = new Configuration(10, 150, 1.7f, 0.08f);
	BufferedImage background;
	Man guy;
	ArrayList <Stump> stumps = new ArrayList <Stump>();
	MyPanel(Configuration kk) 
	{
		k=kk;
		background=Util.load("background");
		guy = new Man(k.roof, k.gravity);
		for(int i=1000; i<500*k.number+1000; i+=500)
		stumps.add(new Stump(i));
		setPreferredSize(new Dimension(800, 600));
	}
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(background, -(int)(time*k.tempo)%800, 0, null);
		g2.drawImage(background, 800-(int)(time*k.tempo)%800, 0, null);
		ludzik.live();
		g2.drawImage(guy.bitmap, 300, (int)guy.y, null);
		for(Stump s : stumps)
		{
			s.x=s.place-(int)(time*k.tempo);
			if(s.x<100)checked++;
			g2.drawImage(s.bitmap, (int)s.x, 280, null);
			if(Util.colision(guy, s))dead=time;
			if(time-dead>50)defeat=true;
		}
		g2.drawString("Stumps "+checked+"/"+k.number, 20, 30);
		if(checked==k.number)victory=true;
		checked=0;
	}
	void key(KeyEvent e)
	{
		if(e.getKeyChar()==' ' && guy.ground)guy.jump=true;
	}
}
