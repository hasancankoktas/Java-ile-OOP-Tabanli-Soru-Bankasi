import java.io.*;

// sadece bir soru üzerinde duruluyor burada 
public class Soru implements Serializable, Comparable<Soru> {
    String soru;
    int zorluk;
    int puan;

    public Soru() {
    }

    public Soru(String soru, String[] cevaplar, char dogruCevap, int zorluk, int puan) {
        this.soru = soru;
        this.zorluk = zorluk;
        this.puan = puan;
    }

    @Override
    public int compareTo(Soru au) {
        return this.puan - au.puan;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public int getZorluk() {
        return zorluk;
    }

    public void setZorluk(int zorluk) {
        this.zorluk = zorluk;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    /** Soruyu ekrana yaz. */
    public void soruYaz() {
        System.out.println("Puan (" + getPuan() + ")");
        System.out.println(getSoru());

    }

    /** Soruyu ekrandan oku. */
    public void soruOku() {
        System.out.print("soru: ");
        String soru = Main.input.nextLine().trim();
        setSoru(soru);

        System.out.print("zorluk (1/2/3): ");
        int zorluk = Integer.parseInt(Main.input.nextLine());
        setZorluk(zorluk);

        System.out.print("puan: ");
        int puan = Integer.parseInt(Main.input.nextLine());
        setPuan(puan);
    }

    /** Soruyu sor. */
    public int soruSor() {
        return 0;
    }
}
