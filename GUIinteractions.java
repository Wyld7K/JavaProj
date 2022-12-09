import javax.swing.*;

/**
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
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

                System.out.println("ALIGINIregreNG");
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
                String result = tasks.multString(arg1, Integer.parseInt(arg2));
                report.setText(result);
            }

            case 4: {
                String result = tasks.phoneNumberFormatter(arg1, Integer.parseInt(arg2));
                report.setText(result);

                break;

            }

            case 5: {

            }
            // must leave this in:
            default:
                break;
        }
    }
}
