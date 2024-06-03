package royerdavid.pokedex.core.util

import co.touchlab.kermit.loggerConfigInit
import co.touchlab.kermit.platformLogWriter


interface Logger {
    val defaultTag: String

    /** Send a VERBOSE log */
    fun v(throwable: Throwable? = null, tag: String = defaultTag, message: String)

    /** Send a VERBOSE log */
    fun v(throwable: Throwable? = null, tag: String = defaultTag, message: () -> String)

    /** Send a DEBUG log */
    fun d(throwable: Throwable? = null, tag: String = defaultTag, message: String)

    /** Send a DEBUG log */
    fun d(throwable: Throwable? = null, tag: String = defaultTag, message: () -> String)

    /** Send an INFO log */
    fun i(throwable: Throwable? = null, tag: String = defaultTag, message: String)

    /** Send an INFO log */
    fun i(throwable: Throwable? = null, tag: String = defaultTag, message: () -> String)

    /** Send a WARNING log */
    fun w(throwable: Throwable? = null, tag: String = defaultTag, message: String)

    /** Send a WARNING log */
    fun w(throwable: Throwable? = null, tag: String = defaultTag, message: () -> String)

    /** Send an ERROR log */
    fun e(throwable: Throwable? = null, tag: String = defaultTag, message: String)

    /** Send an ERROR log */
    fun e(throwable: Throwable? = null, tag: String = defaultTag, message: () -> String)

    /** Send an ASSERT log */
    fun a(throwable: Throwable? = null, tag: String = defaultTag, message: String)

    /** Send an ASSERT log */
    fun a(throwable: Throwable? = null, tag: String = defaultTag, message: () -> String)
}

internal class KermitLogger(override val defaultTag: String) : Logger {

    private val kermitLogger = co.touchlab.kermit.Logger(
        loggerConfigInit(platformLogWriter()),
        defaultTag
    )

    override fun v(throwable: Throwable?, tag: String, message: String) =
        kermitLogger.v(throwable, tag) { message }

    override fun v(throwable: Throwable?, tag: String, message: () -> String) =
        kermitLogger.v(throwable, tag, message)

    override fun d(throwable: Throwable?, tag: String, message: String) =
        kermitLogger.d(throwable, tag) { message }

    override fun d(throwable: Throwable?, tag: String, message: () -> String) =
        kermitLogger.d(throwable, tag, message)

    override fun i(throwable: Throwable?, tag: String, message: String) =
        kermitLogger.i(throwable, tag) { message }

    override fun i(throwable: Throwable?, tag: String, message: () -> String) =
        kermitLogger.i(throwable, tag, message)

    override fun w(throwable: Throwable?, tag: String, message: String) =
        kermitLogger.w(throwable, tag) { message }

    override fun w(throwable: Throwable?, tag: String, message: () -> String) =
        kermitLogger.w(throwable, tag, message)

    override fun e(throwable: Throwable?, tag: String, message: String) =
        kermitLogger.e(throwable, tag) { message }

    override fun e(throwable: Throwable?, tag: String, message: () -> String) =
        kermitLogger.e(throwable, tag, message)

    override fun a(throwable: Throwable?, tag: String, message: String) =
        kermitLogger.a(throwable, tag) { message }

    override fun a(throwable: Throwable?, tag: String, message: () -> String) =
        kermitLogger.a(throwable, tag, message)
}
