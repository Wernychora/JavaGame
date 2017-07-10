package paczka;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;
class MyPanel extends JPanel
{
	int time=0, zaliczone=0, dead=1000000000;
	boolean przegrana=false, wygrana=false;
	static Konfiguracja k = new Konfiguracja(10, 150, 1.7f, 0.08f);
	BufferedImage t³o;
	Ludzik ludzik;
	ArrayList <Przeszkoda> pieñki = new ArrayList <Przeszkoda>();
	MyPanel(Konfiguracja kk) 
	{
		k=kk;
		t³o=Util.wczytaj("t³o");
		ludzik = new Ludzik(k.pu³ap, k.grawitacja);
		for(int i=1000; i<500*k.iloœæ+1000; i+=500)
		pieñki.add(new Przeszkoda(i));
		setPreferredSize(new Dimension(800, 600));
	}
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(t³o, -(int)(time*k.tempo)%800, 0, null);
		g2.drawImage(t³o, 800-(int)(time*k.tempo)%800, 0, null);
		ludzik.¿yj();
		g2.drawImage(ludzik.bitmapa, 300, (int)ludzik.y, null);
		for(Przeszkoda p : pieñki)
		{
			p.x=p.miejsce-(int)(time*k.tempo);
			if(p.x<100)zaliczone++;
			g2.drawImage(p.bitmapa, (int)p.x, 280, null);
			if(Util.kolizja(ludzik, p))dead=time;
			if(time-dead>50)przegrana=true;
		}
		g2.drawString("Pieñki "+zaliczone+"/"+k.iloœæ, 20, 30);
		if(zaliczone==k.iloœæ)wygrana=true;
		zaliczone=0;
	}
	void klawisz(KeyEvent e)
	{
		if(e.getKeyChar()==' ' && ludzik.ziemia)ludzik.skok=true;
	}
}