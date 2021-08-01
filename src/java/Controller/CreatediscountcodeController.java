/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DiscountcodeDAO;
import DTO.DiscountERROR;
import DTO.DiscountcodeDTO;
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
public class CreatediscountcodeController extends HttpServlet {
    private static final String SUCCESS="AdminsearchController?action=SearchBook&"
            + "Searchname=&SearchCate=0";
    private static final String ERROR="Createbook.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        DiscountERROR error=new DiscountERROR("", "", "");
        try {
            boolean flag = true;
            String code = request.getParameter("code");
            int percent = Integer.parseInt("0");
           int date = Integer.parseInt("0");
            if(code.length()<5||code.length()>20){
                flag=false;
               error.setCodeERROR("Id not must below than 5 and lager than 20 word ");
            }
           try {
                percent =Integer.parseInt(request.getParameter("percent"));
                if(percent<=0){
                    flag=false;
                    error.setPercentERROR("percent number must not below than 0 digit");
                }
            } catch (Exception e) {
                flag=false;
                error.setPercentERROR("percent number must be digit");
            }
           try {
                date =Integer.parseInt(request.getParameter("percent"));
                if(date<=0){
                    flag=false;
                    error.setDateERROR("Date number must not below than 0 digit");
                }
            } catch (Exception e) {
                flag=false;
                error.setDateERROR("Date number must be digit");
            }
           if(flag){
               DiscountcodeDTO dto=new DiscountcodeDTO(code, percent, true, date);
               DiscountcodeDAO dao=new DiscountcodeDAO();
               dao.insert(dto);
               request.setAttribute("NEW_Discount", dto);
               url=SUCCESS;
           }else{
               request.setAttribute("ERROR", error);
           }

            
        } catch (Exception e) {
            log("Error at CreateController"+e.toString());
            if(e.toString().contains("duplicate")){
                error.setCodeERROR("Code is duplicate");
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
