using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.adress
{
    public class area
    {
        public Guid? id { get; set; }
        public string name { get; set; }
        public Guid? cityid { get; set; }
        public string cityname { get; set; }
    }
}
