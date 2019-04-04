using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;

namespace ThingToThing.Users
{
    /// <summary>
    /// ConfimUserId 的摘要说明
    /// </summary>
    public class ConfimUserId : IHttpHandler
    {
        RegisteredBLL rb = new RegisteredBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";

            string id= context.Request.QueryString["Id"].ToString();
            string res = "0";
            if (rb.ConfimUserId(id))
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