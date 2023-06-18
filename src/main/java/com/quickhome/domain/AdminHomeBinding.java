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
 * @TableName tab_adminHomeBinding_zch_hwz_gjc
 */
@TableName(value ="tab_adminHomeBinding_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminHomeBinding implements Serializable {
    /**
     * 
     */
    @TableId(value = "bindingID_zch_hwz_gjc", type = IdType.AUTO)
    private Long bindingID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "managerID_zch_hwz_gjc")
    private Long managerID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeID_zch_hwz_gjc")
    private Long homeID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "bindingType_zch_hwz_gjc")
    private String bindingType_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "bindingTime_zch_hwz_gjc")
    private Date bindingTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "bindingState_zch_hwz_gjc")
    private String bindingState_zch_hwz_gjc;

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
        AdminHomeBinding other = (AdminHomeBinding) that;
        return (this.getBindingID_zch_hwz_gjc() == null ? other.getBindingID_zch_hwz_gjc() == null : this.getBindingID_zch_hwz_gjc().equals(other.getBindingID_zch_hwz_gjc()))
            && (this.getManagerID_zch_hwz_gjc() == null ? other.getManagerID_zch_hwz_gjc() == null : this.getManagerID_zch_hwz_gjc().equals(other.getManagerID_zch_hwz_gjc()))
            && (this.getHomeID_zch_hwz_gjc() == null ? other.getHomeID_zch_hwz_gjc() == null : this.getHomeID_zch_hwz_gjc().equals(other.getHomeID_zch_hwz_gjc()))
            && (this.getBindingType_zch_hwz_gjc() == null ? other.getBindingType_zch_hwz_gjc() == null : this.getBindingType_zch_hwz_gjc().equals(other.getBindingType_zch_hwz_gjc()))
            && (this.getBindingTime_zch_hwz_gjc() == null ? other.getBindingTime_zch_hwz_gjc() == null : this.getBindingTime_zch_hwz_gjc().equals(other.getBindingTime_zch_hwz_gjc()))
            && (this.getBindingState_zch_hwz_gjc() == null ? other.getBindingState_zch_hwz_gjc() == null : this.getBindingState_zch_hwz_gjc().equals(other.getBindingState_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBindingID_zch_hwz_gjc() == null) ? 0 : getBindingID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getManagerID_zch_hwz_gjc() == null) ? 0 : getManagerID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeID_zch_hwz_gjc() == null) ? 0 : getHomeID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getBindingType_zch_hwz_gjc() == null) ? 0 : getBindingType_zch_hwz_gjc().hashCode());
        result = prime * result + ((getBindingTime_zch_hwz_gjc() == null) ? 0 : getBindingTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getBindingState_zch_hwz_gjc() == null) ? 0 : getBindingState_zch_hwz_gjc().hashCode());
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
        sb.append(", bindingID_zch_hwz_gjc=").append(bindingID_zch_hwz_gjc);
        sb.append(", managerID_zch_hwz_gjc=").append(managerID_zch_hwz_gjc);
        sb.append(", homeID_zch_hwz_gjc=").append(homeID_zch_hwz_gjc);
        sb.append(", bindingType_zch_hwz_gjc=").append(bindingType_zch_hwz_gjc);
        sb.append(", bindingTime_zch_hwz_gjc=").append(bindingTime_zch_hwz_gjc);
        sb.append(", bindingState_zch_hwz_gjc=").append(bindingState_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}