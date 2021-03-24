
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datamodel.Product;
import util.Info;
import util.UtilDB;

/**
 * Servlet implementation class runEditProduct
 */
@WebServlet("/runEditProduct")
public class runEditProduct extends HttpServlet implements Info
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public runEditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String editProductID = "";
		
		editProductID = request.getParameter("newProductID");
		System.out.println(editProductID);
		
		String pName = request.getParameter("newProductName").trim();
		String pManu = request.getParameter("newManufacture").trim();
		String pInve = request.getParameter("newInventory").trim();
		
		UtilDB.editProductInfo(editProductID, pName, pManu, pInve);
		
		PrintWriter out = response.getWriter();
		
		String title = "Database Update";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
		out.println(docType + //
			"<html>\n" + //
			"<head><title>" + title + "</title></head>\n" + //
			"<body bgcolor=\"#f0f0f0\">\n" + //
			"<h1 align=\"center\">" + title + "</h1>\n");
		out.println("<ul>");
		out.println("<h3>Update finish.</h3>");
		out.println("</ul>");
		out.println("<a href=/" + projectName + "/" + editProduct + ">Back to Edit Product</a> <br>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
