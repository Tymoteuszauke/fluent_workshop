package fluent_conditionals;

import org.testng.annotations.Test;

import java.util.function.Supplier;

import static fluent_conditionals.FluentConditional.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

public class FluentConditionalTest {

    @Test
    public void fluentConditionalExpectTrue() {
        boolean condition = true;
        Fluent fluent = mock(Fluent.class);

        when(() -> condition)
                .then(fluent::doThen)
                .orElse(fluent::doElse);

        verify(fluent, times(1)).doThen();
    }

    @Test
    public void fluentConditionalExpectFalse() {
        boolean condition = true;
        Fluent fluent = mock(Fluent.class);

        when(() -> condition)
                .then(fluent::doThen)
                .orElse(fluent::doElse);

        verify(fluent, times(1)).doThen();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void fluentConditionalExpectRuntimeExceptionOnThrowE() throws Exception {
        Fluent fluent = mock(Fluent.class);

        when(() -> false)
                .then(fluent::doThen)
                .orElseThrowE(new RuntimeException());
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void fluentConditionalExpectRuntimeExceptionOnThrow() throws Exception {
        Fluent fluent = mock(Fluent.class);

        when(() -> false)
                .then(fluent::doThen)
                .orElseThrow(RuntimeException::new);
    }

    @Test
    public void fluentConditionalExpectDoThen() throws Exception {
        Fluent fluent = mock(Fluent.class);

        when(() -> true)
                .then(fluent::doThen)
                .orElseThrow(RuntimeException::new);

        verify(fluent, times(1)).doThen();
    }

    @Test
    public void fluentConditionalReturnString() {

        String data = when(() -> true)
                .thenReturn(() -> "Goła baba")
                .orElse(() -> "Ubrana baba");

        System.out.println(data);
        assertEquals("Goła baba", data);
    }

    @Test
    public void fluentConditionalReturnInteger() {

        Integer data = when(() -> false)
                .thenReturn(() -> 1)
                .orElse(() -> 2);

        System.out.println(data);
        assertEquals(2, (int)data);
    }


}