package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ListedServlet")
public class ListedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListedServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String url = "jdbc:mysql://localhost:3306/evaluation";
      String user = "root";
      String password ="root";
      try{
          Class.forName("com.mysql.cj.jdbc.Driver");
      } catch(Exception e){
          e.printStackTrace();
      }
      
      String sql = "SELECT * FROM book";
      try (Connection connection = DriverManager.getConnection(url, user, password);
      		PreparedStatement statement = connection.prepareStatement(sql)){
      		
      		ResultSet results = statement.executeQuery();
		                ArrayList<HashMap<String,String>> rows =new
		                ArrayList<HashMap<String,String>>();
		                while(results.next()){
		                    HashMap<String,String> columns = new
		                    HashMap<String,String>();
		                    String janCode = results.getString("JAN_CD");
		                    columns.put("janCode", janCode);
		                    String isbnCode = results.getString("ISBN_CD");
		                    columns.put("isbnCode", isbnCode);
		                    String bookName = results.getString("BOOK_NM");
		                    columns.put("bookName", bookName);
		                    String bookKana = results.getString("BOOK_KANA");
		                    columns.put("bookKana", bookKana);
		                    String price = results.getString("PRICE");
		                    columns.put("price", price);
		                    String issueDate = results.getString("ISSUE_DATE");
		                    columns.put("issueDate", issueDate);
		                    String createDate = results.getString("CREATE_DATETIME");
		                    columns.put("createDate", createDate);
		                    String updateDate = results.getString("UPDATE_DATETIME");
		                    if (updateDate == null) {
		                        updateDate = ""; 
		                    }
		                    columns.put("updateDate", updateDate);
		                   
		                    rows.add(columns);
		                }
		                request.setAttribute("rows",rows);
		                
      }   catch(SQLException e){
          e.printStackTrace();
      }
          catch (Exception e){
          request.setAttribute("message", "Exception" + e.getMessage());
      }
        String view = "WEB-INF/view/listed.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
