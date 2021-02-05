package org.deroesch.state.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class StateTest {

    private static final Supplier<? extends IllegalArgumentException> ILLEGAL_ARG = IllegalArgumentException::new;

    @Test
    void testEquality() {
        assertSame(State.CA, State.CA);
        assertNotSame(State.OK, State.CA);
    }

    @Test
    void testGetter() {
        assertEquals("PA", State.PA.shortName());
        assertEquals("Pennsylvania", State.PA.getLongName());
    }

    @Test
    void testGetOne() {
        assertEquals(State.PA, State.getOne("Pennsylvania").orElseThrow(ILLEGAL_ARG));
        assertEquals("PA", State.getOne("Pennsylvania").orElseThrow(ILLEGAL_ARG).shortName());

        assertThrows(IllegalArgumentException.class, () -> {
            State.getOne("Foobar").orElseThrow(ILLEGAL_ARG);
        });
    }

}
