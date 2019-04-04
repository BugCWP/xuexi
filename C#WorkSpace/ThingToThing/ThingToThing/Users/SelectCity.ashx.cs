using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using ThingToThingModel;
using Newtonsoft.Json;

namespace ThingToThing.Users
{
    /// <summary>
    /// SelectCity 的摘要说明
    /// </summary>
    public class SelectCity : IHttpHandler
    {
        RegisteredBLL rb = new RegisteredBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string porvince= context.Request["porvince"].ToString();
            List<ProvinceModel> listpm=  rb.SelectCityBLL(porvince);
           
            context.Response.Write(JsonConvert.SerializeObject(listpm));
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