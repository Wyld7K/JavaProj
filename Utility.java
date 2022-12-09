import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

public class Utility {
    private static Scanner s = new Scanner(System.in);

    // ======TERMINAL METHODS======

    /**
     * Sleeps thread based on inputted seconds
     * 
     * @param seconds desired num of seconds
     */
    public static void sleepThread(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000);

        } catch (Exception e) {
            System.out.print(
                    e.toString().replaceAll("\\[", "").replaceAll("]", ""));
        }
    }

    /**
     * Checks if player wants to play again
     * 
     * @return boolean that can be used to determine whether to run method again
     */
    public static boolean YayOrNay() {
        System.out.println("Play Again? (Y/N)");
        String answer = "";
        do {
            answer = s.nextLine().substring(0).toUpperCase();
        } while (!(answer.equals("Y") || answer.equals("N")));
        if (answer.equals("Y"))
            return true;
        return false;
    }

    public static void clearTerminal() {
        // String sequence to clear terminal: \033[H\033[2J
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // <<<<PRINTDOTSLEEP METHODS>>>>>

    /**
     * Makes a cool print that includes a start and final Print message
     * 
     * @param finalPrintMessage The last thing printed after dots
     *
     */
    public static void printSleepDotsMessage(String finalPrintMessage, String calcMessage) {
        System.out.print(calcMessage);
        sleepThread(1); // See sleepThread method

        System.out.print(".");
        sleepThread(1);

        System.out.print(".");
        sleepThread(1); // See sleepThread method

        System.out.println(".");
        sleepThread(1); // See sleepThread method

        System.out.println(finalPrintMessage);
    }

    public static void printSleepDotsMessage(String finalPrintMessage, String calcMessage, int sleepTime) {
        System.out.print(calcMessage);
        sleepThread(sleepTime);
        System.out.print(".");
        sleepThread(sleepTime);
        System.out.print(".");
        sleepThread(sleepTime);
        System.out.println(".");
        sleepThread(sleepTime);
        System.out.println(finalPrintMessage);
    }

    public static void printSleepDotsMessage(String startingMessage, String calcMessage, String finalMessage,
            int sleepTime) {
        System.out.print("Your answer is");
        sleepThread(sleepTime);
        System.out.print(".");
        sleepThread(sleepTime);
        System.out.print(".");
        sleepThread(sleepTime);
        System.out.println(".");
        sleepThread(sleepTime);
        System.out.println(finalMessage);
    }

    // ======ARRAY METHODS======

    // <<<<swapElementsInArr METHODS>>>>>
    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // ======STRING METHODS======
    public static int numVowels(String word) {
        int count = 0;
        List<Character> vowels = new ArrayList<Character>(Arrays.asList(new Character[] { 'A', 'E', 'I', 'O', 'U' }));

        for (int i = 0; i < word.length(); i++) {
            if (vowels.contains(word.toUpperCase().charAt(i))) {
                count++;
            }

        }
        return count;

    }

    public static String reverseIt(String word) {
        String tempWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            tempWord += word.charAt(i);
        }
        return tempWord;
    }

    public String sortAlphebetical(String text) {

        text = text.toLowerCase();
        char[] letters = text.toCharArray();
        String finalWord = "";

        // Selection Sort Algorithm
        for (int i = letters.length - 1; i > 0; i--) {

            int largest = 0;
            for (int j = 1; j <= i; j++) {
                if (((int) letters[j]) > ((int) letters[largest]))
                    largest = j;
            }
            Utility.swap(letters, largest, i);

        }
        for (char letter : letters) {
            finalWord += letter;
        }
        System.out.println("THE FINAL WORD: " + finalWord);
        return finalWord;

    }

    /**
     * Recursive Merge Sort Algorithm Implementation
     * 
     * @param input inputted array
     * @param start starting Index
     * @param end   ending Index+1
     * 
     *              1. Algorithm checks if input is 1 element array because then we
     *              can start merging arrays
     * 
     *              2. Calculate all midpoints for next array both for the left and
     *              right side of array
     * 
     *              3. After calculating midpoints, merge arrays with those ranges
     *              of indicies in sorted order
     *
     *              4. Keep merging until we have reached the end of both sides of
     *              the original array
     * 
     *              5. Copy into main array
     * 
     */

    public static void mergeSort(int[] input, int start, int end) {
        // 1 element arr (break case)
        if (end - start < 2) {
            return;
        }

        // Calc mdpt of given arr
        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);

        // Merge sibling arr
        merge(input, start, mid, end);
        System.out.println(Arrays.toString(input));

    }

    public static void merge(int[] input, int start, int mid, int end) {
        // If last index of left arr is less than the last most value in the first index
        // then we can just leave the arr alone
        if (input[mid - 1] >= input[mid])
            return;

        int i = start; // Left partition index
        int j = mid; // Right partition index
        int tempIndex = 0; // Preserve insertion index

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            // depending on which value is less, the next index value will be from left or
            // right arr
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];

        }
        // Copy into one arr
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        // Insert into main arr
        System.arraycopy(temp, 0, input, start, tempIndex);

    }

}