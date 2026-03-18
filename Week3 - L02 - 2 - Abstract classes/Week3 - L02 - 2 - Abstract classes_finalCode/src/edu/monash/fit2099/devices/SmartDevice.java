package edu.monash.fit2099.devices;
import edu.monash.fit2099.Utils;

public abstract class SmartDevice {

    //private/protected attributes
    private String ipAddress;
    private boolean status;
    private double consumptionToday; //inWatts

    public SmartDevice(String _ipAddress, boolean _status) {
        this.ipAddress = _ipAddress;
        this.status = _status;
    }

    //getters and setters
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getConsumptionToday() {
        return Utils.getRandomConsumption();
    }

    //Abstract methods
    public abstract void display();

    public abstract void turnOn();

    public abstract void turnOff();

}
