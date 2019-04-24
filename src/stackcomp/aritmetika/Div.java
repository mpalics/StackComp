package stackcomp.aritmetika;

import stackcomp.Command;
import stackcomp.Main;

public class Div implements Command {
    public void execute(String[] cmd) {
        int a = Main.stack.peek(); Main.stack.pop();
        int b = Main.stack.peek(); Main.stack.pop();
        Main.stack.push(a/b);
    }
}