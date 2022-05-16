public class KlasikSinav extends Sinav {

    @Override
    boolean soruGecerli(Soru soru) {
        return KlasikSoru.class.isInstance(soru);
    }
}
