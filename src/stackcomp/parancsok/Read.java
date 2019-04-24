package stackcomp.parancsok;

import stackcomp.Command;
import stackcomp.Main;

public class Read implements Command {
    public void execute(String[] cmd) {
        Main.stack.push(Main.sc.nextInt());
    }
}
