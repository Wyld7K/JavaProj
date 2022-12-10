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

    public static boolean shouldAnswerCell(boolean isMorning, boolean isMom, boolean isAsleep, boolean isGrumpy) {

        if (!(isAsleep)) {
            if (isMorning && isMom) {
                return true;
            } else if (!(isMorning || isGrumpy))
                return true;
        } else {

            return false;
        }
        return false;
    }

    // 13 & 14. Make up two of your own methods which take arguments, do something
    // interesting with them, and then return some value

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

    public static boolean isPrime(int num) {
        if (num != 2) {
            if (num % 2 == 0)
                return false;
            else {
                long end = (long) (Math.sqrt(num) + 1);
                for (long divisor = 3; divisor <= end; divisor += 2) {
                    if (num % divisor == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static ArrayList<String> findFactors(int num) {
        ArrayList<String> factors = new ArrayList<>();

        for (int i = num; i > 0; i--) {
            for (int j = 1; j < num; j++) {
                boolean isNotOne = (j != 1) && (i != 1);
                boolean isPrimes = isPrime(i) && isPrime(j);
                boolean isFactors = (j * i == num);
                if (isNotOne && isPrimes && isFactors)
                    factors.add(((num / i) + " " + i));
            }
        }

        return (ArrayList<String>) factors;

    }

    public static String almostPrime(int min, int max) {
        ArrayList<ArrayList<String>> factors = new ArrayList<ArrayList<String>>();
        for (int i = min; i < max; i++) {
            if ((findFactors(i).size() != 0)) {
                factors.add(findFactors(i));
            }
        }
        System.out.println(factors);
        if (factors.size() > 0)
            return "YES! ALMOST PRIME!";
        return "NO! Not Prime...";
    }

    public static String multString(String text, int numTimes) {
        String result = "";
        for (int i = 0; i < numTimes; i++) {
            result += text;
        }
        return result;
    }

    public static boolean primeString(String mainStr, String str) {
        int multCount = 0;

        if (str.length() % 2 == 0 && str.indexOf(str, (str.indexOf(str) + 1)) != -1) {
            multCount = str.length() / 2;
            if (multString(str, multCount).equals(mainStr))
                return false;

        }

        primeString(mainStr, str.substring(0, str.length() - 1));

        return true;
    }

    public static void main(String[] args) {
        // System.out.println(primeString("hello", "hell"));
        // System.out.println(primeString("BoraBora", "BoraBor"));
        System.out.println(shouldAnswerCell(false, false, false, false));
        System.out.println(shouldAnswerCell(false, false, true, false));
        System.out.println(shouldAnswerCell(true, false, false, false));
        System.out.println(shouldAnswerCell(false, false, false, true));

    }

}
