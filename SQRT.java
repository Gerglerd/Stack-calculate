package function;

import calculator.CalculateCommand;
import calculator.CommandExecuteException;
import calculator.Stack;

import java.util.EmptyStackException;
import java.util.List;

public class SQRT implements CalculateCommand {
    @Override
    public void comExecuteEx(Stack stack, List<String> myArgs) throws CommandExecuteException {
        double a;
        try {
            a = stack.popStack();
        } catch (EmptyStackException e) {
            throw new CommandExecuteException("Stack is empty", e);
        }
            if (a > 0.0 || a == 0.0) {
                stack.pushStack(Math.sqrt(a));
            } else {
                throw new CommandExecuteException("Argument in sqrt less zero");
        }
    }
}
