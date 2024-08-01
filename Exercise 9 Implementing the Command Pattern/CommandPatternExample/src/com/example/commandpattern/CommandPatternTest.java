package com.example.commandpattern;

public class CommandPatternTest {
    public static void main(String[] args) {
        // Create a Light instance
        Light light = new Light();

        // Create command objects
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create invoker (RemoteControl)
        RemoteControl remote = new RemoteControl();

        // Turn light on
        remote.setCommand(lightOn);  // This should match the method in RemoteControl
        remote.pressButton();

        // Turn light off
        remote.setCommand(lightOff);  // This should match the method in RemoteControl
        remote.pressButton();
    }
}
