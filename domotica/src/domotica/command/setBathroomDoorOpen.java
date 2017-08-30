package domotica.command;
import domotica.model.*;



public class setBathroomDoorOpen implements Command {
	Bathroom room;

	public setBathroomDoorOpen(Bathroom bathroom){
		this.room = bathroom;
	}
	public void execute() {
		try {
			room.setDoorsClosed(false);
		} catch (ElectricityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
