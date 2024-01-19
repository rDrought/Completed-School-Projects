package itec3030.assignments.a2;

public class WiFIDecorator extends PolarbearDecorator {
    private polarbear ac;

    public WiFIDecorator(polarbear ac) {
        this.ac = ac;
    }

    @Override
    public void turnOn() {
        System.out.println("Wifi started.");
        ac.turnOn();
    }
}
