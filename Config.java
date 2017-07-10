package paczka;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
class Konfiguracja
{
	Integer iloœæ, pu³ap;
	Float tempo, grawitacja;
	Konfiguracja(int il, int p, float t, float g)
	{
		iloœæ=il;
		pu³ap=p;
		tempo=t;
		grawitacja=g;
	}
}
class Config  extends JPanel
{
	Konfiguracja conf = new Konfiguracja(10, 150, 1.6f, 0.08f);
	String[] jbText = {"Iloœæ przeszkód", "Wysokoœæ skoków", "Szybkoœæ biegu", "Grawitacja"};
	String[] jtfText = {conf.iloœæ.toString(), conf.pu³ap.toString(), conf.tempo.toString(), conf.grawitacja.toString()};
	int l_opcji=jbText.length;
	JButton graj = new JButton("Graj!"), powrót = new JButton("Powrót");
	JButton[] jb = new JButton[l_opcji];
	JTextField[] jtf = new JTextField[l_opcji];
	Config()
	{
		setLayout(new GridLayout(l_opcji+1,2));
		add(graj);
		add(powrót);
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