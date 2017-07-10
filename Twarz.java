package paczka;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;
class Twarz  extends JPanel
{
	int l_misji=10;
	boolean gra=false;
	BufferedImage t�o;
	PierwszaKlasa baza;
	String[] Sg��wny = {"W�asna Gra","Kampania","Wyj�cie"};
	String[] Skampania=new String[l_misji+1];
	Wyb�r Wg��wny = new Wyb�r(Sg��wny), Wkampania;
	Config Ww�asny = new Config();
	ActionListener BL = new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
	    {
			String name=((JButton)e.getSource()).getText();
			if(name.equals("Kampania"))
			{
				Wg��wny.setVisible(false);
				Wkampania.setVisible(true);
			}
			if(name.equals("W�asna Gra"))
			{
				Wg��wny.setVisible(false);
				Ww�asny.setVisible(true);
				repaint();
			}
			if(name.equals("Wyj�cie"))System.exit(1);
			if(name.contains("Poziom"))
			{
				switch(name)
				{
					case "Poziom 1":  baza.graj(new Konfiguracja(10, 150, 1.6f, 0.08f)); break;
					case "Poziom 2":  baza.graj(new Konfiguracja(15, 150, 2.0f, 0.08f)); break;
					case "Poziom 3":  baza.graj(new Konfiguracja(20, 150, 2.5f, 0.08f)); break;
					case "Poziom 4":  baza.graj(new Konfiguracja(20, 150, 3.0f, 0.08f)); break;
					case "Poziom 5":  baza.graj(new Konfiguracja(20, 150, 3.5f, 0.08f)); break;
					case "Poziom 6":  baza.graj(new Konfiguracja(20, 150, 4.0f, 0.08f)); break;
					case "Poziom 7":  baza.graj(new Konfiguracja(25, 150, 5.0f, 0.12f)); break;
					case "Poziom 8":  baza.graj(new Konfiguracja(30, 150, 6.0f, 0.15f)); break;
					case "Poziom 9":  baza.graj(new Konfiguracja(35, 150, 7.0f, 0.18f)); break;
					case "Poziom 10": baza.graj(new Konfiguracja(50, 150, 8.0f, 0.2f));  break;
				}
				Wkampania.setVisible(false);
				Wg��wny.setVisible(true);
				setVisible(false);
			}
			if(name.equals("Powr�t"))
			{
				Wkampania.setVisible(false);
				Ww�asny.setVisible(false);
				Wg��wny.setVisible(true);
				repaint();
			}
			if(name.equals("Graj!"))
			{
				baza.graj(Ww�asny.conf);
			}
	    }
	};
	ActionListener TFL = new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String name=e.getActionCommand();
			if(name==Ww�asny.jtfText[0])Ww�asny.conf.ilo��=Integer.valueOf(Ww�asny.jtf[0].getText());
			if(name==Ww�asny.jtfText[1])Ww�asny.conf.pu�ap=Integer.valueOf(Ww�asny.jtf[1].getText());
			if(name==Ww�asny.jtfText[2])Ww�asny.conf.tempo=Float.valueOf(Ww�asny.jtf[2].getText());
			if(name==Ww�asny.jtfText[3])Ww�asny.conf.grawitacja=Float.valueOf(Ww�asny.jtf[3].getText());
		}
	};
	Twarz(PierwszaKlasa pk)
	{
		t�o=Util.wczytaj("t�o");
		setLayout(null);
		baza=pk;
		
		Wg��wny.setBounds(300,200,200,150);
		for(JButton jb: Wg��wny.przyciski)
			jb.addActionListener(BL);
		add(Wg��wny);
		
		for(int i=0; i<l_misji; i++)
			Skampania[i]="Poziom "+(i+1);
		Skampania[l_misji]="Powr�t";
		Wkampania = new Wyb�r(Skampania);
		Wkampania.setBounds(300,20,200,500);
		for(JButton jb: Wkampania.przyciski)
			jb.addActionListener(BL);
		add(Wkampania);
		Wkampania.setVisible(false);
		Ww�asny.setBounds(250,100,300,300);
		Ww�asny.powr�t.addActionListener(BL);
		Ww�asny.graj.addActionListener(BL);
		for(int i=0; i<Ww�asny.l_opcji; i++)
			Ww�asny.jtf[i].addActionListener(TFL);
		add(Ww�asny);
		Ww�asny.setVisible(false);
		
		setPreferredSize(new Dimension(800, 600));
	}
	protected void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(t�o, 0, 0, null);
		if(Ww�asny.isVisible())
		{
        	g.setFont(new Font("Default", Font.BOLD, 15));
			g2.drawString("Kliknij ENTER by potwierdzi� zmiany", 250, 80);
		}
	}
}