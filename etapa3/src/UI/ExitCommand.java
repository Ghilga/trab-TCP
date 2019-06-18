package UI;

public class ExitCommand extends Command {
	public void execute() {
		ui.isRunning = false;
	}
}
