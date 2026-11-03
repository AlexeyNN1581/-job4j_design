package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void checkThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere").isNotEqualTo("Tetrahedron");
    }

    @Test
    void checkThisTetrahedron() {
        Box box = new Box(4, 5);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron").isNotEqualTo("Sphere");
    }

    @Test
    void checkNotTetrahedronOrSphere() {
        Box box = new Box(8, 5);
        String name = box.whatsThis();
        assertThat(name).isNotEqualTo("Tetrahedron").isNotEqualTo("Sphere");
    }

    @Test
    void checkExist() {
        Box box = new Box(8, 5);
        Boolean numOfVer = box.isExist();
        assertThat(numOfVer).isTrue().isNotNull();

    }

    @Test
    void checkArea() {
        Box box = new Box(8, 5);
        double area = box.getArea();
        assertThat(area).isNotEqualTo(58).isNotEqualTo(123).isNotEqualTo(258).
                isEqualTo(150);

    }
}