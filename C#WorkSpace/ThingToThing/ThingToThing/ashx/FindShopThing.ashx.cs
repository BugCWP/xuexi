using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.SessionState;
using Newtonsoft.Json;
using ThingToThingModel;
using ThingToThingBLL;

namespace ThingToThing.ashx
{
    /// <summary>
    /// FindShopThing 的摘要说明
    /// </summary>
    public class FindShopThing : IHttpHandler,IRequiresSessionState
    {
        UserInfoModel user;
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            if (context.Request["ThingId"] != null)
            {
                string id = context.Request["ThingId"].ToString();
                ShopImgUrlqu siuq = new ShopImgUrlqu();
                siuq.ImgUrl = stb.SelectThingImgUrl(id);
                siuq.ThingId = id;
                string res = JsonConvert.SerializeObject(siuq);
                context.Response.Write(res);
            }
            else
            {
                string res = "";
                if (context.Session["UserInfo"] != null)
                {
                    string str = context.Session["UserInfo"].ToString();
                    int pageIndex = Convert.ToInt32(context.Request["pageIndex"]);
                    int pageSize = Convert.ToInt32(context.Request["pageSize"]);
                    user = JsonConvert.DeserializeObject<UserInfoModel>(str);
                    string id = user.UserLoginId;
                    List<ShopThingModel> listSTM = stb.SelectShopThing(id,pageIndex,pageSize);
                    res = JsonConvert.SerializeObject(listSTM);
                }
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