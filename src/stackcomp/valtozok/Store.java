package stackcomp.valtozok;

        import stackcomp.Command;
        import stackcomp.Main;

public class Store implements Command {
    public void execute(String[] cmd) {
        Main.vars.put(cmd[1], Main.stack.pop());
    }
}