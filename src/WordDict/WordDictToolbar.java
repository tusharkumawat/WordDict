package WordDict;

import java.awt.Color;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;



public class WordDictToolbar extends JPanel
{
	JToolBar tool;
	int i;
	String alph;
	JButton b1,b2,b3,b4,b5;
	public WordDictToolbar()
	{
		tool=new JToolBar();
		tool.setBackground(Color.white);
		
		
		
			JLabel A=new JLabel("A");
			JLabel B=new JLabel("B");
			JLabel C=new JLabel("C");
			JLabel D=new JLabel("D");
			JLabel E=new JLabel("E");
			JLabel F=new JLabel("F");
			JLabel G=new JLabel("G");
			JLabel H=new JLabel("H");
			JLabel I=new JLabel("I");
			JLabel J=new JLabel("J");
			JLabel K=new JLabel("K");
			JLabel L=new JLabel("L");
			JLabel M=new JLabel("M");
			JLabel N=new JLabel("N");
			JLabel O=new JLabel("O");
			JLabel P=new JLabel("P");
			JLabel Q=new JLabel("Q");
			JLabel R=new JLabel("R");
			JLabel S=new JLabel("S");
			JLabel T=new JLabel("T");
			JLabel U=new JLabel("U");
			JLabel V=new JLabel("V");
			JLabel W=new JLabel("W");
			JLabel X=new JLabel("X");
			JLabel Y=new JLabel("Y");
			JLabel Z=new JLabel("Z");
			mouseEve(A);
			mouseEve(B);
			mouseEve(C);
			mouseEve(D);
			mouseEve(E);
			mouseEve(F);
			mouseEve(G);
			mouseEve(H);
			mouseEve(I);
			mouseEve(J);
			mouseEve(K);
			mouseEve(L);
			mouseEve(M);
			mouseEve(N);
			mouseEve(O);
			mouseEve(P);
			mouseEve(Q);
			mouseEve(R);
			mouseEve(S);
			mouseEve(T);
			mouseEve(U);
			mouseEve(V);
			mouseEve(W);
			mouseEve(X);
			mouseEve(Y);
			mouseEve(Z);
			

		
		
		tool.setEnabled(false);
		
		add(tool);
		tool.setOrientation(JToolBar.VERTICAL);
	}
	
	
	void mouseEve(JLabel label)
	{
		//label.setBorder(null);
		label.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent e)  
			    {  
				 try
				 	{
				 	//System.out.println(label);
				 	String query="Select word from words where word like '"+label.getText()+"%';";
				 	
				 		PreparedStatement ps=DBInfo.getConnection().prepareStatement(query);
				 		ResultSet rs=ps.executeQuery();
				 		WordDictView.textArea.setText("");
				 		int i=0;
				 		while(rs.next())
				 		{		
				 			i++;
				 			WordDictView.textArea.append("\n"+i+". "+rs.getString(1));
				 		}
				 		
				 	}
				 	catch(Exception f)
				 	{
				 		f.printStackTrace();
				 	}
			    }  
			 @Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				label.setForeground(Color.lightGray);
				
			}
			 @Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				label.setForeground(Color.black);
			}
		});
		tool.add(label);
	}
}

