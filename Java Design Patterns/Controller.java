/*
 *  Template Developed by Sotirios Liaskos for the needs of
 *   ITEC3030 Systems Architecture.
 *  @ All Rights Reserved
 */
package itec3030.assignments.a1;

import itec3030.smarthome.standards.*;

/**
 * 
 * @author Sotirios Liaskos
 */
public class Controller implements IController {

    /**
     * Reference to a building model.
     */
    protected Building house = new Building();

    /**
     * Set the building model which the Controller controls
     * 
     * @param bld
     */
    public void setBuildingModel(Building bld) {
        house = bld;
    }

    /**
     * (See SSDCS documentation)
     */
    @Override
    public void changeDetected(ISmartObject s) {
        this.update();
    }

    /**
     * Function that is called by the controller every time a change has been
     * communicated by a {@linkplain ISmartObject}, i.e., the smart object has
     * called {@linkplain IController#changeDetected(ISmartObject)}
     */
    private void update() {

        // See if you need to turn on heating
        if (house.getAvergeTemperature() > house.getDesiredTemperature() && house.getCoolingDevice().isOff()) {
            System.out.println("Average house temperature is now: " + house.getAvergeTemperature()
                    + " while desired is " + house.getDesiredTemperature() + ". Turning A/C on.");
            turnCoolingOn();
        }
        // See if you need to turn heating off
        if (house.getAvergeTemperature() <= house.getDesiredTemperature() && house.getCoolingDevice().isOn()) {
            System.out.println("Average house temperature is now: " + house.getAvergeTemperature()
                    + " while desired is " + house.getDesiredTemperature() + ". Turning A/C off.");
            turnCoolingOff();
        }
    }

    /**
     * Turns cooling off.
     */
    private void turnCoolingOff() {
        house.getCoolingDevice().turnOff();
        ;
    }

    /**
     * Turns cooling on.
     */
    private void turnCoolingOn() {
        house.getCoolingDevice().turnOn();
    }

}
