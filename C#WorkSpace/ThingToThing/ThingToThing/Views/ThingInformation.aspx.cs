using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using ThingToThingBLL;
using ThingToThingModel;

namespace ThingToThing.Views
{
    public partial class ThingInformation : System.Web.UI.Page
    {
        public ShopThingModel stm = new ShopThingModel();
        public UserInfoModel uim = new UserInfoModel();
        public ShopImgUrlqu siuq = new ShopImgUrlqu();
        public List<PingJiaModel> listp = new List<PingJiaModel>();
        public string UserId = null;
        ShopThingBLL stb = new ShopThingBLL();
        RegisteredBLL rb = new RegisteredBLL();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Request["ThingId"] != null)
            {
                string ThingId = Request["ThingId"].ToString();
                stm = stb.selectShopThingInformation(ThingId);
                stm.ThingId = ThingId;
                string UserId = stm.UserId;
                uim = rb.SelectUserInfo(UserId);
                siuq.ImgUrl = stb.SelectThingImgUrl(ThingId);
                List<PingJiaModel> listpj = stb.selectThingPingJia(ThingId);
                foreach(PingJiaModel p in listpj)
                {
                    p.UserName = rb.SelectUserInfo(p.UserId).UserName;
                    listp.Add(p);
                }
            }
            if (Request["UserId"] != null)
            {
               UserId = Request["UserId"].ToString();
            }
            
        }
    }
}