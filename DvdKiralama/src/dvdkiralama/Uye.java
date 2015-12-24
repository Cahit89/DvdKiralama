/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdkiralama;

/**
 *
 * @author hp
 */
public class Uye {
  
    private String tcno;
    private String ad;
    private String soyad;
    private String tel;

    public Uye( String tcno, String ad, String soyad, String tel) {
      
        this.tcno = tcno;
        this.ad = ad;
        this.soyad = soyad;
        this.tel = tel;
    }

 

    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
