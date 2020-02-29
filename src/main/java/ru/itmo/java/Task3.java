package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {

        if (inputArray == null || inputArray.length == 0) {
            return new int[]{};
        }

        int val = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 1; i > 0; i--) {
            inputArray[i] = inputArray[i - 1];
        }
        inputArray[0] = val;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        } else if (inputArray.length == 1) {
            return inputArray[0];
        }

        int max1 = -1, max2 = -1, pos = -1;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max1) {
                max1 = inputArray[i];
                pos = i;
            }
            if (inputArray[i] > max2 && i != pos) {
                max2 = inputArray[i];
            }
        }
        return max1 * max2;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null) {
            return 0;
        }
        int len = input.length();
        double sum = 0;
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'A' || input.charAt(i) == 'b' || input.charAt(i) == 'B') {
                sum += 1;
            }
        }
        return (int) ((sum / len) * 100);
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        String ans = "";
        if (input == null) {
            return "";
        }
        int i = 0;
        while (input.length() > i) {
            char ch = input.charAt(i);
            int index = 0;
            while (input.charAt(i) == ch) {
                index += 1;
                i++;
                if (i == input.length()) {
                    break;
                }
            }
            ans += ch + Integer.toString(index);
        }
        return ans;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() != two.length() || one == "") {
            return false;
        }
        char chars[] = one.toCharArray();
        Arrays.sort(chars);
        char chars2[] = two.toCharArray();
        Arrays.sort(chars2);
        if (Arrays.equals(chars, chars2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i), i + 1) != -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m[0].length == 0)
            return new int[][]{{}, {}};
        int n = m[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }
        if (separator == null) {
            separator = ' ';
        }
        String res = "";
        for (int i = 0; i < inputStrings.length - 1; i++) {
            res += inputStrings[i] + separator;
        }
        return res + inputStrings[inputStrings.length - 1];
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < inputStrings.length; i++) {
            int k = 0;
            for (int j = 0; j < prefix.length(); j++) {
                if (inputStrings[i].charAt(j) == prefix.charAt(j)) {
                    k++;
                } else {
                    break;
                }

            }
            if (k == prefix.length()) {
                res++;
            }
        }
        return res;
    }
}