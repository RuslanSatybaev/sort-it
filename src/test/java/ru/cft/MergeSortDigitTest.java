package ru.cft;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortDigitTest {

    @Test
    public void positiveTest() {
        int[] actual = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] expectedDesc = {6, 5, 4, 3, 2, 1};
        MergeSortDigit.mergeSort(actual, actual.length);
        assertArrayEquals(expectedDesc, actual);
    }
}