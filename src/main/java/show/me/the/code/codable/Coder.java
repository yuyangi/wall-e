package show.me.the.code.codable;

public interface Coder {

    <T> T executeImmediately(String command);

    void compileExecutable();

}
