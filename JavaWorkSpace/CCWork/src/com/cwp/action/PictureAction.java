package com.cwp.action;

import com.cwp.entity.Picture;
import com.cwp.entity.Resident;
import com.cwp.service.PictureService;
import com.cwp.service.ResidentService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ParentPackage("struts-default")
@Namespace("/picture")
public class PictureAction extends ActionSupport {
    private File upload;
    private String uploadFileName;
    private String uploadContentType;

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    @Autowired
    private ResidentService residentService;
    @Autowired
    private PictureService pictureService;

    @Action(value = "uploadpersonalpicture")
    public void uploadPersonalPicture() throws IOException {
        String realpath = ServletActionContext.getServletContext().getRealPath("/image/resident");
        HttpSession session = ServletActionContext.getRequest().getSession();
        Resident user = (Resident) session.getAttribute("user");
        Long id = user.getResidentId();
        String newtime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String newfilename = newtime + "_" + uploadFileName;
        String newnumber = "resident_" + id.toString();
        String newUrl = "/image/resident/" + newfilename;
        if (upload != null) {
            File savefile = new File(realpath, newfilename);
            if (!savefile.getParentFile().exists()) {
                savefile.getParentFile().mkdirs();
            }
            FileUtils.copyFile(upload, savefile);
            Resident r1 = new Resident();
            r1.setResidentId(id);
            Resident r2 = residentService.findResident(r1);
            r2.setResidentAvatar(newnumber);
            residentService.updateResident(r2);
            Picture p = new Picture();
            p.setPictureNumber(newnumber);
            p.setPictureTime(newtime);
            p.setPictureUrl(newUrl);
            pictureService.addPicture(p);
        }
    }
}