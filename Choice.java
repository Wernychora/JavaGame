package game;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
class Choice extends JPanel
{
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	Choice(String[] titles)
	{
		setLayout(new GridLayout(titles.length,1));
		for(String s: titles)
			buttons.add(new JButton(s));
		for(JButton jb: buttons)
			add(jb);
	}
}
