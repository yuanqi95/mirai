/*
 * Copyright 2019-2022 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/dev/LICENSE
 */

package net.mamoe.mirai.internal.network.protocol.data.jce

import kotlinx.serialization.Serializable
import net.mamoe.mirai.internal.utils.io.JceStruct
import net.mamoe.mirai.internal.utils.io.serialization.tars.TarsId


@Serializable
internal class SetGroupReq(
    @JvmField @TarsId(0) val reqtype: Int = 0,
    @JvmField @TarsId(1) val uin: Long = 0L,
    @JvmField @TarsId(2) val vecBody: ByteArray? = null
) : JceStruct

@Serializable
internal class SetGroupResp(
    @JvmField @TarsId(0) val reqtype: Byte = 0,
    @JvmField @TarsId(1) val result: Byte = 0,
    @JvmField @TarsId(2) val vecBody: ByteArray? = null,
    @JvmField @TarsId(3) val errorString: String = ""
) : JceStruct