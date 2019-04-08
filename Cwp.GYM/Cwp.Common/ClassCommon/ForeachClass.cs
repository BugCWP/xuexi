using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Common.ClassCommon
{
    public class ForeachClass
    {
        /// <summary>
        /// C#反射遍历对象属性
        /// </summary>
        /// <typeparam name="T">对象类型</typeparam>
        /// <param name="model">对象</param>
        public static Dictionary<string,object> ForeachClassProperties<T>(T model)
        {
            Type t = model.GetType();
            PropertyInfo[] PropertyList = t.GetProperties();
            Dictionary<string, object> modelProperties = new Dictionary<string, object>();
            foreach (PropertyInfo item in PropertyList)
            {
                modelProperties.Add(item.Name,item.GetValue(model,null));
            }
            return modelProperties;
        }
    }
}
