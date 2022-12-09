import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class testMethods {
    public static String pythonJavaCase(String firstString, String secondString, String thirdString, boolean isJava) {
        // returns: the 3 Strings combined as either camelCase or python_case and with
        // any of the following illegal characters removed: . ! ? < >
        // (if the last argument is true, it is Java, if false, Python)

        if (!isJava) {
            firstString += "_";
            secondString += "_";

        }
        String finalString = firstString + secondString + thirdString;

        List<Character> illegalChars = new ArrayList<Character>(
                Arrays.asList(new Character[] { '.', '!', '?', '<', '>' }));
        String copy = new String(finalString); // Deep copy to not
        for (int i = 0; i < copy.length() - 1; i++) {
            if (illegalChars.contains(copy.charAt(i))) {
                finalString = finalString.replace(Character.toString(copy.charAt(i)), "");

            }
        }

        return finalString;
    }

    public static int getTicket(int speed, boolean isBirthday) {

        int ticketValue = 0;
        if (isBirthday) {
            if (speed <= 60)
                ticketValue = 0;

            else if (speed >= 71 && speed <= 90)
                ticketValue = speed * 2;

            else if (speed >= 91)
                ticketValue = speed * 3;
        }
        if (speed <= 60)
            ticketValue = 0;

        else if (speed >= 61 && speed <= 80)
            ticketValue = speed * 2;

        else if (speed >= 81 && !isBirthday)
            ticketValue = speed * 3;
        return ticketValue;

    }

    public static int stringNumberSum(String str) {
        int sum = 0;
        char currentChar = '\u0000';
        for (int i = 0; i < str.length(); i++) {
            currentChar = str.charAt(i);
            try {
                int currentInt = Integer.parseInt(Character.toString(currentChar));
                sum += currentInt;
            } catch (Exception e) {

            }
        }
        return sum;
    }

    public static boolean fourFitInOne(int int1, int int2, int int3, int int4) {
        // Find largest value
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(int1);
        nums.add(int2);
        nums.add(int3);
        nums.add(int4);

        int max = Collections.max(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum -= max;

        if (sum < max)
            return true;
        return false;
    }

    public static boolean okayLineUp(double height1, double height2, double height3) {
        ArrayList<Double> heights = new ArrayList<>();

        heights.add(height1);
        heights.add(height2);
        heights.add(height3);

        for (int i = 1; i < heights.size(); i++) {
            if (heights.get(i - 1) < heights.get(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;

    }

    public static String phoneNumberFormatter(String phoneNumber, int formatType) {
        switch (formatType) {
            case 1:
                String phoneCopy = phoneNumber;
                // () with space
                return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-"
                        + phoneNumber.substring(6);

            case 2:
                return "(" + phoneNumber.substring(0, 3) + ")" + phoneNumber.substring(3, 6) + "-"
                        + phoneNumber.substring(6);
            case 3:
                return phoneNumber;
            case 4:
                return phoneNumber.substring(0, 3) + "-" +
                        phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
            default:
                return phoneNumber.substring(0, 3) + "." +
                        phoneNumber.substring(3, 6) + "." + phoneNumber.substring(6);
        }

    }

    // ISPRIMESTRING

    // Composite if only made up of repeating units
    // Prime if NOT made up of ONLY repeating units
    // BoraBora --> (Composite)

    // hello --> (Prime)

    // l --> (Composite)

    // public static
    public static String[] swap(String[] strArr, int i, int j) {
        String temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
        return strArr;

    }

    public static String reverseString(String str) {
        String temp[] = str.split("\\s+");
        temp = swap(temp, 0, temp.length - 1);
        return temp[0] + temp[1];
    }

    public static ArrayList<String> findFactors(int num) {
        ArrayList<String> factors = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (num % i == 0) {
                // if()
                factors.add(((num / i) + " " + i));
            }
        }
        ArrayList<String> factorsCopy = (ArrayList<String>) factors.clone();

        factors.forEach((ogstrEl) -> {
            factorsCopy.forEach((strEl) -> {
                System.out.println(ogstrEl);
                System.out.println((reverseString(ogstrEl)));
                if ((reverseString(ogstrEl)).equals(strEl))
                    factors.remove(ogstrEl);
            });
        });

        return (ArrayList<String>) factors;

    }

    public static String almostPrime(int min, int max) {
        ArrayList<ArrayList<String>> factors = new ArrayList<ArrayList<String>>();
        for (int i = min; i < max; i++) {
            factors.add(findFactors(i));
        }
        System.out.println(factors);

        if (factors.size() > 0)
            return "YES! ALMOST PRIME!";
        return "NO! Not Prime...";
    }

    public static boolean isPrimeString(String str, int start, int mid, int end) {
        String repeatingString = (str.substring(start, mid) + str.substring(mid, end));
        if (repeatingString.indexOf(str, mid) != -1)
            return false;
        return true;

    }

    public static boolean midPrimeString(String str, int start, int end) {

        if (end - start < 2)
            return false;

        int mid = (start + end) / 2;
        midPrimeString(str, start, mid);
        midPrimeString(str, mid, end);
        return isPrimeString(str, start, mid, end);

    }

    public static void main(String[] args) {
        // System.out.println(testMethods.pythonJavaCase("hel>?!", "goodbye", "giraffe",
        // false));
        // System.out.println(stringNumberSum("He1l3E"));
        // System.out.println(testMethods.fourFitInOne(1, 2, 3, 40));
        // System.out.println(testMethods.phoneNumberFormatter("1112223333", 1));
        // System.out.println(testMethods.okayLineUp(1.0, 20.0, 3.0));
        // String str = "BoraBora";
        // System.out.println(midPrimeString(str, 0, str.length()));
        almostPrime(10, 20);
    }

}
