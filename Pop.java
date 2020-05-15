package function;

import calculator.CalculateCommand;
import calculator.CommandExecuteException;
import calculator.Stack;

import java.util.EmptyStackException;
import java.util.List;

public class Pop implements CalculateCommand {
    @Override
    public void comExecuteEx(Stack context, List<String> myArgs) throws CommandExecuteException {
        try{
            context.popStack();
        } catch (EmptyStackException e) {
            throw new CommandExecuteException("Stack is empty", e);
        }
    }
}
