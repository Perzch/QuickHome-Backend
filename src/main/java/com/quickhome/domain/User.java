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
 * @TableName tab_user_zch_hwz_gjc
 */
@TableName(value ="tab_user_zch_hwz_gjc")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(value = "userId_zch_hwz_gjc", type = IdType.AUTO)
    private Long userId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userAccount_zch_hwz_gjc")
    private String userAccount_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userName_zch_hwz_gjc")
    private String userName_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userPwd_zch_hwz_gjc")
    private String userPwd_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userEmail_zch_hwz_gjc")
    private String userEmail_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userPhone_zch_hwz_gjc")
    private String userPhone_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userInDate_zch_hwz_gjc")
    private Date userInDate_zch_hwz_gjc;

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
        User other = (User) that;
        return (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getUserAccount_zch_hwz_gjc() == null ? other.getUserAccount_zch_hwz_gjc() == null : this.getUserAccount_zch_hwz_gjc().equals(other.getUserAccount_zch_hwz_gjc()))
            && (this.getUserName_zch_hwz_gjc() == null ? other.getUserName_zch_hwz_gjc() == null : this.getUserName_zch_hwz_gjc().equals(other.getUserName_zch_hwz_gjc()))
            && (this.getUserPwd_zch_hwz_gjc() == null ? other.getUserPwd_zch_hwz_gjc() == null : this.getUserPwd_zch_hwz_gjc().equals(other.getUserPwd_zch_hwz_gjc()))
            && (this.getUserEmail_zch_hwz_gjc() == null ? other.getUserEmail_zch_hwz_gjc() == null : this.getUserEmail_zch_hwz_gjc().equals(other.getUserEmail_zch_hwz_gjc()))
            && (this.getUserPhone_zch_hwz_gjc() == null ? other.getUserPhone_zch_hwz_gjc() == null : this.getUserPhone_zch_hwz_gjc().equals(other.getUserPhone_zch_hwz_gjc()))
            && (this.getUserInDate_zch_hwz_gjc() == null ? other.getUserInDate_zch_hwz_gjc() == null : this.getUserInDate_zch_hwz_gjc().equals(other.getUserInDate_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
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
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", userAccount_zch_hwz_gjc=").append(userAccount_zch_hwz_gjc);
        sb.append(", userName_zch_hwz_gjc=").append(userName_zch_hwz_gjc);
        sb.append(", userPwd_zch_hwz_gjc=").append(userPwd_zch_hwz_gjc);
        sb.append(", userEmail_zch_hwz_gjc=").append(userEmail_zch_hwz_gjc);
        sb.append(", userPhone_zch_hwz_gjc=").append(userPhone_zch_hwz_gjc);
        sb.append(", userInDate_zch_hwz_gjc=").append(userInDate_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}