import java.util.Calendar;

/**
 *
 * @author JC Krisna
 */
public class Transaksi implements Peminjaman{
    
    private String statusPeminjam; // Cek status peminjam
    private Calendar tglPeminjaman;
    private Calendar tglPengembalian;
    
    public Transaksi(){
        
    }
    
    public Calendar getTglPeminjaman() {
        return tglPeminjaman;
    }

    public void setTglPeminjaman(Calendar tglPeminjaman) {
        this.tglPeminjaman = tglPeminjaman;
    }

    public Calendar getTglPengembalian() {
        return tglPengembalian;
    }

    public void setTglPengembalian(Calendar tglPengembalian) {
        this.tglPengembalian = tglPengembalian;
    }
    
    public String getStatusPeminjam() {
        return statusPeminjam;
    }

    public void setStatusPeminjam(String statusPeminjam) {
        this.statusPeminjam = statusPeminjam;
    }
    
    @Override
    public int lamaPinjam(String statusPeminjam) { // parameter statusPeminjam, nanti pake if..else.. untuk durasi peminjaman
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tarifDenda(String statusPeminjam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void hitungDenda(){ 
        // method hitung denda
        // tglPengembalian - tglPeminjaman
        // jika lebih dari lamaPinjam , maka bayar denda
    }
    
    public static void main(String[] args) {
        
    }
}
