package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.auctionDao;
import dao.itemDao;
import vo.auctionVo;
import vo.createItemVo;

/**
 * Servlet implementation class PostBar
 */
@WebServlet("/itemConfirmServlet")
public class itemConfirmServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public itemConfirmServlet() {
  super();
  // TODO Auto-generated constructor stub
  System.out.println("new itemconfirm servlet");
 }

 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  // TODO Auto-generated method stub
  System.out.println("doGet in itemconfirm");

  // TODO Auto-generated method stub
  itemDao itemconfirm=new itemDao();
  auctionDao auctionconfirm = new auctionDao();
                  
  // select all information of a new item from items table, output the result  
  //select all information of a new auction from auction table, output the result 
  // no need to use arraylist, but I forget to update the function
  List newitems = itemconfirm.getitem(itemconfirm.getmaxid());
  List newauction = auctionconfirm.getauction(auctionconfirm.getmaxid());
  resp.setContentType("text/html");
  PrintWriter out = resp.getWriter();
  out.println("<html>");
  out.println("<head>");
  out.println("<title>Auction Confirm</title>");
  out.println("</head>");
  out.println("<body>");
  out.println("<h1>You just created a new aunction!</h1>");
  for (int j = 0; j < newitems.size(); j++) {
	  out.println("<p>" + newitems.get(j)  + "<p>");
	    	  	
  }
  for (int j = 0; j < newauction.size(); j++) {
	  out.println("<p>" + newauction.get(j) + "<p>");
	  
  	  	
  }
  out.println("<a href=\"http://localhost:8080/finalProjectjuju/item4buyServlet?\">Go to item page</a>");
  

  out.println("</body>");
  out.println("</html>");

//  req.setAttribute("item", item);
//  req.setAttribute("auction", auction);
//  req.getRequestDispatcher("/itemConfirm.jsp").forward(req, resp);
 }

}