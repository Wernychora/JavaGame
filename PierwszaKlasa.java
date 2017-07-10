package paczka;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
public class PierwszaKlasa extends JFrame 
{
	static MyPanel panel;
	static Twarz twarz;
	java.util.Timer timer;
	KeyListener kl = new KeyListener()
	{
		
		public void keyPressed(KeyEvent e)
		{
			panel.klawisz(e);
		}
		public void keyReleased(KeyEvent e){}
		public void keyTyped(KeyEvent e){}
	};
	void koniec(String info1, String info2)
	{
		panel.przegrana=false;
		panel.wygrana=false;
		panel.dead=1000000000;
		int opcja=JOptionPane.showConfirmDialog(null, info1+", chcesz zagraæ jeszcze raz?", info2, JOptionPane.YES_NO_OPTION);
		if(opcja==JOptionPane.YES_OPTION)
		{
			timer.cancel();
			graj(panel.k);
		}
		if(opcja==JOptionPane.NO_OPTION)
		{
			twarz.gra=false;
			panel.setVisible(false);
			twarz.setVisible(true);
			timer.cancel();
		}
	}
	public PierwszaKlasa() 
	{
		super("Rysowanie");
		twarz = new Twarz(this);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width/2-400, screenSize.height/2-300);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		twarz.setBounds(0,0,800,600);
		add(twarz);
		setSize(800, 600);
		addKeyListener(kl);
	}
	void graj(Konfiguracja k)
	{
		panel = new MyPanel(k);
		panel.setBounds(0,0,800,600);
		requestFocus();
		add(panel);
		timer = new java.util.Timer();
		TimerTask tt = new TimerTask()
		{
			public void run()
			{
				twarz.setVisible(false);
				panel.setVisible(true);
				if(!panel.wygrana && !panel.przegrana)panel.time++;
				panel.repaint();
				if(panel.przegrana)koniec("Przegra³eœ","Przegrana");
				if(panel.wygrana)koniec("Wygra³eœ","Wygrana");
			}
		};
		timer.schedule(tt, 0, 5);
	}
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new PierwszaKlasa();
			}
		});
	}
}