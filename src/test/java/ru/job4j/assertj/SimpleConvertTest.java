package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkConstrainAnimals() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("dog", "cate", "crocodile", "rebut", "wolf", "bird");
        assertThat(array).hasSize(6).contains("wolf");
        assertThat(array).isNotNull().hasSize(6);
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("dog", "cate", "crocodile", "rebut", "wolf", "bird");
        assertThat(simpleConvert.toSet(array)).containsAnyOf("rebut").element(3).isNotNull();
    }
@Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("dog", "cate", "crocodile", "rebut", "wolf", "bird");
        assertThat(simpleConvert.toList(array)).element(2).isNotEqualTo("bear");
        assertThat(simpleConvert.toList(array)).doesNotContain("fox");
    }@Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("dog", "cate", "crocodile", "rebut", "wolf", "bird");
        assertThat(simpleConvert.toMap(array)).hasSize(6).containsKey("cate").isNotEmpty();
        assertThat(simpleConvert.toList(array)).doesNotContain("fox").doesNotContain("hours");
    }
}