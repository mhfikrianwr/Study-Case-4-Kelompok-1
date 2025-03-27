public class BukuTidakDipinjamException extends RuntimeException {
    public BukuTidakDipinjamException(String judulBuku) {
        super("ERROR EXCEPTION : Buku dengan judul '" + judulBuku + "' tidak dipinjam oleh anggota ini.");
    }
}
