public class BukuTidakTersediaException extends RuntimeException {
    public BukuTidakTersediaException(String judulBuku) {
        super("Buku dengan judul '" + judulBuku + "' tidak tersedia untuk dipinjam.");
    }
}