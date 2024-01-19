/*
 *  Template Developed by Sotirios Liaskos for the needs of
 *   ITEC3030 Systems Architecture.
 *  @ All Rights Reserved
 */
package itec3030.assignments.a1;
/*
 *  Template Developed by Sotirios Liaskos for the needs of
 *   ITEC3030 Systems Architecture.
 *  @ All Rights Reserved
 */

//package itec3030.assignments.a1;

//import itec3030.assignments.a1.actuators.arcticcool.ArcticCoolFA15;
import itec3030.assignments.a1.sensors.omnitemp.OmniTempSensorXS3;
import itec3030.smarthome.standards.*;
import java.util.ArrayList;

/**
 * A Building object for maintaining information about the entire building.
 * 
 * @author Sotirios
 */
public class Building {
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ICooler ac = null;
    private ITemperaturePreferenceSensor thermostat = null;

    /**
     * Returns the temperature desired by the inhabitants of the building.
     * 
     * @return The desired temperature.
     */
    public int getDesiredTemperature() {
        return thermostat.getReading();
    }

    /**
     * Returns a reference to the cooling device installed in the building.
     * 
     * @return A reference to the cooling device installed in the building.
     */
    public ICooler getCoolingDevice() {
        return ac;
    }

    /**
     * "Installs" a cooling device in the building.
     * 
     * @param clr A reference to the cooling device to be installed in the building.
     */
    public void setCoolingDevice(ICooler clr) {
        this.ac = clr;
    }

    /**
     * Returns a reference to the temperature preference sensor (thermostat)
     * installed in the building.
     * 
     * @return A reference to the temperature preference sensor (thermostat)
     *         installed in the building.
     */
    public ITemperaturePreferenceSensor getThermostat() {
        return thermostat;
    }

    /**
     * "Installs" the temperature preference sensor (thermostat) in the building
     * 
     * @param sth Reference to a thermostat object.
     */
    public void setThermostat(ITemperaturePreferenceSensor sth) {
        this.thermostat = sth;
    }

    /**
     * Returns the average temperature in all rooms of the building.
     * 
     * @return Average temperature over all rooms of the building.
     */
    public float getAvergeTemperature() {
        float count = 0, sum = 0;
        for (Room r : rooms) {
            sum += r.getAvergeTemperature();
            count++;
        }
        return (float) (sum / count);
    }

    /**
     * Locates and returns the room in which a smart object is installed.
     * 
     * @param s Reference to a smart object.
     * @return Reference to the Room in which the smart object is installed.
     */
    public Room findRoomOf(ISmartObject s) {
        Room found = null;
        for (Room r : rooms) {
            if (r.hasThing((OmniTempSensorXS3) s))
                found = r;
        }
        return (found);
    }

    //
    // Install Constituent Rooms
    //

    /**
     * Add a room to the building.
     * 
     * @param room Reference to a Room Object.
     */
    public void add(Room room) {
        rooms.add(room);
    }
}
