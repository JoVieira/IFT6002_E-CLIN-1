import java.util.*;

public class Clinic {

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
        if(doctorTriageType.equals(TriageType.FIFO)) {
            triageDoctorListFIFO(patient);
        }
        else if(doctorTriageType.equals(TriageType.GRAVITY)) {
            triageDoctorListGravity(patient);
        }

        if(patient.visibleSymptom == VisibleSymptom.BROKEN_BONE || patient.visibleSymptom == VisibleSymptom.SPRAIN) {
            triageRadiologyListFIFO(patient);
        }
    }

    public void triageDoctorListFIFO(Patient patient) {
        doctorList.add(patient);
    }

    public void triageRadiologyListFIFO(Patient patient) {
        radiologyList.add(patient);
    }

    public void triageDoctorListGravity(Patient patient) {
        if(patient.gravity > 5) {
            doctorList.add(0, patient);
        }
        else {
            doctorList.add(patient);
        }
    }
}