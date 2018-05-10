package WordDict;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;



public class Home extends JFrame
{
	JSplitPane pane;
	public Home() 
	{
		super("Home");
		setSize(500, 550);
		//setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		
		menuBar.add(mnFile);
		
		JMenuItem addword = new JMenuItem("Add");
		addword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String data=JOptionPane.showInputDialog("Insert new word:");
				String query="Insert into words(word) values('"+data+"');";
				try
				{
					PreparedStatement ps=DBInfo.getConnection().prepareStatement(query);				
					ps.executeUpdate(query);
				}
				catch(Exception f)
				{
					f.printStackTrace();
				}
			}
		});
		JMenuItem removeword = new JMenuItem("Remove");
		removeword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String data=JOptionPane.showInputDialog("Insert word to remove:");
				String query="Delete from words where word='"+data+"';";
				try
				{
					PreparedStatement ps=DBInfo.getConnection().prepareStatement(query);				
					ps.executeUpdate();
				}
				catch(Exception f)
				{
					JOptionPane.showMessageDialog(obj, "No such word!!");
				}
			}
		});
		mnFile.add(addword);
		mnFile.add(removeword);
		
		pane=new JSplitPane();
		pane.setEnabled(false);
		try {
			pane.setLeftComponent(new WordDictToolbar());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pane.setBackground(Color.white);
		pane.setRightComponent(new WordDictView());
		add(pane);
		
		
	}
	static Home obj;
	public static void main(String[] args) {
		Home obj=new Home();
		obj.setVisible(true);
	}
	

}
