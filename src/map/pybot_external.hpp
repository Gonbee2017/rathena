// [GonBee]
// パーティーBOT機能の外部から参照される関数を宣言する。

#ifndef PYBOT_EXTERNAL_HPP
#define PYBOT_EXTERNAL_HPP

#include <cstdint>
#include <memory>
#include <string>
#include <vector>

struct block_list;
enum e_skill;
struct flooritem_data;
struct map_session_data;
struct mob_data;

namespace pybot {

// -----------------------------------------------------------------------------
// 列挙の定義

// マップの種類。
enum map_types {
	MT_UNKNOWN, // 不明。
	MT_CITY   , // 街。
	MT_FIELD  , // フィールド。
	MT_DUNGEON, // ダンジョン。
};

// 国の種類。
enum nation_types {
	NT_UNKNOWN    , // 不明。
	NT_MIDGARD    , // ルーンミッドガッツ王国。
	NT_SCHWARZWALD, // シュバルツバルド共和国。
	NT_ARUNAFELTZ , // アルナベルツ教国。
	NT_OTHER      , // その他の国々。
};
	
// -----------------------------------------------------------------------------
// 型の定義

// MVPの統計。
struct mvp_stats {
	std::string char_name; // キャラクター名。
	e_job job;             // 職業。
	int round;             // 周回数。
	int mobs;              // モンスターの数。
};

// メンバー情報。
struct member_info {
	int account_id;        // アカウントID。
	int char_id;           // キャラクターID。
	std::string char_name; // キャラクター名。
	e_job class_;          // 職業。
};

// メモ情報。
struct memo_info {
	int m;                     // マップID。
	int x;                     // X座標。
	int y;                     // Y座標。
	std::string name_english;  // マップ名(英語)。
	std::string name_japanese; // マップ名(日本語)。
};

// -----------------------------------------------------------------------------
// 外部から参照される関数の宣言

void advance_mvp_round(int cid);
void bot_identify_equip(int cid, item* itm);
double calculate_level_rate(block_list* bl, mob_data* md = nullptr);
bool char_is_bot(int cid);
int command_bot(const int fd, map_session_data* sd, const char* mes);
int convert_card(int car_id);
void do_final();
void do_init();
equip_index equip_pos_order_to_index(int ord);
int find_mobdb(const std::string& nam);
bool flooritem_to_be_ignored(map_session_data* sd, flooritem_data* fit);
const char* get_equip_pos_name(equip_index equ_ind);
int get_last_summoned_id(map_session_data* sd);
map_session_data* get_leader(int cid);
block_list* get_map_initial_position(map_session_data* sd);
std::string get_map_name_japanese(int mid);
std::string get_map_name_japanese(const std::string& nam_eng);
std::shared_ptr<std::vector<std::shared_ptr<member_info>>> get_member_list(map_session_data* sd);
bool letter_is_jlead(uint8_t let);
double map_rate(int m);
bool mob_is_normal_mvp(mob_data* md);
void pc_acquired_mvp(map_session_data* sd, mob_data* md);
bool pc_can_takeitem(map_session_data* sd, flooritem_data* fitm);
bool pc_has_acquired_mvp(int cid, int mid);
std::string print_tick(t_tick tic);
std::shared_ptr<std::vector<std::shared_ptr<memo_info>>> query_memo_infos(map_session_data* sd, nation_types nat_typ, map_types map_typ);
std::shared_ptr<std::vector<std::shared_ptr<mvp_stats>>> query_mvp_ranking(const std::vector<e_job>& jobs, int lim);
std::shared_ptr<mvp_stats> query_mvp_stats(int cid);
void reload_equipset_in_battle(int cid);
void set_last_summoned_id(map_session_data* sd, int bid);
void set_map_initial_position(map_session_data* sd);
bool skill_is_layable_on_lp(e_skill kid);
std::string unescape(const std::string& tex);
void update_fever();

// -----------------------------------------------------------------------------
// 外部から参照される定数の宣言

extern const std::string CASH_EXP;
extern const std::string EXTRA_SKILL_POINT;
extern const std::string EXTRA_STATUS_POINT;
extern const std::string MVP_MANIA_ENHANCE;
extern const std::string PYBOT_DUMMY_NPC_NAME;

}

#endif
