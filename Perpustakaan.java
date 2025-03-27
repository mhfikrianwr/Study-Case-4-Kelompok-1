import java.util.*;
public class Perpustakaan{
    ArrayList<Buku> daftarBuku = new ArrayList<>();
    HashMap<String, Anggota> daftarAnggota = new HashMap<>();
    public void tambahBuku(Buku buku){
        daftarBuku.add(buku);
        System.out.println("Buku Berhasil ditambahkan !!!");
    }
    public void tambahAnggota(Anggota anggota){
        daftarAnggota.put(anggota.idAnggota,anggota);
        System.out.println("Anggota Berhasil ditambahkan");
    }
    public void pinjamBuku(String idAnggota, String judul){
        Anggota anggota = daftarAnggota.get(idAnggota);
        Buku buku = daftarBuku.get(0);
        boolean foundAnggota = false;
        for(String i : daftarAnggota.keySet()){
            if(i.equalsIgnoreCase(idAnggota)){
                anggota = daftarAnggota.get(i);
                foundAnggota = true;
            }
        }
        if(!foundAnggota) throw new AnggotaTidakDitemukanException("Anggota tidak ditemukan !!! idAnggota tidak valid, tidak dapat meminjam buku");
        else{
            boolean foundBuku = false;
             for(Buku a : daftarBuku){
                if(a.judul.equalsIgnoreCase(judul)){
                    buku = a;
                    foundBuku = true;
                    break;
                }
            }
            if(!foundBuku) throw new BukuTidakTersediaException(judul);
            else{
                anggota.daftarBukuDipinjam.add(buku);
                buku.tersedia = true;
            }
        }
    
    }
    public void kembaliBuku(String idAnggota, String judul){
        Anggota anggota = daftarAnggota.get(idAnggota);
        Buku buku = daftarBuku.get(0);
        boolean foundAnggota = false;
        for(String i : daftarAnggota.keySet()){
            if(i.equalsIgnoreCase(idAnggota)){
                anggota = daftarAnggota.get(i);
                foundAnggota = true;
            }
        }
        if(!foundAnggota) throw new AnggotaTidakDitemukanException("Anggota tidak ditemukan !!! idAnggota tidak valid, tidak dapat mengembalikan buku");
        else{
            if(!anggota.daftarBukuDipinjam.contains(buku)){
                throw new BukuTidakDipinjamException(buku.judul);
            }else{
                System.out.println("Buku " + buku.judul + " berhasil dikembalikan!!!");
                anggota.daftarBukuDipinjam.remove(buku);
                buku.tersedia = true;
            }
        }
    
    }
    public void searchBuku(String title){  
        boolean boolFound = false;
        for(Buku buku : daftarBuku){
            if(buku.judul.equalsIgnoreCase(title)){
                boolFound = true;
            }
        }
        if(!boolFound) throw new BookDoesntExist(title);
    }
}