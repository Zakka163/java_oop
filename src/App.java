import java.util.ArrayList;
import java.util.Scanner;

class Kendaraan {
    private String nama;
    private String warna;
    private String brand;
    private String jenisKendaraan;
    private int harga;
    private int tahun;

    // Constructor untuk inisialisasi brand, model, dan year
    public Kendaraan(String nama, String warna, String brand, String jenisKendaraan, int harga, int tahun) {
        this.nama = nama;
        this.warna = warna;
        this.brand = brand;
        this.harga = harga;
        this.tahun = tahun;
        this.jenisKendaraan = jenisKendaraan;
    }

    // Getter untuk mengambil properti class
    public String getNama() {
        return nama;
    }

    public String getWarna() {
        return warna;
    }

    public String getBrand() {
        return brand;
    }

    public int getHarga() {
        return harga;
    }

    public int getTahun() {
        return tahun;
    }

    public String getJenisKendaaran() {
        return jenisKendaraan;
    }

    // Setter untuk mengubah properti class
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setJenisKendaaran(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    // Method untuk menampilkan informasi kendaraan
    public void view() {
        System.out.println();
        System.out.println("Nama: " + nama);
        System.out.println("Warna: " + warna);
        System.out.println("Brand: " + brand);
        System.out.println("Harga: " + harga);
        System.out.println("Tahun: " + tahun);
        System.out.println("Jenis kendaraan : " + jenisKendaraan);
    }

}

class Mobil extends Kendaraan {
    private int jumlahPintu;

    public Mobil(String nama, String warna, String brand, int harga, int tahun, int jumlahPintu) {
        super(nama, warna, brand, "Mobil", harga, tahun);
        this.jumlahPintu = jumlahPintu;
    }

    
    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    // Override method view untuk menampilkan informasi mobil
    @Override
    public void view() {
        super.view();
        System.out.println("Jumlah pintu: " + jumlahPintu);
    }
}

class Motor extends Kendaraan {
    public Motor(String nama, String warna, String brand, int harga, int tahun) {
        super(nama, warna, brand, "Motor", harga, tahun);
    }

    @Override
    public void view() {
        super.view();
    }
}

class Garage {
    private ArrayList<Kendaraan> kendaraanList;

    public Garage() {
        this.kendaraanList = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan kendaraan) {
        kendaraanList.add(kendaraan);
    }

    public boolean getKendaraan(int index) {
        index = index - 1;
        if (index >= 0 && index < kendaraanList.size()) {
            Kendaraan kendaraan = kendaraanList.get(index);
            kendaraan.view();
            return true;
        } else {
            System.out.println("Nomor tidak valid");
            return false;
        }
       

    }

    public void updateKendaraan(int index, Kendaraan kendaraan) {
        index = index - 1;
        if (index >= 0 && index < kendaraanList.size()) {
            kendaraanList.set(index, kendaraan);
        } else {
            System.out.println("Nomor tidak valid");
        }
    }

    public void hapusKendaraan(int index) {
        index = index - 1;
        if (index >= 0 && index < kendaraanList.size()) {
            kendaraanList.remove(index);
        } else {
            System.out.println("Nomor tidak valid");
        }
    }
    

    public void tampilkanKendaraan() {
        int nomor = 1;
        System.out.println("=============================================================================================================");
        System.out.printf("%-5s %-10s %-15s %-10s %-10s %-10s %-10s  %-10s \n", "No", "Nama", "Jenis Kendaraan","Warna", "Brand", "Harga", "Tahun", "Jumlah Pintu");
        System.out.println("=============================================================================================================");
        for (Kendaraan kendaraan : kendaraanList) {
            if (kendaraan instanceof Mobil) {
                Mobil mobil = (Mobil) kendaraan;
                System.out.printf("%-5s %-10s %-15s %-10s %-10s %-10s %-10s  %-10s\n", nomor, mobil.getNama(),mobil.getJenisKendaaran(), mobil.getWarna(), mobil.getBrand(), mobil.getHarga(),mobil.getTahun(), mobil.getJumlahPintu());
            } else if (kendaraan instanceof Motor) {
                Motor motor = (Motor) kendaraan;
                System.out.printf("%-5s %-10s %-15s %-10s %-10s %-10s %-10s  %-10s\n", nomor, motor.getNama(),motor.getJenisKendaaran(), motor.getWarna(), motor.getBrand(), motor.getHarga(),motor.getTahun(), "-");
            }
            nomor++;
        }
        System.out.println();
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Garage garage = new Garage();
        garage.tambahKendaraan(new Mobil("E36", "Biru", "Biru", 100000000, 1999, 2));
        garage.tambahKendaraan(new Motor("Beat","Merah","Honda",3000000,2004));
        boolean exit = false;

        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Update Kendaraan");
            System.out.println("3. Hapus Kendaraan");
            System.out.println("4. Tampilkan Kendaraan");
            System.out.println("5. Keluar");
            System.out.println();
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (pilihan) {
                case 1:
                    clearScreen();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Warna: ");
                    String warna = scanner.nextLine();
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Harga: ");
                    int harga = scanner.nextInt();
                    System.out.print("Tahun: ");
                    int tahun = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    System.out.println("Jenis Kendaraan (mobil/motor): ");
                    String jenis = scanner.nextLine();
                    if (jenis.equalsIgnoreCase("mobil")) {
                        System.out.print("Jumlah Pintu: ");
                        int jumlahPintu = scanner.nextInt();
                        garage.tambahKendaraan(new Mobil(nama, warna, brand, harga, tahun, jumlahPintu));
                    } else if (jenis.equalsIgnoreCase("motor")) {
                        garage.tambahKendaraan(new Motor(nama, warna, brand, harga, tahun));
                    }
                    clearScreen();
                    break;
                case 2:
                    clearScreen();
                    garage.tampilkanKendaraan();
                    System.out.print("Nomor yang akan diupdate: ");
                    int indexUpdate = scanner.nextInt();
                    if (!garage.getKendaraan(indexUpdate)) {
                        // clearScreen();
                        break;
                    } 
                    System.out.println();
                    System.out.println("==== Data Baru =====");
                    scanner.nextLine(); 
                    System.out.print("Nama: ");
                    String namaUpdate = scanner.nextLine();
                    System.out.print("Warna: ");
                    String warnaUpdate = scanner.nextLine();
                    System.out.print("Brand: ");
                    String brandUpdate = scanner.nextLine();
                    System.out.print("Harga: ");
                    int hargaUpdate = scanner.nextInt();
                    System.out.print("Tahun: ");
                    int tahunUpdate = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Jenis Kendaraan (mobil/motor): ");
                    String jenisUpdate = scanner.nextLine();
                    if (jenisUpdate.equalsIgnoreCase("mobil")) {
                        System.out.print("Jumlah Pintu: ");
                        int jumlahPintuUpdate = scanner.nextInt();
                        garage.updateKendaraan(indexUpdate, new Mobil(namaUpdate, warnaUpdate, brandUpdate, hargaUpdate,tahunUpdate, jumlahPintuUpdate));
                    } else if (jenisUpdate.equalsIgnoreCase("motor")) {
                        garage.updateKendaraan(indexUpdate,new Motor(namaUpdate, warnaUpdate, brandUpdate, hargaUpdate, tahunUpdate));
                    }
                    clearScreen();
                    break;
                case 3:
                    clearScreen();
                    garage.tampilkanKendaraan();
                    System.out.print("Nomor yang akan dihapus: ");
                    int indexHapus = scanner.nextInt();
                    garage.hapusKendaraan(indexHapus);
                    clearScreen();
                    break;
                case 4:
                    clearScreen();
                    garage.tampilkanKendaraan();
                    break;
                case 5:
                    clearScreen();
                    System.out.println("Terima kasih!");
                    System.exit(0);
                    break;
                default:
                    clearScreen();
                    System.out.println("Pilihan tidak valid!");
            }

        } while (!exit);

        scanner.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}
