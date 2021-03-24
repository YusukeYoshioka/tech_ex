
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.User;
import util.UtilDB;

@WebServlet("/MyServletHibernateDBforTE")
public class MyServletHibernateDBforTE extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletHibernateDBforTE() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<User> listUsers = UtilDB.listUser();
      for (User user : listUsers) {
         System.out.println("[DBG] " + user.getId() + ", " //
               + user.getName() + ", " //
               + user.getAge());

         out.println("<li>" + user.getId() + ", " //
               + user.getName() + ", " //
               + user.getAge() + "</li>");
      }
      out.println("</ul>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
