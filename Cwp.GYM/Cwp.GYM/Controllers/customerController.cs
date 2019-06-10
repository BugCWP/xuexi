using Cwp.BLL.person;
using Cwp.Model.personnel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Cwp.GYM.Controllers
{
    public class customerController : EntityController<customer,customerBLL>
    {
        /// <summary>
        /// 用户注册接口
        /// </summary>
        /// <param name="customer"></param>
        /// <returns></returns>
        [HttpPost]
        public string customerRegister([FromBody]customer customer)
        {
            return new customerBLL().customerRegister(customer);
        }
    }
}