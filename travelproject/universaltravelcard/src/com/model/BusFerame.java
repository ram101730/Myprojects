package com.model;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.persistence.DataBaseLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class BusFerame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JComboBox source;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel4;
	private JTextField jTextField1;
	private JComboBox destination;

	ComboBoxModel destinationModel =null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BusFerame inst = new BusFerame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BusFerame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(192,192,192));
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Source");
				jLabel1.setBounds(67, 102, 82, 14);
				jLabel1.setFont(new java.awt.Font("Tempus Sans ITC",1,16));
				jLabel1.setBackground(new java.awt.Color(0,0,64));
			}
			{
				
				DataBaseLogic db=new DataBaseLogic();
				ArrayList<String> source1=new ArrayList<String>();
				source1=db.getSource();
				source1.add(0,"select");
				
				
				
				ComboBoxModel sourceModel = 
					new DefaultComboBoxModel(
							 source1.toArray());
				source = new JComboBox();
				getContentPane().add(source);
				source.setModel(sourceModel);
				source.setBounds(172, 99, 106, 21);
				source.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						sourceActionPerformed(evt);
					}
				});
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Destination");
				jLabel2.setBounds(67, 146, 92, 14);
				jLabel2.setFont(new java.awt.Font("Tempus Sans ITC",1,16));
			}
			{
				
				
				
				ComboBoxModel destinationModel = 
					new DefaultComboBoxModel();
				destination = new JComboBox();
				getContentPane().add(destination);
				destination.setModel(destinationModel);
				destination.setBounds(171, 143, 107, 21);
				destination.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						destinationActionPerformed(evt);
					}
				});
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Fare");
				jLabel3.setBounds(67, 196, 82, 14);
				jLabel3.setFont(new java.awt.Font("Tempus Sans ITC",1,16));
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(171, 189, 107, 21);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("DEDUCT AMOUNT");
				jButton1.setBounds(154, 268, 156, 21);
				jButton1.setFont(new java.awt.Font("Times New Roman",1,16));
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setBounds(159, 24, 119, 14);
				jLabel4.setText("ap28z1234");
				jLabel4.setFont(new java.awt.Font("Times New Roman",1,18));
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Home");
				jButton2.setBounds(329, 12, 55, 21);
				jButton2.setFont(new java.awt.Font("Tahoma",1,14));
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton2ActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(403, 437);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void sourceActionPerformed(ActionEvent evt) {
		System.out.println("source.actionPerformed, event="+evt);
		//TODO add your code for source.actionPerformed
		int selectedSource=source.getSelectedIndex();
		DataBaseLogic db=new DataBaseLogic();
		ArrayList<String> destination1=new ArrayList<String>();
		destination1=db.getDestination(selectedSource);
		destination1.add(0,"select");
		ComboBoxModel destinationModel = 
			new DefaultComboBoxModel(destination1.toArray());
		destination.setModel(destinationModel);
	}
	
	private void destinationActionPerformed(ActionEvent evt) {
		System.out.println("destination.actionPerformed, event="+evt);
		//TODO add your code for destination.actionPerformed
		DataBaseLogic db=new DataBaseLogic();
		String selectedDest=(String) destination.getSelectedItem();
		int destinationId=db.getDestinationId(selectedDest);
		
		
		int source=this.source.getSelectedIndex();
		int fare=db.getFair(source,destinationId);
		jTextField1.setText(fare+"");
		
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		System.out.println("jButton1.actionPerformed, event="+evt);
		//TODO add your code for jButton1.actionPerformed
		DataBaseLogic db=new DataBaseLogic();

		int i=JOptionPane.showConfirmDialog(null,"did u insert smart card");
		
		
		if(i==0)
		{
		System.out.println("yes");
		CardClient cc=new CardClient("str", "str");
		cc.run();
		String cardid=cc.getCardNo();
		cc.start();
		System.out.println(cardid);
		String[] cardinfo=cardid.split(",");
		
		
			int fare=Integer.parseInt(jTextField1.getText());
			
			int balance=new DataBaseLogic().getBalnce(cardinfo[0]);
			
			if(balance>0)
			{
				int i1=db.updateBalance(fare,cardinfo[0]);
				if(i1>0)
				{
					JOptionPane.showMessageDialog(null,"successfully deducted");
					int i2=db.insertJourneyDetails(source.getSelectedIndex(),cardinfo[0],"3");
					System.out.println(i2);
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"invalid smart card");
				}
		
		}
		if(i==1)
		{
		JOptionPane.showMessageDialog(null,"please insert ur smart card");	
		}
	
		}
		else
		{
			JOptionPane.showMessageDialog(null,"no balance");
		}
		
			}
			
			
			
					
	
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		System.out.println("jButton2.actionPerformed, event="+evt);
		//TODO add your code for jButton2.actionPerformed
		this.dispose();
		HomePage h=new HomePage();
		h.setVisible(true);
	}

}
