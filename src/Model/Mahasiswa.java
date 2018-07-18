package Model;

import java.util.Calendar;

/**
 *
 * @author JC Krisna
 */
public class Mahasiswa extends Person{
    
    private String idMahasiswa;
    private String status;
    
    public Mahasiswa(){ // Constructors
        status = "Mahasiswa";
        super.tglGabung = Calendar.DATE;
    }
    
     public Mahasiswa(String id, String name, String jk, String born, String address, String phone, String email){
        this();
        this.idMahasiswa = id;
        super.nama = name;
        super.jenisKelamin = jk;
        super.tglLahir = born;
        super.alamat = address;
        super.noTelepon = phone;
        super.email = email;
    }
    
    public String getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(String idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
