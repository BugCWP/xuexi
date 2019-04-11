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
        public dataList<gymroom> GetgymList(string pageIndex,string pageSize,string search)
        {
            List<gymroom> g = new curdHelp().SelectPagingDataList<gymroom>(new gymroom(),pageIndex,pageSize,search);
            string count = new curdHelp().SelectCount<gymroom>(new gymroom());
            int intCout = int.Parse(count);
            int intPageSize = int.Parse(pageSize);
            int intPageCount = intCout % intPageSize == 0 ? intCout / intPageSize : intCout / intPageSize + 1;
            string pageCount = intPageCount.ToString();
            dataList<gymroom> dataListResult = new dataList<gymroom>();
            dataListResult.Count = count;
            dataListResult.gyms = g;
            dataListResult.pageCount = pageCount;
            return dataListResult;
        }
    }
}
