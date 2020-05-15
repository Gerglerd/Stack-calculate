package calculator;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.HashMap;

public class Stack {
    private LinkedList<Double> calculateStack = new LinkedList<Double>();
    private HashMap<String, Double> permanent = new HashMap<String, Double>();

    public double getConst(String variable) throws NoSuchElementException{
        if (!permanent.containsKey(variable)){
            throw new NoSuchElementException("Stack doesn't contain: " + variable);
        }
        return permanent.get(variable);
    }

    public void setConst(String variable, Double value) {
        permanent.put(variable,value);
    }

    public void pushStack(double value){
        calculateStack.push(value);
    }

    public double popStack() throws EmptyStackException{
        return calculateStack.pop();
    }

    public double peekStack() throws EmptyStackException, CommandExecuteException {
        if (calculateStack.peek() == null) {
            throw new CommandExecuteException("Stack doesn't be empty");
        }
        return calculateStack.peek();
    }
}
