package zad5;

public class Builder {
    public static void main(String[] argv){
        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("javaTest923@gmail.com")
                //.addPass("haslotestowe1")
                .addTo("izzetgurad@gmail.com")
                .addSubject("Mail testowy")
                .addContent("Brak tresci,ale dziala")
                .build();
        wiadomosc.show();
        wiadomosc.sendMessageFAKESMTP();
    }

}
