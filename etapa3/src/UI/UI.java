package UI;

import java.util.HashMap;
import java.util.Map;

import domain.Database;

public class UI {
	
	private static Map<Integer, UICommand> commands;
	
	public static void main(String[] args) {
		Database.initialize();
		initializeCommandsMap();
		
		//UICommand teste = new AllocationCommand();
		//teste.execute();
	}
	
	public Integer getCommand() {
		return null;
	}
	
	private static void initializeCommandsMap() {
		commands = new HashMap<>();
		commands.put(1, new AllocationCommand());
		commands.put(2, new EvaluationCommand());
		commands.put(3, new ReportCommand());
	}

}
