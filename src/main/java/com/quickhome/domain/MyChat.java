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
 * @TableName tab_myChat_zch_hwz_gjc
 */
@TableName(value ="tab_myChat_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyChat implements Serializable {
    /**
     * 
     */
    @TableId(value = "chatId_zch_hwz_gjc", type = IdType.AUTO)
    private Long chatId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "messageReceive_zch_hwz_gjc")
    private Long messageReceive_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "messageContent_zch_hwz_gjc")
    private String messageContent_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "messageSender_zch_hwz_gjc")
    private Long messageSender_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "conversationDialogId_zch_hwz_gjc")
    private Long conversationDialogId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "sendingTime_zch_hwz_gjc")
    private Date sendingTime_zch_hwz_gjc;

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
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
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
        result = prime * result + ((getVisible_zch_hwz_gjc() == null) ? 0 : getVisible_zch_hwz_gjc().hashCode());
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
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}