import java.util.Arrays;

public class Viewer {

    public void printInfoMessage() {
        String infoMessage = formatMessages();
        System.out.print(infoMessage);
    }

    private String formatMessages() {
        StringBuilder formattedMessage = new StringBuilder();

        for (InfoMessage msg : InfoMessage.values()) {
            if (!msg.equals(InfoMessage.SELECT)) {
                formattedMessage.append(msg.getMessage()).append('\n');
            }
        }
        formattedMessage.append('\n')
                .append(InfoMessage.SELECT.getMessage());

        return formattedMessage.toString();
    }
}
