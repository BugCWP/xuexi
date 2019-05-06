using Cwp.BLL;
using Cwp.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Cwp.GYM.ashx
{
    /// <summary>
    /// imgdown 的摘要说明
    /// </summary>
    public class imgdown : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            var code = context.Request["code"];
            List<picturepath> picturepaths = new picturepathBLL().getALLPicturePathList(code);

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