public class AnggotaTidakDitemukanException extends RuntimeException{
    public AnggotaTidakDitemukanException(String idAnggota){
        super("ERROR EXCEPTION : Anggota dengan id " + idAnggota + " tidak ditemukan");
    }
}
