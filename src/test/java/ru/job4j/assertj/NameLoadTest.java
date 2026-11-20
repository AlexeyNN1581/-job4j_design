package ru.job4j.assertj;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkisEmptyArg() {
        NameLoad nameLoad = new NameLoad();
        String[] args = new String[0];
        //   nameLoad.parse(args);

        ThrowableAssert.ThrowingCallable action = new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                nameLoad.parse(args);
            }
        };
        assertThatThrownBy(action)
                .isInstanceOf(IllegalArgumentException.class)

                .hasMessageContaining("Names array is empty");
    }

    @Test
    void checkNotContain() {
        NameLoad nameLoad = new NameLoad();
        String[] args = new String[1];
        args[0] = "=";
        //   nameLoad.parse(args);

        ThrowableAssert.ThrowingCallable action = () -> nameLoad.parse(args);
        assertThatThrownBy(action)
                .isInstanceOf(IllegalArgumentException.class)

                .hasMessageContaining("this name: = does not contain a key");

    }

    @Test
    void checkNotContain1() {
        NameLoad nameLoad = new NameLoad();
        String[] args = new String[2];
        args[0] = "a";
        args[1] = "=";
        //   nameLoad.parse(args);

        ThrowableAssert.ThrowingCallable action = () -> nameLoad.parse(args);
        assertThatThrownBy(action)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: a does not contain the symbol '='");
    }

    @Test
    void checkNotContain2() {
        NameLoad nameLoad = new NameLoad();
        String[] args = new String[2];
        args[1] = "args=";
        args[0] = "args=";
        //   nameLoad.parse(args);

        ThrowableAssert.ThrowingCallable action = () -> nameLoad.parse(args);
        assertThatThrownBy(action)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: args= does not contain a value");
    }
}