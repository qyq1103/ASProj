package org.qyq.`as`.proj.common.component

import android.app.Application
import com.google.gson.Gson
import org.qyq.hi.ability.hi_library.log.HiLogConfig
import org.qyq.hi.ability.hi_library.log.HiLogConfig.JsonParser
import org.qyq.hi.ability.hi_library.log.HiLogManager
import org.qyq.hi.ability.hi_library.log.pritenter.HiConsolePrinter

/**
 *
 * @Author: Net Spirit
 * @Time: 2023/5/24 22:55
 * @FixAuthor:
 * @FixTime:
 * @Desc: BaseApplication
 * 1、初始化HiLog框架
 *
 */
open class HiBaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initLog()
    }

    /**
     * HiLog框架初始化
     */
    private fun initLog() {
        HiLogManager.init(object : HiLogConfig() {
            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }

            override fun includeThread(): Boolean {
                return true
            }
        }, HiConsolePrinter())

    }
}