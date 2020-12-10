package github;

import java.util.ArrayList;
import java.util.LinkedList;

public class UserDTO {
    /// 유저 이름.
    private String userName;
    /// 참여 week.
    private ArrayList<Boolean> participation;

    private Double participationRate = null;
    /// 상태 변경 체크 용 변수.
    private Boolean stateChanged = null;

    public UserDTO(String userName, int totalWeeks) {
        this.participation = new ArrayList<Boolean>(totalWeeks);
        this.userName = userName;
        for( int i = 0 ; i < totalWeeks ; i++) {
            this.participation.add(false);
        }
    }

    public double getParticipationRate() {

        if (this.stateChanged != null && stateChanged == false) {
            return this.participationRate;
        }
        int total = participation.size();
        long trueCount = participation.stream().filter( (val) -> val.equals(Boolean.TRUE)).count();
        this.participationRate = (trueCount == 0) ? 0 : (trueCount / (double)total) * 100;
        this.stateChanged = false;
        return this.participationRate;
    }

    public void setParticipation(int week, boolean value) {
        this.stateChanged = true;
        this.participation.set(week, value);
    }

    @Override
    public String toString() {
        int total = participation.size();
        String ret = "";
        for (int i = 0 ; i < total + 2 ; i++) {
            if ( i == 0 ) {
                ret += userName;
            } else if (i == total + 1){
                ret += Double.parseDouble(String.format("%.2f",this.getParticipationRate())) + "%";
            } else {
                ret += (this.participation.get(i - 1) == true) ? "✅" : "X";
            }
            ret += "|";
        }
        return ret;
    }
}
