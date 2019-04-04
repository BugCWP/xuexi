using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using ThingToThingModel;
using ThingToThingCommon;
using Newtonsoft.Json;
using System.Web.SessionState;


namespace ThingToThing.Users
{
    /// <summary>
    /// Login 的摘要说明
    /// </summary>
    public class Login : IHttpHandler,IRequiresSessionState
    {

        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string id= context.Request.Form["Id"].ToString();
            string pwd = context.Request.Form["pwd"].ToString();
            string res = "0";
            string pwd2 = "";
            RegisteredBLL rb = new RegisteredBLL();
            MD5Str md = new MD5Str();
            if (!rb.ConfimUserId(id))
            {
                rb.ConfimUserPwd(id, out pwd2);
                if (pwd2 == md.MD5(pwd))
                {
                    //登陆成功
                    res = "2";
                    UserInfoModel user=rb.SelectUserInfo(id);
                    string str = JsonConvert.SerializeObject(user);
                    context.Session["UserInfo"] =str;
                    //HttpCookie cookie = new HttpCookie("LoginUser");
                    ////cookie.Values["Id"] = user.UserLoginId;
                    ////cookie.Values["name"] = user.UserName;
                    ////cookie.Values["pwd"] = user.UserPwd;
                    ////cookie.Values["email"] = user.UserEmail;
                    ////cookie.Values["phone"] = user.UserPhone;
                    ////cookie.Values["adress"] = user.UserAdress;
                    //string str = JsonConvert.SerializeObject(user);
                    //cookie.Value = str;
                    //DateTime now = DateTime.Now;
                    //TimeSpan span = new TimeSpan(1, 0, 0, 0);
                    //cookie.Expires = now + span;
                    //context.Response.Cookies.Add(cookie);
                }
                else
                {
                    //密码错误
                    res = "3";
                }
            }
            else
            {
                //用户名不存在
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