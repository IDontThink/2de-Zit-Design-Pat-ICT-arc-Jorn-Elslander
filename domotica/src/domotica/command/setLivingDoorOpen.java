package domotica.command;
import domotica.model.*;



public class setLivingDoorOpen implements Command {
	Living room;

	public setLivingDoorOpen(Living Living){
		this.room = Living;
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
