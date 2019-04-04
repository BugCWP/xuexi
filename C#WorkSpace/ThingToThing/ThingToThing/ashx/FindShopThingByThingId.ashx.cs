using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using Newtonsoft.Json;
using ThingToThingModel;

namespace ThingToThing.ashx
{
    /// <summary>
    /// FindShopThingByThingId 的摘要说明
    /// </summary>
    public class FindShopThingByThingId : IHttpHandler
    {
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            ShopThingModel sm = new ShopThingModel();
            if (context.Request["ThingId"] != null)
            {
                var ThingId = context.Request["ThingId"].ToString();
                sm = stb.selectShopThingInformation(ThingId);
            }
            string res = JsonConvert.SerializeObject(sm);
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