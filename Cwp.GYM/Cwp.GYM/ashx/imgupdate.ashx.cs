using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;

namespace Cwp.GYM.ashx
{
    /// <summary>
    /// imgupdate 的摘要说明
    /// </summary>
    public class imgupdate : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            context.Response.StatusCode = (int)HttpStatusCode.OK;
            context.Response.Write("Hello World");
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