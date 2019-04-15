using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.level
{
    //教练等级
   public class coachlevel
    {
        public Guid id { get; set; }
        public string name { get; set; }
        public int level { get; set; }
        public string remark { get; set; }
    }
}
