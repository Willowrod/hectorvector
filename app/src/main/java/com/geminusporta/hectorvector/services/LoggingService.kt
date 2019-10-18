package com.geminusporta.hectorvector.services

import android.util.Log
import com.geminusporta.hectorvector.BuildConfig
import com.geminusporta.hectorvector.constants.ErrorLevels

/**
 * Created by mikehall on 06/12/2017.
 */


object LoggingService {

    private val LOG_TAG = "HECTOR_VECTOR"
    private var LOGGIN_ON = true
    private var LOG_STANDARD = true
    private var LOG_ERRORS = true
    private var LOG_NETWORK = true
    private var LOG_LONG_LOGS = true
    private var LOG_LISTS = true
    private val LOG_CHUNK_SIZE = 4000
    private val DEFAULT_LOG_LEVEL = ErrorLevels.Debug

    init {

        if (!BuildConfig.DEBUG) {
            LOGGIN_ON = false
            LOG_STANDARD = false
            LOG_ERRORS = false
            LOG_NETWORK = false
            LOG_LONG_LOGS = false
            LOG_LISTS = false
        }
    }

    fun AlwaysLog(tag: String, entry: String, level: ErrorLevels = DEFAULT_LOG_LEVEL) {
        when (level) {
            ErrorLevels.Assert -> Log.wtf(tag, entry)
            ErrorLevels.Error -> Log.e(tag, entry)
            ErrorLevels.Warn -> Log.w(tag, entry)
            ErrorLevels.Info -> Log.i(tag, entry)
            ErrorLevels.Debug -> Log.d(tag, entry)
            ErrorLevels.Verbose -> Log.v(tag, entry)
        }
    }

    fun Log(entry: String, level: ErrorLevels = DEFAULT_LOG_LEVEL) {
        if (LogsNormalLogEntries()) {
            AlwaysLog(LOG_TAG, entry, level)
        }
    }

    fun LogBool(condition: Boolean, description: String, level: ErrorLevels = DEFAULT_LOG_LEVEL) {
        if (LogsNormalLogEntries()) {
            if (condition) {
                AlwaysLog(LOG_TAG, "$description: True", level)
            } else {
                AlwaysLog(LOG_TAG, "$description: False", level)
            }
        }
    }

    fun LogNetwork(entry: String, level: ErrorLevels = DEFAULT_LOG_LEVEL) {
        if (LogsNetworkEntries()) {
            AlwaysLog("$LOG_TAG:NW", entry, level)
        }
    }

    fun LogLongEntry(entry: String, level: ErrorLevels = DEFAULT_LOG_LEVEL) {
        if (LogsLongEntries()) {
            val lengthOfEntry = entry.length
            var currentStartChunk = 0
            if (lengthOfEntry > LOG_CHUNK_SIZE) {
                var numberOfChunks = lengthOfEntry / LOG_CHUNK_SIZE
                if (lengthOfEntry % LOG_CHUNK_SIZE > 0) {
                    numberOfChunks++
                }
                for (a in 1..numberOfChunks) {
                    val lastPossibleCharacterThisTime = LOG_CHUNK_SIZE * a
                    when {
                        lastPossibleCharacterThisTime < lengthOfEntry -> AlwaysLog(
                            LOG_TAG + ":LG_${a}_of_$numberOfChunks",
                            entry.substring(currentStartChunk, lastPossibleCharacterThisTime),
                            level
                        )
                        else -> AlwaysLog(
                            LOG_TAG + ":LG_${a}_of_$numberOfChunks",
                            entry.substring(currentStartChunk),
                            level
                        )
                    }
                    currentStartChunk += LOG_CHUNK_SIZE
                }
            } else {
                AlwaysLog("$LOG_TAG:LG_1_of_1", entry, level)
            }
        }
    }


    fun LogError(entry: String?, level: ErrorLevels = ErrorLevels.Error) {
        if (LogsErrors() && entry != null) {
            AlwaysLog("$LOG_TAG:ERROR", entry, level)
        }
    }

    fun LogList(title: String, level: ErrorLevels = DEFAULT_LOG_LEVEL) {
        if (LogsLists()) {
            AlwaysLog("$LOG_TAG:LIST", title, level)
        }
    }

    fun LogList(
        title: String,
        list: HashMap<String, String>,
        level: ErrorLevels = DEFAULT_LOG_LEVEL
    ) {
        if (LogsLists()) {
            AlwaysLog("$LOG_TAG:LIST", "----------------", level)
            AlwaysLog("$LOG_TAG:LIST", title, level)
            for (a in list) {
                AlwaysLog("$LOG_TAG:LIST", "${a.key} : ${a.value}", level)
            }
            AlwaysLog("$LOG_TAG:LIST", "----------------", level)
        }
    }

    private fun LogsNormalLogEntries(): Boolean {
        return LOGGIN_ON && LOG_STANDARD
    }

    private fun LogsErrors(): Boolean {
        return LOG_ERRORS
    }

    private fun LogsNetworkEntries(): Boolean {
        return LOGGIN_ON && LOG_NETWORK
    }

    private fun LogsLongEntries(): Boolean {
        return LOGGIN_ON && LOG_LONG_LOGS
    }

    private fun LogsLists(): Boolean {
        return LOGGIN_ON && LOG_LISTS
    }

}
