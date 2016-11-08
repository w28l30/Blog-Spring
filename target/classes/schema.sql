CREATE TABLE IF NOT EXISTS post (
  id int(11) auto_increment primary key,
  title varchar(255) NOT NULL DEFAULT '',
  content text,
  created datetime NOT NULL);
CREATE TABLE IF NOT EXISTS  comment (
  `id` int(11) auto_increment primary key,
  `content` text,
  `post_id` int(11) NOT NULL,
  `created` datetime NOT NULL);
CREATE TABLE IF NOT EXISTS  tag (
  `id` int(11) auto_increment primary key,
  `name` varchar(255) NOT NULL DEFAULT '',
  `created` datetime NOT NULL);
CREATE TABLE IF NOT EXISTS post_tag (
  tag_id  INT(11) NOT NULL,
  post_id INT(11) NOT NULL,
  PRIMARY KEY (tag_id, post_id),
  CONSTRAINT FK_post_id FOREIGN KEY (post_id) REFERENCES post(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT FK_tag_id FOREIGN KEY (tag_id) REFERENCES tag(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
CREATE TABLE IF NOT EXISTS  setting (
  `_key` varchar(255) primary key,
  `_value` text NOT NULL );
-- INSERT INTO `post`(`title`, `content`, `created`) values('Hello', 'This is a auto created blog', '2016-10-23');