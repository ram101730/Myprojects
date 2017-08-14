package com.model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Tracking extends javax.swing.JFrame {
	private JLabel smartcardlabel;
	private JButton submitbutton;
	private JButton getid;
	private JComboBox destination;
	private JLabel destinationlabel;
	private JLabel sourcelabel;
	private JComboBox source;
	private JTextField smartcard;
	Connection con=null;
	private JComboBox busnumber;
	private JLabel busnumberlabel;
	Statement st=null,st1=null,st2=null,st3=null,st4=null,st5=null, st6=null;
	ResultSet rs=null,rs1=null,rs2=null,rs3=null,rs4=null;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Tracking inst = new Tracking();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Tracking() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				smartcardlabel = new JLabel();
				getContentPane().add(smartcardlabel);
				smartcardlabel.setText("Smart Card Id");
				smartcardlabel.setBounds(77, 56, 67, 14);
			}
			{
				smartcard = new JTextField();
				getContentPane().add(smartcard);
				smartcard.setBounds(175, 53, 123, 21);
			}
			{
				con=com.persistence.ConnectionFactory.getConnection();
				st=con.createStatement();
				String sql="select * from STATION";
				rs=st.executeQuery(sql);
				ArrayList a=new ArrayList();
				a.add("From");
				while(rs.next())
				{
					a.add(rs.getString(2));
					
				}
				
				
				ComboBoxModel sourceModel = 
					new DefaultComboBoxModel(a.toArray());
				source = new JComboBox();
				getContentPane().add(source);
				source.setModel(sourceModel);
				source.setBounds(175, 108, 123, 21);
			}
			{
				sourcelabel = new JLabel();
				getContentPane().add(sourcelabel);
				sourcelabel.setText("Source");
				sourcelabel.setBounds(84, 111, 33, 14);
			}
			{
				destinationlabel = new JLabel();
				getContentPane().add(destinationlabel);
				destinationlabel.setText("Destination");
				destinationlabel.setBounds(84, 144, 54, 14);
			}
			{
				con=com.persistence.ConnectionFactory.getConnection();
				st1=con.createStatement();
				String sql="select * from STATION";
				rs1=st1.executeQuery(sql);
				ArrayList a1=new ArrayList();
				a1.add("To");
				while(rs1.next())
				{
					a1.add(rs1.getString(2));
					
				}
				
				
				
				ComboBoxModel destinationModel = 
					new DefaultComboBoxModel(a1.toArray());
				destination = new JComboBox();
				getContentPane().add(destination);
				destination.setModel(destinationModel);
				destination.setBounds(175, 141, 123, 21);
			}
			{
				getid = new JButton();
				getContentPane().add(getid);
				getid.setText("Get  ID");
				getid.setBounds(320, 53, 51, 21);
			}
			{
				submitbutton = new JButton();
				getContentPane().add(submitbutton);
				submitbutton.setText("Submit");
				submitbutton.setBounds(144, 184, 46, 21);
				submitbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						submitbuttonActionPerformed(evt);
					}
				});
			}
			{
				busnumberlabel = new JLabel();
				getContentPane().add(busnumberlabel);
				busnumberlabel.setText("Bus Number");
				busnumberlabel.setBounds(77, 86, 57, 14);
			}
			{
				con=com.persistence.ConnectionFactory.getConnection();
				st4=con.createStatement();
				String s="select * from BUS";
				rs4=st4.executeQuery(s);
				ArrayList a1=new ArrayList();
				a1.add("Select");
				while(rs4.next())
				{
					a1.add(rs4.getString(2));
					
				}
				
				
				ComboBoxModel busnumberModel = 
					new DefaultComboBoxModel(a1.toArray());
				busnumber = new JComboBox();
				getContentPane().add(busnumber);
				busnumber.setModel(busnumberModel);
				busnumber.setBounds(175, 83, 123, 21);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void submitbuttonActionPerformed(ActionEvent evt) {
		System.out.println("submitbutton.actionPerformed, event="+evt);
		//TODO add your code for submitbutton.actionPerformed
		String busnum=(String) busnumber.getSelectedItem();
		
		
		
		String scard=smartcard.getText();
		String source1=(String) source.getSelectedItem();
		String dest=(String) destination.getSelectedItem();
		if("".equalsIgnoreCase(scard))
		{
			JOptionPane.showMessageDialog(null,"please enter smart card id");
			
			
		}else{
			if("select".equalsIgnoreCase(busnum))
			{
				
				JOptionPane.showMessageDialog(null, "please select bus number");
				
			}else
			{
				
				
			
			if("From".equalsIgnoreCase(source1)){
				JOptionPane.showMessageDialog(null, "please select the source");
				
			}
			else{
				if("To".equalsIgnoreCase(dest)){
					JOptionPane.showMessageDialog(null, "please select the destination");
					
				}
			
				else{	
					con=com.persistence.ConnectionFactory.getConnection();
					try {
						st2=con.createStatement();
						String sql="select * from SMARTCARD where SCARD_ID='"+scard+"'";
						rs2=st2.executeQuery(sql);
						if(rs2.next())
						{
							
							String sid=rs2.getString(1); 
							Double balance=rs.getDouble(2);
							st5=con.createStatement();
							String query="insert into JOURNEY values(journeysequence.nextval,'"+sid+"', (select BUSID from bus where BUSNUM='"+busnum+"'), sysdate )";
							System.out.println(query);
							int i=st5.executeUpdate(query);
							if(i>0){
								
								
							}
							//balance=balance+amt;
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
			
			}
		
		
	}
	}
}
