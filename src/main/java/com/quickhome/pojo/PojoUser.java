package com.quickhome.pojo;

import com.quickhome.domain.AccountBalance;
import com.quickhome.domain.User;
import com.quickhome.domain.UserHeadImage;
import com.quickhome.domain.UserInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/19 20:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PojoUser {
    String token;
    int userId;
    User user;
    UserInformation  userInformation;
    UserHeadImage  userHeadImage;
}
