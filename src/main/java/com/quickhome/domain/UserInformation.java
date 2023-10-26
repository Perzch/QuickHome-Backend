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
 * @TableName tab_userinformation_zch_hwz_gjc
 */
@TableName(value ="tab_userinformation_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class UserInformation implements Serializable {
    /**
     * 用户信息编号
     */
    @TableId(value = "UIId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("UIId")
    private Long UIId_zch_hwz_gjc;

    /**
     * 用户编号
     */
    @TableField(value = "userId_zch_hwz_gjc")
    @JsonProperty("userId")
    private Long userId_zch_hwz_gjc;

    /**
     * 用户性别
     */
    @TableField(value = "userGender_zch_hwz_gjc")
    @JsonProperty("userGender")
    private String userGender_zch_hwz_gjc;

    /**
     * 用户头像编号
     */
    @TableField(value = "userHeadId_zch_hwz_gjc")
    @JsonProperty("userHeadId")
    private Long userHeadId_zch_hwz_gjc;

    /**
     * 用户生日
     */
    @TableField(value = "userBirthday_zch_hwz_gjc")
    @JsonProperty("userBirthday")
    private Date userBirthday_zch_hwz_gjc;

    /**
     * 个性签名
     */
    @TableField(value = "userSignature_zch_hwz_gjc")
    @JsonProperty("userSignature")
    private String userSignature_zch_hwz_gjc;

    /**
     * 证件类型
     */
    @TableField(value = "idCardType_zch_hwz_gjc")
    @JsonProperty("idCardType")
    private String idCardType_zch_hwz_gjc;

    /**
     * 证件号码
     */
    @TableField(value = "idCardNumber_zch_hwz_gjc")
    @JsonProperty("idCardNumber")
    private String idCardNumber_zch_hwz_gjc;

    /**
     * 实名认证状态
     */
    @TableField(value = "authenticationStatus_zch_hwz_gjc")
    @JsonProperty("authenticationStatus")
    private String authenticationStatus_zch_hwz_gjc;

    /**
     * 实名认证时间
     */
    @TableField(value = "authenticationTime_zch_hwz_gjc")
    @JsonProperty("authenticationTime")
    private Date authenticationTime_zch_hwz_gjc;

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
     * 乐观锁
     */
    @JsonProperty("version")
    @Version
    @TableField(value = "version_zch_hwz_gjc")
    private Integer version_zch_hwz_gjc;


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
            && (this.getVersion_zch_hwz_gjc() == null ? other.getVersion_zch_hwz_gjc() == null : this.getVersion_zch_hwz_gjc().equals(other.getVersion_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
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
        result = prime * result + ((getVersion_zch_hwz_gjc() == null) ? 0 : getVersion_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeleted_zch_hwz_gjc() == null) ? 0 : getDeleted_zch_hwz_gjc().hashCode());
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
        sb.append(", version_zch_hwz_gjc=").append(version_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}