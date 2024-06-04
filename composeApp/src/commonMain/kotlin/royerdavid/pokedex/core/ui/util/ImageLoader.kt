package royerdavid.pokedex.core.ui.util

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import okio.FileSystem
import org.koin.compose.koinInject
import royerdavid.pokedex.core.util.Logger


@OptIn(ExperimentalCoilApi::class)
@Composable
fun InitComposeImageLoader() {
    val logger = koinInject<Logger>()

    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .crossfade(true)
            .logger(CoilLogger(logger))
            .networkCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(context, 0.3)
                    .strongReferencesEnabled(true)
                    .build()
            }
            .diskCachePolicy(CachePolicy.ENABLED)
            .diskCache {
                newDiskCache()
            }
            .build()
    }
}

private fun newDiskCache(): DiskCache =
    DiskCache.Builder()
        .directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "image_cache")
        .maxSizeBytes(256L * 1024 * 1024) // 256 MB
        .build()

private class CoilLogger(
    private val logger: Logger,
    override var minLevel: coil3.util.Logger.Level = coil3.util.Logger.Level.Debug,
) : coil3.util.Logger {

    override fun log(
        tag: String,
        level: coil3.util.Logger.Level,
        message: String?,
        throwable: Throwable?
    ) {
        if (message != null) {
            logger.d(throwable = throwable, tag = tag, message = message)
        }
    }
}
