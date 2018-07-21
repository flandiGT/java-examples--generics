package de.adorsys.example.generic;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class StringsTest {

    private List<String> strings;

    @Before
    public void setup() throws Exception {
        strings = new Objects<String>();
    }

    @Test
    public void shouldStoreOneString() throws Exception {
        strings.add("abc");
        String string = strings.get(0);

        assertThat(string, is(equalTo("abc")));
    }

    @Test
    public void shouldStoreTwoStrings() throws Exception {
        strings.add("abc");
        strings.add("xyz");

        String string = strings.get(0);
        assertThat(string, is(equalTo("abc")));

        string = strings.get(1);
        assertThat(string, is(equalTo("xyz")));
    }

    @Test
    public void shouldStoreThreeStrings() throws Exception {
        strings.add("abc");
        strings.add("xyz");
        strings.add("mno");

        String string = strings.get(0);
        assertThat(string, is(equalTo("abc")));

        string = strings.get(1);
        assertThat(string, is(equalTo("xyz")));

        string = strings.get(2);
        assertThat(string, is(equalTo("mno")));
    }

    @Test
    public void shouldAddThousandStrings() throws Exception {
        for(Integer counter = 0; counter < 1000; counter++) {
            strings.add(counter.toString());
        }
    }

    @Test
    public void shouldAddTenThousandStrings() throws Exception {
        for(Integer counter = 0; counter < 10000; counter++) {
            strings.add(counter.toString());
        }
    }

    @Test
    public void shouldAddHundredThousandStrings() throws Exception {
        for(Integer counter = 0; counter < 100000; counter++) {
            strings.add(counter.toString());
        }
    }

    @Test
    public void shouldAddOneMillionStrings() throws Exception {
        for(Integer counter = 0; counter < 1000000; counter++) {
            strings.add(counter.toString());
        }
    }

    @Test
    public void shouldAddTenMillionStrings() throws Exception {
        for(Integer counter = 0; counter < 10000000; counter++) {
            strings.add(counter.toString());
        }
    }

    @Test
    @Ignore
    public void shouldAddOneBillionStrings() throws Exception {
        for(Integer counter = 0; counter < 1000000000; counter++) {
            strings.add(counter.toString());
        }
    }
}
