package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @TableName tab_supermanager_zch_hwz_gjc
 */
@TableName(value ="tab_supermanager_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class SuperManager implements Serializable {
    /**
     * 超级管理员编号
     */
    @TableId(value = "superManagerId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("superManagerId")
    private Long superManagerId_zch_hwz_gjc;

    /**
     * 超级管理员账号
     */
    @TableField(value = "superManagerAccount_zch_hwz_gjc")
    @JsonProperty("superManagerAccount")
    private String superManagerAccount_zch_hwz_gjc;

    /**
     * 超级管理员密码
     */
    @TableField(value = "superManagerPwd_zch_hwz_gjc")
    @JsonProperty("superManagerPwd")
    private String superManagerPwd_zch_hwz_gjc;

    /**
     * 创建时间
     */
    @TableField(value = "createTime_zch_hwz_gjc")
    @JsonProperty("createTime")
    private Date createTime_zch_hwz_gjc;

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
        SuperManager other = (SuperManager) that;
        return (this.getSuperManagerId_zch_hwz_gjc() == null ? other.getSuperManagerId_zch_hwz_gjc() == null : this.getSuperManagerId_zch_hwz_gjc().equals(other.getSuperManagerId_zch_hwz_gjc()))
            && (this.getSuperManagerAccount_zch_hwz_gjc() == null ? other.getSuperManagerAccount_zch_hwz_gjc() == null : this.getSuperManagerAccount_zch_hwz_gjc().equals(other.getSuperManagerAccount_zch_hwz_gjc()))
            && (this.getSuperManagerPwd_zch_hwz_gjc() == null ? other.getSuperManagerPwd_zch_hwz_gjc() == null : this.getSuperManagerPwd_zch_hwz_gjc().equals(other.getSuperManagerPwd_zch_hwz_gjc()))
            && (this.getCreateTime_zch_hwz_gjc() == null ? other.getCreateTime_zch_hwz_gjc() == null : this.getCreateTime_zch_hwz_gjc().equals(other.getCreateTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
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
        result = prime * result + ((getDeleted_zch_hwz_gjc() == null) ? 0 : getDeleted_zch_hwz_gjc().hashCode());
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
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}