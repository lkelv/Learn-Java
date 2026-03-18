import edu.monash.fit2099.devices.*;
import edu.monash.fit2099.loaders.DeviceLoader;

import java.util.ArrayList;
import java.util.Scanner;


public class SmartHomeDriver {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //Load the IOT Ecosystem
        DeviceLoader loader = new DeviceLoader();
        ArrayList<SmartDevice> devices = loader.getAllDevices();
        ArrayList<SmartHeater> heaters = loader.getAllHeaters();
        ArrayList<SmartLighting> lightingDevices = loader.getAllLightingDevices();
        ArrayList<SmartSwitch> switches = loader.getAllSmartSwitches();

        //LOAD CONTROL MENU
        int selection;
        do {
            selection = menuItem();
            switch (selection) {
                case 1:
                    for(SmartDevice device : devices)
                        device.turnOn();
                    break;
                case 2:
                    for(SmartDevice device : devices)
                        device.turnOff();
                    break;
                case 3:
                    for(SmartDevice device : devices)
                        device.display();
                    break;
                case 4:
                    System.out.print("Type the colour:");
                    String colour = input.nextLine();
                    //perform some input validation here
                    for(SmartLighting light : lightingDevices) {
                        light.setColour(colour);
                    }

                    for(SmartSwitch sw : switches) {
                        for(SmartLighting light1 : sw.getSmartLightingList())
                            light1.setColour(colour);
                    }
                    break;
                case 5:
                    System.out.print("Type the temperature:");
                    int temp = Integer.parseInt(input.nextLine());
                    for(SmartHeater heater : heaters) {
                        heater.setTemperature(temp);
                    }
                    break;
                case 0:
                    System.exit(0);
            }


        } while (selection != 7);
    }

    public static int menuItem() {
            Scanner sel = new Scanner(System.in);

            System.out.println("+-------------------------------------+");
            System.out.println("|            Welcome to the           |");
            System.out.println("|      Smart Home control system      |");
            System.out.println("+-------------------------------------+");

            System.out.println("1) Turn all devices ON");
            System.out.println("2) Turn all devices OFF");
            System.out.println("3) Display status of all devices");
            System.out.println("4) Change lighting colour");
            System.out.println("5) Set home temperature");


            System.out.println("0) Exit");
            System.out.print("Select an option:");
            int choice = Integer.parseInt(sel.nextLine()); // try catch must be added
            return choice;
        }



}
