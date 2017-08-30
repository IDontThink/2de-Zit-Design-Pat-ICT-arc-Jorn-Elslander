package domotica.command;
import domotica.model.*;



public class setBedroomDoorOpen implements Command {
	Bedroom room;

	public setBedroomDoorOpen(Bedroom Bedroom){
		this.room = Bedroom;
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
