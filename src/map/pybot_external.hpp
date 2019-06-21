// [GonBee]
// �p�[�e�B�[BOT�@�\�̊O������Q�Ƃ����֐���錾����B

#ifndef PYBOT_EXTERNAL_HPP
#define PYBOT_EXTERNAL_HPP

#include <cstdint>
#include <memory>
#include <vector>

struct block_list;
enum e_skill;
struct flooritem_data;
struct map_session_data;
struct mob_data;

namespace pybot {
	
// -----------------------------------------------------------------------------
// �^�̒�`

// MVP�̓��v�B
struct mvp_stats {
	std::string char_name; // �L�����N�^�[���B
	e_job job;             // �E�ƁB
	int round;             // ���񐔁B
	int mobs;              // �����X�^�[�̐��B
};

// -----------------------------------------------------------------------------
// �O������Q�Ƃ����֐��̐錾

void advance_mvp_round(int cid);
double base_level_rate(block_list* bl, mob_data* md);
void bot_identify_equip(int cid, item* itm);
bool char_is_bot(int cid);
int command_bot(const int fd, map_session_data* sd, const char* mes);
int convert_card(int car_id);
void do_final();
void do_init();
equip_index equip_pos_order_to_index(int ord);
bool flooritem_to_be_ignored(map_session_data* sd, flooritem_data* fit);
const char* get_equip_pos_name(equip_index equ_ind);
map_session_data* get_leader(int cid);
block_list* get_map_initial_position(map_session_data* sd);
double job_level_rate(map_session_data* sd, block_list* bl);
bool letter_is_jlead(uint8_t let);
double map_rate(int m);
void pc_acquired_mvp(int cid, mob_data* md);
bool pc_can_takeitem(map_session_data* sd, flooritem_data* fitm);
bool pc_has_acquired_mvp(int cid, int mid);
std::shared_ptr<std::vector<std::shared_ptr<mvp_stats>>> query_mvp_ranking(const std::vector<e_job>& jobs, int lim);
std::shared_ptr<mvp_stats> query_mvp_stats(int cid);
void reload_equipset_in_battle(int cid);
void set_map_initial_position(map_session_data* sd);
bool skill_is_layable_on_lp(e_skill kid);

}

#endif