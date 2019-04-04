using Cwp.Common;
using Cwp.Common.ClassCommon;
using Cwp.Common.SQLCommon;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
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
            return sqlHelp.ExecuteNonQuery(sql,sqlParameterList);
        }

        /// <summary>
        /// 修改数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <param name="changemodel"></param>
        /// <returns></returns>
        public int UpdateData<T>(T model,T changemodel)
        {
            string sql = SQLCondition.UpdateCondition<T>(model,changemodel);
            SqlParameter[] sqlParameterList = SQLParameterCondition.sqlParameters<T>(model, changemodel);
            return sqlHelp.ExecuteNonQuery(sql,sqlParameterList);
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
            return sqlHelp.ExecuteNonQuery(sql,sqlParameters);
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
                i+=DeleteData<T>(model);
            }
            return i;
        }

        /// <summary>
        /// 查找单个数据
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public T SelectData<T>(T model)
            where T:new()
        {
            return SelectDataList<T>(model)[0];
        }


        /// <summary>
        /// 查找数据集
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public List<T> SelectDataList<T>(T model)
            where T:new()
        {
            string sql = SQLCondition.SelectCondition<T>(model);
            SqlParameter[] sqlParameterList = SQLParameterCondition.sqlParameters<T>(model);
            List<T> tList = ChangeToClass.DataTableToClass<T>(sqlHelp.getDatable(sql, sqlParameterList));
            return tList;
        }
    }
}
