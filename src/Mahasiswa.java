/**
 *
 * @author JC Krisna
 */
public class Mahasiswa extends Person{
    
    private String idMahasiswa;
    private String status;
    
    public Mahasiswa(){ // Constructors
        status = "Mahasiswa";
    }
    
    public String getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(String idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }
    
}
