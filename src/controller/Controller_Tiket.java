package controller;

import database.Koneksi;
import model.datatiket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Controller_Tiket {

    Koneksi koneksi;
    ArrayList<datatiket> arrtiket;

    public Controller_Tiket() {
        this.koneksi = new Koneksi();
        this.arrtiket = new ArrayList<>();
    }

    public void insertTiket(datatiket tiket) {

        this.koneksi.ManipulasiData("INSERT INTO JENIS_TIKET (ID_TIKET, VARIAN_TIKET, TOTAL_SEAT, HARGA_TIKET) "
                + "VALUES (" + tiket.getId_tiket() + ", '" + tiket.getVarian_tiket() + "', '" + tiket.getTotal_seat() + "', '"
                + tiket.getHarga_tiket() + "')");
        System.out.println("INSERT INTO JENIS_TIKET (ID_JENISTIKET, VARIAN_TIKET, TOTAL_SEAT, HARGA_) "
                + "VALUES (" + tiket.getId_tiket() + ", '" + tiket.getVarian_tiket() + "', '" + tiket.getTotal_seat() + "', '"
                + tiket.getHarga_tiket() + "')");

    }

    public ArrayList<datatiket> getDataTiket() throws SQLException {
        this.arrtiket.clear();
        ResultSet r = this.koneksi.GetData("SELECT * FROM JENIS_TIKET ORDER BY ID_JENISTIKET DESC");
        while (r.next()) {
            datatiket Tiket = new datatiket();
            Tiket.setId_tiket(r.getInt("ID_JENISTIKET"));
            Tiket.setVarian_tiket(r.getString("VARIAN_TIKET"));
            Tiket.setTotal_seat(r.getInt("TOTAL_SEAT"));
            Tiket.setHarga_tiket(r.getInt("HARGA_"));

            this.arrtiket.add(Tiket);
        }
        return this.arrtiket;
    }
}
