using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.personnel
{
    //客户
    public class customer:person
    {
        public Guid personid { get; set; }
        public Guid coachlevelid { get; set; }
        //注册时间
        public string registeredtime { get; set; }
    }
}
