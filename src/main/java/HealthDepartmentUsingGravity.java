public class HealthDepartmentUsingGravity extends HealthDepartment {

    HealthDepartmentUsingGravity() {
        super();
    }

    @Override
    public void triage(Patient patient) {
        if(patient.gravity > 5) {
            waitingList.add(0, patient);
        }
        else {
            waitingList.add(patient);
        }
    }
}
