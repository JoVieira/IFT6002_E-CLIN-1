import java.util.*;

public class Clinic extends HealthCenter {

    public ArrayList<Patient> doctorList;
    public ArrayList<Patient> radiologyList;
    public TriageType doctorTriageType;
    public TriageType radiologyTriageType;

    public Clinic() {
        doctorList = new ArrayList<Patient>();
        radiologyList = new ArrayList<Patient>();
        doctorTriageType = TriageType.FIFO;
        radiologyTriageType = TriageType.FIFO;
    }

    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        doctorList = new ArrayList<Patient>();
        radiologyList = new ArrayList<Patient>();
        this.doctorTriageType = doctorTriageType;
        this.radiologyTriageType = radiologyTriageType;
    }

    public void triagePatient(Patient patient) {
        if(patient.gravity > 1) {
            if (doctorTriageType.equals(TriageType.FIFO)) {
                triageListFIFO(patient, doctorList);
            } else if (doctorTriageType.equals(TriageType.GRAVITY)) {
                triageListGravity(patient, doctorList);
            }

            if (patient.visibleSymptom == VisibleSymptom.BROKEN_BONE || patient.visibleSymptom == VisibleSymptom.SPRAIN) {
                if (radiologyTriageType.equals(TriageType.FIFO)) {
                    triageListFIFO(patient, radiologyList);
                } else if (radiologyTriageType.equals(TriageType.GRAVITY)) {
                    triageListGravity(patient, radiologyList);
                }
            }
        }
    }
}