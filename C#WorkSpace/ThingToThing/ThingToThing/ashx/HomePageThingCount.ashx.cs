using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;

namespace ThingToThing.ashx
{
    /// <summary>
    /// HomePageThingCount 的摘要说明
    /// </summary>
    public class HomePageThingCount : IHttpHandler
    {
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            int res = stb.selectAllThingCount();
            string str = res.ToString();
            context.Response.Write(str);
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