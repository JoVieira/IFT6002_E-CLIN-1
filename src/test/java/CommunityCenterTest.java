import org.junit.Test;

import static org.junit.Assert.*;

public class CommunityCenterTest {

    /*
     *
     * 4TH STEP
     *
     */

    @Test
    public final void nurseListIsInitiallyEmpty() {
        CommunityCenter communityCenter = new CommunityCenter(TriageType.FIFO);
        assertTrue(communityCenter.nurseList.isEmpty());
    }

    @Test
    public final void uniquePatientIs1stInTheNurseList() {
        CommunityCenter communityCenter = new CommunityCenter(TriageType.FIFO);
        Patient patient = new Patient("John", 2, VisibleSymptom.MIGRAINE);

        communityCenter.triagePatient(patient);
        assertEquals(communityCenter.nurseList.get(0), patient);
    }

    @Test
    public final void secondPatientIs2ndInTheNurseListUsingFIFO() {
        CommunityCenter communityCenter = new CommunityCenter(TriageType.FIFO);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.MIGRAINE);
        Patient patient2 = new Patient("Mary", 100, VisibleSymptom.EBOLA);

        communityCenter.triagePatient(patient1);
        communityCenter.triagePatient(patient2);
        assertEquals(communityCenter.nurseList.get(1), patient2);
    }

    @Test
    public final void secondPriorityPatientIs1stInTheNurseListUsingGravity() {
        CommunityCenter communityCenter = new CommunityCenter(TriageType.GRAVITY);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.MIGRAINE);
        Patient patient2 = new Patient("Mary", 100, VisibleSymptom.EBOLA);

        communityCenter.triagePatient(patient1);
        communityCenter.triagePatient(patient2);
        assertEquals(communityCenter.nurseList.get(0), patient2);
    }

    @Test
    public final void firstPatientIsNow2ndInTheNurseListUsingGravity() {
        CommunityCenter communityCenter = new CommunityCenter(TriageType.GRAVITY);
        Patient patient1 = new Patient("John", 2, VisibleSymptom.MIGRAINE);
        Patient patient2 = new Patient("Mary", 100, VisibleSymptom.EBOLA);

        communityCenter.triagePatient(patient1);
        communityCenter.triagePatient(patient2);
        assertEquals(communityCenter.nurseList.get(1), patient1);
    }
}
