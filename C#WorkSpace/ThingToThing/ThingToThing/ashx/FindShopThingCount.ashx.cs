using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using System.Web.SessionState;
using Newtonsoft.Json;

namespace ThingToThing.ashx
{
    /// <summary>
    /// FindShopThingCount 的摘要说明
    /// </summary>
    public class FindShopThingCount : IHttpHandler,IRequiresSessionState
    {
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            string count;
            context.Response.ContentType = "text/plain";
            if (context.Session["UserInfo"] != null)
            {
                string id = context.Request["UserId"].ToString();
                count= stb.selectShopThingcount(id);
                context.Response.Write(count);
            }
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