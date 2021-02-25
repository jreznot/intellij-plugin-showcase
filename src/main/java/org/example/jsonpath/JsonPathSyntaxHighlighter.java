package org.example.jsonpath;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.example.jsonpath.psi.JsonPathTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

final class JsonPathSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey JSONPATH_KEYWORD =
            createTextAttributesKey("JSONPATH.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey JSONPATH_IDENTIFIER =
            createTextAttributesKey("JSONPATH.IDENTIFIER", DefaultLanguageHighlighterColors.INSTANCE_FIELD);

    public static final TextAttributesKey JSONPATH_CONTEXT =
            createTextAttributesKey("JSONPATH.CONTEXT", DefaultLanguageHighlighterColors.STATIC_FIELD);

    public static final TextAttributesKey JSONPATH_NUMBER =
            createTextAttributesKey("JSONPATH.NUMBER", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey JSONPATH_BRACKETS =
            createTextAttributesKey("JSONPATH.BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);

    public static final TextAttributesKey JSONPATH_COMMA =
            createTextAttributesKey("JSONPATH.COMMA", DefaultLanguageHighlighterColors.COMMA);

    public static final TextAttributesKey JSONPATH_DOT =
            createTextAttributesKey("JSONPATH.DOT", DefaultLanguageHighlighterColors.DOT);

    private static final Map<IElementType, TextAttributesKey> ourMap;

    static {
        ourMap = new HashMap<>();

        fillMap(ourMap, JSONPATH_KEYWORD, JsonPathTypes.WILDCARD);
        fillMap(ourMap, JSONPATH_IDENTIFIER, JsonPathTypes.IDENTIFIER);
        fillMap(ourMap, JSONPATH_CONTEXT, JsonPathTypes.ROOT_CONTEXT, JsonPathTypes.EVAL_CONTEXT);
        fillMap(ourMap, JSONPATH_BRACKETS, JsonPathTypes.LBRACKET, JsonPathTypes.RBRACKET);
        fillMap(ourMap, JSONPATH_DOT, JsonPathTypes.DOT, JsonPathTypes.RECURSIVE_DESCENT);
        fillMap(ourMap, JSONPATH_COMMA, JsonPathTypes.COMMA);
        fillMap(ourMap, JSONPATH_NUMBER, JsonPathTypes.NUMBER);
    }

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new JsonPathLexer();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return pack(ourMap.get(tokenType));
    }
}
