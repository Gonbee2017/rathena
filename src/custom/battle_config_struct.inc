// Copyright (c) rAthena Dev Teams - Licensed under GNU GPL
// For more information, see LICENCE in the main folder

/**
 * Custom battle config structure
 * Place the definition of custom battle configuration structure members in this file.
 *
 * Make sure that the name you want is not already taken by looking into battle.h
 * Do not forget to add initilization logic to battle_config_init.inc
 *
 * Format:
 *	 <datatype> name;
 **/

// [GonBee]
int pybot_around_distance;           // 周辺距離。
int pybot_away_distance;             // 敵モンスターから離れていると言える最短距離。
int pybot_away_distance_great;       // グレートモンスターから離れていると言える最短距離。
int pybot_heavy_cool_time;           // Botが重たいコマンドを実行できるようになるまでのクールタイム。
int pybot_reload_equipset_cool_time; // 武具一式をリロードするまでのクールタイム。
int pybot_restart_cool_time;         // BOTが死亡してからリスタートまでのクールタイム。
int pybot_think_time;                // AIを実行する間隔時間。
int max_flee2;                       // 完全回避の上限。
int max_mdef;                        // 除算Mdefの上限。
int max_steal_rate;                  // スティール成功率の上限。
