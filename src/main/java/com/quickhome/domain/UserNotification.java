package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tab_usernotification_zch_hwz_gjc
 */
@TableName(value ="tab_usernotification_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class UserNotification implements Serializable {
    /**
     * 用户通知编号
     */
    @TableId(value = "userNotificationId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("userNotificationId")
    private Long userNotificationId_zch_hwz_gjc;

    /**
     * 通知发布时间
     */
    @TableField(value = "notificationReleaseTime_zch_hwz_gjc")
    @JsonProperty("notificationReleaseTime")
    private Date notificationReleaseTime_zch_hwz_gjc;

    /**
     * 通知发布管理员编号
     */
    @TableField(value = "notifyPostManager_zch_hwz_gjc")
    @JsonProperty("notifyPostManager")
    private Long notifyPostManager_zch_hwz_gjc;

    /**
     * 通知内容
     */
    @TableField(value = "notificationContent_zch_hwz_gjc")
    @JsonProperty("notificationContent")
    private String notificationContent_zch_hwz_gjc;

    /**
     * 备用字段1
     */
    @TableField(value = "standby1_zch_hwz_gjc")
    private String standby1_zch_hwz_gjc;

    /**
     * 备用字段2
     */
    @TableField(value = "standby2_zch_hwz_gjc")
    private String standby2_zch_hwz_gjc;

    /**
     * 备用字段3
     */
    @TableField(value = "standby3_zch_hwz_gjc")
    private String standby3_zch_hwz_gjc;

    /**
     * 逻辑删除（默认0，逻辑删除1）
     */
    @TableLogic
    @TableField(value = "deleted_zch_hwz_gjc")
    private Integer deleted_zch_hwz_gjc;

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
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
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
        result = prime * result + ((getDeleted_zch_hwz_gjc() == null) ? 0 : getDeleted_zch_hwz_gjc().hashCode());
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
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}