public class SmartHeater extends SmartDevice {

    //private attributes
    private boolean isTimerOn;
    private int timerMinutes;

    private int temperature;

    //constructor
    public SmartHeater(String _ipAddress, boolean _status) {
        super(_ipAddress, _status);

    }

    //getters and setters

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }




    //other methods

    public void turnOn(int _temperature) {
        this.status = true;
        this.temperature= _temperature;
        System.out.println("Attempting to turn on the heater at "+ this.ipAddress);
        System.out.println("The heater at "+ this.ipAddress +" was turned successfully ON at " + this.temperature + " degrees");
    }

    public void turnOff() {
        this.status = false;
        System.out.println("Attempting to turn the heater at "+ this.ipAddress + " off");
        System.out.println("The heater at "+ this.ipAddress +" was turned successfully OFF");
    }

    public void setTimer(int _minutes)
    {
        this.isTimerOn=true;
        this.timerMinutes=_minutes;

        if(this.status)
        {

            System.out.println("The device at "+ this.ipAddress + " will turn on in " + this.timerMinutes + " minutes");
            System.out.println("Call sent to the device.......");
        }
        else
        {
            System.out.println("The device at "+ this.ipAddress + " will turn off in " + this.timerMinutes + " minutes");
            System.out.println("Call sent to the device.......");
        }

    }


    public void display() {
        System.out.println("Heater at " + this.ipAddress + " is on: " + this.status + ". Temperature:" + this.temperature + ". Today's consumption: " + super.getConsumptionToday());
    }
}
