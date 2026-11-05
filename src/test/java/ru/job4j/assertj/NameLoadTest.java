package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
        //does not contain a key
    void checkParse1() {
        NameLoad nameLoad = new NameLoad();
        String names = "=Alex";
        nameLoad.parse(names);


    }

    @Test
        //does not contain the symbol '='
    void checkParse2() {
        NameLoad nameLoad = new NameLoad();
        String names = "Alex";
        nameLoad.parse(names);


    }

    @Test
        //does not contain a value
    void checkParse3() {
        NameLoad nameLoad = new NameLoad();
        String names = "A=";
        nameLoad.parse(names);


    }  @Test
        //Тут не понятно, как добиться, чтобы выбрасывало ошибку Names array is empty
    void checkParse4() {
        NameLoad nameLoad = new NameLoad();
        String names=new String();
        nameLoad.parse(names);


    }
}

