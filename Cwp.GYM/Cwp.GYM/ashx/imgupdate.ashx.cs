using Cwp.BLL;
using Cwp.Common.CodeCommon;
using Cwp.Model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Web;

namespace Cwp.GYM.ashx
{
    /// <summary>
    /// imgupdate 的摘要说明
    /// </summary>
    public class imgupdate : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            var pfile = context.Request.Files["file"];
            string imgBaseStr = "";
            var data = context.Request.Form["data"];
            MyTool mytool = new MyTool();
            if (pfile != null)
            {
                string newfilename = mytool.GetMD5(pfile.InputStream) +Guid.NewGuid() + Path.GetExtension(pfile.FileName);
                string newpath = context.Request.MapPath("/images/") + DateTime.Now.ToString("yyyyMMdd");
                mytool.CreateDirectory(newpath);
                string path = Path.Combine(newpath, newfilename);
                picturepath pp = new picturepath();
                pp.name = newfilename;
                pp.path = path;
                pp.code =new Guid(data.Replace("\"",""));
                string result = new picturepathBLL().CreateData<picturepath>(pp);
                pfile.SaveAs(path);
            }
            context.Response.Write(imgBaseStr);
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