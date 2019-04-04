using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using ThingToThingModel;

namespace ThingToThing.ashx
{
    /// <summary>
    /// UpdateShopThing 的摘要说明
    /// </summary>
    public class UpdateShopThing : IHttpHandler
    {
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string Id = context.Request["ThingId"].ToString();
            string name = context.Request["ThingName"].ToString();
            string type = context.Request["ThingType"].ToString();
            string introduction = context.Request["ThingIntroduction"].ToString();
            string res = "";
            ShopThingModel sm = new ShopThingModel();
            sm.ThingId = Id;
            sm.ThingName = name;
            sm.ThingType = type;
            sm.ThingIntroduction = introduction;
            if (stb.updateShopThing(sm))
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