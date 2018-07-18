package Model;
/**
 *
 * @author JC Krisna
 */
public class BukuNonFiksi extends Buku{ 
    
    private String jenisNonFiksi; // Pelajaran, Jurnal, Biografi, dll

    public String getJenisNonFiksi() {
        return jenisNonFiksi;
    }

    public void setJenisNonFiksi(String jenisNonFiksi) {
        this.jenisNonFiksi = jenisNonFiksi;
    }
    
}
