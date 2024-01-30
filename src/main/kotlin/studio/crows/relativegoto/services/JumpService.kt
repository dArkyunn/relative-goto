package studio.crows.relativegoto.services

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.LogicalPosition
import com.intellij.openapi.editor.markup.HighlighterLayer
import com.intellij.openapi.editor.markup.RangeHighlighter
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.ui.JBColor

class JumpService(val editor: Editor) {

    private var highlighter : RangeHighlighter? = null

    fun goToRelativeLine(relativeLine: Int) {
        val targetLine = getTargetLine(relativeLine)

        editor.caretModel.primaryCaret.moveToLogicalPosition(LogicalPosition(
                targetLine, 0
        ))
        removeHighlight()
    }

    fun highlightLine(relativeLine: Int) {
        if (relativeLine == -1) {
            removeHighlight()
            return
        }

        addHighlight(relativeLine)
    }

    private fun getCurrentLine(): Int {
        return editor.document.getLineNumber(editor.caretModel.primaryCaret.offset)
    }

    private fun getTargetLine(relativeLine: Int): Int {
        val currentLine = getCurrentLine()
        val calculatedLine = currentLine + relativeLine

        if (calculatedLine < 0)
            return 0
        if (calculatedLine > getMaxLines())
            return getMaxLines()

        return calculatedLine
    }

    private fun getMaxLines(): Int {
        return editor.document.lineCount - 1
    }

    private fun removeHighlight() {
        if (highlighter == null)
            return

        editor.markupModel.removeHighlighter(this.highlighter!!)
        this.highlighter = null
    }

    private fun addHighlight(relativeLine: Int) {
        removeHighlight()

        val textAttributes = TextAttributes()
        textAttributes.backgroundColor = JBColor.ORANGE

        val highlighter: RangeHighlighter = editor.markupModel.addLineHighlighter(
                getTargetLine(relativeLine),
                HighlighterLayer.ERROR + 1,
                textAttributes
        )

        this.highlighter = highlighter
    }
}