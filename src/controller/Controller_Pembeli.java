
package controller;

import model.datapembeli;
import database.Koneksi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;


public class Controller_Pembeli {
    
    Koneksi koneksi;
    ArrayList<datapembeli> arrpembeli;

    public Controller_Pembeli(){
        this.koneksi = new Koneksi();
        this.arrpembeli = new ArrayList<>();
    }
    
    public void insertPembeli(datapembeli pembeli) {
        
        this.koneksi.ManipulasiData("INSERT INTO PEMBELI_07047 (ID_PEMBELI, NAMA_PEMBELI, GENDER, alamat_07047) "
                + "VALUES ("+pembeli.getId_pembeli()+", '"+ pembeli.getNama_pembeli()+"','"+ pembeli.getGender() +"','"
                + pembeli.getAlamat()+"')");
        
        System.out.println("INSERT INTO PEMBELI_07047 (ID_PEMBELI, NAMA_PEMBELI, GENDER, alamat_07047) "
                + "VALUES ("+pembeli.getId_pembeli()+", '"+ pembeli.getNama_pembeli()+"','"+ pembeli.getGender() +"','"
                + pembeli.getAlamat()+"')");
    }  
    
//    Update Controller_Pembeli
    public void UpdatePembeli(datapembeli pembeli){
       
        this.koneksi.ManipulasiData("UPDATE PEMBELI_07047 SET "+"nama_pembeli = '"+pembeli.getNama_pembeli()
                                    +"', "+"Gender='"+pembeli.getGender()+"', "
                                    +"alamat_07047='"+pembeli.getAlamat()+"' "+" WHERE ID_PEMBELI="+pembeli.getId_pembeli());
        System.out.println("UPDATE PEMBELI_07047 SET "+"nama_pembeli = '"+pembeli.getNama_pembeli()
                                    +"', "+"Gender='"+pembeli.getGender()+"', "
                                    +"alamat_07047='"+pembeli.getAlamat()+"' "+" WHERE ID_PEMBELI="+pembeli.getId_pembeli());
    }
    
    
    
    public ArrayList<datapembeli> getDataPembeli() {
        try {
            this.arrpembeli.clear();
            ResultSet rs = this.koneksi.GetData("SELECT * FROM PEMBELI_07047 ORDER BY ID_PEMBELI ASC");
            while (rs.next()) {
                datapembeli pembeli = new datapembeli();
                pembeli.setId_pembeli(rs.getInt("ID_PEMBELI"));
                pembeli.setNama_pembeli(rs.getString("NAMA_PEMBELI"));
                pembeli.setGender(rs.getString("GENDER"));
                pembeli.setAlamat(rs.getString("ALAMAT_07047"));
                
                
                this.arrpembeli.add(pembeli);
            }
            
        } catch (SQLException ex) {
            System.out.print(ex);
        }
       return this.arrpembeli;
    }
    
    
}