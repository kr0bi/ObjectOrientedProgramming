package objOrientProgr.agenziaImmobiliare;

import java.util.function.Predicate;

public interface Filtro {
    public Predicate<Abitazione> test(int min, int max);
}
