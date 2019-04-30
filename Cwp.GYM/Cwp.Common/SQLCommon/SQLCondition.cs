using Cwp.Common.ClassCommon;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Common.SQLCommon
{
    /// <summary>
    /// sql补足
    /// </summary>
    public class SQLCondition
    {
        /// <summary>
        /// and条件补足
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public static string AndCondition<T>(T model)
        {
            Dictionary<string, object> modeProperties = ForeachClass.ForeachClassProperties<T>(model);
            StringBuilder sqlstring = new StringBuilder();
            foreach (var item in modeProperties)
            {
                if (item.Value != null&&item.Value.ToString()!="")
                {
                    string sql = " and " + item.Key + "=@" + item.Key;
                    sqlstring.Append(sql);
                }
            }
            return sqlstring.ToString();
        }

        /// <summary>
        /// insert条件补足
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public static string InsertCondition<T>(T model)
        {
            Dictionary<string, object> modeProperties = ForeachClass.ForeachClassProperties<T>(model);
            StringBuilder sqlstring = new StringBuilder();
            string insertsql = "insert into " + model.GetType().Name+"(";
            sqlstring.Append(insertsql);
            foreach (var item in modeProperties)
            {
                if (item.Value != null)
                {
                    string sql = item.Key + ",";
                    sqlstring.Append(sql);
                }
            }
            sqlstring=sqlstring.Remove(sqlstring.Length-1,1);
            sqlstring.Append(") values (");
            foreach (var item in modeProperties)
            {
                if (item.Value != null)
                {
                    string sql = "@" + item.Key + ",";
                    sqlstring.Append(sql);
                }
            }
            sqlstring = sqlstring.Remove(sqlstring.Length - 1,1);
            sqlstring.Append(")");
            return sqlstring.ToString();
        }

        /// <summary>
        /// select补足语句 
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public static string SelectCondition<T>(T model)
        {
            StringBuilder sqlstring = new StringBuilder();
            string selectsql = "select * from " + model.GetType().Name+" where 0=0";
            sqlstring.Append(selectsql);
            sqlstring.Append(AndCondition<T>(model));
            return sqlstring.ToString();
        }

        /// <summary>
        /// select补足语句 
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public static string SelectCondition<T>()
            where T:new()
        {
            StringBuilder sqlstring = new StringBuilder();
            T t = new T();
            string selectsql = "select * from " + t.GetType().Name + " where 0=0 and id=@id";
            sqlstring.Append(selectsql);
            return sqlstring.ToString();
        }

        /// <summary>
        /// delete补足语句
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public static string DeleteCondition<T>(T model)
        {
            StringBuilder sqlstring = new StringBuilder();
            string deletesql = "delete from " + model.GetType().Name + " where 0=0 ";
            sqlstring.Append(deletesql);
            sqlstring.Append(AndCondition<T>(model));
            return sqlstring.ToString();
        }

        /// <summary>
        /// update补充语句
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="changemodel">要改变的model</param>
        /// <param name="model">新model值</param>
        /// <returns></returns>
        public static string UpdateCondition<T>(T changemodel,T model)
        {
            StringBuilder sqlstring = new StringBuilder();
            string updatesql = "update " + model.GetType().Name + " set ";
            sqlstring.Append(updatesql);
            Dictionary<string, object> modeProperties = ForeachClass.ForeachClassProperties<T>(model);
            foreach (var item in modeProperties)
            {
                if (item.Value!=null)
                {
                    string sql = item.Key + "=@" + item.Key+",";
                    sqlstring.Append(sql);
                }  
            }
            sqlstring = sqlstring.Remove(sqlstring.Length - 1, 1);
            sqlstring.Append(" where 0=0");
            sqlstring.Append(AndCondition<T>(changemodel));
            return sqlstring.ToString();
        }



        /// <summary>
        /// Select分页查找补足语句
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <param name="pageIndex"></param>
        /// <param name="pageSize"></param>
        /// <returns></returns>
        public static string SelectPagingCondition<T>(T model,int pageIndex,int pageSize,string search)
        {
            StringBuilder sqlstring = new StringBuilder();
            string selectSql = SelectCondition<T>(model);
            sqlstring.Append(selectSql);
            if (search!=null&&search!="")
            {
                string likeSql =" and name like '%"+search+"%' ";
                sqlstring.Append(likeSql);
            }
            string orderSql = " order by id offset "+(pageIndex-1)*pageSize+" rows fetch next "+pageSize+" rows only";
            sqlstring.Append(orderSql);
            return sqlstring.ToString();
        } 

        /// <summary>
        /// 数量查询sql补足
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="model"></param>
        /// <returns></returns>
        public static string SelectCount<T>(T model,string search)
        {
            StringBuilder sqlstring = new StringBuilder();
            string countSql = "select count(*) from " + model.GetType().Name+" where 0=0 ";
            sqlstring.Append(countSql);
            if (search != null && search != "")
            {
                string likeSql = " and name like '%" + search + "%' ";
                sqlstring.Append(likeSql);
            }
            return sqlstring.ToString();
        }


    }
}
