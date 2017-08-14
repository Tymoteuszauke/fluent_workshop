package fluent_conditionals;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class FluentSupplier {

    private BooleanSupplier booleanSupplier;
    private Supplier supplier;

    public <T> FluentSupplier(BooleanSupplier statement, Supplier<T> supplier) {
        this.booleanSupplier = statement;
        this.supplier = supplier;
    }

    public <T> T orElse(Supplier<T> supplier) {
        if (!booleanSupplier.getAsBoolean()) this.supplier = supplier;
        return (T) this.supplier.get();
    }
}
