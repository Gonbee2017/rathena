// [GonBee]
// パーティーBOT機能の内部から参照されるあらゆるものを宣言、または定義する。

#ifndef PYBOT_INTERNAL_HPP
#define PYBOT_INTERNAL_HPP

#include "../common/malloc.hpp"
#include "../common/mmo.hpp"
#include "../common/random.hpp"
#include "../common/showmsg.hpp"
#include "../common/socket.hpp"
#include "../common/sql.hpp"
#include "../common/strlib.hpp"
#include "../common/timer.hpp"
#include "../common/utils.hpp"
#include "atcommand.hpp"
#include "battle.hpp"
#include "chrif.hpp"
#include "clan.hpp"
#include "clif.hpp"
#include "guild.hpp"
#include "homunculus.hpp"
#include "intif.hpp"
#include "itemdb.hpp"
#include "log.hpp"
#include "map.hpp"
#include "mob.hpp"
#include "npc.hpp"
#include "party.hpp"
#include "pc.hpp"
#include "pc_groups.hpp"
#include "pet.hpp"
#include "pybot_external.hpp"
#include "skill.hpp"
#include "status.hpp"
#include "storage.hpp"
#include "trade.hpp"
#include "unit.hpp"

#include <algorithm>
#include <array>
#include <cctype>
#include <climits>
#include <cstdarg>
#include <cstddef>
#include <cstdint>
#include <cstdlib>
#include <cstring>
#include <ctime>
#include <functional>
#include <initializer_list>
#include <iomanip>
#include <iterator>
#include <list>
#include <memory>
#include <sstream>
#include <stdexcept>
#include <string>
#include <type_traits>
#include <typeindex>
#include <typeinfo>
#include <unordered_map>
#include <unordered_set>
#include <utility>
#include <vector>

#undef max
#undef min

// -----------------------------------------------------------------------------
// マクロの定義

// AIにおけるスキル使用手続きのマップ値を初期化する。
#define AI_SKILL_USE_PROC(\
	kid,   /* スキルID。 */\
	nklv,  /* 最小スキルレベル。 */\
	xklv,  /* 最大スキルレベル。 */\
	bmf,   /* 戦闘モードのフラグ。 */\
	pf,    /* 一次バトラーのフラグ。 */\
	wf,    /* 歩行中のフラグ。 */\
	af,    /* 攻撃されているフラグ */\
	sp_rat /* SPの四分率。 */\
) ai_t::skill_use_proc{unbind(&AI_SKILL_USE_DEF(kid)), kid, nklv, xklv, bmf, pf, wf, af, sp_rat}

// AIにおけるスキル使用手続きのマップ値(タイプ付き)を初期化する。
#define AI_SKILL_USE_PROC_T(\
	kid,   /* スキルID。 */\
	typ,   /* タイプ。 */\
	nklv,  /* 最小スキルレベル。 */\
	xklv,  /* 最大スキルレベル。 */\
	bmf,   /* 戦闘モードのフラグ。 */\
	pf,    /* 一次バトラーのフラグ。 */\
	wf,    /* 歩行中のフラグ。 */\
	af,    /* 攻撃されているフラグ */\
	sp_rat /* SPの四分率。 */\
) ai_t::skill_use_proc{unbind(&AI_SKILL_USE_DEF_T(kid, typ)), kid, nklv, xklv, bmf, pf, wf, af, sp_rat}

// AIにおけるスキル使用手続きのマップ値(他のハンドラに委任)を初期化する。
#define AI_SKILL_USE_PROC_D(\
	kid,     /* スキルID。 */\
	inv_kid, /* 呼び出すスキルID。 */\
	nklv,    /* 最小スキルレベル。 */\
	xklv,    /* 最大スキルレベル。 */\
	bmf,     /* 戦闘モードのフラグ。 */\
	pf,      /* 一次バトラーのフラグ。 */\
	wf,      /* 歩行中のフラグ。 */\
	af,      /* 攻撃されているフラグ */\
	sp_rat   /* SPの四分率。 */\
) ai_t::skill_use_proc{unbind(&AI_SKILL_USE_DEF(inv_kid)), kid, nklv, xklv, bmf, pf, wf, af, sp_rat}

// AIにおけるスキル使用手続きのマップ値(他のハンドラに委任、なおかつタイプ付き)を初期化する。
#define AI_SKILL_USE_PROC_DT(\
	kid,     /* スキルID。 */\
	inv_kid, /* 呼び出すスキルID。 */\
	typ,     /* タイプ。 */\
	nklv,    /* 最小スキルレベル。 */\
	xklv,    /* 最大スキルレベル。 */\
	bmf,     /* 戦闘モードのフラグ。 */\
	pf,      /* 一次バトラーのフラグ。 */\
	wf,      /* 歩行中のフラグ。 */\
	af,      /* 攻撃されているフラグ */\
	sp_rat   /* SPの四分率。 */\
) ai_t::skill_use_proc{unbind(&AI_SKILL_USE_DEF_T(inv_kid, typ)), kid, nklv, xklv, bmf, pf, wf, af, sp_rat}

// AIにおけるケミカル〇〇チャージの使用手続きのマップ値を初期化する。
#define AI_SKILL_USE_PROC_CP(\
	cp_id,  /* ケミカル〇〇チャージのスキルID。 */\
	equ,    /* 装備部位。 */\
	sc_typ, /* 状態変化のタイプ。 */\
	has_sk, /* 敵モンスターのスキル所持判定メンバ関数。 */\
	cp_nlv, /* ケミカル〇〇チャージの最小スキルレベル。 */\
	cp_xlv, /* ケミカル〇〇チャージの最大スキルレベル。 */\
	bmf,    /* 戦闘モードのフラグ。 */\
	pf,     /* 一次バトラーのフラグ。 */\
	wf,     /* 歩行中のフラグ。 */\
	af,     /* 攻撃されているフラグ */\
	sp_rat  /* SPの四分率。 */\
) ai_t::skill_use_proc{\
	AI_SKILL_USE_DEF(cp)(EQP_ ## equ, SC_CP_ ## sc_typ, &enemy_if::has_unequip_ ## has_sk ## _skill),\
	AM_CP_ ## cp_id, cp_nlv, cp_xlv, bmf, pf, wf, af, sp_rat\
}

// AIにおけるヒールの使用手続きのマップ値を初期化する。
#define AI_SKILL_USE_PROC_HEAL(\
	hp_rat,  /* HPの四分率。 */\
	hea_nlv, /* ヒールの最小スキルレベル。 */\
	hea_xlv, /* ヒールの最大スキルレベル。 */\
	bmf,     /* 戦闘モードのフラグ。 */\
	pf,      /* 一次バトラーのフラグ。 */\
	wf,      /* 歩行中のフラグ。 */\
	af,      /* 攻撃されているフラグ */\
	sp_rat   /* SPの四分率。 */\
) ai_t::skill_use_proc{AI_SKILL_USE_DEF(heal)(hp_rat), AL_HEAL, hea_nlv, hea_xlv, bmf, pf, wf, af, sp_rat}

// AIにおけるHP回復ポーションピッチャーの使用手続きのマップ値を初期化する。
#define AI_SKILL_USE_PROC_PP_HP(\
	hp_rat,  /* HPの四分率。 */\
	pp_nlv,  /* ポーションピッチャーの最小スキルレベル。 */\
	pp_xlv,  /* ポーションピッチャーの最大スキルレベル。 */\
	bmf,     /* 戦闘モードのフラグ。 */\
	pf,      /* 一次バトラーのフラグ。 */\
	wf,      /* 歩行中のフラグ。 */\
	af,      /* 攻撃されているフラグ */\
	sp_rat   /* SPの四分率。 */\
) ai_t::skill_use_proc{\
	AI_SKILL_USE_DEF(pp_hp)(hp_rat),\
	AM_POTIONPITCHER, pp_nlv, pp_xlv, bmf, pf, wf, af, sp_rat\
}

// AIにおける○○の魂の使用手続きのマップ値を初期化する。
#define AI_SKILL_USE_PROC_SPIRIT(\
	spi_id,  /* ○○の魂のスキルID。 */\
	mid,     /* マップID。 */\
	spi_nlv, /* ○○の魂の最小スキルレベル。 */\
	spi_xlv, /* ○○の魂の最大スキルレベル。 */\
	bmf,     /* 戦闘モードのフラグ。 */\
	pf,      /* 一次バトラーのフラグ。 */\
	wf,      /* 歩行中のフラグ。 */\
	af,      /* 攻撃されているフラグ */\
	sp_rat   /* SPの四分率。 */\
) ai_t::skill_use_proc{\
	AI_SKILL_USE_DEF(spirit)(mid),\
	spi_id, spi_nlv, spi_xlv, bmf, pf, wf, af, sp_rat\
}

// AIにおけるスリムポーションピッチャーの使用手続きのマップ値を初期化する。
#define AI_SKILL_USE_PROC_SPP(\
	hp_rat,  /* HPの四分率。 */\
	spp_nlv, /* ポーションピッチャーの最小スキルレベル。 */\
	spp_xlv, /* ポーションピッチャーの最大スキルレベル。 */\
	bmf,     /* 戦闘モードのフラグ。 */\
	pf,      /* 一次バトラーのフラグ。 */\
	wf,      /* 歩行中のフラグ。 */\
	af,      /* 攻撃されているフラグ */\
	sp_rat   /* SPの四分率。 */\
) ai_t::skill_use_proc{\
	AI_SKILL_USE_DEF(spp)(hp_rat),\
	CR_SLIMPITCHER, spp_nlv, spp_xlv, bmf, pf, wf, af, sp_rat\
}

// AIにおけるスキル使用ハンドラの署名。
#define AI_SKILL_USE_FUNC(\
	kid_ /* スキルID。 */\
) void AI_SKILL_USE_DEF(kid_)(\
	e_skill kid, /* スキルID。 */\
	int klv      /* スキルレベル。 */\
)

// AIにおけるスキル使用ハンドラ(タイプ付き)の署名。
#define AI_SKILL_USE_FUNC_T(\
	kid_, /* スキルID。 */\
	typ   /* タイプ。 */\
) void AI_SKILL_USE_DEF_T(kid_, typ)(\
	e_skill kid, /* スキルID。 */\
	int klv      /* スキルレベル。 */\
)

// AIにおけるスキル使用ハンドラの関数名。
#define AI_SKILL_USE_DEF(\
	kid /* スキルID。 */\
) ai_t::skill_use_ ## kid

// AIにおけるスキル使用ハンドラ(タイプ付き)の関数名。
#define AI_SKILL_USE_DEF_T(\
	kid, /* スキルID。 */\
	typ  /* タイプ。 */\
) ai_t::skill_use_ ## kid ## _ ## typ

// AIにおけるアイテム使用手続きのマップ値を初期化する。
#define AI_ITEM_USE_PROC(\
	nam /* 名前。 */\
) {unbind(&AI_ITEM_USE_DEF(nam)), ITEMID_ ## nam}

// AIにおけるアイテム使用手続きのマップ値(他のハンドラに委任)を初期化する。
#define AI_ITEM_USE_PROC_D(\
	nam,    /* アイテム名。 */\
	inv_nam /* 呼び出すアイテム名。 */\
) {unbind(&AI_ITEM_USE_DEF(inv_nam)), ITEMID_ ## nam}

// AIにおける矢/弾コンテナのアイテム使用手続きのマップ値を初期化する。
#define AI_ITEM_USE_PROC_AMMO(\
	con_nam, /* コンテナ名。 */\
	amm_nam  /* 矢/弾名。 */\
) {AI_ITEM_USE_DEF(ammo_container)(ITEMID_ ## amm_nam), ITEMID_ ## con_nam}

// AIにおけるASPDポーションのアイテム使用手続きのマップ値を初期化する。
#define AI_ITEM_USE_PROC_ASPD(\
	nam /* アイテム名。 */\
) {AI_ITEM_USE_DEF(aspd_potion)(), ITEMID_ ## nam}

// AIにおけるアイテム使用ハンドラの署名。
#define AI_ITEM_USE_FUNC(\
	nam /* 名前 */\
) void AI_ITEM_USE_DEF(nam)(\
	int itm_ind /* アイテムのインデックス。 */\
)

// AIにおけるアイテム使用ハンドラの関数名。
#define AI_ITEM_USE_DEF(\
	nam /* 名前。 */\
) ai_t::item_use_ ## nam

// サブコマンドハンドラのマップ値。
#define SUBCMD_PROC(\
	com_nam,    /* コマンド名。 */\
	sc_ful_nam, /* サブコマンドの完全名。 */\
	sc_abr_nam  /* サブコマンドの略称。 */\
) initialize<subcommand_proc>(#com_nam, #sc_ful_nam, #sc_abr_nam, SUBCMD_DEF(com_nam, sc_ful_nam))

// サブコマンドハンドラの署名。
#define SUBCMD_FUNC(\
	com_nam,   /* コマンド名。 */\
	sc_ful_nam /* サブコマンドの完全名。 */\
) void SUBCMD_DEF(com_nam, sc_ful_nam)(\
	block_if* lea,              /* リーダー。 */\
	command_argument_list& args /* 引数のリスト。 */\
)

// サブコマンドハンドラの関数名。
#define SUBCMD_DEF(\
	com_nam,   /* コマンド名。 */\
	sc_ful_nam /* サブコマンドの完全名。 */\
) subcommand_ ## com_nam ## _ ## sc_ful_nam

// サブコマンドの説明。
#define SUBCMD_DESC(\
	com_nam,    /* コマンド名。 */\
	sc_ful_nam, /* サブコマンドの完全名。 */\
	sc_abr_nam, /* サブコマンドの略称。 */\
	sc_des      /* サブコマンドの説明。 */\
) initialize<subcommand_desc>(#com_nam, #sc_ful_nam, #sc_abr_nam, sc_des)

// スキルユニットキーのマップ値。
#define SKILL_UNIT_KEY(\
	kid, /* スキルID。 */\
	...  /* ソースのタイプ、最低スキルレベル。 */\
) {kid, {kid, __VA_ARGS__}}

// スキルの詠唱時間と遅延時間の合計。
#define SKILL_GET_CAST_DELAY(\
	kid, /* スキルID。 */\
	klv  /* レベル。 */\
) t_tick(skill_get_cast(kid, klv) + skill_get_delay(kid, klv))

// コンテナの全範囲のリスト。
#define ALL_RANGE(\
	con /* コンテナ。 */\
) (con).begin(), (con).end()

// コンテナの逆順の全範囲のリスト。
#define ALL_RRANGE(\
	con /* コンテナ。 */\
) (con).rbegin(), (con).rend()

// マップにキーが存在するかを判定する。
#define KEY_EXISTS(\
	map_, /* マップ。 */\
	key   /* キー。 */\
) ((map_).find(key) != (map_).end())

// コンテナに値が存在するかを判定する。
#define VALUE_EXISTS(\
	con, /* コンテナ。 */\
	val  /* 値。 */\
) (std::find(ALL_RANGE(con), val) != (con).end())

// 未実装エラーを投げる。
#define RAISE_NOT_IMPLEMENTED_ERROR\
	RAISE_RUNTIME_ERROR("Not implemented.")

// 実行時エラーを投げる。
#define RAISE_RUNTIME_ERROR(\
	mes /* メッセージ。 */\
) throw std::runtime_error(print(RUNTIME_ERROR_PREFIX, ": ", mes))

// 実行時エラー表示の接頭辞。
#define RUNTIME_ERROR_PREFIX print("Runtime(", __FUNCTION__, "@", __LINE__, ")")

// 変数をデバッグ表示する。
#define SHOW_DEBUG_VARIABLE(\
	var /* 変数。 */\
) SHOW_DEBUG_MESSAGE(print(#var, "='", var, "'"))

// メッセージをデバッグ表示する。
#define SHOW_DEBUG_MESSAGE(\
	mes /* メッセージ。 */\
) show_info(print(DEBUG_PREFIX, ": ", mes))

// 接頭辞のみをデバッグ表示する。
#define SHOW_DEBUG show_info(DEBUG_PREFIX)

// デバッグ表示の接頭辞。
#define DEBUG_PREFIX print("Debug(", __FUNCTION__, "@", __LINE__, ")")

// 予期せぬエラーのメッセージ
#define UNEXPECTED_ERROR "予期せぬエラーが発生しました。"

namespace pybot {

// -----------------------------------------------------------------------------
// 列挙の定義

// 攻撃されているフラグ。
enum attacked_flags {
	AF_TRUE  = 0x1,                // 真。
	AF_FALSE = 0x2,                // 偽。
	AF_ALL   = AF_TRUE | AF_FALSE, // すべて。
};

// 戦闘モードのフラグ。
enum battle_mode_flags {
	BMF_NONE   = 0x1,                    // なし。
	BMF_TAUNT  = 0x2,                    // 挑発。
	BMF_ASSIST = 0x4,                    // アシスト。
	BMF_COMBAT = BMF_TAUNT | BMF_ASSIST, // 戦闘中。
	BMF_ALL    = BMF_NONE | BMF_COMBAT,  // すべて。
};

// 戦闘モード。
enum battle_modes {
	BM_NONE,   // なし。
	BM_TAUNT,  // 挑発。
	BM_ASSIST, // アシスト。
	BM_MAX,
};

// コマンド要素のタイプ。
enum command_element_types {
    CET_LITERAL,   // リテラル。
    CET_SEPARATOR, // 区切る記号。
    CET_OPEN,      // 開く記号。
    CET_CLOSE,     // 閉じる記号。
    CET_MAX,
};

// 距離ポリシーの値。
enum distance_policy_values {
	DPV_PENDING, // 保留。
	DPV_CLOSE,   // 近接。
	DPV_AWAY,    // 遠隔。
	DPV_MAX
};

// 装備部位の順序。
enum equip_pos_orders {
	EPO_HEAD_TOP        , // 頭上。
	EPO_BODY            , // 体。
	EPO_HAND_L          , // 左手。
	EPO_HAND_R          , // 右手。
	EPO_SHOLDER         , // 肩。
	EPO_FOOT            , // 足。
	EPO_ACC_L           , // 左アクセサリ。
	EPO_ACC_R           , // 右アクセサリ。
	EPO_HEAD_MID        , // 頭中。
	EPO_HEAD_LOW        , // 頭下。
	EPO_COSTUME_HEAD_TOP, // 衣頭上。
	EPO_COSTUME_HEAD_MID, // 衣頭中。
	EPO_COSTUME_HEAD_LOW, // 衣頭下。
	EPO_COSTUME_GARMENT , // 衣肩。
	EPO_AMMO            , // 矢/弾。
	EPO_MAX             ,
};

// 追加のアイテムID。
enum item_ids {
	ITEMID_ORANGE_POTION           =   502, // 紅ポーション。
	ITEMID_GREEN_POTION            =   506, // 緑ポーション。
	ITEMID_GREEN_HERB              =   511, // 緑ハーブ。
	ITEMID_PANACEA                 =   525, // 万能薬。
	ITEMID_ROYAL_JELLY             =   526, // ローヤルゼリー。
	ITEMID_TOM_YUM_GOONG           =   566, // トムヤンクン。
	ITEMID_CHOCOLATE_DRINK         =   573, // チョコレートドリンク。
	ITEMID_CAVIAR_PANCAKE          =   591, // キャビアパンケーキ。
	ITEMID_JAM_PANCAKE             =   592, // ジャムパンケーキ。
	ITEMID_HONEY_PANCAKE           =   593, // ハニーパンケーキ。
	ITEMID_SOUR_CREAM_PANCAKE      =   594, // クリームパンケーキ。
	ITEMID_MUSHROOM_PANCAKE        =   595, // マッシュルームパンケーキ。
	ITEMID_LEAF_OF_YGGDRASIL       =   610, // イグドラシルの葉。
	ITEMID_CONCENTRATION_POTION    =   645, // スピードポーション。
	ITEMID_AWAKENING_POTION        =   656, // ハイスピードポーション。
	ITEMID_BERSERK_POTION          =   657, // バーサクポーション。
	ITEMID_POISON_BOTTLE           =   678, // 毒薬の瓶。
	ITEMID_ARROW                   =  1750, // 矢。
	ITEMID_SILVER_ARROW            =  1751, // 銀の矢。
	ITEMID_FIRE_ARROW              =  1752, // 炎の矢。
	ITEMID_STEEL_ARROW             =  1753, // 鋼鉄の矢。
	ITEMID_CRYSTAL_ARROW           =  1754, // 水晶の矢。
	ITEMID_ARROW_OF_WIND           =  1755, // 風の矢。
	ITEMID_STONE_ARROW             =  1756, // 岩石の矢。
	ITEMID_IMMATERIAL_ARROW        =  1757, // 無形の矢。
	ITEMID_RUSTY_ARROW             =  1762, // 錆びた矢。
	ITEMID_ORIDECON_ARROW          =  1765, // オリデオコンの矢。
	ITEMID_ARROW_OF_SHADOW         =  1767, // 影矢。
	ITEMID_IRON_ARROW              =  1770, // 鉄の矢。
	ITEMID_HOLY_ARROW              =  1772, // 聖なる矢。
	ITEMID_PORING_CARD             =  4001, // ポリンカード。
	ITEMID_QUIVER                  = 12004, // 矢筒。
	ITEMID_IRON_ARROW_QUIVER       = 12005, // 鉄の矢筒。
	ITEMID_STEEL_ARROW_QUIVER      = 12006, // 鋼鉄の矢筒。
	ITEMID_ORIDECON_ARROW_QUIVER   = 12007, // オリデオコンの矢筒。
	ITEMID_FIRE_ARROW_QUIVER       = 12008, // 炎の矢筒。
	ITEMID_SILVER_ARROW_QUIVER     = 12009, // 銀の矢筒。
	ITEMID_WIND_ARROW_QUIVER       = 12010, // 風の矢筒。
	ITEMID_STONE_ARROW_QUIVER      = 12011, // 岩石の矢筒。
	ITEMID_CRYSTAL_ARROW_QUIVER    = 12012, // 水晶の矢筒。
	ITEMID_SHADOW_ARROW_QUIVER     = 12013, // 影の矢筒。
	ITEMID_IMMATERIAL_ARROW_QUIVER = 12014, // 無形の矢筒。
	ITEMID_RUSTY_ARROW_QUIVER      = 12015, // 錆びた矢筒。
	ITEMID_LIGHTNING_SPHERE_PACK   = 12144, // ウィンドスフィアケース。
	ITEMID_BLIND_SPHERE_PACK       = 12145, // ダークスフィアケース。
	ITEMID_POISON_SPHERE_PACK      = 12146, // ポイズンスフィアケース。
	ITEMID_FREEZING_SPHERE_PACK    = 12147, // アイススフィアケース。
	ITEMID_FLARE_SPHERE_PACK       = 12148, // ファイアスフィアケース。
	ITEMID_CARTRIDGE               = 12149, // バレットケース。
	ITEMID_BLOOD_CARTRIDGE         = 12150, // ブラッドバレットケース。
	ITEMID_SILVER_CARTRIDGE        = 12151, // シルバーバレットケース。
	ITEMID_HOLY_ARROW_QUIVER       = 12183, // 聖なる矢筒。
	ITEMID_BULLET                  = 13200, // バレット。
	ITEMID_SILVER_BULLET           = 13201, // シルバーバレット。
	ITEMID_BLOODY_SHELL            = 13202, // ブラッドバレット。
	ITEMID_FIRE_SPHERE             = 13203, // ファイアスフィア。
	ITEMID_LIGHTNING_SPHERE        = 13204, // ウィンドスフィア。
	ITEMID_POISON_SPHERE           = 13205, // ポイズンスフィア。
	ITEMID_BLIND_SPHERE            = 13206, // ダークスフィア。
	ITEMID_FREEZING_SPHERE         = 13207, // アイススフィア。
};

// マップの種類。
enum map_types {
	MT_UNKNOWN, // 不明。
	MT_CITY   , // 街。
	MT_FIELD  , // フィールド。
	MT_DUNGEON, // ダンジョン。
};

// メタモンスター。
enum meta_mobs {
	MM_REST        =   100, // 休息。
	MM_BACKUP      =   101, // 予備。
	MM_BASE        =   102, // 基本。
	MM_SIZE        =   120, // サイズ。
	MM_ELEMENT     =   140, // 属性。
	MM_RACE        =   160, // 種族。
	MM_BOSS        =   180, // ボス。
	MM_GREAT       =   181, // グレート。
	MM_FLORA       =   182, // フローラ型。
	MM_SP_DECLINE4 =   190, // SP低下4。
	MM_SP_DECLINE3 =   191, // SP低下3。
	MM_SP_DECLINE2 =   192, // SP低下2。
	MM_SP_DECLINE1 =   193, // SP低下1。
	MM_HP_DECLINE4 =   200, // HP低下4。
	MM_HP_DECLINE3 =   201, // HP低下3。
	MM_HP_DECLINE2 =   202, // HP低下2。
	MM_HP_DECLINE1 =   203, // HP低下1。
	MM_INDIVIDUAL  =   500, // 個別。
	MM_CAUTION     = 10000, // 警戒。
};

// 国の種類。
enum nation_types {
	NT_UNKNOWN    , // 不明。
	NT_MIDGARD    , // ルーンミッドガッツ王国。
	NT_SCHWARZWALD, // シュバルツバルド共和国。
	NT_ARUNAFELTZ , // アルナベルツ教国。
	NT_OTHER      , // その他の国々。
};

// 通常攻撃ポリシーの値。
enum normal_attack_policy_values {
	NAPV_PENDING,    // 保留。
	NAPV_CONTINUOUS, // 連続。
	NAPV_SINGLE,     // 単発。
	NAPV_MAX
};

// 一次バトラーのフラグ。
enum primary_flags {
	PF_TRUE  = 0x1,                // 真。
	PF_FALSE = 0x2,                // 偽。
	PF_ALL   = PF_TRUE | PF_FALSE, // すべて。
};

// レジストリの変更状態。
enum registry_dirties {
	RD_CLEAN,  // なし。
	RD_INSERT, // 挿入。
	RD_UPDATE, // 更新。
	RD_DELETE, // 削除。
	RD_MAX,
};

// ステータスのタイプ。
enum status_types {
	ST_STR, // STR。
	ST_AGI, // AGI。
	ST_VIT, // VIT。
	ST_INT, // INT。
	ST_DEX, // DEX。
	ST_LUK, // LUK。
	ST_MAX
};

// 歩行中のフラグ。
enum walking_flags {
	WF_TRUE  = 0x1,               // 真。
	WF_FALSE = 0x2,               // 偽。
	WF_ALL  = WF_TRUE | WF_FALSE, // すべて。
};

// -----------------------------------------------------------------------------
// 型の宣言

struct ai_t;

struct battler_if;
struct block_if;
struct bot_if;
struct enemy_if;
struct general_if;
struct homun_if;
struct item_user_if;
struct leader_if;
struct member_if;
struct mob_if;
struct pet_if;
struct skill_target_if;
struct skill_user_if;
struct slave_if;

struct battler_impl;
struct bot_impl;
struct client_impl;
struct enemy_impl;
struct general_impl;
struct homn_impl;
struct item_user_impl;
struct leader_impl;
struct member_impl;
struct mob_impl;
struct pet_impl;
struct server_impl;
struct skill_target_impl;
struct skill_user_impl;

struct bot_t;
struct enemy_t;
struct homun_t;
struct leader_t;
struct member_t;
struct mob_t;
struct pet_t;

template <class K, class T = void> struct registry_t;
template <class T = int> struct regnum_t;

template <class C> struct back_insert_iterator;
struct card_exchanger;
struct cart_context;
struct command_element;
struct command_error;
struct equipset_t;
struct equipset_item;
struct fever_size;
struct guild_storage_context;
template <class C> struct insert_iterator;
struct inventory_context;
struct item_key;
struct item_used_exception;
struct play_skill;
template <class V> struct policy_t;
struct pos_t;
struct private_storage_context;
struct pybot_map;
struct skill_mobs;
struct skill_unit_key;
struct sql_binder;
struct sql_column;
struct sql_context;
struct sql_param;
struct sql_session;
struct storage_context;
struct subcommand_desc;
struct subcommand_proc;
struct team_member;
struct team_t;
struct turn_end_exception;
using distance_policy = policy_t<distance_policy_values>;
using normal_attack_policy = policy_t<normal_attack_policy_values>;

// ブロックの述語。
using block_pred = std::function<
	bool( // 結果。
		block_if* // ブロック。
	)
>;

// コマンド引数のリスト。
using command_argument_list = std::list<std::string>;

// モンスタースキル述語。
using mob_skill_pred = std::function<
	bool( // 結果。
		e_skill kid, // スキルID。
		int klv      // スキルレベル。
	)
>;

// オブジェクトのポインタ。
template <class T> using ptr = std::shared_ptr<T>;

// 状態変化タイプのセット。
using sc_type_set = std::unordered_set<sc_type>;

// スキルIDのセット。
using skill_id_set = std::unordered_set<e_skill>;

// スキルユニットキーのセット。
using skill_unit_key_map = std::unordered_map<e_skill,skill_unit_key>;

// サブコマンドハンドラ。
using subcommand_func = std::function<void(
	block_if*,             // リーダー。
	command_argument_list& // コマンド引数のリスト。
)>;

// ブロックリスト獲得ハンドラ。
using yield_bl_func = std::function<
	int( // 獲得したブロック数。
		block_list* // ブロックリスト。
	)
>;

// スキルユニット獲得ハンドラ。
using yield_skill_unit_func = std::function<
	int( // 獲得したスキルユニット数。
		skill_unit*, // スキルユニット。
		block_list*  // ソースのブロックリスト。
	)
>;

// 座標獲得ハンドラ。
using yield_xy_func = std::function<
	bool( // 処理続行か。
		int, // X座標。
		int  // Y座標。
	)
>;

// スキル獲得ハンドラ。
using yield_skill_func = std::function<
	bool( // 処理続行か。
		s_skill* // スキル。
	)
>;

// -----------------------------------------------------------------------------
// AI型の定義

// AI。
struct ai_t {
	// 行動終了ハンドラ。
	using done_func = std::function<void(
		ai_t*, // AI。
		void*  // 行動終了ハンドラ。
	)>;

	// アイテム使用ハンドラ。
	using item_use_func = std::function<void(
		ai_t*, // AI。
		int    // アイテムのインデックス。
	)>;

	// アイテム使用手続き。
	struct item_use_proc {
		item_use_func func; // アイテム使用ハンドラ。
		int nameid;         // アイテムID。
	};

	// スキル使用ハンドラ。
	using skill_use_func = std::function<void(
		ai_t*,   // AI。
		e_skill, // スキルID。
		int      // スキルレベル。
	)>;
	
	// スキル使用手続き。
	struct skill_use_proc {
		skill_use_func func;                // スキル使用ハンドラ。
		e_skill skill_id;                   // スキルID。
		int min_skill_lv;                   // 最小スキルレベル。
		int max_skill_lv;                   // 最大スキルレベル。0なら使用可能な最大レベル。
		battle_mode_flags battle_mode_flag; // 戦闘モードのフラグ。
		primary_flags primary_flag;         // 一次バトラーのフラグ。
		walking_flags walking_flag;         // 歩行中のフラグ。
		attacked_flags attacked_flag;       // 攻撃されているフラグ。
		int sp_rat;                         // SPの四分率。5なら敵モンスター数に連動する。
	};

	// スキル使用手続きのベクタ。
	using skill_use_proc_vector = std::vector<
		skill_use_proc // スキル使用手続き。
	>;

	std::vector<block_if*> ally_mobs;        // 味方モンスターのベクタ。
	block_if* battler;                       // バトラー。
	std::vector<block_if*> battlers;         // バトラーのベクタ。
	std::unordered_map<				             
		int,      // ブロックID。	             
		block_if* // ブロック。		             
	> blocks;                                // ブロックのマップ。
	block_if* bot;                           // Bot。
	std::vector<block_if*> enemies;          // 敵モンスターのベクタ。
	std::vector<flooritem_data*> flooritems; // ドロップアイテムのベクタ。
	block_if* homun;                         // ホムンクルス。
	std::vector<block_if*> homuns;           // ホムンクルスのベクタ。
	block_if* leader;                        // リーダー。
	std::vector<block_if*> members;          // メンバーのベクタ。
	block_if* pet;                           // ペット。
	std::vector<block_if*> pets;             // ペットのベクタ。
	std::vector<npc_data*> warp_portals;     // ワープポータルのベクタ。

	static TIMER_FUNC(timer_func);

	void leader_main(block_if* lea);
	void leader_organize();
	void leader_collect();
	void leader_target();
	void leader_battler();
	void leader_pet();

	void bot_main(block_if* bot_);
	void bot_dialog();
	void bot_dead();
	void bot_lost();
	void bot_emotion();
	void bot_stand();
	void bot_cast_cancel();
	void bot_walk_end();
	void bot_cast_end();
	void bot_cart_auto_get();
	void bot_reload_equipset();
	void bot_use_item();
	void bot_pickup_flooritem();
	void bot_positioning();
	void bot_follow();
	void bot_attack();
	void bot_play_skill();
	void bot_use_skill();
	void bot_rest();

	void homun_main(block_if* hom);
	void homun_lost();
	void homun_feed();
	void homun_positioning();
	void homun_follow();
	void homun_attack();
	void homun_use_skill();

	void pet_main(block_if* pet_);
	void pet_feed();
	void pet_perform();

	void battler_positioning();
	void battler_attack();
	void battler_use_skill();

	bool away_enemies(int x, int y);
	bool away_other_battlers(int x, int y);
	bool away_warp_portals(int x, int y);
	bool check_line_other_battlers(int x, int y);
	bool check_stuck(int x, int y);
	yield_xy_func find_away_pos_pred(pos_t& pos);
	pos_t find_best_assist_pos();
	pos_t find_best_away_pos();
	pos_t find_best_tanut_pos();
	template <class T> block_if* find_block(int id);
	yield_xy_func find_close_pos_pred(pos_t& pos);
	yield_xy_func find_wall_side_pos_pred(pos_t& pos);
	int sp_ratio_by_enemies();

	AI_ITEM_USE_FUNC(CAVIAR_PANCAKE);
	AI_ITEM_USE_FUNC(GREEN_HERB);
	AI_ITEM_USE_FUNC(GREEN_POTION);
	AI_ITEM_USE_FUNC(HOLY_WATER);
	AI_ITEM_USE_FUNC(LEAF_OF_YGGDRASIL);
	AI_ITEM_USE_FUNC(PANACEA);
	AI_ITEM_USE_FUNC(POISON_BOTTLE);

	static ai_t::item_use_func AI_ITEM_USE_DEF(ammo_container)(int amm_id);
	static ai_t::item_use_func AI_ITEM_USE_DEF(aspd_potion)();

	AI_SKILL_USE_FUNC(AC_CHARGEARROW);
	AI_SKILL_USE_FUNC(AC_CONCENTRATION);
	AI_SKILL_USE_FUNC(AC_DOUBLE);
	AI_SKILL_USE_FUNC(AC_SHOWER);
	AI_SKILL_USE_FUNC(AL_ANGELUS);
	AI_SKILL_USE_FUNC(AL_BLESSING);
	AI_SKILL_USE_FUNC_T(AL_BLESSING, cure);
	AI_SKILL_USE_FUNC_T(AL_BLESSING, curse);
	AI_SKILL_USE_FUNC(AL_CRUCIS);
	AI_SKILL_USE_FUNC(AL_CURE);
	AI_SKILL_USE_FUNC(AL_DECAGI);
	AI_SKILL_USE_FUNC_T(AL_HEAL, attack);
	AI_SKILL_USE_FUNC(AL_HOLYWATER);
	AI_SKILL_USE_FUNC(AL_INCAGI);
	AI_SKILL_USE_FUNC(AL_PNEUMA);
	AI_SKILL_USE_FUNC(AM_ACIDTERROR);
	AI_SKILL_USE_FUNC(AM_BERSERKPITCHER);
	AI_SKILL_USE_FUNC(AM_CALLHOMUN);
	AI_SKILL_USE_FUNC(AM_CANNIBALIZE);
	AI_SKILL_USE_FUNC_T(AM_POTIONPITCHER, sp);
	AI_SKILL_USE_FUNC(AM_REST);
	AI_SKILL_USE_FUNC(AM_RESURRECTHOMUN);
	AI_SKILL_USE_FUNC(ALL_RESURRECTION);
	AI_SKILL_USE_FUNC(AS_ENCHANTPOISON);
	AI_SKILL_USE_FUNC(AS_POISONREACT);
	AI_SKILL_USE_FUNC(ASC_BREAKER);
	AI_SKILL_USE_FUNC(ASC_EDP);
	AI_SKILL_USE_FUNC(BA_FROSTJOKER);
	AI_SKILL_USE_FUNC(BD_ADAPTATION);
	AI_SKILL_USE_FUNC(BS_ADRENALINE);
	AI_SKILL_USE_FUNC(BS_ADRENALINE2);
	AI_SKILL_USE_FUNC(BS_HAMMERFALL);
	AI_SKILL_USE_FUNC_T(BS_MAXIMIZE, activate);
	AI_SKILL_USE_FUNC_T(BS_MAXIMIZE, deactivate);
	AI_SKILL_USE_FUNC(BS_OVERTHRUST);
	AI_SKILL_USE_FUNC(BS_REPAIRWEAPON);
	AI_SKILL_USE_FUNC(BS_WEAPONPERFECT);
	AI_SKILL_USE_FUNC(CG_LONGINGFREEDOM);
	AI_SKILL_USE_FUNC(CH_CHAINCRUSH);
	AI_SKILL_USE_FUNC(CH_PALMSTRIKE);
	AI_SKILL_USE_FUNC(CH_SOULCOLLECT);
	AI_SKILL_USE_FUNC(CH_TIGERFIST);
	AI_SKILL_USE_FUNC(CR_AUTOGUARD);
	AI_SKILL_USE_FUNC_T(CR_DEFENDER, activate);
	AI_SKILL_USE_FUNC_T(CR_DEFENDER, deactivate);
	AI_SKILL_USE_FUNC(CR_DEVOTION);
	AI_SKILL_USE_FUNC(CR_FULLPROTECTION);
	AI_SKILL_USE_FUNC(CR_GRANDCROSS);
	AI_SKILL_USE_FUNC_T(CR_GRANDCROSS, effective);
	AI_SKILL_USE_FUNC(CR_PROVIDENCE);
	AI_SKILL_USE_FUNC(CR_REFLECTSHIELD);
	AI_SKILL_USE_FUNC_T(CR_SHIELDBOOMERANG, spirit);
	AI_SKILL_USE_FUNC(CR_SHRINK);
	AI_SKILL_USE_FUNC(CR_SPEARQUICKEN);
	AI_SKILL_USE_FUNC(DC_SCREAM);
	AI_SKILL_USE_FUNC(DC_WINKCHARM);
	AI_SKILL_USE_FUNC(GS_ADJUSTMENT);
	AI_SKILL_USE_FUNC(GS_BULLSEYE);
	AI_SKILL_USE_FUNC(GS_CRACKER);
	AI_SKILL_USE_FUNC(GS_DESPERADO);
	AI_SKILL_USE_FUNC(GS_DISARM);
	AI_SKILL_USE_FUNC(GS_DUST);
	AI_SKILL_USE_FUNC(GS_FLING);
	AI_SKILL_USE_FUNC_T(GS_GATLINGFEVER, activate);
	AI_SKILL_USE_FUNC_T(GS_GATLINGFEVER, deactivate);
	AI_SKILL_USE_FUNC(GS_GLITTERING);
	AI_SKILL_USE_FUNC(GS_GROUNDDRIFT);
	AI_SKILL_USE_FUNC(GS_INCREASING);
	AI_SKILL_USE_FUNC_T(GS_MADNESSCANCEL, activate);
	AI_SKILL_USE_FUNC_T(GS_MADNESSCANCEL, deactivate);
	AI_SKILL_USE_FUNC(GS_MAGICALBULLET);
	AI_SKILL_USE_FUNC(GS_PIERCINGSHOT);
	AI_SKILL_USE_FUNC(GS_TRACKING);
	AI_SKILL_USE_FUNC(GS_TRIPLEACTION);
	AI_SKILL_USE_FUNC_T(HP_ASSUMPTIO, primary);
	AI_SKILL_USE_FUNC_T(HP_ASSUMPTIO, not_primary);
	AI_SKILL_USE_FUNC(HT_ANKLESNARE);
	AI_SKILL_USE_FUNC(HT_DETECTING);
	AI_SKILL_USE_FUNC(HT_FREEZINGTRAP);
	AI_SKILL_USE_FUNC(HT_LANDMINE);
	AI_SKILL_USE_FUNC(HT_POWER);
	AI_SKILL_USE_FUNC(HT_REMOVETRAP);
	AI_SKILL_USE_FUNC(HT_SANDMAN);
	AI_SKILL_USE_FUNC(HW_GANBANTEIN);
	AI_SKILL_USE_FUNC(HW_GRAVITATION);
	AI_SKILL_USE_FUNC(KN_AUTOCOUNTER);
	AI_SKILL_USE_FUNC(KN_CHARGEATK);
	AI_SKILL_USE_FUNC(KN_ONEHAND);
	AI_SKILL_USE_FUNC(KN_PIERCE);
	AI_SKILL_USE_FUNC(KN_TWOHANDQUICKEN);
	AI_SKILL_USE_FUNC(LK_AURABLADE);
	AI_SKILL_USE_FUNC(LK_BERSERK);
	AI_SKILL_USE_FUNC(LK_CONCENTRATION);
	AI_SKILL_USE_FUNC(LK_HEADCRUSH);
	AI_SKILL_USE_FUNC(LK_JOINTBEAT);
	AI_SKILL_USE_FUNC(LK_PARRYING);
	AI_SKILL_USE_FUNC(LK_SPIRALPIERCE);
	AI_SKILL_USE_FUNC(MC_CARTREVOLUTION);
	AI_SKILL_USE_FUNC_T(MC_CARTREVOLUTION, effective);
	AI_SKILL_USE_FUNC(MC_LOUD);
	AI_SKILL_USE_FUNC(MC_MAMMONITE);
	AI_SKILL_USE_FUNC(MG_ENERGYCOAT);
	AI_SKILL_USE_FUNC(MG_FIREBALL);
	AI_SKILL_USE_FUNC(MG_FIREBOLT);
	AI_SKILL_USE_FUNC_T(MG_FIREBOLT, compromise);
	AI_SKILL_USE_FUNC(MG_FIREWALL);
	AI_SKILL_USE_FUNC(MG_FROSTDIVER);
	AI_SKILL_USE_FUNC(MG_NAPALMBEAT);
	AI_SKILL_USE_FUNC(MG_SAFETYWALL);
	AI_SKILL_USE_FUNC(MG_SIGHT);
	AI_SKILL_USE_FUNC(MG_STONECURSE);
	AI_SKILL_USE_FUNC(MG_THUNDERSTORM);
	AI_SKILL_USE_FUNC(MO_ABSORBSPIRITS);
	AI_SKILL_USE_FUNC(MO_BALKYOUNG);
	AI_SKILL_USE_FUNC(MO_BLADESTOP);
	AI_SKILL_USE_FUNC(MO_BODYRELOCATION);
	AI_SKILL_USE_FUNC(MO_CALLSPIRITS);
	AI_SKILL_USE_FUNC_T(MO_CALLSPIRITS, ready);
	AI_SKILL_USE_FUNC(MO_CHAINCOMBO);
	AI_SKILL_USE_FUNC(MO_COMBOFINISH);
	AI_SKILL_USE_FUNC(MO_EXPLOSIONSPIRITS);
	AI_SKILL_USE_FUNC(MO_EXTREMITYFIST);
	AI_SKILL_USE_FUNC_T(MO_EXTREMITYFIST, combo);
	AI_SKILL_USE_FUNC(MO_FINGEROFFENSIVE);
	AI_SKILL_USE_FUNC_T(MO_FINGEROFFENSIVE, crush);
	AI_SKILL_USE_FUNC_T(MO_FINGEROFFENSIVE, first_attack);
	AI_SKILL_USE_FUNC(MO_INVESTIGATE);
	AI_SKILL_USE_FUNC(MO_STEELBODY);
	AI_SKILL_USE_FUNC(NJ_BAKUENRYU);
	AI_SKILL_USE_FUNC(NJ_BUNSINJYUTSU);
	AI_SKILL_USE_FUNC(NJ_HYOUSYOURAKU);
	AI_SKILL_USE_FUNC(NJ_ISSEN);
	AI_SKILL_USE_FUNC(NJ_KAENSIN);
	AI_SKILL_USE_FUNC(NJ_KAMAITACHI);
	AI_SKILL_USE_FUNC(NJ_KASUMIKIRI);
	AI_SKILL_USE_FUNC(NJ_KIRIKAGE);
	AI_SKILL_USE_FUNC_T(NJ_KOUENKA, compromise);
	AI_SKILL_USE_FUNC(NJ_NEN);
	AI_SKILL_USE_FUNC(NJ_RAIGEKISAI);
	AI_SKILL_USE_FUNC(NJ_SHADOWJUMP);
	AI_SKILL_USE_FUNC(NJ_SUITON);
	AI_SKILL_USE_FUNC(NJ_TATAMIGAESHI);
	AI_SKILL_USE_FUNC(NJ_UTSUSEMI);
	AI_SKILL_USE_FUNC(NV_FIRSTAID);
	AI_SKILL_USE_FUNC_T(NV_TRICKDEAD, activate);
	AI_SKILL_USE_FUNC_T(NV_TRICKDEAD, deactivate);
	AI_SKILL_USE_FUNC_T(PA_GOSPEL, activate);
	AI_SKILL_USE_FUNC_T(PA_GOSPEL, deactivate);
	AI_SKILL_USE_FUNC(PA_SACRIFICE);
	AI_SKILL_USE_FUNC(PF_DOUBLECASTING);
	AI_SKILL_USE_FUNC(PF_FOGWALL);
	AI_SKILL_USE_FUNC(PF_HPCONVERSION);
	AI_SKILL_USE_FUNC(PF_MEMORIZE);
	AI_SKILL_USE_FUNC(PF_SOULCHANGE);
	AI_SKILL_USE_FUNC(PF_SPIDERWEB);
	AI_SKILL_USE_FUNC(PR_ASPERSIO);
	AI_SKILL_USE_FUNC(PR_BENEDICTIO);
	AI_SKILL_USE_FUNC(PR_GLORIA);
	AI_SKILL_USE_FUNC(PR_IMPOSITIO);
	AI_SKILL_USE_FUNC(PR_KYRIE);
	AI_SKILL_USE_FUNC(PR_LEXAETERNA);
	AI_SKILL_USE_FUNC(PR_LEXDIVINA);
	AI_SKILL_USE_FUNC(PR_MAGNIFICAT);
	AI_SKILL_USE_FUNC(PR_MAGNUS);
	AI_SKILL_USE_FUNC(PR_REDEMPTIO);
	AI_SKILL_USE_FUNC(PR_SANCTUARY);
	AI_SKILL_USE_FUNC(PR_SLOWPOISON);
	AI_SKILL_USE_FUNC(PR_STRECOVERY);
	AI_SKILL_USE_FUNC_T(PR_STRECOVERY, blind);
	AI_SKILL_USE_FUNC(PR_SUFFRAGIUM);
	AI_SKILL_USE_FUNC(PR_TURNUNDEAD);
	AI_SKILL_USE_FUNC(RG_BACKSTAP);
	AI_SKILL_USE_FUNC(RG_STEALCOIN);
	AI_SKILL_USE_FUNC(RG_STRIPSHIELD);
	AI_SKILL_USE_FUNC(RG_STRIPWEAPON);
	AI_SKILL_USE_FUNC(SA_AUTOSPELL);
	AI_SKILL_USE_FUNC(SA_DELUGE);
	AI_SKILL_USE_FUNC(SA_DISPELL);
	AI_SKILL_USE_FUNC_T(SA_DISPELL, cure);
	AI_SKILL_USE_FUNC(SA_FROSTWEAPON);
	AI_SKILL_USE_FUNC(SA_FLAMELAUNCHER);
	AI_SKILL_USE_FUNC(SA_LANDPROTECTOR);
	AI_SKILL_USE_FUNC(SA_LIGHTNINGLOADER);
	AI_SKILL_USE_FUNC(SA_MAGICROD);
	AI_SKILL_USE_FUNC(SA_SEISMICWEAPON);
	AI_SKILL_USE_FUNC(SA_SPELLBREAKER);
	AI_SKILL_USE_FUNC(SA_VIOLENTGALE);
	AI_SKILL_USE_FUNC(SA_VOLCANO);
	AI_SKILL_USE_FUNC(SG_FUSION);
	AI_SKILL_USE_FUNC(SG_MOON_COMFORT);
	AI_SKILL_USE_FUNC(SG_STAR_COMFORT);
	AI_SKILL_USE_FUNC(SG_SUN_COMFORT);
	AI_SKILL_USE_FUNC(SG_SUN_WARM);
	AI_SKILL_USE_FUNC(SL_KAAHI);
	AI_SKILL_USE_FUNC(SL_KAITE);
	AI_SKILL_USE_FUNC(SL_KAIZEL);
	AI_SKILL_USE_FUNC(SL_KAUPE);
	AI_SKILL_USE_FUNC(SL_SKA);
	AI_SKILL_USE_FUNC(SL_SKE);
	AI_SKILL_USE_FUNC(SL_SMA);
	AI_SKILL_USE_FUNC(SL_STIN);
	AI_SKILL_USE_FUNC(SL_STUN);
	AI_SKILL_USE_FUNC(SL_SWOO);
	AI_SKILL_USE_FUNC(SM_AUTOBERSERK);
	AI_SKILL_USE_FUNC(SM_BASH);
	AI_SKILL_USE_FUNC_T(SM_BASH, disturb);
	AI_SKILL_USE_FUNC_T(SM_BASH, effective);
	AI_SKILL_USE_FUNC(SM_ENDURE);
	AI_SKILL_USE_FUNC(SM_MAGNUM);
	AI_SKILL_USE_FUNC_T(SM_MAGNUM, effective);
	AI_SKILL_USE_FUNC_T(SM_MAGNUM, enchant);
	AI_SKILL_USE_FUNC(SM_PROVOKE);
	AI_SKILL_USE_FUNC_T(SM_PROVOKE, first_attack);
	AI_SKILL_USE_FUNC(SN_SIGHT);
	AI_SKILL_USE_FUNC(SN_SHARPSHOOTING);
	AI_SKILL_USE_FUNC(SN_WINDWALK);
	AI_SKILL_USE_FUNC(ST_FULLSTRIP);
	AI_SKILL_USE_FUNC(ST_PRESERVE);
	AI_SKILL_USE_FUNC(ST_REJECTSWORD);
	AI_SKILL_USE_FUNC(TF_DETOXIFY);
	AI_SKILL_USE_FUNC_T(TF_HIDING, activate);
	AI_SKILL_USE_FUNC_T(TF_HIDING, deactivate);
	AI_SKILL_USE_FUNC(TF_PICKSTONE);
	AI_SKILL_USE_FUNC(TF_POISON);
	AI_SKILL_USE_FUNC(TF_SPRINKLESAND);
	AI_SKILL_USE_FUNC(TF_STEAL);
	AI_SKILL_USE_FUNC_T(TF_THROWSTONE, crush);
	AI_SKILL_USE_FUNC_T(TF_THROWSTONE, first_attack);
	AI_SKILL_USE_FUNC(TK_COUNTER);
	AI_SKILL_USE_FUNC(TK_DODGE);
	AI_SKILL_USE_FUNC(TK_JUMPKICK);
	AI_SKILL_USE_FUNC(TK_READYCOUNTER);
	AI_SKILL_USE_FUNC(TK_RUN);
	AI_SKILL_USE_FUNC(TK_SEVENWIND);
	AI_SKILL_USE_FUNC(WS_CARTBOOST);
	AI_SKILL_USE_FUNC(WS_MELTDOWN);
	AI_SKILL_USE_FUNC(WS_OVERTHRUSTMAX);
	AI_SKILL_USE_FUNC(WZ_ICEWALL);
	AI_SKILL_USE_FUNC(WZ_FIREPILLAR);
	AI_SKILL_USE_FUNC(WZ_FROSTNOVA);
	AI_SKILL_USE_FUNC(WZ_JUPITEL);
	AI_SKILL_USE_FUNC(WZ_METEOR);
	AI_SKILL_USE_FUNC(WZ_QUAGMIRE);
	AI_SKILL_USE_FUNC(WZ_STORMGUST);
	AI_SKILL_USE_FUNC_T(WZ_STORMGUST, freeze);

	AI_SKILL_USE_FUNC(HAMI_BLOODLUST);
	AI_SKILL_USE_FUNC(HAMI_CASTLE);
	AI_SKILL_USE_FUNC(HAMI_DEFENCE);
	AI_SKILL_USE_FUNC(HFLI_FLEET);
	AI_SKILL_USE_FUNC(HFLI_MOON);
	AI_SKILL_USE_FUNC(HFLI_SPEED);
	AI_SKILL_USE_FUNC(HLIF_AVOID);
	AI_SKILL_USE_FUNC(HLIF_CHANGE);
	AI_SKILL_USE_FUNC(HLIF_HEAL);
	AI_SKILL_USE_FUNC(HVAN_CAPRICE);
	AI_SKILL_USE_FUNC_T(HVAN_CHAOTIC, master);
	AI_SKILL_USE_FUNC_T(HVAN_CHAOTIC, self);

	static ai_t::skill_use_func AI_SKILL_USE_DEF(cp)(equip_pos equ, sc_type sc_typ, bool&(enemy_if::*has_sk)());
	static ai_t::skill_use_func AI_SKILL_USE_DEF(heal)(int hp_rat);
	static ai_t::skill_use_func AI_SKILL_USE_DEF(pp_hp)(int hp_rat);
	static ai_t::skill_use_func AI_SKILL_USE_DEF(spirit)(e_mapid mid);
	static ai_t::skill_use_func AI_SKILL_USE_DEF(spp)(int hp_rat);
};

// -----------------------------------------------------------------------------
// ブロック型の定義

// バトラーのインターフェイス。
struct battler_if {
	virtual bool& around_wall_exists();
	virtual void attack(block_if* blo, bool con = true);
	virtual bool& attacked_by_blower();
	virtual bool& attacked_by_detector();
	virtual std::vector<block_if*>& attacked_enemies();
	virtual block_if*& attacked_long_range_attacker();
	virtual block_if*& attacked_short_range_attacker();
	virtual int& attacked_short_range_attackers();
	virtual int& battle_index();
	virtual battle_modes& battle_mode();
	virtual bool check_attack(block_if* ene);
	virtual bool check_hp(int rat);
	virtual bool check_normal_attack(block_if* ene);
	virtual bool check_sp(int rat);
	virtual bool check_use_skill(e_skill kid, int klv, block_if* ene);
	virtual bool check_use_taunt_skill(block_if* ene);
	virtual distance_policy_values default_distance_policy_value();
	virtual normal_attack_policy_values default_normal_attack_policy_value();
	virtual distance_policy_values& distance_policy_value();
	virtual int get_hold_monsters();
	virtual int guild_id();
	virtual bool& is_best_pos();
	virtual bool is_dead();
	virtual bool is_invincible();
	virtual bool is_no_castcancel();
	virtual bool is_no_gemstone();
	virtual bool is_primary();
	virtual bool is_wall_side();
	virtual block_if*& leader();
	virtual void load_policy(int mid, distance_policy_values* dis_pol_val, normal_attack_policy_values* nor_att_pol_val);
	virtual int& member_index();
	virtual normal_attack_policy_values& normal_attack_policy_value();
	virtual int party_id();
	virtual ptr<registry_t<int>>& reject_skills();
	virtual int skill_ratio(e_skill kid, int klv, block_if* ene);
	virtual void stop_attacking();
	virtual void stop_walking(int typ = USW_FIXPOS);
	virtual block_if*& target_enemy();
	virtual bool teleport(block_list* bl_);
	virtual bool walk_bl(block_list* tbl, int ran = 0);
	virtual ai_t::done_func& walk_end_func();
	virtual bool walk_xy(int x, int y, int ran = 0);
	virtual e_element weapon_attack_element();
	virtual int weapon_attack_element_ratio(block_if* ene);
};

// Botのインターフェイス。
struct bot_if {
	virtual int& bot_index();
	virtual bool is_sit();
	virtual t_tick& last_emotion_tick();
	virtual t_tick& last_reloaded_equipset_tick();
	virtual std::unordered_set<int>& request_items();
	virtual void respawn();
};

// 敵モンスターのインターフェイス。
struct enemy_if {
	virtual std::vector<block_if*>& attacked_battlers();
	virtual int away_distance(block_if* lea);
	virtual std::vector<block_if*>& close_battlers();
	virtual bool& has_knockback_skill();
	virtual bool& has_layout_skill();
	virtual bool& has_long_skill();
	virtual bool& has_long_weapon_skill();
	virtual bool& has_summon_skill();
	virtual bool& has_unequip_armor_skill();
	virtual bool& has_unequip_helm_skill();
	virtual bool& has_unequip_shield_skill();
	virtual bool& has_unequip_weapon_skill();
	virtual bool& has_usefull_skill();
	virtual block_if*& skill_target_battler();
	virtual block_if*& target_battler();
	virtual pos_t waiting_position();
	virtual block_if*& walk_target_battler();
};

// 汎用のインターフェイス。
struct general_if {
	virtual void act_end();
	virtual int attack_element_ratio(block_if* src, e_element ele);
	virtual int attack_range();
	virtual block_list* bl();
	virtual bool can_act();
	virtual bool can_move();
	virtual bool can_reach_bl(block_list* bl_, bool eas = true);
	virtual bool can_reach_block(block_if* blo, bool eas = true);
	virtual bool can_reach_xy(int x, int y, bool eas = true);
	virtual bool check_attack_range(block_if* blo);
	virtual bool check_line_bl(block_list* bl_);
	virtual bool check_line_block(block_if* blo);
	virtual bool check_line_xy(int x, int y);
	virtual bool check_range_bl(block_list* bl0, block_list* bl1, int dis);
	virtual bool check_range_blxy(block_list* bl_, int x, int y, int dis);
	virtual bool check_range_xy(int x0, int y0, int x1, int y1, int dis);
	virtual bool check_sc_types(const sc_type_set& sc_typs);
	virtual bool check_skill_range_block(e_skill kid, int klv, block_if* blo);
	virtual bool check_skill_range_xy(e_skill kid, int klv, int x, int y);
	virtual defType def();
	virtual int def2();
	virtual e_element element();
	virtual int flee();
	virtual int hit();
	virtual int hp();
	virtual int hp_ratio();
	virtual bool is_attacking();
	virtual bool is_casting();
	virtual bool is_ensemble();
	virtual bool is_hiding();
	virtual bool is_long_range_attacker();
	virtual bool is_long_weapon_immune();
	virtual bool is_magic_immune();
	virtual bool is_paralysis();
	virtual bool is_short_range_attacker();
	virtual bool is_solo();
	virtual bool is_walking();
	virtual int max_hp();
	virtual int max_sp();
	virtual std::string name();
	virtual e_race race();
	virtual e_race2 race2();
	virtual status_change* sc();
	virtual size size_();
	virtual int skill_advantage(int x, int y);
	virtual int sp();
	virtual int sp_ratio();
	virtual unit_data* ud();
	virtual int walkpath_length();
	virtual pos_t walkpath_pos(int stes);
};

// ホムンクルスのインターフェイス。
struct homun_if {
	virtual homun_data* hd();
	virtual homun_mapid homun_mapid_();
};

// アイテム使用者のインターフェイス。
struct item_user_if {
	virtual std::unordered_map<int,t_tick>& item_used_ticks();
	virtual void use_item(int ind, bool exc = true);
};

// リーダーのインターフェイス。
struct leader_if {
	virtual std::unordered_map<int,ptr<block_if>>& ally_mobs();
	virtual int& attack_target();
	virtual std::vector<ptr<block_if>>& bots();
	virtual block_list& center();
	virtual std::unordered_map<int,ptr<block_if>>& enemies();
	virtual block_if* find_bot(const std::string& nam);
	virtual block_if* find_member(const std::string& nam);
	virtual ptr<registry_t<int>>& great_mobs();
	virtual ptr<registry_t<int>>& ignore_items();
	virtual t_tick& last_heaby_tick();
	virtual int& last_summoned_id();
	virtual std::vector<block_if*>& members();
	virtual t_tick next_heaby_tick();
	virtual bool& passive();
	virtual ptr<regnum_t<bool>>& rush();
	virtual ptr<registry_t<int>>& sell_items();
	virtual bool& sp_suppliable();
	virtual bool& stay();
	virtual ptr<registry_t<int>>& storage_put_items();
	virtual ptr<registry_t<int,team_t>>& teams();
	virtual void update_bot_indices();
	virtual void update_member_indices();
};

// メンバーのインターフェイス。
struct member_if {
	virtual int& account_id();
	virtual bool can_ka(block_if* tar_mem);
	virtual ptr<registry_t<int>>& cart_auto_get_items();
	virtual int& char_id();
	virtual e_skill combo_skill_id();
	virtual ptr<registry_t<int,distance_policy>>& distance_policies();
	virtual ptr<registry_t<int,equipset_t>>& equipsets();
	virtual int& fd();
	virtual int find_broken_equip(int bas = 0);
	virtual int find_cart(const std::string& nam);
	virtual int find_cart(const item_key& key);
	virtual int find_inventory(const std::string& nam);
	virtual int find_inventory(const item_key& key, int equ = INT_MIN);
	virtual int get_skill_low_rate();
	virtual int get_skill_monsters();
	virtual ptr<regnum_t<int>>& hold_monsters();
	virtual ptr<block_if>& homun();
	virtual void identify_equip(item* itm, storage_context* inv_con = nullptr, storage_context* car_con = nullptr);
	virtual bool is_carton();
	virtual void load_equipset(int mid, equip_pos* equ = nullptr);
	virtual void load_play_skill(int mid, e_skill* kid);
	virtual ptr<regnum_t<bool>>& loot();
	virtual ptr<regnum_t<e_skill>>& skill_auto_spell();
	virtual ptr<regnum_t<int>>& skill_low_rate();
	virtual ptr<regnum_t<int>>& skill_monsters();
	virtual ptr<regnum_t<e_element>>& skill_seven_wind();
	virtual bool magicpower_is_active();
	virtual ptr<registry_t<int,normal_attack_policy>>& normal_attack_policies();
	virtual ptr<block_if>& pet();
	virtual ptr<registry_t<int,play_skill>>& play_skills();
	virtual ptr<registry_t<int,int>>& recover_hp_items();
	virtual ptr<registry_t<int,int>>& recover_sp_items();
	virtual map_session_data*& sd();
	virtual void sit();
	virtual void stand();
	virtual ptr<registry_t<int,int>>& storage_get_items();
};

// モンスターのインターフェイス。
struct mob_if {
	virtual bool can_be_provoke();
	virtual bool has_can_attack();
	virtual bool has_can_move();
	virtual bool has_detector();
	virtual bool has_knockback_immune();
	virtual bool has_mvp();
	virtual bool has_status_immune();
	virtual bool is_berserk();
	virtual bool is_boss();
	virtual bool is_freezable();
	virtual bool is_flora();
	virtual bool is_great(block_if* lea);
	virtual bool is_summoned();
	virtual bool is_undead();
	virtual mob_data*& md();
};

// ペットのインターフェイス。
struct pet_if {
	virtual pet_data* pd();
};

// スキルターゲットのインターフェイス。
struct skill_target_if {
	virtual bool check_skill_used_tick(e_skill kid, t_tick ela_tic);
	virtual std::unordered_map<e_skill,t_tick>& skill_used_ticks();
};

// スキル使用者のインターフェイス。
struct skill_user_if {
	virtual ai_t::done_func& cast_end_func();
	virtual bool can_use_skill(e_skill kid, int klv);
	virtual int check_skill(e_skill kid);
	virtual bool collect_coins(int cou);
	virtual bool collect_spirits(int cou);
	virtual s_skill* find_skill(const std::string& nam);
	virtual s_skill* find_skill(int kid);
	virtual void iterate_skill(yield_skill_func yie);
	virtual ptr<registry_t<int,int>>& limit_skills();
	virtual s_skill* skill(e_skill kid);
	virtual int skill_point();
	virtual int skill_range(e_skill kid, int klv);
	virtual void skill_up(e_skill kid);
	virtual void use_encore(e_skill dan_id);
	virtual bool use_magicpower();
	virtual void use_skill_bl(e_skill kid, int klv, block_list* bl_, bool tur_end = true, ai_t::done_func cas_end_fun = nullptr);
	virtual void use_skill_block(e_skill kid, int klv, block_if* blo, bool tur_end = true, ai_t::done_func cas_end_fun = nullptr);
	virtual void use_skill_self(e_skill kid, int klv, bool tur_end = true, ai_t::done_func cas_end_fun = nullptr);
	virtual void use_skill_xy(e_skill kid, int klv, int x, int y, bool tur_end = true, ai_t::done_func cas_end_fun = nullptr);
};

// 下僕のインターフェイス。
struct slave_if {
	virtual bool exists();
	virtual bool is_active();
	virtual block_if*& master();
};

// ブロックのインターフェイス。
struct block_if :
	virtual battler_if,
	virtual bot_if,
	virtual enemy_if,
	virtual general_if,
	virtual homun_if,
	virtual item_user_if,
	virtual leader_if,
	virtual member_if,
	virtual mob_if,
	virtual pet_if,
	virtual skill_target_if,
	virtual skill_user_if,
	virtual slave_if {};

// バトラーの実装。
struct battler_impl : virtual block_if {
	bool around_wall_exists_;                 // 周辺に壁があるか。
	bool attacked_by_blower_;                 // ノックバックスキル所持モンスターに攻撃を受けているか。
	bool attacked_by_detector_;               // 検知可能モンスターに攻撃を受けているか。
	std::vector<block_if*> attacked_enemies_; // 攻撃を受けている敵モンスターのベクタ。
	block_if* attacked_long_range_attacker_;  // 攻撃を受けている遠隔攻撃モンスター。
	block_if* attacked_short_range_attacker_; // 攻撃を受けている近接攻撃モンスター。
	int attacked_short_range_attackers_;      // 攻撃を受けている近接攻撃モンスター数。
	int battle_index_;                        // 戦闘時のインデックス。
	battle_modes battle_mode_;                // 戦闘モード。
	distance_policy_values
		distance_policy_value_;               // 距離ポリシー値。
	bool is_best_pos_;                        // 最高の位置か。
	normal_attack_policy_values
		normal_attack_policy_value_;          // 通常攻撃ポリシー値。
	block_if* target_enemy_;                  // ターゲットしている敵モンスター。
	ai_t::done_func walk_end_func_;           // 歩行終了ハンドラ。

	virtual bool& around_wall_exists() override;
	virtual void attack(block_if* blo, bool con = true) override;
	virtual bool& attacked_by_blower() override;
	virtual bool& attacked_by_detector() override;
	virtual std::vector<block_if*>& attacked_enemies() override;
	virtual block_if*& attacked_long_range_attacker() override;
	virtual block_if*& attacked_short_range_attacker() override;
	virtual int& attacked_short_range_attackers() override;
	virtual int& battle_index() override;
	virtual battle_modes& battle_mode() override;
	virtual bool check_attack(block_if* ene) override;
	virtual bool check_hp(int rat) override;
	virtual bool check_normal_attack(block_if* ene) override;
	virtual bool check_sp(int rat) override;
	virtual bool check_use_skill(e_skill kid, int klv, block_if* ene) override;
	virtual bool check_use_taunt_skill(block_if* ene) override;
	virtual distance_policy_values& distance_policy_value() override;
	virtual s_skill* find_skill(const std::string& nam) override;
	virtual s_skill* find_skill(int kid) override;
	virtual bool& is_best_pos() override;
	virtual bool is_primary() override;
	virtual normal_attack_policy_values& normal_attack_policy_value() override;
	virtual int skill_ratio(e_skill kid, int klv, block_if* ene) override;
	void start_walking();
	virtual void stop_attacking() override;
	virtual void stop_walking(int typ = USW_FIXPOS) override;
	virtual block_if*& target_enemy() override;
	virtual bool walk_bl(block_list* tbl, int ran = 0) override;
	virtual ai_t::done_func& walk_end_func() override;
	virtual bool walk_xy(int x, int y, int ran = 0) override;
	virtual int weapon_attack_element_ratio(block_if* ene) override;
};

// Botの実装。
struct bot_impl : virtual block_if {
	int bot_index_;                         // Botのインデックス。
	t_tick last_emotion_tick_;              // 最後にエモーションを表示したチック。
	t_tick last_reloaded_equipset_tick_;    // 最後に武具一式をリロードしたチック。
	std::unordered_set<int> request_items_; // 要求アイテムのセット。

	virtual int& bot_index() override;
	virtual bool is_sit() override;
	virtual t_tick& last_emotion_tick() override;
	virtual t_tick& last_reloaded_equipset_tick() override;
	virtual std::unordered_set<int>& request_items() override;
	virtual void respawn() override;
	virtual bool teleport(block_list* bl_) override;
};

// クライアントの実装。
struct client_impl : virtual block_if {
	virtual bool check_range_bl(block_list* bl0, block_list* bl1, int dis) override;
	virtual bool check_range_blxy(block_list* bl_, int x, int y, int dis) override;
	virtual bool check_range_xy(int x0, int y0, int x1, int y1, int dis) override;
};

// 敵モンスターの実装。
struct enemy_impl : virtual block_if {
	std::vector<block_if*> attacked_battlers_; // 攻撃を受けているバトラー。
	std::vector<block_if*> close_battlers_;    // 攻撃範囲内にいる味方。
	bool has_knockback_skill_;                 // ノックバックスキル所持。
	bool has_layout_skill_;                    // レイアウトスキル所持。
	bool has_long_skill_;                      // 遠隔スキル所持。
	bool has_long_weapon_skill_;               // 遠隔物理スキル所持。
	bool has_summon_skill_;                    // 召喚スキル所持。
	bool has_unequip_armor_skill_;             // 武器解除スキル所持。
	bool has_unequip_helm_skill_;              // 盾解除スキル所持。
	bool has_unequip_shield_skill_;            // 鎧解除スキル所持。
	bool has_unequip_weapon_skill_;            // 兜解除スキル所持。
	bool has_usefull_skill_;                   // 有用スキル所持。
	block_if* skill_target_battler_;           // スキルをターゲットしているバトラー。
	block_if* target_battler_;                 // ターゲットしているバトラー。
	block_if* walk_target_battler_;            // 歩行先としてターゲットしているバトラー。
	
	virtual std::vector<block_if*>& attacked_battlers() override;
	virtual int away_distance(block_if* lea) override;
	virtual std::vector<block_if*>& close_battlers() override;
	virtual bool& has_knockback_skill() override;
	virtual bool& has_layout_skill() override;
	virtual bool& has_long_skill() override;
	virtual bool& has_long_weapon_skill() override;
	virtual bool& has_summon_skill() override;
	virtual bool& has_unequip_armor_skill() override;
	virtual bool& has_unequip_helm_skill() override;
	virtual bool& has_unequip_shield_skill() override;
	virtual bool& has_unequip_weapon_skill() override;
	virtual bool& has_usefull_skill() override;
	virtual block_if*& skill_target_battler() override;
	virtual block_if*& target_battler() override;
	virtual pos_t waiting_position() override;
	virtual block_if*& walk_target_battler() override;
};

// 汎用の実装。
struct general_impl : virtual block_if {
	virtual void act_end() override;
	virtual int attack_element_ratio(block_if* src, e_element ele) override;
	virtual bool can_act() override;
	virtual bool can_move() override;
	virtual bool can_reach_bl(block_list* bl_, bool eas = true) override;
	virtual bool can_reach_block(block_if* blo, bool eas = true) override;
	virtual bool can_reach_xy(int x, int y, bool eas = true) override;
	virtual bool check_attack_range(block_if* blo) override;
	virtual bool check_line_bl(block_list* bl_) override;
	virtual bool check_line_block(block_if* blo) override;
	virtual bool check_line_xy(int x, int y) override;
	virtual bool check_sc_types(const sc_type_set& sc_typs) override;
	virtual bool check_skill_range_block(e_skill kid, int klv, block_if* blo) override;
	virtual bool check_skill_range_xy(e_skill kid, int klv, int x, int y) override;
	virtual defType def() override;
	virtual int def2() override;
	virtual e_element element() override;
	virtual int flee() override;
	virtual int hit() override;
	virtual int hp() override;
	virtual int hp_ratio() override;
	virtual bool is_attacking() override;
	virtual bool is_casting() override;
	virtual bool is_ensemble() override;
	virtual bool is_hiding() override;
	virtual bool is_long_range_attacker() override;
	virtual bool is_long_weapon_immune() override;
	virtual bool is_paralysis() override;
	virtual bool is_short_range_attacker() override;
	virtual bool is_solo() override;
	virtual bool is_walking() override;
	virtual int max_hp() override;
	virtual int max_sp() override;
	virtual e_race race() override;
	virtual e_race2 race2() override;
	virtual int attack_range() override;
	virtual status_change* sc() override;
	virtual size size_() override;
	virtual int skill_advantage(int x, int y) override;
	virtual int sp() override;
	virtual int sp_ratio() override;
	virtual unit_data* ud() override;
	virtual int walkpath_length() override;
	virtual pos_t walkpath_pos(int stes) override;
};

// ホムンクルスの実装。
struct homun_impl : virtual block_if {
	virtual block_list* bl() override;
	virtual bool can_use_skill(e_skill kid, int klv) override;
	virtual int check_skill(e_skill kid) override;
	virtual distance_policy_values default_distance_policy_value() override;
	virtual normal_attack_policy_values default_normal_attack_policy_value() override;
	virtual bool exists() override;
	virtual int get_hold_monsters() override;
	virtual homun_data* hd() override;
	virtual homun_mapid homun_mapid_() override;
	virtual bool is_active() override;
	virtual bool is_dead() override;
	virtual bool is_invincible() override;
	virtual bool is_magic_immune() override;
	virtual bool is_no_castcancel() override;
	virtual bool is_no_gemstone() override;
	virtual bool is_wall_side() override;
	virtual void iterate_skill(yield_skill_func yie) override;
	virtual ptr<registry_t<int,int>>& limit_skills() override;
	virtual void load_policy(int mid, distance_policy_values* dis_pol_val, normal_attack_policy_values* nor_att_pol_val) override;
	virtual std::string name() override;
	virtual ptr<registry_t<int>>& reject_skills() override;
	virtual s_skill* skill(e_skill kid) override;
	virtual int skill_point() override;
	virtual void skill_up(e_skill kid) override;
	virtual bool teleport(block_list* bl_) override;
	virtual e_element weapon_attack_element() override;
};

// アイテム使用者の実装。
struct item_user_impl : virtual block_if {
	std::unordered_map<int,t_tick> item_used_ticks_; // アイテム使用チックのマップ。

	virtual std::unordered_map<int,t_tick>& item_used_ticks() override;
	virtual void use_item(int ind, bool exc = true) override;
};

// リーダーの実装。
struct leader_impl : virtual block_if {
	std::unordered_map<int,ptr<block_if>> ally_mobs_; // 敵モンスターのマップ。
	int attack_target_;                               // 攻撃対象とするモンスターのブロックID。
	std::vector<ptr<block_if>> bots_;                 // Botのベクタ。
	block_list center_;                               // 中心。
	std::unordered_map<int,ptr<block_if>> enemies_;   // 敵モンスターのマップ。
	ptr<registry_t<int>> great_mobs_;                 // グレートモンスターのレジストリ。
	ptr<registry_t<int>> ignore_items_;               // 無視アイテムのレジストリ。
	t_tick last_heaby_tick_;                          // 最後に重たいコマンドを実行したチック。
	int last_summoned_id_;                            // 最後に枝召喚したID。
	std::vector<block_if*> members_;                  // メンバーのベクタ。
	bool passive_;                                    // チームがモンスターに反応しないか。
	ptr<regnum_t<bool>> rush_;                        // ラッシュモードの登録値。
	ptr<registry_t<int>> sell_items_;                 // 売却アイテムのレジストリ。
	bool sp_suppliable_;                              // SPを供給可能か。
	bool stay_;                                       // 待機か。
	ptr<registry_t<int>> storage_put_items_;          // 倉庫格納アイテムのレジストリ。
	ptr<registry_t<int,team_t>> teams_;               // チームのレジストリ。

	virtual std::unordered_map<int,ptr<block_if>>& ally_mobs() override;
	virtual int& attack_target() override;
	virtual std::vector<ptr<block_if>>& bots() override;
	virtual block_list& center() override;
	virtual std::unordered_map<int,ptr<block_if>>& enemies() override;
	virtual block_if* find_bot(const std::string& nam) override;
	virtual block_if* find_member(const std::string& nam) override;
	virtual ptr<registry_t<int>>& great_mobs() override;
	virtual ptr<registry_t<int>>& ignore_items() override;
	virtual t_tick& last_heaby_tick() override;
	virtual int& last_summoned_id() override;
	virtual std::vector<block_if*>& members() override;
	virtual t_tick next_heaby_tick() override;
	virtual bool& passive() override;
	virtual ptr<regnum_t<bool>>& rush() override;
	virtual ptr<registry_t<int>>& sell_items() override;
	virtual bool& sp_suppliable() override;
	virtual bool& stay() override;
	virtual ptr<registry_t<int>>& storage_put_items() override;
	virtual ptr<registry_t<int,team_t>>& teams() override;
	virtual void update_bot_indices() override;
	virtual void update_member_indices() override;
};

// メンバーの実装。
struct member_impl : virtual block_if {
	int account_id_;                              // アカウントID。
	ptr<registry_t<int>> cart_auto_get_items_;    // カート自動補充アイテムのレジストリ。
	int char_id_;                                 // キャラクターID。
	ptr<registry_t<int,distance_policy>>
		distance_policies_;                       // 距離ポリシーのレジストリ。
	ptr<registry_t<int,equipset_t>> equipsets_;   // 武具一式のレジストリ。
	int fd_;                                      // ソケットの記述子。
	ptr<regnum_t<int>> hold_monsters_;            // 抱えることのできるモンスター数の登録値。
	ptr<block_if> homun_;                         // ホムンクルス。
	block_if* leader_;                            // リーダー。
	ptr<registry_t<int,int>> limit_skills_;       // 制限スキルのレジストリ。
	ptr<regnum_t<bool>> loot_;                    // ドロップアイテムを拾うかの登録値。
	ptr<regnum_t<e_skill>> skill_auto_spell_;     // オートスペルで選択するスキルの登録値。
	ptr<regnum_t<int>> skill_low_rate_;           // 低ダメージ倍率の登録値。
	ptr<regnum_t<int>> skill_monsters_;           // 範囲スキルの発動モンスター数の登録値。
	ptr<regnum_t<e_element>> skill_seven_wind_;   // 暖かい風で選択する属性の登録値。
	int member_index_;                            // メンバーのインデックス。
	ptr<registry_t<int,normal_attack_policy>>
		normal_attack_policies_;                  // 通常攻撃ポリシーのレジストリ。
	ptr<block_if> pet_;                           // ペット。
	ptr<registry_t<int,play_skill>> play_skills_; // 演奏スキルのレジストリ。
	ptr<registry_t<int,int>> recover_hp_items_;   // HP回復アイテムのレジストリ。
	ptr<registry_t<int,int>> recover_sp_items_;   // SP回復アイテムのレジストリ。
	ptr<registry_t<int>> reject_skills_;          // 拒否スキルのレジストリ。
	map_session_data* sd_;                        // セッションデータ。
	ptr<registry_t<int,int>> storage_get_items_;  // 倉庫補充アイテムのレジストリ。

	virtual int& account_id() override;
	virtual block_list* bl() override;
	virtual bool can_use_skill(e_skill kid, int klv) override;
	virtual bool can_ka(block_if* tar_mem) override;
	virtual ptr<registry_t<int>>& cart_auto_get_items() override;
	virtual int& char_id() override;
	virtual int check_skill(e_skill kid) override;
	virtual e_skill combo_skill_id() override;
	virtual distance_policy_values default_distance_policy_value() override;
	virtual normal_attack_policy_values default_normal_attack_policy_value() override;
	virtual ptr<registry_t<int,distance_policy>>& distance_policies() override;
	virtual ptr<registry_t<int,equipset_t>>& equipsets() override;
	virtual int& fd() override;
	virtual int find_broken_equip(int bas = 0) override;
	virtual int find_cart(const std::string& nam) override;
	virtual int find_cart(const item_key& key) override;
	virtual int find_inventory(const std::string& nam) override;
	virtual int find_inventory(const item_key& key, int equ = INT_MIN) override;
	virtual int get_hold_monsters() override;
	virtual int get_skill_low_rate() override;
	virtual int get_skill_monsters() override;
	virtual int guild_id() override;
	virtual ptr<regnum_t<int>>& hold_monsters() override;
	virtual ptr<block_if>& homun() override;
	virtual void identify_equip(item* itm, storage_context* inv_con = nullptr, storage_context* car_con = nullptr) override;
	virtual bool is_carton() override;
	virtual bool is_dead() override;
	virtual bool is_invincible() override;
	virtual bool is_magic_immune() override;
	virtual bool is_no_castcancel() override;
	virtual bool is_no_gemstone() override;
	virtual bool is_wall_side() override;
	virtual void iterate_skill(yield_skill_func yie) override;
	virtual block_if*& leader() override;
	virtual ptr<registry_t<int,int>>& limit_skills() override;
	virtual void load_equipset(int mid, equip_pos* equ = nullptr) override;
	virtual void load_play_skill(int mid, e_skill* kid) override;
	virtual void load_policy(int mid, distance_policy_values* dis_pol_val, normal_attack_policy_values* nor_att_pol_val) override;
	virtual ptr<regnum_t<bool>>& loot() override;
	virtual ptr<regnum_t<e_skill>>& skill_auto_spell() override;
	virtual ptr<regnum_t<int>>& skill_low_rate() override;
	virtual ptr<regnum_t<int>>& skill_monsters() override;
	virtual ptr<regnum_t<e_element>>& skill_seven_wind() override;
	virtual bool magicpower_is_active() override;
	virtual int& member_index() override;
	virtual std::string name() override;
	virtual ptr<registry_t<int,normal_attack_policy>>& normal_attack_policies() override;
	virtual int party_id() override;
	virtual ptr<block_if>& pet() override;
	virtual ptr<registry_t<int,play_skill>>& play_skills() override;
	virtual ptr<registry_t<int,int>>& recover_hp_items() override;
	virtual ptr<registry_t<int,int>>& recover_sp_items() override;
	virtual ptr<registry_t<int>>& reject_skills() override;
	virtual map_session_data*& sd() override;
	virtual void sit() override;
	virtual s_skill* skill(e_skill kid) override;
	virtual int skill_point() override;
	virtual void skill_up(e_skill kid) override;
	virtual void stand() override;
	virtual ptr<registry_t<int,int>>& storage_get_items() override;
	virtual e_element weapon_attack_element() override;
};

// モンスターの実装。
struct mob_impl : virtual block_if {
	mob_data* md_;       // モンスターデータ。

	virtual block_list* bl() override;
	virtual bool can_be_provoke() override;
	virtual bool has_can_attack() override;;
	virtual bool has_can_move() override;;
	virtual bool has_detector() override;
	virtual bool has_knockback_immune() override;
	virtual bool has_mvp() override;
	virtual bool has_status_immune() override;
	virtual bool is_berserk() override;
	virtual bool is_boss() override;
	virtual bool is_freezable() override;
	virtual bool is_flora() override;
	virtual bool is_great(block_if* lea) override;
	virtual bool is_magic_immune() override;
	virtual bool is_summoned() override;
	virtual bool is_undead() override;
	virtual mob_data*& md() override;
	virtual std::string name() override;
};

// ペットの実装。
struct pet_impl : virtual block_if {
	virtual block_list* bl() override;
	virtual bool exists() override;
	virtual bool is_active() override;
	virtual std::string name() override;
	virtual pet_data* pd() override;
};

// サーバーの実装。
struct server_impl : virtual block_if {
	virtual bool check_range_bl(block_list* bl0, block_list* bl1, int dis) override;
	virtual bool check_range_blxy(block_list* bl_, int x, int y, int dis) override;
	virtual bool check_range_xy(int x0, int y0, int x1, int y1, int dis) override;
};

// スキルターゲットの実装。
struct skill_target_impl : virtual block_if {
	std::unordered_map<e_skill,t_tick> skill_used_ticks_; // スキル使用チックのマップ。

	virtual bool check_skill_used_tick(e_skill kid, t_tick ela_tic) override;
	virtual std::unordered_map<e_skill,t_tick>& skill_used_ticks() override;
};

// スキル使用者の実装。
struct skill_user_impl : virtual block_if {
	ai_t::done_func cast_end_func_; // 詠唱終了ハンドラ。

	virtual ai_t::done_func& cast_end_func() override;
	virtual bool collect_coins(int cou) override;
	virtual bool collect_spirits(int cou) override;
	virtual int skill_range(e_skill kid, int klv) override;
	virtual void use_encore(e_skill dan_id) override;
	virtual bool use_magicpower() override;
	virtual void use_skill_bl(e_skill kid, int klv, block_list* bl_, bool tur_end = true, ai_t::done_func cas_end_fun = nullptr) override;
	virtual void use_skill_block(e_skill kid, int klv, block_if* blo, bool tur_end = true, ai_t::done_func cas_end_fun = nullptr) override;
	virtual void use_skill_self(e_skill kid, int klv, bool tur_end = true, ai_t::done_func cas_end_fun = nullptr) override;
	virtual void use_skill_xy(e_skill kid, int klv, int x, int y, bool tur_end = true, ai_t::done_func cas_end_fun = nullptr) override;
};

// 下僕の実装。
struct slave_impl : virtual block_if {
	block_if* master_;      // 主人。

	virtual int guild_id() override;
	virtual block_if*& leader() override;
	virtual block_if*& master() override;
	virtual int& member_index() override;
	virtual int party_id() override;
};

// メンバー。
struct member_t : battler_impl, client_impl, general_impl, item_user_impl, member_impl, skill_target_impl, skill_user_impl {
	member_t(map_session_data* sd_, block_if* lea);
};

// Bot。
struct bot_t : member_t, bot_impl {
	bot_t(map_session_data* sd_, block_if* lea);
	virtual ~bot_t();
};

// ホムンクルス。
struct homun_t : battler_impl, general_impl, homun_impl, server_impl, skill_target_impl, skill_user_impl, slave_impl {
	homun_t(block_if* mas);
};

// リーダー。
struct leader_t : member_t, leader_impl {
	leader_t(map_session_data* sd_);
	virtual ~leader_t();
};

// モンスター。
struct mob_t : general_impl, mob_impl, server_impl, skill_target_impl {
	mob_t(mob_data* md_);
};

// 敵モンスター。
struct enemy_t : mob_t, enemy_impl {
	enemy_t(mob_data* md_);
};

// ペット。
struct pet_t : general_impl, slave_impl, pet_impl {
	pet_t(block_if* mas);
};

// -----------------------------------------------------------------------------
// レジストリ型の定義

// レジストリ。
template <
	class K, // キーの型。
	class T  // データの型。
> struct registry_t {
	// ロード。
	using load_func = std::function<void(
		sql_session*, // セッション。
		registry_t*     // レジストリ。
	)>;

	// セーブ。
	using save_func = std::function<void(
		sql_session*, // セッション。
		K,            // キー。
		T*            // データ。
	)>;

	// 獲得。
	using yield_func = std::function<
		bool( // 処理続行か。
			K, // キー。
			T* // データ。
		)
	>;

	// ラッパー。
	struct wrapper {
		registry_dirties dirty; // 変更状態。
		ptr<T> data;            // データ。
	};

	std::array<save_func,RD_MAX-RD_INSERT> sav_funs; // 挿入、更新、削除。
	std::unordered_map<K,ptr<wrapper>> wras;         // ラッパーのマップ。
	bool loading;                                    // ロード中か。

	registry_t(load_func loa, save_func ins = nullptr, save_func upd = nullptr, save_func del = nullptr);
	~registry_t();
	int clear();
	template <class O> void copy(O out);
	T* find(K key);
	int import_(registry_t* ano_reg);
	void iterate(yield_func yie);
	void register_(K key, ptr<T> dat);
	void unregister(K key);
};

// データなしレジストリ。
template <
	class K // キーの型。
> struct registry_t<K,void> {
	// ロード。
	using load_func = std::function<void(
		sql_session*, // セッション。
		registry_t*     // レジストリ。
	)>;

	// セーブ。
	using save_func = std::function<void(
		sql_session*, // セッション。
		K             // キー。
	)>;

	// 獲得。
	using yield_func = std::function<
		bool( // 処理続行か。
			K // キー。
		)
	>;

	std::array<save_func,RD_MAX-RD_INSERT> sav_funs;  // 挿入、更新、削除。
	std::unordered_map<K,ptr<registry_dirties>> dirs; // 変更状態のマップ。
	bool loading;                                     // ロード中か。

	registry_t(load_func loa, save_func ins = nullptr, save_func del = nullptr);
	~registry_t();
	int clear();
	template <class O> void copy(O out);
	bool find(K key);
	int import_(registry_t* ano_reg);
	void iterate(yield_func yie);
	void register_(K key);
	void unregister(K key);
};

// 登録値。
template <
	class T // 数値の型。
> struct regnum_t {
	map_session_data* sd; // セッションデータ。
	std::string key;      // キー。
	T cache;              // キャッシュ。

	regnum_t(map_session_data* sd_, const std::string& key_);
	T get();
	void set(T num);
};

// -----------------------------------------------------------------------------
// その他の型の定義

// 末尾挿入反復子。
template <
	class C // コンテナの型。
> struct back_insert_iterator : std::back_insert_iterator<C> {
	using container = C; // コンテナの型。

	using std::back_insert_iterator<C>::back_insert_iterator;
};

// カード変換機。
struct card_converter {
	static ptr<card_converter> instance; // インスタンス。
	std::vector<
		std::vector<
			int // カードID。
		> // カードIDのベクタ。
	> level_cards;                       // カードIDベクタのレベル別ベクタ。

	card_converter();
	int convert(int car_id);
};

// コマンド要素。
struct command_element {
    command_element_types type; // タイプ。
    std::string text;           // テキスト。
};

// コマンドエラー。
struct command_error {
	std::string what; // 原因。
};

// 武具一式。
struct equipset_t {
	int16_t mob_id;                        // モンスターID。
	int16_t individual_mob_id;             // 個別モンスターID。
	struct mob_db* mdb;                    // モンスターデータ。
	std::vector<ptr<equipset_item>> items; // アイテムのベクタ。

	explicit equipset_t(int16_t mid);
};

// チームメンバー。
struct team_member {
	int char_id;      // キャラクターID。
	std::string name; // 名前。
};

// チーム。
struct team_t {
	int tea_num;                           // チームの番号。
	std::vector<ptr<team_member>> members; // メンバーのベクタ。
};

// 武具一式のアイテム。
struct equipset_item {
	equip_pos_orders order; // 装備部位の順序。
	equip_pos equip;        // 装備部位。
	ptr<item_key> key;      // キー。
};

// 挿入反復子。
template <
	class C // コンテナの型。
> struct insert_iterator : std::insert_iterator<C> {
	using container = C; // コンテナの型。

	using std::insert_iterator<C>::insert_iterator;
};

// アイテムのキー。
struct item_key {
	uint16_t nameid;                     // ID。
	char refine;                         // 精錬値。
	char attribute;                      // 状態。
	std::array<uint16_t,MAX_SLOTS> card; // スロット。
	item_data* idb;                      // DB。

	item_key(uint16_t nid);
	item_key(uint16_t nid, uint16_t* car);
	explicit item_key(const std::string& nam);
};

// アイテム使用例外。
struct item_used_exception {};

// 演奏スキル。
struct play_skill {
	int16_t mob_id;            // モンスターID。
	int16_t individual_mob_id; // 個別モンスターID。
	struct mob_db* mdb;        // モンスターデータ。
	e_skill skill_id;          // スキルID。

	play_skill(int16_t mid, e_skill sk_id);
};

// ポリシー。
template <
	class V // 値の型。
> struct policy_t {
	int16_t mob_id;            // モンスターID。
	int16_t individual_mob_id; // 個別モンスターID。
	struct mob_db* mdb;        // モンスターデータ。
	V value;                   // 値。

	explicit policy_t(int16_t mid, V val);
};

// 位置。
struct pos_t {
	int x, y;      // 座標。
	int value;     // 値。
	int advantage; // アドバンテージ。

	pos_t();
	pos_t(int x_, int y_, int val = 0, int adv = 0);
};

// マップ。
struct pybot_map {
	int id;                    // マップID。
	std::string name_english;  // 英語名。
	std::string name_japanese; // 日本語名。
	nation_types nation_type;  // 国の種類。
	map_types map_type;        // マップの種類。
	bool fever_flag;           // フィーバーフラグ。
};

// スコープから抜けるときの処理。
struct scope_exit {
	// 処理。
	using do_func = std::function<void()>;

	do_func do_; // 処理。

	~scope_exit();
};

// スキル所持モンスターIDのセット。
struct skill_mobs {
	static ptr<skill_mobs> instance;        // インスタンス。
	std::unordered_set<int> knockback;      // ノックバック。
	std::unordered_set<int> layout;         // レイアウト。
	std::unordered_set<int> long_;          // 遠隔。
	std::unordered_set<int> long_weapon;    // 遠隔物理。
	std::unordered_set<int> summon;         // 召喚。
	std::unordered_set<int> unequip_armor;  // 鎧解除。
	std::unordered_set<int> unequip_helm;   // 兜解除。
	std::unordered_set<int> unequip_shield; // 盾解除。
	std::unordered_set<int> unequip_weapon; // 武器解除。
	std::unordered_set<int> usefull;        // 有用。

	skill_mobs();
};

// スキルユニットのキー。
struct skill_unit_key {
	e_skill skill_id; // スキルID。
	bl_type src_type; // ソースのタイプ。
	int min_skill_lv; // 最低スキルレベル。
};

// SQLのセッション。
struct sql_session {
	// 処理。
	using do_func = std::function<void(
		sql_session* ses // セッション。
	)>;

	SqlStmt* stmt; // 文。

	explicit sql_session(SqlStmt* stm);
	~sql_session();
	template <class ...A> void execute(A&& ...args);
	bool next_row();
	static void open(do_func do_);
};

// SQLの文脈。
struct sql_context {
	std::stringstream buffer;             // 文のバッファ。
	std::vector<ptr<sql_column>> columns; // 列のベクタ。
	std::vector<ptr<sql_param>> params;   // パラメータのベクタ。

	template <class ...A> void append(A&& ...args);
	template <class ...A> void append_with(const std::string& tex, A&& ...args);
	template <class ...A> void append_with(ptr<sql_column> col, A&& ...args);
	template <class ...A> void append_with(ptr<sql_param> par, A&& ...args);
	void append_with(const std::string& tex);
	void append_with(ptr<sql_column> col);
	void append_with(ptr<sql_param> par);
};

// SQL文にバインドするもの。
struct sql_binder {
	SqlDataType type; // タイプ。
	void* data;       // データ。
	size_t size;      // サイズ。

	template <class T> sql_binder(T& dat, size_t siz = 0);
	virtual ~sql_binder() = default;
	virtual void bind(SqlStmt* stm, int ind) = 0;
};

// SQLの列。
struct sql_column : sql_binder {
	std::string name; // 列名。

	template <class T> sql_column(const std::string& nam, T& dat, size_t siz = 0);
	virtual void bind(SqlStmt* stm, int ind) override;
};

// SQLのパラメータ。
struct sql_param : sql_binder {
	using sql_binder::sql_binder;
	virtual void bind(SqlStmt* stm, int ind) override;
};

// 倉庫の文脈。
struct storage_context {
	// インデックスマップ。
	using index_map = std::unordered_map<
		int, // アイテムID。
		int  // インデックス。
	>;

	int capacity;           // 容量。
	ptr<index_map> indices; // インデックスマップ。
	map_session_data* sd;   // セッションデータ。
	s_storage* storage;     // 倉庫。

	storage_context(int cap, map_session_data* sd_, s_storage* sto);
	virtual ~storage_context() = default;
	virtual bool add(item* itm, int amo) = 0;
	item* at(int ind);
	virtual void delete_(int ind, int amo) = 0;
	int find(int nid);
	int sum(int nid);
	void update_indices_by_adding(item* itm);
	void update_indices_by_deletion(int ind);
};

// 所持アイテムの文脈。
struct inventory_context : storage_context {
	inventory_context(map_session_data* sd_);
	virtual bool add(item* itm, int amo) override;
	virtual void delete_(int ind, int amo) override;
};

// カートの文脈。
struct cart_context : storage_context {
	cart_context(map_session_data* sd_);
	virtual bool add(item* itm, int amo) override;
	virtual void delete_(int ind, int amo) override;
};

// 個人倉庫の文脈。
struct private_storage_context : storage_context {
	private_storage_context(map_session_data* sd_);
	virtual bool add(item* itm, int amo) override;
	virtual void delete_(int ind, int amo) override;
};

// フィーバーマップの数。
struct fever_size {
	nation_types nation_type; // 国の種類。
	map_types map_type;       // マップの種類。
	int size;                 // 数。
};

// ギルド倉庫の文脈。
struct guild_storage_context : storage_context {
	guild_storage_context(map_session_data* sd_);
	virtual bool add(item* itm, int amo) override;
	virtual void delete_(int ind, int amo) override;
};

// サブコマンドの説明。
struct subcommand_desc {
	std::string com_name;     // コマンド名。
	std::string sc_full_name; // サブコマンドの完全名。
	std::string sc_abr_name;  // サブコマンドの略称。
	std::string sc_desc;      // サブコマンドの説明。
};

// サブコマンドの手続き。
struct subcommand_proc {
	std::string com_name;     // コマンド名。
	std::string sc_full_name; // サブコマンドの完全名。
	std::string sc_abr_name;  // サブコマンドの略称。
	subcommand_func func;     // ハンドラ。
};

// ターン終了例外。
struct turn_end_exception {};

// -----------------------------------------------------------------------------
// コマンド用の関数の宣言

SUBCMD_FUNC(Bot, Attack);
SUBCMD_FUNC(Bot, Cart);
SUBCMD_FUNC(Bot, CartAutoGet);
SUBCMD_FUNC(Bot, CartAutoGetClear);
SUBCMD_FUNC(Bot, CartAutoGetTransport);
SUBCMD_FUNC(Bot, CartGet);
SUBCMD_FUNC(Bot, CartPut);
SUBCMD_FUNC(Bot, Equip);
SUBCMD_FUNC(Bot, EquipIdentifyAll);
SUBCMD_FUNC(Bot, EquipRepairAll);
SUBCMD_FUNC(Bot, EquipSet);
SUBCMD_FUNC(Bot, EquipSetClear);
SUBCMD_FUNC(Bot, EquipSetLoad);
SUBCMD_FUNC(Bot, EquipSetTransport);
SUBCMD_FUNC(Bot, Help);
SUBCMD_FUNC(Bot, HoldMonsters);
SUBCMD_FUNC(Bot, HomunsKill);
SUBCMD_FUNC(Bot, HomunsKillLimit);
SUBCMD_FUNC(Bot, HomunsKillUp);
SUBCMD_FUNC(Bot, HomunStatus);
SUBCMD_FUNC(Bot, Item);
SUBCMD_FUNC(Bot, ItemCount);
SUBCMD_FUNC(Bot, ItemDrop);
SUBCMD_FUNC(Bot, ItemIgnore);
SUBCMD_FUNC(Bot, ItemIgnoreClear);
SUBCMD_FUNC(Bot, ItemIgnoreImport);
SUBCMD_FUNC(Bot, ItemRecoverHp);
SUBCMD_FUNC(Bot, ItemRecoverHpClear);
SUBCMD_FUNC(Bot, ItemRecoverHpTransport);
SUBCMD_FUNC(Bot, ItemRecoverSp);
SUBCMD_FUNC(Bot, ItemRecoverSpClear);
SUBCMD_FUNC(Bot, ItemRecoverSpTransport);
SUBCMD_FUNC(Bot, ItemSell);
SUBCMD_FUNC(Bot, ItemSellAll);
SUBCMD_FUNC(Bot, ItemSellClear);
SUBCMD_FUNC(Bot, ItemSellImport);
SUBCMD_FUNC(Bot, LogIn);
SUBCMD_FUNC(Bot, LogOut);
SUBCMD_FUNC(Bot, Loot);
SUBCMD_FUNC(Bot, Memo);
SUBCMD_FUNC(Bot, MonsterGreat);
SUBCMD_FUNC(Bot, MonsterGreatClear);
SUBCMD_FUNC(Bot, MonsterGreatImport);
SUBCMD_FUNC(Bot, PetEquip);
SUBCMD_FUNC(Bot, PetStatus);
SUBCMD_FUNC(Bot, PolicyDistance);
SUBCMD_FUNC(Bot, PolicyDistanceClear);
SUBCMD_FUNC(Bot, PolicyDistanceTransport);
SUBCMD_FUNC(Bot, PolicyNormalAttack);
SUBCMD_FUNC(Bot, PolicyNormalAttackClear);
SUBCMD_FUNC(Bot, PolicyNormalAttackTransport);
SUBCMD_FUNC(Bot, sKill);
SUBCMD_FUNC(Bot, sKillAutoSpell);
SUBCMD_FUNC(Bot, sKillLimit);
SUBCMD_FUNC(Bot, sKillLowRate);
SUBCMD_FUNC(Bot, sKillMonsters);
SUBCMD_FUNC(Bot, sKillPlay);
SUBCMD_FUNC(Bot, sKillPlayClear);
SUBCMD_FUNC(Bot, sKillPlayTransport);
SUBCMD_FUNC(Bot, sKillReject);
SUBCMD_FUNC(Bot, sKillRejectClear);
SUBCMD_FUNC(Bot, sKillRejectTransport);
SUBCMD_FUNC(Bot, sKillSevenWind);
SUBCMD_FUNC(Bot, sKillUp);
SUBCMD_FUNC(Bot, Status);
SUBCMD_FUNC(Bot, StatusUp);
SUBCMD_FUNC(Bot, StorageGet);
SUBCMD_FUNC(Bot, StorageGetAll);
SUBCMD_FUNC(Bot, StorageGetClear);
SUBCMD_FUNC(Bot, StorageGetTransport);
SUBCMD_FUNC(Bot, StoragePut);
SUBCMD_FUNC(Bot, StoragePutAll);
SUBCMD_FUNC(Bot, StoragePutClear);
SUBCMD_FUNC(Bot, StoragePutImport);
SUBCMD_FUNC(Bot, sUmmon);
SUBCMD_FUNC(Bot, Team);
SUBCMD_FUNC(Bot, TeamLogIn);
SUBCMD_FUNC(Bot, TeamLogOut);
SUBCMD_FUNC(Bot, TeamNumber);
SUBCMD_FUNC(Bot, TeamOrder);
SUBCMD_FUNC(Bot, TeamPassive);
SUBCMD_FUNC(Bot, TeamRush);
SUBCMD_FUNC(Bot, TeamStay);
SUBCMD_FUNC(Bot, TradeItem);
SUBCMD_FUNC(Bot, TradeZeny);
SUBCMD_FUNC(Bot, Warp);

int bot_limit(map_session_data* sd);
map_session_data* bot_login(block_if* lea, int bot_aid, int bot_cid, int bot_sex, int bot_gid);
t_tick bot_restart_tick(int cid);
block_if* check_trade_with_bot(block_if* lea, command_argument_list& args);
bool npc_exists(block_list* cen, int rad, npc_subtype typ, const std::string& dis_nam = "");
std::string print_storage(block_if* mem, storage_type sto_typ);
void show_bot_subcommands(int fd);
void show_client(int fd, const std::string& mes);
void skill_user_limit_skill(block_if* lea, command_argument_list& args, block_if* sk_use);
void skill_user_show_skills(int fd, block_if* sk_use);
void skill_user_skill_up(block_if* lea, command_argument_list& args, block_if* sk_use);
void skill_user_use_skill(block_if* lea, command_argument_list& args, block_if* sk_use);
std::string shift_arguments(command_argument_list& args, const std::string& emp_err_mes = "");
block_if* shift_arguments_then_find_bot(block_if* lea, command_argument_list& args);
block_if* shift_arguments_then_find_member(block_if* lea, command_argument_list& args);
int shift_arguments_then_parse_int(command_argument_list& args, const std::string& nam, int min = INT_MIN, int max = INT_MAX);

// -----------------------------------------------------------------------------
// レジストリ用関数の宣言

registry_t<int>::save_func delete_cart_auto_get_item_func(int cid);
registry_t<int,distance_policy>::save_func delete_distance_policy_func(int cid);
registry_t<int,equipset_t>::save_func delete_equipset_func(int cid);
registry_t<int,team_t>::save_func delete_team_func(int cid);
registry_t<int>::save_func delete_great_mob_func(int cid);
registry_t<int>::save_func delete_ignore_item_func(int cid);
registry_t<int,int>::save_func delete_limit_skill_func(int cid);
registry_t<int,normal_attack_policy>::save_func delete_normal_attack_policy_func(int cid);
registry_t<int,play_skill>::save_func delete_play_skill_func(int cid);
registry_t<int,int>::save_func delete_recover_hp_item_func(int cid);
registry_t<int,int>::save_func delete_recover_sp_item_func(int cid);
registry_t<int>::save_func delete_reject_skill_func(int cid);
registry_t<int>::save_func delete_sell_item_func(int cid);
registry_t<int,int>::save_func delete_storage_get_item_func(int cid);
registry_t<int>::save_func delete_storage_put_item_func(int cid);
registry_t<int>::save_func insert_cart_auto_get_item_func(int cid);
registry_t<int,distance_policy>::save_func insert_distance_policy_func(int cid);
registry_t<int,equipset_t>::save_func insert_equipset_func(int cid);
registry_t<int,team_t>::save_func insert_team_func(int cid);
registry_t<int>::save_func insert_great_mob_func(int cid);
registry_t<int>::save_func insert_ignore_item_func(int cid);
registry_t<int,int>::save_func insert_limit_skill_func(int cid);
registry_t<int,normal_attack_policy>::save_func insert_normal_attack_policy_func(int cid);
registry_t<int,play_skill>::save_func insert_play_skill_func(int cid);
registry_t<int,int>::save_func insert_recover_hp_item_func(int cid);
registry_t<int,int>::save_func insert_recover_sp_item_func(int cid);
registry_t<int>::save_func insert_reject_skill_func(int cid);
registry_t<int>::save_func insert_sell_item_func(int cid);
registry_t<int,int>::save_func insert_storage_get_item_func(int cid);
registry_t<int>::save_func insert_storage_put_item_func(int cid);
registry_t<int>::load_func load_cart_auto_get_item_func(int cid);
registry_t<int,distance_policy>::load_func load_distance_policy_func(int cid);
registry_t<int,equipset_t>::load_func load_equipset_func(int cid);
registry_t<int,team_t>::load_func load_team_func(int cid);
registry_t<int>::load_func load_great_mob_func(int cid);
registry_t<int>::load_func load_ignore_item_func(int cid);
registry_t<int,int>::load_func load_limit_skill_func(int cid);
registry_t<int,normal_attack_policy>::load_func load_normal_attack_policy_func(int cid);
registry_t<int,play_skill>::load_func load_play_skill_func(int cid);
registry_t<int,int>::load_func load_recover_hp_item_func(int cid);
registry_t<int,int>::load_func load_recover_sp_item_func(int cid);
registry_t<int>::load_func load_reject_skill_func(int cid);
registry_t<int>::load_func load_sell_item_func(int cid);
registry_t<int,int>::load_func load_storage_get_item_func(int cid);
registry_t<int>::load_func load_storage_put_item_func(int cid);
registry_t<int,distance_policy>::save_func update_distance_policy_func(int cid);
registry_t<int,equipset_t>::save_func update_equipset_func(int cid);
registry_t<int,team_t>::save_func update_team_func(int cid);
registry_t<int,int>::save_func update_limit_skill_func(int cid);
registry_t<int,normal_attack_policy>::save_func update_normal_attack_policy_func(int cid);
registry_t<int,play_skill>::save_func update_play_skill_func(int cid);
registry_t<int,int>::save_func update_recover_hp_item_func(int cid);
registry_t<int,int>::save_func update_recover_sp_item_func(int cid);
registry_t<int,int>::save_func update_storage_get_item_func(int cid);

// -----------------------------------------------------------------------------
// その他の関数の宣言

int actual_nameid(int nid);
template <class C> pybot::back_insert_iterator<C> back_inserter(C& x);
bool bot_can_enter_server(int aid);
template <class C> pybot::insert_iterator<C> inserter(C& x, typename C::iterator i);
int callback_yield_bl(block_list* bl, va_list ap);
bool check_quad_ratio(int x, int y, int rat);
bool check_wall_side(int m, int x, int y);
template <class C, class I> ptr<C> command_collect_blocks(I ele_fir, I ele_las, const std::string& ope, const std::string& clo, bool all_emp);
template <class I, class O> void command_collect_blocks(I ele_fir, I ele_las, O blo_out, const std::string& ope, const std::string& clo, bool all_emp);
template <class C, class I> ptr<C> command_collect_tokens(I ele_fir, I ele_las, const std::string& sep, bool all_emp);
template <class I, class O> void command_collect_tokens(I ele_fir, I ele_las, O tok_out, const std::string& sep, bool all_emp);
template <class C> void command_parse_arguments(const std::string com);
template <class O> void command_parse_arguments(const std::string com, O arg_out);
template <class C, class I> ptr<C> command_parse_blocks(I ele_fir, I ele_las, const std::string& ope, const std::string& clo, bool esc, bool lea);
template <class I, class O> void command_parse_blocks(I ele_fir, I ele_las, O ele_out, const std::string& ope, const std::string& clo, bool esc, bool lea);
template <class C, class I> ptr<C> command_parse_tokens(I ele_fir, I ele_las, const std::string& sep, bool esc, bool lea);
template <class I, class O> void command_parse_tokens(I ele_fir, I ele_las, O ele_out, const std::string& sep, bool esc, bool lea);
template <class C, class I> ptr<C> command_print_all(I eles_fir, I eles_las);
template <class I, class O> void command_print_all(I eles_fir, I eles_las, O tex_out);
template <class I> std::string command_print(I ele_fir, I ele_las);
template <class I> std::string concatinate_strings(I str_fir, I str_las, const std::string& sep = "");
template <class T, class ...A> ptr<T> construct(A&& ...args);
template <class I, class P> typename I::value_type find_if(I fir, I las, P pre, typename I::value_type def = typename I::value_type());
int find_item(s_storage* sto, int cap, const item_key& key, item_data** idbs = nullptr, int equ = INT_MIN);
int find_itemdb(const std::string& nam);
template <class M> typename M::mapped_type find_map_data(const M& map, typename M::key_type key, typename M::mapped_type def = typename M::mapped_type());
template <class M> typename M::key_type find_map_key(const M& map, typename M::mapped_type dat, typename M::key_type def = typename M::key_type());
template <class A> int find_name(const A& arr, const std::string& nam_lc);
mob_data* find_mob(block_if* lea, int mid = 0);
int find_mob_skill(struct mob_db* mdb, mob_skill_pred pre);
int find_skilldb(const std::string& nam);
block_if* get_active_homun(block_if* mem);
block_if* get_homun_if_exists(block_if* mem);
block_if* get_active_pet(block_if* mem);
block_if* get_pet_if_exists(block_if* mem);
template <class T, class ...A> ptr<T> initialize(A&& ...args);
void iterate_corner_bl(block_list* cen, int rad, yield_xy_func yie);
void iterate_corner_xy(int m, int x, int y, int rad, yield_xy_func yie);
void iterate_edge_bl(block_list* cen, int rad, yield_xy_func yie);
void iterate_edge_xy(int m, int x, int y, int rad, yield_xy_func yie);
int iterate_skill_unit(int m, int x, int y, yield_skill_unit_func yie);
void load_maps();
std::string lowercase(const std::string& str);
bool mob_is_pure_flora(mob_data* md);
bool mob_skill_is_long(e_skill kid, int klv);
bool mob_skill_is_long_weapon(e_skill kid, int klv);
std::string npc_display_name(const std::string& npc_name);
int parse_id(const std::string& nam);
int parse_index(const std::string& nam);
template <class ...A> std::string print(A&& ...args);
std::string print_equip_pos(equip_pos equ);
std::string print_equip_type(item_data* idb);
std::string print_item(item* itm, item_data* idb, int amo = 0);
std::string print_item_key(const item_key& key);
std::string print_itemdb(int nid);
template <class D> std::string print_main_status(D* dat);
std::string print_mobdb(int mid);
std::string print_sc(status_change* sc);
template <class O, class L, class ...T> void print_to_with(O& out, const std::string& sep, L lea, T&& ...tras);
template <class O, class A> void print_to_with(O& out, const std::string& sep, A arg);
template <class ...A> std::string print_with(const std::string& sep, A&& ...args);
std::string print_zeny(int zen);
int query_char_id(const std::string& uid, const std::string& upas, const std::string& cnam);
void query_login_data(int cid, std::function<void(int,int,int,int,int,std::string)> yie);
void save_team(block_if* lea, int tea_num);
int sex_string2number(const std::string& str);
void show_error(const std::string& mes);
void show_info(const std::string& mes);
block_pred sift_block_layout(block_if* sk_use, block_if* sk_tar, e_skill kid, int klv, block_pred inn_pre);
block_pred sift_block_path(block_if* sk_use, block_if* sk_tar, e_skill kid, int klv, block_pred inn_pre);
block_pred sift_block_splash(block_if* sk_tar, e_skill kid, int klv, block_pred inn_pre);
bool skill_unit_exists_bl(block_list* bl, const skill_unit_key_map& keys);
bool skill_unit_exists_block(block_if* blo, const skill_unit_key_map& keys);
bool skill_unit_exists_xy(int m, int x, int y, const skill_unit_key_map& keys);
int status_get_base_agi(homun_data* hd);
int status_get_base_dex(homun_data* hd);
int status_get_base_int(homun_data* hd);
int status_get_base_luk(homun_data* hd);
int status_get_base_str(homun_data* hd);
int status_get_base_vit(homun_data* hd);
int status_get_base_agi(map_session_data* sd);
int status_get_base_dex(map_session_data* sd);
int status_get_base_int(map_session_data* sd);
int status_get_base_luk(map_session_data* sd);
int status_get_base_str(map_session_data* sd);
int status_get_base_vit(map_session_data* sd);
int stoi(const std::string& str, int def = 0, int bas = 10);
std::string trim(const std::string& str, const std::string& pad_lets);
template <class T, class R, class ...A> std::function<R(T*,A...)> unbind(R(T::*mem_fun)(A...));
void update_fever();
bool wall_exists(block_list* cen, int rad);

// -----------------------------------------------------------------------------
// 定数の宣言

extern const std::string UNKNOWN_SYMBOL;

extern const std::vector<ai_t::item_use_proc> AI_ITEM_USE_PROCS;
extern const std::unordered_map<e_job,ptr<ai_t::skill_use_proc_vector>> AI_MEMBER_SKILL_USE_PROCS;
extern const ai_t::skill_use_proc_vector AI_MEMBER_TEMPORARY_SKILL_USE_PROCS;
extern const std::unordered_map<homun_mapid,ptr<ai_t::skill_use_proc_vector>> AI_HOMUN_SKILL_USE_PROCS;
extern const std::unordered_map<e_skill,int> ALLY_SKILL_ADVANTAGES;
extern const std::array<std::string,MAX_AMMO_TYPE> AMMO_TYPE_NAME_TABLE;
extern const std::array<std::string,EPO_MAX> ARMOR_TYPE_NAME_TABLE;
extern const std::vector<std::string> BA_FROSTJOKER_MESSAGES;
extern const std::array<battle_mode_flags,BM_MAX> BATTLE_MODE_FLAG_TABLE;
extern const std::vector<ptr<subcommand_desc>> BOT_SUBCMD_DESCS;
extern const std::vector<ptr<subcommand_proc>> BOT_SUBCMD_PROCS;
extern const std::string BROKEN_EQUIP_TAG;
extern const std::string CARD_NAME_POSTFIX;
extern const std::string CASTLE_TRIAL_NPC_NAME;
extern const std::string CAUTION_TAG;
extern const std::string COSTUME_PREFIX;
extern const std::unordered_map<e_job,distance_policy_values> DEFAULT_DISTANCE_POLICY_VALUES;
extern const std::unordered_map<e_job,normal_attack_policy_values> DEFAULT_NORMAL_ATTACK_POLICY_VALUES;
extern const int DEFAULT_SKILL_LOW_RATE;
extern const int DEFAULT_SKILL_MONSTERS;
extern const std::array<std::string,DPV_MAX> DISTANCE_POLICY_VALUE_NAME_TABLE;
extern const std::array<std::string,10> ELEMENT_NAME_TABLE;
extern const skill_unit_key_map ELEMENTAL_SKILL_UNIT_KEYS;
extern const std::unordered_map<e_skill,int> ENEMY_SKILL_ADVANTAGES;
extern const std::array<equip_index,EPO_MAX> EPO2EQI_TABLE;
extern const std::array<std::string,EQI_MAX> EQUIP_POS_NAME_TABLE;
extern const int FAME_OFFSET;
extern const std::string FAME_TAG;
extern const std::string FEVER_RATE_KEY;
extern const sc_type_set GREAT_SC_TYPES;
extern const std::unordered_map<sc_type,std::string> HOMUN_ICON_NAMES;
extern const std::array<std::string,EFST_MAX> ICON_NAME_TABLE;
extern const char ID_PREFIX;
extern const char INDEX_PREFIX;
extern const std::unordered_map<e_job,int> JOB_BOT_LIMITS;
extern const skill_id_set LAYABLE_ON_LP_SKILLS;
extern const std::array<std::string,IT_MAX> ITEM_TYPE_NAME_TABLE;
extern const int ITEM_TYPE_OFFSET;
extern const std::unordered_map<meta_mobs,std::string> META_MONSTER_NAMES;
extern const std::array<std::string,CLASS_MAX> MOB_CLASS_NAME_TABLE;
extern const skill_id_set MOB_SHORT_SKILLS;
extern const std::array<std::string,NAPV_MAX> NORMAL_ATTACK_POLICY_VALUE_NAME_TABLE;
extern const std::string PET_ACCESSORY_TYPE_NAME;
extern const std::array<std::string,10> RACE_NAME_TABLE;
extern const int REPAIR_COST;
extern const std::string REPAIRMAN_NAME;
extern const std::array<std::string,3> SIZE_NAME_TABLE;
extern const std::unordered_map<std::type_index,SqlDataType> SQL_DATA_TYPES;
extern const std::string STAR_FORGED_TAG;
extern const std::array<_sp,ST_MAX> ST2SP_TABLE;
extern const std::array<std::string,ST_MAX> STATUS_TYPE_NAME_TABLE;
extern const std::array<std::string,4> STORAGE_TYPE_NAME_TABLE;
extern const skill_id_set SUMMON_SKILLS;
extern const int TEAM_MAX;
extern const skill_id_set UNEQUIP_ARMOR_SKILLS;
extern const skill_id_set UNEQUIP_HELM_SKILLS;
extern const skill_id_set UNEQUIP_SHIELD_SKILLS;
extern const skill_id_set UNEQUIP_WEAPON_SKILLS;
extern const skill_id_set USEFULL_SKILLS;
extern const std::array<std::string,MAX_WEAPON_TYPE> WEAPON_TYPE_NAME_TABLE;

// -----------------------------------------------------------------------------
// 変数の宣言

extern int ai_timer;
extern std::unordered_map<int,block_if*> all_bots;
extern std::unordered_map<int,ptr<block_if>> all_leaders;
extern std::unordered_map<int,t_tick> bot_dead_ticks;
extern std::unordered_map<int,int> fever_rates;
extern std::unordered_map<int,ptr<pybot_map>> id_maps;
extern std::unordered_map<int,ptr<block_list>> map_initial_positions;
extern t_tick now;
extern std::unordered_map<int,std::vector<ptr<pybot_map>>> type_maps;

}

#include "pybot_template.hpp"

#endif
