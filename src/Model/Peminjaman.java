/**
 *
 * @author JC Krisna
 */
public interface Peminjaman {
    
    public int lamaPinjam(String statusPeminjam); // ditentukan oleh sistem, berdasarkan status (mahasiswa/dosen/tamu)
    public int tarifDenda(String statusPeminjam); // ditentukan oleh sistem, berdasarkan status (mahasiswa/dosen/tamu)
    
}
