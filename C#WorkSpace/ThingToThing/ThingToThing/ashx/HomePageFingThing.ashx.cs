using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Newtonsoft.Json;
using System.Web.SessionState;
using ThingToThingBLL;
using ThingToThingModel;

namespace ThingToThing.ashx
{
    /// <summary>
    /// HomePageFingThing 的摘要说明
    /// </summary>
    public class HomePageFingThing : IHttpHandler,IRequiresSessionState
    {

        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            int pageIndex = Convert.ToInt32(context.Request["pageIndex"]);
            int pageSize = Convert.ToInt32(context.Request["pageSize"]);
            List<ShopThingModel> list= stb.selectAllThing(pageIndex,pageSize);
            string res = JsonConvert.SerializeObject(list);
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