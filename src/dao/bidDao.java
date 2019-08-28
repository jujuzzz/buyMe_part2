package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dbc.dbConnection;
import vo.bidVo;
import vo.createItemVo;
import vo.priceAlertVo;



public class bidDao {
	public void insertbid (bidVo bid) {
	    // 用户注册方法
	    dbConnection bidConnection = new dbConnection();
	    Connection conn = null;
	    Statement sta = null;
	    System.out.println("insertbid starts");

	    try {
	        conn = bidConnection.getConnection();
	        sta = conn.createStatement();
	        System.out.println("juju");
	        String sql = "INSERT INTO `buyMe`.`bid` (`bidPrice`, `bidTime`, `username`)  VALUES ('"	        		
	                + bid.getMoney()
	                + "','"	        		
	                + bid.getTime()
	                + "','"	        		
	                + bid.getBuid()	               
	                + "')";
	     
	        
	        System.out.println(sql);
	       

	        sta.executeUpdate(sql);


	    } catch (SQLException e) {

	        e.printStackTrace();
	    } finally {
	        // 执行完关闭数据库
	        bidConnection.closeConnection(sta, conn);
	    }
	    
	}
	    
	    	    
	    public int getmaxid () {
	    	int newid = 100;
	    	
		    // 用户注册方法
		    dbConnection bidConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("getid starts");

		    try {
		        conn = bidConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select max(bidId) from buyMe.bid";
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        newid = rs.getInt(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        bidConnection.closeConnection(sta, conn);
		    }
			return newid;
	}
	    
	    public void insertmanualbid (bidVo bid) {
		    // 用户注册方法
		    dbConnection bidConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;

		    try {
		        conn = bidConnection.getConnection();
		        sta = conn.createStatement();
		        System.out.println("juju");
		        String sql = "INSERT INTO `buyMe`.`manualBid` (`bidNo`, `bid`, `username`)  VALUES ('"
		        		+ bid.getBid()
		                + "','"	        		
		                + bid.getMoney()
		                + "','"	        		
		                + bid.getBuid()		                             
		                + "')";
		     
		        
		        System.out.println(sql);
		       

		        sta.executeUpdate(sql);


		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        bidConnection.closeConnection(sta, conn);
		    }
		    
		}
	    
	    
	    public void insertbuy (bidVo bid) {
		    // 用户注册方法
		    dbConnection bidConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("insertbuy starts");

		    try {
		        conn = bidConnection.getConnection();
		        sta = conn.createStatement();
		        System.out.println("juju");
		        String sql = "INSERT INTO `buyMe`.`buyer_bid_auction` (`username`, `bidid`, `auctionid`)  VALUES ('"
		        		+ bid.getBuid()
		                + "','"	
		                + bid.getBid()
		                + "','"	        		
		                + bid.getAid()		               
		                + "')";
		     
		        
		        System.out.println(sql);
		       

		        sta.executeUpdate(sql);


		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        bidConnection.closeConnection(sta, conn);
		    }
		    
		}
	    
	    
	    
        public List<bidVo> getbid (int bidNo) {
	    	
	    	
		    // 用户注册方法
		    dbConnection bidConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    List<bidVo> bidinfo = new ArrayList<bidVo>();
		    System.out.println("getbid starts");


		    try {
		        conn = bidConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select * from buyMe.bid where bidID="+bidNo;
		        ResultSet rs =  sta.executeQuery(sql);
		        while(rs.next()){
					bidVo bid = new bidVo();
					bid.setBuid(rs.getString("username"));
				    bid.setMoney(rs.getFloat("bidPrice"));
				    bid.setBid(rs.getInt("bidID"));
				    bid.setTime(rs.getTimestamp("bidTime"));				    
				    bidinfo.add(bid);
				    System.out.println(bid);
					
				}		        		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        bidConnection.closeConnection(sta, conn);
		    }
			return bidinfo;

			
	}
	    
	    
        public String getwinner (int aid, float maxbid) {
	    	String winnerid = null;
	    	
		    // 用户注册方法
		    dbConnection bidConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("getwinner starts");	
		    System.out.println(aid);
		    System.out.println(maxbid);		
		    

		    try {
		        conn = bidConnection.getConnection();
		        sta = conn.createStatement();
		        PreparedStatement ps = conn.prepareStatement("select bid.username from buyMe.bid, buyMe.buyer_bid_auction S where bid.bidID = S.bidid and bid.bidPrice = ? and S.auctionid=?" );		        
		        ps.setFloat(1, maxbid);
		        ps.setInt(2, aid);
		        System.out.println(ps);		
		        ResultSet rs =  ps.executeQuery();
		        rs.next();
		        System.out.print(rs);
		        winnerid = rs.getString(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        bidConnection.closeConnection(sta, conn);
		    }
			return winnerid;
	}
        
        
        
        
        public void updateprice (float price, int itemid) {
	    	
	    	
		    // 用户注册方法
		    dbConnection bidConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("updatesprice starts");
		    

		    try {
		        conn = bidConnection.getConnection();
		        sta = conn.createStatement();
		        
		        PreparedStatement ps = conn.prepareStatement("UPDATE `buyMe`.`items` SET `currentBid`=? WHERE `IID`=?") ; 
		        ps.setFloat(1, price);
		        ps.setInt(2, itemid);
		        ps.executeUpdate();
		        System.out.println(ps);
		        		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        bidConnection.closeConnection(sta, conn);
		    }
			
	}
        
        public void insertalert (priceAlertVo alert) {
    	    // 用户注册方法
    	    dbConnection bidConnection = new dbConnection();
    	    Connection conn = null;
    	    Statement sta = null;
    	    System.out.println("insertalert starts");

    	    try {
    	        conn = bidConnection.getConnection();
    	        sta = conn.createStatement();
    	        System.out.println("juju");
    	        String sql = "INSERT INTO `buyMe`.`priceAlert` (`username`,  `itemid`, `alertprice`)  VALUES ('"
    	        		+ alert.getBuyerid()
    	                + "','"	  
    	                + alert.getItemid()
    	                + "','"	        		
    	                + alert.getNewprice()    	                	               
    	                + "')";
    	     
    	        
    	        System.out.println(sql);
    	       

    	        sta.executeUpdate(sql);


    	    } catch (SQLException e) {

    	        e.printStackTrace();
    	    } finally {
    	        // 执行完关闭数据库
    	        bidConnection.closeConnection(sta, conn);
    	    }
    	    
    	}
        
        public ArrayList<String> getitembuyer (int iid) {
	    	
		    // 用户注册方法
		    dbConnection bidConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    ArrayList<String> names = new ArrayList<String>();
		    System.out.println("getbuyer starts");
		    
		    


		    try {
		        conn = bidConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select B.username from buyMe.buyer_bid_auction B, buyMe.seller_sell_items S where B.auctionid = S.auctionID and S.itemID="+iid ;
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        
			    while (rs.next()) { 
			        names.add(rs.getString(1));
			    }
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        bidConnection.closeConnection(sta, conn);
		    }
			return names;
	}
        
        
        
        public priceAlertVo getbuyerbid (String buyerid, int itemid) {
	    	
	    	
		    // 用户注册方法
		    dbConnection bidConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    priceAlertVo alert = new priceAlertVo();
		    System.out.println("getbid of buyer starts");

		    try {
		        conn = bidConnection.getConnection();
		        sta = conn.createStatement();
		        PreparedStatement ps = conn.prepareStatement("select max(bidPrice), bid.bidID from buyMe.bid, buyMe.buyer_bid_auction B, buyMe.seller_sell_items S where bid.bidID = B.bidid and B.auctionid = S.auctionID and bid. username = ? and S.itemID=?");		        
		        ps.setString(1, buyerid);
		        ps.setInt(2, itemid);
		        ResultSet rs = ps.executeQuery();
		        
		        rs.next();
		        alert.setItemid((rs.getInt(2)));
		        alert.setNewprice((rs.getFloat(1)));

		        		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        bidConnection.closeConnection(sta, conn);
		    }
			
			return alert;
	}
        
       

}
