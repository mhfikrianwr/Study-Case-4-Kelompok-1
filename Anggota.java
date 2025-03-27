import java.util.ArrayList;
import java.util.List;

public class Anggota {
    public String nama;
    public String idAnggota;
    public List<Buku> daftarBukuDipinjam;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
        this.daftarBukuDipinjam = new ArrayList<>();
    }

    public Anggota() {
        this.daftarBukuDipinjam = new ArrayList<>();
    }

    public void pinjamBuku(Buku buku) throws BukuTidakTersediaException {
        buku.pinjamBuku(nama);
        daftarBukuDipinjam.add(buku);
    }

    public void kembaliBuku(Buku buku) throws BukuTidakDipinjamException {
        if (!daftarBukuDipinjam.contains(buku)) {
            throw new BukuTidakDipinjamException("Buku '" + buku.judul + "' tidak dipinjam oleh anggota ini.");
        }
        buku.kembaliBuku();
        daftarBukuDipinjam.remove(buku);
    }
}
