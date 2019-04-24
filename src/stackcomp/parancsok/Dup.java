package stackcomp.parancsok;

import stackcomp.Command;
import stackcomp.Main;

public class Dup implements Command {
    public void execute(String[] cmd) {
        Main.stack.push(Main.stack.peek());
    }
}
