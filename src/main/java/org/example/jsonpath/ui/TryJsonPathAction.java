package org.example.jsonpath.ui;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.testFramework.LightVirtualFile;
import com.intellij.ui.jcef.JBCefApp;
import org.jetbrains.annotations.NotNull;

public final class TryJsonPathAction extends AnAction {

    public TryJsonPathAction() {
        super("Try JSONPath");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) return;

        LightVirtualFile file = new LightVirtualFile("Try JSONPath", TryJsonPathFileType.INSTANCE, "");
        FileEditorManager.getInstance(project).openFile(file, true, true);
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        e.getPresentation().setEnabledAndVisible(JBCefApp.isSupported());
    }
}
