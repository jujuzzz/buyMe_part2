package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import dbc.dbConnection;
import vo.auctionVo;
import vo.createItemVo;

public class auctionDao {
	
	// insert new auction
	public void insertauction (auctionVo auction) {
		dbConnection auctionConnection = new dbConnection();
	    Connection conn = null;
	    Statement sta = null;
	    

	    try {
	        conn = auctionConnection.getConnection();
	        sta = conn.createStatement();
	        System.out.println("juju");
	        String sql = "INSERT INTO `buyMe`.`auction` (`userName`, `startTime`, `endTime`, `createTime`, `reservePrice`)  VALUES ('"
	        		+ auction.getSid()
	                + "','"
	        		+ auction.getStart()
	                + "','"
	                + auction.getEnd()
	                + "','"	        		
	                + auction.getTime()
	                + "','"	                
	                + auction.getReverse()                
	                + "')";
	     
	        
	        System.out.println(sql);
	       

	        sta.executeUpdate(sql);


	    } catch (SQLException e) {

	        e.printStackTrace();
	    } finally {
	        auctionConnection.closeConnection(sta, conn);
	    }
	    
	}
	    
	    
	// get latest auction id
	    public int getmaxid () {
	    	int newid = 100;
		    dbConnection auctionConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("maixid starts");

		    try {
		        conn = auctionConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select max(auctionNo) from buyMe.auction";
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        newid = rs.getInt(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        auctionConnection.closeConnection(sta, conn);
		    }
			return newid;
	}
	    
	    
	   
	    // get reverse price of a certain auction
	    public float getreverse (int auctionid) {
	    	float reverse = 0;
	        dbConnection auctionConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("getreserve starts");


		    try {
		        conn = auctionConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select reservePrice from buyMe.auction where auctionNo="+auctionid;
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        reverse = rs.getFloat(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        auctionConnection.closeConnection(sta, conn);
		    }
			return reverse;
	}

	    
	    // get start time of a certain auction
	    public Timestamp getstart (int aid) {
	    	Timestamp start = null;
		    dbConnection auctionConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("getstart starts");


		    try {
		        conn = auctionConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select startTime from buyMe.auction where auctionNo="+aid;
		        System.out.print(sql);
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        start = rs.getTimestamp(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        		        auctionConnection.closeConnection(sta, conn);
		    }
			return start;
	}
	    
	    //// get end time of a certain auction
	    public Timestamp getend (int aid) {
	    	Timestamp end = null;
	    	
		    // 用户注册方法
		    dbConnection auctionConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("getend starts");


		    try {
		        conn = auctionConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select endTime from buyMe.auction where auctionNo="+aid;
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        end = rs.getTimestamp(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        auctionConnection.closeConnection(sta, conn);
		    }
			return end;
	}
	    
	    
	    	
		    
	    
	    // get auction id of a certain item using its item id
	    public int getaid (int iid) {
	    	int aid = 100;
	    	dbConnection auctionConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("getauctionid starts");


		    try {
		        conn = auctionConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select auctionId from buyMe.seller_sell_items where itemID="+iid;
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        aid = rs.getInt(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        auctionConnection.closeConnection(sta, conn);
		    }
			return aid;
	} 
	    
	    // get all information about an auction using its auction id
        public List<auctionVo> getauction (int aid) {
	    	dbConnection auctionConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    List<auctionVo> auctioninfo = new ArrayList<auctionVo>();
		    System.out.println("juju");
		    System.out.println("getauction starts");


		    try {
		        conn = auctionConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select * from buyMe.auction where auctionNo="+aid;
		        ResultSet rs =  sta.executeQuery(sql);		        
		        while(rs.next()){
					auctionVo auction = new auctionVo();
					auction.setAid(rs.getInt(1));
					auction.setStart(rs.getTimestamp(2));
					auction.setEnd(rs.getTimestamp(3));
					auction.setReverse(rs.getInt(4));
					auction.setTime(rs.getTimestamp(6));
				   auctioninfo.add(auction);
				    System.out.println(auctioninfo);
					
				}		        		     
		        
				   					
		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        auctionConnection.closeConnection(sta, conn);
		    }
			return auctioninfo;

			
	}	
        
       
        
        // get all information about an auction using its auction id, set the reverse price as zero
        public List<auctionVo> getauctionforsell (int aid) {
	    	dbConnection auctionConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    List<auctionVo> auctioninfo = new ArrayList<auctionVo>();
		    System.out.println("juju");
		    System.out.println("getauction starts");


		    try {
		        conn = auctionConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select * from buyMe.auction where auctionNo="+aid;		        
		        ResultSet rs =  sta.executeQuery(sql);		        
		        while(rs.next()){
					auctionVo auction = new auctionVo();
					auction.setAid(rs.getInt(1));
					auction.setStart(rs.getTimestamp(2));
					auction.setEnd(rs.getTimestamp(3));
					auction.setReverse(0);
				   auctioninfo.add(auction);
				    System.out.println(auctioninfo);
					
				}		        		     
		        
				   					
		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        auctionConnection.closeConnection(sta, conn);
		    }
			return auctioninfo;

			
	}	
        

        
	    

	  

	    
	    
		    	    
	    
	    
	    
	    

	    
	    
	

}
