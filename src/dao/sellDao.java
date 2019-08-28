package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import dbc.dbConnection;
import vo.sellVo;


public class sellDao {
	
	// insert into seller_sell_items tabel(table of linking auction and item)
	public void insertSelling (sellVo selling) {
	    dbConnection sellConnection = new dbConnection();
	    Connection conn = null;
	    Statement sta = null;

	    try {
	        conn = sellConnection.getConnection();
	        sta = conn.createStatement();
	        System.out.println("juju");
	        String sql = "INSERT INTO `buyMe`.`seller_sell_items` (`auctionID`, `uName`, `itemID`)  VALUES ('"
	        		+ selling.getAid()
	                + "','"
	                + selling.getSid()
	                + "','"	        		
	                + selling.getIid()	                
	                + "')";
	     
	        
	        System.out.println(sql);
	       

	        sta.executeUpdate(sql);


	    } catch (SQLException e) {

	        e.printStackTrace();
	    } finally {
	        sellConnection.closeConnection(sta, conn);
	    }
	    
	}
	    
	    
	// get auction id of an item using its itemid
	    public int getauctionid (int iid) {
	    	int aid = 100;
	    	
		    dbConnection sellConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("getauctionid starts");

		    try {
		        conn = sellConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select auctionID from buyMe.seller_sell_items where itemID="+iid;
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        aid = rs.getInt(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        sellConnection.closeConnection(sta, conn);
		    }
			return aid;
	}
	    public int getitemid (int aid) {
	    	int iid = 100;
	    	
		    dbConnection sellConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("getauctionid starts");

		    try {
		        conn = sellConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select itemID from buyMe.seller_sell_items where auctionID="+aid;
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        aid = rs.getInt(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        sellConnection.closeConnection(sta, conn);
		    }
			return iid;
	}

	    
	    // get the latest item id
	    public int getmaxid () {
	    	int newid = 100;
		    dbConnection sellConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;

		    try {
		        conn = sellConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select max(itemID) from buyMe.seller_sell_items";
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        newid = rs.getInt(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        sellConnection.closeConnection(sta, conn);
		    }
			return newid;
	}

	    
	  
}



