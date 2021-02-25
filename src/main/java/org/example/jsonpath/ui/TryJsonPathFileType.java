package org.example.jsonpath.ui;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public final class TryJsonPathFileType implements FileType {

    public static final TryJsonPathFileType INSTANCE = new TryJsonPathFileType();

    @Override
    public @NotNull String getName() {
        return "TryJSONPath";
    }

    @Override
    public @NotNull String getDescription() {
        return "JSONPath";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "try-jsonpath";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Json;
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public @Nullable String getCharset(@NotNull VirtualFile file, byte @NotNull [] content) {
        return null;
    }
}
