DROP TABLE IF EXISTS `pybot_cart_auto_get_item`;
CREATE TABLE `pybot_cart_auto_get_item` (
  `char_id` int(11) unsigned NOT NULL,
  `nameid` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `nameid`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_distance_policy`;
CREATE TABLE `pybot_distance_policy` (
  `char_id` int(11) unsigned NOT NULL,
  `mob_id` mediumint(9) unsigned NOT NULL,
  `value` tinyint(2) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `mob_id`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_equipset`;
CREATE TABLE `pybot_equipset` (
  `char_id` int(11) unsigned NOT NULL,
  `mob_id` mediumint(9) unsigned NOT NULL,
  `order` smallint(5) unsigned NOT NULL,
  `equip` int(11) unsigned NOT NULL,
  `nameid` smallint(5) unsigned NOT NULL,
  `card0` smallint(5) unsigned NOT NULL,
  `card1` smallint(5) unsigned NOT NULL,
  `card2` smallint(5) unsigned NOT NULL,
  `card3` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `mob_id`, `order`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_great_mob`;
CREATE TABLE `pybot_great_mob` (
  `char_id` int(11) unsigned NOT NULL,
  `mob_id` mediumint(9) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `mob_id`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_ignore_item`;
CREATE TABLE `pybot_ignore_item` (
  `char_id` int(11) unsigned NOT NULL,
  `nameid` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `nameid`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_limit_skill`;
CREATE TABLE IF NOT EXISTS `pybot_limit_skill` (
  `char_id` int(11) unsigned NOT NULL,
  `skill_id` int(11) unsigned NOT NULL,
  `skill_lv` tinyint(4) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `skill_id`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_mvp`;
CREATE TABLE `pybot_mvp` (
  `char_id` int(11) unsigned NOT NULL,
  `mob_id` mediumint(9) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `mob_id`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_mvp_stats`;
CREATE TABLE `pybot_mvp_stats` (
  `char_id` int(11) unsigned NOT NULL,
  `round` smallint(5) unsigned NOT NULL,
  `mobs` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`char_id`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_normal_attack_policy`;
CREATE TABLE `pybot_normal_attack_policy` (
  `char_id` int(11) unsigned NOT NULL,
  `mob_id` mediumint(9) unsigned NOT NULL,
  `value` tinyint(2) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `mob_id`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_play_skill`;
CREATE TABLE `pybot_play_skill` (
  `char_id` int(11) unsigned NOT NULL,
  `mob_id` mediumint(9) unsigned NOT NULL,
  `skill_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `mob_id`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_recover_hp_item`;
CREATE TABLE `pybot_recover_hp_item` (
  `char_id` int(11) unsigned NOT NULL,
  `nameid` smallint(5) unsigned NOT NULL,
  `threshold` tinyint(4) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `nameid`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_recover_sp_item`;
CREATE TABLE `pybot_recover_sp_item` (
  `char_id` int(11) unsigned NOT NULL,
  `nameid` smallint(5) unsigned NOT NULL,
  `threshold` tinyint(4) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `nameid`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_reject_skill`;
CREATE TABLE IF NOT EXISTS `pybot_reject_skill` (
  `char_id` int(11) unsigned NOT NULL,
  `skill_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `skill_id`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_sell_item`;
CREATE TABLE `pybot_sell_item` (
  `char_id` int(11) unsigned NOT NULL,
  `nameid` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `nameid`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_storage_get_item`;
CREATE TABLE `pybot_storage_get_item` (
  `char_id` int(11) unsigned NOT NULL,
  `nameid` smallint(5) unsigned NOT NULL,
  `amount` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `nameid`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_storage_put_item`;
CREATE TABLE `pybot_storage_put_item` (
  `char_id` int(11) unsigned NOT NULL,
  `nameid` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`char_id`, `nameid`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_team`;
CREATE TABLE `pybot_team` (
  `leader_char_id` int(11) unsigned NOT NULL,
  `member_index` tinyint(2) unsigned NOT NULL,
  `member_char_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`leader_char_id`, `member_index`)
) ENGINE=MyISAM;
