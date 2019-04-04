using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using Newtonsoft.Json;

namespace ThingToThing.ashx
{
    /// <summary>
    /// FingShopThingType 的摘要说明
    /// </summary>
    public class FingShopThingType : IHttpHandler
    {
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            List<string> type = stb.selectShopThingType();
            string res = JsonConvert.SerializeObject(type);
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