package stackcomp.parancsok;

import stackcomp.Command;
import stackcomp.Main;

public class List implements Command {
    public void execute(String[] cmd) {
        for (int x : Main.stack) {
            System.out.println(x);
        }
    }
}