package Model;

import java.util.Calendar;

/**
 *
 * @author JC Krisna
 */
public abstract class Person {
    
    protected String nama;
    protected String jenisKelamin;
    protected String tglLahir;
    protected String alamat;
    protected String noTelepon;
    protected String email;
    protected int tglGabung; // jadi anggota perpustakaan / petugas perpustakaan
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getTglGabung() {
        return tglGabung;
    }

    public void setTglGabung(int tglGabung) {
        this.tglGabung = tglGabung;
    }
    
}
