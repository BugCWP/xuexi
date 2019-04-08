using Cwp.BLL.person;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Cwp.GYM.Controllers
{
    public class LoginController : ApiController
    {
        //登录验证
        [HttpPost]
        public string  personLogin([FromBody]string account,[FromBody]string password)
        {
            return new personBLL().personLogin(account,password);
        }
    }
}