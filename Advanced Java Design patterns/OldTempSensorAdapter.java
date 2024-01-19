package itec3030.assignments.a2;

import itec3030.smarthome.standards.IController;
import itec3030.smarthome.standards.ITemperatureSensor;
import oldtempinc.drivers.OldTempSensor;

public class OldTempSensorAdapter implements ITemperatureSensor {
    private OldTempSensor oldTempSensor;

    public OldTempSensorAdapter() {
        OldTempSensor oldTempSensor = new OldTempSensor();
        this.oldTempSensor = oldTempSensor;
    }

    public float getTemperature() {
        // Use the OldTempSensor to read temperature data
        float temperature = oldTempSensor.getTemperature();
        return temperature;
    }

    @Override
    public void newTemperature(int temperature) {
        // This function should be called by the hardware to register a new temperature
        // reading.
        // Implement the logic to set the new temperature in the OldTempSensor
        // You may need to convert the integer temperature to a float
        float temperatureFloat = (float) temperature;
        oldTempSensor.newTemperature(temperatureFloat);
    }

    @Override
    public IController getController() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getController'");
    }

    @Override
    public void setController(IController arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setController'");
    }

    @Override
    public int getReading() {
        return (int) this.getTemperature();
    }
}