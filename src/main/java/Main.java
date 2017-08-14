import fluent_conditionals.TestHelper;

import java.util.function.BooleanSupplier;

import static fluent_conditionals.FluentConditional.*;


public class Main {
    public static void main(String[] args) throws Exception {

        when(() -> true)
                .then(TestHelper.printDupa())
                .orElse(TestHelper.printNieDupa());

//        System.out.println(dupa);
    }


}
