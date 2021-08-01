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
public class DiscountcodeDTO {
    String code;
    int percent;
    boolean status;
    int date;

    public DiscountcodeDTO() {
    }

    public DiscountcodeDTO(String code, int percent, boolean status, int date) {
        this.code = code;
        this.percent = percent;
        this.status = status;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    

   

   
    
}
