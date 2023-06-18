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
 * @TableName tab_manager_zch_hwz_gjc
 */
@TableName(value ="tab_manager_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Manager implements Serializable {
    /**
     * 
     */
    @TableId(value = "managerId_zch_hwz_gjc", type = IdType.AUTO)
    private Long managerId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "administratorCategory_zch_hwz_gjc")
    private String administratorCategory_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "managerAccount_zch_hwz_gjc")
    private String managerAccount_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "managerPwd_zch_hwz_gjc")
    private String managerPwd_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "managerName_zch_hwz_gjc")
    private String managerName_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "managerPhone_zch_hwz_gjc")
    private String managerPhone_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "managerGender_zch_hwz_gjc")
    private String managerGender_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "managerInDate_zch_hwz_gjc")
    private Date managerInDate_zch_hwz_gjc;

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
        Manager other = (Manager) that;
        return (this.getManagerId_zch_hwz_gjc() == null ? other.getManagerId_zch_hwz_gjc() == null : this.getManagerId_zch_hwz_gjc().equals(other.getManagerId_zch_hwz_gjc()))
            && (this.getAdministratorCategory_zch_hwz_gjc() == null ? other.getAdministratorCategory_zch_hwz_gjc() == null : this.getAdministratorCategory_zch_hwz_gjc().equals(other.getAdministratorCategory_zch_hwz_gjc()))
            && (this.getManagerAccount_zch_hwz_gjc() == null ? other.getManagerAccount_zch_hwz_gjc() == null : this.getManagerAccount_zch_hwz_gjc().equals(other.getManagerAccount_zch_hwz_gjc()))
            && (this.getManagerPwd_zch_hwz_gjc() == null ? other.getManagerPwd_zch_hwz_gjc() == null : this.getManagerPwd_zch_hwz_gjc().equals(other.getManagerPwd_zch_hwz_gjc()))
            && (this.getManagerName_zch_hwz_gjc() == null ? other.getManagerName_zch_hwz_gjc() == null : this.getManagerName_zch_hwz_gjc().equals(other.getManagerName_zch_hwz_gjc()))
            && (this.getManagerPhone_zch_hwz_gjc() == null ? other.getManagerPhone_zch_hwz_gjc() == null : this.getManagerPhone_zch_hwz_gjc().equals(other.getManagerPhone_zch_hwz_gjc()))
            && (this.getManagerGender_zch_hwz_gjc() == null ? other.getManagerGender_zch_hwz_gjc() == null : this.getManagerGender_zch_hwz_gjc().equals(other.getManagerGender_zch_hwz_gjc()))
            && (this.getManagerInDate_zch_hwz_gjc() == null ? other.getManagerInDate_zch_hwz_gjc() == null : this.getManagerInDate_zch_hwz_gjc().equals(other.getManagerInDate_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getManagerId_zch_hwz_gjc() == null) ? 0 : getManagerId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAdministratorCategory_zch_hwz_gjc() == null) ? 0 : getAdministratorCategory_zch_hwz_gjc().hashCode());
        result = prime * result + ((getManagerAccount_zch_hwz_gjc() == null) ? 0 : getManagerAccount_zch_hwz_gjc().hashCode());
        result = prime * result + ((getManagerPwd_zch_hwz_gjc() == null) ? 0 : getManagerPwd_zch_hwz_gjc().hashCode());
        result = prime * result + ((getManagerName_zch_hwz_gjc() == null) ? 0 : getManagerName_zch_hwz_gjc().hashCode());
        result = prime * result + ((getManagerPhone_zch_hwz_gjc() == null) ? 0 : getManagerPhone_zch_hwz_gjc().hashCode());
        result = prime * result + ((getManagerGender_zch_hwz_gjc() == null) ? 0 : getManagerGender_zch_hwz_gjc().hashCode());
        result = prime * result + ((getManagerInDate_zch_hwz_gjc() == null) ? 0 : getManagerInDate_zch_hwz_gjc().hashCode());
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
        sb.append(", managerId_zch_hwz_gjc=").append(managerId_zch_hwz_gjc);
        sb.append(", administratorCategory_zch_hwz_gjc=").append(administratorCategory_zch_hwz_gjc);
        sb.append(", managerAccount_zch_hwz_gjc=").append(managerAccount_zch_hwz_gjc);
        sb.append(", managerPwd_zch_hwz_gjc=").append(managerPwd_zch_hwz_gjc);
        sb.append(", managerName_zch_hwz_gjc=").append(managerName_zch_hwz_gjc);
        sb.append(", managerPhone_zch_hwz_gjc=").append(managerPhone_zch_hwz_gjc);
        sb.append(", managerGender_zch_hwz_gjc=").append(managerGender_zch_hwz_gjc);
        sb.append(", managerInDate_zch_hwz_gjc=").append(managerInDate_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}