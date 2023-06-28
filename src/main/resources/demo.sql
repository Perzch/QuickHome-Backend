SELECT a.*
FROM tab_home_zch_hwz_gjc AS a
         JOIN tab_homeinformation_zch_hwz_gjc AS b ON a.homeId_zch_hwz_gjc = b.homeId_zch_hwz_gjc
         LEFT JOIN tab_order_zch_hwz_gjc AS c ON a.homeId_zch_hwz_gjc = c.homeId_zch_hwz_gjc
WHERE b.homeArea_zch_hwz_gjc > 9
  AND b.maxPerson_zch_hwz_gjc >= 1
  AND a.homeType_zch_hwz_gjc LIKE '温暖家庭房'
  AND ('2023-07-10' < c.checkInTime_zch_hwz_gjc OR '2023-06-28' > c.checkOutTime_zch_hwz_gjc OR c.checkInTime_zch_hwz_gjc IS NULL)
LIMIT 0, 4