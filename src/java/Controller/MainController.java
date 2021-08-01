/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BookDAO;
import DAO.CateDAO;
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
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "Shoppingpage1.jsp";
    private static final String login = "LoginAdmin.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String Search = "SearchController";
    private static final String Addtocart = "AddcartController";
    private static final String Deletecart = "DeletecartController";
    private static final String Updatecart = "UpdatecartController";
    private static final String CreateBook = "CreatebookController";
    private static final String DeleteBook = "DeletebookController";
    private static final String AdminSearch = "AdminsearchController";
    private static final String UpdateBook = "UpdateBook.jsp";
    private static final String Confirm = "UpdateBookController";
    private static final String Checkout = "CheckoutController";
    private static final String Createaccount = "CreateaccountController";
    private static final String Logout = "LogoutController";
    private static final String ViewHistory = "HistoryController";
    private static final String ViewCart = "Cart.jsp";
    private static final String Searchhistory = "SearchhistoryController";
     private static final String Creatediscountcode = "CreatediscountcodeController";
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            BookDAO req = new BookDAO();
            List<BookDTO> list = req.getallbook();
            UserDTO dto=(UserDTO) session.getAttribute("LOGIN_USER");
            if (list != null) {
                request.setAttribute("List_Item", list);
                CateDAO catedao = new CateDAO();
                List<CateDTO> cate = catedao.getCate();
                session.setAttribute("Category", cate);
                url = SUCCESS;
            }
            if ("Login".equals(action)) {
                url = LOGIN;
            }
            else if("login".equals(action)){
                url=login;
            } else if ("Logout".equals(action)) {
                url = LOGOUT;
            } else if ("Search".equals(action)) {
                url = Search;
            } else if ("Addtocart".equals(action)) {
                if (dto == null) {
                    url = "LoginAdmin.jsp";
                } else {
                    url = Addtocart;
                }
            } else if ("DeleteCart".equals(action)) {
                url = Deletecart;
            } else if ("UpdateBook".equals(action)) {
                url = Updatecart;
            } else if ("Create".equals(action)) {
                url = CreateBook;
            } else if ("Delete".equals(action)) {
                url = DeleteBook;
            } else if ("SearchBook".equals(action)) {
                url = AdminSearch;
            } else if ("UpdateBookAdmin".equals(action)) {
                url = UpdateBook;
            } else if ("Confirm".equals(action)) {
                url = Confirm;
            } else if ("Checkout".equals(action)) {
                url = Checkout;
            } else if ("CreateAccount".equals(action)) {
                url = Createaccount;
            }else if("Logout".equals(action)){
                url=LOGOUT;
            }else if("History".equals(action)){
                if (dto == null) {
                    url = "LoginAdmin.jsp";
                } else {
                    url = ViewHistory;
                }
            }else if("SearchDay".equals(action)){
                url=Searchhistory;
            }else if("CreateCode".equals(action)){
                url=Creatediscountcode;
            }else if("Viewcart".equals(action)){
                url=ViewCart;
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
