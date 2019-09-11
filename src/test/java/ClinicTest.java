import org.junit.Test;
import static org.junit.Assert.*;

public class ClinicTest {

    /*
     *
     * 1ST STEP
     *
     * DOCTOR TRIAGE TYPE: FIFO
     * RADIOLOGY TRIAGE TYPE: FIFO
     *
     */

    @Test
    public final void doctorListIsInitiallyEmpty() {
        Clinic clinic = new Clinic();
        assertTrue(clinic.doctorList.isEmpty());
    }

    @Test
    public final void radiologyListIsInitiallyEmpty() {
        Clinic clinic = new Clinic();
        assertTrue(clinic.radiologyList.isEmpty());
    }

    @Test
    public final void uniquePatientWithMigraineIs1stInTheDoctorList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 2, VisibleSymptom.MIGRAINE);

        clinic.triagePatient(patient);
        assertEquals(clinic.doctorList.get(0), patient);
    }

    @Test
    public final void uniquePatientWithMigraineIsNotAddedToTheRadiologyList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 2, VisibleSymptom.MIGRAINE);

        clinic.triagePatient(patient);
        assertTrue(clinic.radiologyList.isEmpty());
    }

    @Test
    public final void secondPatientWithTheFluIs2ndInTheDoctorList() {
        Clinic clinic = new Clinic();
        Patient patient1 = new Patient("John", 2, VisibleSymptom.MIGRAINE);
        Patient patient2 = new Patient("Mary", 3, VisibleSymptom.FLU);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.doctorList.get(1), patient2);
    }

    @Test
    public final void secondPatientWithTheFluNotAddedToTheRadiologyList() {
        Clinic clinic = new Clinic();
        Patient patient1 = new Patient("John", 2, VisibleSymptom.MIGRAINE);
        Patient patient2 = new Patient("Mary", 3, VisibleSymptom.FLU);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertFalse(clinic.radiologyList.contains(patient2));
    }

    @Test
    public final void uniquePatientWithASprainIs1stInTheDoctorList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 2, VisibleSymptom.SPRAIN);

        clinic.triagePatient(patient);
        assertEquals(clinic.doctorList.get(0), patient);
    }

    @Test
    public final void uniquePatientWithASprainIs1stInTheRadiologyList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 2, VisibleSymptom.SPRAIN);

        clinic.triagePatient(patient);
        assertEquals(clinic.radiologyList.get(0), patient);
    }

    @Test
    public final void secondPatientWithABrokenBoneIs2ndInTheRadiologyList() {
        Clinic clinic = new Clinic();
        Patient patient1 = new Patient("John", 2, VisibleSymptom.SPRAIN);
        Patient patient2 = new Patient("Mary", 3, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.radiologyList.get(1), patient2);
    }

    /*
     *
     * 2ND STEP
     *
     * DOCTOR TRIAGE TYPE: GRAVITY
     * RADIOLOGY TRIAGE TYPE: FIFO
     *
     */

    @Test
    public final void secondPriorityPatientWithTheFluIs1stInTheDoctorList() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.CHEST_PAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.FLU);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.doctorList.get(0), patient2);
    }

    @Test
    public final void firstPatientIsNow2ndInTheDoctorList() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.CHEST_PAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.FLU);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.doctorList.get(1), patient1);
    }

    @Test
    public final void secondPriorityPatientWithTheFluNotAddedToTheRadiologyList() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.CHEST_PAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.FLU);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertFalse(clinic.radiologyList.contains(patient2));
    }

    @Test
    public final void secondPriorityPatientWithABrokenBoneIs2ndInTheRadiologyList() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.SPRAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.radiologyList.get(1), patient2);
    }

    /*
     *
     * 3RD STEP
     *
     * DOCTOR TRIAGE TYPE: GRAVITY
     * RADIOLOGY TRIAGE TYPE: GRAVITY
     *
     */

    @Test
    public final void secondPriorityPatientWithABrokenBoneIs1stInTheRadiologyList() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.GRAVITY);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.SPRAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.radiologyList.get(0), patient2);
    }

    @Test
    public final void firstPatientIsNow2ndInTheRadiologyList() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.GRAVITY);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.SPRAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.radiologyList.get(1), patient1);
    }
}
