package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tab_userInformation_zch_hwz_gjc
 */
@TableName(value ="tab_userInformation_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation implements Serializable {
    /**
     * 
     */
    @TableId(value = "UIId_zch_hwz_gjc", type = IdType.AUTO)
    private Long UIId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userId_zch_hwz_gjc")
    private Long userId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userGender_zch_hwz_gjc")
    private String userGender_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userHeadId_zch_hwz_gjc")
    private Long userHeadId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userBirthday_zch_hwz_gjc")
    private Date userBirthday_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userSignature_zch_hwz_gjc")
    private String userSignature_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "idCardType_zch_hwz_gjc")
    private String idCardType_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "idCardNumber_zch_hwz_gjc")
    private String idCardNumber_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "authenticationStatus_zch_hwz_gjc")
    private String authenticationStatus_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "authenticationTime_zch_hwz_gjc")
    private Date authenticationTime_zch_hwz_gjc;

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
        UserInformation other = (UserInformation) that;
        return (this.getUIId_zch_hwz_gjc() == null ? other.getUIId_zch_hwz_gjc() == null : this.getUIId_zch_hwz_gjc().equals(other.getUIId_zch_hwz_gjc()))
            && (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getUserGender_zch_hwz_gjc() == null ? other.getUserGender_zch_hwz_gjc() == null : this.getUserGender_zch_hwz_gjc().equals(other.getUserGender_zch_hwz_gjc()))
            && (this.getUserHeadId_zch_hwz_gjc() == null ? other.getUserHeadId_zch_hwz_gjc() == null : this.getUserHeadId_zch_hwz_gjc().equals(other.getUserHeadId_zch_hwz_gjc()))
            && (this.getUserBirthday_zch_hwz_gjc() == null ? other.getUserBirthday_zch_hwz_gjc() == null : this.getUserBirthday_zch_hwz_gjc().equals(other.getUserBirthday_zch_hwz_gjc()))
            && (this.getUserSignature_zch_hwz_gjc() == null ? other.getUserSignature_zch_hwz_gjc() == null : this.getUserSignature_zch_hwz_gjc().equals(other.getUserSignature_zch_hwz_gjc()))
            && (this.getIdCardType_zch_hwz_gjc() == null ? other.getIdCardType_zch_hwz_gjc() == null : this.getIdCardType_zch_hwz_gjc().equals(other.getIdCardType_zch_hwz_gjc()))
            && (this.getIdCardNumber_zch_hwz_gjc() == null ? other.getIdCardNumber_zch_hwz_gjc() == null : this.getIdCardNumber_zch_hwz_gjc().equals(other.getIdCardNumber_zch_hwz_gjc()))
            && (this.getAuthenticationStatus_zch_hwz_gjc() == null ? other.getAuthenticationStatus_zch_hwz_gjc() == null : this.getAuthenticationStatus_zch_hwz_gjc().equals(other.getAuthenticationStatus_zch_hwz_gjc()))
            && (this.getAuthenticationTime_zch_hwz_gjc() == null ? other.getAuthenticationTime_zch_hwz_gjc() == null : this.getAuthenticationTime_zch_hwz_gjc().equals(other.getAuthenticationTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUIId_zch_hwz_gjc() == null) ? 0 : getUIId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserGender_zch_hwz_gjc() == null) ? 0 : getUserGender_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserHeadId_zch_hwz_gjc() == null) ? 0 : getUserHeadId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserBirthday_zch_hwz_gjc() == null) ? 0 : getUserBirthday_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserSignature_zch_hwz_gjc() == null) ? 0 : getUserSignature_zch_hwz_gjc().hashCode());
        result = prime * result + ((getIdCardType_zch_hwz_gjc() == null) ? 0 : getIdCardType_zch_hwz_gjc().hashCode());
        result = prime * result + ((getIdCardNumber_zch_hwz_gjc() == null) ? 0 : getIdCardNumber_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAuthenticationStatus_zch_hwz_gjc() == null) ? 0 : getAuthenticationStatus_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAuthenticationTime_zch_hwz_gjc() == null) ? 0 : getAuthenticationTime_zch_hwz_gjc().hashCode());
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
        sb.append(", UIId_zch_hwz_gjc=").append(UIId_zch_hwz_gjc);
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", userGender_zch_hwz_gjc=").append(userGender_zch_hwz_gjc);
        sb.append(", userHeadId_zch_hwz_gjc=").append(userHeadId_zch_hwz_gjc);
        sb.append(", userBirthday_zch_hwz_gjc=").append(userBirthday_zch_hwz_gjc);
        sb.append(", userSignature_zch_hwz_gjc=").append(userSignature_zch_hwz_gjc);
        sb.append(", idCardType_zch_hwz_gjc=").append(idCardType_zch_hwz_gjc);
        sb.append(", idCardNumber_zch_hwz_gjc=").append(idCardNumber_zch_hwz_gjc);
        sb.append(", authenticationStatus_zch_hwz_gjc=").append(authenticationStatus_zch_hwz_gjc);
        sb.append(", authenticationTime_zch_hwz_gjc=").append(authenticationTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}