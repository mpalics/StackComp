package stackcomp.vez_szerk;

import stackcomp.Command;
import stackcomp.Main;

public class OnNonZero implements Command {
    public void execute(String[] cmd) {
        if (Main.stack.pop() != 0) { Main.pc = Main.labels.get(cmd[1]); }
    }
}