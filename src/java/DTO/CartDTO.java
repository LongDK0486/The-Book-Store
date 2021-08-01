/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.CartDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PRREDETOR
 */
public class CartDTO {
     private Map<String,BookDTO>cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public Map<String, BookDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }
      public void add(BookDTO book){
        if(this.cart==null){
            this.cart=new HashMap<>();
        }
        if(this.cart.containsKey(book.getBookID())){
            int quantity=this.cart.get(book.getBookID()).getQuantity();
            book.setQuantity(quantity+book.getQuantity());
        }
        cart.put(book.getBookID(), book);
    }
      public void deltete(String id){
        if(this.cart == null){
            return;
        }
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        }
    }

    public void update(String id,BookDTO book){
        if(this.cart==null){
            return;
        }
        if(this.cart.containsKey(id)){
            this.cart.replace(id, book);
        }
    }
    public Float gettotal() {
        float totalofoder = 0;
        
        if (this.cart != null) {
            for (BookDTO dto : cart.values()) {
                int quantity=dto.getQuantity();
                totalofoder+=dto.getPrice()*quantity;
            }
        }
        return totalofoder;
    }
    public List<OderdetailsDTO> oderdetail() throws SQLException{
        List<OderdetailsDTO> list=new ArrayList<>();
        
        if(this.cart!=null){
            for(BookDTO dto:cart.values()){
                float price=dto.getPrice();
                int quantity=dto.getQuantity();
                float total=price*quantity;
                long millis=System.currentTimeMillis();
                java.sql.Date Date=new java.sql.Date(millis);
                Date oderdate=Date;
                String bookid=dto.getBookID();
                CartDAO dao=new CartDAO();
                int oderid=dao.getoderid();
                OderdetailsDTO oderdetails=new OderdetailsDTO(price, quantity, total, oderdate, bookid, oderid);
                list.add(oderdetails);
            }
        }        
        return list;
        
    }
}

