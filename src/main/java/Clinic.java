import java.util.*;

public class Clinic {

    public ArrayList<Patient> doctorList;
    public ArrayList<Patient> radiologyList;

    public Clinic() {
        doctorList = new ArrayList<Patient>();
        radiologyList = new ArrayList<Patient>();
    }

    public void triagePatient(Patient patient) {
        doctorList.add(patient);

        if(patient.visibleSymptom == VisibleSymptom.BROKEN_BONE || patient.visibleSymptom == VisibleSymptom.SPRAIN) {
            radiologyList.add(patient);
        }
    }

}