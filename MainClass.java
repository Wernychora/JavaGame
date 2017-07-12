package game;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
public class MainClass extends JFrame 
{
	static MyPanel panel;
	static Face face;
	java.util.Timer timer;
	KeyListener kl = new KeyListener()
	{
		
		public void keyPressed(KeyEvent e)
		{
			panel.key(e);
		}
		public void keyReleased(KeyEvent e){}
		public void keyTyped(KeyEvent e){}
	};
	void end(String info1, String info2)
	{
		panel.defeat=false;
		panel.victory=false;
		panel.dead=1000000000;
		int option=JOptionPane.showConfirmDialog(null, info1+", do you want play again?", info2, JOptionPane.YES_NO_OPTION);
		if(option==JOptionPane.YES_OPTION)
		{
			timer.cancel();
			play(panel.k);
		}
		if(option==JOptionPane.NO_OPTION)
		{
			face.game=false;
			panel.setVisible(false);
			face.setVisible(true);
			timer.cancel();
		}
	}
	public MainClass() 
	{
		super("Painting");
		face = new Face(this);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width/2-400, screenSize.height/2-300);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		face.setBounds(0,0,800,600);
		add(face);
		setSize(800, 600);
		addKeyListener(kl);
	}
	void game(Configuration k)
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
				face.setVisible(false);
				panel.setVisible(true);
				if(!panel.victory && !panel.default)panel.time++;
				panel.repaint();
				if(panel.default)koniec("You lose","Defeat");
				if(panel.victory)koniec("You won","Victory");
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
				new MainClass();
			}
		});
	}
}
