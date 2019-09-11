import org.junit.Test;
import static org.junit.Assert.*;

public class ClinicTest {

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
}
