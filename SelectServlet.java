package jskusch;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class SelectServlet extends HttpServlet
{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {
          Statement stmt=null;
          ResultSet rs=null;
          Connection conn= null;
          String SQLUrl = "jdbc:mysql://localhost:3306/Restaurant";
		  String SQLUser = "student";
		  String SQLPass = "student";
     
          // Set response content type
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          String title = "Database Result";
          String docType =
          "<!doctype html" +
          "transitional//en\">\n";
          out.println(docType +
          "<html>\n" +
          "<head><title>" + title + "</title></head>\n" +
          "<body>");
          try
          {

               // Open a connection
               conn = DriverManager.getConnection(SQLUrl, SQLUser, SQLPass);

               // Execute SQL query
               stmt = conn.createStatement();
               String sql;
               sql = "SELECT * FROM Groery";
               rs = stmt.executeQuery(sql);
               out.println("<table border=1 >");
               out.println("<caption><h2>Employee Record</h2></caption>");

               out.println("<tr style='background-color:#ffffb3; color:red'>");
               out.println("<th>Fruit Stock</th>");
               out.println("<th>Vegetable Stock</th>");
               out.println("<th>Meat Stock)</th>");
               out.println("<th>Dairy Stock</th>");
               out.println("<th>Budget</th>");
               out.println("<th>Income</th>");
               out.println("</tr>");
               // Extract data from result set
               while(rs.next())
               {
                    //Retrieve by column name
                    int fruits  = rs.getInt("fruit_stock");
                    int veggies  = rs.getInt("veg_stock");
                    int meat  = rs.getInt("meat_stock");
                    int dairy  = rs.getInt("dairy_stock");
                    double budget = rs.getDouble("budget");
                    double income = rs.getDouble("income");

                    //Display values
                    out.println("<tr style='background-color:#b3ffd9;'>");
                    out.println("<td>" + fruits + "</td>");
                    out.println("<td>" + veggies + "</td>");
                    out.println("<td>" + meat + "</td>");
                    out.println("<td>" + dairy + "</td>");
                    out.println("<td>" + budget + "</td>");
                    out.println("<td>" + income + "</td>");

                    out.println("</tr>");
               }
               out.println("</table>");
               out.println("</bod;=y></html>");

               // Clean-up environment
               rs.close();
               stmt.close();
               conn.close();
          }
          catch(SQLException se)
          {
               se.printStackTrace();
          }
          catch(Exception e)
          {
               e.printStackTrace();
          }
          finally
          {
               //finally block used to close resources
               try
               {
                    if(stmt!=null)
                         stmt.close();
               }
               catch(SQLException se2)
               {}// nothing we can do
               try
               {
               if(conn!=null)
                    conn.close();
               }
               catch(SQLException se)
               {
               se.printStackTrace();
               }
          }
     }
}