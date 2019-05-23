using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.personnel
{
    /// <summary>
    /// 员工请假实体
    /// </summary>
    public class staffLeave
    {
        public Guid? id;
        public Guid? staffid;
        public string start_date;
        public string end_date;
        public string status;
        public string remark;
    }
}
