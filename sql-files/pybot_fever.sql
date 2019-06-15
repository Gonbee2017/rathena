DROP TABLE IF EXISTS `pybot_fever_rate`;
CREATE TABLE `pybot_fever_rate` (
  `map` varchar(11) NOT NULL,
  `rate` mediumint(9) unsigned NOT NULL,
  PRIMARY KEY (`map`)
) ENGINE=MyISAM;

DROP TABLE IF EXISTS `pybot_fever_size`;
CREATE TABLE `pybot_fever_size` (
  `nation_type` tinyint(2) unsigned NOT NULL,
  `map_type` tinyint(2) unsigned NOT NULL,
  `size` tinyint(4) unsigned NOT NULL,
  PRIMARY KEY (`nation_type`, `map_type`)
) ENGINE=MyISAM;

REPLACE INTO `global_acc_reg_num` VALUES(1, 'FEVER_RATE', 0, 200);
REPLACE INTO `global_acc_reg_num` VALUES(1, 'FEVER_RATE', 1, 400);

REPLACE INTO `pybot_fever_size` VALUES(1, 2, 7);
REPLACE INTO `pybot_fever_size` VALUES(1, 3, 7);
REPLACE INTO `pybot_fever_size` VALUES(2, 2, 3);
REPLACE INTO `pybot_fever_size` VALUES(2, 3, 3);
REPLACE INTO `pybot_fever_size` VALUES(3, 2, 2);
REPLACE INTO `pybot_fever_size` VALUES(3, 3, 2);
REPLACE INTO `pybot_fever_size` VALUES(4, 2, 1);
REPLACE INTO `pybot_fever_size` VALUES(4, 3, 2);
