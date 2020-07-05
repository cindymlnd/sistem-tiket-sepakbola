package model;

public class tiket {
    private Integer id_pembayaran;
    private datapembeli pembeli;
    private datatiket tiket;
    private Integer jumlah_tiket;
    private Integer harga_total;

    public Integer getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(Integer id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public datapembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(datapembeli pembeli) {
        this.pembeli = pembeli;
    }

    public datatiket getTiket() {
        return tiket;
    }

    public void setTiket(datatiket tiket) {
        this.tiket = tiket;
    }

    public Integer getJumlah_tiket() {
        return jumlah_tiket;
    }

    public void setJumlah_tiket(Integer jumlah_tiket) {
        this.jumlah_tiket = jumlah_tiket;
    }

    public Integer getHarga_total() {
        return harga_total;
    }

    public void setHarga_total(Integer harga_total) {
        this.harga_total = harga_total;
    }
    
}

