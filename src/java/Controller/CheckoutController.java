/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BookDAO;
import DAO.CartDAO;
import DTO.CartDTO;
import DTO.OderDTO;
import DTO.OderdetailsDTO;
import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PRREDETOR
 */
public class CheckoutController extends HttpServlet {
     private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "Notification.jsp";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        
        try {
           HttpSession session = request.getSession();        
           if(session!=null){
               UserDTO user= (UserDTO) session.getAttribute("LOGIN_USER");
               String userid=user.getId();
               CartDTO cart= (CartDTO) session.getAttribute("Cart");
               int oldquantity=0;
               int newquantity=0;
               if(cart!=null){
                   float totalofoder=cart.gettotal();
                   long millis=System.currentTimeMillis();
                   java.sql.Date Date=new java.sql.Date(millis);
                   CartDAO dao=new CartDAO(); 
                   BookDAO book=new BookDAO();                  
                   OderDTO oder=new OderDTO(Date, totalofoder, userid);                   
                   dao.insertOder(oder);
                   List<OderdetailsDTO> list=new ArrayList<>();                  
                   list=cart.oderdetail();
                   for(OderdetailsDTO dto:list){                      
                       dao.insertOderdetail(dto);
                      oldquantity=book.getquantity(dto.getBookID());
                      newquantity=oldquantity-dto.getQuantity();
                      book.Chancequantity(dto.getBookID(), newquantity);
                   }
                   
               }
               session.removeAttribute("Cart");
               url=SUCCESS;
           }

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
