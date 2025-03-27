public class Buku{
    public String judul;
    public String penulis;
    public int tahunTerbit;
    public boolean tersedia;
    public String peminjam;

    public Buku(String judul, String penulis, int tahunTerbit){
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.tersedia = true;
        this.peminjam = null;
    }
    public void pinjamBuku(String peminjam) throws BukuTidakTersediaException {
        if (!this.tersedia) {
            throw new BukuTidakTersediaException(this.judul);
        }
        this.tersedia = false;
        this.peminjam = peminjam;
    }
    public void kembaliBuku() throws BukuTidakDipinjamException {
        if (this.tersedia) {
            throw new BukuTidakDipinjamException(this.judul);
        }
        this.tersedia = true;
        this.peminjam = null;
    }
}