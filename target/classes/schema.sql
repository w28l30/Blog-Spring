CREATE TABLE IF NOT EXISTS post (
  id      INT(11)               AUTO_INCREMENT PRIMARY KEY,
  title   VARCHAR(255) NOT NULL DEFAULT '',
  content TEXT,
  created DATETIME     NOT NULL
);
CREATE TABLE IF NOT EXISTS comment (
  `id`      INT(11) AUTO_INCREMENT PRIMARY KEY,
  `content` TEXT,
  `post_id` INT(11)  NOT NULL,
  `created` DATETIME NOT NULL
);
CREATE TABLE IF NOT EXISTS tag (
  `id`      INT(11)               AUTO_INCREMENT PRIMARY KEY,
  `name`    VARCHAR(255) NOT NULL DEFAULT '',
  `created` DATETIME     NOT NULL
);
CREATE TABLE IF NOT EXISTS post_tag (
  tag_id  INT(11) NOT NULL,
  post_id INT(11) NOT NULL,
  PRIMARY KEY (tag_id, post_id),
  CONSTRAINT FK_post_id FOREIGN KEY (post_id) REFERENCES post (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT FK_tag_id FOREIGN KEY (tag_id) REFERENCES tag (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS setting (
  `_key`   VARCHAR(255) PRIMARY KEY,
  `_value` TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS users (
  email     VARCHAR(255) PRIMARY KEY,
  password  VARCHAR(255) NOT NULL,
  role      VARCHAR(255) NOT NULL,
  createdAt DATETIME     NOT NULL,
  updatedAt DATETIME     NOT NULL
);
-- INSERT INTO `post`(`title`, `content`, `created`) values('Hello', 'This is a auto created blog', '2016-10-23');