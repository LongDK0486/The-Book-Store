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
public class OderdetailsDTO {
    int oderdetailsID;
    float price;
    int quantity;
    float total;
    Date oderdate;
    String bookID;
    int oderid;

    public OderdetailsDTO() {
    }

    public OderdetailsDTO(int oderdetailsID, float price, int quantity, float total, Date oderdate, String bookID, int oderid) {
        this.oderdetailsID = oderdetailsID;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.oderdate = oderdate;
        this.bookID = bookID;
        this.oderid = oderid;
    }

    public OderdetailsDTO(float price, int quantity, float total, Date oderdate, String bookID, int oderid) {
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.oderdate = oderdate;
        this.bookID = bookID;
        this.oderid = oderid;
    }

    public int getOderdetailsID() {
        return oderdetailsID;
    }

    public void setOderdetailsID(int oderdetailsID) {
        this.oderdetailsID = oderdetailsID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getOderdate() {
        return oderdate;
    }

    public void setOderdate(Date oderdate) {
        this.oderdate = oderdate;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getOderid() {
        return oderid;
    }

    public void setOderid(int oderid) {
        this.oderid = oderid;
    }
    
}
