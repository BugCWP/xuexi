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
    @Column(name = "community_adress")
    private String communityAdress;
    @Column(name = "community_introduction")
    private String communityIntroduction;
    @Column(name = "community_picture")
    private String communityPicture;
    @Column(name = "community_delete")
    private int communityDelete;

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

    public String getCommunityAdress() {
        return communityAdress;
    }

    public void setCommunityAdress(String communityAdress) {
        this.communityAdress = communityAdress;
    }

    public String getCommunityIntroduction() {
        return communityIntroduction;
    }

    public void setCommunityIntroduction(String communityIntroduction) {
        this.communityIntroduction = communityIntroduction;
    }

    public String getCommunityPicture() {
        return communityPicture;
    }

    public void setCommunityPicture(String communityPicture) {
        this.communityPicture = communityPicture;
    }

    public int getCommunityDelete() {
        return communityDelete;
    }

    public void setCommunityDelete(int communityDelete) {
        this.communityDelete = communityDelete;
    }
}
