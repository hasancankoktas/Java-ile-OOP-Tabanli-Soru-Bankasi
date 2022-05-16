

public class KlasikSoru extends Soru {

    String verilenCevap;
    
    @Override
    public int soruSor() {
        soruYaz();
        System.out.println("Cevabınız: ");
        verilenCevap = Main.input.nextLine().trim();
        return 0;
    }
}
