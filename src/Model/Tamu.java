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
    
    public String getIdKTP() {
        return idKTP;
    }

    public void setIdKTP(String idKTP) {
        this.idKTP = idKTP;
    }
    
}
