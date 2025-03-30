package budgetbuddy.parser;

import budgetbuddy.exception.InvalidInputException;

/**
 * Parses the "editExpense" command to extract index, amount, description, and time.
 * Supports optional parameters: a/, d/, t/
 */
public class EditExpenseParser extends Parser<String[]> {
    public EditExpenseParser(String input) {
        super(input);
    }

    @Override
    public String[] parse() throws InvalidInputException {
        String[] result = {"", "", "", ""};
        String[] parts = input.split(" ", 3);
        if (parts.length < 3 || !parts[0].equals("editExpense")) {
            throw new InvalidInputException("Use: editExpense <INDEX> a/ <AMOUNT> d/ <DESCRIPTION> t/ <DATE TIME>");
        }
        if (!parts[1].matches("\\d+")) {
            throw new InvalidInputException("Invalid index.");
        }
        result[0] = parts[1];
        String remaining = parts[2];
        if (remaining.contains("a/")) {
            String a = remaining.split("a/", 2)[1].split("d/|t/", 2)[0].trim();
            result[1] = a;
            remaining = remaining.replace("a/" + a, "");
        }
        if (remaining.contains("d/")) {
            String d = remaining.split("d/", 2)[1].split("t/", 2)[0].trim();
            result[2] = d;
            remaining = remaining.replace("d/" + d, "");
        }
        if (remaining.contains("t/")) {
            String t = remaining.split("t/", 2)[1].trim();
            result[3] = t;
        }
        return result;
    }
}