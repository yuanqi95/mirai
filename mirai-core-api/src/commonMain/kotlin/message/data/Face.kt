/*
 * Copyright 2019-2020 Mamoe Technologies and contributors.
 *
 *  此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 *  Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 *  https://github.com/mamoe/mirai/blob/master/LICENSE
 */

@file:JvmMultifileClass
@file:JvmName("MessageUtils")

package net.mamoe.mirai.message.data

import kotlinx.serialization.Serializable
import net.mamoe.mirai.message.code.CodableMessage

/**
 * QQ 自带表情
 *
 * ## mirai 码支持
 * 格式: &#91;mirai:face:*[id]*&#93;
 */
@Serializable
public data class Face(public val id: Int) : // used in delegation
    MessageContent, CodableMessage {

    public override fun toString(): String = "[mirai:face:$id]"
    public override fun contentToString(): String = if (id >= names.size) {
        "[表情]"
    } else names[id]

    public override fun equals(other: Any?): Boolean = other is Face && other.id == this.id
    public override fun hashCode(): Int = id

    /**
     * @author LamGC
     */
    private companion object {
        val names: Array<String> = Array(290) { "[表情]" }

        init {
            names[0] = "[惊讶]"
            names[1] = "[撇嘴]"
            names[2] = "[色]"
            names[3] = "[发呆]"
            names[4] = "[得意]"
            names[5] = "[流泪]"
            names[6] = "[害羞]"
            names[7] = "[闭嘴]"
            names[8] = "[睡]"
            names[9] = "[大哭]"
            names[10] = "[尴尬]"
            names[11] = "[发怒]"
            names[12] = "[调皮]"
            names[13] = "[呲牙]"
            names[14] = "[微笑]"
            names[15] = "[难过]"
            names[16] = "[酷]"
            names[18] = "[抓狂]"
            names[19] = "[吐]"
            names[20] = "[偷笑]"
            names[21] = "[可爱]"
            names[22] = "[白眼]"
            names[23] = "[傲慢]"
            names[24] = "[饥饿]"
            names[25] = "[困]"
            names[26] = "[惊恐]"
            names[27] = "[流汗]"
            names[28] = "[憨笑]"
            names[29] = "[悠闲]"
            names[30] = "[奋斗]"
            names[31] = "[咒骂]"
            names[32] = "[疑问]"
            names[33] = "[嘘]"
            names[34] = "[晕]"
            names[35] = "[折磨]"
            names[36] = "[衰]"
            names[37] = "[骷髅]"
            names[38] = "[敲打]"
            names[39] = "[再见]"
            names[41] = "[发抖]"
            names[42] = "[爱情]"
            names[43] = "[跳跳]"
            names[46] = "[猪头]"
            names[49] = "[拥抱]"
            names[53] = "[蛋糕]"
            names[54] = "[闪电]"
            names[55] = "[炸弹]"
            names[56] = "[刀]"
            names[57] = "[足球]"
            names[59] = "[便便]"
            names[60] = "[咖啡]"
            names[61] = "[饭]"
            names[63] = "[玫瑰]"
            names[64] = "[凋谢]"
            names[66] = "[爱心]"
            names[67] = "[心碎]"
            names[69] = "[礼物]"
            names[74] = "[太阳]"
            names[75] = "[月亮]"
            names[76] = "[赞]"
            names[77] = "[踩]"
            names[78] = "[握手]"
            names[79] = "[胜利]"
            names[85] = "[飞吻]"
            names[86] = "[怄火]"
            names[89] = "[西瓜]"
            names[96] = "[冷汗]"
            names[97] = "[擦汗]"
            names[98] = "[抠鼻]"
            names[99] = "[鼓掌]"
            names[100] = "[糗大了]"
            names[101] = "[坏笑]"
            names[102] = "[左哼哼]"
            names[103] = "[右哼哼]"
            names[104] = "[哈欠]"
            names[105] = "[鄙视]"
            names[106] = "[委屈]"
            names[107] = "[快哭了]"
            names[108] = "[阴险]"
            names[109] = "[亲亲]"
            names[110] = "[吓]"
            names[111] = "[可怜]"
            names[112] = "[菜刀]"
            names[113] = "[啤酒]"
            names[114] = "[篮球]"
            names[115] = "[乒乓]"
            names[116] = "[示爱]"
            names[117] = "[瓢虫]"
            names[118] = "[抱拳]"
            names[119] = "[勾引]"
            names[120] = "[拳头]"
            names[121] = "[差劲]"
            names[122] = "[爱你]"
            names[123] = "[NO]"
            names[124] = "[OK]"
            names[125] = "[转圈]"
            names[126] = "[磕头]"
            names[127] = "[回头]"
            names[128] = "[跳绳]"
            names[129] = "[挥手]"
            names[130] = "[激动]"
            names[131] = "[街舞]"
            names[132] = "[献吻]"
            names[133] = "[左太极]"
            names[134] = "[右太极]"
            names[136] = "[双喜]"
            names[137] = "[鞭炮]"
            names[138] = "[灯笼]"
            names[140] = "[K歌]"
            names[144] = "[喝彩]"
            names[145] = "[祈祷]"
            names[146] = "[爆筋]"
            names[147] = "[棒棒糖]"
            names[148] = "[喝奶]"
            names[151] = "[飞机]"
            names[158] = "[钞票]"
            names[168] = "[药]"
            names[169] = "[手枪]"
            names[171] = "[茶]"
            names[172] = "[眨眼睛]"
            names[173] = "[泪奔]"
            names[174] = "[无奈]"
            names[175] = "[卖萌]"
            names[176] = "[小纠结]"
            names[177] = "[喷血]"
            names[178] = "[斜眼笑]"
            names[179] = "[doge]"
            names[180] = "[惊喜]"
            names[181] = "[骚扰]"
            names[182] = "[笑哭]"
            names[183] = "[我最美]"
            names[184] = "[河蟹]"
            names[185] = "[羊驼]"
            names[187] = "[幽灵]"
            names[188] = "[蛋]"
            names[190] = "[菊花]"
            names[192] = "[红包]"
            names[193] = "[大笑]"
            names[194] = "[不开心]"
            names[197] = "[冷漠]"
            names[198] = "[呃]"
            names[199] = "[好棒]"
            names[200] = "[拜托]"
            names[201] = "[点赞]"
            names[202] = "[无聊]"
            names[203] = "[托脸]"
            names[204] = "[吃]"
            names[205] = "[送花]"
            names[206] = "[害怕]"
            names[207] = "[花痴]"
            names[208] = "[小样儿]"
            names[210] = "[飙泪]"
            names[211] = "[我不看]"
            names[212] = "[托腮]"
            names[214] = "[啵啵]"
            names[215] = "[糊脸]"
            names[216] = "[拍头]"
            names[217] = "[扯一扯]"
            names[218] = "[舔一舔]"
            names[219] = "[蹭一蹭]"
            names[220] = "[拽炸天]"
            names[221] = "[顶呱呱]"
            names[222] = "[抱抱]"
            names[223] = "[暴击]"
            names[224] = "[开枪]"
            names[225] = "[撩一撩]"
            names[226] = "[拍桌]"
            names[227] = "[拍手]"
            names[228] = "[恭喜]"
            names[229] = "[干杯]"
            names[230] = "[嘲讽]"
            names[231] = "[哼]"
            names[232] = "[佛系]"
            names[233] = "[掐一掐]"
            names[234] = "[惊呆]"
            names[235] = "[颤抖]"
            names[236] = "[啃头]"
            names[237] = "[偷看]"
            names[238] = "[扇脸]"
            names[239] = "[原谅]"
            names[240] = "[喷脸]"
            names[241] = "[生日快乐]"
            names[242] = "[头撞击]"
            names[243] = "[甩头]"
            names[244] = "[扔狗]"
            names[245] = "[加油必胜]"
            names[246] = "[加油抱抱]"
            names[247] = "[口罩护体]"
            names[260] = "[搬砖中]"
            names[261] = "[忙到飞起]"
            names[262] = "[脑阔疼]"
            names[263] = "[沧桑]"
            names[264] = "[捂脸]"
            names[265] = "[辣眼睛]"
            names[266] = "[哦哟]"
            names[267] = "[头秃]"
            names[268] = "[问号脸]"
            names[269] = "[暗中观察]"
            names[270] = "[emm]"
            names[271] = "[吃瓜]"
            names[272] = "[呵呵哒]"
            names[273] = "[我酸了]"
            names[274] = "[太南了]"
            names[276] = "[辣椒酱]"
            names[277] = "[汪汪]"
            names[278] = "[汗]"
            names[279] = "[打脸]"
            names[280] = "[击掌]"
            names[281] = "[无眼笑]"
            names[282] = "[敬礼]"
            names[283] = "[狂笑]"
            names[284] = "[面无表情]"
            names[285] = "[摸鱼]"
            names[286] = "[魔鬼笑]"
            names[287] = "[哦]"
            names[288] = "[请]"
            names[289] = "[睁眼]"
        }
    }
}