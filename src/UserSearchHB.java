import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.User;
import util.Info;
import util.UtilDB;

@WebServlet("/UserSearchHB")
public class UserSearchHB extends HttpServlet implements Info
{
	private static final long serialVersionUID = 1L;

	public UserSearchHB() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword").trim();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Database Result";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
		out.println(docType + //
			"<html>\n" + //
			"<head><title>" + title + "</title></head>\n" + //
			"<body bgcolor=\"#f0f0f0\">\n" + //
			"<h1 align=\"center\">" + title + "</h1>\n");
		out.println("<ul>");

		List<User> listUser = null;
		if (keyword != null && !keyword.isEmpty()) {
			listUser = UtilDB.listUser(keyword);
		} else {
			listUser = UtilDB.listUser();
		}
		display(listUser, out);
		out.println("</ul>");
		out.println("<a href=/" + projectName + "/" + searchUserName + ">Search Data</a> <br>");
		out.println("</body></html>");
	}

	void display(List<User> listUser, PrintWriter out) {
		for (User User : listUser) {
			System.out.println("[DBG] " + User.getId() + ", " //
				+ User.getName() + ", " //
				+ User.getAge());
			out.println("<li>" + User.getId() + ", " //
				+ User.getName() + ", " //
				+ User.getAge() + ", " 
				+ User.getGender() + ", "
				+ User.getEmail() + ", " //
				+ User.getAddress() + ", " 
				+ User.getHistory1() + ", "
				+ "</li>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
