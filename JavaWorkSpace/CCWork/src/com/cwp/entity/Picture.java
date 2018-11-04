package com.cwp.entity;

import javax.persistence.*;
import java.io.Serializable;

/*
*图片表
 */
@Entity
@Table(name = "picture_table")
public class Picture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_id")
    private Long pictureId;
    @Column(name = "picture_number")
    private String pictureNumber;
    @Column(name = "picture_url")
    private String pictureUrl;
    @Column(name = "picture_time")
    private String pictureTime;
    @Column(name = "picture_delete")
    private int pictureDelete;

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureNumber() {
        return pictureNumber;
    }

    public void setPictureNumber(String pictureNumber) {
        this.pictureNumber = pictureNumber;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureTime() {
        return pictureTime;
    }

    public void setPictureTime(String pictureTime) {
        this.pictureTime = pictureTime;
    }

    public int getPictureDelete() {
        return pictureDelete;
    }

    public void setPictureDelete(int pictureDelete) {
        this.pictureDelete = pictureDelete;
    }
}
