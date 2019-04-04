using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.SessionState;
using Newtonsoft.Json;
using ThingToThingModel;

namespace ThingToThing.Views
{
    public partial class MyShop : System.Web.UI.Page
    {
        public string UName { get; set; }
        public string UPwd { get; set; }
        public string UPhone { get; set; }
        public string UEmail { get; set; }
        public string UAdress { get; set; }
        public string UId { get; set; }
        protected void Page_Load(object sender, EventArgs e)
        {
            ChangeUserInfo();
        }
        public void ChangeUserInfo()
        {
            if (Session["UserInfo"] != null)
            {
                string str = Session["UserInfo"].ToString();
                UserInfoModel um = JsonConvert.DeserializeObject<UserInfoModel>(str);
                UName = um.UserName;
                UPwd = um.UserPwd;
                UPhone = um.UserPhone;
                UEmail = um.UserEmail;
                UAdress = um.UserAdress;
                UId = um.UserLoginId;
            }
        }
    }
}