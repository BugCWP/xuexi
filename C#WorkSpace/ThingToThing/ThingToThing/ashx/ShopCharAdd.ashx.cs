using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using ThingToThingModel;
using Newtonsoft.Json;
using System.Web.SessionState;


namespace ThingToThing.ashx
{
    /// <summary>
    /// ShopCharAdd 的摘要说明
    /// </summary>
    public class ShopCharAdd : IHttpHandler,IRequiresSessionState
    {
        ShopCharBLL scb = new ShopCharBLL();
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string res = "";
            string myid = context.Request["myid"].ToString();
            string changeid = context.Request["changeid"].ToString();
            if (context.Session["UserInfo"] != null)
            {
                string str = context.Session["UserInfo"].ToString();
                UserInfoModel u = JsonConvert.DeserializeObject<UserInfoModel>(str);
                string Userid = u.UserLoginId;
                ShopThingModel cst = stb.selectShopThingInformation(myid);
                string HUserid = cst.UserId;
                if (scb.ShopCharThingAdd(myid, changeid,Userid ,HUserid))
                {
                    if (stb.DelectShopThing(myid))
                    {
                       res = "1";
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