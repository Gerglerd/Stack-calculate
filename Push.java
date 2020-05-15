package function;

import calculator.CalculateCommand;
import calculator.CommandExecuteException;
import calculator.Stack;

import java.util.List;
import java.util.NoSuchElementException;

public class Push implements CalculateCommand {
    @Override
    public void comExecuteEx(Stack stack, List<String> myArgs) throws CommandExecuteException {
        String args = myArgs.get(0);
        if (isDouble(args)) {
            stack.pushStack(Double.parseDouble(args));
        }else {
            try {
                double constValue = stack.getConst(args);
                stack.pushStack(constValue);
            }catch (NoSuchElementException e) {
                throw new CommandExecuteException("Not exist: " + args, e);
            }
        }
    }

    private boolean isDouble(String args) {
        try {
            Double.parseDouble(args);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}
