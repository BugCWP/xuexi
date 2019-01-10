package com.cwp.action;

import com.cwp.entity.Announcement;
import com.cwp.entity.Picture;
import com.cwp.entity.Resident;
import com.cwp.service.AnnouncementService;
import com.cwp.service.CommentService;
import com.cwp.service.PictureService;
import com.cwp.service.ResidentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ParentPackage("struts-default")
@Namespace("/announcementpicture")
public class AnnouncementPictureAction extends ActionSupport{
    private File upload;
    private String uploadFileName;
    private String announcementTitle;
    private String announcementTable;

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public void setAnnouncementTable(String announcementTable) {
        this.announcementTable = announcementTable;
    }

    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private ResidentService residentService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private CommentService commentService;

    @Action(value = "addannouncement",results = {@Result(name = "success",type = "redirect",location = "/Home.jsp")})
    public String addAnnouncement() throws IOException {
        String realpath = ServletActionContext.getServletContext().getRealPath("/image/announcement");
        HttpSession session = ServletActionContext.getRequest().getSession();
        Resident user = (Resident) session.getAttribute("user");
        Long id = user.getResidentId();
        String newtime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        String newfilename = newtime + "_" + uploadFileName;
        String newnumber = "announemence_"+newtime+ id.toString();
        String newUrl = "/image/announcement/" + newfilename;
        if (upload != null) {
            File savefile = new File(realpath, newfilename);
            if (!savefile.getParentFile().exists()) {
                savefile.getParentFile().mkdirs();
            }
            FileUtils.copyFile(upload,savefile);
            Announcement a=new Announcement();
            a.setAnnouncementTitle(announcementTitle);
            a.setAnnouncementPersion(id);
            a.setAnnouncementTime(newtime);
            a.setAnnouncementTable(announcementTable);
            a.setAnnouncementPicture(newnumber);
            announcementService.addAnnouncement(a);
            Picture p=new Picture();
            p.setPictureNumber(newnumber);
            p.setPictureUrl(newUrl);
            p.setPictureTime(newtime);
            pictureService.addPicture(p);
        }
        return SUCCESS;
    }

}
