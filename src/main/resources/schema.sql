CREATE TABLE `post`(
  `id` int(11) auto_increment primary key,
  `title` varchar(255) NOT NULL DEFAULT '',
  `content` text,
  `created` datetime NOT NULL);
CREATE TABLE  `comment`(
  `id` int(11) auto_increment primary key,
  `content` text,
  `post_id` int(11) NOT NULL,
  `created` datetime NOT NULL);

INSERT INTO `post`(`title`, `content`, `created`) values('Hello', 'This is a auto created blog', '2015-01-01');