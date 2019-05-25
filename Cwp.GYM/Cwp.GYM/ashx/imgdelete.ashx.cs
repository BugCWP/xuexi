using Cwp.BLL;
using Cwp.Model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace Cwp.GYM.ashx
{
    /// <summary>
    /// imgdelete 的摘要说明
    /// </summary>
    public class imgdelete : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            var id = context.Request["id"];
            if (id != null)
            {
                picturepath p = new picturepath();
                p.id = new Guid(id);
                picturepath p1 = new picturepathBLL().GetData<picturepath>(id);
                File.Delete(p1.path);
                new picturepathBLL().DeleteData<picturepath>(p);
            }
            context.Response.Write("Hello World");
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