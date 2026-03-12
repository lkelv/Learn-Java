public class SmartHomeDriver {

    public static void main(String[] args) {

        System.out.println("Welcome to the Smart Home system");

        SmartSwitch smartSwitch = new SmartSwitch();
        smartSwitch.turnOn();

        smartSwitch.addBulb(new SmartBulb(true,"red"));
        smartSwitch.addBulb(new SmartBulb(false,"yellow"));

        smartSwitch.display();

        smartSwitch.turnAllOff();
        smartSwitch.turnAllOn("blue");

        smartSwitch.display();



    }
}
