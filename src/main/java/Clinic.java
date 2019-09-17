import java.util.*;

public class Clinic extends HealthCenter {

    public HealthDepartment doctor;
    public HealthDepartment radiology;

    public Clinic() {
        doctor = new HealthDepartmentUsingFIFO();
        radiology = new HealthDepartmentUsingFIFO();
    }

    public Clinic(HealthDepartment doctor, HealthDepartment radiology) {
        this.doctor = doctor;
        this.radiology = radiology;
    }

    @Override
    public void triagePatient(Patient patient) {
        if(patient.gravity > 1) {
            doctor.triage(patient);

            if (patient.visibleSymptom == VisibleSymptom.BROKEN_BONE || patient.visibleSymptom == VisibleSymptom.SPRAIN) {
                radiology.triage(patient);
            }
        }
    }
}