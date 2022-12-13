import javax.swing.*;

/**
 * 
 *
 * @author Hudson Wesel
 * @version v1.0.0
 */

public class GUIinteractions {

    public void showInstructions(int selectedTask, JTextArea report, JTextField[] entry) {
        /*
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         * TO ADD NEW METHODS, WRITE INSTRUCTIONS HERE:
         * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
         */

        switch (selectedTask) {

            /*
             * CASE 0: "Select" is selected, so don't do anything!
             */
            case 0:
                break;

            case 1: {
                entry[0].setText("Phrase 1");
                entry[1].setText("Phrase 2");
                entry[2].setText("Phrase 3");
                entry[3].setText("javaCasing?");

                report.setText("Please Enter Three phrases. For the 4th box, if you want javaCase type yes!");
                break;
            }
            /*
             * CASE 2: Mr. Beckwith's silly TESTING METHOD IS SELECTED
             */
            case 2: {
                report.setText("Please Enter Three Heights.");

                entry[0].setText("Height 1");
                entry[1].setText("Height 2");
                entry[2].setText("Height 3");
                entry[3].setText("");

                break;
            }

            /*
             * CASE 3: THIS IS WHERE YOU START TO ADD YOURS
             */
            case 3: {
                report.setText("Give me a string and I will multiply by the number you put in the second box!");
                entry[0].setText("Phrase");
                entry[1].setText("Number of times phrase is multiplied ");
                entry[2].setText("");
                entry[3].setText("");

                break;
                // sets instructions
                // entry[0] = "EUHFUEHFEU";

            }

            case 4: {
                // phoneNumberFormatter
                report.setText("In Box 1: Please give me a phone nmber. \n" +
                        "In Box 2: Please give me a preferrred format by inputting a number 1-4 (inclusive) \n" +
                        "1: (###) ###-#### \n" +
                        "2: (###)###-#### \n" +
                        "3: ###-###-#### \n" +
                        "4: ###.###.####");
                entry[0].setText("Phone-Number");
                entry[1].setText("Format");
                entry[2].setText("");
                entry[3].setText("");
                break;

            }
            case 5: {
                report.setText(
                        "Please Input two numbers in the first two boxes and I will determine if they are almost prime :D \n"
                                +
                                "An almost prime is a composite number that has exactly two factors other than itself and they are both prime  ");
                entry[0].setText("First-Number");
                entry[1].setText("Second-Number");
                entry[2].setText("");
                entry[3].setText("");
                break;

            }

            case 6: {
                report.setText("Please input in the first box, your speed that you were driving. \n" +
                        "In the second box, input \'yes\' if it is your birthday!");

                entry[0].setText("Your Speed");
                entry[1].setText("Is It Your Birthday?");
                entry[2].setText("");
                entry[3].setText("");
                break;

            }
            case 7: {
                report.setText(
                        "Please enter any string containing any number of digits and I will take the sum of them!");
                entry[0].setText("Your Phrase With Digits!");
                entry[1].setText("");
                entry[2].setText("");
                entry[3].setText("");
                break;

            }
            case 8: {
                report.setText("Please enter yes or no in the following boxes \n" +
                        "Box 1: Is It Morning? \n" +
                        "Box 2: Is Your Mom Calling? \n" +
                        "Box 3: Are you Asleep? \n" +
                        "Box 4: Are You Grumpy?");

                entry[0].setText("isMorning?");
                entry[1].setText("isMomCalling?");
                entry[2].setText("isAsleep?");
                entry[3].setText("isGrumpy?");
                break;
            }
            case 9: {
                report.setText("Please enter a URL in the first box");
                entry[0].setText("URL");
                entry[1].setText("");
                entry[2].setText("");
                entry[3].setText("");
                break;

            }
            case 10: {
                report.setText(
                        "Please enter in box 1 an exponent. Please enter in box 2, the max number that the exponent will be raised to");
                entry[0].setText("Exponent");
                entry[1].setText("Max-Number");
                entry[2].setText("");
                entry[3].setText("");
                break;
            }
            case 11: {
                report.setText(
                        "Please enter three numbers, one for each box and I will determine if those length values could make a right triangle");
                entry[0].setText("First-Side-Length");
                entry[1].setText("Second-Side-Length");
                entry[2].setText("Third-Side-Length");
                entry[3].setText("");
                break;
            }
            case 12: {
                report.setText(
                        "Please enter in box 1 a number and I will calcualte the factorial \n" +
                                "(I calculated this using recursion because some of the (H) problems involve recursion and I needed a simple example to practice on");
                entry[0].setText("Number");
                entry[1].setText("");
                entry[2].setText("");
                entry[3].setText("");
            }

            // must leave this in:
            default:
                break;
        }
    }

    public void getAndShowResults(Tasks tasks, int selectedTask, JTextArea report,
            JTextField[] entry) {
        // Gets entries from boxes, calls methods sending argumentes, and sets text of
        // report with results

        // GET ALL ANSWERS FROM USER: GETTEXT() CAN ONLY RETURN STRINGS, SO CONVERT
        // LATER:
        String arg1 = entry[0].getText();
        String arg2 = entry[1].getText();
        String arg3 = entry[2].getText();
        String arg4 = entry[3].getText();

        String resultString; // use this for return values that are Strings
        int resultInt; // use this for return values that are integers
        boolean resultBool; // use this for return values that are booleans

        switch (selectedTask) {
            /*
             * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
             * TO ADD NEW METHODS, CALL THE METHOD HERE, GET THE RESULTS, AND SET THE TEXT
             * OF THE REPORT
             * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
             */

            /*
             * CASE 0: "Select" is selected, so don't do anything!
             */
            case 0:
                break;

            /*
             * CASE 1: Mr. Beckwith's silly SWITCHY METHOD IS SELECTED
             */
            case 1: {
                boolean isJava = false;
                if (arg4.toLowerCase().equals("yes") || (arg4.toLowerCase()).equals("y"))
                    isJava = true;

                String result = tasks.pythonJavaCase(arg1, arg2, arg3, isJava);
                report.setText(result);

                break;
            }

            /*
             * CASE 2: Mr. Beckwith's silly TESTING METHOD IS SELECTED
             */
            case 2: {
                // OKAY_LINE_UP
                resultBool = tasks.okayLineUp(Integer.parseInt(arg1), Integer.parseInt(arg2), Integer.parseInt(arg3));
                if (resultBool)
                    report.setText("True");
                report.setText("False");

                break;
            }

            /*
             * CASE 3: THIS IS WHERE YOU START TO ADD YOURS
             */
            case 3: {
                report.setText(tasks.multString(arg1, Integer.parseInt(arg2)));
            }

            case 4: {

                report.setText(tasks.phoneNumberFormatter(arg1, Integer.parseInt(arg2)));
                break;

            }

            case 5: {
                report.setText(tasks.almostPrime(Integer.parseInt(arg1), Integer.parseInt(arg2)));
                break;

            }
            case 6: {
                boolean isBirthday = false;
                if (arg2.toLowerCase().equals("yes") || arg2.charAt(0) == 'y')
                    isBirthday = true;
                report.setText(("Your Ticket Fine Is: " + tasks.getTicket(Integer.parseInt(arg1), isBirthday)));
                break;

            }
            case 7: {
                report.setText("Your Sum Of Digits Is: " + tasks.stringNumberSum(arg1));
                break;
            }
            case 8: {

                boolean boolarg1 = Utility.YayOrNay(arg1);
                boolean boolarg2 = Utility.YayOrNay(arg2);
                boolean boolarg3 = Utility.YayOrNay(arg3);
                boolean boolarg4 = Utility.YayOrNay(arg4);
                System.out.println("erwaoiuhfewauehfiwauefhw");
                report.setText("IJEOWIJFEOI");
                if (tasks.shouldAnswerCell(boolarg1, boolarg2, boolarg3, boolarg4)) {
                    report.setText("You answered the call!");
                } else {

                    report.setText("You did NOT answer the call!");
                }

                break;
                // report.setText)
            }
            case 9: {
                report.setText(tasks.fullURL(arg1));
                break;
            }
            case 10: {
                report.setText("" + tasks.sumOfPowers(Integer.parseInt(arg1), Integer.parseInt(arg2)));
                break;
            }
            case 11: {
                report.setText(
                        "Hypotenuse is: " + tasks.hypotenuse(Integer.parseInt(arg1), Integer.parseInt(arg2),
                                Integer.parseInt(arg3)));
                break;

            }

            case 12: {
                report.setText("Your Number's Factorial Is: " + tasks.factorial(Integer.parseInt(arg1)));
                break;
            }

            // must leave this in:
            default:
                break;
        }
    }
}
