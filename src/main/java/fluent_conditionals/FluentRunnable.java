package fluent_conditionals;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class FluentRunnable {

    private boolean statement;
    private Runnable runnableToRun;

    public FluentRunnable(BooleanSupplier statement, Runnable runnable) {
        this.statement = statement.getAsBoolean();
        this.runnableToRun = runnable;
    }

    public void orElse(Runnable runnable) {
        if (!statement) runnableToRun = runnable;
        runFluent(runnableToRun);
    }

    public void orElseThrowE(Exception exception) throws Exception {
        orElseThrow(() -> exception);
    }

    public void orElseThrow(Supplier<Exception>  exception) throws Exception {
        if (!statement) throw exception.get();
        runFluent(runnableToRun);
    }

    private void runFluent(Runnable runnable) {
        runnable.run();
    }
}
