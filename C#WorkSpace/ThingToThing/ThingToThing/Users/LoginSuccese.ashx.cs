using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingModel;
using Newtonsoft.Json;
using System.Web.SessionState;

namespace ThingToThing.Users
{
    /// <summary>
    /// LoginSuccese 的摘要说明
    /// </summary>
    public class LoginSuccese : IHttpHandler,IRequiresSessionState
    {

        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string str = "";
            if (context.Session["UserInfo"] != null)
            {
                str = context.Session["UserInfo"].ToString();
            }
            context.Response.Write(str);
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