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
    }
    
     public Tamu(String id, String name, String jk, String born, String address, String phone, String email, String join){
        this();
        this.idKTP = id;
        super.nama = name;
        super.jenisKelamin = jk;
        super.tglLahir = born;
        super.alamat = address;
        super.noTelepon = phone;
        super.email = email;
        super.tglGabung = join;
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
