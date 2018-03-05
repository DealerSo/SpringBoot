# 创建t_area表
CREATE TABLE t_area(
  area_id INT(2) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  area_name VARCHAR(200) UNIQUE KEY NOT NULL,
  priority INT(2) NOT NULL DEFAULT 0,
  created_time DATETIME DEFAULT NULL,
  updated_time DATETIME DEFAULT NULL
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;