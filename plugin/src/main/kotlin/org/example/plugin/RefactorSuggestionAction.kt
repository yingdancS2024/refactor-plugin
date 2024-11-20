package com.example.plugin

import SuggestionDialog
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.openapi.ui.Messages

class RefactorSuggestionAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val project: Project? = event.project
        if (project != null) {
            val psiManager = PsiManager.getInstance(project)
            val baseDir = project.baseDir
            val virtualFiles = baseDir.children

            val suggestions = StringBuilder("Refactor Suggestions:\n")
            for (file in virtualFiles) {
                val psiFile = psiManager.findFile(file)
                if (psiFile != null && psiFile.text.contains("var")) {
                    suggestions.append("- Replace 'var' with 'val' in file: ${psiFile.name}\n")
                }
            }

            SuggestionDialog(suggestions.toString()).showAndGet()

        }
    }
}
