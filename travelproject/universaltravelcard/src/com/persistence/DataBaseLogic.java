package com.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;

public class DataBaseLogic {
	Connection connection=null;

	public ArrayList<String> getCountries() {
		// TODO Auto-generated method stub
		ArrayList<String> countryList=new ArrayList<String>();
		try
		{
		connection=ConnectionFactory.getConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select country_name from country");
		while (resultSet.next()) {
			countryList.add(resultSet.getString(1));
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return countryList;
	}

	public ArrayList<String> getStates(int countryId) {
		// TODO Auto-generated method stub
		ArrayList<String> stateList=new ArrayList<String>();
		try
		{
		connection=ConnectionFactory.getConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select state_name from state where COUNTRY_ID='"+countryId+"'");
		while (resultSet.next()) {
			stateList.add(resultSet.getString(1));
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}                                                            
		return stateList;
		

}

	public ArrayList<String> getCities(int stateId) {
		// TODO Auto-generated method stub
		
		ArrayList<String> cityList=new ArrayList<String>();
		try
		{
		connection=ConnectionFactory.getConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select city_name from city where STATE_ID='"+stateId+"'");
		while (resultSet.next()) {
			cityList.add(resultSet.getString(1));
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cityList;
		
	}

	public int insertDetails(String custMailId, String path,
			String custFirstName, String custLastName, String custMobile,
			String custPanId, String custAdharId, String custGender,
			String custStreet, String custCity) {
		// TODO Auto-generated method stub
		int i=0;
		String sql="insert into USERDETAILS(CUST_EMAILID,CUST_IMG,CUST_FIRSTNAME,CUST_LASTNAME,CUST_MOBILE,CUST_PANID,CUST_ADHARID,CUST_GENDER,CUST_STREET,CITY_ID) values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			connection=ConnectionFactory.getConnection();
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1,custMailId);
			
			
			File f=new File(path);
			
			FileInputStream fileInputStream=new FileInputStream(f);
			statement.setBinaryStream(2,fileInputStream,(int)f.length());
			
			statement.setString(3,custFirstName);
			statement.setString(4,custLastName);
			statement.setString(5,custMobile);
			statement.setString(6,custPanId);
			statement.setString(7,custAdharId);
			statement.setString(8,custGender);
			statement.setString(10,custCity);
			statement.setString(9,custStreet);
			i=statement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		return i;
	}

	public int insertsmartCardDetails(String smartCardId,
			String smartCardBalance, String smartCardPin, String customerEmailId) {
		// TODO Auto-generated method stub
		int j=0;
		String sql="insert into SMARTCARD(SCARD_ID,SCARD_BALANCE,SCARD_PINNUM,CUST_EMAILID) values(?,?,?,?)";
try {
			
			connection=ConnectionFactory.getConnection();
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1,smartCardId);
			statement.setString(2,smartCardBalance);
			statement.setString(3,smartCardPin);
			statement.setString(4,customerEmailId);
			j=statement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return j;
	}

	public ArrayList<String> getSource() {
		// TODO Auto-generated method stub
		
		String sql="select STATIONAME from STATION order by stationid";
		ArrayList<String> source=new ArrayList<String>();
		try {
			connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
			source.add(resultSet.getString(1));	
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		return source;
	}

	public ArrayList<String> getDestination(int selectedSource) {
		// TODO Auto-generated method stub
		String sql="select STATIONAME from STATION where STATIONID>'"+selectedSource+"' order by stationid";
		System.out.println(sql);
		ArrayList<String> source=new ArrayList<String>();
		try {
			connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			while (resultSet.next()) {
			source.add(resultSet.getString(1));	
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return source;
	}

	public int getFair(int source, int destinationId) {
		// TODO Auto-generated method stub
		String sql="select FAIR from STATION_STATION1 where STATIONID='"+source+"' and STATIONID1='"+destinationId+"'";
		System.out.println(sql);
		int fair=0;
		try {
			connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			if(resultSet.next())
			{
			fair=resultSet.getInt(1);	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fair;
	}

	public int getDestinationId(String selectedDest) {
		// TODO Auto-generated method stub
		int destinationId=0;
		String sql="select STATIONID from STATION where STATIONAME='"+selectedDest+"'";
		System.out.println(sql);
		try {
			connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			if(resultSet.next())
			{
				destinationId=resultSet.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return destinationId;
	}
	
	public int getPrimaryKey(String columnName,String tableName)
	{
		int pk=0;
		try {
			Connection connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select count("+columnName+")+1 from "+tableName+"");
		    if(resultSet.next())
		    {
		    	pk=resultSet.getInt(1);
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pk;
	}

	public int updateBalance(int fare, String cardinfo) {
		// TODO Auto-generated method stub
		String sql="update SMARTCARD set SCARD_BALANCE=SCARD_BALANCE-"+fare+" where SCARD_ID='"+cardinfo+"'";
		System.out.println(sql);
		int updationResult=0;
		try {
			Connection connection=ConnectionFactory.getConnection();
			Statement statement=connection.createStatement();
			updationResult=statement.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return updationResult;
	}

	public int insertJourneyDetails(int selectedIndex, String string,
			String string2) {
		// TODO Auto-generated method stub
		int pk=getPrimaryKey("JOURNEYID","journey");
		String sql="insert into journey values('"+pk+"','"+string+"','"+string2+"',sysdate)";
		int insertionResult=0;  
		try {
			   Connection connection=ConnectionFactory.getConnection();
				Statement statement=connection.createStatement();
				insertionResult=statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
				
		return insertionResult;
	}

	public ArrayList<String> getCards(String text, String selectedDate) {
		// TODO Auto-generated method stub
		String sql="select SCARD_ID from journey where BUSID='"+text+"' and JDATE like '"+selectedDate+"'";
		System.out.println(sql);
		ArrayList<String> al=new ArrayList<String>();
		try
		{
			
			connection=ConnectionFactory.getConnection();
		
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(sql);
		while (resultSet.next()) {
			al.add(resultSet.getString(1));
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();	
		}
		
		
		return al;
	}

	public int getBalnce(String string) {
		// TODO Auto-generated method stub
        int balcacne=0;
		String sql="select SCARD_BALANCE from SMARTCARD where SCARD_ID='"+string+"'";
		
			try
			{
				
				connection=ConnectionFactory.getConnection();
			
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);
			if(resultSet.next())
			{
			balcacne=resultSet.getInt(1);	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return balcacne;
	
		}
	
	}

