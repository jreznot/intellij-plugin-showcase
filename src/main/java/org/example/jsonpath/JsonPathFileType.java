package org.example.jsonpath;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class JsonPathFileType extends LanguageFileType {

    public static final JsonPathFileType INSTANCE = new JsonPathFileType();

    private JsonPathFileType() {
        super(JsonPathLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "JSONPath";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "JSONPath";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "jsonpath";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Json;
    }
}
