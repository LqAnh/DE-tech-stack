-- Bài 1
CREATE TABLE `classes` (
  `id` int(10) unsigned NOT NULL,
  `course_id` int(10) NOT NULL,
  `teacher_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `classes_students` (
  `class_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`class_id`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `courses` (
  `id` tinyint(3) unsigned NOT NULL,
  `course_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `courseId_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `students` (
  `id` int(10) unsigned NOT NULL,
  `student_name` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL,
  `teacher_name` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `course_id` int(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Bài 2
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL,
  `username` varchar(6) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fullname` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `province` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `age` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Username_UNIQUE` (`username`),
  FULLTEXT KEY `f_name` (`fullname`),
  FULLTEXT KEY `province` (`province`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

