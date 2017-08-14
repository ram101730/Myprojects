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
public class BusLocation extends javax.swing.JFrame {
	private JLabel buslocationlabel;
	private JComboBox station;
	Connection con=null;
	private JButton submitbutton;
	private JTextField distance;
	private JLabel distancelabel;
	private JComboBox destination;
	private JLabel destinationlabel;
	private JLabel busroutelabel;
	private JComboBox jComboBox1;
	private JLabel busroute;
	Statement st=null,st1=null,st2=null,st3=null;
	ResultSet rs=null,rs1=null,rs2=null,rs3=null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BusLocation inst = new BusLocation();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BusLocation() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
	
			
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				buslocationlabel = new JLabel();
				getContentPane().add(buslocationlabel);
				buslocationlabel.setText("Source");
				buslocationlabel.setBounds(56, 121, 96, 17);
				buslocationlabel.setFont(new java.awt.Font("Times New Roman",1,14));
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
				ComboBoxModel stationModel = 
					new DefaultComboBoxModel(a.toArray());
				station = new JComboBox();
				getContentPane().add(station);
				station.setModel(stationModel);
				station.setBounds(170, 117, 113, 21);
			}
			{
				busroute = new JLabel();
				getContentPane().add(busroute);
				busroute.setBounds(58, 111, 80, 14);
			}
			{
				con=com.persistence.ConnectionFactory.getConnection();
				st1=con.createStatement();
				String s="select * from BUS";
				rs1=st1.executeQuery(s);
				ArrayList a1=new ArrayList();
				a1.add("Select");
				while(rs1.next())
				{
					a1.add(rs1.getString(2));
					
				}
				
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(a1.toArray());
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(170, 64, 113, 21);
			}
			{
				busroutelabel = new JLabel();
				getContentPane().add(busroutelabel);
				busroutelabel.setText("Bus Route");
				busroutelabel.setBounds(62, 67, 49, 14);
			}
			{
				
				destinationlabel = new JLabel();
				getContentPane().add(destinationlabel);
				destinationlabel.setText("Destination");
				destinationlabel.setBounds(58, 167, 54, 14);
			}
			{
				con=com.persistence.ConnectionFactory.getConnection();
				st2=con.createStatement();
				String s2="select * from STATION";
				rs2=st2.executeQuery(s2);
				ArrayList a2=new ArrayList();
				a2.add("TO");
				while(rs2.next())
				{
					a2.add(rs2.getString(2));
					
				}
				
				
				ComboBoxModel destinationModel = 
					new DefaultComboBoxModel(a2.toArray());
				destination = new JComboBox();
				getContentPane().add(destination);
				destination.setModel(destinationModel);
				destination.setBounds(170, 160, 113, 21);
			}
			{
				distancelabel = new JLabel();
				getContentPane().add(distancelabel);
				distancelabel.setText("Distance");
				distancelabel.setBounds(58, 207, 41, 14);
			}
			{
				distance = new JTextField();
				getContentPane().add(distance);
				distance.setBounds(170, 207, 113, 21);
			}
			{
				submitbutton = new JButton();
				getContentPane().add(submitbutton);
				submitbutton.setText("Submit");
				submitbutton.setBounds(175, 258, 46, 21);
				submitbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						submitbuttonActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(470, 369);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		finally{
			if(rs2!=null){
				
				try {
					rs2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(st2!=null){
				
				try {
					st2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(rs1!=null){
				
				try {
					rs1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(st1!=null){
				
				try {
					st1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(rs!=null){
				
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(st!=null){
				
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}if(con!=null){
				
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
		
	}
	
	private void submitbuttonActionPerformed(ActionEvent evt) {
		System.out.println("submitbutton.actionPerformed, event="+evt);
		//TODO add your code for submitbutton.actionPerformed
		
		String buno=(String) jComboBox1.getSelectedItem();
		String source=(String) station.getSelectedItem();
		String dest=(String) destination.getSelectedItem();
		String dist=distance.getText();
		if("select".equals(buno)){
			JOptionPane.showMessageDialog(null, "please select the bus no");
			
		}
		else{
			
			if("From".equalsIgnoreCase(source)){
				JOptionPane.showMessageDialog(null, "please select the source");
				
			}
			else{
				if("To".equalsIgnoreCase(dest)){
					JOptionPane.showMessageDialog(null, "please select the destination");
					
				}
				else{
					
					if("".equals(dist)){
						JOptionPane.showMessageDialog(null, "please enter the distance");
						
					}
					else{
						
						con=com.persistence.ConnectionFactory.getConnection();
						try {
							st3=con.createStatement();
							String query="insert into STATION_STATION1 values((select STATIONID from STATION where STATIONAME='"+source+"' ),(select STATIONID from STATION where STATIONAME='"+dest+"'),"+dist+",(select "+dist+"*(select COSTPERKM from BUSTYPE where BUSTYPEID=(select BUSTYPEID from bus where BUSNUM='"+buno+"')) from dual),(select BUSID from BUS where BUSNUM='"+buno+"') )";
						System.out.println(query);
						int i=st3.executeUpdate(query);
						if(i>0){
							JOptionPane.showMessageDialog(null, "successfully registered");
						}
						else{
							JOptionPane.showMessageDialog(null, " registation failed");
							
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
