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
 * @TableName tab_RCAMI_zch_hwz_gjc
 */
@TableName(value ="tab_RCAMI_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rcami implements Serializable {
    /**
     * 
     */
    @TableId(value = "workItemId_zch_hwz_gjc", type = IdType.AUTO)
    private Long workItemId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "informationCreatTime_zch_hwz_gjc")
    private Date informationCreatTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "completionProcessTime_zch_hwz_gjc")
    private Date completionProcessTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "RCAMIInformation_zch_hwz_gjc")
    private String RCAMIInformation_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "des_zch_hwz_gjc")
    private String des_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "workUserId_zch_hwz_gjc")
    private Long workUserId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "completion_zch_hwz_gjc")
    private String completion_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "publisherId_zch_hwz_gjc")
    private Long publisherId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeId_zch_hwz_gjc")
    private Long homeId_zch_hwz_gjc;

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
        Rcami other = (Rcami) that;
        return (this.getWorkItemId_zch_hwz_gjc() == null ? other.getWorkItemId_zch_hwz_gjc() == null : this.getWorkItemId_zch_hwz_gjc().equals(other.getWorkItemId_zch_hwz_gjc()))
            && (this.getInformationCreatTime_zch_hwz_gjc() == null ? other.getInformationCreatTime_zch_hwz_gjc() == null : this.getInformationCreatTime_zch_hwz_gjc().equals(other.getInformationCreatTime_zch_hwz_gjc()))
            && (this.getCompletionProcessTime_zch_hwz_gjc() == null ? other.getCompletionProcessTime_zch_hwz_gjc() == null : this.getCompletionProcessTime_zch_hwz_gjc().equals(other.getCompletionProcessTime_zch_hwz_gjc()))
            && (this.getRCAMIInformation_zch_hwz_gjc() == null ? other.getRCAMIInformation_zch_hwz_gjc() == null : this.getRCAMIInformation_zch_hwz_gjc().equals(other.getRCAMIInformation_zch_hwz_gjc()))
            && (this.getDes_zch_hwz_gjc() == null ? other.getDes_zch_hwz_gjc() == null : this.getDes_zch_hwz_gjc().equals(other.getDes_zch_hwz_gjc()))
            && (this.getWorkUserId_zch_hwz_gjc() == null ? other.getWorkUserId_zch_hwz_gjc() == null : this.getWorkUserId_zch_hwz_gjc().equals(other.getWorkUserId_zch_hwz_gjc()))
            && (this.getCompletion_zch_hwz_gjc() == null ? other.getCompletion_zch_hwz_gjc() == null : this.getCompletion_zch_hwz_gjc().equals(other.getCompletion_zch_hwz_gjc()))
            && (this.getPublisherId_zch_hwz_gjc() == null ? other.getPublisherId_zch_hwz_gjc() == null : this.getPublisherId_zch_hwz_gjc().equals(other.getPublisherId_zch_hwz_gjc()))
            && (this.getHomeId_zch_hwz_gjc() == null ? other.getHomeId_zch_hwz_gjc() == null : this.getHomeId_zch_hwz_gjc().equals(other.getHomeId_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWorkItemId_zch_hwz_gjc() == null) ? 0 : getWorkItemId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getInformationCreatTime_zch_hwz_gjc() == null) ? 0 : getInformationCreatTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCompletionProcessTime_zch_hwz_gjc() == null) ? 0 : getCompletionProcessTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getRCAMIInformation_zch_hwz_gjc() == null) ? 0 : getRCAMIInformation_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDes_zch_hwz_gjc() == null) ? 0 : getDes_zch_hwz_gjc().hashCode());
        result = prime * result + ((getWorkUserId_zch_hwz_gjc() == null) ? 0 : getWorkUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCompletion_zch_hwz_gjc() == null) ? 0 : getCompletion_zch_hwz_gjc().hashCode());
        result = prime * result + ((getPublisherId_zch_hwz_gjc() == null) ? 0 : getPublisherId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeId_zch_hwz_gjc() == null) ? 0 : getHomeId_zch_hwz_gjc().hashCode());
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
        sb.append(", workItemId_zch_hwz_gjc=").append(workItemId_zch_hwz_gjc);
        sb.append(", informationCreatTime_zch_hwz_gjc=").append(informationCreatTime_zch_hwz_gjc);
        sb.append(", completionProcessTime_zch_hwz_gjc=").append(completionProcessTime_zch_hwz_gjc);
        sb.append(", RCAMIInformation_zch_hwz_gjc=").append(RCAMIInformation_zch_hwz_gjc);
        sb.append(", des_zch_hwz_gjc=").append(des_zch_hwz_gjc);
        sb.append(", workUserId_zch_hwz_gjc=").append(workUserId_zch_hwz_gjc);
        sb.append(", completion_zch_hwz_gjc=").append(completion_zch_hwz_gjc);
        sb.append(", publisherId_zch_hwz_gjc=").append(publisherId_zch_hwz_gjc);
        sb.append(", homeId_zch_hwz_gjc=").append(homeId_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}