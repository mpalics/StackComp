package stackcomp.szubrutinok;

import stackcomp.Command;
import stackcomp.Main;

import java.util.HashMap;

public class Call implements Command {
    public void execute(String[] cmd) {
        Main.frame.push(Main.pc);
        Main.pc = Main.functions.get(cmd[1]);
        if (Main.memstack.isEmpty()) {
            HashMap<String,Integer> nullpara = new HashMap<String,Integer>();
            nullpara.put("nullpara",0);
            Main.memstack.push(nullpara);
        }
    }
}