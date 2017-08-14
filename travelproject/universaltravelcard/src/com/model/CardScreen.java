package com.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class CardScreen extends JFrame implements ActionListener {
	JLabel cardLabel;

	JTextField cardField;

	JButton issueButton;

	Dimension leftdimension = new Dimension(50, 25);

	Dimension rightdimension = new Dimension(250, 25);

	int hStrut = 20;

	int vStrut = 10;

	CardScreen() {

		setLayout(new FlowLayout());

		cardLabel = new JLabel("Card No");
		cardLabel.setPreferredSize(leftdimension);

		cardField = new JTextField();
		cardField.setPreferredSize(rightdimension);

		issueButton = new JButton("Store");
		issueButton.setActionCommand("Issue");
		issueButton.setToolTipText("Click this button to Reset the fields");
		issueButton.addActionListener(this);

		Box mainBox = new Box(BoxLayout.Y_AXIS);
		Box cardBox = new Box(BoxLayout.X_AXIS);
		Box buttonBox = new Box(BoxLayout.X_AXIS);

		cardBox.add(cardLabel);
		cardBox.add(Box.createHorizontalStrut(hStrut));
		cardBox.add(cardField);

		buttonBox.add(issueButton);
		buttonBox.add(Box.createHorizontalStrut(hStrut));

		mainBox.add(cardBox);
		mainBox.add(Box.createVerticalStrut(vStrut));
		mainBox.add(buttonBox);

		BevelBorder bevelBorder = new BevelBorder(BevelBorder.RAISED);
		LineBorder lineBorder = new LineBorder(Color.pink, 3);
		String title = "Issue Card";
		TitledBorder titledBorder = new TitledBorder(lineBorder, title);

		mainBox.setBorder(new CompoundBorder(bevelBorder, titledBorder));

		add(mainBox);
		setVisible(true);
		setSize(500, 400);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == issueButton) {
			issueCards();
		}

	}

	public void issueCards() {
		
		CardClient cardClient = new CardClient("issueCard", cardField.getText());
		cardClient.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		while (!cardClient.isCardInserted) {
			System.out.println("Insert card");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			cardClient.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (cardClient.status) {
			System.out.println(cardClient.response);
		}
	}

	public static void main(String[] args) {
		new CardScreen();
	}
}
