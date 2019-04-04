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
            SqlParameter[] sqlparameterlist = new SqlParameter[modeProperties.Count];
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
            SqlParameter[] sqlparameterlist = new SqlParameter[modeProperties.Count];
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
    }
}
