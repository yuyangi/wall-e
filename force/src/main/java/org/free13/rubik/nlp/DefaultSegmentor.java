package org.free13.rubik.nlp;

public class DefaultSegmentor implements Segmentor {
    @Override
    public Segment[] segment(String content) {
        return new Segment[0];
    }

    @Override
    public String[] toWords(String content) {
        return new String[0];
    }

    @Override
    public String[] extractKeyWord(String content, int keywordLength) {
        return new String[0];
    }
}
