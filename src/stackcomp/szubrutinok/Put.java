package stackcomp.szubrutinok;

import stackcomp.Command;
import stackcomp.Main;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Put implements Command {
    public void execute(String[] cmd) {
        HashMap<String,Integer> parameters = new HashMap<String,Integer>();
//        for (int i = 1; i < cmd.length; i++) {
//            parameters.put(String.valueOf(i), Main.vars.get(cmd[i]));
//        }

        int i = 0;
        for (String str : cmd) {
            i++;
            if (!str.equals("put")) {parameters.put(String.valueOf(i), Main.vars.get(str));}
        }

        Main.memstack.push(parameters);
    }
}
