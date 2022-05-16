public class BoslukDoldurmaSoru extends Soru {
    String dogruCevap;
    String verilenCevap;
    
    public String getDogruCevap()
    {
        return dogruCevap;
    }

    public void setDogruCevap(String dogruCevap) {
        this.dogruCevap = dogruCevap;
    }

    @Override
    public void soruOku() {
        System.out.println("Bosluklari ____ seklinde giriniz.");
        super.soruOku();
        System.out.print("Dogru cevap: ");
        dogruCevap = Main.input.nextLine().trim().toLowerCase();
    }

    @Override
    public int soruSor() {
        soruYaz();
        System.out.print("Cevabınız: ");
        verilenCevap = Main.input.nextLine().trim().toLowerCase();
        if (verilenCevap.equals(getDogruCevap())) {
            System.out.println("verilen cevap dogru");
            return getPuan();
        } else {
            System.out.println("verilen cevap dogru değil");
            System.out.println("dogru cevap " + getDogruCevap());
            return 0;
        }
    }   
}