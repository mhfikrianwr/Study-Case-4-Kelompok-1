public class Main {
    public static void main(String[] args){
        //Membuat beberapa objek buku
        Perpustakaan perpustakaan = new Perpustakaan();
        Buku buku1 = new Buku("Atomic Habits","James Clear",1998);
        perpustakaan.tambahBuku(buku1);
        Buku buku2 = new Buku("Money","Morgan",2004);
        perpustakaan.tambahBuku(buku2);
        Buku buku3 = new Buku("Subtle Art","Manson",2005);
        perpustakaan.tambahBuku(buku3);

        //Membuat beberapa object anggota
        Anggota anggota1 = new Anggota("Yazid","1");
        perpustakaan.tambahAnggota(anggota1);
        Anggota anggota2 = new Anggota("anendi","2");
        perpustakaan.tambahAnggota(anggota2);
        Anggota anggota3 = new Anggota("Fikri","3");
        perpustakaan.tambahAnggota(anggota3);

        //Mencoba mencari buku dengan judul yang tersedia dan tidak
        System.out.println("-----------------------");
        perpustakaan.searchBuku("Atomic Habits");
        System.out.println("-----------------------");
        try{
        perpustakaan.searchBuku("Laut bercerita");
        }catch(BookDoesntExist e){
            System.out.println(e.getMessage());
        }
        //Mencoba mencari anggota
        System.out.println("-----------------------");
        perpustakaan.searchAnggota("1");
        System.out.println("-----------------------");
        perpustakaan.searchAnggota("2");
        System.out.println("-----------------------");
        perpustakaan.searchAnggota("3");
        System.out.println("-----------------------");
        try{
        perpustakaan.searchAnggota("4");
        }catch(AnggotaTidakDitemukanException e){
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------");
        perpustakaan.pinjamBuku("1","Atomic Habits");
        System.out.println("-----------------------");
        perpustakaan.pinjamBuku("1","Money");
        System.out.println("-----------------------");
        try{
        perpustakaan.pinjamBuku("4","Atomic Habits");
        }catch(AnggotaTidakDitemukanException e){
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------");
        try{
            perpustakaan.pinjamBuku("3","Atomic Habits");
        }catch(BukuTidakTersediaException e){
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------------");
        perpustakaan.kembaliBuku("1","Atomic Habits");
        System.out.println("-----------------------");
        try{
        perpustakaan.kembaliBuku("1", "Atomic Habits");
        }catch(BukuTidakDipinjamException e){
            System.out.println(e.getMessage());
        }
    }
}
