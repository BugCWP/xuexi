using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using ThingToThingModel;
using System.Web.SessionState;
using Newtonsoft.Json;

namespace ThingToThing.ashx
{
    /// <summary>
    /// ShopThingAdd 的摘要说明
    /// </summary>
    public class ShopThingAdd : IHttpHandler,IRequiresSessionState
    {
        ShopThingBLL stb = new ShopThingBLL();
        ShopThingModel sm = new ShopThingModel();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string res = "";
            sm.ThingName = context.Request["ThingName"].ToString();
            sm.ThingType = context.Request["ThingType"].ToString();
            sm.ThingId = context.Request["ThingId"].ToString();
            if (context.Session["UserInfo"] != null)
            {
                string str = context.Session["UserInfo"].ToString();
                UserInfoModel u = JsonConvert.DeserializeObject<UserInfoModel>(str);
                sm.UserId = u.UserLoginId;
                sm.ThingIntroduction = context.Request["ThingIntroduction"];
                if (stb.AddShopThing(sm))
                {
                    res = "1";
                }
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