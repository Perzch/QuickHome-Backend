
-- 用户表
INSERT INTO tab_user_zch_hwz_gjc (userAccount_zch_hwz_gjc, userName_zch_hwz_gjc, userPwd_zch_hwz_gjc, userEmail_zch_hwz_gjc, userPhone_zch_hwz_gjc, userInDate_zch_hwz_gjc)
VALUES
    ('user1', '张三', '123456', 'zhangsan@163.com', '13811111111', '2023-01-01 12:00:00'),
    ('user2', '李四', '123456', 'lisi@163.com', '13811111112', '2023-02-01 12:00:00'),
    ('user3', '王五', '123456', 'wangwu@163.com', '13811111113', '2023-03-01 12:00:00'),
    ('user4', '赵六', '123456', 'zhaoliu@163.com', '13811111114', '2023-04-01 12:00:00'),
    ('user5', '田七', '123456', 'tianqi@163.com', '13811111115', '2023-05-01 12:00:00');

-- 头像表
INSERT INTO tab_userHeadImage_zch_hwz_gjc (userId_zch_hwz_gjc, imagePath_zch_hwz_gjc, inDateTime_zch_hwz_gjc)
VALUES
    (1000, '/image1.jpg', '2023-01-03 12:00:00'),
    (1001, '/image2.jpg', '2023-02-03 12:00:00'),
    (1002, '/image3.jpg', '2023-03-03 12:00:00'),
    (1003, '/image4.jpg', '2023-04-03 12:00:00'),
    (1004, '/image5.jpg', '2023-05-03 12:00:00');

-- 用户信息表

INSERT INTO tab_userInformation_zch_hwz_gjc (userId_zch_hwz_gjc, userGender_zch_hwz_gjc, userHeadId_zch_hwz_gjc, userBirthday_zch_hwz_gjc, userSignature_zch_hwz_gjc, idCardType_zch_hwz_gjc, idCardNumber_zch_hwz_gjc, authenticationStatus_zch_hwz_gjc, authenticationTime_zch_hwz_gjc)
VALUES
    (1000, '男', 1, '1990-01-01', '一个开心的人', '身份证', '123456789012345678', '未认证', '2023-01-02 12:00:00'),
    (1001, '女', 2, '1991-02-01', '一个快乐的人', '身份证', '123456789012345677', '已认证', '2023-02-02 12:00:00'),
    (1002, '男', 3, '1992-03-01', '一个幸福的人', '身份证', '123456789012345676', '已认证', '2023-03-02 12:00:00'),
    (1003, '女', 4, '1993-04-01', '一个温暖的人', '身份证', '123456789012345675', '已认证', '2023-04-02 12:00:00'),
    (1004, '男', 5, '1994-05-01', '一个真诚的人', '身份证', '123456789012345674', '已认证', '2023-05-02 12:00:00');

-- 超级管理员表
INSERT INTO tab_superManager_zch_hwz_gjc (superManagerAccount_zch_hwz_gjc, superManagerPwd_zch_hwz_gjc, createTime_zch_hwz_gjc)

VALUES
    ('admin1', '123456', '2023-01-04 12:00:00'),
    ('admin2', '123456', '2023-02-04 12:00:00'),
    ('admin3', '123456', '2023-03-04 12:00:00'),
    ('admin4', '123456', '2023-04-04 12:00:00'),
    ('admin5', '123456', '2023-05-04 12:00:00');

-- 管理员表

INSERT INTO tab_manager_zch_hwz_gjc (managerCategory_zch_hwz_gjc, managerAccount_zch_hwz_gjc, managerPwd_zch_hwz_gjc, managerName_zch_hwz_gjc, managerPhone_zch_hwz_gjc, managerGender_zch_hwz_gjc, managerInDate_zch_hwz_gjc)
VALUES
    ('普通管理员', 'manager1', '123456', '小明', '13611111111', '男', '2023-01-05 12:00:00'),
    ('普通管理员', 'manager2', '123456', '小红', '13611111112', '女', '2023-02-05 12:00:00'),
    ('普通管理员', 'manager3', '123456', '小张', '13611111113', '男', '2023-03-05 12:00:00'),
    ('普通管理员', 'manager4', '123456', '小李', '13611111114', '女', '2023-04-05 12:00:00'),
    ('普通管理员', 'manager5', '123456', '小王', '13611111115', '男', '2023-05-05 12:00:00');

-- 金额表
INSERT INTO tab_accountBalance_zch_hwz_gjc (userId_zch_hwz_gjc, userBalance_zch_hwz_gjc, openTime_zch_hwz_gjc)
VALUES
    (1000, 0, '2023-01-06 12:00:00'),
    (1001, 0, '2023-02-06 12:00:00'),
    (1002, 0, '2023-03-06 12:00:00'),
    (1003, 4000, '2023-04-06 12:00:00'),
    (1004, 5000, '2023-05-06 12:00:00');

-- 房屋表
INSERT INTO tab_Home_zch_hwz_gjc (homeName_zch_hwz_gjc, homeType_zch_hwz_gjc, homeDayRent_zch_hwz_gjc, homeState_zch_hwz_gjc, homeAddress_zch_hwz_gjc)
VALUES
    ('一居室', '整租', 50, '可入住', '北京市海淀区XX小区'),
    ('两居室', '整租', 80, '可入住', '北京市朝阳区XX小区'),
    ('三居室', '整租', 100, '可入住', '北京市丰台区XX小区'),
    ('四居室', '整租', 120, '可入住', '北京市西城区XX小区'),
    ('五居室', '整租', 150, '可入住', '北京市东城区XX小区');

-- 房屋信息表
INSERT INTO tab_homeInformation_zch_hwz_gjc (homeId_zch_hwz_gjc, homeArea_zch_hwz_gjc, houseStructure_zch_hwz_gjc, maxPerson_zch_hwz_gjc, homeDeposit_zch_hwz_gjc, homeInDate_zch_hwz_gjc)
VALUES
    (1, 50, '一室一厅', 2, 1000, '2023-01-07 12:00:00'),
    (2, 80, '一室一厅', 3, 1500, '2023-02-07 12:00:00'),
    (3, 100, '二室一厅', 4, 2000, '2023-03-07 12:00:00'),
    (4, 120, '一室一厅一卫', 5, 2500, '2023-04-07 12:00:00'),
    (5, 150, '三室一厅', 6, 3000, '2023-05-07 12:00:00');

-- 用户统一通知表

INSERT INTO tab_userNotification_zch_hwz_gjc (notificationReleaseTime_zch_hwz_gjc, notifyPostManager_zch_hwz_gjc, notificationContent_zch_hwz_gjc)
VALUES
    ('2023-01-09 12:00:00', 1, '温馨提示:国庆节放假通知'),
    ('2023-02-09 12:00:00', 2, '温馨提示:新年放假通知'),
    ('2023-03-09 12:00:00', 3, '温馨提示:五一放假通知'),
    ('2023-04-09 12:00:00', 4, '温馨提示:端午节放假通知'),
    ('2023-05-09 12:00:00', 5, '温馨提示:中秋节放假通知');

-- 优惠券表
INSERT INTO tab_coupon_zch_hwz_gjc (couponName_zch_hwz_gjc, discountMethod_zch_hwz_gjc, discountIntensity_zch_hwz_gjc, useThreshold_zch_hwz_gjc, applicableScope_zch_hwz_gjc, discountInformation_zch_hwz_gjc, earliestUseTime_zch_hwz_gjc, latestUseTime_zch_hwz_gjc)
VALUES
    ('新用户优惠券', '打折', 0.8, 500, '全部用户', '新用户首次下单可享受8折优惠', '2023-01-01 00:00:00', '2023-12-31 23:59:59'),
    ('会员日优惠券', '减免', 50, 300, '全部用户', '会员日全场订单满300减50', '2023-02-01 00:00:00', '2023-02-28 23:59:59'),
    ('生日优惠券', '打折', 0.5, 1000, '全部用户', '生日当天订单满1000打5折', '2023-03-01 00:00:00', '2023-12-31 23:59:59'),
    ('节日优惠券', '满减', 100, 500, '全部用户', '国庆节期间订单满500减100', '2023-04-01 00:00:00', '2023-10-07 23:59:59'),
    ('全场优惠券', '满减', 50, 200, '全部用户', '全场通用,订单满200减50', '2023-05-01 00:00:00', '2023-12-31 23:59:59');

-- 优惠用户详情表
INSERT INTO tab_usersAndCoupons_zch_hwz_gjc (userId_zch_hwz_gjc, couponId_zch_hwz_gjc)
VALUES
    (1000, 1),
    (1001, 2),
    (1002, 3),
    (1003, 4),
    (1004, 5);

-- 房屋评论表
INSERT INTO tab_housingReview_zch_hwz_gjc (comments_zch_hwz_gjc, userId_zch_hwz_gjc, homeId_zch_hwz_gjc, reviewTime_zch_hwz_gjc, housingReviewRating_zch_hwz_gjc)
VALUES
    ('房屋很不错', 1000, 1, '2023-01-11 12:00:00', 5),
    ('房间很干净', 1001, 2, '2023-02-11 12:00:00', 4),
    ('装修很漂亮', 1002, 3, '2023-03-11 12:00:00', 5),
    ('房东很好', 1003, 4, '2023-04-11 12:00:00', 5),
    ('很满意此次入住', 1004, 5, '2023-05-11 12:00:00', 5);

-- 景点表

INSERT INTO tab_attractions_zch_hwz_gjc (attractionsName_zch_hwz_gjc, attractionInformation_zch_hwz_gjc, openingTime_zch_hwz_gjc, closingTime_zch_hwz_gjc, attractionInDate_zch_hwz_gjc)
VALUES
    ('故宫', '中国古代皇家宫殿', '08:30:00', '17:00:00', '2023-01-13 12:00:00'),
    ('颐和园', '中国古典园林', '06:30:00', '18:00:00', '2023-02-13 12:00:00'),
    ('长城', '中华民族伟大建筑', '08:00:00', '18:00:00', '2023-03-13 12:00:00'),
    ('西湖', '中国名胜古迹', '07:00:00', '17:30:00', '2023-04-13 12:00:00'),
    ('九寨沟', '世界自然遗产', '07:30:00', '18:00:00', '2023-05-13 12:00:00');

-- 景点评论表
INSERT INTO tab_attractionReview_zch_hwz_gjc (comments_zch_hwz_gjc, userId_zch_hwz_gjc, attractionsId_zch_hwz_gjc, reviewTime_zch_hwz_gjc, attractionReviewRating_zch_hwz_gjc)

VALUES
    ('景色很美', 1000, 1, '2023-01-14 12:00:00', 5),
    ('环境很好', 1001, 2, '2023-02-14 12:00:00', 4),
    ('值得再来', 1002, 3, '2023-03-14 12:00:00', 5),
    ('玩的很开心', 1003, 4, '2023-04-14 12:00:00', 5),
    ('景点很棒', 1004, 5, '2023-05-14 12:00:00', 5);

-- 房屋收藏表
INSERT INTO tab_houseCollection_zch_hwz_gjc (userId_zch_hwz_gjc, homeId_zch_hwz_gjc, collectionTime_zch_hwz_gjc)
VALUES
    (1000, 1, '2023-01-15 12:00:00'),
    (1001, 2, '2023-02-15 12:00:00'),
    (1002, 3, '2023-03-15 12:00:00'),
    (1003, 4, '2023-04-15 12:00:00'),
    (1004, 5, '2023-05-15 12:00:00');

-- 景点收藏表

INSERT INTO tab_attractionCollection_zch_hwz_gjc (userId_zch_hwz_gjc, attractionsId_zch_hwz_gjc, collectionTime_zch_hwz_gjc)
VALUES
    (1000, 1, '2023-01-16 12:00:00'),
    (1001, 2, '2023-02-16 12:00:00'),
    (1002, 3, '2023-03-16 12:00:00'),
    (1003, 4, '2023-04-16 12:00:00'),
    (1004, 5, '2023-05-16 12:00:00');

-- 订单表
INSERT INTO tab_order_zch_hwz_gjc (homeId_zch_hwz_gjc, creationTime_zch_hwz_gjc, endTime_zch_hwz_gjc, userId_zch_hwz_gjc)

VALUES
    (1, '2023-01-17 12:00:00', '2023-01-20 12:00:00', 1000),
    (2, '2023-02-17 12:00:00', '2023-02-20 12:00:00', 1001),
    (3, '2023-03-17 12:00:00', '2023-03-20 12:00:00', 1002),
    (4, '2023-04-17 12:00:00', '2023-04-20 12:00:00', 1003),
    (5, '2023-05-17 12:00:00', '2023-05-20 12:00:00', 1004);


-- 房屋设备表
INSERT INTO tab_homeDevice_zch_hwz_gjc (homeId_zch_hwz_gjc, deviceName_zch_hwz_gjc, deviceType_zch_hwz_gjc, brand_zch_hwz_gjc, price_zch_hwz_gjc)

VALUES
    (1, '空调', '空调', '格力', 2500),
    (2, '电视', '电视', '海信', 1500),
    (3, '洗衣机', '洗衣机', '小天鹅', 1800),
    (4, '冰箱', '冰箱', '海尔', 3000),
    (5, '热水器', '热水器', '方太', 1200);

-- 支付密码表
INSERT INTO tab_paymentPassword_zch_hwz_gjc (accountID_zch_hwz_gjc, paymentPassword_zch_hwz_gjc, setTime_zch_hwz_gjc)
VALUES
    (1, '123456', '2023-01-24 12:00:00'),
    (2, '123456', '2023-02-24 12:00:00'),
    (3, '123456', '2023-03-24 12:00:00'),
    (4, '123456', '2023-04-24 12:00:00'),
    (5, '123456', '2023-05-24 12:00:00');

-- 房屋图片表
INSERT INTO tab_homeImage_zch_hwz_gjc (homeId_zch_hwz_gjc, imagePath_zch_hwz_gjc, inDateTime_zch_hwz_gjc)
VALUES
    (1, '/home1.jpg', '2023-01-25 12:00:00'),
    (2, '/home2.jpg', '2023-02-25 12:00:00'),
    (3, '/home3.jpg', '2023-03-25 12:00:00'),
    (4, '/home4.jpg', '2023-04-25 12:00:00'),
    (5, '/home5.jpg', '2023-05-25 12:00:00');

-- 维修保洁绑定房屋表
INSERT INTO tab_managerHomeBinding_zch_hwz_gjc (managerID_zch_hwz_gjc, homeID_zch_hwz_gjc, bindingType_zch_hwz_gjc, bindingTime_zch_hwz_gjc)
VALUES
    (1, 1, '维修', '2023-01-27 12:00:00'),
    (2, 2, '保洁', '2023-02-27 12:00:00'),
    (3, 3, '维护', '2023-03-27 12:00:00'),
    (4, 4, '维修', '2023-04-27 12:00:00'),
    (5, 5, '保洁', '2023-05-27 12:00:00');

-- 景点图片表
INSERT INTO tab_attractionImage_zch_hwz_gjc (attractionId_zch_hwz_gjc, imagePath_zch_hwz_gjc, inDateTime_zch_hwz_gjc)
VALUES
    (1, '/attr1.jpg', '2023-01-28 12:00:00'),
    (2, '/attr2.jpg', '2023-02-28 12:00:00'),
    (3, '/attr3.jpg', '2023-03-28 12:00:00'),
    (4, '/attr4.jpg', '2023-04-28 12:00:00'),
    (5, '/attr5.jpg', '2023-05-28 12:00:00');

-- 身份证记录表
INSERT INTO tab_IDCardRecord_zch_hwz_gjc (IDCardName_zch_hwz_gjc, IDCardNumber_zch_hwz_gjc, IDCardPhoneNumber_zch_hwz_gjc, userId_zch_hwz_gjc, inDateTime_zch_hwz_gjc)
VALUES
    ('张三', '110101199003071011', '13811111111', 1000, '2023-01-29 12:00:00'),
    ('李四', '110101199003071022', '13811111112', 1001, '2023-02-28 12:00:00'),
    ('王五', '110101199103074011', '13811111113', 1002, '2023-03-29 12:00:00'),
    ('赵六', '110101199003074022', '13811111114', 1003, '2023-04-29 12:00:00'),
    ('田七', '110101199103075011', '13811111115', 1004, '2023-05-29 12:00:00');

-- 身份信息对照表
INSERT INTO tab_IdentityChecklist_zch_hwz_gjc (IDCardRecordID_zch_hwz_gjc, orderID_zch_hwz_gjc)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);