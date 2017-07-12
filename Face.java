package game;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JPanel;
class Face extends JPanel
{
	int missionNr=10;
	boolean game=false;
	BufferedImage background;
	MainClass base;
	String[] Smain = {"Custom Game","Campaign","Exit"};
	String[] Scampaign=new String[missionNr+1];
	Choice cMain = new Choice(Smain), cCampaign;
	Config cCustom = new Config();
	ActionListener BL = new ActionListener() 
	{
	    public void actionPerformed(ActionEvent e) 
	    {
			String name=((JButton)e.getSource()).getText();
			if(name.equals("Campaign"))
			{
				cMain.setVisible(false);
				cCampaign.setVisible(true);
			}
			if(name.equals("Custom Game"))
			{
				cMain.setVisible(false);
				cCustom.setVisible(true);
				repaint();
			}
			if(name.equals("Exit"))System.exit(1);
			if(name.contains("Level"))
			{
				switch(name)
				{
					case "Level 1":  base.play(new Configuration(10, 150, 1.6f, 0.08f)); break;
					case "Level 2":  base.play(new Configuration(15, 150, 2.0f, 0.08f)); break;
					case "Level 3":  base.play(new Configuration(20, 150, 2.5f, 0.08f)); break;
					case "Level 4":  base.play(new Configuration(20, 150, 3.0f, 0.08f)); break;
					case "Level 5":  base.play(new Configuration(20, 150, 3.5f, 0.08f)); break;
					case "Level 6":  base.play(new Configuration(20, 150, 4.0f, 0.08f)); break;
					case "Level 7":  base.play(new Configuration(25, 150, 5.0f, 0.12f)); break;
					case "Level 8":  base.play(new Configuration(30, 150, 6.0f, 0.15f)); break;
					case "Level 9":  base.play(new Configuration(35, 150, 7.0f, 0.18f)); break;
					case "Level 10": base.play(new Configuration(50, 150, 8.0f, 0.2f));  break;
				}
				cCampaign.setVisible(false);
				cMain.setVisible(true);
				setVisible(false);
			}
			if(name.equals("Back"))
			{
				cCampaign.setVisible(false);
				cCustom.setVisible(false);
				cMain.setVisible(true);
				repaint();
			}
			if(name.equals("Play!"))
			{
				base.play(cCustom.conf);
			}
	    }
	};
	ActionListener TFL = new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String name=e.getActionCommand();
			if(name==cCustom.jtfText[0])cCustom.conf.number=Integer.valueOf(cCustom.jtf[0].getText());
			if(name==cCustom.jtfText[1])cCustom.conf.roof=Integer.valueOf(cCustom.jtf[1].getText());
			if(name==cCustom.jtfText[2])cCustom.conf.tempo=Float.valueOf(cCustom.jtf[2].getText());
			if(name==cCustom.jtfText[3])cCustom.conf.gravity=Float.valueOf(cCustom.jtf[3].getText());
		}
	};
	Face(MainClass mainClass)
	{
		background=Util.load("background");
		setLayout(null);
		base=mainClass;
		
		cMain.setBounds(300,200,200,150);
		for(JButton jb: cMain.buttons)
			jb.addActionListener(BL);
		add(cMain);
		
		for(int i=0; i<missionNr; i++)
			sCampaign[i]="Level "+(i+1);
		sCampaign[missionNr]="Back";
		cCampaign = new Choice(sCampaign);
		cCampaign.setBounds(300,20,200,500);
		for(JButton jb: cCampaign.buttons)
			jb.addActionListener(BL);
		add(cCampaign);
		cCampaign.setVisible(false);
		cCustom.setBounds(250,100,300,300);
		cCustom.back.addActionListener(BL);
		cCustom.play.addActionListener(BL);
		for(int i=0; i<cCustom.choiceNr; i++)
			cCustom.jtf[i].addActionListener(TFL);
		add(cCustom);
		cCustom.setVisible(false);
		
		setPreferredSize(new Dimension(800, 600));
	}
	protected void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(background, 0, 0, null);
		if(cCustom.isVisible())
		{
        	g.setFont(new Font("Default", Font.BOLD, 15));
			g2.drawString("Press Enter to confirm", 250, 80);
		}
	}
}
