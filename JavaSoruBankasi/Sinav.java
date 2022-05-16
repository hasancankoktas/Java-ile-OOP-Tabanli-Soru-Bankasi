import java.io.*;
import java.util.*;

public class Sinav implements Serializable {
    String isim;
    ArrayList<Soru> sorular;

    /** Sadece bu sinav turune uygun sorular icin true doner. */
    boolean soruGecerli(Soru soru) {
        return false;
    }

    /** Listeye soru ekle. */
    void soruEkle(Soru soru) {
        sorular.add(soru);
    }

    /** Sinava basla ve ogrenci notunu ekrana yazdir. */
    void sinavaBasla() {
        System.out.println("Sinav adi: " + isim);
        int not = 0, toplam = 0;
        for (Soru soru : sorular) {
            toplam = toplam + soru.getPuan();
            not = not + soru.soruSor();
        }
        System.out.println("sınav bitmiştir. notunuz: " + not + "/" + toplam);
    }

    public void olustur(ArrayList<Soru> butunSorular) {
        System.out.println("Sinav adi: ");
        isim = Main.input.nextLine().trim();
        // Listeyi sifirla
        sorular = new ArrayList<>();
        // Orijinal listeyi bozmamak icin yedek liste olustur
        ArrayList<Soru> yedek = new ArrayList<>(butunSorular);
        // Sorularin sirasini karistir
        Collections.shuffle(yedek);
        int toplam = 0;
        for (Soru soru: butunSorular) {
            if (toplam + soru.getPuan() <= 110 && soruGecerli(soru)) {
                soruEkle(soru);
                toplam += soru.getPuan();
            }
        }
    }
}
