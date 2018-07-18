package Model;
/**
 *
 * @author JC Krisna
 */
public class Dosen extends Person{

    private String idDosen;
    private String status;
    
    public Dosen(){ // Constructors
        status = "Dosen";
    }
    public String getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(String idDosen) {
        this.idDosen = idDosen;
    }
    
    
}
