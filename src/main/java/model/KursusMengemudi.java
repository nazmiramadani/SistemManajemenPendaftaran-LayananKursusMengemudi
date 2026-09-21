package model;

public class KursusMengemudi {
    private final int idPendaftaran; 
    protected String namaSiswa;
    protected String noTelepon;
    protected int jumlahPertemuan;

    public KursusMengemudi(int idPendaftaran, String namaSiswa, String noTelepon, int jumlahPertemuan) {
        this.idPendaftaran = idPendaftaran;
        setNamaSiswa(namaSiswa);
        setNoTelepon(noTelepon);
        setJumlahPertemuan(jumlahPertemuan);
    }

    public int getIdPendaftaran() {
        return idPendaftaran;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public int getJumlahPertemuan() {
        return jumlahPertemuan;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void setJumlahPertemuan(int jumlahPertemuan) {
        this.jumlahPertemuan = jumlahPertemuan;
    }


    public void tampilkanInfo() {
        System.out.println("ID Pendaftaran       : " + idPendaftaran);
        System.out.println("Nama Siswa           : " + namaSiswa);
        System.out.println("No Telepon           : " + noTelepon);
        System.out.println("Jumlah Pertemuan     : " + jumlahPertemuan + " kali");
    }

    public final void cetakStatusDaftar() {
        System.out.println("Status Pendaftaran: Terdaftar Resmi di Aplikasi");
    }
}