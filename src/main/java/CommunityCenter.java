import java.util.ArrayList;

public class CommunityCenter extends HealthCenter {
    public ArrayList<Patient> nurseList;
    public TriageType nurseTriageType;

    public CommunityCenter(TriageType nurseTriageType) {
        nurseList = new ArrayList<Patient>();
        this.nurseTriageType = nurseTriageType;
    }

    public void triagePatient(Patient patient) {
        if(patient.gravity > 1) {
            if (nurseTriageType.equals(TriageType.FIFO)) {
                triageListFIFO(patient, nurseList);
            } else if (nurseTriageType.equals(TriageType.GRAVITY)) {
                triageListGravity(patient, nurseList);
            }
        }
    }
}