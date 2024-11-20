package org.example.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class MyPluginAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog(
                e.project,
                "Hello from MyPluginAction!",
                "Information",
                Messages.getInformationIcon()
        )
    }
}
