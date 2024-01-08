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
 * @TableName tab_user_zch_hwz_gjc
 */
@TableName(value ="tab_user_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class User implements Serializable {
    /**
     * 用户编号
     */
    @TableId(value = "userId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("userId")
    private Long userId_zch_hwz_gjc;

    /**
     * 用户账户
     */
    @TableField(value = "userAccount_zch_hwz_gjc")
    @JsonProperty("userAccount")
    private String userAccount_zch_hwz_gjc;

    /**
     * 用户名
     */
    @TableField(value = "userName_zch_hwz_gjc")
    @JsonProperty("userName")
    private String userName_zch_hwz_gjc;

    /**
     * 用户密码
     */
    @TableField(value = "userPwd_zch_hwz_gjc")
    @JsonProperty(value = "userPwd", access = JsonProperty.Access.WRITE_ONLY)
    private String userPwd_zch_hwz_gjc;

    /**
     * 用户电子邮箱地址
     */
    @TableField(value = "userEmail_zch_hwz_gjc")
    @JsonProperty("userEmail")
    private String userEmail_zch_hwz_gjc;

    /**
     * 用户手机号
     */
    @TableField(value = "userPhone_zch_hwz_gjc")
    @JsonProperty("userPhone")
    private String userPhone_zch_hwz_gjc;

    /**
     * 用户注册日期
     */
    @TableField(value = "userInDate_zch_hwz_gjc")
    @JsonProperty("userInDate")
    private Date userInDate_zch_hwz_gjc;

    /**
     * 备用字段1
     */
    @TableField(value = "userHeadImage_zch_hwz_gjc")
    @JsonProperty("userHeadImage")
    private String userHeadImage_zch_hwz_gjc;

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
        User other = (User) that;
        return (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getUserAccount_zch_hwz_gjc() == null ? other.getUserAccount_zch_hwz_gjc() == null : this.getUserAccount_zch_hwz_gjc().equals(other.getUserAccount_zch_hwz_gjc()))
            && (this.getUserName_zch_hwz_gjc() == null ? other.getUserName_zch_hwz_gjc() == null : this.getUserName_zch_hwz_gjc().equals(other.getUserName_zch_hwz_gjc()))
            && (this.getUserPwd_zch_hwz_gjc() == null ? other.getUserPwd_zch_hwz_gjc() == null : this.getUserPwd_zch_hwz_gjc().equals(other.getUserPwd_zch_hwz_gjc()))
            && (this.getUserEmail_zch_hwz_gjc() == null ? other.getUserEmail_zch_hwz_gjc() == null : this.getUserEmail_zch_hwz_gjc().equals(other.getUserEmail_zch_hwz_gjc()))
            && (this.getUserPhone_zch_hwz_gjc() == null ? other.getUserPhone_zch_hwz_gjc() == null : this.getUserPhone_zch_hwz_gjc().equals(other.getUserPhone_zch_hwz_gjc()))
            && (this.getUserInDate_zch_hwz_gjc() == null ? other.getUserInDate_zch_hwz_gjc() == null : this.getUserInDate_zch_hwz_gjc().equals(other.getUserInDate_zch_hwz_gjc()))
            && (this.getUserHeadImage_zch_hwz_gjc() == null ? other.getUserHeadImage_zch_hwz_gjc() == null : this.getUserHeadImage_zch_hwz_gjc().equals(other.getUserHeadImage_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getVersion_zch_hwz_gjc() == null ? other.getVersion_zch_hwz_gjc() == null : this.getVersion_zch_hwz_gjc().equals(other.getVersion_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserAccount_zch_hwz_gjc() == null) ? 0 : getUserAccount_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserName_zch_hwz_gjc() == null) ? 0 : getUserName_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserPwd_zch_hwz_gjc() == null) ? 0 : getUserPwd_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserEmail_zch_hwz_gjc() == null) ? 0 : getUserEmail_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserPhone_zch_hwz_gjc() == null) ? 0 : getUserPhone_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserInDate_zch_hwz_gjc() == null) ? 0 : getUserInDate_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserHeadImage_zch_hwz_gjc() == null) ? 0 : getUserHeadImage_zch_hwz_gjc().hashCode());
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
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", userAccount_zch_hwz_gjc=").append(userAccount_zch_hwz_gjc);
        sb.append(", userName_zch_hwz_gjc=").append(userName_zch_hwz_gjc);
        sb.append(", userPwd_zch_hwz_gjc=").append(userPwd_zch_hwz_gjc);
        sb.append(", userEmail_zch_hwz_gjc=").append(userEmail_zch_hwz_gjc);
        sb.append(", userPhone_zch_hwz_gjc=").append(userPhone_zch_hwz_gjc);
        sb.append(", userInDate_zch_hwz_gjc=").append(userInDate_zch_hwz_gjc);
        sb.append(", userHeadImage_zch_hwz_gjc=").append(userHeadImage_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", version_zch_hwz_gjc=").append(version_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
