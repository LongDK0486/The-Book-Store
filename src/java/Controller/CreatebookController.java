/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Copy.Copyphoto;
import DAO.BookDAO;
import DTO.BookDTO;
import DTO.BookERROR;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRREDETOR
 */
public class CreatebookController extends HttpServlet {
    private static final String SUCCESS="AdminsearchController?action=SearchBook&"
            + "Searchname=&SearchCate=0";
    private static final String ERROR="Createbook.jsp";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        BookERROR error=new BookERROR("", "", "", "", "", "", "", "");
        try {
            boolean flag = true;
            String bookid = request.getParameter("bookID");
            String name = request.getParameter("bookName");
            String author = request.getParameter("author");
            String cateid = request.getParameter("cateID");
            int quantity = Integer.parseInt("0");
            String description = request.getParameter("descp");
            float price = Integer.parseInt("0");
            String photo = request.getParameter("photo");
            int lastIndex = photo.lastIndexOf("\\");
            String photoName = photo.substring(lastIndex + 1);
            if (!photo.isEmpty()) {
                if (photo.contains(".jpg") || photo.contains(".img") || photo.contains(".png")) {
                    File head = new File(photo);
                    File tail = new File("D:\\PRJ321\\J3.L.P0018\\web\\image\\" + photoName);
                    Copyphoto.copyfile(head, tail);
                } else {
                    flag = false;
                    error.setPhotoERROR("Photo is wrong");
                }
            }
            if(bookid.length()<2||bookid.length()>6){
                flag=false;
               error.setBookIDERROR("Id not must below than 2  and lager than 6 word ");
            }
            if(name.length()>30||name.length()<=1){
                flag=false;
                error.setBooknameERROR("Name must not lager than 30 and below than 1");
            }
            if(author.length()<1){
                flag=false;
                error.setAuthorERROR("Address must not below than 1");
            }           
            if(cateid.length()<1||cateid.length()>5){
                flag=false;
                error.setCateERROR("category must not below than 1");
            }
            try {
                quantity =Integer.parseInt(request.getParameter("quantity"));
                if(quantity<=0){
                    flag=false;
                    error.setQuantityERROR("quantity number must be lager than 0 ");
                }
            } catch (Exception e) {
                flag=false;
                error.setQuantityERROR("quantity number must be digit");
            }
            
             try {
                price =Float.parseFloat(request.getParameter("price"));
                if(price<=0){
                    flag=false;
                    error.setPriceERROR("Price number must be lager than 0 ");
                }
            } catch (Exception e) {
                flag=false;
                error.setPriceERROR("Price number must be digit");
            }
             if(flag){
                 BookDTO dto=new BookDTO(bookid, name, author, cateid, description, photoName, price, true, quantity);
                 BookDAO dao=new BookDAO();
                 dao.insert(dto);
                 request.setAttribute("NEW_ACCOUNT", dto);
                url=SUCCESS;
             }else{
                 request.setAttribute("ERROR", error);
             }
             
        } catch (Exception e) {
            log("Error at CreateController"+e.toString());
            if(e.toString().contains("duplicate")){
                error.setBookIDERROR("BookID duplicate");
                request.setAttribute("ERROR", error);
            }
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
