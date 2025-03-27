public class AnggotaTidakDitemukanException extends RuntimeException{
    public AnggotaTidakDitemukanException(String idAnggota){
        super("Anggota dengan id " + idAnggota + " tidak ditemukan");
    }
}
