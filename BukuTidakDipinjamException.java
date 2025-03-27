public class BukuTidakDipinjamException extends RuntimeException {
    public BukuTidakDipinjamException(String judulBuku) {
        super("Buku dengan judul '" + judulBuku + "' tidak dipinjam oleh anggota ini.");
    }
}