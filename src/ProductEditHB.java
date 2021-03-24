
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


/**
 * Servlet implementation class ProductEditHB
 */
@WebServlet("/ProductEditHB")
public class ProductEditHB extends HttpServlet implements Info
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEditHB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("productID").trim();

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
			listProduct = UtilDB.searchProductID(keyword);
		} else {
			listProduct = UtilDB.listProduct();
		}
		if (listProduct.isEmpty())
		{
			out.println("<h1>Sorry, we cannot find input product.</h1>");
			out.println("<h1>Try other product infromation.</h1>");
		}
		else
		{

			display(listProduct, out);
		}
		
		out.println("</ul>");
		out.println("<a href=/" + projectName + "/" + searchProductName + ">Search Data</a> <br>");
		out.println("</body></html>");
	}

	void display(List<Product> listProduct, PrintWriter out) {
		for (Product product : listProduct) {
			System.out.println("[DBG] " + product.getId() + ", " //
				+ product.getProductName() + ", " //
				+ product.getManufacturer());
			/*out.println("<li>" + product.getId() + ", " //
				+ product.getProductName() + ", " //
				+ product.getManufacturer() + "," 
				+ product.getInventory() + "</li>");*/
			//out.print("<input type=\"text\" value= \"" + product.getProductName() + "\">");
			
			out.print("<form action=\"runEditProduct\" method=\"POST\"> "
					+ "Product ID: <input type=\"text\" name=\"newProductID\" value= \"" + product.getId() + "\" readonly> <br /> "
					+ "Product Name: <input type=\"text\" name=\"newProductName\" value= \"" + product.getProductName() + "\"> <br /> "
					+ "Manufacture: <input type=\"text\" name=\"newManufacture\" value= \"" + product.getManufacturer() + "\"> <br /> "
					+ "Inventory: <input type=\"text\" name=\"newInventory\" value= \"" + product.getInventory() + "\"> <br /> "
					+ "<input type=\"submit\" value=\"Edit\" /> "
					+ "</form>");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
