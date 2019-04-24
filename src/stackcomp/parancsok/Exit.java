package stackcomp.parancsok;

import stackcomp.Command;

public class Exit implements Command {
    public void execute(String[] cmd) {
        System.exit(0);
    }
}
