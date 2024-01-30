package studio.crows.relativegoto.actions

import com.intellij.openapi.actionSystem.*
import studio.crows.relativegoto.dialogs.UpJumpDialog
import studio.crows.relativegoto.services.JumpService

class UpJumpAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val service = JumpService(e.getData(CommonDataKeys.EDITOR)!!)
        val dialog = UpJumpDialog(service)
        dialog.show()
    }
}