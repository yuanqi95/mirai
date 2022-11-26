/*
 * Copyright 2019-2022 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/dev/LICENSE
 */

package net.mamoe.mirai.contact.essence

import net.mamoe.mirai.message.data.MessageSource
import net.mamoe.mirai.utils.Streamable

/**
 *
 * @since 2.14
 */
public interface Essences : Streamable<EssenceMessageRecord> {
    public suspend fun page(start: Int, limit: Int): List<EssenceMessageRecord>

    public suspend fun share(source: MessageSource)

    public suspend fun remove(source: MessageSource)
}