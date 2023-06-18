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
 * @TableName tab_superManager_zch_hwz_gjc
 */
@TableName(value ="tab_superManager_zch_hwz_gjc")
@Data
public class SuperManager implements Serializable {
    /**
     * 
     */
    @TableId(value = "superManagerId_zch_hwz_gjc", type = IdType.AUTO)
    private Long superManagerId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "superManagerAccount_zch_hwz_gjc")
    private String superManagerAccount_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "superManagerPwd_zch_hwz_gjc")
    private String superManagerPwd_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "createTime_zch_hwz_gjc")
    private Date createTime_zch_hwz_gjc;

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
        SuperManager other = (SuperManager) that;
        return (this.getSuperManagerId_zch_hwz_gjc() == null ? other.getSuperManagerId_zch_hwz_gjc() == null : this.getSuperManagerId_zch_hwz_gjc().equals(other.getSuperManagerId_zch_hwz_gjc()))
            && (this.getSuperManagerAccount_zch_hwz_gjc() == null ? other.getSuperManagerAccount_zch_hwz_gjc() == null : this.getSuperManagerAccount_zch_hwz_gjc().equals(other.getSuperManagerAccount_zch_hwz_gjc()))
            && (this.getSuperManagerPwd_zch_hwz_gjc() == null ? other.getSuperManagerPwd_zch_hwz_gjc() == null : this.getSuperManagerPwd_zch_hwz_gjc().equals(other.getSuperManagerPwd_zch_hwz_gjc()))
            && (this.getCreateTime_zch_hwz_gjc() == null ? other.getCreateTime_zch_hwz_gjc() == null : this.getCreateTime_zch_hwz_gjc().equals(other.getCreateTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSuperManagerId_zch_hwz_gjc() == null) ? 0 : getSuperManagerId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getSuperManagerAccount_zch_hwz_gjc() == null) ? 0 : getSuperManagerAccount_zch_hwz_gjc().hashCode());
        result = prime * result + ((getSuperManagerPwd_zch_hwz_gjc() == null) ? 0 : getSuperManagerPwd_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCreateTime_zch_hwz_gjc() == null) ? 0 : getCreateTime_zch_hwz_gjc().hashCode());
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
        sb.append(", superManagerId_zch_hwz_gjc=").append(superManagerId_zch_hwz_gjc);
        sb.append(", superManagerAccount_zch_hwz_gjc=").append(superManagerAccount_zch_hwz_gjc);
        sb.append(", superManagerPwd_zch_hwz_gjc=").append(superManagerPwd_zch_hwz_gjc);
        sb.append(", createTime_zch_hwz_gjc=").append(createTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}