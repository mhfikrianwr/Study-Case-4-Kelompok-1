public class BookDoesntExist extends RuntimeException{
    public BookDoesntExist(String judul){
        super("Buku dengan judul " + judul + " tidak ditemukan!!!");
    }
}