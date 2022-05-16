import java.util.*;
import java.io.*;

public class SinavBankasi {
    ArrayList<Sinav> sinavlar = new ArrayList<>();

    public void dosyayaYaz(String dosyaAdi) {
        try {
            FileOutputStream fos = new FileOutputStream(dosyaAdi);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sinavlar);
            oos.close();
            fos.close();
        } catch (Exception e) {
            return;
        }
    }

    public void dosyadanOku(String dosyaAdi) {
        try {
            FileInputStream fis = new FileInputStream(dosyaAdi);
            ObjectInputStream ois = new ObjectInputStream(fis);

            sinavlar = (ArrayList<Sinav>) ois.readObject();

            ois.close();
            fis.close();
        } catch (Exception e) {
            return;
        }
    }

    public void sinavOlustur(SoruBankasi soruBankasi) {
        System.out.println("1. Test sinav\n2. Klasik sinav\n3. Karisik sinav");
        int secim = Integer.parseInt(Main.input.nextLine());
        Sinav sinav = null;
        if (secim == 1) {
            sinav = new TestSinav();
        } else if (secim == 2) {
            sinav = new KlasikSinav();
        } else if (secim == 3) {
            sinav = new KarisikSinav();
        }
        if (sinav != null) {
            sinav.olustur(soruBankasi.getSorular());
            sinavlar.add(sinav);
        }
    }

	public void sinavYap() {
        Random random = new Random();
        int sinavNo = random.nextInt(sinavlar.size());
        sinavlar.get(sinavNo).sinavaBasla();
	}
}
