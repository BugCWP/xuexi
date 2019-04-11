using Cwp.BLL.gym;
using Cwp.Model;
using Cwp.Model.gym;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Cwp.GYM.Controllers
{
    public class gymController : ApiController
    {
        [HttpGet]
        public dataList<gymroom> GetgymList(string pageIndex, string pageSize, string search)
        {
            return new gymBLL().GetgymList(pageIndex, pageSize, search);
        }
    }
}