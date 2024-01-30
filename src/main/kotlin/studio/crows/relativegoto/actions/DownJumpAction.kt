package studio.crows.relativegoto.actions

import com.intellij.openapi.actionSystem.*
import studio.crows.relativegoto.dialogs.DownJumpDialog
import studio.crows.relativegoto.services.JumpService

class DownJumpAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val service = JumpService(e.getData(CommonDataKeys.EDITOR)!!)
        val dialog = DownJumpDialog(service)
        dialog.show()
    }
}