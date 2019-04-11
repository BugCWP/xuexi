using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Model.adress
{
    public class street
    {
        public Guid? id { get; set; }
        public string name { get; set; }
        public Guid? areaid { get; set; }
        public string areaname { get; set; }
    }
}
