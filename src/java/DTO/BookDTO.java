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
public class BookDTO {
    String bookID,bookName,author,cateID,description,image;
    float price;
    boolean status;
    int quantity;

    public BookDTO() {
    }

    public BookDTO(String bookID, String bookName, String author, String cateID, String description, String image, float price, boolean status, int quantity) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.cateID = cateID;
        this.description = description;
        this.image = image;
        this.price = price;
        this.status = status;
        this.quantity = quantity;
    }

    public BookDTO(String bookID, String bookName) {
        this.bookID = bookID;
        this.bookName = bookName;
    }
    

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
