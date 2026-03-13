import java.util.ArrayList;

public class DeviceLoader {

    public static ArrayList<SmartDevice> LoadDevices()
    {
        ArrayList<SmartDevice> result=new ArrayList<>();
        //SETUP IOT Ecosystem

        SmartSwitch switch1= new SmartSwitch("128.1.1.1",false);
        result.add(switch1);
        SmartLighting d1 = new SmartLighting("128.1.1.2",false,"red","dimmable");
        SmartLighting d2 = new SmartLighting("128.1.1.3",false,"blue", "nonDimmable");
        SmartLighting d3 = new LedStripe("128.1.1.9",false,"green","nonDimmable");
        switch1.addLightingDevice(d1);
        switch1.addLightingDevice(d2);
        switch1.addLightingDevice(d3);

        //Other devices
        result.add(new SmartTV("128.1.1.4", false));
        result.add(new SmartHeater("128.1.1.5", false));
        result.add(new SmartHeater("128.1.1.6", false));

        //LED stripe
        LedStripe stripe1 = new LedStripe("128.1.1.7",false,"yellow", "dimmable");
        result.add(stripe1);
        stripe1.attachLedStripe(new LedStripe("128.1.1.8",false,"yellow", "dimmable"));

        return result;
    }
}