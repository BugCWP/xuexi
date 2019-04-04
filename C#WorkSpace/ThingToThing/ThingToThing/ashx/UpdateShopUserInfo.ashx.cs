using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using ThingToThingModel;
using ThingToThingCommon;

namespace ThingToThing.ashx
{
    /// <summary>
    /// UpdateShopUserInfo 的摘要说明
    /// </summary>
    public class UpdateShopUserInfo : IHttpHandler
    {
        RegisteredBLL rb = new RegisteredBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            UserInfoModel um = new UserInfoModel();
            MD5Str md5 = new MD5Str();
            string res = "";
            um.UserLoginId = context.Request["id"];
            um.UserName = context.Request["name"];
            um.UserPwd = md5.MD5(context.Request["pwd"].ToString());
            um.UserPhone = context.Request["phone"];
            um.UserEmail = context.Request["email"];
            um.UserAdress = context.Request["adress"];
            if (rb.ChangeUserInfo(um))
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