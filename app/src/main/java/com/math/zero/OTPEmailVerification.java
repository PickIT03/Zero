package com.math.zero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Toast;

import java.util.Properties;
import java.util.Random;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

public class OTPEmailVerification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpemail_verification);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Intent intent=getIntent();
        String email=intent.getStringExtra("EMAIL");
        String name=intent.getStringExtra("NAME");
        String user_password=intent.getStringExtra("PASSWORD");
        String college=intent.getStringExtra("COLLEGE");
        String dept=intent.getStringExtra("DEPT");
        Random random=new Random();
        int otp=random.nextInt(100)+1;
        final String username="pickit03@gmail.com";
        final String password="Pick_IT_03@2021";
        Properties properties=new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
//        Session session=Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username,password);
//            }
//        });
//        try {
//            Message message=new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
//            message.setSubject("OTP for SignIn into ZERO");
//            message.setText("Your OTP for email Verification is "+otp);
//            Transport.send(message);
////            Toast.makeText(this, "Email for OTP send Successfully", Toast.LENGTH_SHORT).show();
//        }catch (MessagingException e){
//            throw new RuntimeException(e);
//        }
    }
}