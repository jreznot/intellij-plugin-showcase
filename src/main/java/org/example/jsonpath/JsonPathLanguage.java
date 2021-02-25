package org.example.jsonpath;

import com.intellij.lang.InjectableLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;

public final class JsonPathLanguage extends Language implements InjectableLanguage {

    public final static JsonPathLanguage INSTANCE = new JsonPathLanguage();

    private JsonPathLanguage() {
        super("JSONPath");
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }

    @Override
    public LanguageFileType getAssociatedFileType() {
        return JsonPathFileType.INSTANCE;
    }
}
