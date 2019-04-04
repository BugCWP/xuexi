using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using ThingToThingBLL;
using ThingToThingModel;
using System.Web.Script.Serialization;

namespace ThingToThing.Views
{
    public partial class MyOrder : System.Web.UI.Page
    {
        ShopCharBLL scb = new ShopCharBLL();
        ShopThingBLL stb = new ShopThingBLL();
        public List<ShopCharModel> scmlist = new List<ShopCharModel>();
        public List<ShopOrderModel> somlist = new List<ShopOrderModel>();
        public List<ShopThingModel> stlist = new List<ShopThingModel>();
        //public List<ShopImgUrl> siu = new List<ShopImgUrl>();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["UserInfo"] != null)
            {
                string str = Session["UserInfo"].ToString();
                JavaScriptSerializer js = new JavaScriptSerializer();
                UserInfoModel u = js.Deserialize<UserInfoModel>(str);
                string UserId = u.UserLoginId;
                scmlist = scb.selectShopChar(UserId);
                List<string> mythingidlist = scb.selectShopCharmyThing(UserId);
                foreach(string mythingid in mythingidlist)
                {
                    ShopOrderModel som = new ShopOrderModel();
                    som.MyThing = stb.selectShopThingInformation(mythingid);
                    som.MyThing.ThingfirstimgUrl = stb.SelectThingImgUrl(mythingid)[0];
                    som.MyThing.ThingId = mythingid;
                    List<ShopThingModel> changehinglist = new List<ShopThingModel>();
                    foreach(ShopCharModel scm in scmlist)
                    {
                        if (scm.MyThingId == mythingid)
                        {
                            ShopThingModel changething = stb.selectShopThingInformation(scm.ChangeThingId);
                            changething.ThingfirstimgUrl = stb.SelectThingImgUrl(scm.ChangeThingId)[0];
                            changething.ThingId = scm.ChangeThingId;
                            changehinglist.Add(changething);
                        }
                    }
                    som.ChangeThing = changehinglist;
                    somlist.Add(som);
                }
                List<string> overThhingid = scb.selectShopCharmyThingdelect(UserId);
                foreach(string overid in overThhingid)
                {
                    ShopThingModel st = stb.selectShopThingInformation(overid);
                    string url = stb.SelectThingImgUrl(overid)[0];
                    st.ThingfirstimgUrl = url;
                    stlist.Add(st);

                }
            }
            //List<ShopThingModel> thinglist = stb.selectAllThing(1, stb.selectAllThingCount());
            //foreach(ShopThingModel s in thinglist)
            //{
            //    ShopImgUrl su = new ShopImgUrl();
            //    su.ThingId = s.ThingId;
            //    su.ImgUrl = stb.SelectThingImgUrl(s.ThingId)[0];
            //    siu.Add(su);
            //}
        }
    }
}