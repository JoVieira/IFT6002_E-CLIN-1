import org.junit.Test;
import static org.junit.Assert.*;

public class ClinicTest {
    /*
     *
     * E-CLIN-2
     *
     */

    @Test
    public void whenTriagingPatient_thenPatientIsAddedToTheDoctorWaitingList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 3, VisibleSymptom.FLU);

        clinic.triagePatient(patient);
        assertTrue(clinic.doctor.waitingList.contains(patient));
    }

    @Test
    public void whenTriagingPatientWithTheFlu_thenPatientIsNotAddedToTheRadiologyWaitingList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 3, VisibleSymptom.FLU);

        clinic.triagePatient(patient);
        assertFalse(clinic.radiology.waitingList.contains(patient));
    }

    @Test
    public void whenTriagingPatientWithABrokenBone_thenPatientIsAddedToTheRadiologyWaitingList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 3, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patient);
        assertTrue(clinic.radiology.waitingList.contains(patient));
    }

    @Test
    public void whenTriagingPatientWithASprain_thenPatientIsAddedToTheRadiologyWaitingList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 3, VisibleSymptom.SPRAIN);

        clinic.triagePatient(patient);
        assertTrue(clinic.radiology.waitingList.contains(patient));
    }
}
