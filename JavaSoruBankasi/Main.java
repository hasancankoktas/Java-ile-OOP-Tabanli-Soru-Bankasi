
import java.util.*;

public class Main {

    static enum Secenek {
        YAPILMADI, SORU_EKLE, SORU_SIL, SORU_LISTELE, SINAV_OLUSTUR, SINAV_YAP, CIKIS
    }

    static String soruDosyasi = "sorularim.dat";
    static String sinavDosyasi = "sinavlarim.dat";

    static Scanner input = new Scanner(System.in);
    static SoruBankasi soruBankasi = new SoruBankasi();
    static SinavBankasi sinavBankasi = new SinavBankasi();

    // main fonk.
    public static void main(String[] args) {
        soruBankasi.dosyadanOku(soruDosyasi);
        sinavBankasi.dosyadanOku(sinavDosyasi);
        Secenek secim = Secenek.YAPILMADI;
        do {
            ekranaSecimleriListele();
            secim = secimAl();
            secimiCalistir(secim);
            soruBankasi.dosyayaYaz(soruDosyasi);
            sinavBankasi.dosyayaYaz(sinavDosyasi);
        } while (secim != Secenek.CIKIS);
    }

    // seçimleri ekrana yazar
    private static void ekranaSecimleriListele() {
        System.out.println("+-----------------------+");
        System.out.println("| 1. Soru Ekle          |");
        System.out.println("| 2. Soru Sil           |");
        System.out.println("| 3. Sorulari Listele   |");
        System.out.println("| 4. Sinav olustur      |");
        System.out.println("| 5. Sinav yap          |");
        System.out.println("| 6. Cikis              |");
        System.out.println("+-----------------------+");
        System.out.print("* Seciminiz: ");
    }

    // seçenekleri değişkenler atar
    private static Secenek secimAl() {
        Secenek secilen = Secenek.YAPILMADI;
        int secim = Integer.parseInt(input.nextLine());
        switch (secim) {
            case 1:
                secilen = Secenek.SORU_EKLE;
                break;
            case 2:
                secilen = Secenek.SORU_SIL;
                break;
            case 3:
                secilen = Secenek.SORU_LISTELE;
                break;
            case 4:
                secilen = Secenek.SINAV_OLUSTUR;
                break;
            case 5:
                secilen = Secenek.SINAV_YAP;
                break;
            case 6:
                secilen = Secenek.CIKIS;
                break;
            default:
                break;
        }
        return secilen;
    }

    // listenelen seçimleri çalıştırır
    private static void secimiCalistir(Secenek secim) {
        switch (secim) {
            case SORU_EKLE:
                soruBankasi.soruEkle();
                break;
            case SORU_SIL:
                soruBankasi.soruSil();
                break;
            case SORU_LISTELE:
                soruBankasi.listeListeleme();
                break;
            case SINAV_OLUSTUR:
                sinavBankasi.sinavOlustur(soruBankasi);
                break;
            case SINAV_YAP:
                sinavBankasi.sinavYap();
                break;
            default:
                break;
        }
    }
}