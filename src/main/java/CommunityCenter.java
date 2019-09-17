public class CommunityCenter extends HealthCenter {

    public HealthDepartment nurse;

    public CommunityCenter() {
        nurse = new HealthDepartmentUsingFIFO();
    }

    public CommunityCenter(HealthDepartment nurse) {
        this.nurse = nurse;
    }

    @Override
    public void triagePatient(Patient patient) {
        if(patient.gravity > 1) {
            nurse.triage(patient);
        }
    }
}
