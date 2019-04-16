using Cwp.Common.ClassCommon;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Common.SQLCommon
{
    /// <summary>
    /// paramder参数补足
    /// </summary>
    public class SQLParameterCondition
    {
        /// <summary>
        /// paramder参数补足
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public static SqlParameter[] sqlParameters<T>(T model)
        {
            Dictionary<string, object> modeProperties = ForeachClass.ForeachClassProperties<T>(model);
            int count = 0;
            foreach (var item in modeProperties)
            {
                if (item.Value != null)
                {
                    count++;
                }
            }
            SqlParameter[] sqlparameterlist = new SqlParameter[count];
            int _i = 0;
            foreach (var item in modeProperties)
            {
                if (item.Value != null)
                {
                    sqlparameterlist[_i] = (new SqlParameter("@" + item.Key, item.Value));
                    _i++;
                }
            }
            return sqlparameterlist;
        }

        /// <summary>
        /// paramder参数补足
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <param name="changemodel"></param>
        /// <returns></returns>
        public static SqlParameter[] sqlParameters<T>(T model, T changemodel)
        {
            Dictionary<string, object> modeProperties = ForeachClass.ForeachClassProperties<T>(model);
            Dictionary<string, object> changemodeProperties = ForeachClass.ForeachClassProperties<T>(changemodel);
            int count = 0;
            foreach (var item in modeProperties)
            {
                if (item.Value != null)
                {
                    count++;
                }
            }
            foreach (var item in changemodeProperties)
            {
                if (item.Value != null)
                {
                    count++;
                }
            }
            SqlParameter[] sqlparameterlist = new SqlParameter[count];
            int _i = 0;
            foreach (var item in modeProperties)
            {
                if (item.Value != null)
                {
                    sqlparameterlist[_i] = (new SqlParameter("@" + item.Key, item.Value));
                    _i++;
                }
            }
            foreach (var item in changemodeProperties)
            {
                if (item.Value != null)
                {
                    sqlparameterlist[_i] = (new SqlParameter("@" + item.Key, item.Value));
                    _i++;
                }
            }
            return sqlparameterlist;
        }

        public static SqlParameter[] sqlParameters(string id)
        {
            SqlParameter[] sqlParameters = { new SqlParameter("@id", id) };
            return sqlParameters;
        }
    }
}
