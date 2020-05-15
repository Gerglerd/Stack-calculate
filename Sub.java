package function;

import calculator.CalculateCommand;
import calculator.CommandExecuteException;
import calculator.Stack;

import java.util.EmptyStackException;
import java.util.List;

public class Sub implements CalculateCommand {
    @Override
    public void comExecuteEx(Stack stack, List<String> myArgs) throws CommandExecuteException {
        try {
            double b = stack.popStack();
            double a = stack.popStack();
            stack.pushStack(a-b);
        }catch (EmptyStackException e) {
            throw new CommandExecuteException("Stack is empty", e);
        }
    }
}
