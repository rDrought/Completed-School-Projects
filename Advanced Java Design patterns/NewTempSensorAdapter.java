package itec3030.assignments.a2;

import newtemp.NewTempSensor.NewTempSensorDriver;
import newtemp.NewTempSensor.Observer;

public class NewTempSensorAdapter implements AbstractNewTempSensorAdapter, Observer {

    private NewTempSensorDriver driver;
    private int temperature;
    private String name = "Lion Sensor";

    public NewTempSensorAdapter() {
        driver = new NewTempSensorDriver();
        driver.registerObserver(this);
    }

    @Override
    public NewTempSensorDriver getAdatptee() {
        return this.driver;
    }

    public String getID() {
        return name;
    }

    public void newTemperature(int temp) {
        this.temperature = temp;
        System.out.println(this.getID() + " receiving new temperature: " + this.getReading());
        driver.notifyObservers(temp);

    }

    @Override
    public void update(int i) {
        this.temperature = i;
        System.out.println(this.getID() + " receiving new temp: " + this.getReading());
    }

    public int getReading() {
        return temperature;
    }
}