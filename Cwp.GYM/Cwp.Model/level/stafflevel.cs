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
        public Guid? id { get; set; }
        public string name { get; set; }
        //上级职位
        public Guid? stafflevelid { get; set; }
        public string stafflevelname { get; set; }
        //详情
        public string remark { get; set; }
        //工资
        public string wage { get; set; }
        public string level { get; set; }
    }
}
