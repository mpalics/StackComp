package stackcomp.szubrutinok;

import stackcomp.Command;
import stackcomp.Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Get implements Command {
    public void execute(String[] cmd) {
        HashMap<String,Integer>  parameters = Main.memstack.pop();

        //for (Integer value : parameters.values()) {
        //    Main.stack.push(value);
        //}

        //for (Map.Entry<String, Integer> entry : Main.memstack.entrySet()) {
        //    Main.stack.push(entry.getValue());
        //}

        parameters.forEach((key, value) -> Main.stack.push(value));

    }
}
