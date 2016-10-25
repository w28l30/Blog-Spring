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
CREATE TABLE IF NOT EXISTS post_tag (
  tag_id int(11) NOT NULL,
  post_id int(11) NOT NULL,
  PRIMARY KEY (tag_id, post_id),
  constraint FK_post_id foreign key(post_id) references post(id),
  constraint FK_tag_id foreign key(tag_id) references tag(id));

-- INSERT INTO `post`(`title`, `content`, `created`) values('Hello', 'This is a auto created blog', '2016-10-23');