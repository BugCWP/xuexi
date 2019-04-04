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
        public Guid id;
        public string name;
        //上级职位
        public Guid stafflevlid;
        //详情
        public string remark;
        public int level;
        public bool status;
    }
}
