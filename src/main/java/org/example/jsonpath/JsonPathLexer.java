package org.example.jsonpath;

import com.intellij.lexer.FlexAdapter;
import org.example.jsonpath.lexer._JsonPathLexer;

public final class JsonPathLexer extends FlexAdapter {
    public JsonPathLexer() {
        super(new _JsonPathLexer(null));
    }
}
