import org.junit.Test;
import static org.junit.Assert.*;

public class CommunityCenterTest {

    @Test
    public void whenTriagingPatient_thenPatientIsAddedToTheNurseWaitingList() {
        CommunityCenter communityCenter = new CommunityCenter();
        Patient patient = new Patient("John", 3, VisibleSymptom.FLU);

        communityCenter.triagePatient(patient);
        assertTrue(communityCenter.nurse.waitingList.contains(patient));
    }
}
