package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.auctionDao;
import dao.bidDao;
import dao.itemDao;
import dao.sellDao;
import vo.auctionVo;
import vo.bidVo;
import vo.createItemVo;
import vo.priceAlertVo;
import vo.sellVo;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/bidServlet")
public class bidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    
    
   
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	    	
    	// assume that previous item4buy.jsp successfully send itemid to this page, test the code using default value 
        //int itemid = Integer.parseInt(request.getParameter("itemid"));               
    	int itemid = 252;
    	
    	sellDao sellingdao = new sellDao();
    	auctionDao auctiondao = new auctionDao();        
    	
    	// make sure that web input send to database only when the current time is between auction's startTime and endTime   	
    	
    	//get auctionid from seller_sell_items table
    	//use the auctionid to get auction's startTime and endTime in auction table
    	int auctionid = sellingdao.getauctionid(itemid); 
    	System.out.print(auctionid);
        Timestamp start = auctiondao.getstart(auctionid);
        Timestamp end = auctiondao.getend(auctionid);    
        Timestamp currenttime = Timestamp.valueOf(LocalDateTime.now());
                
        
    	if (currenttime.before (end) && currenttime.after(start)) {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
                   
        // assume that I have got username as prameter after login, use default value in test
        //Object uid = session.getAttribute("userid");
        //String username = uid.toString();        
        String username = "juju";
        
        //save bid information to bid instance
        Float money = Float.parseFloat(request.getParameter("money"));        
        Timestamp time = Timestamp.valueOf(LocalDateTime.now());                    
        bidVo bid = new bidVo();        
        bid.setMoney(money);
        bid.setTime(time);
        bid.setBuid(username);
        bid.setAid(auctionid);

        
        bidDao biddao = new bidDao();
        
        
        //insert into bid table
        biddao.insertbid(bid);
        //get latest bidID for the purpose of inserting foreign key into buyer_bid_auction table
        bid.setBid(biddao.getmaxid());       
        
                
        //insert into buye_bid_auction table
        biddao.insertbuy(bid);
        
        
        //update item's current price
        biddao.updateprice(bid.getMoney(), itemid);
        
        
        //try of implement of setting high price alert, but have not finished yer 
        //check which buyer's latest bid is smaller than the updated item price, and insert username, higher bid and itemid into alert table
        ArrayList<String> userid = new ArrayList<String>();
        userid = biddao.getitembuyer (itemid);
        System.out.println(userid);
        for (int j = 0; j < userid.size(); j++) {
        	priceAlertVo alert = new priceAlertVo();
        	alert = biddao.getbuyerbid(username, itemid);       
        	Float userbid = alert.getNewprice();
        	if (userbid < money){
        		alert.setBuyerid(username);
        		alert.setItemid(itemid);
        		alert.setNewprice(money);
        		biddao.insertalert(alert);
        	}
        	
        }
        

        
               
        request.getRequestDispatcher("/bidConfirm.jsp").forward(request,
                response);
        // forward to bidConfirm page
    }else {

	  response.setContentType("text/html");
  	  PrintWriter out = response.getWriter();
  	  out.println("<html>");
  	  out.println("<head>");
  	  out.println("<title>Illegal bid tiem</title>");
  	  out.println("</head>");
  	  out.println("<body>");
  	  out.println("<h1>Auction has not ended yet, pelse bid later!</h1>"); 	    	 
	  out.println("</body>");
  	  out.println("</html>");
		
		
	
    }
    	
    	    	
    	
    }
   	 
}
