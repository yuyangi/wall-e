package org.free13.rubik.codable.exec;

import org.free13.rubik.codable.storage.Storager;
import org.free13.rubik.nlp.Segment;
import org.free13.rubik.nlp.Segmentor;

import java.lang.reflect.Field;
import java.util.Arrays;

public class NLExecutor implements Executor {

    private Segmentor segmentor;

    private Storager storager;

    public NLExecutor(Segmentor segmentor, Storager storager) {
        this.segmentor = segmentor;
        this.storager = storager;
    }

    @Override
    public String execute(String nl) {
        Segment[] segments = segmentor.segment(nl);
        Arrays.stream(segments).iterator().forEachRemaining(seg -> {
            if (seg.getPartOfSpeech().startsWith("n")) {
                Object entity = storager.getEntity(seg.getWord());

                Field field = storager.getProperty(seg.getWord(), "name");

            }
        });


        return null;
    }

    @Override
    public Storager storager() {
        return storager;
    }
}
