package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test class for the App class.
 * Contains tests for all methods of the App class, including
 * verification of normal cases and exception scenarios.
 */
public class AppTest {

    /**
     * Tests array generation with a valid size.
     * Verifies that the array is not null, has the correct size,
     * and all elements are within the range [-100; 100].
     */
    @Test
    public void testGenerateRandomArray_ValidSize() {
        int[] array = App.generateRandomArray(10);
        assertNotNull(array);
        assertEquals(10, array.length);
        for (int num : array) {
            assertTrue(num >= -100 && num <= 100);
        }
    }

    /**
     * Tests array generation with zero size.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomArray_ZeroSize() {
        App.generateRandomArray(0);
    }

    /**
     * Tests array generation with negative size.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGenerateRandomArray_NegativeSize() {
        App.generateRandomArray(-5);
    }

    /**
     * Tests counting positive elements in an array with positive numbers.
     */
    @Test
    public void testCountPositiveElements_WithPositives() {
        int[] array = {5, -3, 10, -1, 0, 7};
        assertEquals(3, App.countPositiveElements(array));
    }

    /**
     * Tests counting positive elements in an array without positive numbers.
     */
    @Test
    public void testCountPositiveElements_NoPositives() {
        int[] array = {-5, -3, -10, 0};
        assertEquals(0, App.countPositiveElements(array));
    }

    /**
     * Tests counting positive elements in an array containing only positive numbers.
     */
    @Test
    public void testCountPositiveElements_AllPositives() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(5, App.countPositiveElements(array));
    }

    /**
     * Tests counting positive elements for a null array.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCountPositiveElements_NullArray() {
        App.countPositiveElements(null);
    }

    /**
     * Tests counting positive elements for an empty array.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCountPositiveElements_EmptyArray() {
        App.countPositiveElements(new int[0]);
    }

    /**
     * Tests finding the index of the minimum absolute value element in a normal case.
     */
    @Test
    public void testFindMinAbsIndex_NormalCase() {
        int[] array = {5, -3, 10, -1, 7};
        assertEquals(3, App.findMinAbsIndex(array));
    }

    /**
     * Tests finding the index of the minimum absolute value element
     * when it is at the first position.
     */
    @Test
    public void testFindMinAbsIndex_FirstElement() {
        int[] array = {0, 5, -3, 10};
        assertEquals(0, App.findMinAbsIndex(array));
    }

    /**
     * Tests finding the index of the minimum absolute value element
     * when it is at the last position.
     */
    @Test
    public void testFindMinAbsIndex_LastElement() {
        int[] array = {5, -3, 10, -1};
        assertEquals(3, App.findMinAbsIndex(array));
    }

    /**
     * Tests finding the index for a null array.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindMinAbsIndex_NullArray() {
        App.findMinAbsIndex(null);
    }

    /**
     * Tests finding the index for an empty array.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindMinAbsIndex_EmptyArray() {
        App.findMinAbsIndex(new int[0]);
    }

    /**
     * Tests calculating the product of elements before the minimum absolute value
     * in a normal case.
     */
    @Test
    public void testProductBeforeMinAbs_NormalCase() {
        int[] array = {2, 3, 1, 5, 4};
        assertEquals(6, App.productBeforeMinAbs(array));
    }

    /**
     * Tests calculating the product of elements before the minimum absolute value
     * with negative numbers in the array.
     */
    @Test
    public void testProductBeforeMinAbs_WithNegativeNumbers() {
        int[] array = {-2, 3, 1, 5, 4};
        assertEquals(-6, App.productBeforeMinAbs(array));
    }

    /**
     * Tests calculating the product of elements before the minimum absolute value
     * when the minimum absolute value element is zero.
     */
    @Test
    public void testProductBeforeMinAbs_WithZero() {
        int[] array = {2, 0, 1, 5, 4};
        assertEquals(2, App.productBeforeMinAbs(array));
    }

    /**
     * Tests calculating the product when the minimum absolute value element
     * is first in the array. Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProductBeforeMinAbs_MinIsFirst() {
        int[] array = {0, 5, -3, 10};
        App.productBeforeMinAbs(array);
    }

    /**
     * Tests calculating the product for a null array.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProductBeforeMinAbs_NullArray() {
        App.productBeforeMinAbs(null);
    }

    /**
     * Tests calculating the product for an empty array.
     * Expects IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testProductBeforeMinAbs_EmptyArray() {
        App.productBeforeMinAbs(new int[0]);
    }
}
