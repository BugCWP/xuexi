using Cwp.Common.SQLCommon;
using Cwp.DAL.CURD;
using Cwp.Model;
using Cwp.Model.gym;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.BLL.gym
{
    public class gymBLL
    {
        /// <summary>
        /// 查询健身房列表页
        /// </summary>
        /// <param name="pageIndex"></param>
        /// <param name="pageSize"></param>
        /// <param name="search"></param>
        /// <returns></returns>
        public dataList<gymroom> GetgymList(string pageIndex,string pageSize,string search)
        {
            dataList<gymroom> g = new curdHelp().SelectDataList<gymroom>(new gymroom(),pageIndex,pageSize,search);
            return g;
        }
    }
}
