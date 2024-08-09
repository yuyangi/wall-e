package org.free13.rubik.nlp;

import java.util.List;

public class Segment {

    private String word;
    private long frequency;

    private String partOfSpeech;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public static Segment of(String segStr) {
        Segment seg = new Segment();
        String[] wordParts = segStr.split("/");
        if (wordParts.length > 1) {
            seg.setWord(wordParts[0]);
            // 词性
            seg.setPartOfSpeech(wordParts[1]);
        } else if (wordParts.length == 1) {
            seg.setWord(wordParts[0]);
        } else {
            seg.setWord(segStr);
        }
        return seg;
    }

    public static String[] toWords(List<Segment> segs) {
        if (segs != null) {
            return segs.stream().map(Segment::getWord).toArray(String[]::new);
        }
        return null;
    }

    public String toWord() {
        return word;
    }
}
