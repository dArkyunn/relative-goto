package studio.crows.relativegoto.dialogs

import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.ValidationInfo
import studio.crows.relativegoto.services.JumpService
import java.awt.BorderLayout
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

abstract class AbstractJumpDialog(private val service: JumpService) : DialogWrapper(service.editor.project) {

    private val panel: JComponent
    abstract val prefix: String

    init {
        this.panel = createPanel()
        this.init()
    }

    private fun createPanel(): JComponent {
        this.title = "Go to Relative Line"

        val panel = JPanel(BorderLayout())

        val textField = JTextField(prefix)
        textField.columns = 1
        textField.document.addDocumentListener(object : DocumentListener {
            override fun insertUpdate(e: DocumentEvent?) {
                if (doValidate() == null) {
                    initValidation()
                    runHighlighter(getLine())
                }
            }

            override fun removeUpdate(e: DocumentEvent?) {
                runHighlighter(-1)
            }

            override fun changedUpdate(e: DocumentEvent?) {
                if (doValidate() == null)
                    runHighlighter(getLine())
            }

            fun runHighlighter(line: Int) {
                service.highlightLine(line)
            }
        })
        textField.name = TEXT_FIELD_NAME

        val label = JLabel("Line: ")
        label.labelFor = textField
        label.name = TEXT_FIELD_LABEL_NAME

        panel.add(label, BorderLayout.WEST)
        panel.add(textField, BorderLayout.CENTER)

        return panel
    }

    override fun createCenterPanel(): JComponent? {
        return this.panel
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return getTextField()
    }

    override fun postponeValidation(): Boolean {
        return true
    }

    override fun doValidate(): ValidationInfo? {
        val textField = getTextField()

        if (textField.text.trim().toIntOrNull() == null) {
            return ValidationInfo("Line should be a number")
        }

        return null
    }

    override fun doOKAction() {
        val line = getLine()
        service.goToRelativeLine(line)
        close(OK_EXIT_CODE)
    }

    private fun getTextField(): JTextField {
        val textField = this.panel.components.asList().stream().filter { it.name.equals(TEXT_FIELD_NAME) }.findFirst()

        return textField.get() as JTextField
    }

    private fun getLine(): Int {
        return getTextField().text.trim().toInt()
    }

    companion object {
        private const val TEXT_FIELD_NAME: String = "TextField"
        private const val TEXT_FIELD_LABEL_NAME: String = "Label"
    }
}