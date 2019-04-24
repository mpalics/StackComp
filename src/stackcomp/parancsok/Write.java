package stackcomp.parancsok;

import stackcomp.Command;
import stackcomp.Main;

public class Write implements Command {
    public void execute(String[] cmd) {
        System.out.println(Main.stack.peek());
        Main.stack.pop();
    }
}
