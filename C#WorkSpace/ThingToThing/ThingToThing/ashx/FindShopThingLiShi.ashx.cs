using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Newtonsoft.Json;
using ThingToThingModel;
using ThingToThingBLL;
using System.Web.SessionState;

namespace ThingToThing.ashx
{
    /// <summary>
    /// FindShopThingLiShi 的摘要说明
    /// </summary>
    public class FindShopThingLiShi : IHttpHandler,IRequiresSessionState
    {
        ShopThingBLL stb = new ShopThingBLL();

        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            if (context.Session["UserInfo"] != null)
            {
                string str = context.Session["UserInfo"].ToString();
                UserInfoModel user = JsonConvert.DeserializeObject<UserInfoModel>(str);
                string id = user.UserLoginId;
                List<ShopThingModel> list = stb.SelectShopThingLiShi(id);
                string res = JsonConvert.SerializeObject(list);
                context.Response.Write(res);
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