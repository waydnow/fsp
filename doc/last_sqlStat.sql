/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/6/16 17:37:48                           */
/*==============================================================*/


/*==============================================================*/
/* Table: LU_DEPARTMENT                                         */
/*==============================================================*/
create table LU_DEPARTMENT
(
   ID                   int not null auto_increment,
   NAME                 varchar(128) not null,
   ADDRESS              varchar(256),
   MANAGER              varchar(32),
   PHONE                varchar(128),
   primary key (ID)
);

alter table LU_DEPARTMENT comment '单位表';

/*==============================================================*/
/* Table: LU_GOODS                                              */
/*==============================================================*/
create table LU_GOODS
(
   ID                   int not null auto_increment,
   DEPT_ID              int not null,
   NAME                 varchar(128) not null,
   UNIT                 varchar(32),
   PRICE                decimal(10,2),
   CREATE_USER_ID       int not null,
   CREATE_TIME          datetime not null,
   MEMO                 varchar(255),
   primary key (ID)
);

alter table LU_GOODS comment '物资表';

/*==============================================================*/
/* Index: IDX_GOODS_NAME                                        */
/*==============================================================*/
create index IDX_GOODS_NAME on LU_GOODS
(
   NAME
);

/*==============================================================*/
/* Table: LU_LOGS                                               */
/*==============================================================*/
create table LU_LOGS
(
   ID                   int not null auto_increment,
   OBJ_ID               int,
   OPER_USER_ID         int not null default 0,
   TYPE                 int(3) not null default 0 comment '0:default 1:login 2:
            10:modify good',
   OPER_IP              varchar(128),
   OPER_TIME            datetime not null,
   OPER_DESC            varchar(256),
   primary key (ID)
);

alter table LU_LOGS comment '日志';

/*==============================================================*/
/* Index: IDX_LOG_USER_ID                                       */
/*==============================================================*/
create index IDX_LOG_USER_ID on LU_LOGS
(
   OPER_USER_ID
);

/*==============================================================*/
/* Table: LU_MENU                                               */
/*==============================================================*/
create table LU_MENU
(
   ID                   int not null auto_increment,
   NAME                 varchar(64) not null,
   LINK                 varchar(128),
   PARENT_ID            int,
   ISDISPLAY            int(2) default 0,
   DISPLAY_ORDER        int(3) comment '同级数字越大越靠前',
   primary key (ID)
);

alter table LU_MENU comment '菜单';

/*==============================================================*/
/* Table: LU_ORDER                                              */
/*==============================================================*/
create table LU_ORDER
(
   ID                   int not null auto_increment,
   DEPT_ID              int not null,
   CREATE_USER_ID       int not null,
   CREATE_TIME          datetime not null,
   SUBMIT_TIME          datetime,
   STATUS               int not null,
   AUDIT_USER_ID        int,
   AUDIT_TIME           datetime,
   MEMO                 varchar(1024),
   AUDIT_MEMO           varchar(1024),
   primary key (ID)
);

alter table LU_ORDER comment '订单表';

/*==============================================================*/
/* Table: LU_ORDER_DETAIL                                       */
/*==============================================================*/
create table LU_ORDER_DETAIL
(
   ID                   int not null auto_increment,
   GOOD_ID              int not null,
   ORDER_ID             int not null,
   SEND_TIME            datetime not null,
   GOOD_NUM             int not null,
   GOOD_UNIT            varchar(32) not null,
   MEMO                 varchar(255),
   primary key (ID)
);

alter table LU_ORDER_DETAIL comment '订单明细表';

/*==============================================================*/
/* Table: LU_PERMISSION                                         */
/*==============================================================*/
create table LU_PERMISSION
(
   ID                   int not null auto_increment,
   MENU_ID              int not null,
   ROLE_ID              int not null,
   primary key (ID)
);

alter table LU_PERMISSION comment '权限表';

/*==============================================================*/
/* Table: LU_ROLE                                               */
/*==============================================================*/
create table LU_ROLE
(
   ID                   int not null auto_increment,
   NAME                 varchar(64) not null,
   DELTAG               int(2),
   PARENT_ID            int,
   MEMO                 varchar(255),
   primary key (ID)
);

alter table LU_ROLE comment '角色表';

/*==============================================================*/
/* Table: LU_ROLE_USER                                          */
/*==============================================================*/
create table LU_ROLE_USER
(
   ID                   int not null auto_increment,
   UID                  int not null,
   RID                  int not null,
   primary key (ID)
);

/*==============================================================*/
/* Index: IDX_RU_RID                                            */
/*==============================================================*/
create index IDX_RU_RID on LU_ROLE_USER
(
   RID
);

/*==============================================================*/
/* Index: IDX_RU_UID                                            */
/*==============================================================*/
create index IDX_RU_UID on LU_ROLE_USER
(
   UID
);

/*==============================================================*/
/* Table: LU_USER                                               */
/*==============================================================*/
create table LU_USER
(
   ID                   int not null auto_increment,
   NAME                 varchar(255) not null,
   LOGIN_NAME           varchar(255) not null,
   PWD                  varchar(255) not null,
   DEPT_ID              int,
   PHONE                varchar(128),
   MOBILE               varchar(32),
   EMAIL                varchar(256),
   DELTAG               int(2),
   HEAD_IMG             varchar(255),
   MEMO                 varchar(255),
   primary key (ID)
);

alter table LU_USER comment '用户表';

/*==============================================================*/
/* Index: IDX_USER_NAME                                         */
/*==============================================================*/
create index IDX_USER_NAME on LU_USER
(
   NAME
);

/*==============================================================*/
/* Index: IDX_USER_LOGINNAME                                    */
/*==============================================================*/
create index IDX_USER_LOGINNAME on LU_USER
(
   LOGIN_NAME
);

