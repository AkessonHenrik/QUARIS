-- ---
-- Create database
-- ---

DROP SCHEMA IF EXISTS quaris;

CREATE SCHEMA quaris;
USE quaris;

-- ---
-- Table 'users'
--
-- ---

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INTEGER NOT NULL AUTO_INCREMENT,
  email VARCHAR(64) NOT NULL,
  username VARCHAR(32),
  password VARCHAR(512) NOT NULL,
  UNIQUE (username),
  PRIMARY KEY (id)
);

-- ---
-- Foreign Keys
-- ---


-- ---
-- Table Properties
-- ---

-- ALTER TABLE users ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

