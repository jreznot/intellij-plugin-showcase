package org.example.jsonpath.psi;

import com.intellij.psi.tree.IElementType;
import org.example.jsonpath.JsonPathLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public final class JsonPathElementType extends IElementType {
    public JsonPathElementType(@NotNull @NonNls String debugName) {
        super(debugName, JsonPathLanguage.INSTANCE);
    }
}
