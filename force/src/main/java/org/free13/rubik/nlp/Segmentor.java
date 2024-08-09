package org.free13.rubik.nlp;

public interface Segmentor {

    String[] toWords(String content);
    Segment[] segment(String content);

    String[] extractKeyWord(String content, int keywordLength);

}
