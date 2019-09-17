public class HealthDepartmentUsingFIFO extends HealthDepartment {

    HealthDepartmentUsingFIFO() {
        super();
    }

    @Override
    public void triage(Patient patient) {
        waitingList.add(patient);
    }
}
