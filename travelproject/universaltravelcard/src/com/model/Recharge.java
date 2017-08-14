package com.model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
public class Recharge extends javax.swing.JFrame {
	private JTextField smartcardid;
	private JLabel smartcardlabel;
	private JLabel amountlabel;
	private JComboBox amount;
	private JButton getidlabel;
	private JButton submitbutton;
Connection con=null;
Statement st=null,st1=null;
ResultSet rs=null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Recharge inst = new Recharge();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Recharge() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				smartcardid = new JTextField();
				getContentPane().add(smartcardid);
				smartcardid.setBounds(171, 59, 98, 21);
			}
			{
				smartcardlabel = new JLabel();
				getContentPane().add(smartcardlabel);
				smartcardlabel.setText("Smart Card ID");
				smartcardlabel.setBounds(69, 66, 111, 14);
			}
			{
				amountlabel = new JLabel();
				getContentPane().add(amountlabel);
				amountlabel.setText("Amount");
				amountlabel.setBounds(69, 105, 96, 14);
			}
			{
				submitbutton = new JButton();
				getContentPane().add(submitbutton);
				submitbutton.setText("Submit");
				submitbutton.setBounds(131, 165, 46, 21);
				submitbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						submitbuttonActionPerformed(evt);
					}
				});
			}
			{
				getidlabel = new JButton();
				getContentPane().add(getidlabel);
				getidlabel.setText("Recharge");
				getidlabel.setBounds(303, 12, 78, 21);
				getidlabel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						getidlabelActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel amountModel = 
					new DefaultComboBoxModel(
							new String[] {"Select","100","200","300","400","500","1000"});
				amount = new JComboBox();
				getContentPane().add(amount);
				amount.setModel(amountModel);
				amount.setBounds(171, 102, 98, 21);
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
		
	String smartcard=smartcardid.getText();
		String amnt=(String) amount.getSelectedItem();
		if("".equals(smartcard)){
			JOptionPane.showMessageDialog(null,"Smart card id should not be null");
			
		}else{
			if("select".equalsIgnoreCase(amnt)){
				JOptionPane.showMessageDialog(null,"Please select the amount");
			}
			else{
					
				con=com.persistence.ConnectionFactory.getConnection();
				try {
					st=con.createStatement();
					String sql="select * from SMARTCARD where SCARD_ID='"+smartcard+"'";
					rs=st.executeQuery(sql);
					if(rs.next())
					{
					Double	amt=Double.parseDouble(amnt);
					Double balance=rs.getDouble(2);
					balance=balance+amt;
					st1=con.createStatement();
					String query="update SMARTCARD set SCARD_BALANCE='"+balance+"' where SCARD_ID='"+smartcard+"'";
					int i=st1.executeUpdate(query);
					if(i>0)
					{
					JOptionPane.showMessageDialog(null,"successfully recharged");
								
					}else{
						
						
						JOptionPane.showMessageDialog(null,"not recharged successfully ");
						smartcardid.setText("");
						amount.setSelectedItem("Select");

					}
					
					}
					else
					{
						JOptionPane.showMessageDialog(null,"invalid smart card id...");
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				
			}
		}
		
	}
	
	private void getidlabelActionPerformed(ActionEvent evt) {
		System.out.println("getidlabel.actionPerformed, event="+evt);
		//TODO add your code for getidlabel.actionPerformed
		this.dispose();
		HomePage h=new HomePage();
		h.setVisible(true);
	}

}
