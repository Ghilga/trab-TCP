package UI;

import java.util.HashMap;
import java.util.Map;

import domain.Database;
import domain.Evaluation;

public class UI {
	
	private static Map<Integer, UICommand> commands;
	private static UICommand selectedCommand;
	
	public static void main(String[] args) {
		Database.initialize();
		initializeCommandsMap();
		while(!(selectedCommand instanceof ExitCommand)) {
			printMenu();
			selectedCommand = getCommand();
			selectedCommand.execute();
		}
		ApplicationIO.closeScanner();
	}
	
	private static UICommand getCommand() {
		System.out.println("Selecione a funcionalidade:");
		int input;

		do {
			input = ApplicationIO.readInteger();
			if(input < 1 || input > commands.size())
				System.out.println("Opção invalida! Selecione um numero entre 1 e 3:");
			
		}while(input < 1 || input > commands.size());
		
		return commands.get(input);
	}
	
	private static void initializeCommandsMap() {
		commands = new HashMap<>();
		commands.put(1, new AllocationCommand());
		commands.put(2, new EvaluationCommand());
		commands.put(3, new ReportCommand());
		commands.put(4, new ExitCommand());
	}
	
	private static void printMenu(){
		for (int i = 1; i <= commands.size(); i++) {
			System.out.println(i + " - " + commands.get(i).toString());
		}
		
	}

}
