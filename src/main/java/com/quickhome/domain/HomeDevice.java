package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tab_homedevice_zch_hwz_gjc
 */
@TableName(value ="tab_homedevice_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class HomeDevice implements Serializable {
    /**
     * 设备编号
     */
    @TableId(value = "deviceID_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("deviceID")
    private Long deviceID_zch_hwz_gjc;

    /**
     * 房屋编号
     */
    @TableField(value = "homeId_zch_hwz_gjc")
    @JsonProperty("homeID")
    private Long homeId_zch_hwz_gjc;

    /**
     * 设备名称
     */
    @TableField(value = "deviceName_zch_hwz_gjc")
    @JsonProperty("deviceName")
    private String deviceName_zch_hwz_gjc;

    /**
     * 设备类型(电视/空调/冰箱/洗衣机/热水器/冷暖器)
     */
    @TableField(value = "deviceType_zch_hwz_gjc")
    @JsonProperty("deviceType")
    private String deviceType_zch_hwz_gjc;

    /**
     * 设备属性(安全设备/基础设备/智能设备)
     */
    @TableField(value = "deviceProperties_zch_hwz_gjc")
    @JsonProperty("deviceProperties")
    private String deviceProperties_zch_hwz_gjc;

    /**
     * 品牌
     */
    @TableField(value = "brand_zch_hwz_gjc")
    @JsonProperty("brand")
    private String brand_zch_hwz_gjc;

    /**
     * 价格
     */
    @TableField(value = "price_zch_hwz_gjc")
    @JsonProperty("price")
    private BigDecimal price_zch_hwz_gjc;

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
        HomeDevice other = (HomeDevice) that;
        return (this.getDeviceID_zch_hwz_gjc() == null ? other.getDeviceID_zch_hwz_gjc() == null : this.getDeviceID_zch_hwz_gjc().equals(other.getDeviceID_zch_hwz_gjc()))
            && (this.getHomeId_zch_hwz_gjc() == null ? other.getHomeId_zch_hwz_gjc() == null : this.getHomeId_zch_hwz_gjc().equals(other.getHomeId_zch_hwz_gjc()))
            && (this.getDeviceName_zch_hwz_gjc() == null ? other.getDeviceName_zch_hwz_gjc() == null : this.getDeviceName_zch_hwz_gjc().equals(other.getDeviceName_zch_hwz_gjc()))
            && (this.getDeviceType_zch_hwz_gjc() == null ? other.getDeviceType_zch_hwz_gjc() == null : this.getDeviceType_zch_hwz_gjc().equals(other.getDeviceType_zch_hwz_gjc()))
            && (this.getDeviceProperties_zch_hwz_gjc() == null ? other.getDeviceProperties_zch_hwz_gjc() == null : this.getDeviceProperties_zch_hwz_gjc().equals(other.getDeviceProperties_zch_hwz_gjc()))
            && (this.getBrand_zch_hwz_gjc() == null ? other.getBrand_zch_hwz_gjc() == null : this.getBrand_zch_hwz_gjc().equals(other.getBrand_zch_hwz_gjc()))
            && (this.getPrice_zch_hwz_gjc() == null ? other.getPrice_zch_hwz_gjc() == null : this.getPrice_zch_hwz_gjc().equals(other.getPrice_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeviceID_zch_hwz_gjc() == null) ? 0 : getDeviceID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeId_zch_hwz_gjc() == null) ? 0 : getHomeId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeviceName_zch_hwz_gjc() == null) ? 0 : getDeviceName_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeviceType_zch_hwz_gjc() == null) ? 0 : getDeviceType_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeviceProperties_zch_hwz_gjc() == null) ? 0 : getDeviceProperties_zch_hwz_gjc().hashCode());
        result = prime * result + ((getBrand_zch_hwz_gjc() == null) ? 0 : getBrand_zch_hwz_gjc().hashCode());
        result = prime * result + ((getPrice_zch_hwz_gjc() == null) ? 0 : getPrice_zch_hwz_gjc().hashCode());
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
        sb.append(", deviceID_zch_hwz_gjc=").append(deviceID_zch_hwz_gjc);
        sb.append(", homeId_zch_hwz_gjc=").append(homeId_zch_hwz_gjc);
        sb.append(", deviceName_zch_hwz_gjc=").append(deviceName_zch_hwz_gjc);
        sb.append(", deviceType_zch_hwz_gjc=").append(deviceType_zch_hwz_gjc);
        sb.append(", deviceProperties_zch_hwz_gjc=").append(deviceProperties_zch_hwz_gjc);
        sb.append(", brand_zch_hwz_gjc=").append(brand_zch_hwz_gjc);
        sb.append(", price_zch_hwz_gjc=").append(price_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}