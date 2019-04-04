using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using ThingToThingModel;
using System.Web.SessionState;
using Newtonsoft.Json;
using System.Web.Script.Serialization;

namespace ThingToThing.ashx
{
    /// <summary>
    /// PJAdd 的摘要说明
    /// </summary>
    public class PJAdd : IHttpHandler,IRequiresSessionState
    {
        ShopThingBLL stb = new ShopThingBLL();
        RegisteredBLL rb = new RegisteredBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string res = "";
            string ThingId = context.Request["ThingId"].ToString();
            if (context.Request["pjtxt"] != null)
            {
                string pjtxt = context.Request["pjtxt"].ToString();
                string str = context.Session["UserInfo"].ToString();
               
                UserInfoModel u = JsonConvert.DeserializeObject<UserInfoModel>(str);
                string UserId = u.UserLoginId;
                PingJiaModel p = new PingJiaModel();
                p.UserId = UserId;
                p.PingJiatxt = pjtxt;
                p.ThingId = ThingId;
                stb.PingJiaAdd(p);
                List<PingJiaModel> plist = stb.selectThingPingJia(ThingId);
                foreach(PingJiaModel pt in plist)
                {
                    if (pt.UserId == UserId)
                    {
                        pt.UserName = rb.SelectUserInfo(UserId).UserName;
                        //System.Web.Script.Serialization.JavaScriptSerializer json = new System.Web.Script.Serialization.JavaScriptSerializer();
                        JavaScriptSerializer json = new JavaScriptSerializer();
                        res = json.Serialize(pt);
                        //res = json.Serialize(pt);
                    }
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