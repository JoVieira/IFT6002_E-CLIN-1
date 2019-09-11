import java.util.ArrayList;

public class HealthCenter {
    public void triageListFIFO(Patient patient, ArrayList<Patient> list) {
        list.add(patient);
    }

    public void triageListGravity(Patient patient, ArrayList<Patient> list) {
        if(patient.gravity > 5) {
            list.add(0, patient);
        }
        else {
            list.add(patient);
        }
    }
}
