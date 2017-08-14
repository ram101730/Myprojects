package com.model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BorderFactory;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
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
public class CustomerRegistration extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField firstname;
	private JLabel jLabel2;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton jButton1;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private ButtonGroup buttonGroup1;
	private JLabel jLabel10;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton1;
	private JLabel jLabel8;
	private JTextField pancardid;
	private JLabel jLabel7;
	private JTextField aadharid;
	private JLabel jLabel6;
	private JTextField mobile;
	private JTextField emailid;
	private JTextField lastname;
	private JComboBox state;
	private JFileChooser jFileChooser1;
	private JButton jButton2;
	private JLabel jLabel14;
	private JLabel jLabel13;
	private JTextField jTextField1;
	private JComboBox City;
	private JLabel jLabel9;
	private JComboBox country;
	ComboBoxModel CityModel=null;
	String path=null;
	ButtonGroup bg=new ButtonGroup();
	Connection con=null;
	private JButton jButton3;
	Statement st=null;
	ResultSet rs=null;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CustomerRegistration inst = new CustomerRegistration();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public CustomerRegistration() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(329, 518);
			}
			{
				getContentPane().setLayout(null);
			}
			{
				this.setSize(375, 340);
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("First Name");
				jLabel1.setBounds(70, 48, 53, 14);
			}
			{
				firstname = new JTextField();
				getContentPane().add(firstname);
				firstname.setBounds(158, 45, 93, 21);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Last Name");
				jLabel2.setBounds(70, 79, 53, 14);
			}
			{
				lastname = new JTextField();
				getContentPane().add(lastname);
				lastname.setBounds(158, 76, 93, 21);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Email ID");
				jLabel4.setBounds(70, 146, 38, 14);
			}
			{
				emailid = new JTextField();
				getContentPane().add(emailid);
				emailid.setBounds(158, 143, 93, 21);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Mobile");
				jLabel5.setBounds(70, 183, 30, 14);
			}
			{
				MaskFormatter ms=new MaskFormatter("##########");
				mobile = new JFormattedTextField(ms);
				getContentPane().add(mobile);
				mobile.setBounds(158, 180, 93, 21);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Aadhar ID");
				jLabel6.setBounds(70, 224, 49, 14);
			}
			{
				aadharid = new JTextField();
				getContentPane().add(aadharid);
				aadharid.setBounds(158, 221, 93, 21);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Pancard ID");
				jLabel7.setBounds(70, 266, 53, 14);
			}
			{
				pancardid = new JTextField();
				getContentPane().add(pancardid);
				pancardid.setBounds(158, 263, 93, 21);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("Gender");
				jLabel8.setBounds(70, 319, 35, 14);
			}
			{
				jRadioButton1 = new JRadioButton();
				getContentPane().add(jRadioButton1);
				jRadioButton1.setText("Male");
				jRadioButton1.setBounds(158, 315, 40, 18);
			
				jRadioButton2 = new JRadioButton();
				getContentPane().add(jRadioButton2);
				jRadioButton2.setText("Female");
				jRadioButton2.setBounds(209, 315, 52, 18);
				jRadioButton2.setOpaque(false);
				bg.add(jRadioButton1);
				bg.add(jRadioButton2);
				
			}
			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("Street");
				jLabel9.setBounds(71, 363, 30, 14);
			}
			{
				jLabel10 = new JLabel();
				getContentPane().add(jLabel10);
				jLabel10.setText("City");
				jLabel10.setBounds(70, 472, 36, 14);
			}
			{
				CityModel = 
					new DefaultComboBoxModel();
				City = new JComboBox();
				getContentPane().add(City);
				City.setModel(CityModel);
				City.setBounds(162, 470, 89, 19);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Submit");
				jButton1.setBounds(189, 519, 72, 21);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});

			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(162, 360, 89, 21);
			}
			{
				jLabel11 = new JLabel();
				getContentPane().add(jLabel11);
				jLabel11.setText("Country");
				jLabel11.setBounds(71, 400, 39, 14);
			}
			{
				
				ArrayList<String> countryList=new ArrayList<String>();
				DataBaseLogic db=new DataBaseLogic();
				countryList=db.getCountries();
				countryList.add(0,"select");
				
				ComboBoxModel countryModel = 
					new DefaultComboBoxModel(countryList.toArray());
				country = new JComboBox();
				getContentPane().add(country);
				country.setModel(countryModel);
				country.setBounds(162, 397, 89, 24);
				country.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						countryActionPerformed(evt);
					}
				});

			}
			{
				jLabel12 = new JLabel();
				getContentPane().add(jLabel12);
				jLabel12.setText("State");
				jLabel12.setBounds(70, 438, 26, 14);
			}
			{
				ComboBoxModel stateModel = 
					new DefaultComboBoxModel();
				state = new JComboBox();
				getContentPane().add(state);
				state.setModel(stateModel);
				state.setBounds(162, 435, 89, 21);
				state.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						stateActionPerformed(evt);
					}
				});

			}
			{
				jLabel13 = new JLabel();
				getContentPane().add(jLabel13);
				jLabel13.setText("Image");
				jLabel13.setBounds(287, 52, 50, 14);
			}
			{
				jLabel14 = new JLabel();
				getContentPane().add(jLabel14);
				jLabel14.setBounds(337, 52, 82, 119);
				jLabel14.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Browse");
				jButton2.setBounds(343, 192, 60, 21);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton2ActionPerformed(evt);
					}
				});
			}
			{
				jFileChooser1 = new JFileChooser();
				getContentPane().add(jFileChooser1);
				//jFileChooser1.setBounds(245, 213, 216, 100);
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("Home");
				jButton3.setBounds(364, 5, 69, 21);
				jButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton3ActionPerformed(evt);
					}
				});
			}

			pack();
			this.setSize(466, 595);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		System.out.println("jButton1.actionPerformed, event="+evt);
		System.out.println("++++++++++++++++++++++++hai");
		
		
		
		//TODO add your code for jButton1.actionPerformed
		String custMailId,custImg,custFirstName,custLastName,custMobile,custPanId,custAdharId,custGender,custStreet,custCity;
		custFirstName=firstname.getText();
	    custLastName=lastname.getText();
	    custMailId=emailid.getText();
	    custMobile=mobile.getText();
	    custAdharId=aadharid.getText();
	    custPanId=pancardid.getText();
	    custGender=null;
	    if(jRadioButton1.isSelected())
	    {
	    	custGender="male";
	    }
	    if(jRadioButton2.isSelected())
	    {
	    	custGender="female";
	    }
	    custCity=City.getSelectedIndex()+"";
	    
	    if("".equals(custFirstName)){
	    	JOptionPane.showMessageDialog(null, "First name should not be empty");
	    }
	    else{
	    	
	    	if("".equals(custLastName)){
	    		JOptionPane.showMessageDialog(null, "last name should not be empty");
	    	}else{
	    		
	    		if("".equals(custMailId)){
	    			
	    			JOptionPane.showMessageDialog(null, "email id should not be empty");
	    		}else{
	    			
	    			if("".equals(custMobile)){
		    			
		    			JOptionPane.showMessageDialog(null, "mobile no should not be empty");
		    		}
	    			else{
	    				if("".equals(custAdharId)){
			    			
			    			JOptionPane.showMessageDialog(null, "Adhar Id should not be empty");
			    		}
	    				else{
	    					
	    					
	    					if("".equals(custPanId)){
				    			
				    			JOptionPane.showMessageDialog(null, "Customer Pan Id should not be empty");
				    		}
	    					
	    					
	    					else{
	    						
	    						if("".equals(path)){
	    							JOptionPane.showMessageDialog(null, "Please choose the customer image");
	    						}
	    						
			    				else{
			    						
			    						
			    						if("".equals(custCity)&&"select".equals(custCity)){
							    			
							    			JOptionPane.showMessageDialog(null, "Please select the city");
							    		}
			    						else{
			    							con=com.persistence.ConnectionFactory.getConnection();
			    							try {
												st=con.createStatement();
												String sql="select * from USERDETAILS where CUST_EMAILID='"+custMailId+"'";
												rs=st.executeQuery(sql);
												if(rs.next()){
													
													JOptionPane.showMessageDialog(null, "Already some user exists with email id, so please choose another..");
												}
												else{
													
													custStreet=jTextField1.getText();
												    DataBaseLogic db=new DataBaseLogic();
												    int i=db.insertDetails(custMailId,path,custFirstName,custLastName,custMobile,custPanId,custAdharId,custGender,custStreet,custCity);
												    System.out.println(i);
												    if(i>0)
												    {
												    	JOptionPane.showMessageDialog(null,"succesfully registered");
												    	firstname.setText("");
												    	lastname.setText("");
												    	emailid.setText("");
												    	mobile.setText("");
												    	aadharid.setText("");
												    	pancardid.setText("");
												    	bg.clearSelection();
												    	City.setSelectedItem("select");
												    	state.setSelectedItem("select");
												    	country.setSelectedItem("select");
												    	jTextField1.setText("");
												    	
												    jLabel14.setIcon(null);
												    }
												    else
												    {
												    	JOptionPane.showMessageDialog(null,"not succesfully registered");
		
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
	    			
	    		}
	    		
	    		
	    	}
	    }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
	
	private void countryActionPerformed(ActionEvent evt) {
		System.out.println("country.actionPerformed, event="+evt);
		//TODO add your code for country.actionPerformed
		int countryId=country.getSelectedIndex();
		ArrayList<String> stateList=new ArrayList<String>();
		DataBaseLogic db=new DataBaseLogic();
		stateList=db.getStates(countryId);
		stateList.add(0,"select");
		ComboBoxModel stateModel = 
			new DefaultComboBoxModel(stateList.toArray());
		state.setModel(stateModel);
		
	}
	
	private void stateActionPerformed(ActionEvent evt) {
		System.out.println("state.actionPerformed, event="+evt);
		//TODO add your code for state.actionPerformed
		
		int stateId=state.getSelectedIndex();
		ArrayList<String> cityList=new ArrayList<String>();
		DataBaseLogic db=new DataBaseLogic();
		cityList=db.getCities(stateId);
		cityList.add(0,"select");
		ComboBoxModel cityModel = 
			new DefaultComboBoxModel(cityList.toArray());
		City.setModel(cityModel);
		
		
		
		
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		System.out.println("jButton2.actionPerformed, event="+evt);
		//TODO add your code for jButton2.actionPerformed
		
		
		jFileChooser1.showOpenDialog(jFileChooser1);
		
		path=jFileChooser1.getSelectedFile().toString();
		System.out.println(path);
		
		ImageIcon i=new ImageIcon(path);
		jLabel14.setIcon(i);
		
	}
	
	private void jButton3ActionPerformed(ActionEvent evt) {
		System.out.println("jButton3.actionPerformed, event="+evt);
		//TODO add your code for jButton3.actionPerformed
		this.dispose();
		HomePage h=new HomePage();
		h.setVisible(true);
	}

}
