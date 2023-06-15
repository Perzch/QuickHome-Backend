DROP DATABASE IF EXISTS QuickHome_zch_hwz_gjc;
CREATE DATABASE QuickHome_zch_hwz_gjc;
USE QuickHome_zch_hwz_gjc;

-- 表1 用户表(tab_user_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_user_zch_hwz_gjc;
CREATE TABLE tab_user_zch_hwz_gjc (
	userId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 用户编号
	userAccount_zch_hwz_gjc VARCHAR ( 50 ),-- 用户账户
	userName_zch_hwz_gjc VARCHAR ( 50 ),-- 用户名
	userPwd_zch_hwz_gjc VARCHAR ( 50 ),-- 用户密码
	userEmail_zch_hwz_gjc VARCHAR ( 100 ),-- 用户电子邮箱地址
	userPhone_zch_hwz_gjc VARCHAR ( 50 ),-- 用户手机号
	userInDate_zch_hwz_gjc DATETIME,-- 用户注册日期
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);
-- 表2 用户信息表
DROP TABLE IF EXISTS tab_userInformation_zch_hwz_gjc;
CREATE TABLE tab_userInformation_zch_hwz_gjc(
	UIId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 用户信息编号
	userId_zch_hwz_gjc BIGINT, -- 用户编号
	userGender_zch_hwz_gjc VARCHAR ( 50 ),--  用户性别
	userHeadId_zch_hwz_gjc BIGINT,-- 用户头像id
	userBirthday_zch_hwz_gjc DATETIME,-- 用户生日
	userSignature_zch_hwz_gjc VARCHAR ( 100 ),-- 个性签名
	idCardType_zch_hwz_gjc VARCHAR(10),   -- 证件类型(身份证)
	idCardNumber_zch_hwz_gjc VARCHAR(30), -- 证件号码
	authenticationStatus_zch_hwz_gjc VARCHAR(10), -- 实名认证状态(未认证/认证中/认证成功)
	authenticationTime_zch_hwz_gjc DATETIME,   -- 实名认证时间    
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);
-- 表3 头像表
DROP TABLE IF EXISTS tab_userHeadImage_zch_hwz_gjc;
CREATE TABLE tab_userHeadImage_zch_hwz_gjc(
	userImageId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 用户头像id
	userId_zch_hwz_gjc BIGINT,-- 用户编号
	imagePath_zch_hwz_gjc VARCHAR(300),-- 用户头像路径
	inDateTime_zch_hwz_gjc DATETIME,-- 写入时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);
-- 表4 超级管理员表
DROP TABLE IF EXISTS tab_superManager_zch_hwz_gjc;
CREATE TABLE tab_superManager_zch_hwz_gjc(
superManagerId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 超管id
superManagerAccount_zch_hwz_gjc varchar(50),-- 超管账号
superManagerPwd_zch_hwz_gjc VARCHAR(50),-- 超管密码
createTime_zch_hwz_gjc DATETIME, -- 超级管理员账号创建时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);
-- 表5 管理员表
DROP TABLE IF EXISTS tab_manager_zch_hwz_gjc;
CREATE TABLE tab_manager_zch_hwz_gjc(
managerId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 管理员id
administratorCategory_zch_hwz_gjc VARCHAR(50), -- 管理员类别
managerAccount_zch_hwz_gjc VARCHAR(50), -- 管理员账号
managerPwd_zch_hwz_gjc VARCHAR(50), -- 管理员密码
managerName_zch_hwz_gjc VARCHAR(50), -- 管理员名
managerPhone_zch_hwz_gjc VARCHAR(50), -- 管理员电话
managerGender_zch_hwz_gjc VARCHAR(10), -- 管理员性别
managerInDate_zch_hwz_gjc DATETIME, -- 注册日期
	standby1_zch_hwz_gjc VARCHAR(50), -- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50), -- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50), -- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);
-- 表6 金额表
DROP TABLE IF EXISTS tab_accountBalance_zch_hwz_gjc;
CREATE TABLE tab_accountBalance_zch_hwz_gjc(
	bid_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 金额表id
	userId_zch_hwz_gjc BIGINT,-- 对应用户id
	userBalance_zch_hwz_gjc DOUBLE,-- 用户账户余额
	userDeposit_zch_hwz_gjc DOUBLE,-- 用户账户押金
	lastModifiedDate_zch_hwz_gjc DATETIME,-- 上次修改日期
	openTime_zch_hwz_gjc DATETIME, -- 开户时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- -- 表26: 账户表
-- CREATE TABLE tab_account_zch_hwz_gjc(
-- accountID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT,  -- 账号编号
-- userID_zch_hwz_gjc BIGINT,  -- 用户编号
-- accountName_zch_hwz_gjc VARCHAR(50),   -- 账户名称 
-- accountNumber_zch_hwz_gjc VARCHAR(50), -- 账号
-- accountBalance_zch_hwz_gjc DECIMAL(10,2), -- 账号余额
-- 	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
-- 	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
-- 	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
-- 	visible_zch_hwz_gjc int -- 可见性
-- );
-- 
-- 表7 房屋信息表(tab_Home_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_homeInformation_zch_hwz_gjc;
CREATE TABLE tab_homeInformation_zch_hwz_gjc (
	homeId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 房屋信息编号
	homeName_zch_hwz_gjc VARCHAR ( 50 ),-- 房屋名
	homeType_zch_hwz_gjc VARCHAR ( 50 ),-- 房屋类型 大床房 电竞房
	homeArea_zch_hwz_gjc FLOAT,-- 房屋面积
	homeDescribe_zch_hwz_gjc VARCHAR ( 50 ),-- 房屋描述 室 厅 卫
	maxPerson_zch_hwz_gjc INT,-- 最大入住人数
	homeFacilities_zch_hwz_gjc VARCHAR ( 100 ),-- 房屋自带设施
	homeDayRent_zch_hwz_gjc DOUBLE,-- 单日租金
	homeDeposit_zch_hwz_gjc DOUBLE,-- 所需押金
	homeState_zch_hwz_gjc VARCHAR ( 50 ),-- 房屋状态 就绪/打扫中/已入住
	homeAddress_zch_hwz_gjc VARCHAR(500),-- 房屋地址
	homeInDate_zch_hwz_gjc DATETIME, -- 房屋注册日期
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表8 维修保洁与维护信息表(tab_repairCleaningAndMaintenanceInformation_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_RCAMI_zch_hwz_gjc;
CREATE TABLE tab_RCAMI_zch_hwz_gjc (
	workItemId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 工作项目编号
	informationCreatTime_zch_hwz_gjc DATETIME,-- 信息创建时间
	completionProcessTime_zch_hwz_gjc DATETIME,-- 完成处理时间
	RCAMIInformation_zch_hwz_gjc VARCHAR ( 50 ),-- 信息内容
	des_zch_hwz_gjc VARCHAR ( 50 ),-- 备注
	workUserId_zch_hwz_gjc BIGINT,-- 维修管理员编号
	completion_zch_hwz_gjc VARCHAR ( 50 ),-- 完成情况
	publisherId_zch_hwz_gjc BIGINT,-- 发布人员编号
	homeId_zch_hwz_gjc BIGINT, -- 房屋信息编号
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表9 用户统一通知表(tab_userNotification_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_userNotification_zch_hwz_gjc;
CREATE TABLE tab_userNotification_zch_hwz_gjc ( 
	userNotificationId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment, -- 用户通知编号
	notificationReleaseTime_zch_hwz_gjc DATETIME, -- 通知发布时间
	notifyPostManager_zch_hwz_gjc BIGINT, -- 通知发布管理员编号
	notificationContent_zch_hwz_gjc VARCHAR ( 500 ), -- 通知内容
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表10 优惠券表(tab_coupon_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_coupon_zch_hwz_gjc;
CREATE TABLE tab_coupon_zch_hwz_gjc (
	couponId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 优惠券编号
	couponName_zch_hwz_gjc VARCHAR ( 50 ),-- 优惠券名称
	discountMethod_zch_hwz_gjc VARCHAR ( 50 ),-- 优惠方式(折扣，直减)
	discountIntensity_zch_hwz_gjc DOUBLE, -- 优惠力度(5折或者5元)
	useThreshold_zch_hwz_gjc DOUBLE, -- 使用门槛(满多少才能用)
	applicableScope_zch_hwz_gjc VARCHAR ( 50 ),-- 适用范围(民俗或打车)
	discountInformation_zch_hwz_gjc VARCHAR ( 50 ),-- 优惠信息
	earliestUseTime_zch_hwz_gjc DATETIME,-- 最早使用时间
	latestUseTime_zch_hwz_gjc DATETIME,-- 最晚使用时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);
-- 附表1 优惠用户详情表
DROP TABLE IF EXISTS tab_usersAndCoupons_zch_hwz_gjc;
CREATE TABLE tab_usersAndCoupons_zch_hwz_gjc(
	UACID_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 优惠用户详情编号
	condition_zch_hwz_gjc VARCHAR ( 50 ),-- 使用状况
	userId_zch_hwz_gjc BIGINT, -- 用户编号
	couponId_zch_hwz_gjc BIGINT,-- 优惠券编号
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表11 日志表(tab_log_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_log_zch_hwz_gjc;
CREATE TABLE tab_log_zch_hwz_gjc (
	logId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 日志编号
	userPerformingId_zch_hwz_gjc BIGINT,-- 执行操作的用户编号
	executionTime_zch_hwz_gjc DATETIME,-- 执行时间
	executionContent_zch_hwz_gjc VARCHAR ( 100 ),-- 执行内容
	deviceId_zch_hwz_gjc VARCHAR ( 50 ),-- 用户执行操作的设备编号
	executionPlace_zch_hwz_gjc VARCHAR ( 100 ), -- 用户执行操作的地点
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表12 房屋评论表(tab_housingReview_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_housingReview_zch_hwz_gjc;
CREATE TABLE tab_housingReview_zch_hwz_gjc (
	housingReviewId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 房屋评论编号
	comments_zch_hwz_gjc VARCHAR ( 500 ),-- 评论内容
	userId_zch_hwz_gjc BIGINT,-- 用户编号
	homeId_zch_hwz_gjc BIGINT,-- 房屋信息编号
	reviewTime_zch_hwz_gjc DATETIME,-- 评论时间
	housingReviewRating_zch_hwz_gjc INT, -- 评论等级
	homeLikeCount_zch_hwz_gjc int, -- 点赞数
	secondHousingReviewId_zch_hwz_gjc BIGINT,-- 第二房屋评论编号
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);


-- 表13 私信聊天记录
DROP TABLE IF EXISTS tab_myChat_zch_hwz_gjc;
CREATE TABLE tab_myChat_zch_hwz_gjc(
chatId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 聊天id
messageReceive_zch_hwz_gjc BIGINT,-- 消息接收人编号
messageContent_zch_hwz_gjc VARCHAR(500),-- 消息内容
messageSender_zch_hwz_gjc BIGINT,-- 消息发送人编号
conversationDialogId_zch_hwz_gjc BIGINT,-- 对话框编号
sendingTime_zch_hwz_gjc DATETIME,-- 发送时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表14 景点表(tab_attractions_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_attractions_zch_hwz_gjc;
CREATE TABLE tab_attractions_zch_hwz_gjc (
	attractionsId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 景点编号
	attractionsName_zch_hwz_gjc VARCHAR ( 50 ),-- 景点名
	attractionInformation_zch_hwz_gjc VARCHAR ( 500 ),-- 景点信息
	openingTime_zch_hwz_gjc DATETIME,-- 景点开放时间
	closingTime_zch_hwz_gjc DATETIME,-- 景点关闭时间
	attractionInDate_zch_hwz_gjc DATETIME, -- 信息录入时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表15 景点评论表表(tab_attractionReview_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_attractionReview_zch_hwz_gjc;
CREATE TABLE tab_attractionReview_zch_hwz_gjc (
	attractionReviewId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 第一评论编号
	comments_zch_hwz_gjc VARCHAR ( 500 ),-- 评论内容
	userId_zch_hwz_gjc BIGINT,-- 用户编号
	attractionsId_zch_hwz_gjc BIGINT,-- 景点编号
	reviewTime_zch_hwz_gjc DATETIME,-- 评论时间
	attractionLikeCount_zch_hwz_gjc INT,-- 点赞数
	attractionReviewRating_zch_hwz_gjc INT, -- 评论等级
	secondAttractionReviewId_zch_hwz_gjc BIGINT,-- 第二评论编号
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表16 房屋收藏表
DROP TABLE IF EXISTS tab_houseCollection_zch_hwz_gjc;
CREATE TABLE tab_houseCollection_zch_hwz_gjc (
	hFavoriteRecordsId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 收藏记录编号
	userId_zch_hwz_gjc BIGINT,-- 用户编号
	homeId_zch_hwz_gjc BIGINT,-- 房屋信息编号
	collectionTime_zch_hwz_gjc DATETIME,-- 收藏时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);
-- 表17 景点收藏表
DROP TABLE IF EXISTS tab_attractionCollection_zch_hwz_gjc;
CREATE TABLE tab_attractionCollection_zch_hwz_gjc (
	aFavoriteRecordsId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 收藏记录编号
	userId_zch_hwz_gjc BIGINT,-- 用户编号
	attractionsId_zch_hwz_gjc BIGINT,-- 景点编号
	collectionTime_zch_hwz_gjc DATETIME,-- 收藏时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表18 订单表(tab_order_zch_hwz_gjc)
DROP TABLE IF EXISTS tab_order_zch_hwz_gjc;
CREATE TABLE tab_order_zch_hwz_gjc (
	orderId_zch_hwz_gjc BIGINT ( 20 ) PRIMARY KEY auto_increment,-- 订单编号
	homeId_zch_hwz_gjc BIGINT,-- 房屋信息编号
	DynamicDoorPassword_zch_hwz_gjc VARCHAR ( 50 ), -- 房间动态密码
	creationTime_zch_hwz_gjc DATETIME,-- 订单创建时间
	endTime_zch_hwz_gjc DATETIME,-- 订单结束时间
	checkInTime_zch_hwz_gjc DATETIME,-- 入住时间
	checkOutTime_zch_hwz_gjc DATETIME,-- 退房时间
	orderPayment_zch_hwz_gjc DOUBLE,-- 实际缴费
	orderDeposit_zch_hwz_gjc DOUBLE,-- 具体押金
	maintainStatus_zch_hwz_gjc VARCHAR ( 50 ),-- 维护信息状态
	orderState_zch_hwz_gjc VARCHAR ( 50 ), -- 订单状态
	userId_zch_hwz_gjc BIGINT,-- 用户编号
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表19: 司机信息表 
DROP TABLE IF EXISTS tab_driverInfo_zch_hwz_gjc;
CREATE TABLE tab_driverInfo_zch_hwz_gjc (
driverID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT, -- 司机编号
driverName_zch_hwz_gjc VARCHAR(50),   -- 司机姓名
contactPhoneNumber_zch_hwz_gjc VARCHAR(50),-- 司机联系电话
idNumber_zch_hwz_gjc VARCHAR(50),      -- 司机身份证号码
licenseNumber_zch_hwz_gjc VARCHAR(50),      -- 司机驾驶证号码
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
); 

-- 表20: 汽车信息表
DROP TABLE IF EXISTS tab_carInfo_zch_hwz_gjc;
CREATE TABLE tab_carInfo_zch_hwz_gjc (
	carID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT, -- 汽车编号
	brand_zch_hwz_gjc VARCHAR(50), -- 汽车品牌
	model_zch_hwz_gjc VARCHAR(50), -- 汽车型号
	licensePlateNumber_zch_hwz_gjc VARCHAR(50),   -- 汽车车牌号码
	carColor_zch_hwz_gjc VARCHAR(50),   -- 汽车颜色
	entryTime_zch_hwz_gjc VARCHAR(50), -- 汽车录入时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表21: 预约表 
DROP TABLE IF EXISTS tab_carReservation_zch_hwz_gjc;
CREATE TABLE tab_carReservation_zch_hwz_gjc (
reservationID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT, -- 预约编号
driverID_zch_hwz_gjc BIGINT,  -- 外键,关联司机信息表 
userId_zch_hwz_gjc BIGINT, -- 外键,关联用户信息表
carID_zch_hwz_gjc BIGINT,   -- 外键,关联汽车信息表
carReservationTime_zch_hwz_gjc DATETIME,   -- 客户预约时间
reservationStatus_zch_hwz_gjc VARCHAR(10),   -- 预约状态:已预约/已完成/已取消
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表22:行程记录表
DROP TABLE IF EXISTS tab_tripRecord_zch_hwz_gjc;
CREATE TABLE tab_tripRecord_zch_hwz_gjc(
recordID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT,-- 记录编号
reservationID_zch_hwz_gjc BIGINT, -- 外键,关联预约表
startingPoint_zch_hwz_gjc VARCHAR(50),   -- 起点
destination_zch_hwz_gjc VARCHAR(50),   -- 终点
startingTime_zch_hwz_gjc DATETIME,  -- 出发时间 
endTime_zch_hwz_gjc DATETIME,   -- 到达时间
distanceTraveled_zch_hwz_gjc DOUBLE,   -- 此次行程公里数 
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表23: 智能设备表
DROP TABLE IF EXISTS tab_smartDevice_zch_hwz_gjc;
CREATE TABLE tab_smartDevice_zch_hwz_gjc(
deviceID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT, -- 设备编号
homeId_zch_hwz_gjc BIGINT,-- 房屋信息编号
deviceName_zch_hwz_gjc VARCHAR(50),-- 设备名称
deviceType_zch_hwz_gjc VARCHAR(20), -- 设备类型(灯/空调/电视等)
brand_zch_hwz_gjc VARCHAR(50), -- 品牌
price_zch_hwz_gjc DECIMAL(10,2), -- 价格
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表24:设备状态表
DROP TABLE IF EXISTS tab_deviceStatus_zch_hwz_gjc;
CREATE TABLE tab_deviceStatus_zch_hwz_gjc(
statusID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT, -- 状态编号
deviceID_zch_hwz_gjc BIGINT,   -- 外键,关联智能设备表
deviceStatus_zch_hwz_gjc VARCHAR(20), -- 设备状态(开启/关闭/待机等)
updateTime_zch_hwz_gjc DATETIME, -- 状态更新时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
); 

-- 表25: 设备控制记录表
CREATE TABLE tab_deviceControlRecord_zch_hwz_gjc ( 
recordID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT, -- 记录编号 
userID_zch_hwz_gjc BIGINT,   -- 外键,用户编号
deviceID_zch_hwz_gjc BIGINT, -- 外键,关联智能设备表
controlTime_zch_hwz_gjc DATETIME, -- 控制时间 
controlType_zch_hwz_gjc VARCHAR(20),   -- 控制类型(开/关/调高/调低等) 
controlContent_zch_hwz_gjc VARCHAR(50), -- 控制具体内容 
deviceReservationTime_zch_hwz_gjc DATETIME, -- 预约控制时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);


-- 表27: 汽车订单表
DROP TABLE IF EXISTS tab_carOrder_zch_hwz_gjc;
CREATE TABLE tab_carOrder_zch_hwz_gjc(
orderID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT,   -- 订单编号 
userID_zch_hwz_gjc BIGINT,  -- 用户编号,外键关联用户表 
carID_zch_hwz_gjc BIGINT,   -- 汽车编号,外键关联汽车表
driverID_zch_hwz_gjc BIGINT, -- 司机编号,外键关联司机表
orderTime_zch_hwz_gjc DATETIME, -- 订单下单时间
orderStatus_zch_hwz_gjc VARCHAR(20), -- 订单状态(已预约/已完成/已取消) 
orderAmount_zch_hwz_gjc DECIMAL(10,2), -- 订单总金额 
tripRecordID_zch_hwz_gjc BIGINT,   -- 行程记录编号,外键关联行程记录表 
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);


-- 表28: 支付密码表
DROP TABLE IF EXISTS tab_paymentPassword_zch_hwz_gjc;
CREATE TABLE tab_paymentPassword_zch_hwz_gjc(
passwordID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT, -- 支付密码编号
accountID_zch_hwz_gjc BIGINT,  -- 账号编号,外键关联账户表
paymentPassword_zch_hwz_gjc VARCHAR(6), -- 支付密码
setTime_zch_hwz_gjc DATETIME,   -- 设置支付密码时间   
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表29 房屋图片表
DROP TABLE IF EXISTS tab_homeImage_zch_hwz_gjc;
CREATE TABLE tab_homeImage_zch_hwz_gjc (
	imageId_zch_hwz_gjc BIGINT PRIMARY KEY auto_increment,-- 图片编号
	homeId_zch_hwz_gjc BIGINT, -- 房屋信息编号
	imagePath_zch_hwz_gjc VARCHAR(300),-- 图片路径
	inDateTime_zch_hwz_gjc DATETIME,-- 写入时间
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表30 汽车使用情况表
DROP TABLE IF EXISTS tab_carUseStatus_zch_hwz_gjc;
CREATE TABLE tab_carUseStatus_zch_hwz_gjc(
useStatusID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT,-- 使用情况编号
carID_zch_hwz_gjc BIGINT,-- 汽车编号,外键关联汽车信息表
useDate_zch_hwz_gjc DATE,-- 使用日期
useStatus_zch_hwz_gjc VARCHAR(20),-- 使用状态(使用中/闲置/维修等)
mileage_zch_hwz_gjc INT,-- 公里数
 oilVolume_zch_hwz_gjc INT,-- 油箱油量
tireSituation_zch_hwz_gjc VARCHAR(100),-- 轮胎情况
otherMaintenance_zch_hwz_gjc VARCHAR(200),-- 其他维护保养
nextInspectionTime_zch_hwz_gjc DATE,-- 下次维修时间
inspectRemark_zch_hwz_gjc VARCHAR(200),-- 维修备注
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表31 维修保洁绑定房屋表
DROP TABLE IF EXISTS tab_adminHomeBinding_zch_hwz_gjc;
CREATE TABLE tab_adminHomeBinding_zch_hwz_gjc(
bindingID_zch_hwz_gjc BIGINT PRIMARY KEY AUTO_INCREMENT,-- 绑定编号
managerID_zch_hwz_gjc BIGINT,-- 管理员编号,外键关联管理员表
homeID_zch_hwz_gjc BIGINT,-- 房屋编号,外键关联房屋信息表
bindingType_zch_hwz_gjc VARCHAR(20),-- 绑定类型(保洁/维修)
bindingTime_zch_hwz_gjc DATETIME,-- 绑定时间
bindingState_zch_hwz_gjc VARCHAR(20), -- 绑定状态(绑定中/解绑)
	standby1_zch_hwz_gjc VARCHAR(50),-- 备用字段1
	standby2_zch_hwz_gjc VARCHAR(50),-- 备用字段2
	standby3_zch_hwz_gjc VARCHAR(50),-- 备用字段3
	visible_zch_hwz_gjc int -- 可见性
);

-- 表2 用户信息表
ALTER TABLE tab_userInformation_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_userInformation_tab_userHeadImage_zch_hwz_gjc FOREIGN KEY(userHeadId_zch_hwz_gjc) REFERENCES tab_userHeadImage_zch_hwz_gjc(userImageId_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_userInformation_tab_user_zch_hwz_gjc FOREIGN KEY(userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc);
-- 表3 头像表 
ALTER TABLE tab_userHeadImage_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_userHeadImage_tab_user_zch_hwz_gjc FOREIGN KEY(userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc);
-- 表6 金额表
ALTER TABLE tab_accountBalance_zch_hwz_gjc
ADD CONSTRAINT FK_tab_accountBalance_tab_user_zch_hwz_gjc FOREIGN KEY(userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc);
-- 表8 维修保洁与维护信息表
ALTER TABLE tab_RCAMI_zch_hwz_gjc
add CONSTRAINT FK_tab_RCAMI_zch_hwz_gjc_manager_zch_hwz_gjc foreign key(workUserId_zch_hwz_gjc) references tab_manager_zch_hwz_gjc(managerId_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_RCAMI_tab_homeInformation_zch_hwz_gjc FOREIGN KEY(homeId_zch_hwz_gjc) REFERENCES tab_homeInformation_zch_hwz_gjc(homeId_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_RCAMI_tab_user_zch_hwz_gjc_2 FOREIGN KEY(publisherId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc),
add CONSTRAINT FK_tab_RCAMI_zch_hwz_gjc_manager_zch_hwz_gjc_2 foreign key(publisherId_zch_hwz_gjc) references tab_manager_zch_hwz_gjc(managerId_zch_hwz_gjc);
-- 表9 用户统一通知表
ALTER TABLE tab_userNotification_zch_hwz_gjc
ADD CONSTRAINT FK_tab_userNotification_tab_manager_zch_hwz_gjc FOREIGN KEY(notifyPostManager_zch_hwz_gjc) REFERENCES tab_manager_zch_hwz_gjc(managerId_zch_hwz_gjc);
-- 表10 优惠券表
ALTER TABLE tab_usersAndCoupons_zch_hwz_gjc
ADD CONSTRAINT FK_tab_UAC_tab_coupon_zch_hwz_gjc FOREIGN KEY(couponId_zch_hwz_gjc) REFERENCES tab_coupon_zch_hwz_gjc(couponId_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_UAC_tab_user_zch_hwz_gjc FOREIGN KEY(userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc);
-- 表11 日志表
ALTER TABLE tab_log_zch_hwz_gjc
ADD CONSTRAINT FK_tab_log_tab_user_zch_hwz_gjc FOREIGN KEY(userPerformingId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc),
add CONSTRAINT FK_tab_log_tab_manager_userPerformingId2_zch_hwz_gjc foreign key(userPerformingId_zch_hwz_gjc) references tab_manager_zch_hwz_gjc(managerId_zch_hwz_gjc);
-- 表12 房屋评论表
ALTER TABLE tab_housingReview_zch_hwz_gjc
ADD CONSTRAINT FK_tab_housingReview_tab_user_zch_hwz_gjc FOREIGN KEY(userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_housingReview_tab_homeInformation_zch_hwz_gjc FOREIGN KEY(homeId_zch_hwz_gjc) REFERENCES tab_homeInformation_zch_hwz_gjc(homeId_zch_hwz_gjc),
add CONSTRAINT FK_tab_HR_zch_hwz_gjc_tab_HR_zch_hwz_gjc_reviewId_zch_hwz_gjc foreign key(secondHousingReviewId_zch_hwz_gjc) references tab_housingReview_zch_hwz_gjc(housingReviewId_zch_hwz_gjc);

-- 表13 私信聊天记录
ALTER TABLE tab_myChat_zch_hwz_gjc
ADD CONSTRAINT FK_tab_myChat_tab_user_zch_hwz_gjc FOREIGN KEY(messageReceive_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_myChat_tab_user_zch_hwz_gjc_2 FOREIGN KEY(messageSender_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc),
add CONSTRAINT FK_tab_myChat_tab_admin_messageReceive2_zch_hwz_gjc foreign key(messageReceive_zch_hwz_gjc) references tab_manager_zch_hwz_gjc(managerId_zch_hwz_gjc),
add CONSTRAINT FK_tab_myChat_tab_admin_messageSender2_zch_hwz_gjc foreign key(messageSender_zch_hwz_gjc) references tab_manager_zch_hwz_gjc(managerId_zch_hwz_gjc);
-- 表15 景点评论表表
ALTER TABLE tab_attractionReview_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_attractionReview_tab_user_zch_hwz_gjc FOREIGN KEY(userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_attractionReview_tab_attractions_zch_hwz_gjc FOREIGN KEY(attractionsId_zch_hwz_gjc) REFERENCES tab_attractions_zch_hwz_gjc(attractionsId_zch_hwz_gjc),
add CONSTRAINT FK_tab_AR_zch_hwz_gjc_tab_AR_zch_hwz_gjc_reviewId_zch_hwz_gjc foreign key(secondAttractionReviewId_zch_hwz_gjc) references tab_attractionReview_zch_hwz_gjc(attractionReviewId_zch_hwz_gjc);
-- 表16 房屋收藏表 
ALTER TABLE tab_houseCollection_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_houseCollection_tab_user_zch_hwz_gjc FOREIGN KEY(userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_houseCollection_tab_homeInformation_zch_hwz_gjc FOREIGN KEY(homeId_zch_hwz_gjc) REFERENCES tab_homeInformation_zch_hwz_gjc(homeId_zch_hwz_gjc);
-- 表17 景点收藏表 
ALTER TABLE tab_attractionCollection_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_attractionCollection_tab_user_zch_hwz_gjc FOREIGN KEY(userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_attractionCollection_tab_attractions_zch_hwz_gjc FOREIGN KEY(attractionsId_zch_hwz_gjc) REFERENCES tab_attractions_zch_hwz_gjc(attractionsId_zch_hwz_gjc); 
-- 表18 订单表
ALTER TABLE tab_order_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_order_tab_homeInformation_zch_hwz_gjc FOREIGN KEY(homeId_zch_hwz_gjc) REFERENCES tab_homeInformation_zch_hwz_gjc(homeId_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_order_tab_user_zch_hwz_gjc FOREIGN KEY(userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc);  
-- 表21: 预约表
ALTER TABLE tab_carReservation_zch_hwz_gjc
ADD CONSTRAINT FK_tab_carReservation_tab_driverInfo_zch_hwz_gjc FOREIGN KEY(driverID_zch_hwz_gjc) REFERENCES tab_driverInfo_zch_hwz_gjc(driverID_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_carReservation_tab_user_zch_hwz_gjc  FOREIGN KEY(userId_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userId_zch_hwz_gjc), 
ADD CONSTRAINT FK_tab_carReservation_tab_carInfo_zch_hwz_gjc FOREIGN KEY(carID_zch_hwz_gjc) REFERENCES tab_carInfo_zch_hwz_gjc(carID_zch_hwz_gjc);
-- 表22:行程记录表
ALTER TABLE tab_tripRecord_zch_hwz_gjc
ADD CONSTRAINT FK_tab_tripRecord_tab_carReservation_zch_hwz_gjc FOREIGN KEY(reservationID_zch_hwz_gjc) REFERENCES tab_carReservation_zch_hwz_gjc(reservationID_zch_hwz_gjc);
-- 表23: 智能设备表 
ALTER TABLE tab_smartDevice_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_smartDevice_tab_homeInformation_zch_hwz_gjc FOREIGN KEY(homeID_zch_hwz_gjc) REFERENCES tab_homeInformation_zch_hwz_gjc(homeID_zch_hwz_gjc); 
-- 表24:设备状态表
ALTER TABLE tab_deviceStatus_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_deviceStatus_tab_smartDevice_zch_hwz_gjc FOREIGN KEY(deviceID_zch_hwz_gjc) REFERENCES tab_smartDevice_zch_hwz_gjc(deviceID_zch_hwz_gjc);
-- 表25: 设备控制记录表
ALTER TABLE tab_deviceControlRecord_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_deviceControlRecord_tab_user_zch_hwz_gjc FOREIGN KEY(userID_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userID_zch_hwz_gjc), 
ADD CONSTRAINT FK_tab_deviceControlRecord_tab_smartDevice_zch_hwz_gjc FOREIGN KEY(deviceID_zch_hwz_gjc) REFERENCES tab_smartDevice_zch_hwz_gjc(deviceID_zch_hwz_gjc);
-- -- 表26: 账户表
-- ALTER TABLE tab_account_zch_hwz_gjc
-- ADD CONSTRAINT FK_tab_account_tab_user_zch_hwz_gjc FOREIGN KEY(userID_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userID_zch_hwz_gjc);
-- 表27: 汽车订单表
ALTER TABLE tab_carOrder_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_carOrder_tab_user_zch_hwz_gjc FOREIGN KEY(userID_zch_hwz_gjc) REFERENCES tab_user_zch_hwz_gjc(userID_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_carOrder_tab_carInfo_zch_hwz_gjc FOREIGN KEY(carID_zch_hwz_gjc) REFERENCES tab_carInfo_zch_hwz_gjc(carID_zch_hwz_gjc), 
ADD CONSTRAINT FK_tab_carOrder_tab_driverInfo_zch_hwz_gjc FOREIGN KEY(driverID_zch_hwz_gjc) REFERENCES tab_driverInfo_zch_hwz_gjc(driverID_zch_hwz_gjc),
ADD CONSTRAINT FK_tab_carOrder_tab_tripRecord_zch_hwz_gjc FOREIGN KEY(tripRecordID_zch_hwz_gjc) REFERENCES tab_tripRecord_zch_hwz_gjc(recordID_zch_hwz_gjc);
-- 表28: 支付密码表
ALTER TABLE tab_paymentPassword_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_paymentPassword_tab_accountBalance_zch_hwz_gjc FOREIGN KEY(accountID_zch_hwz_gjc) REFERENCES tab_accountBalance_zch_hwz_gjc(bid_zch_hwz_gjc);
-- 表29 房屋图片表
ALTER TABLE tab_homeImage_zch_hwz_gjc
ADD CONSTRAINT FK_tab_homeImage_tab_homeInformation_zch_hwz_gjc FOREIGN KEY(homeId_zch_hwz_gjc) REFERENCES tab_homeInformation_zch_hwz_gjc(homeId_zch_hwz_gjc);  
-- 表30 汽车使用情况表
ALTER TABLE tab_carUseStatus_zch_hwz_gjc 
ADD CONSTRAINT FK_tab_carUseStatus_tab_carInfo_zch_hwz_gjc FOREIGN KEY(carID_zch_hwz_gjc) REFERENCES tab_carInfo_zch_hwz_gjc(carID_zch_hwz_gjc);
-- 表31 维修保洁绑定房屋表 
ALTER TABLE tab_adminHomeBinding_zch_hwz_gjc
ADD CONSTRAINT FK_tab_adminHomeBinding_tab_manager_zch_hwz_gjc FOREIGN KEY(managerID_zch_hwz_gjc) REFERENCES tab_manager_zch_hwz_gjc(managerID_zch_hwz_gjc), 
ADD CONSTRAINT FK_tab_adminHomeBinding_tab_homeInformation_zch_hwz_gjc  FOREIGN KEY(homeID_zch_hwz_gjc) REFERENCES tab_homeInformation_zch_hwz_gjc(homeID_zch_hwz_gjc);