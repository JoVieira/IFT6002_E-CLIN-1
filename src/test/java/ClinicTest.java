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
        assertTrue(clinic.doctor.waitingList.isEmpty());
    }

    @Test
    public final void radiologyListIsInitiallyEmpty() {
        Clinic clinic = new Clinic();
        assertTrue(clinic.radiology.waitingList.isEmpty());
    }

    @Test
    public final void uniquePatientWithMigraineIs1stInTheDoctorList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 2, VisibleSymptom.MIGRAINE);

        clinic.triagePatient(patient);
        assertEquals(clinic.doctor.waitingList.get(0), patient);
    }

    @Test
    public final void uniquePatientWithMigraineIsNotAddedToTheRadiologyList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 2, VisibleSymptom.MIGRAINE);

        clinic.triagePatient(patient);
        assertTrue(clinic.radiology.waitingList.isEmpty());
    }

    @Test
    public final void secondPatientWithTheFluIs2ndInTheDoctorList() {
        Clinic clinic = new Clinic();
        Patient patient1 = new Patient("John", 2, VisibleSymptom.MIGRAINE);
        Patient patient2 = new Patient("Mary", 3, VisibleSymptom.FLU);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.doctor.waitingList.get(1), patient2);
    }

    @Test
    public final void secondPatientWithTheFluNotAddedToTheRadiologyList() {
        Clinic clinic = new Clinic();
        Patient patient1 = new Patient("John", 2, VisibleSymptom.MIGRAINE);
        Patient patient2 = new Patient("Mary", 3, VisibleSymptom.FLU);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertFalse(clinic.radiology.waitingList.contains(patient2));
    }

    @Test
    public final void uniquePatientWithASprainIs1stInTheDoctorList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 2, VisibleSymptom.SPRAIN);

        clinic.triagePatient(patient);
        assertEquals(clinic.doctor.waitingList.get(0), patient);
    }

    @Test
    public final void uniquePatientWithASprainIs1stInTheRadiologyList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 2, VisibleSymptom.SPRAIN);

        clinic.triagePatient(patient);
        assertEquals(clinic.radiology.waitingList.get(0), patient);
    }

    @Test
    public final void secondPatientWithABrokenBoneIs2ndInTheRadiologyList() {
        Clinic clinic = new Clinic();
        Patient patient1 = new Patient("John", 2, VisibleSymptom.SPRAIN);
        Patient patient2 = new Patient("Mary", 3, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.radiology.waitingList.get(1), patient2);
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
        HealthDepartment doctor = new HealthDepartmentUsingGravity();
        HealthDepartment radiology = new HealthDepartmentUsingFIFO();
        Clinic clinic = new Clinic(doctor, radiology);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.CHEST_PAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.FLU);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.doctor.waitingList.get(0), patient2);
    }

    @Test
    public final void firstPatientIsNow2ndInTheDoctorList() {
        HealthDepartment doctor = new HealthDepartmentUsingGravity();
        HealthDepartment radiology = new HealthDepartmentUsingFIFO();
        Clinic clinic = new Clinic(doctor, radiology);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.CHEST_PAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.FLU);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.doctor.waitingList.get(1), patient1);
    }

    @Test
    public final void secondPriorityPatientWithTheFluNotAddedToTheRadiologyList() {
        HealthDepartment doctor = new HealthDepartmentUsingGravity();
        HealthDepartment radiology = new HealthDepartmentUsingFIFO();
        Clinic clinic = new Clinic(doctor, radiology);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.CHEST_PAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.FLU);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertFalse(clinic.radiology.waitingList.contains(patient2));
    }

    @Test
    public final void secondPriorityPatientWithABrokenBoneIs2ndInTheRadiologyList() {
        HealthDepartment doctor = new HealthDepartmentUsingGravity();
        HealthDepartment radiology = new HealthDepartmentUsingFIFO();
        Clinic clinic = new Clinic(doctor, radiology);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.SPRAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.radiology.waitingList.get(1), patient2);
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
        HealthDepartment doctor = new HealthDepartmentUsingGravity();
        HealthDepartment radiology = new HealthDepartmentUsingGravity();
        Clinic clinic = new Clinic(doctor, radiology);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.SPRAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.radiology.waitingList.get(0), patient2);
    }

    @Test
    public final void firstPatientIsNow2ndInTheRadiologyList() {
        HealthDepartment doctor = new HealthDepartmentUsingGravity();
        HealthDepartment radiology = new HealthDepartmentUsingGravity();
        Clinic clinic = new Clinic(doctor, radiology);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.SPRAIN);
        Patient patient2 = new Patient("Mary", 7, VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patient1);
        clinic.triagePatient(patient2);
        assertEquals(clinic.radiology.waitingList.get(1), patient1);
    }

    /*
     *
     * 5TH STEP
     *
     */

    @Test
    public final void gravity1PatientNotAddedToTheDoctorList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 1, VisibleSymptom.SPRAIN);

        clinic.triagePatient(patient);
        assertFalse(clinic.doctor.waitingList.contains(patient));
    }

    @Test
    public final void gravity1PatientNotAddedToTheRadiologyList() {
        Clinic clinic = new Clinic();
        Patient patient = new Patient("John", 1, VisibleSymptom.SPRAIN);

        clinic.triagePatient(patient);
        assertFalse(clinic.radiology.waitingList.contains(patient));
    }

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
