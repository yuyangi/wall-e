package show.me.the.code.nlp;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.memory.MemoryIndex;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TopFieldDocs;

import java.io.IOException;

public class Searcher {

    private final MemoryIndex index = new MemoryIndex();
    private final Analyzer analyzer = new StandardAnalyzer();

    public void addIndex(String field, String content) {
        index.addField(field, content, analyzer);
    }

    public String search(String query) throws ParseException, IOException {
        QueryParser parser = new QueryParser("content", analyzer);
        TopFieldDocs result = index.createSearcher().search(parser.parse(query), 3, Sort.RELEVANCE);
        return result.toString();
    }

}
