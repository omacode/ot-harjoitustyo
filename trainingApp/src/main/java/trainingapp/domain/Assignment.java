package trainingapp.domain;

/**
 * Yksittäistä tehtävää kuvaava luokka
 */
public class Assignment {

    private int id;
    private int playerId;
    private String question;
    private String answer;
    private String tip;
    private String explanation;

    public Assignment(int playerId, String question, String answer, String tip, String explanation) {
        this.playerId = playerId;
        this.question = question;
        this.answer = answer;
        this.tip = tip;
        this.explanation = explanation;
    }

    public Assignment(int id, int playerId, String question, String answer, String tip, String explanation) {
        this.id = id;
        this.playerId = playerId;
        this.question = question;
        this.answer = answer;
        this.tip = tip;
        this.explanation = explanation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
