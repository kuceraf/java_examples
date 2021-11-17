package cz.fku.designPatterns.behavioural.command;

class Command
{
    enum Action
    {
        DEPOSIT, WITHDRAW
    }

    public Action action;
    public int amount;
    public boolean success;

    public Command(Action action, int amount)
    {
        this.action = action;
        this.amount = amount;
    }
}

class Account
{
    public int balance;

    public void process(Command c)
    {
        switch (c.action) {
            case DEPOSIT:
                balance = balance + c.amount;
                c.success = true;
                break;
            case WITHDRAW:
                if (c.amount <= balance) {
                    balance = balance - c.amount;
                   c.success = true;
                } else {
                    c.success = false;
                }
                break;
        }
    }
}

public class CommandPattern {
}
