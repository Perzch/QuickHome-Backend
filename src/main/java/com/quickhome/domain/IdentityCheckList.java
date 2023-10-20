package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName tab_identitychecklist_zch_hwz_gjc
 */
@TableName(value ="tab_identitychecklist_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class IdentityCheckList implements Serializable {
    /**
     * 身份信息对照编号
     */
    @TableId(value = "IdentityChecklistID_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("IdentityChecklistID")
    private Long identityChecklistID_zch_hwz_gjc;

    /**
     * 身份证记录编号
     */
    @TableField(value = "IDCardRecordID_zch_hwz_gjc")
    @JsonProperty("IDCardRecordID")
    private Long IDCardRecordID_zch_hwz_gjc;

    /**
     * 订单编号
     */
    @TableField(value = "orderID_zch_hwz_gjc")
    @JsonProperty("orderID")
    private Long orderID_zch_hwz_gjc;

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
        IdentityCheckList other = (IdentityCheckList) that;
        return (this.getIdentityChecklistID_zch_hwz_gjc() == null ? other.getIdentityChecklistID_zch_hwz_gjc() == null : this.getIdentityChecklistID_zch_hwz_gjc().equals(other.getIdentityChecklistID_zch_hwz_gjc()))
            && (this.getIDCardRecordID_zch_hwz_gjc() == null ? other.getIDCardRecordID_zch_hwz_gjc() == null : this.getIDCardRecordID_zch_hwz_gjc().equals(other.getIDCardRecordID_zch_hwz_gjc()))
            && (this.getOrderID_zch_hwz_gjc() == null ? other.getOrderID_zch_hwz_gjc() == null : this.getOrderID_zch_hwz_gjc().equals(other.getOrderID_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdentityChecklistID_zch_hwz_gjc() == null) ? 0 : getIdentityChecklistID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getIDCardRecordID_zch_hwz_gjc() == null) ? 0 : getIDCardRecordID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOrderID_zch_hwz_gjc() == null) ? 0 : getOrderID_zch_hwz_gjc().hashCode());
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
        sb.append(", identityChecklistID_zch_hwz_gjc=").append(identityChecklistID_zch_hwz_gjc);
        sb.append(", IDCardRecordID_zch_hwz_gjc=").append(IDCardRecordID_zch_hwz_gjc);
        sb.append(", orderID_zch_hwz_gjc=").append(orderID_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}