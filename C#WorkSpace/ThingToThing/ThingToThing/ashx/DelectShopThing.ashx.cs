using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;

namespace ThingToThing.ashx
{
    /// <summary>
    /// DelectShopThing 的摘要说明
    /// </summary>
    public class DelectShopThing : IHttpHandler
    {
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string res = "";
            string ThingId = context.Request["ThingId"];
            if (stb.DelectShopThing(ThingId))
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