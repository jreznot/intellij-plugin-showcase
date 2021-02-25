package org.example.jsonpath.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.example.jsonpath.JsonPathFileType;
import org.example.jsonpath.JsonPathLanguage;
import org.jetbrains.annotations.NotNull;

public final class JsonPathFile extends PsiFileBase {
    public JsonPathFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, JsonPathLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return JsonPathFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "JsonPathFile";
    }
}
