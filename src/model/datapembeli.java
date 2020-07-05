
package model;


public class datapembeli {
    private Integer id_pembeli;
    private String nama_pembeli;
    private String Gender;
    private String alamat;

    public Integer getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(Integer id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String jenis_kelamin) {
        this.Gender = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

  

}
