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
    public class gymController : EntityController<gymroom,gymBLL>
    {
        /// <summary>
        /// 获取列表api和图片
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        [HttpGet]
        public dataList<gymAndImg> GetDataListAndImg(string search = null, string paramList = null)
        {
            return new gymBLL().GetDataListAndImg(search, paramList);
        }
    }
}