import java.util.ArrayList;

public abstract class HealthDepartment {
    public ArrayList<Patient> waitingList = new ArrayList<Patient>();

    public abstract void triage(Patient patient);
}
