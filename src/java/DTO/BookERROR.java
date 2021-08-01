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
public class BookERROR {

    private String bookIDERROR;
    private String booknameERROR;
    private String photoERROR;
    private String authorERROR;
    private String descriptionERROR;
    private String priceERROR;
    private String quantityERROR;
    private String cateERROR;

    public BookERROR() {
    }

    public BookERROR(String bookIDERROR, String booknameERROR, String photoERROR, String authorERROR, String descriptionERROR, String priceERROR, String quantityERROR, String cateERROR) {
        this.bookIDERROR = bookIDERROR;
        this.booknameERROR = booknameERROR;
        this.photoERROR = photoERROR;
        this.authorERROR = authorERROR;
        this.descriptionERROR = descriptionERROR;
        this.priceERROR = priceERROR;
        this.quantityERROR = quantityERROR;
        this.cateERROR = cateERROR;
    }

    public String getBookIDERROR() {
        return bookIDERROR;
    }

    public void setBookIDERROR(String bookIDERROR) {
        this.bookIDERROR = bookIDERROR;
    }

    public String getBooknameERROR() {
        return booknameERROR;
    }

    public void setBooknameERROR(String booknameERROR) {
        this.booknameERROR = booknameERROR;
    }

    public String getPhotoERROR() {
        return photoERROR;
    }

    public void setPhotoERROR(String photoERROR) {
        this.photoERROR = photoERROR;
    }

    public String getAuthorERROR() {
        return authorERROR;
    }

    public void setAuthorERROR(String authorERROR) {
        this.authorERROR = authorERROR;
    }

    public String getDescriptionERROR() {
        return descriptionERROR;
    }

    public void setDescriptionERROR(String descriptionERROR) {
        this.descriptionERROR = descriptionERROR;
    }

    public String getPriceERROR() {
        return priceERROR;
    }

    public void setPriceERROR(String priceERROR) {
        this.priceERROR = priceERROR;
    }

    public String getQuantityERROR() {
        return quantityERROR;
    }

    public void setQuantityERROR(String quantityERROR) {
        this.quantityERROR = quantityERROR;
    }

    public String getCateERROR() {
        return cateERROR;
    }

    public void setCateERROR(String cateERROR) {
        this.cateERROR = cateERROR;
    }

}
