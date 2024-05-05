package show.me.the.code.nlp;

public interface Segmentor {

    String[] segment(String content);

    String[] extractKeyWord(String content, int keywordLength);

}
