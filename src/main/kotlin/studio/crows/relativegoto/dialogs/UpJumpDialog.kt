package studio.crows.relativegoto.dialogs

import studio.crows.relativegoto.services.JumpService

class UpJumpDialog(service: JumpService) : AbstractJumpDialog(service) {
    override val prefix: String
        get() = "-"
}