package domotica.command;
import domotica.model.*;



public class setLivingDoorClosed implements Command {
	Living room;

	public setLivingDoorClosed(Living Living){
		this.room = Living;
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
