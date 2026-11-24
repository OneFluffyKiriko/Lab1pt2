package org.example;

/**
 1. Створити програми для розв’язування задачі згідно свого варіанту та
 модульний тест до неї. Виконати завдання з використанням функцій. Організувати
 окремий метод для обчислення кожного показника. Модульний тест повинен
 перевіряти коректність роботи усіх створених у проекті методів. Передбачити в
 проекті обробку виключних ситуацій для усіх можливих у вашому варіанті випадків,
 коли розрахунки виконати неможливо.
 Варіант 21:  Для одновимірного масиву цілих чисел, заданого випадковим чином з діапазону
 [-100;100]...21. Визначити 1) кількість додатних елементів масиву; 2) добуток елементів
 масиву, розташованих до мінімального за модулем елемента.
 */
import java.util.Random;

public class App {

    /**
        Makes big array and draws it on the screen
     */
    public static void main(String[] args) {
        try {
            int[] array = generateRandomArray(10);
            System.out.println("Згенерований масив:");
            printArray(array);

            int positiveCount = countPositiveElements(array);
            System.out.println("Кількість додатних елементів: " + positiveCount);

            long product = productBeforeMinAbs(array);
            System.out.println("Добуток елементів до мінімального за модулем: " + product);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    /**
    Generates array full set of integers for an array.
     Also runs checks to make sure the array size is > 0
     */
    public static int[] generateRandomArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Розмір масиву має бути більше 0");
        }

        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100;
        }
        return array;
    }

    /**
    This one counts the number of positive integers in the array.
     *
     * @param array масив цілих чисел
     * @return кількість елементів, більших за 0
     * @throws IllegalArgumentException якщо масив null або порожній
     */
    public static int countPositiveElements(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути null або порожнім");
        }

        int count = 0;
        for (int num : array) {
            if (num > 0) {
                count++;
                countPositiveElements(int[]): int          }
        }
        return count;
    }

    /**
     Finds the index of the element with the minimum absolute value.
     If a few elements are at the minimum, it returns the first one in the array.
     */
    public static int findMinAbsIndex(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути null або порожнім");
        }

        int minAbsIndex = 0;
        int minAbsValue = Math.abs(array[0]);

        for (int i = 1; i < array.length; i++) {
            int currentAbs = Math.abs(array[i]);
            if (currentAbs < minAbsValue) {
                minAbsValue = currentAbs;
                minAbsIndex = i;
            }
        }
        return minAbsIndex;
    }

    /**
     Calculates the sum of the elements before the minimum absolute value.
     */
    public static long productBeforeMinAbs(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути null або порожнім");
        }

        int minAbsIndex = findMinAbsIndex(array);

        if (minAbsIndex == 0) {
            throw new IllegalArgumentException("Мінімальний за модулем елемент є першим, немає елементів до нього");
        }

        long product = 1;
        for (int i = 0; i < minAbsIndex; i++) {
            product *= array[i];
        }
        return product;
    }

    /**
     * Draws the array in the [elem1, elem2, ...] format.
     */
    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
