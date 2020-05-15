package function;

import calculator.CalculateCommand;
import calculator.CommandExecuteException;
import calculator.Stack;

import java.util.EmptyStackException;
import java.util.List;

public class Div implements CalculateCommand {
    @Override
    public void comExecuteEx(Stack context, List<String> myArgs) throws CommandExecuteException {
        double a;
        double b;
        try {
            b = context.popStack();
            a = context.popStack();
        }catch(EmptyStackException e) {
            throw new CommandExecuteException("Stack is empty: " + e);
        }
        if (Math.abs(b) == 0) {
            throw new CommandExecuteException("cannot be divided by zero");
        }
        context.pushStack(a/b);
    }
}
