package domotica.command;
import domotica.model.*;



public class setBathroomDoorClosed implements Command {
	Bathroom room;

	public setBathroomDoorClosed(Bathroom bathroom){
		this.room = bathroom;
	}
	public void execute() {
		try {
			room.setDoorsClosed(true);
		} catch (ElectricityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
