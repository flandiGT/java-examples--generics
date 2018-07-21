package de.adorsys.example.generic;

import de.adorsys.examples.jaxb.generated.Triangle;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

public class TrianglesTest {

    private Objects<Triangle> objectList;

    @Before
    public void setup() throws Exception {
        objectList = new Objects<Triangle>();
    }

    @Test
    public void should() throws Exception {
        Triangle triangle = new Triangle();
        this.objectList.add(triangle);

        Triangle actualTriangle = this.objectList.get(0);
        assertThat(actualTriangle, is(sameInstance(triangle)));
    }
}
