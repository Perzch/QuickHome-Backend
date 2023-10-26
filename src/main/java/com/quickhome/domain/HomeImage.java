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
 * @TableName tab_homeimage_zch_hwz_gjc
 */
@TableName(value ="tab_homeimage_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class HomeImage implements Serializable {
    /**
     * 图片编号
     */
    @TableId(value = "imageId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("imageId")
    private Long imageId_zch_hwz_gjc;

    /**
     * 房屋编号
     */
    @TableField(value = "homeId_zch_hwz_gjc")
    @JsonProperty("homeId")
    private Long homeId_zch_hwz_gjc;

    /**
     * 图片路径
     */
    @TableField(value = "imagePath_zch_hwz_gjc")
    @JsonProperty("imagePath")
    private String imagePath_zch_hwz_gjc;

    /**
     * 上传时间
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
        HomeImage other = (HomeImage) that;
        return (this.getImageId_zch_hwz_gjc() == null ? other.getImageId_zch_hwz_gjc() == null : this.getImageId_zch_hwz_gjc().equals(other.getImageId_zch_hwz_gjc()))
            && (this.getHomeId_zch_hwz_gjc() == null ? other.getHomeId_zch_hwz_gjc() == null : this.getHomeId_zch_hwz_gjc().equals(other.getHomeId_zch_hwz_gjc()))
            && (this.getImagePath_zch_hwz_gjc() == null ? other.getImagePath_zch_hwz_gjc() == null : this.getImagePath_zch_hwz_gjc().equals(other.getImagePath_zch_hwz_gjc()))
            && (this.getInDateTime_zch_hwz_gjc() == null ? other.getInDateTime_zch_hwz_gjc() == null : this.getInDateTime_zch_hwz_gjc().equals(other.getInDateTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getVersion_zch_hwz_gjc() == null ? other.getVersion_zch_hwz_gjc() == null : this.getVersion_zch_hwz_gjc().equals(other.getVersion_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getImageId_zch_hwz_gjc() == null) ? 0 : getImageId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeId_zch_hwz_gjc() == null) ? 0 : getHomeId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getImagePath_zch_hwz_gjc() == null) ? 0 : getImagePath_zch_hwz_gjc().hashCode());
        result = prime * result + ((getInDateTime_zch_hwz_gjc() == null) ? 0 : getInDateTime_zch_hwz_gjc().hashCode());
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
        sb.append(", imageId_zch_hwz_gjc=").append(imageId_zch_hwz_gjc);
        sb.append(", homeId_zch_hwz_gjc=").append(homeId_zch_hwz_gjc);
        sb.append(", imagePath_zch_hwz_gjc=").append(imagePath_zch_hwz_gjc);
        sb.append(", inDateTime_zch_hwz_gjc=").append(inDateTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", version_zch_hwz_gjc=").append(version_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}