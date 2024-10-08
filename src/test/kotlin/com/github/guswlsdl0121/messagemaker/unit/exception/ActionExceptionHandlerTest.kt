package com.github.guswlsdl0121.messagemaker.unit.exception

import com.github.guswlsdl0121.messagemaker.exception.NoChangesException
import com.intellij.notification.NotificationType

class ActionExceptionHandlerTest : AbstractActionExceptionHandlerTest() {
    fun test_빈_변경사항에_대한_경고알림표시() {
        testExceptionHandling(
            NoChangesException(),
            "MessageMaker: No Changes Detected",
            NotificationType.WARNING
        )
    }

    fun test_예상치_못한_예외발생시_에러알림표시_및_로그기록() {
        testUnexpectedExceptionHandling(
            RuntimeException("Test unexpected exception"),
            "MessageMaker: Unexpected Error",
            NotificationType.ERROR,
            "An unexpected error occurred. Please check the logs for more details."
        )
    }
}
