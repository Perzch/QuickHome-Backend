DROP DATABASE IF EXISTS Quickhome_zch_hwz_gjc;
CREATE DATABASE Quickhome_zch_hwz_gjc;
USE Quickhome_zch_hwz_gjc;

-- 表1 用户表(tab_user_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_user_zch_hwz_gjc;
CREATE TABLE tab_user_zch_hwz_gjc
(
    userId_zch_hwz_gjc      BIGINT PRIMARY KEY auto_increment comment "用户编号",
    userAccount_zch_hwz_gjc VARCHAR(50) comment "用户账户",
    userName_zch_hwz_gjc    VARCHAR(50) comment "用户名",
    userPwd_zch_hwz_gjc     VARCHAR(50) comment "用户密码",
    userEmail_zch_hwz_gjc   VARCHAR(100) comment "用户电子邮箱地址",
    userPhone_zch_hwz_gjc   VARCHAR(50) comment "用户手机号",
    userInDate_zch_hwz_gjc  DATETIME comment "用户注册日期",
    standby1_zch_hwz_gjc    VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc    VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc    VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc     int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);
-- 表2 用户信息表
DROP TABLE IF EXISTS tab_userInformation_zch_hwz_gjc;
CREATE TABLE tab_userInformation_zch_hwz_gjc
(
    UIId_zch_hwz_gjc                 BIGINT PRIMARY KEY auto_increment comment "用户信息编号",
    userId_zch_hwz_gjc               BIGINT comment "用户编号",
    userGender_zch_hwz_gjc           VARCHAR(50) comment "用户性别",
    userHeadId_zch_hwz_gjc           BIGINT comment "用户头像编号",
    userBirthday_zch_hwz_gjc         DATETIME comment "用户生日",
    userSignature_zch_hwz_gjc        VARCHAR(100) comment "个性签名",
    idCardType_zch_hwz_gjc           VARCHAR(10) comment "证件类型",
    idCardNumber_zch_hwz_gjc         VARCHAR(30) comment "证件号码",
    authenticationStatus_zch_hwz_gjc VARCHAR(10) comment "实名认证状态",
    authenticationTime_zch_hwz_gjc   DATETIME comment "实名认证时间",
    standby1_zch_hwz_gjc             VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc             VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc             VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc              int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);
-- 表3 头像表
DROP TABLE IF EXISTS tab_userHeadImage_zch_hwz_gjc;
CREATE TABLE tab_userHeadImage_zch_hwz_gjc
(
    userImageId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment comment "用户头像编号",
    userId_zch_hwz_gjc      BIGINT comment "用户编号",
    imagePath_zch_hwz_gjc   VARCHAR(300) comment "用户头像路径",
    inDateTime_zch_hwz_gjc  DATETIME comment "上传时间",
    standby1_zch_hwz_gjc    VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc    VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc    VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc     int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);
-- 表4 超级管理员表
DROP TABLE IF EXISTS tab_superManager_zch_hwz_gjc;
CREATE TABLE tab_superManager_zch_hwz_gjc
(
    superManagerId_zch_hwz_gjc      BIGINT PRIMARY KEY auto_increment comment "超级管理员编号",
    superManagerAccount_zch_hwz_gjc varchar(50) comment "超级管理员账号",
    superManagerPwd_zch_hwz_gjc     VARCHAR(50) comment "超级管理员密码",
    createTime_zch_hwz_gjc          DATETIME comment "创建时间",
    standby1_zch_hwz_gjc            VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc            VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc            VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc             int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);
-- 表5 管理员表
DROP TABLE IF EXISTS tab_manager_zch_hwz_gjc;
CREATE TABLE tab_manager_zch_hwz_gjc
(
    managerId_zch_hwz_gjc       BIGINT PRIMARY KEY auto_increment comment "管理员编号",
    managerCategory_zch_hwz_gjc VARCHAR(50) comment "管理员类别",
    managerAccount_zch_hwz_gjc  VARCHAR(50) comment "管理员账号",
    managerPwd_zch_hwz_gjc      VARCHAR(50) comment "管理员密码",
    managerName_zch_hwz_gjc     VARCHAR(50) comment "管理员姓名",
    managerPhone_zch_hwz_gjc    VARCHAR(50) comment "管理员电话",
    managerGender_zch_hwz_gjc   VARCHAR(10) comment "管理员性别",
    managerInDate_zch_hwz_gjc   DATETIME comment "创建时间",
    standby1_zch_hwz_gjc        VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc        VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc        VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc         int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);
-- 表6 金额表
DROP TABLE IF EXISTS tab_accountBalance_zch_hwz_gjc;
CREATE TABLE tab_accountBalance_zch_hwz_gjc
(
    bid_zch_hwz_gjc              BIGINT PRIMARY KEY auto_increment comment "金额表编号",
    userId_zch_hwz_gjc           BIGINT comment "用户编号",
    userBalance_zch_hwz_gjc      DOUBLE comment "用户账户余额",
    userDeposit_zch_hwz_gjc      DOUBLE comment "用户账户押金",
    lastModifiedDate_zch_hwz_gjc DATETIME comment "最后修改时间",
    openTime_zch_hwz_gjc         DATETIME comment "开户时间",
    standby1_zch_hwz_gjc         VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc         VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc         VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc          int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表7 房屋表
DROP TABLE IF EXISTS tab_Home_zch_hwz_gjc;
CREATE TABLE tab_Home_zch_hwz_gjc
(
    homeId_zch_hwz_gjc      BIGINT PRIMARY KEY auto_increment comment "房屋编号",
    homeName_zch_hwz_gjc    VARCHAR(50) comment "房屋名称",
    homeType_zch_hwz_gjc    VARCHAR(50) comment "房屋类型",
    homeDayRent_zch_hwz_gjc DOUBLE comment "每日租金",
    homeState_zch_hwz_gjc   VARCHAR(50) comment "房屋状态",
    homeAddress_zch_hwz_gjc VARCHAR(500) comment "房屋地址",
    standby1_zch_hwz_gjc    VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc    VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc    VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc     int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);


-- 表7附1 房屋信息表
DROP TABLE IF EXISTS tab_homeInformation_zch_hwz_gjc;
CREATE TABLE tab_homeInformation_zch_hwz_gjc
(
    homeInfId_zch_hwz_gjc      BIGINT PRIMARY KEY auto_increment comment "房屋信息编号",
    homeId_zch_hwz_gjc         BIGINT comment "房屋编号",
    homeArea_zch_hwz_gjc       DOUBLE comment "房屋面积",
    houseStructure_zch_hwz_gjc VARCHAR(50) comment "房屋结构",
    maxPerson_zch_hwz_gjc      INT comment "最大入住人数",
    homeDeposit_zch_hwz_gjc    DOUBLE comment "房屋押金",
    homeInDate_zch_hwz_gjc     DATETIME comment "房屋注册日期",
    standby1_zch_hwz_gjc       VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc       VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc       VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc        int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表8 维修保洁与维护信息表(tab_repairCleaningAndMaintenanceInformation_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_RCAMI_zch_hwz_gjc;
CREATE TABLE tab_RCAMI_zch_hwz_gjc
(
    workItemId_zch_hwz_gjc            BIGINT PRIMARY KEY auto_increment comment "维修保洁与维护信息编号",
    informationCreatTime_zch_hwz_gjc  DATETIME comment "信息创建时间",
    completionProcessTime_zch_hwz_gjc DATETIME comment "完成处理时间",
    RCAMIInformation_zch_hwz_gjc      VARCHAR(50) comment "信息内容",
    des_zch_hwz_gjc                   VARCHAR(50) comment "描述",
    workUserId_zch_hwz_gjc            BIGINT comment "工作人员编号",
    completion_zch_hwz_gjc            VARCHAR(50) comment "完成情况",
    publisherId_zch_hwz_gjc           BIGINT comment "发布人编号",
    orderId_zch_hwz_gjc               BIGINT(20) comment "订单编号",
    homeId_zch_hwz_gjc                BIGINT comment "房屋编号",
    standby1_zch_hwz_gjc              VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc              VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc              VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc               int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表9 用户统一通知表(tab_userNotification_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_userNotification_zch_hwz_gjc;
CREATE TABLE tab_userNotification_zch_hwz_gjc
(
    userNotificationId_zch_hwz_gjc      BIGINT PRIMARY KEY auto_increment comment "用户通知编号",
    notificationReleaseTime_zch_hwz_gjc DATETIME comment "通知发布时间",
    notifyPostManager_zch_hwz_gjc       BIGINT comment "通知发布管理员编号",
    notificationContent_zch_hwz_gjc     VARCHAR(500) comment "通知内容",
    standby1_zch_hwz_gjc                VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc                VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc                VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc                 int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表10 优惠券表(tab_coupon_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_coupon_zch_hwz_gjc;
CREATE TABLE tab_coupon_zch_hwz_gjc
(
    couponId_zch_hwz_gjc            BIGINT PRIMARY KEY auto_increment comment "优惠券编号",
    couponName_zch_hwz_gjc          VARCHAR(50) comment "优惠券名称",
    discountMethod_zch_hwz_gjc      VARCHAR(50) comment "优惠方式",
    discountIntensity_zch_hwz_gjc   DOUBLE comment "优惠力度",
    useThreshold_zch_hwz_gjc        DOUBLE comment "使用门槛",
    applicableScope_zch_hwz_gjc     VARCHAR(50) comment "适用范围",
    discountInformation_zch_hwz_gjc VARCHAR(50) comment "优惠信息",
    earliestUseTime_zch_hwz_gjc     DATETIME comment "最早使用时间",
    latestUseTime_zch_hwz_gjc       DATETIME comment "最晚使用时间",
    standby1_zch_hwz_gjc            VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc            VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc            VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc             int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);
-- 附表1 优惠用户详情表
DROP TABLE IF EXISTS tab_usersAndCoupons_zch_hwz_gjc;
CREATE TABLE tab_usersAndCoupons_zch_hwz_gjc
(
    UACID_zch_hwz_gjc     BIGINT PRIMARY KEY auto_increment comment "优惠用户详情编号",
    condition_zch_hwz_gjc VARCHAR(50) comment "使用状况",
    userId_zch_hwz_gjc    BIGINT comment "用户编号",
    couponId_zch_hwz_gjc  BIGINT comment "优惠券编号",
    standby1_zch_hwz_gjc  VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc  VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc  VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc   int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表11 日志表(tab_log_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_log_zch_hwz_gjc;
CREATE TABLE tab_log_zch_hwz_gjc
(
    logId_zch_hwz_gjc            BIGINT PRIMARY KEY auto_increment comment "日志编号",
    userPerformingId_zch_hwz_gjc BIGINT comment "用户执行编号",
    executionTime_zch_hwz_gjc    DATETIME comment "执行时间",
    executionContent_zch_hwz_gjc VARCHAR(100) comment "执行内容",
    deviceId_zch_hwz_gjc         VARCHAR(50) comment "设备编号",
    executionPlace_zch_hwz_gjc   VARCHAR(100) comment "执行地点",
    standby1_zch_hwz_gjc         VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc         VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc         VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc          int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表12 房屋评论表(tab_housingReview_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_housingReview_zch_hwz_gjc;
CREATE TABLE tab_housingReview_zch_hwz_gjc
(
    housingReviewId_zch_hwz_gjc       BIGINT PRIMARY KEY auto_increment comment "房屋评论编号",
    comments_zch_hwz_gjc              VARCHAR(500) comment "评论内容",
    userId_zch_hwz_gjc                BIGINT comment "用户编号",
    homeId_zch_hwz_gjc                BIGINT comment "房屋编号",
    reviewTime_zch_hwz_gjc            DATETIME comment "评论时间",
    housingReviewRating_zch_hwz_gjc   INT comment "评分",
    homeLikeCount_zch_hwz_gjc         int default 0 comment "点赞数",
    secondHousingReviewId_zch_hwz_gjc BIGINT comment "二级评论编号",
    standby1_zch_hwz_gjc              VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc              VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc              VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc               int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);


-- 表13 私信聊天记录
DROP TABLE IF EXISTS tab_myChat_zch_hwz_gjc;
CREATE TABLE tab_myChat_zch_hwz_gjc
(
    chatId_zch_hwz_gjc               BIGINT PRIMARY KEY auto_increment comment "私信编号",
    messageReceive_zch_hwz_gjc       BIGINT comment "接收人编号",
    messageContent_zch_hwz_gjc       VARCHAR(500) comment "私信内容",
    messageSender_zch_hwz_gjc        BIGINT comment "发送人编号",
    conversationDialogId_zch_hwz_gjc BIGINT comment "对话编号",
    sendingTime_zch_hwz_gjc          DATETIME comment "发送时间",
    standby1_zch_hwz_gjc             VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc             VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc             VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc              int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表14 景点表(tab_attractions_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_attractions_zch_hwz_gjc;
CREATE TABLE tab_attractions_zch_hwz_gjc
(
    attractionsId_zch_hwz_gjc         BIGINT PRIMARY KEY auto_increment comment "景点编号",
    attractionsName_zch_hwz_gjc       VARCHAR(50) comment "景点名称",
    attractionInformation_zch_hwz_gjc VARCHAR(500) comment "景点介绍",
    openingTime_zch_hwz_gjc           DATETIME comment "景点开放时间",
    closingTime_zch_hwz_gjc           DATETIME comment "景点关闭时间",
    attractionInDate_zch_hwz_gjc      DATETIME comment "信息录入时间",
    standby1_zch_hwz_gjc              VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc              VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc              VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc               int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表15 景点评论表表(tab_attractionReview_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_attractionReview_zch_hwz_gjc;
CREATE TABLE tab_attractionReview_zch_hwz_gjc
(
    attractionReviewId_zch_hwz_gjc       BIGINT PRIMARY KEY auto_increment comment "景点评论编号",
    comments_zch_hwz_gjc                 VARCHAR(500) comment "评论内容",
    userId_zch_hwz_gjc                   BIGINT comment "用户编号",
    attractionsId_zch_hwz_gjc            BIGINT comment "景点编号",
    reviewTime_zch_hwz_gjc               DATETIME comment "评论时间",
    attractionLikeCount_zch_hwz_gjc      INT default 0 comment "点赞数",
    attractionReviewRating_zch_hwz_gjc   INT comment "评分",
    secondAttractionReviewId_zch_hwz_gjc BIGINT comment "二级评论编号",
    standby1_zch_hwz_gjc                 VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc                 VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc                 VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc                  int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表16 房屋收藏表
DROP TABLE IF EXISTS tab_houseCollection_zch_hwz_gjc;
CREATE TABLE tab_houseCollection_zch_hwz_gjc
(
    hFavoriteRecordsId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment comment "房屋收藏编号",
    userId_zch_hwz_gjc             BIGINT comment "用户编号",
    homeId_zch_hwz_gjc             BIGINT comment "房屋编号",
    collectionTime_zch_hwz_gjc     DATETIME comment "收藏时间",
    standby1_zch_hwz_gjc           VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc           VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc           VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc            int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);
-- 表17 景点收藏表
DROP TABLE IF EXISTS tab_attractionCollection_zch_hwz_gjc;
CREATE TABLE tab_attractionCollection_zch_hwz_gjc
(
    aFavoriteRecordsId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment comment "景点收藏编号",
    userId_zch_hwz_gjc             BIGINT comment "用户编号",
    attractionsId_zch_hwz_gjc      BIGINT comment "景点编号",
    collectionTime_zch_hwz_gjc     DATETIME comment "收藏时间",
    standby1_zch_hwz_gjc           VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc           VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc           VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc            int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表18 订单表(tab_order_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_order_zch_hwz_gjc;
CREATE TABLE tab_order_zch_hwz_gjc
(
    orderId_zch_hwz_gjc             BIGINT(20) PRIMARY KEY auto_increment comment "订单编号",
    homeId_zch_hwz_gjc              BIGINT(20) comment "房屋编号",
    DynamicDoorPassword_zch_hwz_gjc VARCHAR(50) comment "动态门卡密码",
    creationTime_zch_hwz_gjc        DATETIME comment "订单创建时间",
    endTime_zch_hwz_gjc             DATETIME comment "订单结束时间",
    checkInTime_zch_hwz_gjc         DATETIME comment "入住时间",
    checkOutTime_zch_hwz_gjc        DATETIME comment "退房时间",
    orderPayment_zch_hwz_gjc        DOUBLE comment "订单支付金额",
    orderDeposit_zch_hwz_gjc        DOUBLE comment "房屋押金",
    orderState_zch_hwz_gjc          VARCHAR(50) comment "订单状态", -- 已结束/正常/待结算
    userId_zch_hwz_gjc              BIGINT comment "用户编号",
    standby1_zch_hwz_gjc            VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc            VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc            VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc             int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表19: 司机信息表 
DROP TABLE IF EXISTS tab_driverInfo_zch_hwz_gjc;
CREATE TABLE tab_driverInfo_zch_hwz_gjc
(
    driverID_zch_hwz_gjc           BIGINT PRIMARY KEY AUTO_INCREMENT comment "司机编号",
    driverName_zch_hwz_gjc         VARCHAR(50) comment "司机姓名",
    contactPhoneNumber_zch_hwz_gjc VARCHAR(50) comment "联系电话",
    idNumber_zch_hwz_gjc           VARCHAR(50) comment "身份证号码",
    licenseNumber_zch_hwz_gjc      VARCHAR(50) comment "驾驶证号码",
    standby1_zch_hwz_gjc           VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc           VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc           VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc            int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表20: 汽车信息表
DROP TABLE IF EXISTS tab_carInfo_zch_hwz_gjc;
CREATE TABLE tab_carInfo_zch_hwz_gjc
(
    carID_zch_hwz_gjc              BIGINT PRIMARY KEY AUTO_INCREMENT comment "汽车编号",
    brand_zch_hwz_gjc              VARCHAR(50) comment "汽车品牌",
    model_zch_hwz_gjc              VARCHAR(50) comment "汽车型号",
    licensePlateNumber_zch_hwz_gjc VARCHAR(50) comment "车牌号码",
    carColor_zch_hwz_gjc           VARCHAR(50) comment "汽车颜色",
    entryTime_zch_hwz_gjc          VARCHAR(50) comment "汽车录入时间",
    standby1_zch_hwz_gjc           VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc           VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc           VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc            int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表21: 预约表 
DROP TABLE IF EXISTS tab_carReservation_zch_hwz_gjc;
CREATE TABLE tab_carReservation_zch_hwz_gjc
(
    reservationID_zch_hwz_gjc      BIGINT PRIMARY KEY AUTO_INCREMENT comment "预约编号",
    driverID_zch_hwz_gjc           BIGINT comment "司机编号",
    userId_zch_hwz_gjc             BIGINT comment "用户编号",
    carID_zch_hwz_gjc              BIGINT comment "汽车编号",
    carReservationTime_zch_hwz_gjc DATETIME comment "客户预约时间",
    reservationStatus_zch_hwz_gjc  VARCHAR(10) comment "客户预约状态",
    standby1_zch_hwz_gjc           VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc           VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc           VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc            int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表22:行程记录表
DROP TABLE IF EXISTS tab_tripRecord_zch_hwz_gjc;
CREATE TABLE tab_tripRecord_zch_hwz_gjc
(
    recordID_zch_hwz_gjc         BIGINT PRIMARY KEY AUTO_INCREMENT comment "记录编号",
    reservationID_zch_hwz_gjc    BIGINT comment "预约编号",
    startingPoint_zch_hwz_gjc    VARCHAR(50) comment "起点",
    destination_zch_hwz_gjc      VARCHAR(50) comment "终点",
    startingTime_zch_hwz_gjc     DATETIME comment "开始时间",
    endTime_zch_hwz_gjc          DATETIME comment "结束时间",
    distanceTraveled_zch_hwz_gjc DOUBLE comment "行程距离",
    standby1_zch_hwz_gjc         VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc         VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc         VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc          int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表23: 房屋设备表
DROP TABLE IF EXISTS tab_homeDevice_zch_hwz_gjc;
CREATE TABLE tab_homeDevice_zch_hwz_gjc
(
    deviceID_zch_hwz_gjc         BIGINT PRIMARY KEY AUTO_INCREMENT comment "设备编号",
    homeId_zch_hwz_gjc           BIGINT comment "房屋编号",
    deviceName_zch_hwz_gjc       VARCHAR(50) comment "设备名称",
    deviceType_zch_hwz_gjc       VARCHAR(20) comment "设备类型(电视/空调/冰箱/洗衣机/热水器/冷暖器)",
    deviceProperties_zch_hwz_gjc VARCHAR(20) comment "设备属性(安全设备/基础设备/智能设备)",
    brand_zch_hwz_gjc            VARCHAR(50) comment "品牌",
    price_zch_hwz_gjc            DECIMAL(10, 2) comment "价格",
    standby1_zch_hwz_gjc         VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc         VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc         VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc          int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表24:设备状态表
DROP TABLE IF EXISTS tab_deviceStatus_zch_hwz_gjc;
CREATE TABLE tab_deviceStatus_zch_hwz_gjc
(
    statusID_zch_hwz_gjc     BIGINT PRIMARY KEY AUTO_INCREMENT comment "状态编号",
    deviceID_zch_hwz_gjc     BIGINT comment "设备编号",
    deviceStatus_zch_hwz_gjc VARCHAR(20) comment "设备状态",
    updateTime_zch_hwz_gjc   DATETIME comment "更新时间",
    standby1_zch_hwz_gjc     VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc     VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc     VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc      int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表25: 设备控制记录表
DROP TABLE IF EXISTS tab_deviceControlRecord_zch_hwz_gjc;
CREATE TABLE tab_deviceControlRecord_zch_hwz_gjc
(
    recordID_zch_hwz_gjc              BIGINT PRIMARY KEY AUTO_INCREMENT comment "记录编号",
    userID_zch_hwz_gjc                BIGINT comment "用户编号",
    deviceID_zch_hwz_gjc              BIGINT comment "设备编号",
    controlTime_zch_hwz_gjc           DATETIME comment "控制时间",
    controlType_zch_hwz_gjc           VARCHAR(20) comment "控制类型",
    controlContent_zch_hwz_gjc        VARCHAR(50) comment "控制内容",
    deviceReservationTime_zch_hwz_gjc DATETIME comment "设备预约时间",
    standby1_zch_hwz_gjc              VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc              VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc              VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc               int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);


-- 表27: 汽车订单表
DROP TABLE IF EXISTS tab_carOrder_zch_hwz_gjc;
CREATE TABLE tab_carOrder_zch_hwz_gjc
(
    orderID_zch_hwz_gjc      BIGINT PRIMARY KEY AUTO_INCREMENT comment "订单编号",
    userID_zch_hwz_gjc       BIGINT comment "用户编号",
    carID_zch_hwz_gjc        BIGINT comment "汽车编号",
    driverID_zch_hwz_gjc     BIGINT comment "司机编号",
    orderTime_zch_hwz_gjc    DATETIME comment "下单时间",
    orderStatus_zch_hwz_gjc  VARCHAR(20) comment "订单状态",
    orderAmount_zch_hwz_gjc  DECIMAL(10, 2) comment "订单金额",
    tripRecordID_zch_hwz_gjc BIGINT comment "行程记录编号",
    standby1_zch_hwz_gjc     VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc     VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc     VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc      int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);


-- 表28: 支付密码表
DROP TABLE IF EXISTS tab_paymentPassword_zch_hwz_gjc;
CREATE TABLE tab_paymentPassword_zch_hwz_gjc
(
    passwordID_zch_hwz_gjc      BIGINT PRIMARY KEY AUTO_INCREMENT comment "支付密码编号",
    accountID_zch_hwz_gjc       BIGINT comment "账号编号",
    paymentPassword_zch_hwz_gjc VARCHAR(6) comment "支付密码",
    setTime_zch_hwz_gjc         DATETIME comment "设置时间",
    standby1_zch_hwz_gjc        VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc        VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc        VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc         int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表29 房屋图片表
DROP TABLE IF EXISTS tab_homeImage_zch_hwz_gjc;
CREATE TABLE tab_homeImage_zch_hwz_gjc
(
    imageId_zch_hwz_gjc    BIGINT PRIMARY KEY auto_increment comment "图片编号",
    homeId_zch_hwz_gjc     BIGINT comment "房屋编号",
    imagePath_zch_hwz_gjc  VARCHAR(300) comment "图片路径",
    inDateTime_zch_hwz_gjc DATETIME comment "上传时间",
    standby1_zch_hwz_gjc   VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc   VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc   VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc    int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表30 汽车使用情况表
DROP TABLE IF EXISTS tab_carUseStatus_zch_hwz_gjc;
CREATE TABLE tab_carUseStatus_zch_hwz_gjc
(
    useStatusID_zch_hwz_gjc        BIGINT PRIMARY KEY AUTO_INCREMENT comment "使用情况编号",
    carID_zch_hwz_gjc              BIGINT comment "汽车编号",
    useDate_zch_hwz_gjc            DATE comment "使用日期",
    useStatus_zch_hwz_gjc          VARCHAR(20) comment "使用情况",
    mileage_zch_hwz_gjc            INT comment "里程",
    tireSituation_zch_hwz_gjc      VARCHAR(100) comment "轮胎情况",
    otherMaintenance_zch_hwz_gjc   VARCHAR(200) comment "其他维修情况",
    nextInspectionTime_zch_hwz_gjc DATE comment "下次维修时间",
    inspectRemark_zch_hwz_gjc      VARCHAR(200) comment "维修备注",
    standby1_zch_hwz_gjc           VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc           VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc           VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc            int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表31 维修保洁绑定房屋表
DROP TABLE IF EXISTS tab_managerHomeBinding_zch_hwz_gjc;
CREATE TABLE tab_managerHomeBinding_zch_hwz_gjc
(
    bindingID_zch_hwz_gjc    BIGINT PRIMARY KEY AUTO_INCREMENT comment "维修保洁绑定编号",
    managerID_zch_hwz_gjc    BIGINT comment "维修保洁编号",
    homeID_zch_hwz_gjc       BIGINT comment "房屋编号",
    bindingType_zch_hwz_gjc  VARCHAR(20) comment "绑定人类型",
    bindingTime_zch_hwz_gjc  DATETIME comment "绑定时间",
    bindingState_zch_hwz_gjc VARCHAR(20) comment "绑定状态",
    standby1_zch_hwz_gjc     VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc     VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc     VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc      int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表32 景点图片表
DROP TABLE IF EXISTS tab_attractionImage_zch_hwz_gjc;
CREATE TABLE tab_attractionImage_zch_hwz_gjc
(
    imageId_zch_hwz_gjc      BIGINT PRIMARY KEY auto_increment comment "图片编号",
    attractionId_zch_hwz_gjc BIGINT comment "景点编号",
    imagePath_zch_hwz_gjc    VARCHAR(300) comment "图片路径",
    inDateTime_zch_hwz_gjc   DATETIME comment "上传时间",
    standby1_zch_hwz_gjc     VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc     VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc     VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc      int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表33 身份证记录表
DROP TABLE if exists tab_IDCardRecord_zch_hwz_gjc;
CREATE TABLE tab_IDCardRecord_zch_hwz_gjc
(
    IDCardRecordID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT comment "身份证记录编号",
    IDCardName_zch_hwz_gjc     VARCHAR(20) comment "身份证姓名",
    IDCardNumber_zch_hwz_gjc   VARCHAR(20) comment "身份证号码",
    IDCardPhoneNumber_zch_hwz_gjc VARCHAR(20) comment "身份证手机号码",
    userId_zch_hwz_gjc         BIGINT comment "写入用户id",
    inDateTime_zch_hwz_gjc     DATETIME comment "上传记录时间",
    standby1_zch_hwz_gjc       VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc       VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc       VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc        int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表34 身份信息对照表
drop table if exists tab_IdentityChecklist_zch_hwz_gjc;
create table tab_IdentityChecklist_zch_hwz_gjc
(
    IdentityChecklistID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT comment "身份信息对照编号",
    IDCardRecordID_zch_hwz_gjc      BIGINT comment "身份证记录编号",
    orderID_zch_hwz_gjc             BIGINT comment "订单编号",
    standby1_zch_hwz_gjc            VARCHAR(50) comment "备用字段1",
    standby2_zch_hwz_gjc            VARCHAR(50) comment "备用字段2",
    standby3_zch_hwz_gjc            VARCHAR(50) comment "备用字段3",
    deleted_zch_hwz_gjc             int default 0 comment "逻辑删除（默认0，逻辑删除1）"
);

-- 表1 用户表
ALTER TABLE tab_user_zch_hwz_gjc
    AUTO_INCREMENT = 1000;

-- 表2 用户信息表
ALTER TABLE tab_userInformation_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_userInformation_tab_userHeadImage_zch_hwz_gjc FOREIGN KEY (userHeadId_zch_hwz_gjc) REFERENCES tab_userHeadImage_zch_hwz_gjc (userImageId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_userInformation_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表3 头像表 
ALTER TABLE tab_userHeadImage_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_userHeadImage_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表6 金额表
ALTER TABLE tab_accountBalance_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_accountBalance_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表7附1 房屋信息表
ALTER TABLE tab_homeInformation_zch_hwz_gjc
    ADD CONSTRAINT FK_homeInformation_zch_hwz_gjc FOREIGN KEY (homeId_zch_hwz_gjc) REFERENCES tab_Home_zch_hwz_gjc (homeId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表8 维修保洁与维护信息表
ALTER TABLE tab_RCAMI_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_RCAMI_tab_Order_zch_hwz_gjc FOREIGN KEY (orderId_zch_hwz_gjc) REFERENCES tab_Order_zch_hwz_gjc (orderId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_RCAMI_zch_hwz_gjc_manager_zch_hwz_gjc foreign key (workUserId_zch_hwz_gjc) references tab_manager_zch_hwz_gjc (managerId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_RCAMI_tab_Home_zch_hwz_gjc FOREIGN KEY (homeId_zch_hwz_gjc) REFERENCES tab_Home_zch_hwz_gjc (homeId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_RCAMI_tab_user_zch_hwz_gjc_2 FOREIGN KEY (publisherId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_RCAMI_zch_hwz_gjc_manager_zch_hwz_gjc_2 foreign key (publisherId_zch_hwz_gjc) references tab_manager_zch_hwz_gjc (managerId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表9 用户统一通知表
ALTER TABLE tab_userNotification_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_userNotification_tab_manager_zch_hwz_gjc FOREIGN KEY (notifyPostManager_zch_hwz_gjc) REFERENCES tab_manager_zch_hwz_gjc (managerId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表10 优惠券表
ALTER TABLE tab_usersAndCoupons_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_UAC_tab_coupon_zch_hwz_gjc FOREIGN KEY (couponId_zch_hwz_gjc) REFERENCES tab_coupon_zch_hwz_gjc (couponId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_UAC_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表11 日志表
ALTER TABLE tab_log_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_log_tab_user_zch_hwz_gjc FOREIGN KEY (userPerformingId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_log_tab_manager_userPerformingId2_zch_hwz_gjc foreign key (userPerformingId_zch_hwz_gjc) references tab_manager_zch_hwz_gjc (managerId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表12 房屋评论表
ALTER TABLE tab_housingReview_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_housingReview_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_housingReview_tab_Home_zch_hwz_gjc FOREIGN KEY (homeId_zch_hwz_gjc) REFERENCES tab_Home_zch_hwz_gjc (homeId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_HR_zch_hwz_gjc_tab_HR_zch_hwz_gjc_reviewId_zch_hwz_gjc foreign key (secondHousingReviewId_zch_hwz_gjc) references tab_housingReview_zch_hwz_gjc (housingReviewId_zch_hwz_gjc) ON UPDATE CASCADE;

-- 表13 私信聊天记录
ALTER TABLE tab_myChat_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_myChat_tab_user_zch_hwz_gjc FOREIGN KEY (messageReceive_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_myChat_tab_user_zch_hwz_gjc_2 FOREIGN KEY (messageSender_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_myChat_tab_manager_messageReceive2_zch_hwz_gjc foreign key (messageReceive_zch_hwz_gjc) references tab_manager_zch_hwz_gjc (managerId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_myChat_tab_manager_messageSender2_zch_hwz_gjc foreign key (messageSender_zch_hwz_gjc) references tab_manager_zch_hwz_gjc (managerId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表15 景点评论表表
ALTER TABLE tab_attractionReview_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_attractionReview_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_attractionReview_tab_attractions_zch_hwz_gjc FOREIGN KEY (attractionsId_zch_hwz_gjc) REFERENCES tab_attractions_zch_hwz_gjc (attractionsId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_AR_zch_hwz_gjc_tab_AR_zch_hwz_gjc_reviewId_zch_hwz_gjc foreign key (secondAttractionReviewId_zch_hwz_gjc) references tab_attractionReview_zch_hwz_gjc (attractionReviewId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表16 房屋收藏表 
ALTER TABLE tab_houseCollection_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_houseCollection_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_houseCollection_tab_Home_zch_hwz_gjc FOREIGN KEY (homeId_zch_hwz_gjc) REFERENCES tab_Home_zch_hwz_gjc (homeId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表17 景点收藏表 
ALTER TABLE tab_attractionCollection_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_attractionCollection_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_attractionCollection_tab_attractions_zch_hwz_gjc FOREIGN KEY (attractionsId_zch_hwz_gjc) REFERENCES tab_attractions_zch_hwz_gjc (attractionsId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表18 订单表
ALTER TABLE tab_order_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_order_tab_Home_zch_hwz_gjc FOREIGN KEY (homeId_zch_hwz_gjc) REFERENCES tab_Home_zch_hwz_gjc (homeId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_order_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表21: 预约表
ALTER TABLE tab_carReservation_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_carReservation_tab_driverInfo_zch_hwz_gjc FOREIGN KEY (driverID_zch_hwz_gjc) REFERENCES tab_driverInfo_zch_hwz_gjc (driverID_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_carReservation_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_carReservation_tab_carInfo_zch_hwz_gjc FOREIGN KEY (carID_zch_hwz_gjc) REFERENCES tab_carInfo_zch_hwz_gjc (carID_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表22:行程记录表
ALTER TABLE tab_tripRecord_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_tripRecord_tab_carReservation_zch_hwz_gjc FOREIGN KEY (reservationID_zch_hwz_gjc) REFERENCES tab_carReservation_zch_hwz_gjc (reservationID_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表23: 房屋设备表
ALTER TABLE tab_homeDevice_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_homeDevice_tab_Home_zch_hwz_gjc FOREIGN KEY (homeID_zch_hwz_gjc) REFERENCES tab_Home_zch_hwz_gjc (homeID_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表24:设备状态表
ALTER TABLE tab_deviceStatus_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_deviceStatus_tab_homeDevice_zch_hwz_gjc FOREIGN KEY (deviceID_zch_hwz_gjc) REFERENCES tab_homeDevice_zch_hwz_gjc (deviceID_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表25: 设备控制记录表
ALTER TABLE tab_deviceControlRecord_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_deviceControlRecord_tab_user_zch_hwz_gjc FOREIGN KEY (userID_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userID_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_deviceControlRecord_tab_homeDevice_zch_hwz_gjc FOREIGN KEY (deviceID_zch_hwz_gjc) REFERENCES tab_homeDevice_zch_hwz_gjc (deviceID_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表27: 汽车订单表
ALTER TABLE tab_carOrder_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_carOrder_tab_user_zch_hwz_gjc FOREIGN KEY (userID_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userID_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_carOrder_tab_carInfo_zch_hwz_gjc FOREIGN KEY (carID_zch_hwz_gjc) REFERENCES tab_carInfo_zch_hwz_gjc (carID_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_carOrder_tab_driverInfo_zch_hwz_gjc FOREIGN KEY (driverID_zch_hwz_gjc) REFERENCES tab_driverInfo_zch_hwz_gjc (driverID_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_carOrder_tab_tripRecord_zch_hwz_gjc FOREIGN KEY (tripRecordID_zch_hwz_gjc) REFERENCES tab_tripRecord_zch_hwz_gjc (recordID_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表28: 支付密码表
ALTER TABLE tab_paymentPassword_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_paymentPassword_tab_accountBalance_zch_hwz_gjc FOREIGN KEY (accountID_zch_hwz_gjc) REFERENCES tab_accountBalance_zch_hwz_gjc (bid_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表29 房屋图片表
ALTER TABLE tab_homeImage_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_homeImage_tab_Home_zch_hwz_gjc FOREIGN KEY (homeId_zch_hwz_gjc) REFERENCES tab_Home_zch_hwz_gjc (homeId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表30 汽车使用情况表
ALTER TABLE tab_carUseStatus_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_carUseStatus_tab_carInfo_zch_hwz_gjc FOREIGN KEY (carID_zch_hwz_gjc) REFERENCES tab_carInfo_zch_hwz_gjc (carID_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表31 维修保洁绑定房屋表 
ALTER TABLE tab_managerHomeBinding_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_managerHomeBinding_tab_manager_zch_hwz_gjc FOREIGN KEY (managerID_zch_hwz_gjc) REFERENCES tab_manager_zch_hwz_gjc (managerID_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_managerHomeBinding_tab_Home_zch_hwz_gjc FOREIGN KEY (homeID_zch_hwz_gjc) REFERENCES tab_Home_zch_hwz_gjc (homeID_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表32 景点图片表
ALTER TABLE tab_attractionImage_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_attractionImage_tab_Home_zch_hwz_gjc FOREIGN KEY (attractionId_zch_hwz_gjc) REFERENCES tab_attractions_zch_hwz_gjc (attractionsId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表33 身份证记录表
ALTER TABLE tab_IDCardRecord_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_IDCardRecord_tab_user_zch_hwz_gjc FOREIGN KEY (userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc (userId_zch_hwz_gjc) ON UPDATE CASCADE;
-- 表34 身份信息对照表
ALTER TABLE tab_IdentityChecklist_zch_hwz_gjc
    ADD CONSTRAINT FK_tab_IdentityChecklist_tab_IDCardRecord_zch_hwz_gjc FOREIGN KEY (IDCardRecordID_zch_hwz_gjc) REFERENCES tab_IDCardRecord_zch_hwz_gjc (IDCardRecordID_zch_hwz_gjc) ON UPDATE CASCADE,
    ADD CONSTRAINT FK_tab_IdentityChecklist_tab_order_zch_hwz_gjc FOREIGN KEY (orderID_zch_hwz_gjc) REFERENCES tab_order_zch_hwz_gjc (orderID_zch_hwz_gjc) ON UPDATE CASCADE;
