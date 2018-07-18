package Model;

import java.util.Calendar;

/**
 *
 * @author JC Krisna
 */
public class Tamu extends Person{
    
    private String idKTP;
    private String status;
    
    public Tamu(){ // Constructors
        status = "Tamu";
        super.tglGabung = Calendar.DATE;
    }
    
     public Tamu(String id, String name, String jk, String born, String address, String phone, String email){
        this();
        this.idKTP = id;
        super.nama = name;
        super.jenisKelamin = jk;
        super.tglLahir = born;
        super.alamat = address;
        super.noTelepon = phone;
        super.email = email;
    }
    
    public String getIdKTP() {
        return idKTP;
    }

    public void setIdKTP(String idKTP) {
        this.idKTP = idKTP;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
