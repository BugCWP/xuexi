using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.SessionState;

namespace ThingToThing.ashx
{
    /// <summary>
    /// MyShopYanZheng 的摘要说明
    /// </summary>
    public class MyShopYanZheng : IHttpHandler,IRequiresSessionState
    {

        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
           
            string res = "";
            if (context.Session["UserInfo"] != null)
            {
                res = "2";
            }
            else
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