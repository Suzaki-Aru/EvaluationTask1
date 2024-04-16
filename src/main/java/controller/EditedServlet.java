package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/EditedServlet")
public class EditedServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException,
		    IOException{
		        request.setCharacterEncoding("UTF-8");
		        
		        String janCode = request.getParameter("janCode");
//		        String isbnCode = request.getParameter("isbnCode");
		        String bookName = request.getParameter("bookName");
		        String bookKana = request.getParameter("bookKana");
		        String price = request.getParameter("price");
//		        String issueDate = request.getParameter("issueDate");
//		        String createDate = request.getParameter("createDate");
		        String updateDate = request.getParameter("updateDate");
		        
		        String url = "jdbc:mysql://localhost:3306/evaluation";
		        String user = "root";
		        String password ="root";
		        try{
		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch(Exception e){
		            e.printStackTrace();
		        }
		        String sql ="UPDATE book SET BOOK_NM = ?, BOOK_KANA = ?, PRICE = ?, UPDATE_DATETIME = CURRENT_TIMESTAMP WHERE JAN_CD = ?";
		        try (Connection connection = DriverManager.getConnection
		        (url, user, password);
		        PreparedStatement statement = connection.prepareStatement
		        (sql)){
		        	    statement.setString(1, bookName);
		        	    statement.setString(2, bookKana);
		        	    statement.setString(3, price);
		        	    statement.setString(4, janCode);
		                statement.executeUpdate();
                        
		            response.sendRedirect("ListedServlet");
		                
		            } catch (SQLException e) {
		                e.printStackTrace();
		            } catch (Exception e) {
		                request.setAttribute("message", "Exception" + e.getMessage());
		            }
	}
}