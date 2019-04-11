using Cwp.BLL;
using Cwp.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Cwp.GYM.Controllers
{
    public class EntityController<T,S> : ApiController
        where T:new()
        where S:EntityBLL<T>,new()
    {
        /// <summary>
        /// 获取列表控制器
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        [HttpGet]
        public dataList<T> GetDataList(string pageIndex, string pageSize, string search)
        {
            return new S().GetDataList<T>(pageIndex, pageSize, search);
        }
    }
}