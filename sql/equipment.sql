create table if not exists t_classify(
    id            bigint auto_increment primary key,
    classify_code varchar(40) null comment '分类编码',
    classify_name varchar(40) null comment '分类名称'
)comment '分类表';

create table if not exists t_equipment(
    id              bigint auto_increment primary key,
    equipment_type  varchar(4)   null comment '器材类型',
    equipment_code  varchar(40)  null comment '器材编码',
    equipment_price varchar(40)  null comment '设备价格',
    equipment_photo varchar(100) null comment '照片',
    add_time        datetime     null comment '新增时间'
)comment '设备表';

create table if not exists t_equipment(
    id              bigint auto_increment primary key,
    equipment_type  varchar(4)   null comment '器材类型',
    equipment_code  varchar(40)  null comment '器材编码',
    equipment_price varchar(40)  null comment '设备价格',
    equipment_photo varchar(100) null comment '照片',
    add_time        datetime     null comment '新增时间'
)comment '设备表';

INSERT INTO t_classify (id, classify_code, classify_name) VALUES (1, '01', '哑铃');
INSERT INTO t_classify (id, classify_code, classify_name) VALUES (2, '02', '动感单车');
INSERT INTO t_classify (id, classify_code, classify_name) VALUES (3, '03', '跑步机');

INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (2, '1', '002', '30', null, '2024-04-25 16:37:40');
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (4, '1', '004', '30', null, '2024-04-25 16:39:21');
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (5, '2', '005', '400', null, '2024-04-25 16:39:22');
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (6, '2', '006', '400', null, '2024-04-25 16:39:23');
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (7, '2', '007', '400', null, '2024-04-25 16:39:25');
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (8, '2', '008', '400', null, '2024-04-25 16:39:26');
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (9, '2', '009', '400', null, '2024-04-25 16:39:27');
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (11, '2', '011', '400', null, '2024-04-25 16:39:30');
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (12, '2', '012', '400', null, '2024-04-25 16:39:31');
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (13, '2', '013', '400', null, '2024-04-25 16:39:32');
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (14, '1', null, '1', null, null);
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (15, '1', null, '', null, null);
INSERT INTO t_equipment (id, equipment_type, equipment_code, equipment_price, equipment_photo, add_time) VALUES (16, '3', '1314675', '12367896', null, '2024-04-25 22:09:47');
