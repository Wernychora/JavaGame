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
	BufferedImage t³o;
	PierwszaKlasa baza;
	String[] Sg³ówny = {"W³asna Gra","Kampania","Wyjœcie"};
	String[] Skampania=new String[l_misji+1];
	Wybór Wg³ówny = new Wybór(Sg³ówny), Wkampania;
	Config Ww³asny = new Config();
	ActionListener BL = new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
	    {
			String name=((JButton)e.getSource()).getText();
			if(name.equals("Kampania"))
			{
				Wg³ówny.setVisible(false);
				Wkampania.setVisible(true);
			}
			if(name.equals("W³asna Gra"))
			{
				Wg³ówny.setVisible(false);
				Ww³asny.setVisible(true);
				repaint();
			}
			if(name.equals("Wyjœcie"))System.exit(1);
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
				Wg³ówny.setVisible(true);
				setVisible(false);
			}
			if(name.equals("Powrót"))
			{
				Wkampania.setVisible(false);
				Ww³asny.setVisible(false);
				Wg³ówny.setVisible(true);
				repaint();
			}
			if(name.equals("Graj!"))
			{
				baza.graj(Ww³asny.conf);
			}
	    }
	};
	ActionListener TFL = new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String name=e.getActionCommand();
			if(name==Ww³asny.jtfText[0])Ww³asny.conf.iloœæ=Integer.valueOf(Ww³asny.jtf[0].getText());
			if(name==Ww³asny.jtfText[1])Ww³asny.conf.pu³ap=Integer.valueOf(Ww³asny.jtf[1].getText());
			if(name==Ww³asny.jtfText[2])Ww³asny.conf.tempo=Float.valueOf(Ww³asny.jtf[2].getText());
			if(name==Ww³asny.jtfText[3])Ww³asny.conf.grawitacja=Float.valueOf(Ww³asny.jtf[3].getText());
		}
	};
	Twarz(PierwszaKlasa pk)
	{
		t³o=Util.wczytaj("t³o");
		setLayout(null);
		baza=pk;
		
		Wg³ówny.setBounds(300,200,200,150);
		for(JButton jb: Wg³ówny.przyciski)
			jb.addActionListener(BL);
		add(Wg³ówny);
		
		for(int i=0; i<l_misji; i++)
			Skampania[i]="Poziom "+(i+1);
		Skampania[l_misji]="Powrót";
		Wkampania = new Wybór(Skampania);
		Wkampania.setBounds(300,20,200,500);
		for(JButton jb: Wkampania.przyciski)
			jb.addActionListener(BL);
		add(Wkampania);
		Wkampania.setVisible(false);
		Ww³asny.setBounds(250,100,300,300);
		Ww³asny.powrót.addActionListener(BL);
		Ww³asny.graj.addActionListener(BL);
		for(int i=0; i<Ww³asny.l_opcji; i++)
			Ww³asny.jtf[i].addActionListener(TFL);
		add(Ww³asny);
		Ww³asny.setVisible(false);
		
		setPreferredSize(new Dimension(800, 600));
	}
	protected void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(t³o, 0, 0, null);
		if(Ww³asny.isVisible())
		{
        	g.setFont(new Font("Default", Font.BOLD, 15));
			g2.drawString("Kliknij ENTER by potwierdziæ zmiany", 250, 80);
		}
	}
}