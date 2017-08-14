package com.model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.persistence.DataBaseLogic;


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
public class SmartCardDetails extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField smartcardid;
	private JLabel jLabel2;
	private JTextField smartcardbalance;
	private JLabel jLabel3;
	private JTextField smartcardpin;
	private JLabel jLabel4;
	private JTextField customeremailid;
	private JButton jButton1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SmartCardDetails inst = new SmartCardDetails();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public SmartCardDetails() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Smart Card ID");
				jLabel1.setBounds(72, 63, 81, 14);
			}
			{
				DataBaseLogic db=new DataBaseLogic();
				int pk=db.getPrimaryKey("SCARD_ID","smartcard");
				smartcardid = new JTextField();
				smartcardid.setText(pk+"SMRTC");
				smartcardid.setEditable(false);
				getContentPane().add(smartcardid);
				smartcardid.setBounds(158, 60, 109, 21);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Smart Card Balance");
				jLabel2.setBounds(46, 103, 114, 14);
			}
			{
				smartcardbalance = new JTextField();
				getContentPane().add(smartcardbalance);
				smartcardbalance.setBounds(158, 100, 109, 21);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Smart Card Pin");
				jLabel3.setBounds(69, 147, 89, 14);
			}
			{
				smartcardpin = new JTextField();
				getContentPane().add(smartcardpin);
				smartcardpin.setBounds(158, 144, 109, 21);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Customer Email ID");
				jLabel4.setBounds(53, 186, 110, 14);
			}
			{
				customeremailid = new JTextField();
				getContentPane().add(customeremailid);
				customeremailid.setBounds(158, 183, 109, 21);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Submit");
				jButton1.setBounds(158, 228, 81, 21);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	
	
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		System.out.println("jButton1.actionPerformed, event="+evt);
		//TODO add your code for jButton1.actionPerformed
		String smartCardId,smartCardBalance,smartCardPin,customerEmailId;
		smartCardId=smartcardid.getText();
	    smartCardBalance=smartcardbalance.getText();
	    smartCardPin=smartcardpin.getText();
	    customerEmailId=customeremailid.getText();
	    
	    if("".equals(smartCardId)){
	    	JOptionPane.showMessageDialog(null, "smart card id should not be empty");
	    }
	    else{
	    	
	    	if("".equals(smartCardBalance)){
	    		JOptionPane.showMessageDialog(null, "smartcard balance should not be empty");
	    	}else{
	    		
	    		if("".equals(smartCardPin)){
	    			
	    			JOptionPane.showMessageDialog(null, "smartCardPin should not be empty");
	    		}else{
	    			
	    			if("".equals(customerEmailId)){
		    			
		    			JOptionPane.showMessageDialog(null, "customerEmailId should not be empty");
		    		}
	    			else{
	    				Connection con=com.persistence.ConnectionFactory.getConnection();
	    				try {
							Statement st=con.createStatement();
							String hai="select * from USERDETAILS where CUST_EMAILID='"+customerEmailId+"'";
							ResultSet rs=st.executeQuery(hai);
							if(rs.next()){
								

								
								Statement st1=con.createStatement();
						 String s="select * from SMARTCARD where SCARD_ID='"+smartCardId+"'";
						 ResultSet rs1=st1.executeQuery(s);
						
							 DataBaseLogic db=new DataBaseLogic();
							    int i=db.insertsmartCardDetails(smartCardId,smartCardBalance,smartCardPin,customerEmailId);
							    System.out.println(i);
							    if(i>0)
							    {
							    	String smartCardId1=smartcardid.getText();
							    	smartCardId1=smartCardId1+",";
							    	int len=smartCardId1.length();
							    	for (int j = 0; j <110-len; j++) {
										smartCardId1=smartCardId1+"0";
										
									}
							    	
							    	
							    	CardClient cardClient = new CardClient("issueCard",smartCardId1);
									cardClient.start();
							    	
							    	
							    	
							    	JOptionPane.showMessageDialog(null,"succesfully registered");
							    
							    
							    
							    }
							    else
							    {
							    	JOptionPane.showMessageDialog(null,"not succesfully registered");

							    
							 
						 }
							 
								
					
							}
							else{
								JOptionPane.showMessageDialog(null, "the user you entered doesn't exist");
							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    				
	    			}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   
	
	}

}
	    }}
}