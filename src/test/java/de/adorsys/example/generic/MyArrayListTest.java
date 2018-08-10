package de.adorsys.example.generic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MyArrayListTest {

    private MyArrayList<String> list;

    @Before
    public void setup() throws Exception {
        list = new MyArrayList<>();
    }

    @Test
    public void shouldHaveZeroSizeAfterInitialization() throws Exception {
        assertThat(list.size(), is(0));
    }

    @Test
    public void shouldNotContainElementsAfterInitialization() throws Exception {
        assertThat(list.contains("does not exist"), is(equalTo(false)));
    }

    @Test
    public void shouldNotContainElementAfterInitializationAtIndex() throws Exception {
        assertThat(list.indexOf("does not exist"), is(equalTo(-1)));
    }

    @Test
    public void shouldNotContainElementAfterInitializationAtLastIndex() throws Exception {
        assertThat(list.lastIndexOf("does not exist"), is(equalTo(-1)));
    }

    @Test
    public void shouldBeEmptyAfterInitialization() throws Exception {
        assertThat(list.isEmpty(), is(equalTo(true)));
    }

    @Test
    public void shouldAddOneString() throws Exception {
        list.add("abc");
        String string = list.get(0);

        assertThat(string, is(equalTo("abc")));
        assertThat(list.size(), is(1));
        assertThat(list.indexOf("abc"), is(equalTo(0)));
    }

    @Test
    public void shouldNotSetFirstStringIfIndexIsNegative() throws Exception {
        try {
            list.set(-1, "abc");
        } catch(IndexOutOfBoundsException e){
            return;
        }

        Assert.fail("no IndexOutOfBoundsException thrown");
    }

    @Test
    public void shouldNotSetFirstStringIfListIsEmpty() throws Exception {
        try {
            list.set(0, "abc");
        } catch(IndexOutOfBoundsException e){
            return;
        }

        Assert.fail("no IndexOutOfBoundsException thrown");
    }

    @Test
    public void shouldNotSetSecondStringIfListContainsOneElement() throws Exception {
        list.add("abc");

        try {
            list.set(1, "xyz");
        } catch(IndexOutOfBoundsException e){
            return;
        }

        Assert.fail("no IndexOutOfBoundsException thrown");
    }

    @Test
    public void shouldSetSecondString() throws Exception {
        list.add("xyz");
        String previous = list.set(0, "abc");
        String string = list.get(0);

        assertThat(previous, is(equalTo("xyz")));
        assertThat(string, is(equalTo("abc")));
        assertThat(list.indexOf("abc"), is(equalTo(0)));
        assertThat(list.indexOf("xyz"), is(equalTo(-1)));
    }

    @Test
    public void shouldContainElementAtLastIndexAfterAddingOneElement() throws Exception {
        list.add("abc");
        assertThat(list.lastIndexOf("abc"), is(equalTo(0)));
    }

    @Test
    public void shouldContainFirstElementAfterAddingOneElement() throws Exception {
        list.add("abc");
        assertThat(list.contains("abc"), is(equalTo(true)));
    }

    @Test
    public void shouldContainFirstElementAfterAddingOneElementWhichIsntTheSame() throws Exception {
        list.add("ab".concat("c"));
        assertThat(list.contains("abc"), is(equalTo(true)));
    }

    @Test
    public void shouldNotContainNullElement() throws Exception {
        assertThat(list.contains(null), is(equalTo(false)));
    }

    @Test
    public void shouldNotContainNullElementAtIndex() throws Exception {
        assertThat(list.indexOf(null), is(equalTo(-1)));
    }
    @Test
    public void shouldNotContainNullElementAtLastIndex() throws Exception {
        assertThat(list.lastIndexOf(null), is(equalTo(-1)));
    }

    @Test
    public void shouldContainNullElementIfAdded() throws Exception {
        list.add(null);
        assertThat(list.contains(null), is(equalTo(true)));
    }

    @Test
    public void shouldContainNullElementIfAddedAtIndex() throws Exception {
        list.add(null);
        assertThat(list.indexOf(null), is(equalTo(0)));
    }

    @Test
    public void shouldContainNullElementIfAddedAtLastIndex() throws Exception {
        list.add(null);
        assertThat(list.lastIndexOf(null), is(equalTo(0)));
    }

    @Test
    public void shouldNotBeEmptyAfterAddingOneElement() throws Exception {
        list.add("abc");
        assertThat(list.isEmpty(), is(equalTo(false)));
    }

    @Test
    public void shouldContainElementAtIndexAfterAddingTwoElements() throws Exception {
        list.add("abc");
        list.add("xyz");
        assertThat(list.indexOf("xyz"), is(equalTo(1)));
    }

    @Test
    public void shouldContainElementAtLastIndexAfterAddingTwoElements() throws Exception {
        list.add("abc");
        list.add("xyz");
        assertThat(list.lastIndexOf("xyz"), is(equalTo(1)));
    }

    @Test
    public void shouldContainElementAtLastIndexAfterAddingTwoSameElements() throws Exception {
        list.add("xyz");
        list.add("abc");
        list.add("xyz");
        assertThat(list.lastIndexOf("xyz"), is(equalTo(2)));
    }

    @Test
    public void shouldStoreTwoStrings() throws Exception {
        list.add("abc");
        list.add("xyz");

        String string = list.get(0);
        assertThat(string, is(equalTo("abc")));

        string = list.get(1);
        assertThat(string, is(equalTo("xyz")));
    }

    @Test
    public void shouldHaveSizeOfTwoAfterAddingTwoElements() throws Exception {
        list.add("abc");
        list.add("xyz");
        assertThat(list.size(), is(2));
    }

    @Test
    public void shouldNotBeEmptyAfterAddingTwoElements() throws Exception {
        list.add("abc");
        list.add("xyz");
        assertThat(list.isEmpty(), is(equalTo(false)));
    }

    @Test
    public void shouldStoreThreeStrings() throws Exception {
        list.add("abc");
        list.add("xyz");
        list.add("mno");

        String string = list.get(0);
        assertThat(string, is(equalTo("abc")));

        string = list.get(1);
        assertThat(string, is(equalTo("xyz")));

        string = list.get(2);
        assertThat(string, is(equalTo("mno")));
    }

    @Test
    public void shouldHaveSizeOfThreeAfterAddingThreeElements() throws Exception {
        list.add("abc");
        list.add("mno");
        list.add("xyz");
        assertThat(list.size(), is(3));
    }

    @Test
    public void shouldNotBeEmptyAfterAddingThreeElements() throws Exception {
        list.add("abc");
        list.add("mno");
        list.add("xyz");
        assertThat(list.isEmpty(), is(equalTo(false)));
    }

    @Test
    public void shouldAddThousandStrings() throws Exception {
        for(Integer counter = 0; counter < 1000; counter++) {
            list.add(counter.toString());
        }
    }

    @Test
    public void shouldAddTenThousandStrings() throws Exception {
        for(Integer counter = 0; counter < 10000; counter++) {
            list.add(counter.toString());
        }
    }

    @Test
    public void shouldAddHundredThousandStrings() throws Exception {
        for(Integer counter = 0; counter < 100000; counter++) {
            list.add(counter.toString());
        }
    }

    @Test
    public void shouldAddOneMillionStrings() throws Exception {
        for(Integer counter = 0; counter < 1000000; counter++) {
            list.add(counter.toString());
        }
    }

    @Test
    @Ignore
    public void shouldAddTenMillionStrings() throws Exception {
        for(Integer counter = 0; counter < 10000000; counter++) {
            list.add(counter.toString());
        }
    }

    @Test
    @Ignore
    public void shouldAddOneBillionStrings() throws Exception {
        for(Integer counter = 0; counter < 1000000000; counter++) {
            list.add(counter.toString());
        }
    }

    @Test
    public void shouldContainAllElementsWhenNoElementExists() throws Exception {
        List<String> otherList = new ArrayList<>();
        assertThat(list.containsAll(otherList), is(equalTo(true)));

    }

    @Test
    public void shouldNotContainAllElementsWhenElementsDiffer() throws Exception {
        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        assertThat(list.containsAll(otherList), is(equalTo(false)));
    }

    @Test
    public void shouldContainAllElementsWhenListsContainingSameElement() throws Exception {
        list.add("abc");

        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        assertThat(list.containsAll(otherList), is(equalTo(true)));
    }

    @Test
    public void shouldContainAllElementsWhenListsContainingOneElement() throws Exception {
        list.add("abc");
        list.add("xyz");

        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        assertThat(list.containsAll(otherList), is(equalTo(true)));
    }

    @Test
    public void shouldContainAllElementsWhenListsContainingSameElements() throws Exception {
        list.add("abc");
        list.add("xyz");

        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        otherList.add("xyz");
        assertThat(list.containsAll(otherList), is(equalTo(true)));
    }

    @Test
    public void shouldAddAllElementFromCollection() throws Exception {
        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        list.addAll(otherList);
        assertThat(list.addAll(otherList), is(equalTo(true)));
    }

    @Test
    public void shouldAddAllThreeElementsFromCollection() throws Exception {
        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        otherList.add("def");
        otherList.add("xyz");
        list.addAll(otherList);
        assertThat(list.addAll(otherList), is(equalTo(true)));
    }

    @Test
    public void shouldAddAllElementFromCollectionAtIndex() throws Exception {
        list.add("abc");
        list.add("def");
        list.add("ghi");
        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        list.addAll(2, otherList);
        assertThat(list.addAll(otherList), is(equalTo(true)));
    }

    @Test
    public void shouldAddAllElementsFromCollectionAtIndexZero() throws Exception {
        list.add("abc");
        list.add("def");
        list.add("ghi");

        List<String> otherList = new ArrayList<>();
        otherList.add("xyz");
        list.addAll(0, otherList);

        assertThat(list.indexOf("xyz"), is(equalTo(0)));
        assertThat(list.indexOf("abc"), is(equalTo(1)));
        assertThat(list.indexOf("def"), is(equalTo(2)));
        assertThat(list.indexOf("ghi"), is(equalTo(3)));
    }

    @Test
    public void shouldAddAllTwoElementsFromCollectionAtIndexZero() throws Exception {
        list.add("abc");
        list.add("def");
        list.add("ghi");

        List<String> otherList = new ArrayList<>();
        otherList.add("xyz");
        otherList.add("123");
        list.addAll(0, otherList);

        assertThat(list.indexOf("xyz"), is(equalTo(0)));
        assertThat(list.indexOf("123"), is(equalTo(1)));
        assertThat(list.indexOf("abc"), is(equalTo(2)));
        assertThat(list.indexOf("def"), is(equalTo(3)));
        assertThat(list.indexOf("ghi"), is(equalTo(4)));
    }

    @Test
    public void shouldAddAllElementsFromCollectionAtIndexTwo() throws Exception {
        list.add("abc");
        list.add("def");
        list.add("ghi");

        List<String> otherList = new ArrayList<>();
        otherList.add("xyz");
        list.addAll(2, otherList);

        assertThat(list.indexOf("abc"), is(equalTo(0)));
        assertThat(list.indexOf("def"), is(equalTo(1)));
        assertThat(list.indexOf("xyz"), is(equalTo(2)));
        assertThat(list.indexOf("ghi"), is(equalTo(3)));
    }

    @Test
    public void shouldAddAllElementsFromCollectionAtIndexThree() throws Exception {
        list.add("abc");
        list.add("def");
        list.add("ghi");

        List<String> otherList = new ArrayList<>();
        otherList.add("xyz");
        list.addAll(3, otherList);

        assertThat(list.indexOf("abc"), is(equalTo(0)));
        assertThat(list.indexOf("def"), is(equalTo(1)));
        assertThat(list.indexOf("ghi"), is(equalTo(2)));
        assertThat(list.indexOf("xyz"), is(equalTo(3)));
    }

    @Test
    public void shouldNotAddAllElementsFromCollectionWithNegativeIndex() throws Exception {
        List<String> otherList = new ArrayList<>();
        otherList.add("xyz");

        try {
            list.addAll(-1, otherList);
        } catch(IndexOutOfBoundsException e) {
            return;
        }

        Assert.fail("no IndexOutOfBoundsException thrown");
    }

    @Test
    public void shouldNotAddAllElementsFromCollectionWithIndexAboveRange() throws Exception {
        List<String> otherList = new ArrayList<>();
        otherList.add("xyz");

        try {
            list.addAll(1, otherList);
        } catch(IndexOutOfBoundsException e) {
            return;
        }

        Assert.fail("no IndexOutOfBoundsException thrown");
    }

    @Test
    public void shouldNotRemoveElementFromCollection() throws Exception {
        list.add("abc");
        list.remove("xyz");
        assertThat(list.remove("xyz"), is(equalTo(false)));
    }

    @Test
    public void shouldRemoveElementFromCollection() throws Exception {
        list.add("abc");
        list.remove("abc");
        assertThat(list.remove("abc"), is(equalTo(true)));
    }

    @Test
    public void shouldRemoveElementFromLongerCollection() throws Exception {
        list.add("abc");
        list.add("def");
        list.add("xyz");
        list.add("abc");
        list.add("def");
        list.remove("def");
        assertThat(list.remove("def"), is(equalTo(true)));
    }

    @Test
    public void shouldRemoveAllElementsFromCollection() throws Exception {
        list.add("abc");
        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        list.removeAll(otherList);
        assertThat(list.removeAll(otherList), is(equalTo(true)));
    }

    @Test
    public void shouldRemoveAllElementsFromLongerCollection() throws Exception {
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("abc");
        list.add("xyz");
        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        otherList.add("xyz");
        list.removeAll(otherList);
        assertThat(list.removeAll(otherList), is(equalTo(true)));
    }

    @Test
    public void shouldRetainAllElementsFromCollection() throws Exception {
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("abc");
        list.add("xyz");
        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        otherList.add("xyz");
        list.retainAll(otherList);
        assertThat(list.retainAll(otherList), is(equalTo(true)));
    }

    @Test
    public void shouldNotChangeRetainAllElementsFromCollection() throws Exception {
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("xyz");
        List<String> otherList = new ArrayList<>();
        otherList.add("abc");
        otherList.add("def");
        otherList.add("ghi");
        otherList.add("xyz");
        list.retainAll(otherList);
        assertThat(list.retainAll(otherList), is(equalTo(false)));
    }
}
