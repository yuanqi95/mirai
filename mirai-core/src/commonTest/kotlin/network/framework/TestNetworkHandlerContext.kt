/*
 * Copyright 2019-2022 Mamoe Technologies and contributors.
 *
 *  此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 *  Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 *  https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package net.mamoe.mirai.internal.network.framework

import net.mamoe.mirai.internal.MockBot
import net.mamoe.mirai.internal.QQAndroidBot
import net.mamoe.mirai.internal.network.component.ComponentStorage
import net.mamoe.mirai.internal.network.component.ConcurrentComponentStorage
import net.mamoe.mirai.internal.network.components.SsoProcessor
import net.mamoe.mirai.internal.network.components.SsoProcessorContextImpl
import net.mamoe.mirai.internal.network.components.SsoProcessorImpl
import net.mamoe.mirai.internal.network.handler.NetworkHandlerContext
import net.mamoe.mirai.internal.network.handler.state.LoggingStateObserver
import net.mamoe.mirai.internal.network.handler.state.SafeStateObserver
import net.mamoe.mirai.internal.network.handler.state.StateObserver
import net.mamoe.mirai.utils.MiraiLogger

internal class TestNetworkHandlerContext(
    override val bot: QQAndroidBot = MockBot(),
    override val logger: MiraiLogger = MiraiLogger.Factory.create(TestNetworkHandlerContext::class, "Test"),
    components: ComponentStorage = ConcurrentComponentStorage().apply {
        set(SsoProcessor, SsoProcessorImpl(SsoProcessorContextImpl(bot)))
        set(
            StateObserver,
            SafeStateObserver(
                LoggingStateObserver(MiraiLogger.Factory.create(LoggingStateObserver::class, "States")),
                MiraiLogger.Factory.create(LoggingStateObserver::class, "StateObserver errors")
            )
        )
    }
) : NetworkHandlerContext, ComponentStorage by components

