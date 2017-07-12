package game;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
class Configuration
{
	Integer number, roof;
	Float tempo, gravity;
	Configuration(int nr, int r, float t, float g)
	{
		number=nr;
		roof=r;
		tempo=t;
		gravity=g;
	}
}
class Config  extends JPanel
{
	Configuration conf = new Configuration(10, 150, 1.6f, 0.08f);
	String[] jbText = {"Number of stumps", "Height of jumps", "Speed of run", "Gravity force"};
	String[] jtfText = {conf.number.toString(), conf.roof.toString(), conf.tempo.toString(), conf.gravity.toString()};
	int optionNr=jbText.length;
	JButton play = new JButton("Play!"), back = new JButton("Back");
	JButton[] jb = new JButton[optionNr];
	JTextField[] jtf = new JTextField[optionNr];
	Config()
	{
		setLayout(new GridLayout(optionNr+1,2));
		add(play);
		add(back);
		for(int i=0; i<optionNr; i++)
		{
			jb[i]=new JButton(jbText[i]);
			jtf[i]=new JTextField(jtfText[i]);
			jtf[i].setActionCommand(jtfText[i]);
			add(jb[i]);
			add(jtf[i]);
		}
	}
}
