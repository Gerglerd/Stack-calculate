package calculator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;



public class CommandFactory {
    private static HashMap<String, CalculateCommand> hashmap = new HashMap<String, CalculateCommand>();
    private static Properties properties = null;

    static {
        InputStream stringStream = null;
        try {
            stringStream = new FileInputStream("Commands.txt");
            properties = new Properties();
            properties.load(stringStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stringStream != null) {
                    stringStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static CalculateCommand getCommand(String comName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, CommandExecuteException {
        String key = properties.getProperty(comName.toLowerCase());
        if (key == null) {
            throw new NoSuchElementException("Invalid request: " + comName);
        }
        CalculateCommand command = hashmap.get(key);
        if (null == command) {
            Class<?> comClass = Class.forName(key);
            Constructor<?> constructor = comClass.getConstructor();
            command = (CalculateCommand) constructor.newInstance();
            hashmap.put(key, command);
        }
        return command;
    }
}

