package fluent_conditionals;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class TestHelper {

    public static Runnable printDupa() {
        return () -> System.out.println("Dupa");
    }

    public static Runnable printNieDupa() {
       return () -> System.out.println("NieDupa");
    }

    public static Supplier<Callable> printCallableJedynka() {
        return () -> (Callable<Integer>) () -> 1;
    }

    public static Supplier<Callable> printCallableDwa() {
        return () -> (Callable<Integer>) () -> 2;
    }

    public static Supplier<String> printCallableString() {
        return () -> "dupa";
    }

    public static Supplier<String> printCallableStringDwa() {
        return () -> "dupaBlada";
    }
}
