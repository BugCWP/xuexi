using Cwp.BLL.gym;
using Cwp.Model;
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
    [EnableCors(origins: "*", headers: "*", methods: "*")]
    public class gymController : ApiController
    {
        [HttpGet]
        public dataList<gymroom> GetgymList(string pageIndex, string pageSize, string search)
        {
            return new gymBLL().GetgymList(pageIndex, pageSize, search);
        }
    }
}