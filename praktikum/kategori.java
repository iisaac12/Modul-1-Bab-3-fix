package praktikum;
import java.util.ArrayList;
import java.util.List;

class kategori {
    private String nama;
    private List<buku> daftarBuku;

    public kategori(String nama) {
        this.nama = nama;
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(buku buku) {
        daftarBuku.add(buku);
    }

    public void tampilkanPersentaseKesamaan() {
        System.out.println("Persentase Kesamaan Buku dalam Kategori: " + nama);
        System.out.println("---------------------------------------------");
    
        for (int i = 0; i < daftarBuku.size(); i++) {
            for (int j = i + 1; j < daftarBuku.size(); j++) {
                buku buku1 = daftarBuku.get(i);
                buku buku2 = daftarBuku.get(j);
    
                double persentaseKesamaan = buku1.cekKesamaan(buku2);
                System.out.println("Buku 1: " + buku1.getJudul());
                System.out.println("Buku 2: " + buku2.getJudul());
                System.out.println("Persentase Kesamaan: " + persentaseKesamaan + "%");
                System.out.println("---------------------------------------------");
            }
        }
    }
    

    public void tampilkanBuku() {
        System.out.println("Kategori: " + nama);
        for (buku buku : daftarBuku) {
           buku.tampilkanInfo();
        }
    }
}
