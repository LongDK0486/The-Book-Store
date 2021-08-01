/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PRREDETOR
 */
public class CateDTO {
    String cateid,catename;

    public CateDTO() {
    }

    public CateDTO(String cateid, String catename) {
        this.cateid = cateid;
        this.catename = catename;
    }

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }
    
}
