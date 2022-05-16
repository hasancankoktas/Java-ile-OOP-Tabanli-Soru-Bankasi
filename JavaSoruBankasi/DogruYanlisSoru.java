
public class DogruYanlisSoru extends Soru { 
    boolean dogruCevap;
    boolean verilenCevap;
    
    public boolean getDogruCevap()
    {
        return dogruCevap;
    }

    public void setDogruCevap(boolean dogruCevap) {
        this.dogruCevap = dogruCevap;
    }

    @Override
    public void soruOku() {
        super.soruOku();
        char dogruCevap;
        do
        {
            System.out.print("Dogru cevap (D/Y): ");
            dogruCevap = Main.input.nextLine().trim().toUpperCase().charAt(0);
        } while (dogruCevap != 'D' && dogruCevap != 'Y');
        setDogruCevap(dogruCevap == 'D');
    }

    @Override
    public int soruSor() {
        soruYaz();
        char verilenCevap;
        do {
            System.out.print("Cevabınız: ");
            verilenCevap = Main.input.nextLine().trim().toUpperCase().charAt(0);
        } while (verilenCevap != 'D' && verilenCevap != 'Y');
        this.verilenCevap = verilenCevap == 'D';
        if (this.verilenCevap == getDogruCevap()) {
            System.out.println("verilen cevap dogru");
            return getPuan();
        } else {
            System.out.println("verilen cevap dogru değil");
            System.out.println("dogru cevap " + getDogruCevap());
            return 0;
        }
    }   
    
}

