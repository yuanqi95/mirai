/*
 * Copyright 2019-2022 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/dev/LICENSE
 */

package net.mamoe.mirai.internal.contact.active

import kotlinx.coroutines.launch
import net.mamoe.mirai.contact.MemberPermission
import net.mamoe.mirai.contact.checkBotPermission
import net.mamoe.mirai.contact.active.Active
import net.mamoe.mirai.data.GroupInfo
import net.mamoe.mirai.internal.contact.GroupImpl
import net.mamoe.mirai.internal.contact.active.GroupActiveProtocol.getGroupLevelInfo
import net.mamoe.mirai.internal.contact.active.GroupActiveProtocol.setGroupLevelInfo
import net.mamoe.mirai.internal.contact.groupCode

internal class ActiveImpl(
    private val group: GroupImpl,
    groupInfo: GroupInfo
) : Active {

    override var rankTitles: Map<Int, String> = groupInfo.rankTitles
        set(newValue) {
            if (newValue.isNotEmpty()) {
                group.checkBotPermission(MemberPermission.ADMINISTRATOR)
            }
            group.launch {
                if (newValue.isNotEmpty()) {
                    group.bot.setGroupLevelInfo(groupCode = group.groupCode, titles = newValue)
                }
                field = group.bot.getGroupLevelInfo(groupCode = group.groupCode).levelName
                    .mapKeys { (level, _) -> level.removePrefix("lvln").toInt() }
            }
        }
}