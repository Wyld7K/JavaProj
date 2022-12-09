import java.util.*;

public class Tasks {

    public String pythonJavaCase(String firstString, String secondString, String thirdString, boolean isJava) {
        // returns: the 3 Strings combined as either camelCase or python_case and with
        // any of the following illegal characters removed: . ! ? < >
        // (if the last argument is true, it is Java, if false, Python)

        if (!isJava) {
            firstString = firstString.toLowerCase();
            secondString = secondString.toLowerCase();
            thirdString = thirdString.toLowerCase();

            firstString += "_";
            secondString += "_";

        } else {
            secondString = (Character.toString(secondString.charAt(0))).toUpperCase() + secondString.substring(1);
            thirdString = (Character.toString(thirdString.charAt(0))).toUpperCase() + thirdString.substring(1);

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

    public String multString(String text, int numTimes) {
        String result = "";
        for (int i = 0; i < numTimes; i++) {
            result += text;
        }
        return result;
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

}
