package show.me.the.code.nlp;

public class DefaultSegmentor implements Segmentor {
    @Override
    public String[] segment(String content) {
        return new String[0];
    }

    @Override
    public String[] extractKeyWord(String content, int keywordLength) {
        return new String[0];
    }
}
