package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import dbc.dbConnection;
import vo.createItemVo;

public class itemDao {
	
	//insert new item
	public void insertItem (createItemVo item) {
	    
	    dbConnection itemConnection = new dbConnection();
	    Connection conn = null;
	    Statement sta = null;

	    try {
	        conn = itemConnection.getConnection();
	        sta = conn.createStatement();
	        System.out.println("juju");
	        String sql = "INSERT INTO `buyMe`.`items` (`material`, `color`, `condition`, `description`, `iName`,  `currentBid`)  VALUES ('"
	        		+ item.getMaterial()
	                + "','"
	                + item.getColor()
	                + "','"	        		
	                + item.getCondition()
	                + "','"	                
	                + item.getDescription()
	                + "','"	        		
	                + item.getName()
	                + "','"	        		
	                + item.getPrice()
	                + "')";
	     
	        
	        System.out.println(sql);
	       

	        sta.executeUpdate(sql);


	    } catch (SQLException e) {

	        e.printStackTrace();
	    } finally {
	        itemConnection.closeConnection(sta, conn);
	    }
	    
	}
	    
	    //get the latest item id 	    
	    public int getmaxid () {
	    	int newid = 100;
		    dbConnection itemConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("maxid starts");

		    try {
		        conn = itemConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select max(IID) from buyMe.items";
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        newid = rs.getInt(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        itemConnection.closeConnection(sta, conn);
		    }
			return newid;
	}
	    
	    
	    // get item's current price
	    public float getprice (int iid) {
	    	float price = 0;
	    	
		    dbConnection itemConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.print(iid);
		    System.out.println("getprice starts");


		    try {
		        conn = itemConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select currentBid from buyMe.items where IID="+iid;
		        System.out.print(sql);
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        price = rs.getFloat(1);
		        System.out.print(price);

		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        itemConnection.closeConnection(sta, conn);
		    }
			return price;
	}
	    
	    // get item's name using item id
	    public String getitemname (int iid) {
	    	String name = null;
	    	
		    dbConnection itemConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    System.out.println("getname starts");


		    try {
		        conn = itemConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select iName from buyMe.items where IID="+iid;
		        ResultSet rs =  sta.executeQuery(sql);
		        rs.next();
		        name = rs.getString(1);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        itemConnection.closeConnection(sta, conn);
		    }
			return name ;
	}

	    
	    
	    // insert item type (item's weak entity set)
	    public void insertItemType (createItemVo item) {
		    dbConnection itemConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    

		    try {
		        conn = itemConnection.getConnection();
		        sta = conn.createStatement();		 
		        
		       		        		     
		        String sql = "INSERT INTO `buyMe`.`itemType` (`type`, `subType`, `iID`) VALUES ('"
		        	    + item.getType()
		                + "','"
		                + item.getSubType()
		                + "','"	        		
		                + item.getiid()
		                + "')";


		        System.out.println(sql);
		        

		        sta.executeUpdate(sql);
		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        // 执行完关闭数据库
		        itemConnection.closeConnection(sta, conn);
		    }
	}
	    
	    
	  //   get all information using item id (no need to use arraylist indeed, forget to change it)
      public List<createItemVo> getitem (int iid) {
		    dbConnection itemConnection = new dbConnection();
		    Connection conn = null;
		    Statement sta = null;
		    List<createItemVo> iteminfo = new ArrayList<createItemVo>();
		    System.out.println("juju");
		    System.out.println("getitem starts");


		    try {
		        conn = itemConnection.getConnection();
		        sta = conn.createStatement();
		        String sql = "select * from buyMe.items, buyMe.itemType where items.IID = itemType.iID and items.IID="+iid;
		        ResultSet rs =  sta.executeQuery(sql);
		        while(rs.next()){
					createItemVo item = new createItemVo();
					item.setName(rs.getString(6));
				    item.setMaterial(rs.getString(1));
				    item.setCondition(rs.getString(4));
				    item.setColor(rs.getString(3));
				    item.setPrice(rs.getFloat(7));        
				    item.setDescription(rs.getString(5));
				    item.setiid(rs.getInt(2));
				    item.setType(rs.getString(10));
				    item.setSubType(rs.getString(11));
				    iteminfo.add(item);
				    					
				}		        		     

		    } catch (SQLException e) {

		        e.printStackTrace();
		    } finally {
		        itemConnection.closeConnection(sta, conn);
		    }
			return iteminfo;

			
	}
	    
	    
	    	    
	  
	  
}



