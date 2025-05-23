package budgetbuddy.command;

import budgetbuddy.model.BudgetManager;
import budgetbuddy.ui.Ui;

/**
 * The HelpCommand class represents a command that displays a help message to the user.
 *
 * <p>This command provides a summary of all available commands, including their format and examples of usage.</p>
 */
public class HelpCommand extends Command {

    public HelpCommand(String description) {
        super(description);
    }

    /**
     * Executes the HelpCommand by printing a help message to the user.
     *
     * <p>This method interacts with the {@link Ui} class to display the available commands and their formats.</p>
     *
     * @param budgetManager The BudgetManager responsible for managing budgets and expenses (not used in this case).
     */
    @Override
    public void execute(BudgetManager budgetManager) {
        Ui.printHelpMessage();  // Print the help message
    }

    /**
     * Returns {@code false} as this command does not exit the program.
     *
     * @return {@code false} to indicate that the program should not exit after executing this command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
