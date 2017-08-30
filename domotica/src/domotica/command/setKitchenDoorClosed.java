package domotica.command;
import domotica.model.*;



public class setKitchenDoorClosed implements Command {
	Kitchen room;

	public setKitchenDoorClosed(Kitchen Kitchen){
		this.room = Kitchen;
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
