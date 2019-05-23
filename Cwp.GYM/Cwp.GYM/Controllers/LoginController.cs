using Cwp.BLL.person;
using Cwp.Model.personnel;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Cors;

namespace Cwp.GYM.Controllers
{
    [EnableCors(origins:"*",headers:"*",methods:"*")]
    public class LoginController : ApiController
    {
        //登录验证
        [HttpPost]
        public string  personLogin([FromBody]loginModel obj)
        {
            return new personBLL().personLogin(obj.account, obj.password);
        }
    }
}