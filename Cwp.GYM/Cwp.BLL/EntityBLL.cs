using Cwp.DAL.CURD;
using Cwp.Model;
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
    }
}
