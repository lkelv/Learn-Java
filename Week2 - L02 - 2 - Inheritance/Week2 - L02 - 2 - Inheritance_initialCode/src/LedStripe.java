public class LedStripe extends SmartDevice {

    //private attributes

    private String colour;
    private String type;
    private int dimmingLevel;

    private LedStripe nextLedStripe;

    //constructor
    public LedStripe(String _ipAddress, boolean _status, String _colour, String _type) {
        super(_ipAddress, _status);
        this.colour = _colour;
        this.type=_type; // "dimmable or notDimmable"
        this.dimmingLevel=100;
    }



    //getters and setters

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


    public LedStripe getNextLedStripe() {
        return this.nextLedStripe;
    }

    public void setDimmingLevel(int dimmingLevel) {
        if (this.type=="dimmable")
            this.dimmingLevel = dimmingLevel;
    }

    //other methods
    @Override
    public void turnOn() {
        this.status = true;
        System.out.println("The LedStripe at "+ this.ipAddress +" was turned on successfully");
        if (nextLedStripe!=null)
        {
            this.nextLedStripe.turnOn();
        }
    }

    @Override
    public void turnOff() {
        this.status = false;
        System.out.println("The LedStripe at "+ this.ipAddress +" was turned off successfully");
        if (nextLedStripe!=null)
        {
            this.nextLedStripe.turnOff();
        }
    }
    public void attachLedStripe(LedStripe _ledStripe)
    {
        this.nextLedStripe=_ledStripe;
        if(this.status)
            this.nextLedStripe.turnOn();
        else
            this.nextLedStripe.turnOff();
    }

    public void detachLedStripe()
    {
        this.nextLedStripe=null;
    }

    public void display() {
        System.out.println("LedStripe  at " + super.getIpAddress() + " is on: " + super.getStatus() + ". Colour:" + this.colour + " Today's consumption: " + super.getConsumptionToday());
        this.nextLedStripe.display();
    }

}
