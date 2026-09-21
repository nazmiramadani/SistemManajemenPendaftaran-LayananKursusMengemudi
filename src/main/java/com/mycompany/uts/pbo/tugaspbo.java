package com.mycompany.uts.pbo; 

import model.Service;
import java.util.Scanner;

public class tugaspbo {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Service service = new Service(scanner);

        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n=== Sistem Manajemen Pendaftaran & Layanan Kursus Mengemudi ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");  
            System.out.println("3. Hapus Data");
            System.out.println("4. Update Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1 -> service.tambahSiswa();
                case 2 -> service.tampilkanSiswa();
                case 3 -> service.hapusSiswa();
                case 4 -> service.updateSiswa();
                case 5 -> berjalan = false;
                default -> System.out.println("Pilihan tidak valid");
            }
        }
        
        System.out.println("Terima kasih telah menggunakan aplikasi saya");
        scanner.close();
    }
}