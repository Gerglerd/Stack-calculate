package calculator;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Stack stack = new Stack();

    public static void main(String args[]) {
        printCommands();
        Scanner in = getScanner(args);
        assert null != in: "In is null";
        while (in.hasNextLine()){
            String commands = in.nextLine();
            commands = clearString(commands);
            if (equality(commands)) {
                continue;
            }
            exeCommands(commands);
        }
        in.close();
    }

    private static void exeCommands(String commands) {
        String com[] = commands.split(" ");
        List<String> comArgs = newComArgs(com);
        try {
            CalculateCommand command = CommandFactory.getCommand(com[0]);
            command.comExecuteEx(stack, comArgs);
        } catch (Throwable e) {
            System.err.println("Error execute command: " + e.getLocalizedMessage());
        }
    }

    private static boolean equality (String commands) {
        return commands.equals("") || commands.startsWith("#");
    }

    private static List<String> newComArgs(String[] com) {
        assert null != com: "Com is null";
        return new ArrayList<String>(Arrays.asList(com).subList(1, com.length));
    }

    private static String clearString(String commands) {
        return commands.trim().replaceAll("\\s+", " ");
    }

    private static Scanner getScanner(String[] args) {
        assert null != args: "Args is null";
        Scanner in = null;
        if (1 == args.length) {
            String fileName = args[0];
            try {
                InputStream inStream = new FileInputStream(fileName);
                in = new Scanner(inStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            in = new Scanner(System.in);
        }
        return in;
    }

    private static void printCommands(){
        String commands = "1. Определи переменную: define name value\n2. положи переменную на стек: push name\n3. определи еще одну переменную, пользуясь пунктами 1-2\n4. произведи операции над переменными: + - / * sqrt\n5. напечатай ответ: print\n6.* выйти из калькулятора: нажми на красный квадратик, чтобы остановить выполнение программы";
        System.out.println(commands);
    }


}