package org.free13.rubik.nlp;

import com.google.common.collect.Lists;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Result;
import org.ansj.splitWord.Analysis;
import org.ansj.splitWord.analysis.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@Configuration
public class AnsjSegmentor implements Segmentor {

    @Value("${nlp.segment.ansj.analysis:ToAnalysis}")
    private String analysisType = "ToAnalysis";

    @Override
    public Segment[] segment(String content) {
        return segment2Obj(content).toArray(new Segment[0]);
    }

    @Override
    public String[] toWords(String content) {
        return Segment.toWords(segment2Obj(content));
    }

    public List<Segment> segment2Obj(String content) {
        Result result = parse(content);
        List<Segment> wordSegs = Lists.newArrayList();
        if (result != null && result.getTerms() != null) {
            result.getTerms().forEach(term -> wordSegs.add(Segment.of(term.toString())));
        }
        return wordSegs;
    }

    @Override
    public String[] extractKeyWord(String content, int keywordLength) {
        KeyWordComputer<Analysis> kwc = new KeyWordComputer<>(keywordLength);
        Collection<Keyword> result = kwc.computeArticleTfidf(content);
        return result.stream().map(Keyword::getName).toArray(String[]::new);
    }

    private Result parse(String content) {
        return switch (analysisType) {
            case "DicAnalysis" -> DicAnalysis.parse(content);
            case "IndexAnalysis" -> IndexAnalysis.parse(content);
            case "NlpAnalysis" -> NlpAnalysis.parse(content);
            case "BaseAnalysis" -> BaseAnalysis.parse(content);
            default -> ToAnalysis.parse(content);
        };
    }

}
