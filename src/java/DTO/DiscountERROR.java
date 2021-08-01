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
public class DiscountERROR {
     private String codeERROR;
    private String percentERROR;
    private String dateERROR;

    public DiscountERROR() {
    }

    public DiscountERROR(String codeERROR, String percentERROR, String dateERROR) {
        this.codeERROR = codeERROR;
        this.percentERROR = percentERROR;
        this.dateERROR = dateERROR;
    }

    public String getCodeERROR() {
        return codeERROR;
    }

    public void setCodeERROR(String codeERROR) {
        this.codeERROR = codeERROR;
    }

    public String getPercentERROR() {
        return percentERROR;
    }

    public void setPercentERROR(String percentERROR) {
        this.percentERROR = percentERROR;
    }

    public String getDateERROR() {
        return dateERROR;
    }

    public void setDateERROR(String dateERROR) {
        this.dateERROR = dateERROR;
    }
    
}
