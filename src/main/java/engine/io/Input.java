package engine.io;

public interface Input {
    void showOption(String guideMessage);

    String getCalculateSentence(String guideMessage);

    String getUserInputOption();
}
