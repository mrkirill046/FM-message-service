package com.qwy_games.fllaf_messenger.messageservice.database.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "messages")
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sender_id")
    private Integer senderId;

    @Column(name = "receiver_id")
    private Integer receiverId;

    @Column(name = "content", nullable = false)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sent_at", nullable = false, updatable = false)
    private Date sentAt;

    @Column(name = "is_group")
    private Boolean isGroup;

    @Column(name = "is_channel")
    private Boolean isChannel;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "channel_id")
    private Integer channelId;

    @PrePersist
    protected void onCreate() {
        this.sentAt = new Date();
    }
}
