package com.geminusporta.hectorvector

import com.geminusporta.hectorvector.services.DisplayService
import com.geminusporta.hectorvector.services.LoggingService

interface Shortcuts {
    val display: DisplayService
    get() = DisplayService

    val log: LoggingService
    get() = LoggingService
}