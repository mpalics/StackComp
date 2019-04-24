package stackcomp;

public class CmdErrorException extends Exception {
    public String getMessage(String cmd) {
        return "Ismeretlen parancs: " + cmd;
    }
}
