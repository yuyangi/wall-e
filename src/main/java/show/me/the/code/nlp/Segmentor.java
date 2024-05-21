package show.me.the.code.nlp;

public interface Segmentor {

    String[] toWords(String content);
    Segment[] segment(String content);

    String[] extractKeyWord(String content, int keywordLength);

}
