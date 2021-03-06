//
// Copyright (C) CSIRO Australia Telescope National Facility
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.

package atnf.atoms.mon.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.InternetAddress.*;
import org.apache.log4j.Logger;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * Trivial wrapper class for JavaMail. This uses the host for mail transport and sends mail as the current user.
 * 
 * @author David Brodrick
 */
public class MailSender {

  /** read all the mail settings from monitor-config.txt **/

  private static Properties properties = new Properties();
  static {
    try {
      properties.put("mail.smtp.socketFactory.port", MonitorConfig.getProperty("SMTPPort", "25"));
      properties.put("mail.smtp.host", MonitorConfig.getProperty("SMTPHost", "localhost"));
      properties.put("mail.smtp.auth", MonitorConfig.getProperty("SMTPAuth", "false"));
      if (MonitorConfig.getProperty("SMTPSTARTTLS") == null) {
        // Backwards compatibility
        properties.put("mail.smtp.starttls.enable", MonitorConfig.getProperty("TLS", "false"));
      } else {
        properties.put("mail.smtp.starttls.enable", MonitorConfig.getProperty("SMTPSTARTTLS"));
      }
      String temp = MonitorConfig.getProperty("SMTPSSLSocket");
      if (temp != null && temp.toLowerCase().equals("true")) {
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      }
    } catch (Exception e) {
    }
  }

  private static Session theirSession = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication(MonitorConfig.getProperty("SMTPUser"), MonitorConfig.getProperty("SMTPPassword"));
    }
  });

  /** Logger. */
  private static Logger theirLogger = Logger.getLogger(MailSender.class);

  /** if no sender specified, pass an empty sender */
  public static void sendMail(String to, String subject, String body) {
    String sender = "";
    sendMail(to, sender, subject, body);
  }

  /** Send an email with the specified recipient, sender, subject and body. */
  public static void sendMail(String to, String sender, String subject, String body) {
    MimeMessage message = new MimeMessage(theirSession);
    InternetAddress from = new InternetAddress();
    try {
      if (sender == "") {
        from = InternetAddress.getLocalAddress(theirSession);
      } else {
        from = new InternetAddress(sender);
      }
    } catch (AddressException ex) {
      theirLogger.error("AddressException occurred: " + ex);
    }

    try {
      String[] strAddresses = to.split("\\s+");
      InternetAddress[] iaAddresses = new InternetAddress[strAddresses.length];
      for (int i = 0; i < strAddresses.length; i++) {
        iaAddresses[i] = new InternetAddress(strAddresses[i]);
      }
      message.addRecipients(Message.RecipientType.TO, iaAddresses);
      message.setSubject(subject);
      message.setText(body);
      message.setFrom(from);
      Transport.send(message);
    } catch (MessagingException ex) {
      theirLogger.error("Cannot send email: " + ex);
    }
  }

  /** Test method. */
  public final static void main(String[] args) {
    if (args.length < 3) {
      System.err.println("USAGE: Requires at least 3 arguments:");
      System.err.println("\trecipient_email, subject, body");
      System.err.println("OR\trecipient_email, sender_email, subject, body");
      System.exit(1);
    }

    if (args.length == 3) {
      MailSender.sendMail(args[0], args[1], args[2]);
    } else if (args.length == 4) {
      MailSender.sendMail(args[0], args[1], args[2], args[3]);
    }

  }
}
