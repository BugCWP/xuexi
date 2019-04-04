using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;

namespace ThingToThing.ashx
{
    /// <summary>
    /// DelectThingImg 的摘要说明
    /// </summary>
    public class DelectThingImg : IHttpHandler
    {
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string res = "";
            string url = context.Request["url"].ToString();
            string id = context.Request["id"].ToString();
            if (stb.delectThingImgUrl(id, url))
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