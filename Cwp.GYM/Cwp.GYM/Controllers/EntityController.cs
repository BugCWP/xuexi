﻿using Cwp.BLL;
using Cwp.Model;
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
    public class EntityController<T, S> : ApiController
        where T : new()
        where S : EntityBLL<T>, new()
    {
        /// <summary>
        /// 获取列表api
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        [HttpGet]
        public dataList<T> GetDataList(string pageIndex, string pageSize, string search = null, string paramList = null)
        {
            return new S().GetDataList<T>(pageIndex, pageSize, search, paramList);
        }

        /// <summary>
        /// 获取列表api
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        [HttpGet]
        public List<T> GetDataList(string search = null, string paramList = null)
        {
            return new S().GetDataList<T>(paramList);
        }

        /// <summary>
        /// 获取所有列表值
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public List<T> GetDataAllList()
        {
            return new S().GetDataAllList<T>();
        }

        /// <summary>
        /// 新建数据api
        /// </summary>
        /// <param name="model"></param>
        /// <returns></returns>
        [EnableCors(origins: "*", headers: "*", methods: "*")]
        [HttpPost]
        public string CreateData([FromBody]T formData)
        {
            return new S().CreateData<T>(formData);
        }

        /// <summary>
        /// 删除数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns><o/returns>
        [EnableCors(origins: "*", headers: "*", methods: "*")]
        [HttpPost]
        public string DeleteData([FromBody]JObject multipleSelection)
        {
            return new S().DeleteData<T>(multipleSelection);
        }

        /// <summary>
        /// 查询单条数据
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        [HttpGet]
        public T GetData(string id)
        {
            return new S().GetData<T>(id);
        }
        [HttpPost]
        public T GetData([FromBody]T fromData)
        {
            return new S().GetData<T>(fromData);
        }

        /// <summary>
        /// 修改单数据
        /// </summary>
        /// <param name="fromData"></param>
        /// <returns></returns>
        [HttpPost]
        public string UpdateData([FromBody]T fromData)
        {
            return new S().UpdateData<T>(fromData);
        }
    }
}