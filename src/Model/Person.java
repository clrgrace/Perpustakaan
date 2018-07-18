package Model;

import java.util.Calendar;

/**
 *
 * @author JC Krisna
 */
public abstract class Person {
    
    protected String nama;
    protected String jenisKelamin;
    protected Calendar tglLahir;
    protected String alamat;
    protected int noTelepon;
    protected String email;
    protected Calendar tglGabung; // jadi anggota perpustakaan / petugas perpustakaan
    
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

    public Calendar getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Calendar tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(int noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Calendar getTglGabung() {
        return tglGabung;
    }

    public void setTglGabung(Calendar tglGabung) {
        this.tglGabung = tglGabung;
    }
    
}
