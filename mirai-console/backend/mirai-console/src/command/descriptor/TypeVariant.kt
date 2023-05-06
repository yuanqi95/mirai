/*
 * Copyright 2019-2023 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/dev/LICENSE
 */

package net.mamoe.mirai.console.command.descriptor

import net.mamoe.mirai.console.command.parse.CommandValueArgument
import net.mamoe.mirai.console.internal.data.castOrNull
import net.mamoe.mirai.console.internal.data.kClassQualifiedName
import net.mamoe.mirai.message.data.*
import net.mamoe.mirai.utils.NotStableForInheritance
import kotlin.reflect.KType
import kotlin.reflect.typeOf

/**
 * Intrinsic variant of an [CommandValueArgument].
 *
 * The *intrinsic* reveals the independent conversion property of this type.
 * Conversion with [TypeVariant] is out of any contextual resource,
 * except the [output type][TypeVariant.outType] declared by the [TypeVariant] itself.
 *
 *
 * [TypeVariant] is not necessary for all [CommandValueArgument]s.
 *
 * @param OutType the type this [TypeVariant] can map a argument [Message] to .
 *
 * @see CommandValueArgument.typeVariants
 */
@NotStableForInheritance
public interface TypeVariant<out OutType> {
    /**
     * The reified type of [OutType]
     */
    public val outType: KType

    /**
     * Maps an [valueArgument] to [outType]
     *
     * @see CommandValueArgument.value
     */
    public fun mapValue(valueArgument: Message): OutType
}

/**
 * Creates a [TypeVariant] with reified [OutType].
 * @since 2.15
 */
public inline fun <reified OutType> TypeVariant(crossinline mapValue: (valueParameter: Message) -> OutType): TypeVariant<OutType> {
    return object : TypeVariant<OutType> {
        override val outType: KType = typeOf<OutType>()
        override fun mapValue(valueArgument: Message): OutType = mapValue(valueArgument)
    }
}

@ExperimentalCommandDescriptors
public object MessageContentTypeVariant : TypeVariant<MessageContent> {
    override val outType: KType = typeOf<MessageContent>()
    override fun mapValue(valueArgument: Message): MessageContent =
        valueArgument.castOrNull<MessageContent>()
            ?: error("Accepts MessageContent only but given ${valueArgument.kClassQualifiedName}")
}

@ExperimentalCommandDescriptors
public object MessageChainTypeVariant : TypeVariant<MessageChain> {
    override val outType: KType = typeOf<MessageChain>()
    override fun mapValue(valueArgument: Message): MessageChain = valueArgument.toMessageChain()
}

@ExperimentalCommandDescriptors
public object ContentStringTypeVariant : TypeVariant<String> {
    override val outType: KType = typeOf<String>()
    override fun mapValue(valueArgument: Message): String = valueArgument.content
}
