package stackcomp.vez_szerk;

import stackcomp.Command;
import stackcomp.Main;

public class Jump implements Command {
    public void execute(String[] cmd) {
        Main.pc = Main.labels.get(cmd[1]);
    }
}