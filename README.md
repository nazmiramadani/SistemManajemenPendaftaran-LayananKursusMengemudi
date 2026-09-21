# Sistem Manajemen Pendaftaran & Layanan Kursus Mengemudi
## Nama : Nazmi Ramadani
## NIM  : 2509116031
## Penjelasan Studi Kasus

Aplikasi ini adalah program berbasis **Java console** yang digunakan untuk mengelola data pendaftaran siswa pada sebuah tempat kursus mengemudi. Kursus yang ditawarkan terbagi menjadi dua jenis, yaitu **Kursus Mobil Manual** dan **Kursus Mobil Matic**, yang masing-masing memiliki tarif per pertemuan dan opsi biaya sertifikat SIM yang berbeda.

Melalui aplikasi ini, pengguna (admin/petugas kursus) dapat melakukan operasi CRUD sederhana terhadap data siswa, yaitu:

1. **Tambah Data** -> mendaftarkan siswa baru beserta memilih tipe kursus (Manual/Matic) dan apakah siswa membutuhkan sertifikat SIM.
2. **Tampilkan Data** -> menampilkan seluruh data siswa yang terdaftar beserta rincian biaya kursus.
3. **Hapus Data** -> menghapus data siswa berdasarkan ID Pendaftaran.
4. **Update Data** -> memperbarui nama siswa dan jumlah pertemuan berdasarkan ID Pendaftaran.
5. **Keluar** -> mengakhiri program.

Program dijalankan melalui menu interaktif pada class `TugasPBO` (main program), yang berkomunikasi dengan class `Service` untuk memproses seluruh logika bisnis, sementara data siswa disimpan dalam struktur `ArrayList<KursusMengemudi>`.

Setiap tipe kursus memiliki tarif dasar yang berbeda:
- **Kursus Manual**: Rp 230.000 per pertemuan, biaya sertifikat Rp 300.000 (jika diambil)
- **Kursus Matic**: Rp 160.000 per pertemuan, biaya sertifikat Rp 300.000 (jika diambil)


---

## Penjelasan Hierarki Class

Struktur class pada aplikasi ini disusun dengan pendekatan **Object-Oriented Programming (OOP)**, khususnya menerapkan konsep **inheritance (pewarisan)** antar class model. Berikut hierarkinya:

```
                    KursusMengemudi
                     (superclass)
                          |
          ----------------------------------
          |                                |
    KursusManual                     KursusMatic
    (subclass)                       (subclass)
```

**1. `KursusMengemudi` (Superclass / Parent Class)**
Merupakan class dasar yang menyimpan atribut dan perilaku umum yang dimiliki oleh semua jenis kursus, yaitu:
- `idPendaftaran` (final, tidak bisa diubah setelah objek dibuat)
- `namaSiswa`, `noTelepon`, `jumlahPertemuan` (bersifat `protected` agar bisa diakses langsung oleh subclass)
- Method `tampilkanInfo()` untuk mencetak data dasar siswa
- Method `cetakStatusDaftar()` yang bersifat `final` sehingga tidak dapat di-override oleh subclass manapun

**2. `KursusManual` (Subclass)**
Mewarisi seluruh atribut dan method dari `KursusMengemudi`, kemudian menambahkan atribut khusus:
- `tarifPerPertemuan`, `butuhSertifikat`, `biayaSertifikat`
- Meng-override method `tampilkanInfo()` untuk menampilkan informasi tambahan khusus kursus manual beserta perhitungan total biaya.

**3. `KursusMatic` (Subclass)**
Memiliki struktur yang serupa dengan `KursusManual`, mewarisi dari `KursusMengemudi` dengan atribut tambahan yang sama (`tarifPerPertemuan`, `butuhSertifikat`, `biayaSertifikat`), namun dengan tarif dasar yang berbeda dan label tipe kursus "Mobil Matic".

**4. `Service` (Class Pengelola/Controller)**
Bukan bagian dari hierarki pewarisan, melainkan class yang berperan sebagai pengelola data. Class ini menyimpan seluruh objek `KursusMengemudi` (baik `KursusManual` maupun `KursusMatic`) dalam satu `ArrayList<KursusMengemudi>`, memanfaatkan konsep **polimorfisme** karena satu tipe referensi (`KursusMengemudi`) dapat menampung objek dari berbagai subclass.

**5. `TugasPBO` (Main Class)**
Berisi method `main()` sebagai titik masuk program, menampilkan menu, dan memanggil method-method pada `Service` sesuai pilihan pengguna.

---

## Penjelasan Bagian Kode Yang Menggunakan Inheritance

### 1. Deklarasi pewarisan dengan kata kunci `extends`

```java
public class KursusManual extends KursusMengemudi { ... }
public class KursusMatic extends KursusMengemudi { ... }
```

Baris ini menyatakan bahwa `KursusManual` dan `KursusMatic` merupakan turunan (subclass) dari `KursusMengemudi` (superclass), sehingga keduanya otomatis mewarisi seluruh atribut `protected`/`public` dan method non-`private` dari `KursusMengemudi`, seperti `namaSiswa`, `noTelepon`, `jumlahPertemuan`, `getIdPendaftaran()`, `setNamaSiswa()`, `setJumlahPertemuan()`, dan `cetakStatusDaftar()`.

### 2. Pemanggilan constructor induk dengan `super(...)`

```java
public KursusManual(int idPendaftaran, String namaSiswa, String noTelepon, int jumlahPertemuan,
                     double tarifPerPertemuan, boolean butuhSertifikat, double biayaSertifikat) {
    super(idPendaftaran, namaSiswa, noTelepon, jumlahPertemuan);
    this.butuhSertifikat = butuhSertifikat;
    this.biayaSertifikat = biayaSertifikat;
    this.tarifPerPertemuan = tarifPerPertemuan;
}
```

Baris `super(idPendaftaran, namaSiswa, noTelepon, jumlahPertemuan)` memanggil constructor milik `KursusMengemudi` untuk menginisialisasi atribut-atribut umum terlebih dahulu, sebelum constructor subclass menginisialisasi atribut tambahan miliknya sendiri (`tarifPerPertemuan`, `butuhSertifikat`, `biayaSertifikat`). Pola yang sama juga diterapkan pada constructor `KursusMatic`.

### 3. Method overriding dengan `@Override` dan pemanggilan `super.method()`

```java
@Override
public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.println("Tipe Kursus          : Mobil Manual");
    System.out.println("Tarif Per Pertemuan  : Rp " + tarifPerPertemuan);
    ...
}
```

Method `tampilkanInfo()` di-*override* baik pada `KursusManual` maupun `KursusMatic` untuk menampilkan informasi tambahan yang spesifik pada masing-masing tipe kursus. Pemanggilan `super.tampilkanInfo()` di baris pertama memastikan informasi dasar dari superclass (ID, nama siswa, no. telepon, jumlah pertemuan) tetap ditampilkan sebelum informasi tambahan dari subclass dicetak — ini adalah pola umum *extend behavior* pada inheritance, bukan menggantikannya sepenuhnya.

### 4. Method `final` yang tidak dapat di-override

```java
public final void cetakStatusDaftar() {
    System.out.println("Status Pendaftaran: Terdaftar Resmi di Aplikasi");
}
```

Kata kunci `final` pada method ini mencegah subclass manapun (`KursusManual` maupun `KursusMatic`) meng-override perilakunya, sehingga status pendaftaran akan selalu konsisten di seluruh jenis kursus.

### 5. Polimorfisme melalui referensi superclass

```java
private ArrayList<KursusMengemudi> daftarSiswa;
...
KursusMengemudi siswa = daftarSiswa.get(i);
siswa.tampilkanInfo();
```

Pada class `Service`, seluruh objek disimpan menggunakan tipe referensi superclass `KursusMengemudi`, meskipun objek yang sebenarnya dibuat adalah `KursusManual` atau `KursusMatic`. Ketika `siswa.tampilkanInfo()` dipanggil, Java secara otomatis menjalankan versi method yang sesuai dengan tipe objek aslinya (dynamic method dispatch) inilah wujud nyata **polimorfisme** yang dimungkinkan oleh inheritance.

## 1. Tampilan Awal

<img width="739" height="198" alt="Screenshot 2026-09-21 102709" src="https://github.com/user-attachments/assets/6c6c1c32-5efc-4db3-9721-8f2b94c4edf3" />

## 2. Menu Tambah Data

<img width="649" height="279" alt="Screenshot 2026-09-21 102745" src="https://github.com/user-attachments/assets/8ca72ce5-11ea-49fd-987b-45773ad3cc93" />

## 3. Menu Lihat Data

<img width="799" height="496" alt="Screenshot 2026-09-21 102827" src="https://github.com/user-attachments/assets/f5b2337e-ca9b-4d1d-bd3a-18faead6aa32" />

## 4. Menu Hapus Data

<img width="637" height="189" alt="Screenshot 2026-09-21 102848" src="https://github.com/user-attachments/assets/aa42bbf1-35de-4080-9954-97b3afea8d0c" />

## 5. Menu Update Data

<img width="572" height="209" alt="Screenshot 2026-09-21 102908" src="https://github.com/user-attachments/assets/e6624a1b-635e-47bf-8baa-b04e06541e27" />

## 6. Menu Keluar

<img width="737" height="268" alt="Screenshot 2026-09-21 103546" src="https://github.com/user-attachments/assets/e735de84-7b70-4dcf-ae9a-48a0f2fc79af" />
