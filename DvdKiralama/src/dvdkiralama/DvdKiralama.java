/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdkiralama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class DvdKiralama {
  public int elemansay(String table){
      int top=0;
       String dburl="jdbc:derby://localhost:1527/DvdKiralama";
      Connection con=null;
      Statement stm=null;
     try{
          con=DriverManager.getConnection(dburl, "Cahit", "123");
          stm=con.createStatement();
          ResultSet rs= stm.executeQuery("select count(*) as top from "+table);
          rs.next();
          top= rs.getInt("top");
         } catch (SQLException ex) {
          Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(con!=null)try {
              con.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
          if(stm!=null)try {
              stm.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
      } 
     return top;
  } 
  public boolean dvdEkle(Dvd dvd){
      String dburl="jdbc:derby://localhost:1527/DvdKiralama";
      Connection con=null;
      Statement stm=null;
      try {
          con=DriverManager.getConnection(dburl, "Cahit", "123");
          stm=con.createStatement();
     
          String q = "insert into Dvdler values('"+dvd.getDvdId()+"','"+dvd.getDvdName()+"','"+dvd.getTur()+"',0)";
          stm.executeUpdate(q);
               return true;   
                  
                  } catch (SQLException ex) {
          Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(con!=null)try {
              con.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
          if(stm!=null)try {
              stm.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      return false;
      
  }

  public List<Dvd> dvdlistele(){
      int i=0;String D;
      List<Dvd> liste = new ArrayList<>();
       String dburl="jdbc:derby://localhost:1527/DvdKiralama";
      Connection con=null;
      Statement stm=null;
     try{
          con=DriverManager.getConnection(dburl, "Cahit", "123");
          stm=con.createStatement();
          ResultSet rs= stm.executeQuery("select * from Dvdler order by DvdId asc");
          while(rs.next()){
              int d = rs.getInt(4);
              if(d==1)D="Kirada";
              else D="Mevcut";
               Dvd dvd = new Dvd();
              dvd.setDvdId(rs.getString(1));
              dvd.setDvdName(rs.getString(2));
              dvd.setTur(rs.getString(3));
              dvd.setDurum(D);
              liste.add(dvd);
              
          }
          
         } catch (SQLException ex) {
          Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(con!=null)try {
              con.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
          if(stm!=null)try {
              stm.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
      } 
      
      return liste;
  }
    
  public boolean dvdsil(String dvdid){
      String dburl="jdbc:derby://localhost:1527/DvdKiralama";
      Connection con=null;
      Statement stm=null;
      try {
          con=DriverManager.getConnection(dburl, "Cahit", "123");
          stm=con.createStatement();
          String q = "delete from Dvdler where DvdId='"+dvdid+"'";
          stm.executeUpdate(q);
               return true;   
                  
                } catch (SQLException ex) {
          Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(con!=null)try {
              con.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
          if(stm!=null)try {
              stm.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
     return false;
  }
  public List<Dvd> ismeGoreDvdAra(String isim){
       String D;
      List<Dvd> liste = new ArrayList<>();
      String dburl="jdbc:derby://localhost:1527/DvdKiralama";
      Connection con=null;
      Statement stm=null;
     try{
          con=DriverManager.getConnection(dburl, "Cahit", "123");
          stm=con.createStatement();
          ResultSet rs= stm.executeQuery("select * from Dvdler where DvdName like '"+isim+"%'");
          while(rs.next()){
              int d = rs.getInt(4);
              if(d==1)D="Kirada";
              else D="Mevcut";
              Dvd dvd = new Dvd();
              dvd.setDvdId(rs.getString(1));
              dvd.setDvdName(rs.getString(2));
              dvd.setTur(rs.getString(3));
              dvd.setDurum(D);
              liste.add(dvd);
          }
          
         } catch (SQLException ex) {
          Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(con!=null)try {
              con.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
          if(stm!=null)try {
              stm.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
      } 
      
      return liste;
     
}
   public boolean uyeEkle(Uye uye){
      String dburl="jdbc:derby://localhost:1527/DvdKiralama";
      Connection con=null;
      Statement stm=null;
      try {
          con=DriverManager.getConnection(dburl, "Cahit", "123");
          stm=con.createStatement();
     
          String q = "insert into Uyeler values('"+uye.getTcno()+"','"+
                  uye.getAd()+"','"+uye.getSoyad()+"','"+uye.getTel()+"')";
          stm.executeUpdate(q);
               return true;   
                  
                  } catch (SQLException ex) {
          Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(con!=null)try {
              con.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
          if(stm!=null)try {
              stm.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      return false;
      
  }
    public Object[][] uyelistele(){
      int i=0;
      Object[][] liste = new Object[elemansay("Uyeler")][4];
       String dburl="jdbc:derby://localhost:1527/DvdKiralama";
      Connection con=null;
      Statement stm=null;
     try{
          con=DriverManager.getConnection(dburl, "Cahit", "123");
          stm=con.createStatement();
          ResultSet rs= stm.executeQuery("select * from Uyeler ");
          while(rs.next()){
             
              liste[i][0]=rs.getString(1);
              liste[i][1]=rs.getString(2);
              liste[i][2]=rs.getString(3);
              liste[i][3]=rs.getString(4);
              i++;
          }
          
         } catch (SQLException ex) {
          Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(con!=null)try {
              con.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
          if(stm!=null)try {
              stm.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
      } 
      
      return liste;
  }
   public boolean uyesil(String tcno){
      String dburl="jdbc:derby://localhost:1527/DvdKiralama";
      Connection con=null;
      Statement stm=null;
      try {
          con=DriverManager.getConnection(dburl, "Cahit", "123");
          stm=con.createStatement();
          String q = "delete from Uyeler where TcNo='"+tcno+"'";
          stm.executeUpdate(q);
               return true;   
                  
                } catch (SQLException ex) {
          Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(con!=null)try {
              con.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
          if(stm!=null)try {
              stm.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
     return false;
  }
 
   public Object[][] tcyeGoreUyeAra(String tcno){
       int i=0;String D;
      Object[][] liste = new Object[1][4];
      String dburl="jdbc:derby://localhost:1527/DvdKiralama";
      Connection con=null;
      Statement stm=null;
     try{
          con=DriverManager.getConnection(dburl, "Cahit", "123");
          stm=con.createStatement();
          ResultSet rs= stm.executeQuery("select * from Uyeler where TcNO='"+tcno+"'");
          while(rs.next()){
              liste[0][0]=rs.getString(1);
              liste[0][1]=rs.getString(2);
              liste[0][2]=rs.getString(3);
              liste[0][3]=rs.getString(4);
             
             
          }
          
         } catch (SQLException ex) {
          Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          if(con!=null)try {
              con.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
          if(stm!=null)try {
              stm.close();
          } catch (SQLException ex) {
              Logger.getLogger(DvdKiralama.class.getName()).log(Level.SEVERE, null, ex);
          }
      } 
      
      return liste;
     
}  
    
}