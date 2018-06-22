package ipl;

public class Matches {
  public Matches(int mATCH_ID, String sEASON, String cITY, String dATE, String tEAM1, String tEAM2, String tOSS_WINNER,
      String tOSS_DECISION, String rESULT, String wINNER) {
    super();
    MATCH_ID = mATCH_ID;
    SEASON = sEASON;
    CITY = cITY;
    DATE = dATE;
    TEAM1 = tEAM1;
    TEAM2 = tEAM2;
    TOSS_WINNER = tOSS_WINNER;
    TOSS_DECISION = tOSS_DECISION;
    RESULT = rESULT;
    WINNER = wINNER;
  }
  public Matches() {
    super();
  }
  int MATCH_ID; 
  String SEASON; 
  String CITY; 
  String DATE; 
  String TEAM1;
  String TEAM2;
  String TOSS_WINNER;
  String TOSS_DECISION; 
  String RESULT; 
  String WINNER;

}
