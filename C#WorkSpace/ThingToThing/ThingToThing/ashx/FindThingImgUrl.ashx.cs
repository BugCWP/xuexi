using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using Newtonsoft.Json;

namespace ThingToThing.ashx
{
    /// <summary>
    /// FindThingImgUrl 的摘要说明
    /// </summary>
    public class FindThingImgUrl : IHttpHandler
    {
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string res = "";
            if (context.Request["ThingId"] != null)
            {
                string ThingId = context.Request["ThingId"].ToString();
                List<string> list= stb.SelectThingImgUrl(ThingId);
                res = JsonConvert.SerializeObject(list);
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