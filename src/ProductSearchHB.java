import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Product;
import util.Info;
import util.UtilDB;

@WebServlet("/ProductSearchHB")
public class ProductSearchHB extends HttpServlet implements Info
{
	private static final long serialVersionUID = 1L;

	public ProductSearchHB() {
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

		List<Product> listProduct = null;
		if (keyword != null && !keyword.isEmpty()) {
			listProduct = UtilDB.listProduct(keyword);
		} else {
			listProduct = UtilDB.listProduct();
		}
		display(listProduct, out);
		out.println("</ul>");
		out.println("<a href=/" + projectName + "/" + searchProductName + ">Search Data</a> <br>");
		out.println("</body></html>");
	}

	void display(List<Product> listProduct, PrintWriter out) {
		for (Product product : listProduct) {
			System.out.println("[DBG] " + product.getId() + ", " //
				+ product.getProductName() + ", " //
				+ product.getManufacturer());
			out.println("<li>" + product.getId() + ", " //
				+ product.getProductName() + ", " //
				+ product.getManufacturer() + "," 
				+ product.getInventory() + "</li>");
			//out.print("<input type=\"text\" value= \"" + product.getProductName() + "\">");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
