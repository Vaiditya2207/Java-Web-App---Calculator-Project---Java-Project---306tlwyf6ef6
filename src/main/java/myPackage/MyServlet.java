package myPackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am here");
    
        String operand1Str = request.getParameter("operand1");
        String operand2Str = request.getParameter("operand2");
        String operation = request.getParameter("operation");
    
        if (operand1Str == null || operand2Str == null || operation == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Required parameter(s) missing");
            return;
        }
    
        double operand1, operand2;
        try {
            operand1 = Double.parseDouble(operand1Str);
            operand2 = Double.parseDouble(operand2Str);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format");
            return;
        }
    
        System.out.println(operand1 + " " + operand2 + " " + operation);
    
        Calculator calculator = new Calculator();
        double result;
        try {
            result = calculator.performOperation(operand1, operand2, operation);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error performing operation");
            return;
        }
    
        System.out.println(result);
        request.setAttribute("result", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
