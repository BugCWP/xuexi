using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.level
{
    //会员等级
    public class customerlevel
    {
        public Guid? id { get; set; }
        public string name { get; set; }
        public string remark { get; set; }
        public string price { get; set; }
        public string leveltime { get; set; }
        public string levelname { get; set; }
    }
}
