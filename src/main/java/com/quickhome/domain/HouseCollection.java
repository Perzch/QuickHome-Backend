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
 * @TableName tab_houseCollection_zch_hwz_gjc
 */
@TableName(value ="tab_houseCollection_zch_hwz_gjc")
@Data
public class HouseCollection implements Serializable {
    /**
     * 
     */
    @TableId(value = "hFavoriteRecordsId_zch_hwz_gjc", type = IdType.AUTO)
    private Long hFavoriteRecordsId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userId_zch_hwz_gjc")
    private Long userId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeId_zch_hwz_gjc")
    private Long homeId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "collectionTime_zch_hwz_gjc")
    private Date collectionTime_zch_hwz_gjc;

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
        HouseCollection other = (HouseCollection) that;
        return (this.getHFavoriteRecordsId_zch_hwz_gjc() == null ? other.getHFavoriteRecordsId_zch_hwz_gjc() == null : this.getHFavoriteRecordsId_zch_hwz_gjc().equals(other.getHFavoriteRecordsId_zch_hwz_gjc()))
            && (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getHomeId_zch_hwz_gjc() == null ? other.getHomeId_zch_hwz_gjc() == null : this.getHomeId_zch_hwz_gjc().equals(other.getHomeId_zch_hwz_gjc()))
            && (this.getCollectionTime_zch_hwz_gjc() == null ? other.getCollectionTime_zch_hwz_gjc() == null : this.getCollectionTime_zch_hwz_gjc().equals(other.getCollectionTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHFavoriteRecordsId_zch_hwz_gjc() == null) ? 0 : getHFavoriteRecordsId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeId_zch_hwz_gjc() == null) ? 0 : getHomeId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCollectionTime_zch_hwz_gjc() == null) ? 0 : getCollectionTime_zch_hwz_gjc().hashCode());
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
        sb.append(", hFavoriteRecordsId_zch_hwz_gjc=").append(hFavoriteRecordsId_zch_hwz_gjc);
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", homeId_zch_hwz_gjc=").append(homeId_zch_hwz_gjc);
        sb.append(", collectionTime_zch_hwz_gjc=").append(collectionTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}