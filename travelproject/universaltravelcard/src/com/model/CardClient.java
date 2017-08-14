package com.model;
import java.util.List;

import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CardTerminals;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

public class CardClient extends Thread {

	CardChannel channel = null;

	private final byte PDS_CLA = (byte) 0xB0;

	private final byte GET_CARD_NO = (byte) 0x60;
	
	private final byte SET_CARD_NO= (byte) 0x70;
	
	byte P1 = (byte) 0x00;

	byte P2 = (byte) 0x00;

	String data = "";

	public String response = "";

	public boolean status;

	String action;
	
	public boolean isCardInserted;
	
	public CardClient(String action, String data){
		this.action=action;
		this.data=data;
	}
	
	public void run() {
		TerminalFactory terminalFactory = TerminalFactory.getDefault();
		CardTerminals cardTerminals = terminalFactory.terminals();
		List cardTerminalList = null;
		try {
			cardTerminalList = cardTerminals.list();
		} catch (CardException e) {
			e.printStackTrace();
		}
		CardTerminal terminal = (CardTerminal) cardTerminalList.get(0);
		isCardInserted(terminal);
	}

	public void isCardInserted(CardTerminal terminal) {
		Card card = null;
		try {
			if (terminal.waitForCardPresent(0)) {
				isCardInserted = true;
				
				card = terminal.connect("*");
				
				System.out.println("card:::" + card);
				channel = card.getBasicChannel();
				
				if(action.equals("getCard")){
					response=getCardNo();
					status=true;
				} 
				if(action.equals("issueCard")){
					response=issueCard(data);
					status=true;
				}				
			}
		} catch (CardException e1) {
			e1.printStackTrace();
		}
	}

	
	public boolean selectApplet() {
		byte[] SELECT = { (byte) 0x00, (byte) 0xA4, (byte) 0x04, (byte) 0x00,
				(byte) 0x0a, (byte) 0xa0, (byte) 0x00, (byte) 0x00,
				(byte) 0x00, (byte) 0x62, (byte) 0x03, (byte) 0x01,
				(byte) 0x0c, (byte) 0x06, (byte) 0x01 };
		

		// byte[] VERIFY = {(byte) 0xB0, (byte) 0x20, (byte) 0x00, (byte) 0x00,
		// (byte) 0x04, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};

		CommandAPDU comAPDU = new CommandAPDU(SELECT);
		ResponseAPDU resAPDU = null;
		try {
			resAPDU = channel.transmit(comAPDU);
		} catch (CardException e) {
			e.printStackTrace();
		}
		
		String status = Integer.toHexString(resAPDU.getSW());		
		System.out.println("Status is------------:" + status);
		
		if (status.equals("9000")) {
			System.out.println("Applet selected");
			return true;
		}
		System.out.println("Applet not sleected retrning false---------------");
		return false;
	}

		
	public String issueCard(String cardNo) {
		byte[] cardbyteArray = convertToHexString(cardNo);

		boolean select = selectApplet();

		if (select == true) {
			CommandAPDU comAPDU = new CommandAPDU(PDS_CLA, SET_CARD_NO, P1,
					P2, cardbyteArray, 0x00, 0x6E);
			ResponseAPDU resAPDU = null;

			try {
				resAPDU = channel.transmit(comAPDU);
				
				String status = Integer.toHexString(resAPDU.getSW());
				
				System.out.println("Status is------------:" + status);
				if (status.equals("9000")) {
					System.out.println("Status True");
					return "success";
				} else {
					return "failed";
				}
			} catch (CardException e) {
				e.printStackTrace();
			}
		} else {
			return "selection failed";
		}
		return null;

	}

	public String getCardNo() {
		boolean select = selectApplet();

		if (select == true) {
			CommandAPDU comAPDU = new CommandAPDU(PDS_CLA, GET_CARD_NO,
					P1, P2, 0x6E);
			ResponseAPDU resAPDU = null;

			try {
				resAPDU = channel.transmit(comAPDU);
				
				String status = Integer.toHexString(resAPDU.getSW());
				System.out.println("Status is------------:" + status);
				
				if (status.equals("9000")) {
					byte[] cardNo = resAPDU.getData();
					String card = "";
					char c;
					for (int i = 0; i < cardNo.length; i++) {
						String ch = cardNo[i] + "";
						byte b = Byte.valueOf(ch,10);
						if(b==10)
						{
							c='a';
							card += c + "";
						}else if(b==11)
						{
							c='b';
							card += c + "";
						} 
						else if(b==12)
						{
							c='c';
							card += c + "";
						}
						
						else if(b==13)
						{
							c='d';
							card += c + "";
						}
						else if(b==14)
						{
							c='e';
							card += c + "";
						}
						else if(b==15)
						{
							c='f';
							card += c + "";
						}
						else if(b==16)
						{
							c='g';
							card += c + "";
						}
						else if(b==17)
						{
							c='h';
							card += c + "";
						}
						else if(b==18)
						{
							c='i';
							card += c + "";
						}
						else if(b==19)
						{
							c='j';
							card += c + "";
						}
						else if(b==20)
						{
							c='k';
							card += c + "";
						}
						else if(b==21)
						{
							c='l';
							card += c + "";
						}
						else if(b==22)
						{
							c='m';
							card += c + "";
						}
						else if(b==23)
						{
							c='n';
							card += c + "";
						}
						else if(b==24)
						{
							c='o';
							card += c + "";
						}
						else if(b==25)
						{
							c='p';
							card += c + "";
						}
						else if(b==26)
						{
							c='q';
							card += c + "";
						}
						else if(b==27)
						{
							c='r';
							card += c + "";
						}
						else if(b==28)
						{
							c='s';
							card += c + "";
						}
						else if(b==29)
						{
							c='t';
							card += c + "";
						}
						else if(b==30)
						{
							c='u';
							card += c + "";
						}
						else if(b==31)
						{
							c='v';
							card += c + "";
						}
						else if(b==32)
						{
							c='w';
							card += c + "";
						}
						else if(b==33)
						{
							c='x';
							card += c + "";
						}
						else if(b==34)
						{
							c='y';
							card += c + "";
						}
						else if(b==35)
						{
							c='z';
							card += c + "";
						}else if(b==36)
						{
							c=',';
							card += c + "";
						}else if(b==37)
						{
							c=' ';
							card += c + "";
						}
						else if(b==38)
						{
							c='A';
							card += c + "";
						}
						else if(b==39)
						{
							c='B';
							card += c + "";
						}
						else if(b==40)
						{
							c='C';
							card += c + "";
						}
						else if(b==41)
						{
							c='D';
							card += c + "";
						}
						else if(b==42)
						{
							c='E';
							card += c + "";
						}
						else if(b==43)
						{
							c='F';
							card += c + "";
						}
						else if(b==44)
						{
							c='G';
							card += c + "";
						}
						else if(b==45)
						{
							c='H';
							card += c + "";
						}
						else if(b==46)
						{
							c='I';
							card += c + "";
						}
						else if(b==47)
						{
							c='J';
							card += c + "";
						}
						else if(b==48)
						{
							c='K';
							card += c + "";
						}
						else if(b==49)
						{
							c='L';
							card += c + "";
						}
						else if(b==50)
						{
							c='M';
							card += c + "";
						}
						else if(b==51)
						{
							c=' ';
							card += c + "N";
						}
						else if(b==52)
						{
							c='O';
							card += c + "";
						}
						else if(b==53)
						{
							c='P';
							card += c + "";
						}
						else if(b==54)
						{
							c='Q';
							card += c + "";
						}
						else if(b==55)
						{
							c='R';
							card += c + "";
						}
						else if(b==56)
						{
							c='S';
							card += c + "";
						}
						else if(b==57)
						{
							c='T';
							card += c + "";
						}
						else if(b==58)
						{
							c='U';
							card += c + "";
						}
						else if(b==59)
						{
							c='V';
							card += c + "";
						}
						else if(b==60)
						{
							c='W';
							card += c + "";
						}
						else if(b==61)
						{
							c='X';
							card += c + "";
						}
						else if(b==62)
						{
							c='Y';
							card += c + "";
						}
						else if(b==63)
						{
							c='Z';
							card += c + "";
						}
						else if(b==64)
						{
							c='-';
							card += c + "";
						}
						
						else
						{
							card += b + "";
						}
						
					}

					System.out.println("cardNO---" + card);
					return card;

				} else {
					return "failed";
				}
			} catch (CardException e) {
				e.printStackTrace();
			}
		} else {
			return "selection failed";
		}
		return null;
	}
	
	

	

	public byte[] convertToHexString(String number) {
		byte[] data = new byte[110];

		int dataSize = 0;
		System.out.println("Lenghth:"+number.length());
		for (int i = 0; i < number.length(); i++) {
			String ch = "" + number.charAt(i);
			System.out.println("ch---" + ch);
			if (ch.equals("0")) {
				byte num = (byte) 0x00;
				data[dataSize++] = num;
			}
			if (ch.equals("1")) {
				byte num = (byte) 0x01;
				data[dataSize++] = num;
			}
			if (ch.equals("2")) {
				byte num = (byte) 0x02;
				data[dataSize++] = num;
			}
			if (ch.equals("3")) {
				byte num = (byte) 0x03;
				data[dataSize++] = num;
			}
			if (ch.equals("4")) {
				byte num = (byte) 0x04;
				data[dataSize++] = num;
			}
			if (ch.equals("5")) {
				byte num = (byte) 0x05;
				data[dataSize++] = num;
			}
			if (ch.equals("6")) {
				byte num = (byte) 0x06;
				data[dataSize++] = num;
			}
			if (ch.equals("7")) {
				byte num = (byte) 0x07;
				data[dataSize++] = num;
			}
			if (ch.equals("8")) {
				byte num = (byte) 0x08;
				data[dataSize++] = num;
			}
			if (ch.equals("9")) {
				byte num = (byte) 0x09;
				data[dataSize++] = num;
			}
			if(ch.equals("a"))
			{
				byte num=(byte)0x0a;
				System.out.println("number for a:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("b"))
			{
				byte num=(byte)0x0b;
				System.out.println("number for b:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("c"))
			{
				byte num=0x0c;
				System.out.println("number for c:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("d"))
			{
				byte num=0x0d; 
				System.out.println("number for d:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("e"))
			{
				byte num=0x0e;
				System.out.println("number for e:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("f"))
			{
				byte num=0x0f;
				System.out.println("number for f:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("g"))
			{
				byte num=16;
				System.out.println("number for g:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("h"))
			{
				byte num=17;
				System.out.println("number for h:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("i"))
			{
				byte num=18;
				System.out.println("number for i:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("j"))
			{
				byte num=19;
				System.out.println("number for j:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("k"))
			{
				byte num=20;
				System.out.println("number for k:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("l"))
			{
				byte num=21;
				System.out.println("number for l:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("m"))
			{
				byte num=22;
				System.out.println("number for m:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("n"))
			{
				byte num=23;
				System.out.println("number for n:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("o"))
			{
				byte num=24;
				System.out.println("number for o:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("p"))
			{
				byte num=25;
				System.out.println("number for p:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("q"))
			{
				byte num=26;
				System.out.println("number for q:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("r"))
			{
				byte num=27;
				System.out.println("number for r:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("s"))
			{
				byte num=28;
				System.out.println("number for t:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("t"))
			{
				byte num=29;
				System.out.println("number for t:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("u"))
			{
				byte num=30;
				System.out.println("number for u:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("v"))
			{
				byte num=31;
				System.out.println("number for v:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("w"))
			{
				byte num=32;
				System.out.println("number for w:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("x"))
			{
				byte num=33;
				System.out.println("number for x:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("y"))
			{
				byte num=34;
				System.out.println("number for y:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("z"))
			{
				byte num=35;
				System.out.println("number for z:::"+num);
				data[dataSize++] = num;
			
			}
			if(ch.equals(","))
			{
				byte num=36;
				System.out.println("number for ,:::"+num);
				data[dataSize++] = num;
			
			}
			if(ch.equals(" "))
			{
				byte num=37;
				System.out.println("number for ,:::"+num);
				data[dataSize++] = num;
			
			}
			if(ch.equals("A"))
			{
				byte num=38;
				System.out.println("number for a:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("B"))
			{
				byte num=39;
				System.out.println("number for b:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("C"))
			{
				byte num=40;
				System.out.println("number for c:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("D"))
			{
				byte num=41; 
				System.out.println("number for d:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("E"))
			{
				byte num=42;
				System.out.println("number for e:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("F"))
			{
				byte num=43;
				System.out.println("number for f:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("G"))
			{
				byte num=44;
				System.out.println("number for g:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("H"))
			{
				byte num=45;
				System.out.println("number for h:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("I"))
			{
				byte num=46;
				System.out.println("number for i:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("J"))
			{
				byte num=47;
				System.out.println("number for j:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("K"))
			{
				byte num=48;
				System.out.println("number for k:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("L"))
			{
				byte num=49;
				System.out.println("number for l:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("M"))
			{
				byte num=50;
				System.out.println("number for m:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("N"))
			{
				byte num=51;
				System.out.println("number for n:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("O"))
			{
				byte num=52;
				System.out.println("number for o:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("P"))
			{
				byte num=53;
				System.out.println("number for p:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("Q"))
			{
				byte num=54;
				System.out.println("number for q:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("R"))
			{
				byte num=55;
				System.out.println("number for r:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("S"))
			{
				byte num=56;
				System.out.println("number for t:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("T"))
			{
				byte num=57;
				System.out.println("number for t:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("U"))
			{
				byte num=58;
				System.out.println("number for u:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("V"))
			{
				byte num=59;
				System.out.println("number for v:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("W"))
			{
				byte num=60;
				System.out.println("number for w:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("X"))
			{
				byte num=61;
				System.out.println("number for x:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("Y"))
			{
				byte num=62;
				System.out.println("number for y:::"+num);
				data[dataSize++] = num;
			}
			if(ch.equals("Z"))
			{
				byte num=63;
				System.out.println("number for z:::"+num);
				data[dataSize++] = num;
			
			}	
			if(ch.equals("-"))
			{
				byte num=64;
				System.out.println("number for -:::"+num);
				data[dataSize++] = num;
			
			}	
			
		}

		byte[] databyteArray = new byte[dataSize];
		for (int i = 0; i < dataSize; i++) {
			byte temp = data[i];
			databyteArray[i] = temp;
			System.out.println(databyteArray[i]);
		}

		return databyteArray;

	}

	
}
