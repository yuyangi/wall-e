package show.me.the.code.codable;

import java.util.*;

public class Codability {

    //单例模式
    private static final Codability instance = new Codability();

    private final Map<String, Object> codified = new HashMap<>();

    private Codability() {
    }

    public static Codability getInstance() {
        return instance;
    }

    public void registerCodified(String name, Object codable) {
        codified.put(name, codable);
    }

    public Object getCodified(String name) {
        return codified.get(name);
    }

    public String exec(String command) {

        return "exec " + command + " success";
    }
}
