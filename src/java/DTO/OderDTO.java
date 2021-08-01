/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author PRREDETOR
 */
public class OderDTO {
    int oderid;
    Date oderdate;
    float totaloder;
    String userid;

    public OderDTO() {
    }

    public OderDTO(int oderid, Date oderdate, float totaloder, String userid) {
        this.oderid = oderid;
        this.oderdate = oderdate;
        this.totaloder = totaloder;
        this.userid = userid;
    }

    public OderDTO(Date oderdate, float totaloder, String userid) {
        this.oderdate = oderdate;
        this.totaloder = totaloder;
        this.userid = userid;
    }

    public OderDTO(int oderid) {
        this.oderid = oderid;
    }
    

    public int getOderid() {
        return oderid;
    }

    public void setOderid(int oderid) {
        this.oderid = oderid;
    }

    public Date getOderdate() {
        return oderdate;
    }

    public void setOderdate(Date oderdate) {
        this.oderdate = oderdate;
    }

    public float getTotaloder() {
        return totaloder;
    }

    public void setTotaloder(float totaloder) {
        this.totaloder = totaloder;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    
}
