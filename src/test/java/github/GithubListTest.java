package github;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueBuilder;
import org.kohsuke.github.GHIssueComment;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GithubListTest {

    @Test
    public void github_size_zero_test() {
        List<GHIssue> gh = new ArrayList<GHIssue>();
        try {
            assertEquals(GithubList.getBoardString(gh), "|이름|참여율|\n" + "|--|--|\n");
        } catch (Exception e) {
            fail("EXPECTED |이름|참여율|\n" +  "|--|--| + \n");
        }
    }

    @Test
    public void user_dto_participation_rate_test() {
        UserDTO user = new UserDTO("test1", 3);
        user.setParticipation(0, true);
        user.setParticipation(1, true);
        user.setParticipation(2, true);
        assertEquals(100.00, user.getParticipationRate());
        assertEquals(100.00, user.getParticipationRate());
        user.setParticipation(2, false);
        assertEquals(66.66666666666666, user.getParticipationRate());
        assertEquals(66.66666666666666, user.getParticipationRate());
        assertEquals(user.toString(), "test1|✅|✅|X|66.67%|");
    }


}