package stackcomp.szubrutinok;

import stackcomp.Command;
import stackcomp.Main;

public class Return implements Command {
    public void execute(String[] cmd) {
        Main.pc = Main.frame.pop();
    }
}