package com.model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

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
public class HomePage extends javax.swing.JFrame {
	private JButton jButton1;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				HomePage inst = new HomePage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public HomePage() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Registration");
				jButton1.setBounds(68, 83, 152, 27);
				jButton1.setFont(new java.awt.Font("Kristen ITC",1,16));
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Recharge");
				jButton2.setBounds(328, 84, 138, 26);
				jButton2.setFont(new java.awt.Font("Kristen ITC",1,16));
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton2ActionPerformed(evt);
					}
				});
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("Billing");
				jButton3.setBounds(68, 159, 152, 26);
				jButton3.setFont(new java.awt.Font("Kristen ITC",1,16));
				jButton3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton3ActionPerformed(evt);
					}
				});
			}
			{
				jButton4 = new JButton();
				getContentPane().add(jButton4);
				jButton4.setText("tracking");
				jButton4.setBounds(328, 159, 138, 26);
				jButton4.setFont(new java.awt.Font("Kristen ITC",1,16));
				jButton4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton4ActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(598, 446);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		System.out.println("jButton1.actionPerformed, event="+evt);
		//TODO add your code for jButton1.actionPerformed
		CustomerRegistration c=new CustomerRegistration();
		this.dispose();
		c.setVisible(true);
		
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		System.out.println("jButton2.actionPerformed, event="+evt);
		//TODO add your code for jButton2.actionPerformed
		
		Recharge c=new Recharge();
		this.dispose();
		c.setVisible(true);
	}
	
	private void jButton3ActionPerformed(ActionEvent evt) {
		System.out.println("jButton3.actionPerformed, event="+evt);
		//TODO add your code for jButton3.actionPerformed
		BusFerame b=new BusFerame();
		this.dispose();
		b.setVisible(true);
		
	}
	
	private void jButton4ActionPerformed(ActionEvent evt) {
		System.out.println("jButton4.actionPerformed, event="+evt);
		//TODO add your code for jButton4.actionPerformed
		JourneyDetails c=new JourneyDetails();
		this.dispose();
		c.setVisible(true);
		
	}

}
