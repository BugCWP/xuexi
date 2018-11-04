package com.cwp.entity;


import javax.persistence.*;
import java.io.Serializable;
/*
*社区表
 */
@Entity
@Table(name = "community_table")
public class Community implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_id")
    private Long communityId;
    @Column(name = "community_name")
    private String communityName;
    @Column(name = "commnity_adress")
    private String commnityAdress;
    @Column(name = "commnity_introduction")
    private String commnityIntroduction;
    @Column(name = "commnity_delete")
    private int commnityDelete;

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommnityAdress() {
        return commnityAdress;
    }

    public void setCommnityAdress(String commnityAdress) {
        this.commnityAdress = commnityAdress;
    }

    public String getCommnityIntroduction() {
        return commnityIntroduction;
    }

    public void setCommnityIntroduction(String commnityIntroduction) {
        this.commnityIntroduction = commnityIntroduction;
    }

    public int getCommnityDelete() {
        return commnityDelete;
    }

    public void setCommnityDelete(int commnityDelete) {
        this.commnityDelete = commnityDelete;
    }
}
