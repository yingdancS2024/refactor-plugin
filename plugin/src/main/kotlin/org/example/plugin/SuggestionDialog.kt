import com.intellij.openapi.ui.DialogWrapper
import javax.swing.*

class SuggestionDialog(private val suggestions: String) : DialogWrapper(true) {
    init {
        init()
        title = "Refactor Suggestions"
    }

    override fun createCenterPanel(): JComponent? {
        val panel = JPanel()
        panel.add(JLabel(suggestions))
        return panel
    }
}

