package domotica.command;


public class DoorController {
	Command[] closeCommands;
	Command[] openCommands;
	Command NoCommand;
	
	
	public DoorController() {
		closeCommands = new Command[4];
		openCommands = new Command[4];
		Command noCommand = new NoCommand();
		
		for(int i=0; i<4;i++){
			closeCommands[i] = noCommand;
			openCommands[i] = noCommand;
		}
	}
	
	public void setCommand(int slot, Command closeCommand, Command openCommand){
		closeCommands[slot] = closeCommand;
		openCommands[slot] = openCommand;
	}
	
	public void executeCloseCommand(int slot){
		closeCommands[slot].execute();
	}
	
	public void executeOpenCommand(int slot){
		openCommands[slot].execute();
	}
	

}
