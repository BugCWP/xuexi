using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using ThingToThingBLL;
using ThingToThingModel;
using Newtonsoft.Json;

namespace ThingToThing.Views
{
    public partial class MyChar : System.Web.UI.Page
    {
        public List<ShopThingModel> shopthing = new List<ShopThingModel>();
        public List<ShopImgUrl> shopimgurl = new List<ShopImgUrl>();
        public List<ShopCharModel> shopchar = new List<ShopCharModel>();
        public List<ShopCharModel> scmlist = new List<ShopCharModel>();
        public List<ShopCharThingChangeModel> shopcharthingchange = new List<ShopCharThingChangeModel>();
        public List<ShopCharThingChangeModel> shopcharthingchangeover = new List<ShopCharThingChangeModel>();
        public ShopThingModel byshop = new ShopThingModel();
        public ShopImgUrl byimg = new ShopImgUrl();
        ShopThingBLL stb = new ShopThingBLL();
        ShopCharBLL scb = new ShopCharBLL();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["UserInfo"] != null)
            {
                string str = Session["UserInfo"].ToString();
                UserInfoModel u = JsonConvert.DeserializeObject<UserInfoModel>(str);
                string UserId = u.UserLoginId;
                getshopThing(UserId);
                getShopChar(UserId);
                getShopCharover(UserId);
            }
            if (Request["ThingId"] != null)
            {
                string byThingId = Request["ThingId"].ToString();
                getbyshopThing(byThingId);
                
            }
            else
            {
                byimg.ImgUrl = "../Images/start.png";
            }
        }
        public void getshopThing(string Userid)
        {
            string count = stb.selectShopThingcount(Userid);
            int pagesize = Convert.ToInt32(count);
            shopthing = stb.SelectShopThing(Userid, 1, pagesize);
            foreach(ShopThingModel st in shopthing)
            {
                getshopThingimg(st.ThingId);
            }
        }
        public void getshopThingimg(string Thingid)
        {
            List<string> list = stb.SelectThingImgUrl(Thingid);
            ShopImgUrl siu = new ShopImgUrl();
            siu.ThingId = Thingid;
            siu.ImgUrl = list[0];
            shopimgurl.Add(siu);
        }

        public void getbyshopThing(string thingid)
        {
            int count = stb.selectAllThingCount();
            List<ShopThingModel> slist = stb.selectAllThing(1, count);
            foreach(ShopThingModel s in slist)
            {
                if (s.ThingId == thingid)
                {
                    byshop = s;
                    List<string> list = stb.SelectThingImgUrl(s.ThingId);
                    byimg.ImgUrl = list[0];
                    byshop.ThingId = s.ThingId;
                }
            }
        }

        public void getShopChar(string Userid)
        {
            shopchar = scb.selectShopCharbychar(Userid);
            foreach(ShopCharModel scm in shopchar)
            {
                ShopThingModel myshopthing = stb.selectShopThingInformation(scm.MyThingId);
                ShopThingModel changeshopthing = stb.selectShopThingInformation(scm.ChangeThingId);
                string  myurl= stb.SelectThingImgUrl(scm.MyThingId)[0];
                string changeurl = stb.SelectThingImgUrl(scm.ChangeThingId)[0];
                ShopCharThingChangeModel list = new ShopCharThingChangeModel();
                list.myshopThing = myshopthing;
                list.changeshopThing = changeshopthing;
                list.myshopUrl = myurl;
                list.changeshopUrl = changeurl;
                shopcharthingchange.Add(list);
            }
        }
        public void getShopCharover(string Userid)
        {
            scmlist = scb.selectShopCharOver(Userid);
            foreach(ShopCharModel scm in scmlist)
            {
                ShopThingModel myshopthing = stb.selectShopThingInformation(scm.MyThingId);
                ShopThingModel changeshopthing = stb.selectShopThingInformation(scm.ChangeThingId);
                string myurl = stb.SelectThingImgUrl(scm.MyThingId)[0];
                string changeurl = stb.SelectThingImgUrl(scm.ChangeThingId)[0];
                ShopCharThingChangeModel list = new ShopCharThingChangeModel();
                list.myshopThing = myshopthing;
                list.changeshopThing = changeshopthing;
                list.myshopUrl = myurl;
                list.changeshopUrl = changeurl;
                shopcharthingchangeover.Add(list);
            }
        }
    }
}