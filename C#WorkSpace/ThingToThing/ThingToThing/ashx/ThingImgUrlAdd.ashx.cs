using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using ThingToThingModel;
using System.Web.SessionState;
using Newtonsoft.Json;
using System.IO;
using ThingToThingCommon;

namespace ThingToThing.ashx
{
    /// <summary>
    /// ThingImgUrlAdd 的摘要说明
    /// </summary>
    public class ThingImgUrlAdd : IHttpHandler,IRequiresSessionState
    {
        ShopThingBLL stb = new ShopThingBLL();
        MyTool mytool = new MyTool();
        public void ProcessRequest(HttpContext context)
        {
            
            context.Response.ContentType = "text/plain";
            string res = "";
            string ThingId = context.Request["ThingId"].ToString();
            string ThingName = context.Request["ThingName"].ToString();
            HttpPostedFile pfile = context.Request.Files["file"];
            ShopImgUrl siu = new ShopImgUrl();
            siu.ThingId = ThingId;
            string str = context.Session["UserInfo"].ToString();
            UserInfoModel u = JsonConvert.DeserializeObject<UserInfoModel>(str);
            string UserId = u.UserLoginId;
            string newfilename = mytool.GetMD5(pfile.InputStream) + Path.GetExtension(pfile.FileName);
            string newpath = context.Request.MapPath("/images/" + UserId + "/") + DateTime.Now.ToString("yyyyMMdd");
            mytool.CreateDirectory(newpath);
            string path = Path.Combine(newpath, newfilename);
            pfile.SaveAs(path);
            string imgUrl = "../Images/" + UserId + "/" + DateTime.Now.ToString("yyyMMdd") + "/"+newfilename+"";
            siu.ImgUrl = imgUrl;
            if (stb.AddimgUrl(siu))
            {
                res = "1";
            }
            context.Response.Write(res);
        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }
    }
}