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
        public Guid personid { get; set; }
        public Guid coachlevelid { get; set; }
        public string entrytime { get; set; }
    }
}
