using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.gym
{
    public class customer_course
    {
        public Guid? id { get; set; }
        public Guid? courseid { get; set; }
        public string coursename { get; set; }
        public Guid? customerid { get; set; }
        public string customername { get; set; }
    }
}
