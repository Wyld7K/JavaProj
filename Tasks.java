import java.math.BigInteger;
import java.util.*;

public class Tasks {
    /**
     * Depending on speed and isBirthday, will return a speeding ticket
     * 
     * @param speed
     * @param isBirthday
     * @return The price of the ticket
     */

    public int getTicket(int speed, boolean isBirthday) {

        int ticketValue = 0;

        if (isBirthday) { // if isBirthday adjust range of values for calculations
            if (speed <= 60) {
                ticketValue = 0;
                return ticketValue;
            }

            else if (speed >= 71 && speed <= 90) {
                ticketValue = speed * 2;
                return ticketValue;
            }

            else if (speed >= 91) {
                ticketValue = speed * 3;
                return ticketValue;
            }
        }
        // Not isBirthday
        if (speed <= 60) {
            ticketValue = 0;
            return ticketValue;

        }

        else if (speed >= 61 && speed <= 80) {
            ticketValue = speed * 2;
            return ticketValue;
        }

        else if (speed >= 81)
            ticketValue = speed * 3;
        return ticketValue;

    }

    /**
     * Gets three strings from user and whether they want python or java casing and
     * formats a string as such
     * 
     * @param firstString
     * @param secondString
     * @param thirdString
     * @param isJava
     * @return A string in either python or java casing
     */
    public String pythonJavaCase(String firstString, String secondString, String thirdString, boolean isJava) {
        // returns: the 3 Strings combined as either camelCase or python_case and with
        // any of the following illegal characters removed: . ! ? < >
        // (if the last argument is true, it is Java, if false, Python)

        // If is python casing
        if (!isJava) {
            firstString = firstString.toLowerCase();
            secondString = secondString.toLowerCase();
            thirdString = thirdString.toLowerCase();

            // Adding _ for python casing
            firstString += "_";
            secondString += "_";

        } else {
            // Set secondString and thirdString as starting letter upper case
            secondString = (Character.toString(secondString.charAt(0))).toUpperCase() + secondString.substring(1);
            thirdString = (Character.toString(thirdString.charAt(0))).toUpperCase() + thirdString.substring(1);

        }

        String finalString = firstString + secondString + thirdString;

        // Filtering illegal chars
        List<Character> illegalChars = new ArrayList<Character>(
                Arrays.asList(new Character[] { '.', '!', '?', '<', '>' }));

        String copy = new String(finalString); // Deep copy to iterate with | other array adjusted throughout forloop
        for (int i = 0; i < copy.length() - 1; i++) {

            if (illegalChars.contains(copy.charAt(i))) { // Does contain illegal char?

                finalString = finalString.replace(Character.toString(copy.charAt(i)), "");

            }
        }
        return finalString;
    }

    /**
     * Gets a string from user conatining digits and takes the sum of them
     * 
     * @param str
     * @return The sum of DIGITS in a string
     */

    public int stringNumberSum(String str) {
        int sum = 0; // Beginning Sum

        char currentChar = '\u0000'; // Intialize currentChar
        for (int i = 0; i < str.length(); i++) {
            currentChar = str.charAt(i);
            try { // Using try catch so that when I convert each letter I avoid an error
                int currentInt = Integer.parseInt(Character.toString(currentChar));
                sum += currentInt;
            } catch (Exception e) {
                // If error just go to next letter
            }
        }
        return sum;
    }

    /**
     * Given 4 inputs via (yes or no) determines if cell should be answered
     * 
     * @param isMorning
     * @param isMom
     * @param isAsleep
     * @param isGrumpy
     * @return Whether someone should answer their phone call
     */
    public boolean shouldAnswerCell(boolean isMorning, boolean isMom, boolean isAsleep, boolean isGrumpy) {

        if (!(isAsleep)) { // isAsleep? --> Otherwise never answer cell
            if (isMorning && isMom) { // Only answer in morning if isMom
                return true;
            } else if (!(isMorning || isGrumpy)) // !isMorning && !isGrumpy
                return true;
        }
        return false;
    }

    /**
     * Recieves three heights and determines if they are in ascending order
     * 
     * @param height1
     * @param height2
     * @param height3
     * @return Whether or not the three heights are in ascending order
     */

    public boolean okayLineUp(double height1, double height2, double height3) {
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

    /**
     * Takes a string and multiplies it by numTimes
     * 
     * @param text
     * @param numTimes
     * @return Inputted string multiplied numTimes
     */
    public String multString(String text, int numTimes) {
        String result = "";
        for (int i = 0; i < numTimes; i++) {
            result += text;
        }
        return result;
    }

    /**
     * Given a phoneNumber and format(nums 1-4), formats phone number
     * 
     * @param phoneNumber
     * @param formatType
     * @return A phoneNumber in specific format
     */
    public String phoneNumberFormatter(String phoneNumber, int formatType) {
        switch (formatType) {
            case 1:
                // Format: (###) ###-####
                String phoneCopy = phoneNumber;
                // () with space
                return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-"
                        + phoneNumber.substring(6);

            case 2:
                // Format: (###)###-####
                return "(" + phoneNumber.substring(0, 3) + ")" + phoneNumber.substring(3, 6) + "-"
                        + phoneNumber.substring(6);
            case 3:
                return phoneNumber;
            case 4:
                // Format: ###-###-####
                return phoneNumber.substring(0, 3) + "-" +
                        phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
            default:
                // Format: ###.###.####;
                return phoneNumber.substring(0, 3) + "." +
                        phoneNumber.substring(3, 6) + "." + phoneNumber.substring(6);
        }

    }

    /**
     * UTILITY
     * Determines if number is prime (used in findFactors)
     * 
     * @param num
     * @return Whether number is prime
     */

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

    /**
     * * UTILITY
     * Finds factors of number (used in almost prime)
     * 
     * @param num
     * @return List of factors for inputted number
     */
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

    /**
     * Recieves min and max from user and determines if any nums in that range are
     * 'almost prime'
     * Almost Prime Num = num whose factors are prime
     * 
     * @param min
     * @param max
     * @return Whether a range of numbers is almostPrime
     */
    public String almostPrime(int min, int max) {
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

    // OMG PRIMESTRING
    /*
     * b. swapSequence()
     * Given two strings, your task is to find out if there is a swap sequence that
     * transforms the first string into the second string. A swap sequence is a
     * sequence of strings, such that for each two consecutive strings in the list,
     * each one can be obtained from the previous one after a swap of two
     * characters.
     *
     * Your method will return the list of words, each with one swap, that need to
     * occur to achieve the second string
     * 
     * Example: (I've underlined the swaps to help you understand the problem)
     * 
     * • swapSequence("are", "ear") could return: "are, aer, ear"
     * 
     * • swapSequence("needs", "dense") could return:
     * "needs, nedes, ndees, dnees, denes, dense"
     * • swapSequence("needs", "nerds") would return: "no swap possible"
     * • swapSequence("needs", "neds") would return: "no swap possible" (easy to
     * find this one out!)
     * 
     * (other ones to check: cat/act, last/salt, limped/dimple,
     * introduces/reductions
     * 
     */
    /*
     * g. primeString()
     * a String made up only repeated substrings is called "composite", otherwise it
     * is a "prime string"
     * 
     * primeString() returns true if the string argument sent to it is a prime
     * string and false otherwise
     * 
     * This is best seen through examples:
     * primeString("hello") returns true
     * prime, since the "l" repeats, but "hello" is not only made of repeats
     * 
     * primeString("mississippi") returns true
     * prime, since there are some repeats,but it's not only made of repeats
     * 
     * primeString("BoraBora") returns false
     * composite, since it’s just "Bora" + "Bora"
     * 
     * primeString("HackHackcodecode") returns false
     * composite, since it's just "Hack" + "Hack" and "code" + "code"
     * 
     * primeString("HackcodeHackcode") returns false
     * composite, since it's just "Hackcode" + "Hackcode"
     * 
     * primeString("HackHackcode") returns true
     * prime since "code" only appears once, there is no way to write it as repeats
     * only
     * 
     * 
     */
    public boolean primeString(String mainString, String str) {

        if (str.equals(mainString))
            return false;

        if (str.indexOf(str, str.indexOf(str) + 1) == -1) {
            return true;
        }
        return primeString(mainString, str.substring(0, str.length() + 1));

    }

    public String fullURL(String websiteName) {
        if (websiteName.contains("http://www."))
            return websiteName;
        if (websiteName.contains("www."))
            return "http://" + websiteName;
        if (!websiteName.contains("."))
            return "Bad Address";
        return "http://www." + websiteName;
    }

    public long sumOfPowers(int exp, int numOfTerms) {

        long sumOfPowers = 0;
        // the sum of of the consecutive powers of integers up to numberOfTerms; the
        for (int i = 1; i < numOfTerms + 1; i++) {
            System.out.println((long) Math.pow(i, exp));
            sumOfPowers += (long) Math.pow(i, exp);
        }
        return sumOfPowers;
    }

    public double hypotenuse(int a, int b, int c) {

        if (Math.pow(a, 2) >= (Math.pow(b, 2) + Math.pow(c, 2))) {

            return Math.pow(a, 2);
        } else if (Math.pow(b, 2) >= (Math.pow(a, 2) + Math.pow(c, 2))) {

            return Math.pow(b, 2);
        } else if (Math.pow(c, 2) >= (Math.pow(a, 2) + Math.pow(b, 2))) {

            return Math.pow(c, 2);
        }
        return -1;
    }

    public BigInteger factorial(long num) {
        // Base Case
        if (num == 0)
            return new BigInteger(1 + "");
        // Big integer uses strings as parameters

        BigInteger factorial = new BigInteger(((factorial(num - 1)).multiply(new BigInteger(num + ""))) + "");
        return factorial;
    }

    public String isPlainDrome(int num) {
        if (num / 10 == 0)
            return "Yes Is Plaindrome";
        // 20
        // 22
        // 24
        int newNum = (10 * (num % 10)) + num / 10;
        if (newNum == num)
            return "Yes Is Plaindrome";

        isPlainDrome(num / 10);
        return "No is not palindrome";
    }

}
