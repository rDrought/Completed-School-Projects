/*
 *  Template Developed by Sotirios Liaskos for the needs of
 *   ITEC3030 Systems Architecture.
 *  @ All Rights Reserved
 */
package itec3030.assignments.a1;

import itec3030.smarthome.standards.*;
import itec3030.assignments.a1.actuators.arcticcool.ArcticCoolFA15;
import itec3030.assignments.a1.sensors.omnitemp.OmniTempSensorXS3;
import itec3030.assignments.a1.sensors.thermoset.ThermoSetX19.ThermosetX19;

/**
 *
 * @author Sotirios
 */
public class Main {
    Main p = new Main();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller c = new Controller();

        // Create Building
        Building h = new Building();
        Room livingRoom = new Room();
        Room bedRoom = new Room();
        livingRoom.setName("Living Room");
        bedRoom.setName("Bedoom");
        h.add(livingRoom);
        h.add(bedRoom);

        ITemperatureSensor o1 = new OmniTempSensorXS3(c, "o1");
        ITemperatureSensor o2 = new OmniTempSensorXS3(c, "o2");
        ITemperatureSensor o3 = new OmniTempSensorXS3(c, "o3");
        ICooler ac = new ArcticCoolFA15("ac");
        ITemperaturePreferenceSensor th = new QuickThermostat();

        livingRoom.install(o1);
        livingRoom.install(o2);
        bedRoom.install(o3);

        h.setCoolingDevice(ac);
        h.setThermostat(th);
        c.setBuildingModel(h);

        // Part 2 - uncomment to execute Part 2
        ac.powerOn();
        Scenario e = new Scenario(o1, o2, o3, th);
        e.play();
        ac.powerOff();

        //Part 3 - uncomment to execute Part 3
        th = new ThermosetX19();
        h.setThermostat(th);
        ac.powerOn();
        e = new Scenario(o1, o2, o3, th);
        e.play();
        ac.powerOff();
        ((ICooler) th).powerOff();
    }
}
