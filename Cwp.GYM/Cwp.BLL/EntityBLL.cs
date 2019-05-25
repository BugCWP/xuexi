using Cwp.Common.ClassCommon;
using Cwp.DAL.CURD;
using Cwp.Model;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using System.Web.Script.Serialization;

namespace Cwp.BLL
{
    public class EntityBLL<T>
    {

        /// <summary>
        /// 获取列表页信息
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        public virtual dataList<T> GetDataList<T>(string pageIndex, string pageSize, string search,string paramList)
            where T:new()
        {
            T t = new T();
            if (paramList != null)
            {
                JavaScriptSerializer serializer = new JavaScriptSerializer();
                Dictionary<string, object> jsonDy =(Dictionary<string,object>)serializer.DeserializeObject(paramList);
                PropertyInfo[] propertys = t.GetType().GetProperties();
                foreach (var item in propertys)
                {
                    foreach (var dy in jsonDy)
                    {
                        if (item.Name == dy.Key)
                        {
                            Type type = item.PropertyType;
                            item.SetValue(t,new Guid(dy.Value.ToString()), null);
                        }
                    }
                }
            }
            dataList<T> dataList = new curdHelp().SelectDataList<T>(t, pageIndex, pageSize, search);
            return dataList;
        }

        /// <summary>
        /// 获取列表页信息
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        public virtual List<T> GetDataList<T>(string paramList)
            where T : new()
        {
            T t = new T();
            if (paramList != null)
            {
                JavaScriptSerializer serializer = new JavaScriptSerializer();
                Dictionary<string, object> jsonDy = (Dictionary<string, object>)serializer.DeserializeObject(paramList);
                PropertyInfo[] propertys = t.GetType().GetProperties();
                foreach (var item in propertys)
                {
                    foreach (var dy in jsonDy)
                    {
                        if (item.Name == dy.Key)
                        {
                            Type type = item.PropertyType;
                            item.SetValue(t, new Guid(dy.Value.ToString()), null);
                        }
                    }
                }
            }
            List<T> dataList = new curdHelp().SelectDataList<T>(t);
            return dataList;
        }
        /// <summary>
        /// 获取所有列表信息
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        public virtual List<T> GetDataAllList<T>()
            where T:new()
        {
            T t = new T();
            List<T> dataList = new curdHelp().SelectDataList<T>(t);
            return dataList;
        }
        /// <summary>
        /// 新建数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public virtual string CreateData<T>(T model)
        {
           int resut= new curdHelp().CreateData<T>(model);
            return resut.ToString();
        }

        /// <summary>
        /// 删除数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        public virtual string DeleteData<T>(JObject jObject)
            where T:new()
        {
            List<T> modelList = ChangeToClass.JObjectToClass<T>(jObject);
            int resut = new curdHelp().DeleteDataList<T>(modelList);
            return resut.ToString();
        }

        public virtual string DeleteData<T>(T model)
           where T : new()
        {
            int resut = new curdHelp().DeleteData<T>(model);
            return resut.ToString();
        }

        /// <summary>
        /// 查询单条数据
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public virtual T GetData<T>(string id)
            where T:new()
        {
            T t = new T();
            return new curdHelp().SelectData<T>(id);
        }
        public virtual T GetData<T>(T fromData)
            where T:new()
        {
            return new curdHelp().SelectData<T>(fromData);
        }

        /// <summary>
        /// 修改单数据
        /// </summary>
        /// <param name="fromData"></param>
        /// <returns></returns>
        public virtual string UpdateData<T>(T fromData)
            where T:new()
        {
            return new curdHelp().UpdateData<T>(fromData).ToString();
        }
    }
}
