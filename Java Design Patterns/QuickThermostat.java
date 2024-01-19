/*
 *  Template Developed by Sotirios Liaskos for the needs of
 *   ITEC3030 Systems Architecture.
 *  @ All Rights Reserved
 */
package itec3030.assignments.a1;

import itec3030.smarthome.standards.*;

public class QuickThermostat implements INumericInstrument, ITemperaturePreferenceSensor {

	private int reading;

	@Override
	public int getReading() {
		return reading;
	}

	@Override
	public IController getController() {
		// No controller needed
		return null;
	}

	@Override
	public void setController(IController arg0) {
		// No need to set a controller
	}

	@Override
	public void newPreferredTemperature(int reading) {
		this.reading = reading;
	}
}
