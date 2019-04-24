package stackcomp.valtozok;

import stackcomp.Command;
import stackcomp.Main;

public class Load implements Command {
    public void execute(String[] cmd) {
        Main.stack.push(Main.vars.get(cmd[1]));
    }
}