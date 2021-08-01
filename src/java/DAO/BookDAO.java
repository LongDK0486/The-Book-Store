/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.BookDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRREDETOR
 */
public class BookDAO {
    Connection conn=null;
    PreparedStatement ps =null;
    ResultSet rs=null;
    public void closeConnection() throws SQLException{
        if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(conn!=null){
                conn.close();
            }
    }
    public List<BookDTO> getallbook() throws SQLException{
        List<BookDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select bookID,bookName,author,cateID,description,price,status,quantity,image"
                        + " From tblBook"
                        + " Where status=1 and quantity > 0";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    String bookid=rs.getString("bookID");
                    String bookname=rs.getString("bookName");
                    String author=rs.getString("author");
                    String cateID=rs.getString("cateID");
                    String desctiption=rs.getString("description");
                    float price=rs.getFloat("price");
                    boolean status=rs.getBoolean("status");
                    int quantity=rs.getInt("quantity");
                    String image=rs.getString("image");
                    if(list==null){
                        list=new ArrayList<>();
                    }
                    list.add(new BookDTO(bookid, bookname, author, cateID, desctiption, image, price, status, quantity));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }      
        return list;        
    }
     public List<BookDTO> searchname(String searchcate,String searchname) throws SQLException{
         List<BookDTO> list = null;           
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                 String sql="Select bookID,bookName,author,cateID,description,price,status,quantity,image"
                        + " From tblBook"
                        + " Where bookName like ?  and status=1 and quantity > 0";
                ps = conn.prepareStatement(sql);
                 ps.setString(1,"%"+ searchname +"%");                
                rs = ps.executeQuery();
                while (rs.next()) {
                    String bookid=rs.getString("bookID");
                    String bookname=rs.getString("bookName");
                    String author=rs.getString("author");
                    String cateID=rs.getString("cateID");
                    String desctiption=rs.getString("description");
                    float price=rs.getFloat("price");
                    boolean status=rs.getBoolean("status");
                    int quantity=rs.getInt("quantity");
                    String image=rs.getString("image");
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    if (searchcate.equals("0") || searchcate.equals(cateID)) {
                        list.add(new BookDTO(bookid, bookname, author, cateID, desctiption, image, price, status, quantity));
                    }
                }
            }                  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
     public List<BookDTO> searchprice(String searchcate,String searchname,int Price) throws SQLException{
         List<BookDTO> list = null;           
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                 String sql="Select bookID,bookName,author,cateID,description,price,status,quantity,image"
                        + " From tblBook"
                        + " Where bookName like ? and price <=? and status=1 and quantity > 0";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+ searchname +"%"); 
                ps.setInt(2, Price);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String bookid=rs.getString("bookID");
                    String bookname=rs.getString("bookName");
                    String author=rs.getString("author");
                    String cateID=rs.getString("cateID");
                    String desctiption=rs.getString("description");
                    float price=rs.getFloat("price");
                    boolean status=rs.getBoolean("status");
                    int quantity=rs.getInt("quantity");
                    String image=rs.getString("image");
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    if (searchcate.equals("0") || searchcate.equals(cateID)) {
                        list.add(new BookDTO(bookid, bookname, author, cateID, desctiption, image, price, status, quantity));
                    }
                }
            }                  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
     public void insert(BookDTO book) throws SQLException{
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Insert Into tblBook(bookID,bookName,author,cateID,description,price,status,quantity,image)"
                        + " Values(?,?,?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, book.getBookID());
                ps.setString(2, book.getBookName());
                ps.setString(3, book.getAuthor());
                 ps.setString(4, book.getCateID());
                  ps.setString(5, book.getDescription());
                   ps.setFloat(6, book.getPrice());
                  ps.setBoolean(7, book.isStatus());
                  ps.setInt(8, book.getQuantity());
                  ps.setString(9, book.getImage());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
     public boolean DeleteBook(String id)throws SQLException{
        boolean check = false;     
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Update tblBook Set status = 0"
                        + " Where bookID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
     public boolean update(BookDTO book) throws SQLException{
        boolean check=false;    
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Update tblBook Set bookName=?,author=?,cateID=?,description=?,price=?,quantity=?,image=?"
                        + " Where bookID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, book.getBookName());
                ps.setString(2, book.getAuthor());
                ps.setString(3, book.getCateID());
                ps.setString(4, book.getDescription());
                ps.setFloat(5, book.getPrice());
                ps.setInt(6, book.getQuantity());
                ps.setString(7, book.getImage());
                ps.setString(8, book.getBookID());
                check=ps.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{          
          closeConnection();
        }
        return check;
    }
      public boolean Chancequantity(String id,int quantity)throws SQLException{
        boolean check = false;     
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Update tblBook Set quantity ='" + quantity + "'"
                        + " Where bookID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
      public int getquantity(String id)throws SQLException{
        int quantity=0;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select quantity"
                        + " From tblBook"
                        + " Where bookID = ?";                       
                ps=conn.prepareStatement(sql);
                ps.setString(1, id);
                rs=ps.executeQuery();
                if(rs.next()){
                    quantity=rs.getInt("quantity");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return quantity;
    }
      public List<BookDTO> getBookname() throws SQLException{
        List<BookDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select bookID,bookName"
                        + " From tblBook";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    String bookID=rs.getString("bookID");
                    String bookName=rs.getString("bookName");
                    if(list==null){
                        list=new ArrayList<>();
                    }
                    list.add(new BookDTO(bookID, bookName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return list;
    }
}
