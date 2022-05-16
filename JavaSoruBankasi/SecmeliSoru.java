
import java.util.*;

/** Secmeli soru. */
public class SecmeliSoru extends Soru {
    String[] cevaplar = new String[4];
    char dogruCevap;
    char verilenCevap;
    
    public String[] getCevaplar() {
        return cevaplar;
    }

    public void setCevaplar(String[] cevaplar) {
        this.cevaplar = cevaplar;
    }

    public char getDogruCevap() {
        return dogruCevap;
    }

    public void setDogruCevap(char dogruCevap) {
        this.dogruCevap = dogruCevap;
    }

    @Override
    public void soruOku() {
        super.soruOku();
        for (int i = 0; i < 4; i++) {
            System.out.print((char)('A' + i) + ": ");
            cevaplar[i] = Main.input.nextLine().trim();
        }
        do {
            System.out.print("doğru cevap (A/B/C/D): ");
            dogruCevap = Main.input.nextLine().trim().charAt(0);
        } while (dogruCevap < 'A' || dogruCevap > 'D');
    }

    @Override
    public void soruYaz() {
        super.soruYaz();
        for (int i = 0; i < getCevaplar().length; i++) {
            System.out.println((char)('A' + i) + ". " + getCevaplar()[i]);
        }
    }

    @Override
    public int soruSor() {
        soruYaz();
        do {
            System.out.println("Cevabınız: ");
            verilenCevap = Main.input.nextLine().trim().charAt(0);
        } while(verilenCevap < 'A' || verilenCevap > 'D');
        if (verilenCevap == getDogruCevap()) {
            System.out.println("verilen cevap dogru");
            return getPuan();
        } else {
            System.out.println("verilen cevap dogru değil");
            System.out.println("dogru cevap " + getDogruCevap());
            return 0;
        }
    }
}
