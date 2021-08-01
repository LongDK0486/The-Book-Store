/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.BookDTO;
import DTO.CartDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PRREDETOR
 */
public class AddcartController extends HttpServlet {
    private static final String SUCCESS="SearchController?action=Search&"
            + "Searchname=&SearchCate=0&Searchprice=";
    private static final String ERROR="error.jsp";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {
            String bookid = request.getParameter("Bookid");
            String bookname = request.getParameter("Bookname");
            String Cateid = request.getParameter("CateID");
            Float Price = Float.parseFloat(request.getParameter("price"));
            String image = request.getParameter("image");
            int quantity = 1;
            BookDTO book = new BookDTO(bookid, bookname, "", Cateid, "", image, Price, true, quantity);
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("Cart");
            if(cart==null){
                cart=new CartDTO();
            }
            cart.add(book);
            session.setAttribute("Cart", cart);
            url=SUCCESS;
        } catch (Exception e) {
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
