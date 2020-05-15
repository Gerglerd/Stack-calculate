package function;

import calculator.CalculateCommand;
import calculator.CommandExecuteException;
import calculator.Stack;

import java.util.EmptyStackException;
import java.util.List;

public class Mult implements CalculateCommand {
    @Override
    public void comExecuteEx(Stack context, List<String> myArgs) throws CommandExecuteException {
       try {
           double a = context.popStack();
           double b = context.popStack();
           context.pushStack(a*b);
       }catch (EmptyStackException e){
           throw new CommandExecuteException("Stack is empty", e);
       }
    }
}
