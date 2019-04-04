using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ThingToThingBLL;
using ThingToThingModel;

namespace ThingToThing.ashx
{
    /// <summary>
    /// DelectShopChar 的摘要说明
    /// </summary>
    public class DelectShopChar : IHttpHandler
    {
        ShopCharBLL scb = new ShopCharBLL();
        ShopThingBLL stb = new ShopThingBLL();
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            string res = "";
            ShopCharModel sc = new ShopCharModel();
            sc.MyThingId= context.Request["myid"].ToString();
            sc.ChangeThingId = context.Request["changeid"].ToString();
            if (scb.updateshopchar(sc))
            {
               List<string> list= scb.selectOtherThing(sc);
                scb.deleteOtherThing(sc);
                stb.DelectShopThing(sc.MyThingId);
                foreach(string cid in list)
                {
                    scb.addOtherThing(cid);
                    
                }
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