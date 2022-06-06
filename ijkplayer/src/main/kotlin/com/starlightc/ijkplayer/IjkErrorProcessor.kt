package com.starlightc.ijkplayer


import com.starlightc.video.core.Constant
import com.starlightc.video.core.SimpleLogger
import com.starlightc.video.core.interfaces.ErrorProcessor
import tv.danmaku.ijk.media.player.IMediaPlayer

/**
 * @author StarlightC
 * @since 2022/4/26
 */
class IjkErrorProcessor: ErrorProcessor {
    override fun getName(): String {
        return Constant.IJK_ERROR_PROCESSOR
    }

    override fun process(what: Int, extra: Int): Int {
        return when (what) {
            IMediaPlayer.MEDIA_ERROR_IO -> {
                SimpleLogger.instance.debugI("视频错误: IO")
                1
            }
            IMediaPlayer.MEDIA_ERROR_SERVER_DIED -> {
                SimpleLogger.instance.debugI("视频错误: SEVER_DIED")
                1
            }
            IMediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK -> {
                SimpleLogger.instance.debugI("视频错误: NOT_VALID_FOR_PROGRESSIVE_PLAYBACK")
                1
            }
            IMediaPlayer.MEDIA_ERROR_UNSUPPORTED -> {
                SimpleLogger.instance.debugI("视频错误: UNSUPPORTED")
                1
            }
            IMediaPlayer.MEDIA_ERROR_UNKNOWN -> {
                SimpleLogger.instance.debugI("视频错误: UNKNOWN")
                1
            }
            IMediaPlayer.MEDIA_ERROR_TIMED_OUT -> {
                SimpleLogger.instance.debugI("视频错误: TIMED_OUT")
                2
            }
            IMediaPlayer.MEDIA_ERROR_MALFORMED -> {
                SimpleLogger.instance.debugI("视频错误: MALFORMED")
                -1
            }
            else -> {
                SimpleLogger.instance.debugI("视频错误: What -> $what  Ext -> $extra")
                -1
            }
        }
    }
}