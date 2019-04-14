using Cwp.Common.ClassCommon;
using Cwp.DAL.CURD;
using Cwp.Model;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.BLL
{
    public class EntityBLL<T>
    {
        /// <summary>
        /// 获取列表页信息
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        public dataList<T> GetDataList<T>(string pageIndex, string pageSize, string search)
            where T:new()
        {
            dataList<T> dataList = new curdHelp().SelectDataList<T>(new T(), pageIndex, pageSize, search);
            return dataList;
        }

        /// <summary>
        /// 新建数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public string CreateData<T>(T model)
        {
           int resut= new curdHelp().CreateData<T>(model);
            return resut.ToString();
        }

        /// <summary>
        /// 删除数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        public string DeleteData<T>(JObject jObject)
            where T:new()
        {
            List<T> modelList = ChangeToClass.JObjectToClass<T>(jObject);
            int resut = new curdHelp().DeleteDataList<T>(modelList);
            return resut.ToString();
        }

        /// <summary>
        /// 查询单条数据
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public T GetData<T>(string id)
            where T:new()
        {
            T t = new T();
            return new curdHelp().SelectData<T>(id);
        }

        /// <summary>
        /// 修改单数据
        /// </summary>
        /// <param name="fromData"></param>
        /// <returns></returns>
        public string UpdateData<T>(T fromData)
            where T:new()
        {
            return new curdHelp().UpdateData<T>(fromData).ToString();
        }
    }
}
