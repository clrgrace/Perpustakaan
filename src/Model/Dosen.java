package Model;

import java.util.Calendar;

/**
 *
 * @author JC Krisna
 */
public class Dosen extends Person{

    private String idDosen;
    private String status;
    
    public Dosen(){ // Constructors
        status = "Dosen";
        super.tglGabung = Calendar.DATE;
    }
    
    public Dosen(String id, String name, String jk, String born, String address, String phone, String email){
        this();
        this.idDosen = id;
        super.nama = name;
        super.jenisKelamin = jk;
        super.tglLahir = born;
        super.alamat = address;
        super.noTelepon = phone;
        super.email = email;
    }
    
    public String getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(String idDosen) {
        this.idDosen = idDosen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
