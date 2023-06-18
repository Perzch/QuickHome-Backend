package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tab_userNotification_zch_hwz_gjc
 */
@TableName(value ="tab_userNotification_zch_hwz_gjc")
@Data
public class UserNotification implements Serializable {
    /**
     * 
     */
    @TableId(value = "userNotificationId_zch_hwz_gjc", type = IdType.AUTO)
    private Long userNotificationId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "notificationReleaseTime_zch_hwz_gjc")
    private Date notificationReleaseTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "notifyPostManager_zch_hwz_gjc")
    private Long notifyPostManager_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "notificationContent_zch_hwz_gjc")
    private String notificationContent_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "standby1_zch_hwz_gjc")
    private String standby1_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "standby2_zch_hwz_gjc")
    private String standby2_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "standby3_zch_hwz_gjc")
    private String standby3_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "visible_zch_hwz_gjc")
    private Integer visible_zch_hwz_gjc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserNotification other = (UserNotification) that;
        return (this.getUserNotificationId_zch_hwz_gjc() == null ? other.getUserNotificationId_zch_hwz_gjc() == null : this.getUserNotificationId_zch_hwz_gjc().equals(other.getUserNotificationId_zch_hwz_gjc()))
            && (this.getNotificationReleaseTime_zch_hwz_gjc() == null ? other.getNotificationReleaseTime_zch_hwz_gjc() == null : this.getNotificationReleaseTime_zch_hwz_gjc().equals(other.getNotificationReleaseTime_zch_hwz_gjc()))
            && (this.getNotifyPostManager_zch_hwz_gjc() == null ? other.getNotifyPostManager_zch_hwz_gjc() == null : this.getNotifyPostManager_zch_hwz_gjc().equals(other.getNotifyPostManager_zch_hwz_gjc()))
            && (this.getNotificationContent_zch_hwz_gjc() == null ? other.getNotificationContent_zch_hwz_gjc() == null : this.getNotificationContent_zch_hwz_gjc().equals(other.getNotificationContent_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserNotificationId_zch_hwz_gjc() == null) ? 0 : getUserNotificationId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getNotificationReleaseTime_zch_hwz_gjc() == null) ? 0 : getNotificationReleaseTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getNotifyPostManager_zch_hwz_gjc() == null) ? 0 : getNotifyPostManager_zch_hwz_gjc().hashCode());
        result = prime * result + ((getNotificationContent_zch_hwz_gjc() == null) ? 0 : getNotificationContent_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby1_zch_hwz_gjc() == null) ? 0 : getStandby1_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby2_zch_hwz_gjc() == null) ? 0 : getStandby2_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby3_zch_hwz_gjc() == null) ? 0 : getStandby3_zch_hwz_gjc().hashCode());
        result = prime * result + ((getVisible_zch_hwz_gjc() == null) ? 0 : getVisible_zch_hwz_gjc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userNotificationId_zch_hwz_gjc=").append(userNotificationId_zch_hwz_gjc);
        sb.append(", notificationReleaseTime_zch_hwz_gjc=").append(notificationReleaseTime_zch_hwz_gjc);
        sb.append(", notifyPostManager_zch_hwz_gjc=").append(notifyPostManager_zch_hwz_gjc);
        sb.append(", notificationContent_zch_hwz_gjc=").append(notificationContent_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}