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

import dao.bidDao;


/**
 * Servlet implementation class PostBar
 */
@WebServlet("/bidConfirmServlet")
public class bidConfirmServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 /**
  * @see HttpServlet#HttpServlet()
  */
 public bidConfirmServlet() {
  super();
  // TODO Auto-generated constructor stub
  System.out.println("new itemconfirm servlet");
 }

 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  // TODO Auto-generated method stub
  System.out.println("doGet in itemconfirm");

  // TODO Auto-generated method stub
  bidDao bidconfirm=new bidDao();
                    
          
  List newbid = bidconfirm.getbid(bidconfirm.getmaxid());
  resp.setContentType("text/html");
  PrintWriter out = resp.getWriter();
  out.println("<html>");
  out.println("<head>");
  out.println("<title>Auction Confirm</title>");
  out.println("</head>");
  out.println("<body>");
  out.println("<h1>You just created a new aunction!</h1>");
  for (int j = 0; j < newbid.size(); j++) {
	  out.println("<p>" + newbid.get(j) +"<br>" +"<p>");
	    	  	
  }
  

  out.println("</body>");
  out.println("</html>");

//  req.setAttribute("item", item);
//  req.setAttribute("auction", auction);
//  req.getRequestDispatcher("/itemConfirm.jsp").forward(req, resp);
 }

}
