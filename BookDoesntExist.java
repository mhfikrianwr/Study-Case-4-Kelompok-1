public class BookDoesntExist extends RuntimeException{
    public BookDoesntExist(String judul){
        super("ERROR EXCEPTION : Buku dengan judul " + judul + " tidak ditemukan!!!");
    }
}
