using Cwp.Model.gym;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Cors;

namespace Cwp.GYM.Controllers
{
    public class registerController : ApiController
    {
        /// <summary>
        /// 新建数据api
        /// </summary>
        /// <param name="model"></param>
        /// <returns></returns>
        [EnableCors(origins: "*", headers: "*", methods: "*")]
        [HttpPost]
        public string CreateData([FromBody]gymRegister formData)
        {
            return null;
        }
    }
}