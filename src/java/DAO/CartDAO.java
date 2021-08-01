/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.OderDTO;
import DTO.OderdetailsDTO;
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
public class CartDAO {
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
    public void insertOder(OderDTO oder) throws SQLException{
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Insert Into tblOder(oderdate,totalofOder,userid)"
                        + " Values(?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setDate(1, oder.getOderdate());
                ps.setFloat(2, oder.getTotaloder());
                ps.setString(3, oder.getUserid());                
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    public int getoderid()throws SQLException{
        int oderid=0;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select Max(oderID) as oderID"
                        + " From tblOder";                       
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                if(rs.next()){
                    oderid=rs.getInt("oderID");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return oderid;
    }
    
    public void insertOderdetail(OderdetailsDTO oder) throws SQLException{
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Insert Into tblOderdetail(price,quantity,total,oderDate,bookID,oderID)"
                        + " Values(?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setFloat(1, oder.getPrice());
                ps.setInt(2, oder.getQuantity());
                ps.setFloat(3, oder.getTotal());
                ps.setDate(4, oder.getOderdate());
                ps.setString(5, oder.getBookID());
                ps.setInt(6, oder.getOderid());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
    /* public int getoderid2(String id)throws SQLException{
        int oderid=0;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select oderID"
                        + " From tblOder"
                        + " Where userid=?";                       
                ps=conn.prepareStatement(sql);
                ps.setString(1, id);
                rs=ps.executeQuery();
                while(rs.next()){
                    oderid=rs.getInt("oderID");                   
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }        
        return oderid;
        
    }*/
      public List<OderdetailsDTO > getoderdetails(String userid) throws SQLException{
        List<OderdetailsDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select OderdetailID,price,quantity,total,a.oderDate,bookID,a.oderID"
                        + " From tblOderdetail a join tblOder b on a.oderID=b.oderID"
                        + " Where b.userid=?";
                ps=conn.prepareStatement(sql);
                ps.setString(1, userid);
                rs=ps.executeQuery();
                while(rs.next()){
                    String OderdetailID=rs.getString("OderdetailID");
                    float price=rs.getFloat("price");
                    int quantity=rs.getInt("quantity");
                    float total=rs.getFloat("total");
                    Date oderdate=rs.getDate("oderDate");       
                    String bookID=rs.getString("bookID");
                    int oderID=rs.getInt("oderID");
                    if(list==null){
                        list=new ArrayList<>();
                    }
                    list.add(new OderdetailsDTO(oderID, price, quantity, total, oderdate, bookID, oderID));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }      
        return list;     
      }
    public List<OderdetailsDTO> searchHistorydate(String userID,String date) throws SQLException{
        List<OderdetailsDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select OderdetailID,price,quantity,total,a.oderDate,bookID,a.oderID"
                        + " From tblOderdetail a join tblOder b on a.oderID=b.oderID"
                        + " Where b.userid=? and a.oderDate=?";
                ps=conn.prepareStatement(sql);
                ps.setString(1, userID);
                ps.setString(2, date);
                rs=ps.executeQuery();
                while(rs.next()){
                    String OderdetailID=rs.getString("OderdetailID");
                    float price=rs.getFloat("price");
                    int quantity=rs.getInt("quantity");
                    float total=rs.getFloat("total");
                    Date oderdate=rs.getDate("oderDate");       
                    String bookID=rs.getString("bookID");
                    int oderID=rs.getInt("oderID");
                    if(list==null){
                        list=new ArrayList<>();
                    }                   
                        list.add(new OderdetailsDTO(oderID, price, quantity, total, oderdate, bookID, oderID));
              
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
