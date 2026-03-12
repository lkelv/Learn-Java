public class SmartBulb extends SmartDevice {

    private String colour;
    private String type;
    private int dimmingLevel;

    //constructor
    public SmartBulb(String _ipAddress, boolean _status, String _colour, String _type) {
        super(_ipAddress, _status);
        this.colour = _colour;
        this.type=_type; // "dimmable or notDimmable"
        this.dimmingLevel=100;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


    public void setDimmingLevel(int dimmingLevel) {
        if (this.type=="dimmable")
            this.dimmingLevel = dimmingLevel;
    }


}
