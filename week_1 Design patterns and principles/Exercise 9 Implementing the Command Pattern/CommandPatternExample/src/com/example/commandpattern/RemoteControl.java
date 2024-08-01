package com.example.commandpattern;

public class RemoteControl {
    private Command command;

    // Setter for Command
    public void setCommand(Command command) {
        this.command = command;
    }

    // Method to execute the command
    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set.");
        }
    }
}
