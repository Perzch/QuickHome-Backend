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
 * @TableName tab_mychat_zch_hwz_gjc
 */
@TableName(value ="tab_mychat_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class MyChat implements Serializable {
    /**
     * 私信编号
     */
    @TableId(value = "chatId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("chatId")
    private Long chatId_zch_hwz_gjc;

    /**
     * 接收人编号
     */
    @TableField(value = "messageReceive_zch_hwz_gjc")
    @JsonProperty("messageReceive")
    private Long messageReceive_zch_hwz_gjc;

    /**
     * 私信内容
     */
    @TableField(value = "messageContent_zch_hwz_gjc")
    @JsonProperty("messageContent")
    private String messageContent_zch_hwz_gjc;

    /**
     * 发送人编号
     */
    @TableField(value = "messageSender_zch_hwz_gjc")
    @JsonProperty("messageSender")
    private Long messageSender_zch_hwz_gjc;

    /**
     * 对话编号
     */
    @TableField(value = "conversationDialogId_zch_hwz_gjc")
    @JsonProperty("conversationDialogId")
    private Long conversationDialogId_zch_hwz_gjc;

    /**
     * 发送时间
     */
    @TableField(value = "sendingTime_zch_hwz_gjc")
    @JsonProperty("sendingTime")
    private Date sendingTime_zch_hwz_gjc;

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
        MyChat other = (MyChat) that;
        return (this.getChatId_zch_hwz_gjc() == null ? other.getChatId_zch_hwz_gjc() == null : this.getChatId_zch_hwz_gjc().equals(other.getChatId_zch_hwz_gjc()))
            && (this.getMessageReceive_zch_hwz_gjc() == null ? other.getMessageReceive_zch_hwz_gjc() == null : this.getMessageReceive_zch_hwz_gjc().equals(other.getMessageReceive_zch_hwz_gjc()))
            && (this.getMessageContent_zch_hwz_gjc() == null ? other.getMessageContent_zch_hwz_gjc() == null : this.getMessageContent_zch_hwz_gjc().equals(other.getMessageContent_zch_hwz_gjc()))
            && (this.getMessageSender_zch_hwz_gjc() == null ? other.getMessageSender_zch_hwz_gjc() == null : this.getMessageSender_zch_hwz_gjc().equals(other.getMessageSender_zch_hwz_gjc()))
            && (this.getConversationDialogId_zch_hwz_gjc() == null ? other.getConversationDialogId_zch_hwz_gjc() == null : this.getConversationDialogId_zch_hwz_gjc().equals(other.getConversationDialogId_zch_hwz_gjc()))
            && (this.getSendingTime_zch_hwz_gjc() == null ? other.getSendingTime_zch_hwz_gjc() == null : this.getSendingTime_zch_hwz_gjc().equals(other.getSendingTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChatId_zch_hwz_gjc() == null) ? 0 : getChatId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getMessageReceive_zch_hwz_gjc() == null) ? 0 : getMessageReceive_zch_hwz_gjc().hashCode());
        result = prime * result + ((getMessageContent_zch_hwz_gjc() == null) ? 0 : getMessageContent_zch_hwz_gjc().hashCode());
        result = prime * result + ((getMessageSender_zch_hwz_gjc() == null) ? 0 : getMessageSender_zch_hwz_gjc().hashCode());
        result = prime * result + ((getConversationDialogId_zch_hwz_gjc() == null) ? 0 : getConversationDialogId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getSendingTime_zch_hwz_gjc() == null) ? 0 : getSendingTime_zch_hwz_gjc().hashCode());
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
        sb.append(", chatId_zch_hwz_gjc=").append(chatId_zch_hwz_gjc);
        sb.append(", messageReceive_zch_hwz_gjc=").append(messageReceive_zch_hwz_gjc);
        sb.append(", messageContent_zch_hwz_gjc=").append(messageContent_zch_hwz_gjc);
        sb.append(", messageSender_zch_hwz_gjc=").append(messageSender_zch_hwz_gjc);
        sb.append(", conversationDialogId_zch_hwz_gjc=").append(conversationDialogId_zch_hwz_gjc);
        sb.append(", sendingTime_zch_hwz_gjc=").append(sendingTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}