package edu.monash.fit2099.loaders;
import edu.monash.fit2099.devices.*;

import java.util.ArrayList;

public class DeviceLoader {

    private ArrayList<SmartDevice> allDevices;
    private ArrayList<SmartLighting> allLightingDevices;
    private ArrayList<SmartSwitch> allSmartSwitches;
    private ArrayList<SmartHeater> allHeaters;

    public ArrayList<SmartDevice> getAllDevices() {
        return allDevices;
    }

    public ArrayList<SmartLighting> getAllLightingDevices() {
        return allLightingDevices;
    }

    public ArrayList<SmartSwitch> getAllSmartSwitches() {
        return allSmartSwitches;
    }

    public ArrayList<SmartHeater> getAllHeaters() {
        return allHeaters;
    }

    public DeviceLoader() {
        allDevices=new ArrayList<>();
        allLightingDevices=new ArrayList<>();
        allSmartSwitches=new ArrayList<>();
        allHeaters=new ArrayList<>();
        LoadDevices();
    }

    private ArrayList<SmartDevice> LoadDevices()
    {
        //SETUP IOT Ecosystem

        //Smart switch
        SmartSwitch switch1= new SmartSwitch("128.1.1.1",false);
        this.allDevices.add(switch1);
        SmartLighting d1 = new SmartLighting("128.1.1.2",false,"red","dimmable");
        SmartLighting d2 = new SmartLighting("128.1.1.3",false,"blue", "nonDimmable");
        SmartLighting d3 = new LedStripe("128.1.1.9",false,"green","nonDimmable");
        switch1.addLightingDevice(d1);
        switch1.addLightingDevice(d2);
        switch1.addLightingDevice(d3);
        this.allSmartSwitches.add(switch1);

        //Smart TV
        this.allDevices.add(new SmartTV("128.1.1.4", false));

        //Heaters
        SmartHeater heater1 = new SmartHeater("128.1.1.5", false);
        this.allDevices.add(heater1);
        this.allHeaters.add(heater1);
        SmartHeater heater2= new SmartHeater("128.1.1.6", false);
        this.allDevices.add(heater2);
        this.allHeaters.add(heater2);

        //LED stripe
        LedStripe stripe1 = new LedStripe("128.1.1.7",false,"yellow", "dimmable");
        this.allDevices.add(stripe1);
        stripe1.attachLedStripe(new LedStripe("128.1.1.8",false,"yellow", "dimmable"));
        this.allLightingDevices.add(stripe1);

        return this.allDevices;
    }
}