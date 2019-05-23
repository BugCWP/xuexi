using Cwp.BLL.person;
using Cwp.Model;
using Cwp.Model.personnel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Cwp.GYM.Controllers
{
    public class staffController : EntityController<staff,staffBLL>
    {
        /// <summary>
        /// 获取列表api和图片
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        [HttpGet]
        public dataList<staffAndImg> GetDataListAndImg(string pageIndex, string pageSize, string search = null, string paramList = null)
        {
            return new staffBLL().GetDataListAndImg(pageIndex, pageSize, search, paramList);
        }
    }
}