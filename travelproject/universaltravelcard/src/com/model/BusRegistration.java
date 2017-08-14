package com.model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
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
public class BusRegistration extends javax.swing.JFrame {
	private JComboBox bustype;
	private JButton backbutton;
	private JButton submit;
	private JLabel busnumlabel;
	private JTextField busnum;
	private JLabel bustypelabel;
	Connection con=null;
	private JLabel jLabel1;
	Statement st=null,st1=null,st2=null;
	ResultSet rs=null,rs1=null,rs2=null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BusRegistration inst = new BusRegistration();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BusRegistration() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
		
			con=com.persistence.ConnectionFactory.getConnection();
			st=con.createStatement();
			String s="select * from BUSTYPE";
			rs=st.executeQuery(s);
			ArrayList al=new ArrayList();
			al.add("select");
			while(rs.next())
			{
				al.add(rs.getString("BUSTYPENAME"));
				
			}
			
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{				ComboBoxModel bustypeModel = 
					new DefaultComboBoxModel(al.toArray());
				bustype = new JComboBox();
				getContentPane().add(bustype);
				bustype.setModel(bustypeModel);
				bustype.setBounds(215, 128, 136, 21);
				bustype.setFont(new java.awt.Font("Lucida Calligraphy",1,11));
				bustype.setBorder(BorderFactory.createCompoundBorder(
						null, 
						null));
			}
			{
				bustypelabel = new JLabel();
				getContentPane().add(bustypelabel);
				bustypelabel.setText("Select bus type");
				bustypelabel.setBounds(70, 128, 121, 14);
				bustypelabel.setFont(new java.awt.Font("Kristen ITC",1,12));
			}
			{
				busnum = new JTextField();
				getContentPane().add(busnum);
				busnum.setBounds(215, 170, 136, 21);
				busnum.setFont(new java.awt.Font("Times New Roman",0,11));
				busnum.setOpaque(false);
			}
			{
				busnumlabel = new JLabel();
				getContentPane().add(busnumlabel);
				busnumlabel.setText("Enter Bus Number");
				busnumlabel.setBounds(70, 177, 121, 14);
				busnumlabel.setFont(new java.awt.Font("Kristen ITC",1,11));
			}
			{
				submit = new JButton();
				getContentPane().add(submit);
				submit.setText("submit");
				submit.setBounds(108, 233, 83, 21);
				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						submitActionPerformed(evt);
					}
				});
			}
			{
				backbutton = new JButton();
				getContentPane().add(backbutton);
				backbutton.setText("back");
				backbutton.setBounds(248, 233, 67, 21);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Bus Registration");
				jLabel1.setBounds(172, 42, 136, 37);
				jLabel1.setFont(new java.awt.Font("Kristen ITC",1,14));
				jLabel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			}
			pack();
			this.setSize(485, 407);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void submitActionPerformed(ActionEvent evt) {
		System.out.println("submit.actionPerformed, event="+evt);
		//TODO add your code for submit.actionPerformed
		String btype=(String) bustype.getSelectedItem();
		  String bnum=busnum.getText();
		if("select".equals(btype))
		{
			JOptionPane.showMessageDialog(null,"please select the bustype" );
		}else
		{
			if("".equals(bnum))
			{
				JOptionPane.showMessageDialog(null,"please enter the bus number" );
	
			}else
			{
				con=com.persistence.ConnectionFactory.getConnection();
				try {
					st1=con.createStatement();
					String s="select * from BUS where BUSNUM='"+bnum+"' and BUSTYPEID=(select BUSTYPEID from BUSTYPE where BUSTYPENAME='"+btype+"')";
				rs1=st1.executeQuery(s);
				if(rs1.next())
				{
					JOptionPane.showMessageDialog(null,"already bus number is registered" );

				}else 
				{
					st2=con.createStatement();
					
					String sql="insert into BUS values(bussequence.nextval,'"+bnum+"',(select BUSTYPEID from BUSTYPE where BUSTYPENAME='"+btype+"'))";
					System.out.println(sql);
					int i=st2.executeUpdate(sql);
					
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"successfully inserted" );
						bustype.setSelectedItem("select");
						busnum.setText("");
						
						
					
					}else
					{
						JOptionPane.showMessageDialog(null,"Registration failed..please try after sometime.." );

					}
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
			
		  
	}

}
