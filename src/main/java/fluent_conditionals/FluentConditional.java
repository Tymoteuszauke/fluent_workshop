package fluent_conditionals;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class FluentConditional {

    private BooleanSupplier statement;
    private Supplier mySupplier;

    public FluentConditional(BooleanSupplier statement) {
        this.statement = statement;
    }

    public static FluentConditional when(BooleanSupplier conditionStatement) {
        return new FluentConditional(conditionStatement);
    }

    public FluentParameter given(Supplier<String> stringSupplier) {
        return new FluentParameter(stringSupplier);
    }

    public FluentRunnable then(Runnable runnable) {
        return new FluentRunnable(statement, runnable);
    }

    public <T>FluentSupplier thenReturn(Supplier<T> supplier) {
        if (statement.getAsBoolean()) mySupplier = supplier;
        return new FluentSupplier(statement, mySupplier);
    }
}
