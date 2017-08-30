package domotica.command;
import domotica.model.*;



public class setKitchenDoorOpen implements Command {
	Kitchen room;

	public setKitchenDoorOpen(Kitchen Kitchen){
		this.room = Kitchen;
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
