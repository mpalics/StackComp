package stackcomp;

import stackcomp.aritmetika.*;
import stackcomp.parancsok.*;
import stackcomp.szubrutinok.*;
import stackcomp.valtozok.*;
import stackcomp.vez_szerk.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
    public static ArrayDeque<Integer> frame = new ArrayDeque<Integer>();

    public static HashMap<String,Integer> labels = new HashMap<>();
    public static HashMap<String,Integer> vars = new HashMap<>();
    public static HashMap<String,Integer> functions = new HashMap<>();

    public static ArrayDeque<HashMap<String, Integer>>  memstack = new ArrayDeque<HashMap<String, Integer>>();

    public static Scanner sc = new Scanner(System.in);
    public static int pc = 0;

    public static void main(String[] args) {

        HashMap<String,Command> map = new HashMap<String,Command>();
        String[] cmd = new String[5];
        LinkedList<String> lines = new LinkedList<>();
        boolean show_pc = false;

        map.put("exit",         new Exit());
        map.put("dup",          new Dup());
        map.put("list",         new List());
        map.put("pop",          new Pop());
        map.put("push",         new Push());
        map.put("read",         new Read());
        map.put("write",        new Write());
        map.put("add",          new Add());
        map.put("sub",          new Sub());
        map.put("mult",         new Mult());
        map.put("div",          new Div());
        map.put("jump",         new Jump());
        map.put("onnonzero",    new OnNonZero());
        map.put("onzero",       new OnZero());
        map.put("onnegative",   new OnNegative());
        map.put("store",        new Store());
        map.put("load",         new Load());
        map.put("call",         new Call());
        map.put("return",       new Return());
        map.put("put",          new Put());
        map.put("get",          new Get());

        if (args.length > 0) {
            lines = loadfile(args[0]);
            if (args.length == 2) {
                if (args[1].equals("-d")) { show_pc = true; }            //-d paraméter esetén program counter mutatása
            }
            System.out.print(args[0]+" nevű fájl futtatása...\n\n");

        }

        while(true) {

            if (lines.size() == 0) {                                      //parancsértelmező mód
                System.out.print(">> ");
                cmd = sc.nextLine().trim().split("\\s");
            }
            else {
                if (pc+1 > lines.size()) {System.exit(0);}          //fájlból értelmező mód
                cmd = lines.get(pc).trim().split("\\s");
                pc++;
            }

            try {
                Command c = map.get(cmd[0]);
                c.execute(cmd);
                if (show_pc) { System.out.println("\t ["+ pc + "]: " + cmd[0]); }
            }
            catch (Exception ex) { System.out.println("Hibás parancs: " + cmd[0] + " -> " + pc); }
        }
    }

    public static LinkedList<String>  loadfile(String path) {
        LinkedList<String> lines = new LinkedList<>();
        File file = new File(path);

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) { labels.put(line,lines.size()); }
                else if (line.startsWith("@")) { functions.put(line,lines.size()); }
                else if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {;}
                else { lines.add(line); }
            }

        } catch (Exception ex) { System.out.println("Fájl olvasási hiba."); }

        return lines;
    }
}
