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
    public class equipmentController : EntityController<equipment, equipmentBLL>
    {
        /// <summary>
        /// 获取列表api和图片
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        [HttpGet]
        public dataList<equipmentAndImg> GetDataListAndImg(string pageIndex, string pageSize, string search = null, string paramList = null)
        {
            return new equipmentBLL().GetDataListAndImg(pageIndex, pageSize, search, paramList);
        }

       
    }
}