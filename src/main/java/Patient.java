public class Patient {
    public String name;
    public int gravity;
    public VisibleSymptom visibleSymptom;

    public Patient(String name, int gravity, VisibleSymptom visibleSymptom) {
        this.name = name;
        this.gravity = gravity;
        this.visibleSymptom = visibleSymptom;
    }
}
