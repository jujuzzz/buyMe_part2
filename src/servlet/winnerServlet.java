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
import vo.sellVo;





 
/**
 * Servlet implementation class PostBar
 */
@WebServlet("/winnerServlet")
public class winnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public winnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	auctionDao auctiondao = new auctionDao();
    	Timestamp end = auctiondao.getend(155);    
    	Timestamp currenttime = Timestamp.valueOf(LocalDateTime.now());
    	  // before define winner, check if the auction is ended
    	  if (currenttime.after(end) ) {
    	  // TODO Auto-generated method stub
    	  System.out.println("doGet in item");

    	   // assume that auctionID and username are passed to winner.jsp as parameter from previous page, use default value in test
    	    int auctionid = 151;
    	    String username = "juju";
    	 
    	    
    	    //get itemid of the item the buyer is bidding     
    	    sellDao sellingdao = new sellDao();
    	    int itemid = sellingdao.getitemid(auctionid);
    	    
    	    //get reverse price
    	    auctionDao audao = new auctionDao();
    	    float reverse = audao.getreverse(auctionid);
    	    
    	    
    	    //get the max current bid
    	    itemDao itemdao = new itemDao();
    	    float maxbid = itemdao.getprice(itemid);
    	    System.out.print(reverse);
    	    System.out.print(maxbid);

    	    
    	    
    	    //define winner
    	    if (reverse < maxbid) {
    	    	bidDao biddao = new bidDao();
    	        String winnerid = biddao.getwinner(auctionid, maxbid);
    	        // I should use the getwinner() to update the winner value in items table, but I have not started to work on it
    	        if (username.equals(winnerid)){
    	          resp.setContentType("text/html");
    	    	  PrintWriter out = resp.getWriter();
    	    	  out.println("<html>");
    	    	  out.println("<head>");
    	    	  out.println("<title>Auction Confirm</title>");
    	    	  out.println("</head>");
    	    	  out.println("<body>");
    	    	  out.println("<h1>You win this bid!</h1>");   	    	  
  	    	      out.println("</body>");
    	    	  out.println("</html>");
    	     }else {
    	    	 // if the user is not the winner, output different webpage content
    	     resp.setContentType("text/html");
   	    	  PrintWriter out = resp.getWriter();
   	    	  out.println("<html>");
   	    	  out.println("<head>");
   	    	  out.println("<title>Auction Confirm</title>");
   	    	  out.println("</head>");
   	    	  out.println("<body>");
   	    	  out.println("<h1>You are not the winner!</h1>");
   	    	  out.println("</body>");
   	    	  out.println("</html>");

    	     }
    	    } else {
    	    	//if max bid is less than reserve price, output different webpage content
    	      resp.setContentType("text/html");
  	    	  PrintWriter out = resp.getWriter();
  	    	  out.println("<html>");
  	    	  out.println("<head>");
  	    	  out.println("<title>Auction Confirm</title>");
  	    	  out.println("</head>");
  	    	  out.println("<body>");
  	    	  out.println("<h1>The Maximum Price is lesser than reverse price, no winner!</h1>"); 	    	 
	    	  out.println("</body>");
  	    	  out.println("</html>");

    	    	
    	    }
    	    
 	
	}else{
		//if auction has not ended yet, directly output different webpage content
		  resp.setContentType("text/html");
    	  PrintWriter out = resp.getWriter();
    	  out.println("<html>");
    	  out.println("<head>");
    	  out.println("<title>Winner not defined</title>");
    	  out.println("</head>");
    	  out.println("<body>");
    	  out.println("<h1>Auction has not ended yet, winner cannot be defined!</h1>"); 	    	 
  	      out.println("</body>");
    	  out.println("</html>");
		
		
	}
    }
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("juju");
		// TODO Auto-generated method stub
	}
 
}

