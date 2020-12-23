package jcactus;

public class Message {

    private void message (String text, String collor) {
        String collorInt = "37";
        if (collor.equals("red")) { collorInt = "31"; }
        if (collor.equals("green")) { collorInt = "32"; }
        if (collor.equals("yellow")) { collorInt = "33"; }
        if (collor.equals("blue")) { collorInt = "34"; }
        if (collor.equals("purple")) { collorInt = "35"; }
        if (collor.equals("cyan")) { collorInt = "36"; }

        System.out.println(((char) 27 + "[" + collorInt +"m"+ text + (char)27 + "[0m"));
    }

    public void errorMessage(String text) {
       message(text, "red");
    }

    public void successMessage(String text) {
        message(text, "green");
    }

    public void systemMessage(String text) {
        message(text, "yellow");
    }

}
