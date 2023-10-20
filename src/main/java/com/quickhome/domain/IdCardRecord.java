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
 * @TableName tab_idcardrecord_zch_hwz_gjc
 */
@TableName(value ="tab_idcardrecord_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class IdCardRecord implements Serializable {
    /**
     * 身份证记录编号
     */
    @TableId(value = "IDCardRecordID_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("IDCardRecordID")
    private Long IDCardRecordID_zch_hwz_gjc;

    /**
     * 身份证姓名
     */
    @TableField(value = "IDCardName_zch_hwz_gjc")
    @JsonProperty("IDCardName")
    private String IDCardName_zch_hwz_gjc;

    /**
     * 身份证号码
     */
    @TableField(value = "IDCardNumber_zch_hwz_gjc")
    @JsonProperty("IDCardNumber")
    private String IDCardNumber_zch_hwz_gjc;

    /**
     * 身份证手机号码
     */
    @TableField(value = "IDCardPhoneNumber_zch_hwz_gjc")
    @JsonProperty("IDCardPhoneNumber")
    private String IDCardPhoneNumber_zch_hwz_gjc;

    /**
     * 写入用户id
     */
    @TableField(value = "userId_zch_hwz_gjc")
    @JsonProperty("userId")
    private Long userId_zch_hwz_gjc;

    /**
     * 上传记录时间
     */
    @TableField(value = "inDateTime_zch_hwz_gjc")
    @JsonProperty("inDateTime")
    private Date inDateTime_zch_hwz_gjc;

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
        IdCardRecord other = (IdCardRecord) that;
        return (this.getIDCardRecordID_zch_hwz_gjc() == null ? other.getIDCardRecordID_zch_hwz_gjc() == null : this.getIDCardRecordID_zch_hwz_gjc().equals(other.getIDCardRecordID_zch_hwz_gjc()))
            && (this.getIDCardName_zch_hwz_gjc() == null ? other.getIDCardName_zch_hwz_gjc() == null : this.getIDCardName_zch_hwz_gjc().equals(other.getIDCardName_zch_hwz_gjc()))
            && (this.getIDCardNumber_zch_hwz_gjc() == null ? other.getIDCardNumber_zch_hwz_gjc() == null : this.getIDCardNumber_zch_hwz_gjc().equals(other.getIDCardNumber_zch_hwz_gjc()))
            && (this.getIDCardPhoneNumber_zch_hwz_gjc() == null ? other.getIDCardPhoneNumber_zch_hwz_gjc() == null : this.getIDCardPhoneNumber_zch_hwz_gjc().equals(other.getIDCardPhoneNumber_zch_hwz_gjc()))
            && (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getInDateTime_zch_hwz_gjc() == null ? other.getInDateTime_zch_hwz_gjc() == null : this.getInDateTime_zch_hwz_gjc().equals(other.getInDateTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIDCardRecordID_zch_hwz_gjc() == null) ? 0 : getIDCardRecordID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getIDCardName_zch_hwz_gjc() == null) ? 0 : getIDCardName_zch_hwz_gjc().hashCode());
        result = prime * result + ((getIDCardNumber_zch_hwz_gjc() == null) ? 0 : getIDCardNumber_zch_hwz_gjc().hashCode());
        result = prime * result + ((getIDCardPhoneNumber_zch_hwz_gjc() == null) ? 0 : getIDCardPhoneNumber_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getInDateTime_zch_hwz_gjc() == null) ? 0 : getInDateTime_zch_hwz_gjc().hashCode());
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
        sb.append(", IDCardRecordID_zch_hwz_gjc=").append(IDCardRecordID_zch_hwz_gjc);
        sb.append(", IDCardName_zch_hwz_gjc=").append(IDCardName_zch_hwz_gjc);
        sb.append(", IDCardNumber_zch_hwz_gjc=").append(IDCardNumber_zch_hwz_gjc);
        sb.append(", IDCardPhoneNumber_zch_hwz_gjc=").append(IDCardPhoneNumber_zch_hwz_gjc);
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", inDateTime_zch_hwz_gjc=").append(inDateTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}