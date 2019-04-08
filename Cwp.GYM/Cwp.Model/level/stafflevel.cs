using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.level
{
    //员工职位表
    public class stafflevel
    {
        public Guid id { get; set; }
        public string name { get; set; }
        //上级职位
        public Guid stafflevlid { get; set; }
        //详情
        public string remark { get; set; }
        //工资
        public decimal wage { get; set; }
        public int level { get; set; }
        public bool status { get; set; }
    }
}
