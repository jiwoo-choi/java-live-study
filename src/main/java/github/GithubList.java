package github;

import org.apache.commons.io.IOExceptionWithCause;
import org.kohsuke.github.*;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;


public class GithubList {

    public static String getBoardString(List<GHIssue> allIssues) throws IOException {

        TreeMap<String, UserDTO> userManager = new TreeMap<String, UserDTO>();
        int totalWeeks = allIssues.size();

        String board = "|이름|";
        for (int i = 0 ; i < totalWeeks ; i++) {
            board += "week " + (i+1) + "|";
        }

        board += "참여율|";
        board += '\n';
        board += '|';
        for (int i = 0 ; i < totalWeeks + 2 ; i++) {
            board += "--|";
        }
        board += '\n';

        for (int i = totalWeeks - 1; i >= 0 ; i--) {
            int thisWeek = totalWeeks - i - 1; // for index
            List<GHIssueComment> comments = allIssues.get(i).getComments();
            for (GHIssueComment comment : comments) {
                if (comment.getUser().getLogin().equals(GithubConstant.STUDY_LEADER)) continue;
                String name = comment.getUser().getLogin();
                UserDTO user = userManager.getOrDefault(name, new UserDTO(name, totalWeeks));
                user.setParticipation(thisWeek, true);
                if (!userManager.containsKey(name)) {
                    userManager.put(name, user);
                }
            }
        }

        for (String s : userManager.keySet()) {
            board += userManager.get(s).toString();
            board += '\n';
        }

        return board;
    }

    public static void start() {
        try {
            GitHub github = GitHub.connectUsingOAuth(GithubConstant.GITHUB_PEROSNAL_TOKEN);
            GHRepository repository = github.getRepository(GithubConstant.TARGET_REPOSITORY);
            List<GHIssue> allIssues = repository.getIssues(GHIssueState.ALL);
            System.out.println(getBoardString(allIssues));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        start();
    }
}
