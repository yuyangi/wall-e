package show.me.the.code.codable.exec;

import show.me.the.code.codable.storage.Storager;
import show.me.the.code.nlp.AnsjPartOfSpeech;
import show.me.the.code.nlp.Segment;
import show.me.the.code.nlp.Segmentor;

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
