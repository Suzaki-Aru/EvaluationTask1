package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/ShowedServlet")
public class ShowedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowedServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String janCode = request.getParameter("janCode");
        String isbnCode = request.getParameter("isbnCode");
        String bookName = request.getParameter("bookName");
        String bookKana = request.getParameter("bookKana");
        String price = request.getParameter("price");
        String issueDate = request.getParameter("issueDate");
        String createDate = request.getParameter("createDate");
        String updateDate = request.getParameter("updateDate");
        
        request.setAttribute("janCode", janCode);
		request.setAttribute("isbnCode", isbnCode);
	    request.setAttribute("bookName", bookName);
		request.setAttribute("bookKana", bookKana);	
		request.setAttribute("price", price);	
		request.setAttribute("issueDate", issueDate);	
		request.setAttribute("createDate", createDate);	
		request.setAttribute("updateDate", updateDate);	
	    
	    String view="WEB-INF/view/edited.jsp";
    	RequestDispatcher dispatcher= request .getRequestDispatcher(view);
    	dispatcher.forward(request, response);
		         
	}

}
