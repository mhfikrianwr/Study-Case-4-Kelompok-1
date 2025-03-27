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
        if (anggota == null) throw new AnggotaTidakDitemukanException(idAnggota);

        Buku bukuDitemukan = null;
        for (Buku buku : daftarBuku) {
            if (buku.judul.equalsIgnoreCase(judul) && buku.tersedia) {
                bukuDitemukan = buku;
                break;
            }
        }
        if (bukuDitemukan == null) throw new BukuTidakTersediaException(judul);

        anggota.daftarBukuDipinjam.add(bukuDitemukan);
        bukuDitemukan.tersedia = false;
        System.out.println("Anggota '" + anggota.nama + "' berhasil meminjam buku '" + judul + "'!");
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
        if(!foundAnggota) throw new AnggotaTidakDitemukanException(idAnggota);
        else{
            if(!anggota.daftarBukuDipinjam.contains(buku)){
                throw new BukuTidakDipinjamException(buku.judul);
            }else{
                System.out.println(" Anggota dengan id " + idAnggota +" berhasil mengembalikan Buku " + buku.judul + " !!!");
                anggota.daftarBukuDipinjam.remove(buku);
                buku.tersedia = true;
                System.out.println("\n");
            }
        }
    
    }
    public void searchBuku(String title){  
        boolean boolFound = false;
        Buku a = daftarBuku.get(0);
        for(Buku buku : daftarBuku){
            if(buku.judul.equalsIgnoreCase(title)){
                boolFound = true;
                a = buku;
            }
        }
        if(!boolFound) throw new BookDoesntExist(title);
        else{
            System.out.println("Buku dengan judul " + title + " ditemukan");
        }
    }
    public void searchAnggota(String idAnggota){
        if(!daftarAnggota.containsKey(idAnggota)) throw new AnggotaTidakDitemukanException(idAnggota);
        else System.out.println("Anggota dengan id " + idAnggota + " ditemukan !!!");
    }
}
