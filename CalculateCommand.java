package calculator;

import java.util.List;

public interface CalculateCommand {
    void comExecuteEx (Stack stack, List<String> myArgs) throws CommandExecuteException;
}

