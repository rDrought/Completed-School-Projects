package itec3030.assignments.a1;

import itec3030.assignments.a1.sensors.thermoset.ThermoSetX19FrontEnd.ThermostatGUI;
import itec3030.smarthome.standards.ITemperaturePreferenceSensor;
import itec3030.smarthome.standards.IController;

public class ThermoSetX19 implements ITemperaturePreferenceSensor {

    private int setTemp;
    private IController thermostat;

    public ThermoSetX19(){
        ThermostatGUI f = new ThermostatGUI(this);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void newPreferredTemperature(int i) {
        this.setTemp = i;
    }

    @Override
    public IController getController () {
        return this.thermostat;
    }

    @Override
    public void setController(IController var1) {
        this.thermostat = var1;
    }

    @Override
    public int getReading () {
        return setTemp;
    }
}
