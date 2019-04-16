using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.personnel
{
    //教练model
    public class coach:person
    {
        public Guid? coachlevelid { get; set; }
        public string coachlevelname { get; set; }
        //注册时间
        public string entrytime { get; set; }
    }
}
