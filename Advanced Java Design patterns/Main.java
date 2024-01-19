/*
 *  Template Developed by Sotirios Liaskos for the needs of
 *   ITEC3030 Systems Architecture.
 *  @ All Rights Reserved
 */
package itec3030.assignments.a2;

import itec3030.smarthome.standards.ITemperatureSensor;
import newtemp.NewTempSensor.NewTempSensorDevice;
import oldtempinc.hardware.OldSensorDevice;
import itec3030.assignments.a2.polarbear;

/**
 *
 * @author Sotirios
 */
public class Main {
    Main p = new Main();

    public static void main(String[] args) throws InterruptedException {

        // ***
        // Exercise 1
        // ***
        ITemperatureSensor o1 = new OldTempSensorAdapter();

        // Creating a new OldTemp Hardware Device and passing a TemperatureSensor in it
        OldSensorDevice olddev = new OldSensorDevice(o1);
        // Start the scenario
        olddev.start();
        // **** NEW *****
        System.out.println("Last reading sent from device was " + o1.getReading());

        // ***
        // Exercise 2
        // ***

        polarbear n = new BearMinimum();
        n = new PurifierDecorator(n);
        n = new WiFIDecorator(n);
        n.turnOn();

        // ***
        // Exercise 3
        // ***

        // Creating the adapter
        NewTempSensorAdapter o2 = new NewTempSensorAdapter();

        // Creating a new NewTemp Hardware Device and passing a NewTempSensor in it.
        NewTempSensorDevice newdev = new NewTempSensorDevice(o2.getAdatptee());

        // Part 1: Play the device scenario
        newdev.start();
        // Part 2: Get the last reading
        System.out.println("Last reading sent from device was " + o2.getReading());
        // Part 3: Trigger your own temperature event:
        o2.newTemperature(39);

    }
}
