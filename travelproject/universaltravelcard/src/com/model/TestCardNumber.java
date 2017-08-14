package com.model;
public class TestCardNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardClient cc=new CardClient("str", "str");
		cc.run();

		String cardid=cc.getCardNo();

		cc.start();
		System.out.println(cardid);
		String[] cardinfo=cardid.split(",");
//				
	}
}
