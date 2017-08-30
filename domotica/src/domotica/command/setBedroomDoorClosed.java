package domotica.command;
import domotica.model.*;



public class setBedroomDoorClosed implements Command {
	Bedroom room;

	public setBedroomDoorClosed(Bedroom Bedroom){
		this.room = Bedroom;
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
