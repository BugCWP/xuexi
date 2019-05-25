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
        public Guid? id { get; set; }
        public Guid? gymid { get; set; }
        public Guid? gymidname { get; set; }
        public Guid? staffid { get; set; }
        public string staffidname { get; set; }
        public string start_date { get; set; }
        public string end_date { get; set; }
        public string status { get; set; }
        public string remark { get; set; }
    }
}
