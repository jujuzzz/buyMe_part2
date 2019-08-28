package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.auctionDao;
import dao.itemDao;
import dao.sellDao;
import vo.auctionVo;
import vo.createItemVo;




 
/**
 * Servlet implementation class PostBar
 */
@WebServlet("/item4buyServlet")
public class item4buyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public item4buyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	  // TODO Auto-generated method stub
    	  System.out.println("doGet in item");

    	  // TODO Auto-generated method stub
    	  itemDao itemdao=new itemDao();
    	  auctionDao auctiondao = new auctionDao();
    	  sellDao selldao = new sellDao();
    	  
    	  //int itemid = Integer.parseInt(request.getParameter("itemid"));
    	  //fail to connect with searching seesion, set a default itemid
    	  int itemid = 252;
    	  
    	  // get the auctionid of this item so that I can select acution information from auction table
    	  int auctionid = selldao.getauctionid(itemid);
    	  String itemname = itemdao.getitemname(itemid);
    	  
    	  // select all information of a new item from items table, output the result  
    	  //select all information except reverse price of a new auction from auction table, output the result 
    	  // no need to use arraylist, but I forget to update the function                    	          
    	  List newitems = itemdao.getitem(itemid);
    	  List newauction = auctiondao.getauctionforsell(auctionid);
    	  resp.setContentType("text/html");
    	  PrintWriter out = resp.getWriter();
    	  out.println("<html>");
    	  out.println("<head>");
    	  out.println("<title>Auction Confirm</title>");
    	  out.println("</head>");
    	  out.println("<body>");
    	  out.println("<h1>" + itemname + "</h1>");
    	  for (int j = 0; j < newitems.size(); j++) {
    		  out.println("<p>" + newitems.get(j) +"<br>" +"<p>");    		      	  	  	
    	  }
    	  
    	  
    	  
    	  for (int j = 0; j < newauction.size(); j++) {
    		  out.println("<p>" + newauction.get(j) + "<br>"+"<p>");   		    	  	  	
    	  } 
    	  
    	  //Try to send itemID as parameter in URL of bid.jsp, but fail
    	  //out.println("<a href= " + "\"http://localhost:8080/finalProjectjuju/bid.jsp itemid\" " + itemid + ">Bid</a>"); 
    	  out.println("<p>This reverse price is just a system default value for every auction. You guess!</p>");

    	  out.println("</body>");
    	  out.println("</html>");
		
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("juju");
		// TODO Auto-generated method stub
	}
 
}

