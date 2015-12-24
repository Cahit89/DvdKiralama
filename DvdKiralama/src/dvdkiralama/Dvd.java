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
public class Dvd {
    private String DvdId;
    private String DvdName;
    private String Tur;
    private String durum;
    public Dvd(){};
    public Dvd(String DvdId, String DvdName, String Tur) {
        this.DvdId = DvdId;
        this.DvdName = DvdName;
        this.Tur=Tur;
    }

    public String getTur() {
        return Tur;
    }

    public void setTur(String Tur) {
        this.Tur = Tur;
    }

    public String getDvdId() {
        return DvdId;
    }

    public void setDvdId(String DvdId) {
        this.DvdId = DvdId;
    }

    public String getDvdName() {
        return DvdName;
    }

    public void setDvdName(String DvdName) {
        this.DvdName = DvdName;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
    
    
}
