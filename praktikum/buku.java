package praktikum;
import java.util.*;

class buku {
    private String judul;
    private List<String> penulis;
    private String kategori;
    private String sinopsis;
    private int tahunTerbit;
    private int hargaBuku;

    public buku(String judul, List<String> penulis, String kategori, String sinopsis, int tahunTerbit, int hargaBuku) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.tahunTerbit = tahunTerbit;
        this.sinopsis = sinopsis;
        this.hargaBuku = hargaBuku;
    }

    public int panjangSinopsis(){
        return sinopsis.isEmpty() ? 0 : sinopsis.split("\\s+").length;
    }

    public String getJudul() {
        return judul;
    }
    
    public double cekKesamaan(buku other) {
        int totalAtribut = 5;
        int persentasePlagiat = 0;
    
        if (this.judul.equalsIgnoreCase(other.judul)) {
            persentasePlagiat++;
        }
        if (this.penulis.equals(other.penulis)) {
            persentasePlagiat++;
        }
        if (this.kategori.equalsIgnoreCase(other.kategori)) {
            persentasePlagiat++;
        }
        if (this.sinopsis.equalsIgnoreCase(other.sinopsis)) {
            persentasePlagiat++;
        }
        if (this.tahunTerbit == other.tahunTerbit) {
            persentasePlagiat++;
        }
    
        return (persentasePlagiat / (double) totalAtribut) * 100;
    }
    //saya udh tau cara kerja method copy ini kak, tapi sudah terlanjur 😔
    public buku copy(){
        return new buku(this.judul, this.penulis, this.kategori, this.sinopsis, this.tahunTerbit, this.hargaBuku);
    }

    //ini adalah method overloading yang digunakan untuk menghitung royalti secara default, dalam kasus ini saya nge-set 15%.
    //Method ini memiliki paramter variable hargaBuku di atas. Berhubung saya sudah set harga di setiap bukunya, maka tidak perlu untuk set harga buku secara manual
    public double hitungRoyalti (int hargaBuku){
        return hargaBuku * 0.15;
    }

    //ini adalah method overloading yang digunakan apabila kita ingin set royalti secara custom. Di kasus ini saya nge-set 20%
    //Method ini memiliki dua parameter, yakni variable hargaBuku dan persenRoyalti. 
    //persenRoyalti adalah parameter yang berfungsi buat nge-set berapa persen royalti yg kita inginkan. 
    public double hitungRoyalti (int hargaBuku, double persenRoyalti){
        return hargaBuku * (persenRoyalti / 100);
    }
    
    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + String.join(", ", penulis));
        System.out.println("Kategori: " + kategori);
        System.out.println("Tahun terbit: " + tahunTerbit);
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Jumlah kata sinopsis: " + panjangSinopsis());
        System.out.println("Royalti normal: " + hitungRoyalti(hargaBuku)); //kode di samping adalah cara untuk menampilkan royalti secara otomatis dengan nilai royalti default
        System.out.println("Royalti custom: " + hitungRoyalti(hargaBuku, 20)); //kode di samping adalah cara untuk menampilkan royalti secara otomatis dengan nilai persen royalti yang diubah

        System.out.println("-----------------------------");
    }
}