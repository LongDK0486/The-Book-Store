/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UserDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PRREDETOR
 */
public class UserDAO {
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
    public UserDTO login(String id,String password) throws SQLException{
        UserDTO user=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql=" Select userID,username,phone,email,roleID,status"
                        + " From tbluser"
                        + " Where userID='" + id + "' And password='" + password + "'";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                if(rs.next()){         
                    String name =rs.getString("username");  
                    int phone=rs.getInt("phone");
                    String email =rs.getString("email"); 
                    String roleid =rs.getString("roleID"); 
                    boolean status=rs.getBoolean("status");
                    if(status==true){
                       user=new UserDTO(id, name, "", email, roleid, phone, status);
                    }else{
                        return user;
                    }         
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return user;
    }
    public void insert(UserDTO user) throws SQLException{
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Insert Into tbluser(userID,username,password,phone,email,roleID,status)"
                        + " Values(?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPassword());
                ps.setInt(4, user.getPhone());
                ps.setString(5, user.getEmail());
                ps.setString(6, user.getRoleID());
                ps.setBoolean(7, user.isStatus());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
