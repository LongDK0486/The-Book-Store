/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BookDAO;
import DAO.CateDAO;
import DAO.UserDAO;
import DTO.BookDTO;
import DTO.CateDTO;
import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PRREDETOR
 */
public class LoginController extends HttpServlet {
  private static final String ERROR="LoginAdmin.jsp";
    private static final String SUCCESS="AdminView.jsp";
    private static final String SUCCESS2="Shoppingpage1.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            UserDAO dao = new UserDAO();
            UserDTO user = dao.login(userID, password);
            String role = user.getRoleID();
            BookDAO req = new BookDAO();
            HttpSession session = request.getSession();
            if (user != null) {
                session.setAttribute("LOGIN_USER", user);
                if ("AD".equals(role)) {
                    List<BookDTO> list = req.getallbook();
                    if (list != null) {
                        request.setAttribute("List_Book", list);
                        CateDAO catedao = new CateDAO();
                        url = SUCCESS;
                    }
                } else if ("US".equals(role)) {
                    List<BookDTO> list = req.getallbook();
                    if (list != null) {
                        request.setAttribute("List_Item", list);
                        CateDAO catedao = new CateDAO();
                        url = SUCCESS2;
                    }
                }
                CateDAO catedao = new CateDAO();
                List<CateDTO> cate = catedao.getCate();
                session.setAttribute("Category", cate);

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
