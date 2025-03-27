public class BukuTidakTersediaException extends RuntimeException {
    public BukuTidakTersediaException(String judulBuku) {
        super("ERROR EXCEPTION : Tidak dapat meminjam buku !!! Buku dengan judul '" + judulBuku + "' tidak tersedia untuk dipinjam.");
    }
}
