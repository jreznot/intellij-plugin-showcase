package org.example.jsonpath.ui;

import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.util.UserDataHolderBase;
import com.intellij.ui.jcef.JBCefBrowser;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.beans.PropertyChangeListener;

public final class TryJsonPathEditor extends UserDataHolderBase implements FileEditor {
    private final JBCefBrowser browser;

    public TryJsonPathEditor() {
        browser = new JBCefBrowser("http://jsonpath.com/");
    }

    @Override
    public @NotNull JComponent getComponent() {
        return browser.getComponent();
    }

    @Override
    public @Nullable JComponent getPreferredFocusedComponent() {
        return browser.getComponent();
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) @NotNull String getName() {
        return "TryJSONPath";
    }

    @Override
    public void setState(@NotNull FileEditorState state) {
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener) {
    }

    @Override
    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener) {
    }

    @Override
    public @Nullable FileEditorLocation getCurrentLocation() {
        return null;
    }

    @Override
    public void dispose() {
        browser.dispose();
    }
}
