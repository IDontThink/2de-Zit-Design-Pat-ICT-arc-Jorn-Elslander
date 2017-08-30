package domotica.test;
import domotica.command.*;

import java.util.*;

import domotica.model.*;
import domotica.view.*;

public class Test {

	private static Random random = new Random();

	private static int randomInt(int lo, int hi) {
		return lo + random.nextInt(hi - lo + 1);
	}

	private static float randomFloat(float lo, float hi) {
		return lo + random.nextFloat() * (hi - lo);
	}

	private static void round(House house) throws DomoticaException {
		{
			Living living = house.getLiving();
			living.setAircoTemperature(randomInt(15, 25));
			living.setLightLevel(randomFloat(0, 1));
			living.setRollerShutterDown(!living.isRollerShutterDown());
			living.setDoorsClosed(!living.isDoorClosed());
			living.setTvSwitchedOn(!living.isTvSwitchedOn());
			living.setTvChannel(randomInt(0, 99));
			living.setTvVolume(randomInt(0, 10));
		}
		{
			Kitchen kitchen = house.getKitchen();
			kitchen.setAircoTemperature(randomInt(15, 25));
			kitchen.setLightLevel(randomFloat(0, 1));
			kitchen.setRollerShutterDown(!kitchen.isRollerShutterDown());
			kitchen.setDoorsClosed(!kitchen.isDoorClosed());
			kitchen.setCooktopSwitchedOn(!kitchen.isCooktopSwitchedOn());
			kitchen.setExtractorHoodSwitchedOn(!kitchen.isExtractorHoodSwitchedOn());
			kitchen.setRefrigeratorTemperature(randomInt(1, 15));
			kitchen.setFreezerTemperature(randomInt(-15, -1));
		}
		{
			Bathroom bathroom = house.getBathroom();
			bathroom.setAircoTemperature(randomInt(15, 25));
			bathroom.setLightLevel(randomFloat(0, 1));
			bathroom.setRollerShutterDown(!bathroom.isRollerShutterDown());
			bathroom.setDoorsClosed(!bathroom.isDoorClosed());
			bathroom.setShowerTemperature(randomInt(10, 60));
			bathroom.setShowerFlowLevel(randomFloat(0, 1));
			bathroom.setTapTemperature(randomInt(10, 60));
			bathroom.setTapFlowLevel(randomFloat(0, 1));
		}
		{
			Bedroom bedroom = house.getBedroom();
			bedroom.setAircoTemperature(randomInt(15, 25));
			bedroom.setLightLevel(randomFloat(0, 1));
			bedroom.setRollerShutterDown(!bedroom.isRollerShutterDown());
			bedroom.setDoorsClosed(!bedroom.isDoorClosed());
			bedroom.setAlarmSwitchedOn(!bedroom.isAlarmSwitchedOn());
			bedroom.setWaterbedTemperature(randomInt(10, 30));
		}
	}

	public static void main(String[] args) throws DomoticaException {
		House house = new House("house");
		new HouseView(house);
		for (int i = 0; i < 100; i++) {
			round(house);
		}
		
		TestCommandPat(house);
		
		
	}
	
	public static void TestCommandPat(House house){
		DoorController doorController = new DoorController();
		Command setBathroomDoorClosed = new setBathroomDoorClosed(house.getBathroom());
		Command setBathroomDoorOpen = new setBathroomDoorOpen(house.getBathroom());
		Command setBedroomDoorClosed = new setBedroomDoorClosed(house.getBedroom());
		Command setBedroomDoorOpen = new setBedroomDoorOpen(house.getBedroom());
		Command setKitchenDoorClosed = new setKitchenDoorClosed(house.getKitchen());
		Command setKitchenDoorOpen = new setKitchenDoorOpen(house.getKitchen());
		Command setLivingDoorClosed = new setLivingDoorClosed(house.getLiving());
		Command setLivingDoorOpen = new setLivingDoorOpen(house.getLiving());
		doorController.setCommand(0, setBathroomDoorClosed, setBathroomDoorOpen);
		doorController.setCommand(1, setBedroomDoorClosed, setBedroomDoorOpen);
		doorController.setCommand(2, setKitchenDoorClosed, setKitchenDoorOpen);
		doorController.setCommand(3, setLivingDoorClosed, setLivingDoorOpen);
		
		Random rand = new Random();
		int i = rand.nextInt(4);		
		
		doorController.executeCloseCommand(i);
		doorController.executeOpenCommand(i);
		
	}

}
