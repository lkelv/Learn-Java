package edu.monash.fit2099.devices;

import java.util.ArrayList;

public class SmartSwitch extends SmartDevice {

    //private attributes
    private ArrayList<SmartLighting> smartLightings;

    //constructor
    public SmartSwitch(String _ipAddress, boolean _status) {
        super(_ipAddress, _status);
        this.smartLightings = new ArrayList<>();
    }

    //getters and setters
    public void addLightingDevice(SmartLighting _smartLighting) {
        this.smartLightings.add(_smartLighting);
    }

    public ArrayList<SmartLighting> getSmartLightingList(){
        return this.smartLightings;
    }

    //Other methods
    public void turnOn() {
        super.setStatus(true);
        System.out.println("The SmartSwitch at "+ super.getIpAddress() +" was turned ON succesfully");
        for (SmartLighting light : smartLightings
        ) {
            light.turnOn();
        }
    }

    public void turnOff() {
        super.setStatus(false);
        System.out.println("The SmartSwitch at "+ super.getIpAddress() +" was turned OFF succesfully");
        for (SmartLighting light : smartLightings
        ) {
            light.turnOff();
        }
    }



    public double getTotalConsumptionToday() {
        double totalConsumption = 0;
        totalConsumption += super.getConsumptionToday();
        for (SmartLighting smartbulb : smartLightings
        ) {
            totalConsumption += smartbulb.getConsumptionToday();
        }
        return totalConsumption;
    }

    public void display() {
        System.out.println("SmartSwitch  at " + super.getIpAddress() + " is on: " + super.getStatus() + " Today's consumpion: " + super.getConsumptionToday());

        for (SmartLighting smartLighting : this.getSmartLightingList()) {
            smartLighting.display();
        }
    }




}
