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
    public partial class HomePage : System.Web.UI.Page
    {
        ShopThingBLL stb = new ShopThingBLL();
        public int index { get; set; }
        public int PageNumber { get; set; }
        public int PageCount { get; set; }
        public List<ShopThingModel> Shopthinglist { get; set; }
        public List<ShopImgUrl> Shopurllist = new List<ShopImgUrl>();
        public string UserId = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            int  PageSize = 30;
            int PageIndx;
            if(Request["PageIndx"]!=null)
            {
                PageIndx = Convert.ToInt32(Request["PageIndx"]);
            }
            else
            {
                PageIndx = 1;
            }
            if (Session["UserInfo"] != null)
            {
                string str = Session["UserInfo"].ToString();
                JavaScriptSerializer js = new JavaScriptSerializer();
                UserInfoModel u = js.Deserialize<UserInfoModel>(str);
                UserId = u.UserLoginId;
            }
            PageIndx = PageIndx < 1 ? 1 : PageIndx;
             PageCount = getpagecount(PageSize);
            PageIndx = PageIndx > PageCount ? PageCount : PageIndx;
           
            index = PageIndx;
            Shopthinglist = getshopthing(PageIndx,PageSize);
           
            foreach (ShopThingModel stm in Shopthinglist)
            {
                ShopImgUrl siu = new ShopImgUrl();
                string ThingId = stm.ThingId;
                siu.ThingId = ThingId;
                List<string> url = stb.SelectThingImgUrl(ThingId);
                siu.ImgUrl = url[0];
                Shopurllist.Add(siu);
            }
           
        }
        public List<ShopThingModel> getshopthing(int PageIndex,int PageSize)
        {
            if (UserId == null)
            {
                return stb.selectAllThing(PageIndex, PageSize);
            }
            else
            {
                return stb.selectAllThing(PageIndex, PageSize,UserId);
            }
            
        }
        public int getpagecount(int PageSize)
        {
            int pagenumber;
            if (UserId == null)
            {
              pagenumber= stb.selectAllThingCount();
            }
            else
            {
                pagenumber = stb.selectAllThingCount(UserId);
            }
            int pagecount = pagenumber / PageSize + 1;
            return pagecount;
        }
    }
}