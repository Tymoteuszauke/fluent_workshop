package fluent_conditionals;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class FluentParameter {

    private Supplier<String> stringSupplier;
    private BooleanSupplier booleanSupplier;

    public FluentParameter(Supplier<String> stringSupplier) {
        this.stringSupplier = stringSupplier;
    }

    public void when(BooleanSupplier booleanSupplier) {
        this.booleanSupplier = booleanSupplier;
    }

     public void then(Supplier<String> stringSupplier) {

     }

     public void orElse(Supplier<Integer> characterIndex) {

     }
}
