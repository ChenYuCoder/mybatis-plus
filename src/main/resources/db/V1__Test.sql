CREATE TABLE `group`
(
    group_id   BIGINT(20)  NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '名称',
    PRIMARY KEY (group_id)
);

DELETE
FROM `group`;

INSERT INTO `group` (group_id, name)
VALUES (1, 'G1');

CREATE TABLE user
(
    id       BIGINT(20)  NOT NULL COMMENT '主键ID',
    name     VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age      INT(11)     NULL DEFAULT NULL COMMENT '年龄',
    email    VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    group_id BIGINT(20)  NOT NULL COMMENT '用户组ID',
    PRIMARY KEY (id)
);

DELETE
FROM user;

INSERT INTO user (id, name, age, email, group_id)
VALUES (1, 'Jone', 18, 'test1@baomidou.com', 1),
       (2, 'Jack', 20, 'test2@baomidou.com', 1),
       (3, 'Tom', 28, 'test3@baomidou.com', 1),
       (4, 'Sandy', 21, 'test4@baomidou.com', 1),
       (5, 'Billie', 24, 'test5@baomidou.com', 1);

