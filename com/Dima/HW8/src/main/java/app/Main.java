package app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[15];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.print("Початковий вигляд масиву: ");
        System.out.println(Arrays.toString(array));

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        System.out.println("Відсортований масив: ");
        System.out.println(Arrays.toString(array));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть число для пошуку: ");

        int target = scanner.nextInt();

        int result = binarySearch(array, target);

        if (result == -1) {
            System.out.println("Число " + target + " не найдено в массиве.");
        } else {
            System.out.println(" Індекс числа " + target + " у відсортованому масиві " + result);
        }
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

