using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using ThingToThingModel;
using ThingToThingBLL;
using ThingToThingCommon;


namespace ThingToThing.Users
{
    public partial class Register : System.Web.UI.Page
    {
        public string Res { get; set; }
        public string UserLoginId { get; set; }
        public string UserName { get; set; }
        public string UserPwdOne { get; set; }
        public string UserPwdTwo { get; set; }
        public string UserEmail { get; set; }
        public string UserPhone { get; set; }
        protected void Page_Load(object sender, EventArgs e)
        {
            GetProvince();
            if (IsPostBack)
            {
                AddUserInfo();

            }
            else
            {

            }
        }
        RegisteredBLL rb = new RegisteredBLL();
        MD5Str md = new MD5Str();
        RegularExpressions re = new RegularExpressions();
        public List<ProvinceModel> listProvince { get; set; }
        public void GetProvince()
        {
            listProvince = rb.SelectProvinceBLL();
        }
        public void AddUserInfo()
        {
            Res = "";
            string LoginId = Request.Form["UserLoginId"];
            string name = Request.Form["UserName"];
            string pwdone = Request.Form["UserPwdOne"];
            string pwdtwo = Request.Form["UserPwdTwo"];
            string email = Request.Form["UserEmail"];
            string phone = Request.Form["UserPhone"];
            string adressporvince = Request.Form["UserAdressProvince"];
            string adresscity = Request.Form["UserAdressCity"];
            string adressDetailed = Request.Form["UserAdressDetailed"];
            string adress = adressporvince + adresscity + adressDetailed;
            string IdHidden = Request.Form["IdHidden"];
            UserInfoModel uim = new UserInfoModel();
            if (LoginId == "")
            {
                Res = "请输入账号";
            }
            else
            {
                if (IdHidden == "1")
                {


                    uim.UserLoginId = LoginId;
                    UserLoginId = LoginId;
                    if (name == "")
                    {
                        Res = "请输入姓名";
                    }
                    else
                    {
                        uim.UserName = name;
                        UserName = name;
                        if (pwdone == "")
                        {
                            Res = "亲输入密码";
                        }
                        else
                        {
                            if (pwdtwo != "")
                            {
                                UserPwdTwo = pwdtwo;
                                if (pwdone != pwdtwo)
                                {
                                    Res = "验证密码不正确";
                                }
                                else
                                {
                                    uim.UserPwd = md.MD5(pwdone);
                                    UserPwdOne = pwdone;
                                    if (email == "")
                                    {
                                        Res = "请输入邮箱";
                                    }
                                    else
                                    {
                                        if (re.IsEmail(email))
                                        {
                                            uim.UserEmail = email;
                                            UserEmail = email;
                                            if (phone == "")
                                            {
                                                Res = "请输入电话";
                                            }
                                            else
                                            {
                                                if (re.IsPhone(phone))
                                                {
                                                    uim.UserPhone = phone;
                                                    UserPhone = phone;
                                                    if (adressporvince == "省" || adresscity == "市" || adressDetailed == "")
                                                    {
                                                        Res = "请输入正确地址";
                                                    }
                                                    else
                                                    {
                                                        uim.UserAdress = adress;

                                                        if (rb.AddUserInfo(uim))
                                                        {
                                                            Res = "";
                                                            Response.Redirect("~/Views/HomePage.aspx");
                                                        }
                                                        else
                                                        {
                                                            Res = "注册失败";
                                                        }
                                                    }
                                                }
                                                else
                                                {
                                                    Res = "请输入正确电话号码";
                                                }
                                            }
                                        }
                                        else
                                        {
                                            Res = "请输入正确邮箱";
                                        }
                                    }
                                }
                            }
                            else
                            {
                                Res = "请输入确认密码";
                            }
                        }
                    }
                }
                else
                {
                    Res = "请输入正确账号";
                }
            }






        }
    }
}