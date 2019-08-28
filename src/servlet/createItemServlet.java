package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
import vo.sellVo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/createItemServlet")
public class createItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
       
               
        // passing web page input to variable        
        String itemname = request.getParameter("itemname");
        String type = request.getParameter("type");
        String subType = request.getParameter("subType");
        String material = request.getParameter("material");
        String condition = request.getParameter("condition");
        String color = request.getParameter("color");
        Float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
                        
        Float reverse = Float.parseFloat(request.getParameter("reversePrice"));
        String dt = request.getParameter("startTime");
        System.out.println(request.getParameter("startTime"));
        System.out.println(dt);
        Timestamp start = Timestamp.valueOf(dt);
        String tm = request.getParameter("endTime");
        Timestamp end = Timestamp.valueOf(tm);
        Timestamp time = Timestamp.valueOf(LocalDateTime.now());
        
        //Object uid = session.getAttribute("userid");
        //String username = uid.toString();
        // fail to connect to login part, set a default username
        String username = "juju";

        
                
     
        
        // web page input are saved to instances of item, auction, selling 
        createItemVo item = new createItemVo();
        item.setName(itemname);
        item.setMaterial(material);
        item.setCondition(condition);
        item.setColor(color);
        item.setPrice(price);        
        item.setDescription(description);
        item.setType(type);
        item.setSubType(subType);
                      
        auctionVo auction = new auctionVo();
        auction.setReverse(reverse);
        auction.setStart(start);
        auction.setEnd(end);
        auction.setTime(time);
        auction.setSid(username);

                
        sellVo selling = new sellVo();
        
        selling.setSid(123);              
                
        // insert into items table
        itemDao itemdao = new itemDao();              
        itemdao.insertItem(item);
        
        
        // get the latest itemid, saved into instances of item, selling
        // item id in seller_sell_items table, itemtype table references to items table
        int iid= itemdao.getmaxid();        
        item.setiid(iid);
        selling.setIid(iid);
       
        // insert into itemType table 
         itemdao.insertItemType(item);
        
        //insert into auction table        
        auctionDao auctiondao = new auctionDao();         
        auctiondao.insertauction(auction); 
        
        
        //get the latest auctionid, saved into selling instance 
        //auction id in seller_sell_item talbe references to auction table
        selling.setAid(auctiondao.getmaxid());
        
        //insert into seller_sell_items table
        sellDao selldao = new sellDao();       
        selldao.insertSelling(selling);

        
        request.getRequestDispatcher("/itemConfirm.jsp").forward(request, response);
    }
 
	 
}
