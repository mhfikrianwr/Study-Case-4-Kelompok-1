public class CannotBorrow extends RuntimeException{
    public CannotBorrow(String judul){
        super("Buku dengan judul " + judul + " tidak dapat dipinjam!!! Buku ini sudah dipinjam!!!");
    }
}
