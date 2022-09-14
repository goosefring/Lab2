/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rehan
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String message = "---";
        
        request.setAttribute("message", message);
        
                this.getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstValue = request.getParameter("first");
        String secondValue = request.getParameter("second");
        
        String operation = request.getParameter("operation");

        
        String message;

        try {
            double parseFirst = Double.parseDouble(firstValue);
            double parseSecond = Double.parseDouble(secondValue);
        
            double result;
            
            switch (operation) {
                case "+": {
                    result = parseFirst + parseSecond;
                    break;
                }
            
                case "-": {
                    if (parseFirst >= parseSecond) {
                        result = parseFirst - parseSecond;
                    }
                    else {
                        result = parseSecond - parseFirst;
                    }
                    break;
                }
            
                case "*": {
                    result = parseFirst * parseSecond;
                    break;
                }
                        
                case "%": {
                    result = parseFirst % parseSecond;
                    break;
                }
             
                default: {
                    result = Double.NaN;
                    break;
                }
            }
        
            if (Double.isNaN(result)) {
                message = "Result is not a number!";
            }
        
            else {
                message = String.format("%.1f", result);
                //message = Double.toString(result);
                //message = result + "";
            }
        }
        
        catch (Exception e) {
            message = "Invalid Input!";
        }
        
        request.setAttribute("message", message);

        this.getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

    }

}
