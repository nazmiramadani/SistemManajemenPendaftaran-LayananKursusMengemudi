package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    private ArrayList<KursusMengemudi> daftarSiswa;
    private Scanner scanner;
    
    public Service(Scanner scanner){
        this.daftarSiswa = new ArrayList<>();
        this.scanner = scanner;
    }
    
    public void tambahSiswa(){
        System.out.print("ID Pendaftaran: "); 
        int id = scanner.nextInt(); 
        scanner.nextLine(); 

        System.out.print("Nama Siswa: "); 
        String nama = scanner.nextLine();

        System.out.print("No Telepon: "); 
        String telp = scanner.nextLine();

        System.out.print("Jumlah Pertemuan: "); 
        int pertemuan = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Pilih Tipe Kursus (1. Manual, 2. Matic): ");
        int tipe = scanner.nextInt();
        scanner.nextLine();

        if (tipe == 1) {
            System.out.print("Butuh Sertifikat SIM? (y/n): ");
            boolean butuhSertifikat = scanner.nextLine().equalsIgnoreCase("y");
            
            KursusManual siswaBaru = new KursusManual(id, nama, telp, pertemuan, 230000, butuhSertifikat, 300000);
            daftarSiswa.add(siswaBaru);
            System.out.println("Data Kursus Manual berhasil ditambahkan");
            
        } else if (tipe == 2) {
            System.out.print("Butuh Sertifikat SIM? (y/n): ");
            boolean butuhSertifikat = scanner.nextLine().equalsIgnoreCase("y");
            
            KursusMatic siswaBaru = new KursusMatic(id, nama, telp, pertemuan, 160000, butuhSertifikat, 300000);
            daftarSiswa.add(siswaBaru);
            System.out.println("Data Kursus Matic berhasil ditambahkan");
            
        } else {
            System.out.println("Tipe kursus tidak valid");
        }
    }
    
    public void tampilkanSiswa(){
        for (int i = 0; i < daftarSiswa.size(); i++) {
            KursusMengemudi siswa = daftarSiswa.get(i);
            siswa.tampilkanInfo(); 
        }
    }
    
    public void hapusSiswa(){
        System.out.print("Masukkan ID Pendaftaran: ");
        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < daftarSiswa.size(); i++){
            if(daftarSiswa.get(i).getIdPendaftaran() == idTarget){    
                daftarSiswa.remove(i);
                System.out.println("Data berhasil dihapus");
                break;
            }
        }
    }
    
    public void updateSiswa(){
        System.out.print("Masukkan ID Pendaftaran: ");
        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for (KursusMengemudi siswa : daftarSiswa){
            if(siswa.getIdPendaftaran() == idTarget){
                System.out.print("Nama Baru: ");
                String namaBaru = scanner.nextLine(); 
                siswa.setNamaSiswa(namaBaru);
                
                System.out.print("Jumlah Pertemuan Baru: ");
                int pertemuanBaru = scanner.nextInt(); 
                scanner.nextLine();
                siswa.setJumlahPertemuan(pertemuanBaru);
                
                System.out.println("Data berhasil diperbarui");
                return;
            }
        }
        System.out.println("Data tidak ditemukan");
    }
}