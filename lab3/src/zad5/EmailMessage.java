package zad5;

import java.util.LinkedList;
import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;



public class EmailMessage {
    private String from; //required (must be e-mail)
    private String pass;//haslotestowe1
    private LinkedList<String> to = new LinkedList<String>(); //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc=new LinkedList<String>(); //optional
    private LinkedList<String> bcc=new LinkedList<String>();; // optional

    protected EmailMessage(Builder data){
        from=data.from;
        pass=data.pass;
        to=data.to;
        subject=data.subject;
        content=data.content;
        mimeType=data.mimeType;
        cc=data.cc;
        bcc=data.bcc;

    }
    protected EmailMessage(  String from,
                          String pass,
                          LinkedList<String> to,
                          String subject,
                          String content,
                          String mimeType ,
                          LinkedList<String> cc,
                          LinkedList<String> bcc){
        if (!from.contains("@")){
            System.out.println("adres nie jest e-mailem");
            return;
        }
        this.from=from;
        this.pass=pass;
        if (!to.contains("@")){
            System.out.println("adres nie jest e-mailem");
            return;
        }
        this.to.addAll(to);//laczenie list

    }
    public void show(){
        System.out.println(this.from);
        System.out.println(this.to.getFirst());
        System.out.println(this.content);
        System.out.println(this.subject);
    }
    public static Builder builder(){
        return  new EmailMessage.Builder();
    }

    public void send1(){
        try {
            boolean sessionDebug = false;
            String host = "smtp.gmail.com";

            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to.getFirst())};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(content);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host,from,pass);

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void send(){
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try{
            properties.setProperty("mail.user",from);
            properties.setProperty("mail.password",pass);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.getFirst()));
            message.setSubject(subject);
            message.setText(content);
            Transport transport = session.getTransport("smtp");
            transport.connect(host,from,pass);
            //Transport.send(message);
            System.out.println("moze...?");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void  sendMessageFAKESMTP() {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "localhost");
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            for(String adress : to)
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(adress));

            if(subject != null)
                message.setSubject(subject);
            if(content != null)
                message.setText(content);


            Transport.send(message);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static class Builder{
        private String from; //required (must be e-mail)
        private String pass;
        private LinkedList<String> to=new LinkedList<String>();; //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc=new LinkedList<String>();; //optional
        private LinkedList<String> bcc=new LinkedList<String>();; // optional

        public Builder addFrom(String From){
            if (!From.contains("@")){
                System.out.println("adres nie jest e-mailem");
                return this;
            }

            from=From;
            return this;
        }
        public Builder addPass(String Pass){
            pass=Pass;
            return this;
        }
        public Builder addTo(String To){
            if (!To.contains("@")){
                System.out.println("adres nie jest e-mailem");
                return this;
            }
            try {
                to.add(To);
            }catch (Exception e){}
            return this;


        }
        public Builder addSubject(String sub){
            subject=sub;
            return this;
        }
        public Builder addContent(String con){
            content=con;
            return this;
        }
        public EmailMessage build(){

            return new EmailMessage(this);
        }

    }
}

