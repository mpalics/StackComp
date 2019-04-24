package stackcomp.parancsok;

import stackcomp.Command;
import stackcomp.Main;

public class Pop implements Command {
    public void execute(String[] cmd) {
        Main.stack.pop();
    }
}
