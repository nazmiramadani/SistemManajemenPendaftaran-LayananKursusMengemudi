package model;

public class KursusManual extends KursusMengemudi {
    private boolean butuhSertifikat;
    private double biayaSertifikat;
    private double tarifPerPertemuan;

    public KursusManual(int idPendaftaran, String namaSiswa, String noTelepon, int jumlahPertemuan, double tarifPerPertemuan, boolean butuhSertifikat, double biayaSertifikat) {
        super(idPendaftaran, namaSiswa, noTelepon, jumlahPertemuan);
        this.butuhSertifikat = butuhSertifikat;
        this.biayaSertifikat = biayaSertifikat;
        this.tarifPerPertemuan = tarifPerPertemuan;
    }

    public boolean isButuhSertifikat() {
        return butuhSertifikat;
    }

    public double getBiayaSertifikat() {
        return biayaSertifikat;
    }

    public double getTarifPerPertemuan() {
        return tarifPerPertemuan;
    }
    

    public void setButuhSertifikat(boolean butuhSertifikat) {
        this.butuhSertifikat = butuhSertifikat;
    }

    public void setBiayaSertifikat(double biayaSertifikat) {
        this.biayaSertifikat = biayaSertifikat;
    }

    public void setTarifPerPertemuan(double tarifPerPertemuan) {
        this.tarifPerPertemuan = tarifPerPertemuan;
    }
    
    

@Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe Kursus          : Mobil Manual");
        System.out.println("Tarif Per Pertemuan  : Rp " + tarifPerPertemuan );
        System.out.println("Ambil Sertifikat     : " + (butuhSertifikat ? "Ya" : "Tidak"));
        
        double totalBiaya = jumlahPertemuan * tarifPerPertemuan;
        if (butuhSertifikat) {
            System.out.println("Biaya Sertifikat     : Rp " + biayaSertifikat);
            totalBiaya += biayaSertifikat;
        }
        System.out.println("Total Biaya          : Rp " + totalBiaya);
        System.out.println("---------------------------------------------");
    }
}