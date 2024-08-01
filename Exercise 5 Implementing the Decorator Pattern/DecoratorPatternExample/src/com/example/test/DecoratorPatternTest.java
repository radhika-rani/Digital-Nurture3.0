package com.example.test;

import com.example.notification.EmailNotifier;
import com.example.notification.Notifier;
import com.example.notification.SMSNotifierDecorator;
import com.example.notification.SlackNotifierDecorator;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Basic email notifier
        Notifier emailNotifier = new EmailNotifier();
        emailNotifier.send("Hello World!");

        // Email notifier with SMS and Slack decorators
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        smsNotifier.send("Hello World!");

        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);
        slackNotifier.send("Hello World!");
    }
}
