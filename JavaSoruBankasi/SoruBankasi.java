import java.io.*;
import java.util.*;
import java.util.Collections;

public class SoruBankasi {
    static ArrayList<Soru> sorular = new ArrayList<>();

    void dosyadanOku(String dosyaAdi) {
        try {
            FileInputStream fis = new FileInputStream(dosyaAdi);
            ObjectInputStream ois = new ObjectInputStream(fis);

            sorular = (ArrayList<Soru>) ois.readObject();

            ois.close();
            fis.close();
        } catch (Exception e) {
            return;
        }
    }

    void dosyayaYaz(String dosyaAdi) {
        try {
            FileOutputStream fos = new FileOutputStream(dosyaAdi);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sorular);
            oos.close();
            fos.close();
        } catch (Exception e) {
            return;
        }
    }

    ArrayList<Soru> getSorular() {
        return sorular;
    }

    // listelem seçeneklerini listeleme metodu
    void listeListeleme() {
        System.out.println("listeleme seklini giriniz");
        System.out.println("sorulari listelemek icin 1");
        System.out.println("bir kritere göre listeleme icin 2");
        int listeIcınAl = Integer.parseInt(Main.input.nextLine());
        if (listeIcınAl == 1) {
            soruListele();
        } else {
            sIcindeListele();
        }
    }

    // soruları listeleme metodu
    void soruListele() {
        int i = 1;
        System.out.println("\n------------sorular---------");
        for (Soru soru : sorular) {
            System.out.print(i + "->");
            soru.soruYaz();
            System.out.println("");
            i++;
        }
        System.out.println("\n----------------------------\n\n");
    }

    // sorunun içinde arama metodu duzeltilecek
    void sIcindeListele() {
        System.out.println("lutfen hangi katagoride seçim yapacaksanız giriniz");
        System.out.println("1. Soru metni içinde arama");
        System.out.println("2. Soru şıklarının metinleri içinde");
        System.out.println("3. Doğru şıkları uzerinden arama ");
        System.out.println("4. Puan uzerinden arama");
        System.out.println("5. Zorluk derecesinden arama");
        int ara = Integer.parseInt(Main.input.nextLine());
        switch (ara) {
            case (1):
                metinIci();
                break;
            case (2):
                sikMetinIci();
                break;
            case (3):
                break;
            case (4):
                break;
            case (5):
                break;
            default:
                break;
        }

    }

    // metin içinde arama yapma metodu
    private void metinIci() {
        System.out.println("lutfen aramak istediginiz cumleyi giriniz");

        String metin = Main.input.nextLine().trim();

        System.out.println("girilen kelime ile ilgili sorular");
        for (int i = 0; i < sorular.size(); i++) {
            if (sorular.get(i).getSoru().contains(metin)) {
                System.out.println((i + 1) + ". " + sorular.get(i).getSoru());
            }
        }
        System.out.println("sorgulama bitti");
    }

    // sik metni icinde arama yapma metodu eklenecek
    private void sikMetinIci() {
        System.out.println("lütfen cevaplarda aramak istediginiz cumleyi giriniz ");
        String cevap = Main.input.nextLine().trim();

        System.out.println("girilen kelimeyi cevap olarak iceren sorular");
        for (int i = 0; i < sorular.size(); i++) {
        }
        System.out.println("sorgulama bitti");
    }

    // soru ekleme metodu
    void soruEkle() {
        System.out.println("1- Test sorusu");
        System.out.println("2- Klasik soru");
        System.out.println("3- Dogru yanlis sorusu");
        System.out.println("4- Bosluk doldurma sorusu");
        System.out.print("Seciminiz: ");
        int soruTipi = Integer.parseInt(Main.input.nextLine());
        Soru soru = null;
        if (soruTipi == 1) {
            soru = new SecmeliSoru();
        } else if (soruTipi == 2) {
            soru = new KlasikSoru();
        } else if (soruTipi == 3) {
            soru = new DogruYanlisSoru();
        } else if (soruTipi == 4) {
            soru = new BoslukDoldurmaSoru();
        }
        if (soru != null) {
            soru.soruOku();
            sorular.add(soru);
            Collections.sort(sorular);
        }
    }

    // soru silme metodu eklendi
    void soruSil() {
        System.out.print("Silinecek sorunun numarasını giriniz: ");
        int index = Integer.parseInt(Main.input.nextLine()) - 1;
        if (index < 0 || index >= sorular.size()) {
            System.out.println("Soru silinemedi!");
        } else {
            sorular.remove(index);
            System.out.println("Soru silindi \n\n\n");
        }
    }
}
