package itec3030.assignments.a2;

public class PurifierDecorator extends PolarbearDecorator {
    private polarbear ac;

    public PurifierDecorator(polarbear ac) {
        this.ac = ac;
    }

    @Override
    public void turnOn() {
        System.err.println("UV Purifier: On");
        ac.turnOn();
    }
}
