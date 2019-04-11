﻿using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Common.ClassCommon
{
    public class ChangeToClass
    {
        /// <summary>
        /// DataTable变为model类型
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="dataTable"></param>
        /// <returns></returns>
        public static List<T> DataTableToClass<T>(T model,DataTable dataTable) 
        where T:new()
        {
            List<T> tList = new List<T>();
            foreach(DataRow dr in dataTable.Rows)
            {
                T t = new T();
                PropertyInfo[] propertys = model.GetType().GetProperties();
                foreach (PropertyInfo property in propertys)
                {
                    string tempName = property.Name;
                    if (!dataTable.Columns.Contains(tempName))
                    {
                        continue;
                    }
                    Object value = dr[tempName];
                    if (value != DBNull.Value)
                    {
                        property.SetValue(t,value,null);
                    }
                }
                tList.Add(t);
            }
            return tList;
        }
    }
}
