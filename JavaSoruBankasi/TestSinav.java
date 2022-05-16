public class TestSinav extends Sinav {

    @Override
    boolean soruGecerli(Soru soru) {
        return SecmeliSoru.class.isInstance(soru);
    }
}
