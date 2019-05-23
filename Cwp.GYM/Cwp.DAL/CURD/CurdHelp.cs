using Cwp.Common;
using Cwp.Common.ClassCommon;
using Cwp.Common.SQLCommon;
using Cwp.Model;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.DAL.CURD
{
    public class curdHelp
    {
        /// <summary>
        /// 新建数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public int CreateData<T>(T model)
        {
            string sql = SQLCondition.InsertCondition<T>(model);
            SqlParameter[] sqlParameterList = SQLParameterCondition.sqlParameters<T>(model);
            return sqlHelp.ExecuteNonQuery(sql, sqlParameterList);
        }

        /// <summary>
        /// 修改数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <param name="changemodel"></param>
        /// <returns></returns>
        public int UpdateData<T>(T model, T changemodel)
        {
            string sql = SQLCondition.UpdateCondition<T>(model, changemodel);
            SqlParameter[] sqlParameterList = SQLParameterCondition.sqlParameters<T>(model, changemodel);
            return sqlHelp.ExecuteNonQuery(sql, sqlParameterList);
        }

        /// <summary>
        /// 修改数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <param name="changemodel"></param>
        /// <returns></returns>
        public int UpdateData<T>(T model)
            where T : new()
        {
            T t = new T();
            PropertyInfo[] propertys = model.GetType().GetProperties();
            foreach (PropertyInfo property in propertys)
            {
                string tempName = property.Name;
                if (tempName == "id")
                {
                    property.SetValue(t,property.GetValue(model), null);
                    property.SetValue(model,null,null);
                }
            }
            string sql = SQLCondition.UpdateCondition<T>(t, model);
            SqlParameter[] sqlParameterList = SQLParameterCondition.sqlParameters<T>(t, model);
            return sqlHelp.ExecuteNonQuery(sql, sqlParameterList);
        }

        /// <summary>
        /// 删除数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public int DeleteData<T>(T model)
        {
            string sql = SQLCondition.DeleteCondition<T>(model);
            SqlParameter[] sqlParameters = SQLParameterCondition.sqlParameters<T>(model);
            return sqlHelp.ExecuteNonQuery(sql, sqlParameters);
        }

        /// <summary>
        /// 批量删除数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="modelList"></param>
        /// <returns></returns>
        public int DeleteDataList<T>(List<T> modelList)
        {
            int i = 0;
            foreach (T model in modelList)
            {
                i += DeleteData<T>(model);
            }
            return i;
        }

        /// <summary>
        /// 查找单个数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public T SelectData<T>(string id)
            where T : new()
        {
            string sql = SQLCondition.SelectCondition<T>();
            SqlParameter[] sqlParameterList = SQLParameterCondition.sqlParameters(id);
            List<T> tList = ChangeToClass.DataTableToClass<T>(new T(), sqlHelp.getDatable(sql, sqlParameterList));
            return tList[0];
        }

        /// <summary>
        /// 查找单个数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public T SelectData<T>(T model)
            where T : new()
        {
            if (SelectDataList<T>(model).Count != 0)
            {
                return SelectDataList<T>(model)[0];
            }
            else
            {
                return default(T);
            }
        }


        /// <summary>
        /// 查找数据集
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public List<T> SelectDataList<T>(T model)
            where T : new()
        {
            string sql = SQLCondition.SelectCondition<T>(model);
            SqlParameter[] sqlParameterList = SQLParameterCondition.sqlParameters<T>(model);
            List<T> tList = ChangeToClass.DataTableToClass<T>(model, sqlHelp.getDatable(sql, sqlParameterList));
            return tList;
        }

        /// <summary>
        /// 分页查询数据集
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <param name="pageIndex"></param>
        /// <param name="pageSize"></param>
        /// <param name="search"></param>
        /// <returns></returns>
        public IList<T> SelectPagingDataList<T>(T model, string pageIndex, string pageSize, string search)
             where T : new()
        {
            string sql = SQLCondition.SelectPagingCondition<T>(model, int.Parse(pageIndex), int.Parse(pageSize), search);
            SqlParameter[] sqlParameterList = SQLParameterCondition.sqlParameters<T>(model);
            IList<T> tList = ChangeToClass.DataTableToClass<T>(model, sqlHelp.getDatable(sql, sqlParameterList));
            return tList;
        }

        /// <summary>
        /// 查询数量
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public string SelectCount<T>(T model, string search)
        {
            string sql = SQLCondition.SelectCount<T>(model, search);
            string count = sqlHelp.ExecuteScalar(sql).ToString();
            return count;
        }

        /// <summary>
        /// 列表页查询
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <param name="pageIndex"></param>
        /// <param name="pageSize"></param>
        /// <param name="search"></param>
        /// <returns></returns>
        public dataList<T> SelectDataList<T>(T model, string pageIndex, string pageSize, string search)
            where T : new()
        {
            dataList<T> dataList = new dataList<T>();
            IList<T> ts = SelectPagingDataList<T>(model, pageIndex, pageSize, search);
            string count = SelectCount<T>(model, search);
            int intCout = int.Parse(count);
            int intPageSize = int.Parse(pageSize);
            int intPageCount = intCout % intPageSize == 0 ? intCout / intPageSize : intCout / intPageSize + 1;
            string pageCount = intPageCount.ToString();
            dataList.list = ts;
            dataList.Count = count;
            dataList.pageCount = pageCount;
            return dataList;
        }

    }
}
