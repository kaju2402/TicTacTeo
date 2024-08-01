import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacTeo implements ActionListener
{
	Random rn= new Random();
	JFrame fm= new JFrame();
	JPanel tit_panel = new JPanel();
	JPanel Butt_panel =new JPanel();
	JLabel txt_field = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	boolean player2_turn;
	
	TicTacTeo()
	{
		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fm.setSize(800,800);
		fm.getContentPane().setBackground(new Color(50,50,50));
		fm.setLayout(new BorderLayout());
		fm.setVisible(true);
		
		txt_field.setBackground(new Color(25,25,25));
		txt_field.setForeground(new Color(25,255,0));
		txt_field.setFont(new Font("Ink Free",Font.BOLD,75));
		txt_field.setHorizontalAlignment(JLabel.CENTER);
		txt_field.setText("Tic-Tac-Teo");
		txt_field.setOpaque(true);
		
		tit_panel.setLayout(new BorderLayout());
		tit_panel.setBounds(0,0,800,100);
		
		Butt_panel.setLayout(new GridLayout(3,3));
		Butt_panel.setBackground(new Color(150,150,150));

		for(int i=0;i<9;i++)
		{
			buttons[i]=new JButton();
			Butt_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		tit_panel.add(txt_field);
		fm.add(tit_panel,BorderLayout.NORTH);
		fm.add(Butt_panel);
		
		
		disableButtons();
		try
		{
			Thread.sleep(2000);
			enableButtons();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==buttons[i])
			{
				if(player1_turn)
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						txt_field.setText("O Turn");
						check();
					}
				}
				else
				{
					if(buttons[i].getText()=="")
					{
					buttons[i].setForeground(new Color(0,0,255));
					buttons[i].setText("O");
					player1_turn=true;
					txt_field.setText("X Turn");
					check();
					}
				}
			}
		}
	}
	public void firstTurn()
	{
		
		if(rn.nextInt(2)==0)
		{
			player1_turn=true;
			txt_field.setText("X Turn");
		}
		else
		{
			player1_turn=false;
			txt_field.setText("O Turn");
		}
	}
	public void check()
	{
		
		//X Check
		if((buttons[0].getText()=="X")&&
		   (buttons[1].getText()=="X")&&
		   (buttons[2].getText()=="X"))
		{
			xWins(0,1,2);
		}
		if((buttons[3].getText()=="X")&&
		   (buttons[4].getText()=="X")&&
		   (buttons[5].getText()=="X"))
		{
			xWins(3,4,5);
		}
		if((buttons[6].getText()=="X")&&
		   (buttons[7].getText()=="X")&&
		   (buttons[8].getText()=="X"))
		{
			xWins(6,7,8);
		}
		if((buttons[0].getText()=="X")&&
		   (buttons[3].getText()=="X")&&
		   (buttons[6].getText()=="X"))
		{
			xWins(0,3,6);
		}
		if((buttons[1].getText()=="X")&&
		   (buttons[4].getText()=="X")&&
		   (buttons[7].getText()=="X"))
		{
			xWins(1,4,7);
		}
		if((buttons[2].getText()=="X")&&
		   (buttons[5].getText()=="X")&&
		   (buttons[8].getText()=="X"))
		{
			xWins(2,5,8);
		}
		if((buttons[0].getText()=="X")&&
		   (buttons[4].getText()=="X")&&
		   (buttons[8].getText()=="X"))
		{
			xWins(0,4,8);
		}
		if((buttons[2].getText()=="X")&&
		   (buttons[4].getText()=="X")&&
		   (buttons[6].getText()=="X"))
		{
			xWins(2,4,6);
		}
		
		//O Check
		
		if((buttons[0].getText()=="O")&&
				   (buttons[1].getText()=="O")&&
				   (buttons[2].getText()=="O"))
				{
					oWins(0,1,2);
				}
				if((buttons[3].getText()=="O")&&
				   (buttons[4].getText()=="O")&&
				   (buttons[5].getText()=="O"))
				{
					oWins(3,4,5);
				}
				if((buttons[6].getText()=="O")&&
				   (buttons[7].getText()=="O")&&
				   (buttons[8].getText()=="O"))
				{
					oWins(6,7,8);
				}
				if((buttons[0].getText()=="O")&&
				   (buttons[3].getText()=="O")&&
				   (buttons[6].getText()=="O"))
				{
					oWins(0,3,6);
				}
				if((buttons[1].getText()=="O")&&
				   (buttons[4].getText()=="O")&&
				   (buttons[7].getText()=="O"))
				{
					oWins(1,4,7);
				}
				if((buttons[2].getText()=="O")&&
				   (buttons[5].getText()=="O")&&
				   (buttons[8].getText()=="O"))
				{
					oWins(2,5,8);
				}
				if((buttons[0].getText()=="O")&&
				   (buttons[4].getText()=="O")&&
				   (buttons[8].getText()=="O"))
				{
					oWins(0,4,8);
				}
				if((buttons[2].getText()=="O")&&
				   (buttons[4].getText()=="O")&&
				   (buttons[6].getText()=="O"))
				{
					oWins(2,4,6);
				}
	 }
	
	public void xWins(int a,int b, int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		txt_field.setText("Yeah!X Wins");
		disableButtons();
	}
	public void oWins(int a,int b, int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		txt_field.setText("Yeah!O Wins");
		disableButtons();

	}
    public void disableButtons() 
    {
        for (int i = 0; i < 9; i++) 
        {
            buttons[i].setEnabled(false);
        }
    }
	public void enableButtons()
	{
		for(int i=0;i<9;i++)
		{
			buttons[i].setEnabled(true);
		}
	}	
}
