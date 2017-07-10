package paczka;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
class Konfiguracja
{
	Integer ilo��, pu�ap;
	Float tempo, grawitacja;
	Konfiguracja(int il, int p, float t, float g)
	{
		ilo��=il;
		pu�ap=p;
		tempo=t;
		grawitacja=g;
	}
}
class Config  extends JPanel
{
	Konfiguracja conf = new Konfiguracja(10, 150, 1.6f, 0.08f);
	String[] jbText = {"Ilo�� przeszk�d", "Wysoko�� skok�w", "Szybko�� biegu", "Grawitacja"};
	String[] jtfText = {conf.ilo��.toString(), conf.pu�ap.toString(), conf.tempo.toString(), conf.grawitacja.toString()};
	int l_opcji=jbText.length;
	JButton graj = new JButton("Graj!"), powr�t = new JButton("Powr�t");
	JButton[] jb = new JButton[l_opcji];
	JTextField[] jtf = new JTextField[l_opcji];
	Config()
	{
		setLayout(new GridLayout(l_opcji+1,2));
		add(graj);
		add(powr�t);
		for(int i=0; i<l_opcji; i++)
		{
			jb[i]=new JButton(jbText[i]);
			jtf[i]=new JTextField(jtfText[i]);
			jtf[i].setActionCommand(jtfText[i]);
			add(jb[i]);
			add(jtf[i]);
		}
	}
}