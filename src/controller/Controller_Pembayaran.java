/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Koneksi;
import model.tiket;
import model.datapembeli;
import model.datatiket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Controller_Pembayaran {

    Koneksi koneksi;
    ArrayList<tiket> arrpembayaran;
    ArrayList<datapembeli> arrpembeli;
    ArrayList<datatiket> arrtiket;
    ArrayList<tiket> arrbayar;

    public Controller_Pembayaran() {
        this.koneksi = new Koneksi();
        this.arrpembayaran = new ArrayList<>();
        this.arrpembeli = new ArrayList<>();
        this.arrtiket = new ArrayList<>();
        this.arrbayar = new ArrayList<>();

    }

    public void insertPembayaran(tiket pembayaran) {

        this.koneksi.ManipulasiData("INSERT INTO PEMBAYARAN VALUES ("
                + "id_pembayaran.NEXTVAL, " + pembayaran.getTiket().getId_tiket() + ", "
                + pembayaran.getPembeli().getId_pembeli() + ", " + pembayaran.getJumlah_tiket()
                + ", " + pembayaran.getHarga_total() + ")");
        System.out.println("INSERT INTO PEMBAYARAN VALUES ("
                + "id_pembayaran.NEXTVAL, " + pembayaran.getTiket().getId_tiket() + ", "
                + pembayaran.getPembeli().getId_pembeli() + ", " + pembayaran.getJumlah_tiket()
                + ", " + pembayaran.getHarga_total() + ")");
    }

    public ArrayList<tiket> getDataPembayaran() throws SQLException {
        this.arrpembayaran.clear();
        ResultSet rs = this.koneksi.GetData("SELECT pembayaran.id_pembayaran as kode_bayar, "
                + "pembayaran.jumlah_tiket as tiket_dibeli, pembayaran.harga_total as total_harga, pembeli_07047.*, jenis_tiket.* "
                + "FROM PEMBAYARAN JOIN PEMBELI_07047 ON PEMBAYARAN.ID_PEMBELI=PEMBELI_07047.ID_PEMBELI "
                + "JOIN JENIS_TIKET ON PEMBAYARAN.ID_JENISTIKET = JENIS_TIKET.ID_JENISTIKET ORDER BY ID_PEMBAYARAN ASC");

        while (rs.next()) {
            tiket pembayaran = new tiket();

            datapembeli pembeli = new datapembeli();
            pembeli.setId_pembeli(rs.getInt("ID_PEMBELI"));
            pembeli.setNama_pembeli(rs.getString("NAMA_PEMBELI"));
            pembeli.setGender(rs.getString("GENDER"));
            pembeli.setAlamat(rs.getString("ALAMAT_07047"));

            datatiket Tiket = new datatiket();
            Tiket.setId_tiket(rs.getInt("ID_JENISTIKET"));
            Tiket.setVarian_tiket(rs.getString("VARIAN_TIKET"));
            Tiket.setTotal_seat(rs.getInt("TOTAL_SEAT"));
            Tiket.setHarga_tiket(rs.getInt("HARGA_"));

            pembayaran.setId_pembayaran(rs.getInt("KODE_BAYAR"));
            pembayaran.setPembeli(pembeli);
            pembayaran.setTiket(Tiket);
            pembayaran.setJumlah_tiket(rs.getInt("TIKET_DIBELI"));
            pembayaran.setHarga_total(rs.getInt("TOTAL_HARGA"));

            this.arrpembayaran.add(pembayaran);
        }
        return this.arrpembayaran;
    }

}
