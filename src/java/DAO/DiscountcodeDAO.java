/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DiscountcodeDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PRREDETOR
 */
public class DiscountcodeDAO {
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
    public void insert(DiscountcodeDTO code) throws SQLException{
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Insert Into tbldiscount(code,discountpercent,status,discountdate)"
                        + " Values(?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, code.getCode());
                ps.setInt(2, code.getPercent());
                ps.setBoolean(3, code.isStatus());
                 ps.setInt(4, code.getDate());                 
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
