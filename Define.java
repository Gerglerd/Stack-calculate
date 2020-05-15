package function;

import calculator.CalculateCommand;
import calculator.CommandExecuteException;
import calculator.Stack;

import java.util.EmptyStackException;
import java.util.List;

public class Define implements CalculateCommand {
    @Override
    public void comExecuteEx(Stack context, List<String> myArgs) throws CommandExecuteException {
        if (myArgs.size()<2) {
            throw new CommandExecuteException("U can't use DEFINE without NAME and VALUE");
        }
        String constValue = null;
        try{
            String constName = myArgs.get(0);
            constValue = myArgs.get(1);
            double constVal = Double.parseDouble(constValue);
            context.setConst(constName,constVal);
        }catch (NumberFormatException e){
            throw new CommandExecuteException(constValue + "isn't number", e);
        }catch (EmptyStackException e){
            throw new CommandExecuteException("Stack is empty", e);
        }
    }
}
