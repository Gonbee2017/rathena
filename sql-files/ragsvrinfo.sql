DROP TABLE IF EXISTS `ragsrvinfo`;
CREATE TABLE `ragsrvinfo` (
	`index` int(11) NOT NULL DEFAULT '0',
	`name` varchar(255) NOT NULL DEFAULT '',
	`exp` int(11) unsigned NOT NULL DEFAULT '0',
	`jexp` int(11) unsigned NOT NULL DEFAULT '0',
	`drop` int(11) unsigned NOT NULL DEFAULT '0'
) ENGINE=MyISAM;
